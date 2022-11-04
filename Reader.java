//Создаем класс Reader, хранящий информацию о пользователе библиотеки
public class Reader {
    String fio;
    int numTicket;
    String faculty;
    String dateBirth;
    String phoneNumber;

    Reader(String fio, int numTicket, String faculty, String dateBirth, String phoneNumber){
        this.fio = fio;
        this.numTicket = numTicket;
        this.faculty = faculty;
        this.dateBirth = dateBirth;
        this.phoneNumber = phoneNumber;
    }

    //Метод takeBook, принимающий количество взятых книг
    public void takeBook(int number) {
        System.out.println(this.fio + " взял " + number + " книги.");
        System.out.println();
    }
    //Метод takeBook, принимающий количество названий взятых книг
    public void takeBook(Book... books) {
        System.out.println(this.fio + " взял книги:");
        for (Book book : books) {
            System.out.println(book.getNameBook() + " " + book.getAuthor());
        }
        System.out.println();
    }

    //Метод returnBook, принимающий количество возвращенных книг
    public void returnBook(int number) {
        System.out.println(this.fio + " вернул " + number + " книги.");
        System.out.println();
    }
    //Метод returnBook, принимающий количество названий возвращенных книг
    public void returnBook(Book... books) {
        System.out.println(this.fio + " вернул книги:");
        for (Book book : books) {
            System.out.println(book.getNameBook() + " " + book.getAuthor());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Reader reader1 = new Reader("Петров В.В.", 10272, "Прикладная Информатика", "02.12.2003", "8999123456");

        Book book1 = new Book("Приключения", "Автор");
        Book book2 = new Book("Словарь", "Автор");
        Book book3 = new Book("Энциклопедия", "Автор");

        reader1.takeBook(3);
        reader1.takeBook(book1, book2, book3);

        reader1.returnBook(3);
        reader1.returnBook(book1, book2, book3);
    }
}

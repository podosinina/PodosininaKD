//Создаем класс Book, содержащий имя и автора книги
public class Book {
    String nameBook;
    String Author;

    Book(String nameBook, String Author){
        this.nameBook = nameBook;
        this.Author = Author;
    }

    //Даем доступ классу Reader к nameBook и Author
    public String getNameBook(){
        return nameBook;
    }

    public String getAuthor(){
        return Author;
    }
}


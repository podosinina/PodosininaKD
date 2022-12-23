import java.util.Objects;
import java.util.Scanner;
import java.util.*;

public class project{

    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static Scanner in = new Scanner(System.in);

    static ArrayList<String> task = new ArrayList<>();


    public static void main(String[] args) {

        System.out.print("Если Вы хотите создать новое задание, введите " + ANSI_BLUE + "создать задание" + ANSI_RESET + "\n" +
                "Если Вы хотите удалить задание, введите " + ANSI_BLUE + "удалить задание" + ANSI_RESET + "\n" +
                "Если Вы хотите отредактировать задание, введите "+ ANSI_BLUE + "отредактировать задание" + ANSI_RESET + "\n" +
                "Если Вы хотите просмотреть список всех заданий, введите " + ANSI_BLUE + "список всех заданий" + ANSI_RESET + "\n" +
                "Если Вы хотите просмотреть список всех заданий, введите " + ANSI_BLUE + "список всех заданий по дате выполнения" + ANSI_RESET + "\n" +
                "Если Вы хотите просмотреть список всех заданий, введите " + ANSI_BLUE + "список всех заданий по дате создания" + ANSI_RESET + "\n" +
                "Если Вы хотите просмотреть список выполненных заданий, введите " + ANSI_BLUE + "список выполненных заданий" + ANSI_RESET + "\n" +
                "Если Вы хотите просмотреть список выполненных заданий на конкретную дату выполнения, введите " + ANSI_BLUE + "выполненные задания по дате выполнения" + ANSI_RESET + "\n" +
                "Если Вы хотите просмотреть список выполненных заданий на конкретную дату выполнения, введите " + ANSI_BLUE + "выполненные задания по дате создания" + ANSI_RESET + "\n" +
                "Если Вы хотите просмотреть список невыполненных заданий, введите " + ANSI_BLUE + "список невыполненных заданий" + ANSI_RESET + "\n" +
                "Если Вы хотите просмотреть список выполненных заданий на конкретную дату выполнения, введите " + ANSI_BLUE + "невыполненные задания по дате выполнения" + ANSI_RESET + "\n" +
                "Если Вы хотите просмотреть список выполненных заданий на конкретную дату выполнения, введите " + ANSI_BLUE + "невыполненные задания по дате создания" + ANSI_RESET + "\n" +
                "Если Вы хотите просмотреть детальную информацию о задании, введите " + ANSI_BLUE + "детальная информация" + ANSI_RESET + "\n" +
                "Если Вам не нужно создавать задание, введите " + ANSI_BLUE + "стоп: " + ANSI_RESET  + "\n");

        Scanner in = new Scanner(System.in);
        String create;

        while(true){
            System.out.print("Введите команду: ");

            create = in.nextLine();

            if (Objects.equals(create, "создать задание")) {
                int number = generate(1000, 10000);
                createTask(number);

            }else if(Objects.equals(create, "удалить задание")){
                delete_task();

            }else if(Objects.equals(create, "отредактировать задание")){
                update_task();

            } else if (Objects.equals(create, "список всех заданий")) {
                allTask();

            } else if (Objects.equals(create, "список всех заданий по дате выполнения")) {
                allCompletedDate();

            } else if (Objects.equals(create, "список всех заданий по дате создания")) {
                allCreateDate();

            } else if (Objects.equals(create, "список выполненных заданий")) {
                completedTask();

            } else if (Objects.equals(create, "выполненные задания по дате выполнения")) {
                completedDateCompletedTask();

            } else if (Objects.equals(create, "выполненные задания по дате создания")) {
                createDateCompletedTask();

            }else if (Objects.equals(create, "список невыполненных заданий")) {
                failedTask();

            } else if (Objects.equals(create, "невыполненные задания по дате выполнения")) {
                completedDateFailedTask();

            } else if (Objects.equals(create, "невыполненные задания по дате создания")) {
                createDateFailedTask();

            } else if (Objects.equals(create, "детальная информация")) {
                detailTask();

            } else if (Objects.equals(create, "стоп")){
                System.out.println(ANSI_GREEN + "Вы закончили создавать задания!");
                break;

            } else{
                System.out.println(ANSI_RED + "Вы ввели неправильную команду. Попробуйте еще раз." + ANSI_RESET);
            }
        }
        in.close();
    }



    //Генерируется номер задания
    public static int generate(int min, int max){
        return (int)(Math.random() * (max - min) + min);
    }

    //удаляем задание
    public static void delete_task() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название задачи, которую хотите удалить: ");
        String delTask1 = in.nextLine();
        System.out.println("Введите дату создания задачи, которую хотите удалить: ");
        String delTask2 = in.nextLine();

        Iterator<String> iterator = task.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().contains(delTask1)&&iterator.next().contains(delTask2)) {
                iterator.remove();
                System.out.println(ANSI_GREEN + "Задание удалено!" + ANSI_RESET);
            }
        }
    }

    //Неправильно работает
    public static void update_task() {
        System.out.println("Укажите название задачи, которую хотите отредактировать: ");
        String editName = in.nextLine();

        StringBuilder update_inf = new StringBuilder(); //Задание, которое нужно отредактировать

        for (String string : task) {
            if(string.contains(editName)){
                update_inf.append(string);
            }
        }

        if (update_inf.isEmpty()){
            System.out.println(ANSI_RED + "Задачи с такми наименованием нет!" + ANSI_RESET);
        }else {
            System.out.println("Укажите информацию, которую хотите отредактировать" + '\n' +
                    "(Дата создания, Дата выполнения, Наименование, Детальная информация, Статус задания): ");

            String editInf = in.nextLine(); //Пункт, который нужно отредактировать

            switch (editInf) {
                case "Дата создания" -> {
                    int startInd = update_inf.indexOf("Дата создания");
                    int endInd = update_inf.indexOf(", Дата выполнения");
                    System.out.println("Введите новое значение: ");
                    String newValue = "Дата создания: " + ANSI_YELLOW + in.nextLine() + ANSI_RESET;
                    update_inf.replace(startInd, endInd, newValue);
                    task.add(String.valueOf(update_inf));
                    System.out.println(ANSI_GREEN + "Задание отредактировано!" + ANSI_RESET);
                }
                case "Дата выполнения" -> {
                    int startInd = update_inf.indexOf("Дата выполнения");
                    int endInd = update_inf.indexOf(", Наименование");
                    System.out.println("Введите новое значение: ");
                    String newValue = "Дата выполнения: " + ANSI_YELLOW + in.nextLine() + ANSI_RESET;
                    update_inf.replace(startInd, endInd, newValue);
                    task.add(String.valueOf(update_inf));
                    System.out.println(ANSI_GREEN + "Задание отредактировано!" + ANSI_RESET);
                }
                case "Наименование" -> {
                    int startInd = update_inf.indexOf("Наименование");
                    int endInd = update_inf.indexOf(", Детальная информация");
                    System.out.println("Введите новое значение: ");
                    String newValue = "Наименование: " + ANSI_YELLOW + in.nextLine() + ANSI_RESET;
                    task.add(String.valueOf(update_inf));
                    update_inf.replace(startInd, endInd, newValue);
                    System.out.println(ANSI_GREEN + "Задание отредактировано!" + ANSI_RESET);
                }
                case "Детальная информация" -> {
                    int startInd = update_inf.indexOf("Детальная информация");
                    int endInd = update_inf.indexOf(", Статус задания");
                    System.out.println("Введите новое значение: ");
                    String newValue = "Детальная информация: " + ANSI_YELLOW + in.nextLine() + ANSI_RESET;
                    task.add(String.valueOf(update_inf));
                    update_inf.replace(startInd, endInd, newValue);
                    System.out.println(ANSI_GREEN + "Задание отредактировано!" + ANSI_RESET);
                }
                case "Статус задания" -> {
                    int startInd = update_inf.indexOf("Статус задания");
                    int endInd = update_inf.indexOf("ыполнено");
                    System.out.println("Введите новое значение: ");
                    String newValue = "Статус задания: " + ANSI_YELLOW + in.nextLine() + ANSI_RESET;
                    task.add(String.valueOf(update_inf));
                    update_inf.replace(startInd, endInd, newValue);
                    System.out.println(ANSI_GREEN + "Задание отредактировано!" + ANSI_RESET);
                }
            }
        }
    }

    //Выводим список всех заданий
    public static void allTask(){
        if (task.isEmpty()){
            System.out.println(ANSI_RED + "Заданий нет!" + ANSI_RESET);
        } else {
            for (String s : task) {
                System.out.print(s + "\n");
            }
        }
    }

    //Выводим список всех заданий по дате выполнения
    public static void allCompletedDate(){
        System.out.println("Введите дату выполнения задания(дд.мм.ггг): ");
        String dateTask = in.nextLine();
        List <String> listClone = new ArrayList<>();

        for (String string : task) {
            if(string.contains(dateTask)){
                listClone.add(string);
            }
        }
        if(listClone.isEmpty()){
            System.out.println(ANSI_RED + "Заданий с такой датой выполнения нет!" + ANSI_RESET);
        }else {
            for (String s : listClone) {
                System.out.print(s + "\n");
            }
        }
    }

    //Выводим список всех заданий по дате создания
    public static void allCreateDate(){
        System.out.println("Введите дату создания задания(дд.мм.ггг): ");
        String dateTask = in.nextLine();
        List <String> listClone = new ArrayList<>();

        for (String string : task) {
            if(string.contains(dateTask)){
                listClone.add(string);
            }
        }
        if(listClone.isEmpty()){
            System.out.println(ANSI_RED + "Заданий с такой датой создания нет!" + ANSI_RESET);
        }else {
            for (String s : listClone) {
                System.out.print(s + "\n");
            }
        }
    }

    //Выводим список всех выполненных
    public static void completedTask(){
        List <String> listClone = new ArrayList<>();
        String searchString = "Выполнено";
        for (String string : task) {
            if(string.contains(searchString)){
                listClone.add(string);
            }
        }
        if(listClone.isEmpty()){
            System.out.println(ANSI_RED + "Выполненных заданий нет!" + ANSI_RESET);
        }else {
            for (String s : listClone) {
                System.out.print(s + "\n");
            }
        }
    }

    //Выводим список выполненных заданий по дате выполнения
    public static void completedDateCompletedTask(){
        System.out.println("Введите дату выполнения задания(дд.мм.ггг): ");
        String dateTask = in.nextLine();
        List <String> listClone = new ArrayList<>();
        String searchString = "Выполнено";

        for (String string : task) {
            if(string.contains(searchString)&&string.contains(dateTask)){
                listClone.add(string);
            }
        }
        if(listClone.isEmpty()){
            System.out.println(ANSI_RED + "Выполненных заданий по такой дате выполнения нет!" + ANSI_RESET);
        }else {
            for (String s : listClone) {
                System.out.print(s + "\n");
            }
        }
    }

    //Выводим список выполненных заданий по дате создания
    public static void createDateCompletedTask(){
        System.out.println("Введите дату создания задания(дд.мм.ггг): ");
        String dateTask = in.nextLine();
        List <String> listClone = new ArrayList<>();
        String searchString = "Выполнено";

        for (String string : task) {
            if(string.contains(searchString)&&string.contains(dateTask)){
                listClone.add(string);
            }
        }
        if(listClone.isEmpty()){
            System.out.println(ANSI_RED + "Выполненных заданий по такой дате создания нет!" + ANSI_RESET);
        }else {
            for (String s : listClone) {
                System.out.print(s + "\n");
            }
        }
    }

    //Выводим список всех невыполненных заданий
    public static void failedTask(){
        List <String> listClone = new ArrayList<>();
        String searchString = "Не выполнено";
        for (String string : task) {
            if(string.contains(searchString)){
                listClone.add(string);
            }
        }
        if(listClone.isEmpty()){
            System.out.println(ANSI_RED + "Невыполненных заданий нет!" + ANSI_RESET);
        }else {
            for (String s : listClone) {
                System.out.print(s + "\n");
            }
        }
    }

    //Выводим список невыполненных заданий по дате выполнения
    public static void completedDateFailedTask(){
        System.out.println("Введите дату выполнения задания(дд.мм.ггг): ");
        String dateTask = in.nextLine();
        List <String> listClone = new ArrayList<>();
        String searchString = "Не выполнено";

        for (String string : task) {
            if(string.contains(searchString)&&string.contains(dateTask)){
                listClone.add(string);
            }
        }
        if(listClone.isEmpty()){
            System.out.println(ANSI_RED + "Невыполненных заданий по такой дате выполнения нет!" + ANSI_RESET);
        }else {
            for (String s : listClone) {
                System.out.print(s + "\n");
            }
        }
    }

    //Выводим список невыполненных заданий по дате создания
    public static void createDateFailedTask(){
        System.out.println("Введите дату создания задания(дд.мм.ггг): ");
        String dateTask = in.nextLine();
        List <String> listClone = new ArrayList<>();
        String searchString = "Не выполнено";

        for (String string : task) {
            if(string.contains(searchString)&&string.contains(dateTask)){
                listClone.add(string);
            }
        }
        if(listClone.isEmpty()){
            System.out.println(ANSI_RED + "Невыполненных заданий по такой дате создания нет!" + ANSI_RESET);
        }else {
            for (String s : listClone) {
                System.out.print(s + "\n");
            }
        }
    }

    //выводим детальную информацию о задании
    public static void detailTask(){
        System.out.println("Введите название задачи, которую хотите посмотреть детальную информацию: ");
        String detTask = in.nextLine();

        StringBuilder detail_inf = new StringBuilder();

        for (String string : task) {
            if(string.contains(detTask)){
                detail_inf.append(string);
            }
        }
        if (detail_inf.isEmpty()){
            System.out.println(ANSI_RED + "Задачи с такми наименованием нет!" + ANSI_RESET);
        }else {
            int startInd = detail_inf.indexOf("Детальная");
            int endInd = detail_inf.indexOf(", Статус");
            char[] dst = new char[endInd - startInd];
            detail_inf.getChars(startInd, endInd, dst, 0);
            System.out.print("Задание: " + detTask + ", ");
            System.out.println( dst);
        }
    }

    //Создаем задание и сохраняем его
    public static void createTask(int number){

        System.out.print("Введите дату создания(дд.мм.ггг): ");
        String create_date = in.nextLine();
        System.out.print("Введите дату выполнения(дд.мм.ггг): ");
        String completion_date = in.nextLine();
        System.out.print("Введите наименование: ");
        String name = in.nextLine();
        System.out.print("Введите детальную информацию: ");
        String detailed_description = in.nextLine();
        System.out.print("Введите статус задания(Выполнено/Не выполнено): ");
        String status = in.nextLine();

        System.out.println(ANSI_GREEN + "Задание создано!" + ANSI_RESET);

        String numberStr = String.valueOf(number);

        String text = "Номер задания: " + ANSI_YELLOW + numberStr + ANSI_RESET + ", Дата создания: " + ANSI_YELLOW + create_date +
                ANSI_RESET + ", Дата выполнения: " + ANSI_YELLOW + completion_date + ANSI_RESET + ", Наименование: " + ANSI_YELLOW + name +
                ANSI_RESET + ", Детальная информация: " + ANSI_YELLOW + detailed_description + ANSI_RESET + ", Статус задания: " + ANSI_YELLOW + status + ANSI_RESET;
        task.add(text);
    }
}
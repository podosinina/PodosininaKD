import java.util.*;

public class HW2 {
    public static void main(String[] args) {
        //Задача №3
        Scanner input = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int size = input.nextInt();
        String listA[] = new String[size];
        System.out.println("Введите элементы массива: ");

        for (int i = 0; i < size; i++) {
            listA[i] = input.nextLine();
        }

        System.out.print("ListA: ");
        for (String el : listA) {
            System.out.print(" " + el);
        }

        System.out.println();

        HashSet<String> setA = new LinkedHashSet<>(Arrays.asList(listA)); //множество для удаления дубликатов

        ArrayList<String> listB = new ArrayList<>(setA);
        System.out.print("ListA без дубликатов:");

        for (String el : listB) {
            System.out.print(" " + el);
        }
        System.out.println();

        //Задача №4
        ArrayList<Double> listArr = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            listArr.add(Math.random());
        }

        LinkedList<Double> listLin = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            listLin.add(Math.random());
        }

        long startArr = System.currentTimeMillis();
        Random random1 = new Random();
        for (int i = 0; i < 100000; i++) {
            int index = random1.nextInt(listArr.size());
        }
        long finishArr = System.currentTimeMillis();
        long ArrTime = finishArr - startArr;
        System.out.println("Время работы listArr: " + ArrTime);

        long startLin = System.currentTimeMillis();
        Random random2 = new Random();
        for (int i = 0; i < 100000; i++) {
            int index = random2.nextInt(listLin.size());
        }
        long finishLin = System.currentTimeMillis();
        long LinTime = finishLin - startLin;
        System.out.println("Время работы listLin: " + LinTime);

        if (ArrTime < LinTime){
            System.out.println("ArrayList быстрее, чем LinkedList.");
        } else {
            System.out.println("LinkedList быстрее, чем ArrayList.");
        }
    }
}

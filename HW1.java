import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {

        System.out.println("Задача №1. Hello World");

        final int n = 89;
        System.out.println("Задача №2. " + n);

        int a = 15;
        int b = ++a;
        System.out.print("Задача №3. " + a);

        int c = 15;
        int d = c++;
        System.out.println(" " + c);

        int p1 = 3;
        int p2 = 5;
        System.out.print("Задача №4. p1 = " + p2 + "; p2 = " + p1);
        int temp = p1;
        p1 = p2;
        p2 = temp;
        System.out.println("; p1 = " + p1 + "; p2 = " + p2);

        int x = 5;
        int y = 9;
        double gip = Math.sqrt((Math.pow(x,2) + Math.pow(y, 2)));
        System.out.println("Задача №5. " + gip);

        int natural1 = 1874;
        System.out.println("Задача №6. " + natural1%10);

        int natural2 = 7368;
        int ten = natural2%10;
        System.out.println("Задача №7. " + ten%10);

        int two_dig_num = 93;
        System.out.println("Задача №8. " + two_dig_num/10);

        num_diff();
        average_num();
        geometric_num();
        dist_points();

    }

    static void num_diff() {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int wh_num = in.nextInt();
        System.out.println("Задача №9. " + wh_num + "-21=" + (wh_num-21));
        in.close();
    }

    static void average_num() {

        int wh_num1 = 38;
        int wh_num2 = 94;
        System.out.println("Задача №10. " + (wh_num1+wh_num2)/2);
    }

    static void geometric_num() {

        int wh_num1 = 3;
        int wh_num2 = 12;
        System.out.println("Задача №11. " + Math.sqrt(wh_num1*wh_num2));
    }

    static void dist_points() {

        float x1 = 3;
        float y1 = 12;
        float x2 = 4;
        float y2 = 8;
        System.out.println("Задача №12. " + Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1,2)));
    }


}


public class chislaDoN {

    public static void main(String[] args){
        System.out.println(chisla(4, 1));
    }

    private static int chisla(int n, int start){
        if (n == 1)
            return 1;
        if (start<n) {
            System.out.println(start);
            chisla(n, start + 1);
        }
        return n;
    }
}

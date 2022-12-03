public class potoky extends Thread {

    @Override
    public void run() {
        System.out.println("Выполнен поток " + getName());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            potoky thread = new potoky();
            thread.start();
        }
    }
}
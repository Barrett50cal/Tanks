package chars;

public class PTank implements Runnable {

    public static int Px = 50;
    public static int Py = 50;
    private static int Power = 50;

    public static void moveLeft() {
        if (Px > 0) {
            Px = Px - 5;
        }

    }

    public static void movePDown() {
        if (Power > 0) {
            Power--;
        }

    }

    public static void movePUp() {
        if (Power < 100) {
            Power++;
        }

    }

    public static void moveRight() {
        if (Px < 800 - 50) {
            Px = Px + 5;
        }

    }

    @Override
    public void run() {
    }
}

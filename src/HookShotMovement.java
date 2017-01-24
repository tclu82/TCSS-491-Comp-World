import java.awt.*;

/**
 * Created by zac on 1/23/17.
 *
 * This class simulate our Hook Shot Hero movement when he shoot the hook shot
 */
public class HookShotMovement {

    // Fields
    private double hookShotLength;

    private Point centerPoint;

    private Point currentPoint;

    /**
     * Constructor
     *
     * @param hookShotLength
     */
    private HookShotMovement(double hookShotLength) {

        this.hookShotLength = hookShotLength;

        this.centerPoint = new Point(0, 0);

        currentPoint = new Point(hookShotLength * -1, 0);
    }
    /**
     * Get current X coordination
     *
     * @return double
     */
    public double getX() {
        return currentPoint.getX();
    }

    /**
     * Get current Y coordination
     *
     * @return double
     */
    public double getY() {
        return currentPoint.getY();
    }

    /**
     * Get current Point position
     *
     * @return Point
     */
    private Point getPoint() {
        return currentPoint;
    }

    /**
     * This method calculus how our hero move by degree
     *
     * @param moveByDegree
     */
    public void heroMove(int moveByDegree) {

        for (int degree=0; degree>=-180; degree-= moveByDegree) {

            currentPoint.x = Math.cos(Math.toRadians(degree));
            currentPoint.y = Math.sin(Math.toRadians(degree));

            String position = String.format("Degree: %d, X: %.3f, Y: %.3f",
                    degree,
                    -currentPoint.x * hookShotLength,
                    currentPoint.y * hookShotLength);

            System.out.println(position);
        }
    }

    /**
     * Main method
     *
     * @param theArgs
     */
    public static void main(String... theArgs) {
        System.out.println("============Program start==========");
        // Decide how long hero's hook shot is
        HookShotMovement hsm = new HookShotMovement(100);
        // Change the degree you want, the smaller degree number, display more positions
        hsm.heroMove(10);
    }

    /**
     * Private Point class
     */
    private class Point {
        double x;
        double y;

        private Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public Point getPoint() {
            return new Point(x, y);
        }
    }
}

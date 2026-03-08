import java.awt.*;
import java.util.Date;

public class ReferenceType {
    static void main() {
        byte age = 30;
        Date currentTime = new Date();
        System.out.println(currentTime);

        Point point1 = new Point(2, 3);
        Point point2 = point1;
        point1.x = 5;
        System.out.println(point2);
    }
}

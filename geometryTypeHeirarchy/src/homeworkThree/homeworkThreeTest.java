package homeworkThree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 */
public class homeworkThreeTest {
    @Test
    public void testLine() {
        Line l1 = new Line(0, 0, 1, 0);
        Line l2 = new Line(0, 0, -1, 0);
        l1.getSecondPoint().rotateAbout(new Point(0, 0), Math.PI);
        assertEquals(l1.getSecondPoint().getX(), l2.getSecondPoint().getX());
    }
}
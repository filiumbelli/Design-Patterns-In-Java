import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Sometimes caching is important in Adapter to prevent dublicate Objects creation
public class Demo1 {
    private final static List<VectorObject> vectorObjects =
            new ArrayList<>(Arrays.asList(
                    new VectorRectangle(1, 1, 10, 10),
                    new VectorRectangle(2, 5, 10, 5),
                    new VectorRectangle(11, 10, 20, 8)
            ));

    public static void drawPoint(Point p) {
        System.out.println(".");
    }
    private static void draw()
    {
        for(VectorObject vo : vectorObjects)
        {
            for (Line line : vo)
            {
                final LineToPointAdapter adapter = new LineToPointAdapter(line);
                adapter.forEach(Demo1::drawPoint);
            }
        }
    }

    public static void main(String[] args) {
        draw();
    }
}

class LineToPointAdapter extends ArrayList<Point>
{
    public LineToPointAdapter(Line line)
    {
        // draws line from points
    }
}
class VectorObject extends ArrayList<Line> {
}

class VectorRectangle extends VectorObject {
    public VectorRectangle(int x, int y, int width, int height) {
        add(new Line(new Point(x, y), new Point(x + width, y)));
        add(new Line(new Point(x, y + height), new Point(x, y)));
        add(new Line(new Point(x + width, y), new Point(x + width, y + height)));
        add(new Line(new Point(x + width, y + height), new Point(x, y + height)));
    }
}

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

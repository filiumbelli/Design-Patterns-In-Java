import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        GraphicObject drawing = new GraphicObject();
        drawing.setName("My Drawings");
        drawing.children.add(new Square("Red"));
        drawing.children.add(new Circle("Bluee"));
        GraphicObject group = new GraphicObject();
        group.children.add(new Circle("Black"));
        group.children.add(new Square("Reddis"));
        System.out.println(drawing);
        System.out.println(group);
    }
}


class GraphicObject {
    protected String name = "Group";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GraphicObject() {

    }

    public String color;
    public List<GraphicObject> children = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        print(sb,0);
        return sb.toString();
    }

    private void print(StringBuilder sb, int i) {
        // print children and object itself
    }

}

class Circle extends  GraphicObject
{
    public Circle(String color) {
        name = "Circle";
        this.color = color;
    }

}

class Square extends  GraphicObject
{
    public Square(String color) {
        name = "Square";
        this.color = color;
    }

}

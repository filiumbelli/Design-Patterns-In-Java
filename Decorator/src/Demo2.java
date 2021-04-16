import java.util.function.Supplier;

public class Demo2 {
    public static void main(String[] args) {
        ColoredShape<Circle> redCircle = new ColoredShape<Circle>("Red", ()->new Circle(10));
        System.out.println(redCircle.info());
        TransparentShape<Square> transparentShape = new TransparentShape<Square>(50, ()->new Square(15));
        System.out.println(transparentShape.info());
    }
}
interface Shape
{
    String info();
}

class Circle implements  Shape{

    private float radius;
    public Circle(){

    }
    void resize(float factor){
        radius *= factor;
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public String info() {
        return "Circle of radius " + radius;
    }
}

class Square implements  Shape{
    private float side;

    public Square() {
    }

    public Square(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "Side of the square " + side;
    }
}
class ColoredShape<T extends  Shape> implements  Shape
{
    private String color;
    private Shape shape;


    public ColoredShape(String color, Supplier<? extends T> ctor) {
        this.color = color;
        this.shape = ctor.get();
    }

    @Override
    public String info() {
        return color + " colored " + shape.info() + " drawed";
    }
}

class TransparentShape<T extends Shape> implements  Shape
{
    private int transparency;
    private Shape shape;

    @Override
    public String info() {
        return "Transperency: " + transparency + " shape: " + shape.info();
    }

    public TransparentShape(int transparency, Supplier<? extends T> ctor) {
        this.transparency = transparency;
        this.shape = ctor.get();
    }

}

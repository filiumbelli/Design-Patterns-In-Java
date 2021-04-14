import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Demo1 {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ShapeModule());
        Circle instance = injector.getInstance(Circle.class);
        instance.radius = 3;
        instance.draw();
        instance.resize(5);
        instance.draw();
    }
}

class ShapeModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(Renderer.class).to(VectorRenderer.class);
    }
}
interface Renderer {
    void renderCircle(float radius);
}

class VectorRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Circle of radius " + radius);
    }
}

class RasterRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing pixels for a circle of radius " + radius);
    }
}

abstract class Shape {
    protected  Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }
    public abstract void resize(float factor);
    public abstract void draw();
}

class Circle extends Shape{
    public float radius;

    @Inject
    public Circle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void resize(float factor) {
        radius *=factor;

    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }
}

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        Console.newConsole(20,30).render();
    }
}
class Buffer{
    private char[] characters;
    private int lineWidth;
    public Buffer(int lineHeight,int lineWidth){
        this.lineWidth = lineWidth;
        characters = new char[lineHeight* lineWidth];

    }
    public char charAt(int x,int y)
    {
        return characters[y*lineWidth+x];
    }
}

class Viewport{
    public Viewport() {
    }
    Buffer buffer;
    int width,height,offsetX,offsetY;

    public Viewport(Buffer buffer, int width, int height, int offsetX, int offsetY) {
        this.buffer = buffer;
        this.width = width;
        this.height = height;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }
    public char charAt(int x,int y)
    {
        return buffer.charAt(x+offsetX,y+offsetY);
    }
}
class Console{
    public static Console newConsole(int width,int height){
        Buffer buffer = new Buffer(30, 30);
        Viewport viewport = new Viewport(buffer, 30, 20, 0, 0);
        Console console = new Console(30, 20);
        console.addViewport(viewport);
        return console;
    }
    private List<Viewport> viewports = new ArrayList<>();
    int width,height;

    public Console(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public void addViewport(Viewport viewport)
    {
        viewports.add(viewport);
    }
    public void render(){
        for(int y= 0;y<height;++y){
            for(int x=0;x<width;++x){
                for(Viewport vp : viewports){
                    System.out.println(vp.charAt(x,y));
                }
                System.out.println();
            }
        }
    }
}

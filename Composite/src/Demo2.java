import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Demo2 {
    public static void main(String[] args) {
        Neuron n1 = new Neuron();
        Neuron n2 = new Neuron();
        Layer l1 = new Layer();
        Layer l2 = new Layer();



    }
}

interface SomeNeurons extends Iterable<Neuron>
{

}

class Neuron implements SomeNeurons{
    public ArrayList<Neuron> in,out;

    @Override
    public Iterator<Neuron> iterator() {
        return Collections.singleton(this).iterator();
    }

    @Override
    public void forEach(Consumer<? super Neuron> action) {
    }

    @Override
    public Spliterator<Neuron> spliterator() {
        return Collections.singleton(this).spliterator();
    }
}
class Layer extends  ArrayList<Neuron> implements SomeNeurons
{

}

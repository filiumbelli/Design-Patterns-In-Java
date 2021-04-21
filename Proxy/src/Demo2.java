import java.util.Objects;

class Property<T>{
    private T value;

    public Property(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        // logging
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property<?> property = (Property<?>) o;
        return Objects.equals(value, property.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

class Creature{
    private Property<Integer> agility = new Property<>(10);

    public int getAgility() {
        return this.agility.getValue();
    }

    public void setAgility(int agility) {
        this.agility.setValue(agility);
    }
}
public class Demo2 {
    public static void main(String[] args) {
        Creature creature = new Creature();
        creature.setAgility(12);
    }
}

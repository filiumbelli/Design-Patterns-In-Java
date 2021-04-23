public class Demo1 {
    public static void main(String[] args) {
        Creature goblin = new Creature("Goblin", 2, 2);
        CreatureModifier root = new CreatureModifier(goblin);
        System.out.println("Double the goblin attack");
//        root.add(new NoBonusesModifier(goblin));
        root.add(new DoubleAttackModifier(goblin));
        root.add(new IncreaseDefenseModifier(goblin));
        root.handle();
        System.out.println(goblin.toString());
    }
}

class Creature {
    public String name;
    public int attack, defence;

    public Creature(String name, int attack, int defence) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", defence=" + defence +
                '}';
    }
}

class CreatureModifier {
    protected Creature creature;
    protected CreatureModifier next;

    public CreatureModifier(Creature creature) {
        this.creature = creature;
    }

    public void add(CreatureModifier cm) {
        if (next != null) {
            next.add(cm);
        } else {
            next = cm;
        }
    }


    public void handle() {
        if (next != null) next.handle();

    }
}

class DoubleAttackModifier extends CreatureModifier {
    @Override
    public void handle() {
        System.out.println("Doubling the attack");
        creature.attack *= 2;
        super.handle();
    }

    public DoubleAttackModifier(Creature creature) {
        super(creature);
    }
}

class IncreaseDefenseModifier extends CreatureModifier {
    public IncreaseDefenseModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        System.out.println("Increase defence");
        creature.defence += 3;
        super.handle();
    }
}

class NoBonusesModifier extends CreatureModifier {
    public NoBonusesModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        System.out.println("No bonuses");
    }
}

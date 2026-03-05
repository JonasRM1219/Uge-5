import java.util.ArrayList;
import java.util.Random;

class Animal {
    String name;
    int energy;

    Animal(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    boolean isActive() { return energy > 0; }
    int attack() { return 0; }

    public String toString() {
        return getClass().getSimpleName() + " \"" + name + "\" (energi: " + energy + ")";
    }
}

class Lion extends Animal {
    Lion(String name) { super(name, 100); }
    int attack() { return 15; }
}

class Wolf extends Animal {
    Random r = new Random();
    Wolf(String name) { super(name, 80); }
    int attack() { return r.nextInt(10) + 5; }
}

class Rabbit extends Animal {
    Rabbit(String name) { super(name, 150); }
    int attack() { return 3; }
}

class Contest {
    Animal a1, a2;
    int rounds = 0;

    Contest(Animal a1, Animal a2) { this.a1 = a1; this.a2 = a2; }

    void playRound() {
        rounds++;
        System.out.println("--- Runde " + rounds + " ---");

        if (a1.isActive()) {
            int damage = a1.attack();
            a2.energy -= damage;
            System.out.println(a1.name + " angriber " + a2.name + " for " + damage +
                    "! (" + a2.name + " har " + Math.max(0, a2.energy) + " energi tilbage)");
        }

        if (a2.isActive()) {
            int damage = a2.attack();
            a1.energy -= damage;
            System.out.println(a2.name + " angriber " + a1.name + " for " + damage +
                    "! (" + a1.name + " har " + Math.max(0, a1.energy) + " energi tilbage)");
        }
        System.out.println();
    }

    Animal getWinner() {
        if (!a1.isActive() && !a2.isActive()) return null;
        if (!a1.isActive()) return a2;
        if (!a2.isActive()) return a1;
        return null;
    }
}

public class Uge5Del2 {
    public static void main(String[] args) {
        ArrayList<Animal> dyr = new ArrayList<>();
        dyr.add(new Lion("Simba"));
        dyr.add(new Wolf("Fenrir"));
        dyr.add(new Rabbit("Bunny"));
        dyr.add(new Wolf("Luna"));

        System.out.println("ALLE DYR");
        for (Animal a : dyr) System.out.println(a);
        System.out.println();

        System.out.println("KAMP 1: LION VS RABBIT");
        Contest c1 = new Contest(dyr.get(0), dyr.get(2));
        while (c1.getWinner() == null) c1.playRound();
        System.out.println("VINDER: " + c1.getWinner().name + "\n");

        System.out.println("KAMP 2: WOLF VS WOLF");
        Contest c2 = new Contest(dyr.get(1), dyr.get(3));
        while (c2.getWinner() == null) c2.playRound();
        System.out.println("VINDER: " + c2.getWinner().name + "\n");
    }
}
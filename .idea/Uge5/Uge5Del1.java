
import java.util.ArrayList;

class Lamp {
    int watt;
    Lamp(int watt) { this.watt = watt; }
    public String toString() { return watt + "W"; }
}

class Window {
    int w, h;
    Window(int w, int h) { this.w = w; this.h = h; }
    int area() { return w * h; }
    public String toString() { return w + "x" + h + "cm"; }
}

class Room {
    String name;
    ArrayList<Lamp> lamps = new ArrayList<>();
    ArrayList<Window> windows = new ArrayList<>();

    Room(String name) { this.name = name; }
    void add(Lamp l) { lamps.add(l); }
    void add(Window w) { windows.add(w); }
    int lampCount() { return lamps.size(); }
    int totalWatt() { int sum = 0; for(Lamp l : lamps) sum += l.watt; return sum; }
    int totalArea() { int sum = 0; for(Window w : windows) sum += w.area(); return sum; }
}

class Building {
    String name;
    ArrayList<Room> rooms = new ArrayList<>();

    Building(String name) { this.name = name; }
    void add(Room r) { rooms.add(r); }
    int totalLamps() { int sum = 0; for(Room r : rooms) sum += r.lampCount(); return sum; }
    int totalWatt() { int sum = 0; for(Room r : rooms) sum += r.totalWatt(); return sum; }

    void print() {
        System.out.println(name);
        for(Room r : rooms) {
            System.out.println("  " + r.name + ": " + r.lamps + " " + r.windows);
        }
    }
}

class Uge5Del1 {
    public static void main(String[] args) {
        Building b = new Building("Kontor");

        Room r1 = new Room("Kontor 1");
        r1.add(new Lamp(60)); r1.add(new Lamp(40)); r1.add(new Window(120,150));

        Room r2 = new Room("Mødelokale");
        r2.add(new Lamp(100)); r2.add(new Lamp(100)); r2.add(new Window(200,150));

        Room r3 = new Room("Kantine");
        r3.add(new Lamp(80)); r3.add(new Lamp(60)); r3.add(new Window(300,200));

        b.add(r1); b.add(r2); b.add(r3);

        b.print();
        System.out.println("\nLamper: " + b.totalLamps() + ", Watt: " + b.totalWatt());
    }
}
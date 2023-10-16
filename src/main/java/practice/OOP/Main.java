package practice.OOP;

public class Main {
    public static void main(String[] args) {
        Bird b1 = new Penguin();
        b1.run();

        Flyable b2 = new Pigeon();
        b2.fly();

        Bird b3 = getPenguin();
        b3.run();

        BirdsList birdsList = new BirdsList();
        birdsList.getBirds().add(b1);
        birdsList.getBirds().add(b3);
        birdsList.getBirds().get(0).run();
//        birdsList.getBirds().add(b2);
    }

    public static Penguin getPenguin(){
        return new Penguin();
    }
}

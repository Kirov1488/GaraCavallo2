import java.util.Random;

class Cavallo extends Thread {
    private String name;
    private int speed;
    private int pathLength;
    private int distanceCovered = 0;
    private Random random = new Random();
    private float injuryChance = 0.05f;

    public Cavallo(String name, int speed, int pathLength) {
        this.name = name;
        this.speed = speed;
        this.pathLength = pathLength;
    }

    public float injury() {
        float chance = random.nextFloat();

        return chance;
    }

    @Override
    public void run() {
        while (distanceCovered < pathLength) {
            int step = random.nextInt(10) + 1;
            distanceCovered += step;

            if (distanceCovered > pathLength) {
                distanceCovered = pathLength;
            }

            if (injury() <= injuryChance) {
                System.out.println();
                break;
            } else {
                System.out.println(name + " ha percorso " + distanceCovered + " metri ");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        System.out.println(name + " ha tagliato il traguardo!");
    }
}

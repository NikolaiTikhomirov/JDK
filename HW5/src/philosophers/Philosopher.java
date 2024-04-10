package philosophers;

import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread{
    private String name;
    private final int eating;
    private EatingQueue eatingQueue;
    CountDownLatch latch;

    public Philosopher(String name, EatingQueue eatingQueue) {
        this.name = name;
        eating = 1500;
        this.eatingQueue = eatingQueue;
    }

    @Override
    public void run () {
        System.out.println(name + ": I'm going to think!");
        eating();
        System.out.println(name + ": I'm finished!");
    }

    public void eating () {
        try {
            for (int i = 0; i < 3; i++) {
                if (eatingQueue.eatingQueue) {
                    latch = new CountDownLatch(1);
                    eatingQueue.addPhilosopherToEatQueue(this);
                }
                if (latch != null) {
                    latch.await();
                }
                eatingQueue.setEatingQueue(true);
                System.out.println(name + ": I'm eating!");
                Thread.sleep(eating);
                System.out.println(name + ": I'm going to think!");
                System.out.println("============================================");
                eatingQueue.setEatingQueue(false);
                if (!eatingQueue.eatQueue.isEmpty()) {
                    eatingQueue.getPhilosopherFromEatQueue().latch.countDown();
                }
                Thread.sleep(600);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

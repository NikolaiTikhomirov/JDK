package philosophers;

import java.util.ArrayDeque;
import java.util.Deque;

public class EatingQueue {
    public volatile Boolean eatingQueue;
    public Deque<Philosopher> eatQueue;

    public EatingQueue() {
        eatingQueue = false;
        eatQueue = new ArrayDeque<>();
    }

    public void setEatingQueue(Boolean eatingQueue) {
        this.eatingQueue = eatingQueue;
    }

    public Philosopher getPhilosopherFromEatQueue() {
        return eatQueue.pop();
    }

    public synchronized void addPhilosopherToEatQueue(Philosopher philosopher) {
        if (!eatQueue.contains(philosopher)) {
            eatQueue.add(philosopher);
        }
    }
}

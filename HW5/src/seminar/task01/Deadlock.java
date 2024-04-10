package seminar.task01;
/*
Создать два класса ObjectA, ObjectB
Реализовать класс в котором два потока вызовут DeadLock
 */

public class Deadlock implements Runnable {
    ObjectA objectA = new ObjectA();
    ObjectB objectB = new ObjectB();
    Thread thread;

    public Deadlock() {
        Thread.currentThread().setName("philosophers.Main thread");
        this.thread = new Thread(this,"Blocking thread");
    }

    @Override
    public void run() {
        objectB.stepFirst(objectA);
        System.out.println(Thread.currentThread().getName() + " is finished!");
    }

    public void startDeadlock() {
        thread.start();
        objectA.stepFirst(objectB);
        System.out.println(Thread.currentThread().getName() + " is finished!");
    }

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();
        deadlock.startDeadlock();

//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                synchronized (deadlock.first) {
//                    System.out.println("Running...");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    synchronized (deadlock.second) {
//                        System.out.println("Some work");
//                    }
//                }
//
//            }
//        };
//
//        Thread thread2 = new Thread() {
//            @Override
//            public void run() {
//                synchronized (deadlock.second) {
//                    System.out.println("Running...");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    synchronized (deadlock.first) {
//                        System.out.println("Some work");
//                    }
//                }
//
//            }
//        };
//
//        thread1.start();
//        thread2.start();
    }
}

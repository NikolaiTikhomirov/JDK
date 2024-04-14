package org.example.MontyHallGame;

public class Main {
    public static void main(String[] args) {
        MontyHallGame montyHallGame = new MontyHallGame();
        for (int i = 0; i < 100; i++) {
            Thread consolePrinterFirst = new ConsolePrinterFirst();
            Thread consolePrinterSecond = new ConsolePrinterSecondAllwaysYes();
            consolePrinterFirst.start();
            consolePrinterSecond.start();
            montyHallGame.runGame();
        }
        String res1 = montyHallGame.getAllGameResults();

        MontyHallGame montyHallGame2 = new MontyHallGame();
        for (int i = 0; i < 100; i++) {
            Thread consolePrinterFirst = new ConsolePrinterFirst();
            Thread consolePrinterSecond = new ConsolePrinterSecondAllwaysNot();
            consolePrinterFirst.start();
            consolePrinterSecond.start();
            montyHallGame2.runGame();
        }
        String res2 = montyHallGame2.getAllGameResults();


        System.out.println(res1);
        System.out.println(res2);
    }
}
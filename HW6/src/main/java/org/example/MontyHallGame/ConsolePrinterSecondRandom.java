package org.example.MontyHallGame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class ConsolePrinterSecondRandom extends Thread {

    public void run () {
        Random random = new Random();
        try {
            Thread.sleep(200);
            int a = random.nextInt(1, 3);
            Robot r = new Robot();
            if (a == 1) {
                r.keyPress(KeyEvent.VK_1);
            }
            if (a == 2) {
                r.keyPress(KeyEvent.VK_2);
            }
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
}

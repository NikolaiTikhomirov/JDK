package org.example.MontyHallGame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ConsolePrinterSecondAllwaysNot extends Thread {

    public void run () {
        try {
            Thread.sleep(200);
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_2);
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
}

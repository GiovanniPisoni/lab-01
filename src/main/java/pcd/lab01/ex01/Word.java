package pcd.lab01.ex01;

import org.fusesource.jansi.Ansi.*;


import java.util.Random;

import static pcd.lab01.ex01.AuxLib.*;

public class Word extends Thread {

    private final String word;
    private final int pos;
    private Random rand;
    private int y;
    private int finalY;


    public Word(String word, int pos) {
        this.word = word;
        this.pos = pos;
        this.rand = new Random();
        this.y = 0;
        this.finalY = 20;

    }

    public void run() {
        Screen screen = Screen.getInstance();
        while (y < finalY) {
            screen.writeStringAt(y, pos, Color.BLACK, word);
            y += rand.nextInt(3);
            screen.writeStringAt(y, pos, Color.CYAN, word);
            try {
                Thread.sleep(100);
            } catch (Exception ignored) {}
        }
        screen.writeStringAt(y, pos, Color.BLACK, word);
        screen.writeStringAt(finalY+2, pos, Color.CYAN, word);
    }
}

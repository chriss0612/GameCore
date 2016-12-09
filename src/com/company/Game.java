package com.company;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * Created by Christian on 02.12.2016.
 */
public class Game extends Canvas implements Runnable{
    private static final long serialVersionUID = -7842236344523576496L;
    private static final String VERSION = "V1.0";
    private Thread thread;
    public boolean running = false;
    public Handler handeler;
    private Window window;
    public  Random r;
    private static Game game;
    private boolean paused=false;
    private int lastLevelup=0;

    public Game(){
        handeler = new Handler();
        window = new Window(1080,1080/16*9,"Game " + VERSION, this);
        r=new Random();
        requestFocus();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == ' ' && !paused)
                {

                }
                if(e.getExtendedKeyCode()==KeyEvent.VK_ESCAPE)
                    paused=!paused;
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        game = this;
    }
    public static Game getGame(){
        return game;
    }
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        running=false;
    }
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                if(!paused)tick();
                delta--;
            }
            if (running)
                render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("Fps: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    private void tick() {
        handeler.tick();

        game=this;
    }
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        handeler.render(g);
        g.dispose();
        bs.show();
    }
    public static void main(String args[])
    {
        new Game();
    }
}

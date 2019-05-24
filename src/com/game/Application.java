package com.game;

import com.game.entity.Ball;
import com.game.entity.Cxk;
import com.game.utils.GameConstant;
import com.game.utils.Gameutil;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Application extends Frame {
    private Cxk cxk;

    private Ball[] balls;

    private boolean bomed;

    private Image background;


    public Application(int ballNum , int ballSpeed) throws IOException {
        cxk = new Cxk(500,500,100,100,10);
        balls = new Ball[ballNum];
        for (int i = 0; i < ballNum; i++){
            balls[i] = new Ball((int)(Math.random() * GameConstant.WINDOW_WIDTH.getCode()), 30, 40, 40, ballSpeed);
        }
        background = Gameutil.getImage(this.getClass().getClassLoader().getResource("com/image/background/timg.jpg").getPath());
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0 ,null);
        if(!bomed){
            cxk.draw(g, false);
        }else {
            Gameutil.gameOver(g);
        }
        for (Ball ball : balls) {
            ball.draw(g, false);
            if(!bomed){
                bomed = Gameutil.isBom(cxk, ball);
            }
        }

    }

    private Image bImage;
    private Graphics bGraphics;

    @Override
    public void update(Graphics g) {
        if(bImage==null)
        {
            bImage=createImage(this.getSize().width,this.getSize().height);
            bGraphics=bImage.getGraphics();
        }
        bGraphics.setColor(getBackground());
        bGraphics.fillRect(0,0,this.getSize().width,this.getSize().height);
        paint(bGraphics);
        g.drawImage(bImage,0,0,this);
    }

    public void run(int x, int y){
        this.setTitle("kk paly basketball");
        this.setSize(GameConstant.WINDOW_WIDTH.getCode(), GameConstant.WINDOW_HEIGHT.getCode());
        this.setLocation(x,y);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP : {
                        cxk.setUp(true);
                        break;
                    }
                    case KeyEvent.VK_DOWN : {
                        cxk.setDown(true);
                        break;
                    }
                    case KeyEvent.VK_LEFT : {
                        cxk.setLeft(true);
                        break;
                    }
                    case KeyEvent.VK_RIGHT : {
                        cxk.setRight(true);
                        break;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP : {
                        cxk.setUp(false);
                        break;
                    }
                    case KeyEvent.VK_DOWN : {
                        cxk.setDown(false);
                        break;
                    }
                    case KeyEvent.VK_LEFT : {
                        cxk.setLeft(false);
                        break;
                    }
                    case KeyEvent.VK_RIGHT : {
                        cxk.setRight(false);
                        break;
                    }
                }
            }
        });



        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        Application application = new Application(20,10);
        application.run(500, 0);
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    application.repaint();
                    try {
                        Thread.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}

package com.game.entity;

import com.game.utils.GameConstant;
import com.game.utils.Gameutil;

import java.awt.*;
import java.io.IOException;

public class Cxk {
    private int x;
    private int y;
    private int width;
    private int height;
    private int speed;
    private Image[] images;
    private int currentImage;

    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    private Cxk() throws IOException {
        images = new Image[12];
        for(int i = 0; i < images.length; i++){
            String path = Cxk.class.getClassLoader().getResource("com/image/cxk/cxk-"+ (i+1) + ".png").getPath();
            images[i] = Gameutil.getImage(path);
        }
    }

    public Cxk(int x, int y, int width, int height, int speed) throws IOException {
        this();
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
        this.currentImage = 0;
    }

    public void draw(Graphics graphics, boolean rect){
        if(rect){
            Gameutil.drawRect(graphics, x, y, width, height);
        }
        graphics.drawImage(images[currentImage], x, y, width, height, null);
        if(up){
            if(y > GameConstant.UP_BORDER.getCode()){
                y -= speed;
            }
        }
        if(down){
            if(y < GameConstant.WINDOW_HEIGHT.getCode() - (GameConstant.OTHER_BORDER.getCode() + height)) {
                y += speed;
            }
        }
        if(left){
            if(x > GameConstant.OTHER_BORDER.getCode()){
                x -= speed;
            }
        }
        if(right){
            if(x < GameConstant.WINDOW_WIDTH.getCode() - (GameConstant.OTHER_BORDER.getCode() + width)){
                x += speed;
            }
        }
        currentImage++;
        if(currentImage >= images.length ){
            currentImage = 0;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

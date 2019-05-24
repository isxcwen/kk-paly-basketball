package com.game.entity;

import com.game.utils.GameConstant;
import com.game.utils.Gameutil;

import java.awt.*;
import java.io.IOException;

public class Ball {
    private int x;
    private int y;
    private int width;
    private int height;
    private int speed;
    private double angle;
    private Image[] images;
    private int currentImage;

    private int xDirection;
    private int yDirection;

    private Ball() throws IOException {
        images = new Image[4];
        for(int i = 0; i < images.length; i++){
            String path = Cxk.class.getClassLoader().getResource("com/image/basketball/ball-"+ (i+1) + ".png").getPath();
            images[i] = Gameutil.getImage(path);
        }
    }

    public Ball(int x, int y, int width, int height, int speed) throws IOException {
        this();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        double d = Math.random() * Math.PI * 2;
        this.angle = d;
        this.xDirection = 1;
        this.yDirection = 1;
    }

    public void draw(Graphics graphics, boolean rect){
        if(rect){
            Gameutil.drawRect(graphics, x, y, width, height);
        }
        graphics.drawImage(images[currentImage], x, y, width, height, null);

        int i = (int )(x + (xDirection * speed * Math.cos(angle)));
        int j = (int) (y + (yDirection * speed * Math.sin(angle)));

        if(i < GameConstant.OTHER_BORDER.getCode() || i > GameConstant.WINDOW_WIDTH.getCode() - (GameConstant.OTHER_BORDER.getCode() + width)){
            xDirection = -xDirection;
            i = (int )(x + (xDirection * speed * Math.cos(angle)));
        }
        if(j < GameConstant.UP_BORDER.getCode() || j > GameConstant.WINDOW_HEIGHT.getCode() - (GameConstant.OTHER_BORDER.getCode() + height)){
            yDirection = -yDirection;
            j = (int) (y + (yDirection * speed * Math.sin(angle)));
        }

        x = i;
        y = j;

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

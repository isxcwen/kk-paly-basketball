package com.game.utils;

import com.game.entity.Ball;
import com.game.entity.Cxk;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Gameutil {
    public static Image getImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }

    public static boolean isBom(Cxk a, Ball b){
        return convertCxk(a).intersects(convertBall(b));
    }

    public static Rectangle convertCxk(Cxk cxk){
        return new Rectangle(cxk.getX() + 20, cxk.getY()-20, cxk.getWidth() - 30, cxk.getHeight());
    }

    public static Rectangle convertBall(Ball ball){
        return new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
    }

    public static void  drawRect(Graphics graphics, int x, int y, int width, int height){
        Color color = graphics.getColor();
        graphics.setColor(Color.BLUE);
        graphics.drawRect(x, y, width, height);
        graphics.setColor(color);
    }

    public static void gameOver(Graphics graphics){
        Color color = graphics.getColor();
        Font font = graphics.getFont();
        graphics.setColor(Color.red);
        graphics.setFont(new Font("宋体",Font.BOLD,60));
        graphics.drawString("GAME OVER", 300, GameConstant.WINDOW_HEIGHT.getCode() / 2);
        graphics.setColor(color);
        graphics.setFont(font);
    }
}

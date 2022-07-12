package com.planes.obj;

import com.planes.Game;
import com.planes.utils.GameUtils;

import java.awt.*;

public class GameObj {
    Image image;
    int x;
    int y;
    int width;
    int height;
    double speed;
    int p_id;
    Game frame;

    public GameObj(Image image, int x, int y, int width, int height, double speed, int p_id, Game frame) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.p_id=p_id;
        this.frame = frame;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Game getFrame() {
        return frame;
    }

    public void setFrame(Game frame) {
        this.frame = frame;
    }

    public GameObj() {

    }

    public GameObj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public GameObj(Image image, int x, int y, double speed) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public GameObj(Image image, int x, int y, int width, int height, double speed,Game frame) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.frame = frame;
    }

    public void paintSelf(Graphics gImage) {
        gImage.drawImage(image, x, y, null);
    }

    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }
}


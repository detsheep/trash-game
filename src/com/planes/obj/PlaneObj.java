package com.planes.obj;

import com.planes.Game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlaneObj extends GameObj {
    @Override
    public Image getImage() {
        return super.getImage();
    }

    public PlaneObj() {
        super();
    }

    public PlaneObj(Image image, int x, int y, int width, int height, double speed, Game frame) {
        super(image, x, y, width, height, speed,frame);
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                PlaneObj.super.x=e.getX()-28;
                PlaneObj.super.y=e.getY()-15;
            }
        });
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if(this.frame.bossObj!=null&&this.getRec().intersects(this.frame.bossObj.getRec())){
            Game.state=3;
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

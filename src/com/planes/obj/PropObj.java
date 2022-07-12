package com.planes.obj;

import com.planes.Game;
import com.planes.utils.GameUtils;

import java.awt.*;

public class PropObj extends GameObj{
    public PropObj() {
        super();
    }

    public PropObj(Image image, int x, int y, int width, int height, double speed, int p_id,Game frame) {
        super(image, x, y, width, height, speed,p_id, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        super.paintSelf(gImage);
        y += speed;
        x+=0.5*speed;
        if (x > 790 || x < -30) {
            speed = -speed;
        }
        if(y>900){
            this.x=-200;
            this.y=200;
            GameUtils.removeList.add(this);
        }
        //道具的碰撞检测
        if (this.getRec().intersects(this.frame.planeObj.getRec())) {
            this.x=-200;
            this.y=200;
//          System.out.println("nmsl");
          Game.shell_state=p_id;
          GameUtils.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {

        return super.getRec();
    }
}

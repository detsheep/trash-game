package com.planes.obj;

import com.planes.Game;
import com.planes.obj.GameObj;
import com.planes.utils.GameUtils;

import java.awt.*;

public class BulletObj extends GameObj {
    public BulletObj(Image image, int x, int y, int width, int height, double speed, Game frame) {
        super(image, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y+=speed;
        if(this.getRec().intersects(this.frame.planeObj.getRec())){
            Game.state=3;
        }
        //敌机子弹越界消失，条件为y>900，改变后的坐标(-300,300)
        if(y>900){
            this.x=-300;
            this.y=300;
            GameUtils.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

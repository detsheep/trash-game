package com.planes.obj;

import com.planes.Game;
import com.planes.utils.GameUtils;

import java.awt.*;

public class BossObj extends GameObj {
    int life = 50;

    public BossObj(Image image, int x, int y, int width, int height, double speed, Game frame) {
        super(image, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if (x > 790 || x < -30) {
            speed = -speed;
        }
        x += speed;
        for (ShellObj shellObj : GameUtils.shellObjList) {
            if (this.getRec().intersects(shellObj.getRec())) {
                shellObj.setX(-100);
                shellObj.setY(100);
                GameUtils.removeList.add(shellObj);
                life--;
            }
            if(life<=0){
                Game.state=4;
            }
        }
        //血条白色背景
        gImage.setColor(Color.white);
        gImage.fillRect(20,40,150,10);
        //血条的绘制,life之后是的除数是boss总血量
        gImage.setColor(Color.red);
        gImage.fillRect(20,40,life*150/10,10);
    }


    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

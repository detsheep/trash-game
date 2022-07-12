package com.planes.obj;

import com.planes.Game;
import com.planes.utils.GameUtils;

import java.awt.*;

public class EnemyObj extends GameObj {
    public EnemyObj() {
        super();
    }

    public EnemyObj(Image image, int x, int y, int width, int height, double speed, Game frame) {
        super(image, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        //敌我飞机碰撞检测
        if (this.getRec().intersects(this.frame.planeObj.getRec())) {
            Game.state = 3;
//          System.out.println("nmsl");
        }
        //敌机越界消失,当y>900,改变坐标为(-200,-200),我方子弹为(-100,100)
        if(y>900){
            this.x=-200;
            this.y=200;
            GameUtils.removeList.add(this);
        }
        //敌机与子弹的碰撞检测
        for (ShellObj shellObj : GameUtils.shellObjList) {
            if (this.getRec().intersects(shellObj.getRec())) {
//                System.out.println("碰撞了");
                ExplodeObj explodeObj=new ExplodeObj(x,y);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);

                if(Game.shell_state==0){
                    shellObj.setX(-100);
                    shellObj.setY(100);
                    GameUtils.removeList.add(shellObj);
                }

                this.x = -200;
                this.y = 200;

                GameUtils.removeList.add(this);
                Game.score++;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

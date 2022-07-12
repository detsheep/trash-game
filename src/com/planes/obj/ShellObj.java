package com.planes.obj;

import com.planes.Game;
import com.planes.utils.GameUtils;

import java.awt.*;

public class ShellObj extends GameObj {
    @Override
    public Image getImage() {
        return super.getImage();
    }

    public ShellObj() {
        super();
    }

    public ShellObj(Image image, int x, int y, int width, int height, double speed, Game frame) {
        super(image, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y -= speed;
        //子弹越界消失
        if (y < 0) {
            this.x = -100;
            this.y = 100;
            GameUtils.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

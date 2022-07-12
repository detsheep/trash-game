package com.planes.obj;

import java.awt.*;

public class BgObj extends GameObj {
    public BgObj() {
        super();
    }

    public BgObj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y+=speed;
        if(y>=0){
            y=-1000;
        }
    }
}

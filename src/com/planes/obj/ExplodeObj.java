package com.planes.obj;

import java.awt.*;

public class ExplodeObj extends GameObj {
    static Image[] pic = new Image[4];
    int explodeCount = 0;

    static {
        for (int i = 0; i < pic.length; i++) {
            pic[i] = Toolkit.getDefaultToolkit().getImage("imgs/exp" + (i + 1) + ".gif");
        }
    }

    @Override
    public void paintSelf(Graphics gImage) {

        if(explodeCount<3){
            image=pic[explodeCount];
            super.paintSelf(gImage);
            explodeCount++;
        }
    }

    public ExplodeObj(int x, int y) {
        super(x, y);
    }
}

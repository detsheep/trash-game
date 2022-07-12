package com.planes.utils;

import com.planes.obj.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    //背景图
    public static Image bgImage = Toolkit.getDefaultToolkit().getImage("imgs/bg2.png");
    //爆炸背景图
    public static Image expImage = Toolkit.getDefaultToolkit().getImage("imgs/exp.gif");
    //默认飞机
    public static Image planeImage = Toolkit.getDefaultToolkit().getImage("imgs/plane.png");
    //默认子弹
    public static Image c_shellImage = Toolkit.getDefaultToolkit().getImage("imgs/c_shell.png");
    //激光子弹
    public static Image c1_shellImage = Toolkit.getDefaultToolkit().getImage("imgs/c1_shell.png");
    //蓝色子弹
    public static Image c2_shellImage = Toolkit.getDefaultToolkit().getImage("imgs/c2_shell.png");
    //敌机1
    public static Image enemy1Image = Toolkit.getDefaultToolkit().getImage("imgs/enemy1.png");
    //敌机2
    public static Image enemyImage = Toolkit.getDefaultToolkit().getImage("imgs/enemy2.png");
    //boss1
    public static Image bossImage = Toolkit.getDefaultToolkit().getImage("imgs/boss.png");
    //boss子弹
    public static Image bulletImage = Toolkit.getDefaultToolkit().getImage("imgs/bullet.png");
    //道具1-激光
    public static Image prop1Image = Toolkit.getDefaultToolkit().getImage("imgs/prop1.png");
    //道具2-蓝色子弹
    public static Image prop2Image = Toolkit.getDefaultToolkit().getImage("imgs/prop2.png");



    //游戏中所有物体的集合
    public static List<GameObj> gameObjList = new ArrayList<>();
    //我方子弹集合
    public static List<ShellObj> shellObjList = new ArrayList<>();
    //敌方战机集合
    public static List<EnemyObj> enemyObjList = new ArrayList<>();
    //需要移除的集合
    public static List<GameObj> removeList = new ArrayList<>();
    //敌方子弹集合
    public static List<BulletObj> bulletObjList = new ArrayList<>();
    //爆炸类集合
    public static List<ExplodeObj> explodeObjList = new ArrayList<>();
    //道具的集合
    public static List<PropObj> propObjList = new ArrayList<>();

    //绘制文字的方法
    public static void drawWord(Graphics gImage,String str,Color color,int size,int x,int y){
        gImage.setColor(color);
        gImage.setFont(new Font("楷体",Font.BOLD,size));
        gImage.drawString(str,x,y);
    }

}

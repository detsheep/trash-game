package com.planes;

import com.planes.obj.*;
import com.planes.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JFrame {

    //状态{0，1，2，3，4}未开始，游戏中，暂停，失败，成功
    public static int state = 0;
    //游戏分数
    public static int score = 0;
    //目前子弹状况(根据道具来修改)
    public static int shell_state = 0;
    //当前道具维持时间(undefined!!)
    //....
    //当前关卡，击败boss+1
    public static int level=0;

    Image offScreenImage = null;
    //窗口宽高
    int width = 1000;
    int height = 800;
    //游戏重绘次数
    int count = 1;
    //敌机数量
    int enemyCount = 0;

    //背景对象
    BgObj bgObj = new BgObj(GameUtils.bgImage, 0, -1000, 2);
    //我的飞机对象
    public PlaneObj planeObj = new PlaneObj(GameUtils.planeImage, 290, 550, 20, 30, 0, this);
    //Boss对象
    public BossObj bossObj = null;

    public void launch() {
        //窗体是否可见
        this.setVisible(true);
        //窗口大小
        this.setSize(width, height);
        //窗口位置
        this.setLocationRelativeTo(null);
        //窗口标题
        this.setTitle("trash");

        //在总集合中添加背景和我的飞机
        GameUtils.gameObjList.add(bgObj);
        GameUtils.gameObjList.add(planeObj);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (state == 0 && e.getButton() == 1) {
                    state = 1;
//                    repaint();
                }
            }
        });

        //按空格暂停
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 32) {
                    switch (state) {
                        case 1:
                            state = 2;
                            break;
                        case 2:
                            state = 1;
                            break;
                        default:
                    }
                }
            }
        });

        //在state==1的情况下调用createObj函数
        while (true) {
            if (state == 1) {
                createObj();
                repaint();
            }
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(width, height);
        }
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0, 0, width, height);
        if (state == 0) {
            //初始画面(调用drawImage函数来绘制)
            gImage.drawImage(GameUtils.bgImage, 0, 0, null);
            gImage.drawImage(GameUtils.enemyImage, 200, 120, null);
            gImage.drawImage(GameUtils.expImage, 270, 350, null);
            GameUtils.drawWord(gImage, "点击开始游戏，空格可暂停", Color.yellow, 40, 250, 420);
        }
        if (state == 1) {
            GameUtils.gameObjList.addAll(GameUtils.explodeObjList);
            for (int i = 0; i < GameUtils.gameObjList.size(); i++) {
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
            GameUtils.gameObjList.removeAll(GameUtils.removeList);
        }
        if (state == 3) {
            //失败画面(调用drawImage函数来绘制)
            gImage.drawImage(GameUtils.expImage, planeObj.getX() - 35, planeObj.getY() - 30, null);
            GameUtils.drawWord(gImage, "F a i l!!!", Color.green, 100, 380, 420);
        }
        if (state == 4) {
            //成功画面(调用drawImage函数来绘制)
            gImage.drawImage(GameUtils.expImage, bossObj.getX() + 30, bossObj.getY(), null);
            GameUtils.drawWord(gImage, "W i n !!!", Color.green, 100, 280, 520);

        }
        GameUtils.drawWord(gImage, "score:" + score, Color.lightGray, 40, 30, 100);
        g.drawImage(offScreenImage, 0, 0, null);
        count++;
        //优化目标之一
//        System.out.println("场上Obj数量" + GameUtils.gameObjList.size());
    }

    void createObj() {
        //子弹对象
        if (shell_state==0&&count % 15 == 0) {
            GameUtils.shellObjList.add(new ShellObj(GameUtils.c_shellImage, planeObj.getX() + 20, planeObj.getY() - 10, 13, 29, 10, this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
        }
        //激光子弹
        if (shell_state==1&&count % 10 == 0) {
            GameUtils.shellObjList.add(new ShellObj(GameUtils.c1_shellImage, planeObj.getX()+20, planeObj.getY() -175, 17, 130, 80, this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
        }
        //蓝色子弹
        if (shell_state==2&&count % 14 == 0) {
            GameUtils.shellObjList.add(new ShellObj(GameUtils.c2_shellImage, planeObj.getX() + 40, planeObj.getY() - 10, 13, 29, 5, this));
            GameUtils.shellObjList.add(new ShellObj(GameUtils.c2_shellImage, planeObj.getX() - 40, planeObj.getY() - 10, 13, 29, 5, this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 2));
        }
        //敌方飞机
        if (count % 15 == 0) {
            GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemy1Image, (int) (Math.random() * 12) * 75, 0, 74, 59, 5, this));
            GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size() - 1));
            enemyCount++;
        }
        //敌方boss子弹
        if (count % 21 == 0 && bossObj != null) {
            GameUtils.bulletObjList.add(new BulletObj(GameUtils.bulletImage, bossObj.getX() + 70, bossObj.getY() + 70, 15, 25, 5, this));
            GameUtils.gameObjList.add(GameUtils.bulletObjList.get(GameUtils.bulletObjList.size() - 1));
        }
        //敌方boss
        if (enemyCount == 30 && bossObj == null) {
            bossObj = new BossObj(GameUtils.bossImage, 300, 50, 180, 120, 5, this);
            GameUtils.gameObjList.add(bossObj);
        }
        //道具
        if (count % 300 == 0) {
            //p为随机生成的效果
            Image image = null;
            int p=(int)(1+Math.random()*(2));
            switch (p){
                case 1:image= GameUtils.prop1Image;break;
                case 2:image=GameUtils.prop2Image;break;
                default:
            }
//            System.out.println(p);
            GameUtils.propObjList.add(new PropObj(image, (int) (Math.random() * 12) * 75, 0, 75, 60, 6,p,this));
            GameUtils.gameObjList.add(GameUtils.propObjList.get(GameUtils.propObjList.size() - 1));
        }

    }

    public static void main(String[] args) {
        Game game = new Game();
        game.launch();
    }
}

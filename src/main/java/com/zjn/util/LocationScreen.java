package com.zjn.util;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Classname LocationScreen
 * @Description 本地监控核心类
 * @Date 2019/11/18 2:54 下午
 * @Created by miaojiayu
 */
public class LocationScreen {

    public static void main(String[] args) {

        //请求框
        int chioce = JOptionPane.showConfirmDialog(
                null,"请求控制对方电脑?","周俊楠",JOptionPane.YES_NO_CANCEL_OPTION);

        //否按钮
        if(chioce == JOptionPane.NO_OPTION){
            return;
        }

        //输入ip地址和端口号
        JOptionPane.showInputDialog("请输入你要连接的IP地址和端口号");

        //初始化窗口
        JFrame jframe = new JFrame("Java远程桌面监控");
        //窗口大小
        jframe.setSize(600,600);
        //窗口是否可见
        jframe.setVisible(true);
        //居中显示
        jframe.setLocationRelativeTo(null);
        //设置窗口置顶
        jframe.setAlwaysOnTop(true);
        //点击关闭按钮退出程序
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel imageJLabel = new JLabel();

        jframe.add(imageJLabel);


        try {
            //创建一个机器人
            Robot robot = new Robot();
            //获取屏幕大小
            Toolkit tk = Toolkit.getDefaultToolkit();
            Dimension dm = tk.getScreenSize();
            //System.out.println("宽度:"+dm.getWidth()+"  高度:"+dm.getHeight());
            Rectangle rec = new Rectangle(
                    jframe.getWidth(), 0, (int) dm.getWidth()-jframe.getWidth(), (int)dm.getHeight());

            //截取图片
            BufferedImage bufImg = robot.createScreenCapture(rec);

            imageJLabel.setIcon(new ImageIcon(bufImg));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

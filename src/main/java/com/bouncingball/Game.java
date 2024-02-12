package com.bouncingball;


import com.bouncingball.components.AddBallFrame;
import com.bouncingball.components.BallPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.bouncingball.constants.GameSettings.WINDOW_HEIGHT;
import static com.bouncingball.constants.GameSettings.WINDOW_WIDTH;


/**
 * Game main class
 * @author FinnerLi yuanfeng_li@brown.edu
 */
public class Game {

    /**
     * game main func
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLayout(new BorderLayout());
        // 设置窗口为无装饰（即没有窗口边框和标题栏）

        BallPanel ballPanel = new BallPanel();
        ballPanel.setBackground(Color.WHITE);
        ballPanel.setOpaque(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        ballPanel.setBorder(border);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ballPanel.setVisible(true);
        frame.add(ballPanel, BorderLayout.CENTER);

        JButton addButton = new JButton("Add Ball");
        addButton.setPreferredSize(new Dimension(100, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.add(addButton, gbc);
        frame.add(buttonPanel, BorderLayout.SOUTH);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBallFrame dialog = new AddBallFrame(frame);
                dialog.setBallPanel(ballPanel);
                dialog.setVisible(true);
            }
        });
        frame.setVisible(true);
    }



}

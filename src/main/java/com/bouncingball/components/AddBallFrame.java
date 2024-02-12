package com.bouncingball.components;

import com.bouncingball.entity.Ball;
import com.bouncingball.utils.BallGameUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.bouncingball.constants.GameSettings.*;

/**
 * @author FinnerLi 2/11/24 yuanfeng_li@brown.edu
 **/

@Getter
@Setter
public class AddBallFrame extends JDialog {

    private BallPanel ballPanel;

    public AddBallFrame(JFrame parent) {
        super(parent, "Add Ball Settings", true);
        setSize(ADD_BALL_WINDOW_WIDTH, ADD_BALL_WINDOW_HEIGHT);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 6, 6, 6);


        // 设置组件在网格中的位置
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Size (20-80):"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        JTextField sizeField = new JTextField("40");
        add(sizeField, gbc);

        // 每个组件占用一行，因此gridy需要增加
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Velocity (10-80):"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        JTextField velocityField = new JTextField("40");
        add(velocityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Start X (100-900):"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        JTextField startXField = new JTextField("100");
        add(startXField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Start Y (100-900):"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        JTextField startYField = new JTextField("100");
        add(startYField, gbc);

        // 为 ColorChooser 设置权重，使其可以在垂直方向填充额外空间
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // 占据两列
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH; // 水平和垂直填充空间

        JColorChooser colorChooser = new JColorChooser();
        colorChooser.setPreviewPanel(new JPanel()); // 简化的颜色选择器视图
        add(colorChooser, gbc);

        // 重置权重，添加 OK 按钮
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE; // 不填充额外空间
        gbc.anchor = GridBagConstraints.CENTER;

        JButton okButton = new JButton("OK");
        add(okButton,gbc);
        okButton.addActionListener(e -> {
            int size = BallGameUtils.parseAndFixInt(sizeField.getText(), MAX_SIZE, MIN_SIZE);
            int velocity = BallGameUtils.parseAndFixInt(velocityField.getText(), MAX_VELOCITY, MIN_VELOCITY);
            Color color = colorChooser.getColor();
            int xPos = BallGameUtils.parseAndFixInt(startXField.getText(), X_RANGE_END, X_RANGE_START);
            int yPos = BallGameUtils.parseAndFixInt(startYField.getText(), Y_RANGE_END, Y_RANGE_START);
            if(getBallPanel() != null){
                Ball newBall = Ball.builder()
                        .x(xPos)
                        .y(yPos)
                        .velocity(velocity)
                        .size(size)
                        .color(color)
                        .build();
                getBallPanel().addBall(newBall);
            }
        });
        setLocationRelativeTo(parent);
    }

}

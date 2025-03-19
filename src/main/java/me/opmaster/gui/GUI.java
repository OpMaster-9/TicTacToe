package me.opmaster.gui;

import me.opmaster.game.Tiktaktoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    Tiktaktoe game = new Tiktaktoe();
    JButton[][] fields = new JButton[3][3];
    JTextField indicator = new JTextField();

    public void initialize() {
        this.setBounds(0, 0, 600, 600);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(70, 70, 70));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("TikTakToe");

        indicator.setEditable(false);
        indicator.setFocusable(false);
        indicator.setBounds(50, 10, 500, 30);
        indicator.setBackground(new Color(20, 20, 20));
        indicator.setForeground(new Color(200, 200, 200));
        indicator.setBorder(null);
        this.add(indicator);


        JPanel board = new JPanel();
        board.setLayout(new GridLayout(3, 3));
        board.setBounds(50, 50, 500, 500);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fields[i][j] = new JButton();
                fields[i][j].setBackground(new Color(20, 20, 20));
                fields[i][j].setForeground(new Color(200, 200, 200));
                fields[i][j].setFocusable(false);
                fields[i][j].setFont(new Font("Monospaced", Font.PLAIN, 65));
                final int[] pos = {i, j};
                fields[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        game.makeMove(pos[0], pos[1]);
                        refresh();
                    }
                });
                board.add(fields[i][j]);
            }
        }

        this.add(board);

        this.setVisible(true);
        refresh();
    }
    public void refresh() {
        indicator.setText(game.getIndicator());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fields[i][j].setText(String.valueOf(game.getChar(i, j)));
            }
        }
    }
}

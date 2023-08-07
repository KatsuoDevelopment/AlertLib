package fr.katsuo.alertlib.ui;

import fr.katsuo.alertlib.utils.AlertEnum;
import fr.katsuo.alertlib.utils.MouseUtils;

import javax.swing.*;
import java.awt.*;

public class AlertFrame extends JFrame {

    private final AlertPanel panel;
    private AlertFrame instance;

    public AlertFrame(String name, AlertEnum alert, String message){
        instance = this;

        this.setTitle(name);

        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setContentPane(panel = new AlertPanel());
        this.pack();
        this.setSize(400, 200);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        MouseUtils mouse = new MouseUtils(this);
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);

        this.setVisible(true);
    }

    public AlertFrame getInstance() {
        return instance;
    }

    public AlertPanel getPanel() {
        return panel;
    }
}

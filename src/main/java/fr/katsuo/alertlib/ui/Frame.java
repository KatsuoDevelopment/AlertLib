package fr.katsuo.alertlib.ui;

import fr.katsuo.alertlib.ui.component.AlertComponent;
import fr.katsuo.alertlib.utils.AlertType;
import fr.katsuo.alertlib.utils.MouseUtils;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private final AlertComponent panel;

    public Frame(String name, AlertType alert, String message){
        this.setTitle(name);

        this.setUndecorated(true);
        this.setContentPane(panel = new AlertComponent(alert, name, message));
        this.pack();

        this.setSize(400, 200);
        this.setLocationRelativeTo(null);

        MouseUtils mouse = new MouseUtils(this);
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);

        this.setVisible(true);
    }
}

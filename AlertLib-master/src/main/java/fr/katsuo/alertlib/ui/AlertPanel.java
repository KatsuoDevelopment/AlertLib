package fr.katsuo.alertlib.ui;

import fr.katsuo.alertlib.ui.component.ValidateButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AlertPanel extends JPanel implements ActionListener {

    private Image errorImage = new ImageIcon(getClass().getResource("/error.png")).getImage();;
    private Image checkImage = new ImageIcon(getClass().getResource("/check.png")).getImage();;
    private JLabel title = new JLabel("NameTest | ERROR");
    private ValidateButton valid = new ValidateButton(checkImage, new Color(43, 143, 41), "Validate", 350, 30);


    public AlertPanel() {
        this.setLayout(null);
        this.setOpaque(false);

        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/inter/Inter-Medium.ttf"));
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        Font fontText = font.deriveFont(Font.PLAIN, 18f);

        title.setBounds(50, 17, 200, 14);
        title.setForeground(Color.white);
        title.setFont(fontText);
        this.add(title);

        valid.setBounds(24, 150);
        valid.addActionListener(this);
        this.add(valid);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(41, 41, 41));
        g.fillRect(0, 0, 400, 200);
        g.setColor(new Color(31, 31, 31));
        g.fillRect(0, 0, 400, 50);
        g.drawImage(errorImage, 10, 10, 30, 30,this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(valid.equals(e.getSource())){
            System.exit(0);
        }
    }
}

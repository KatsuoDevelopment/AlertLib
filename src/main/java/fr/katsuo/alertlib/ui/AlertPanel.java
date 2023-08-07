package fr.katsuo.alertlib.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AlertPanel extends JPanel {

    private Image errorImage = new ImageIcon(getClass().getResource("/error.png")).getImage();;
    private JLabel title = new JLabel("NameTest | ERROR");


    public AlertPanel() {
        this.setLayout(null);
        this.setOpaque(false);

        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/inter/Inter-Medium.ttf"));
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        Font biggerFont = font.deriveFont(Font.PLAIN, 12f);

        title.setBounds(46, 13, 145, 14);
        title.setForeground(Color.white);
        title.setFont(biggerFont);
        this.add(title);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(41, 41, 41));
        g.fillRect(0, 0, 300, 150);
        g.setColor(new Color(31, 31, 31));
        g.fillRect(0, 0, 300, 40);
        g.drawImage(errorImage, 10, 8, 25, 25,this);
    }
}

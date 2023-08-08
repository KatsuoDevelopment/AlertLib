package fr.katsuo.alertlib.ui.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class ValidateButton extends JButton implements MouseListener {

    private Image image;
    private Color color;
    private String text;
    private int width;
    private int height;
    private Font font;
    private boolean hovered = false;

    public ValidateButton(Image image, Color color, String text, int width, int height) {
        this.setLayout(null);
        this.image = image;
        this.color = color;
        this.text = text;
        this.width = width;
        this.height = height;

        this.addMouseListener(this);
        this.setSize(width, height);
        this.setBorder(null);
        this.setContentAreaFilled(false);

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/inter/Inter-ExtraBold.ttf"));
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        Font fontText = font.deriveFont(Font.BOLD, 11);

        JLabel label = new JLabel(text);
        label.setBounds(150, 0, 100, 30);
        label.setFont(fontText);
        label.setForeground(Color.WHITE);
        this.add(label);
    }

    @Override
    public void setFont(Font font) {
        this.font = font;
    }

    public void setBounds(int x, int y) {
        super.setBounds(x, y, width, height);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.hovered = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.hovered = false;
    }

    @Override
    protected void paintComponent(Graphics g2) {
        Graphics2D g = (Graphics2D)g2;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHints(rh);
        if (this.hovered) {
            g.setColor(color);
            g.fillRect(0, 0, width, height);
            g.drawImage(image, 10, 6, 20, 17, this);
            g.setColor(new Color(255, 255, 255, 40));
            g.fillRect(0, 0, width, height);
        } else {
            g.setColor(color);
            g.fillRect(0, 0, width, height);
            g.drawImage(image, 10, 6, 20, 17, this);
        }
    }


}
package fr.katsuo.alertlib.ui.component;

import fr.katsuo.alertlib.ui.Frame;
import fr.katsuo.alertlib.utils.AlertType;
import fr.katsuo.alertlib.utils.multiline.MultiLineLabelUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Pattern;

public class AlertComponent extends JPanel implements ActionListener {

    private AlertType alertType;
    private String title, message;
    private Image img;
    private JLabel titleLabel, messageLabel;
    private Image checkImage = new ImageIcon(getClass().getResource("/check.png")).getImage();
    private ValidateButton valid = new ValidateButton(checkImage, new Color(43, 143, 41), "Validate", 350, 30);
    private Font interMediumFont, interRegularFont, text;

    public AlertComponent(AlertType alertType, String title, String message) {
        setLayout(null);
        setOpaque(false);

        this.alertType = alertType;
        this.title = title;
        this.message = message;

        img = new ImageIcon(getClass().getResource(alertType.resourceLink)).getImage();

        try {
            interMediumFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/inter/Inter-Medium.ttf"));
            interRegularFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/inter/Inter-Regular.ttf"));
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        text = interMediumFont.deriveFont(Font.PLAIN, 18f);

        titleLabel = new JLabel(title + " | " + upperCaseFirstChar(alertType.toString()));
        titleLabel.setBounds(50, 18, 300, 14);
        titleLabel.setForeground(Color.white);
        titleLabel.setBackground(new Color(1, 34, 12));
        titleLabel.setFont(text);
        this.add(titleLabel);

        text = interRegularFont.deriveFont(Font.PLAIN, 10f);

        messageLabel = new JLabel(message);
        messageLabel.setBounds(25, 58, 355, 80);
        messageLabel.setForeground(Color.white);
        messageLabel.setUI(MultiLineLabelUI.labelUI);
        messageLabel.setFont(text);
        this.add(messageLabel);

        valid.setBounds(24, 150);
        valid.addActionListener(this);
        this.add(valid);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(valid.equals(e.getSource())){
            Frame.getInstance().setVisible(false);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(41, 41, 41));
        g.fillRect(0, 0, 400, 200);
        g.setColor(new Color(31, 31, 31));
        g.fillRect(0, 0, 400, 50);
        g.drawImage(img, 10, 10, 30, 30,this);
    }

    private String upperCaseFirstChar(String message){
        String altnc = alertType.toString().toLowerCase();
        String output = altnc.substring(0, 1).toUpperCase() + altnc.substring(1);
        return output;
    }

}

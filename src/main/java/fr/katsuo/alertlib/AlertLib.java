package fr.katsuo.alertlib;

import fr.katsuo.alertlib.ui.Frame;
import fr.katsuo.alertlib.utils.AlertType;

public class AlertLib {

    private String name;

    public AlertLib(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sendAlert(AlertType alert, String message) {
        Frame frame = new Frame(name, alert, message);
    }
}

package fr.katsuo.alertlib;

import fr.katsuo.alertlib.ui.AlertFrame;
import fr.katsuo.alertlib.utils.AlertEnum;

public class AlertLib {

    private String name;

    public AlertLib(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sendAlert(AlertEnum alert, String message) {
        AlertFrame alertFrame = new AlertFrame(name, alert, "");
    }
}

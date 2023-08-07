package fr.katsuo.alertlib;

import fr.katsuo.alertlib.utils.AlertEnum;

public class Test {
    public static void main(String[] args) {
        AlertLib alertLib = new AlertLib("Minecraft Launcher");
        alertLib.sendAlert(AlertEnum.ERROR, "");
    }
}
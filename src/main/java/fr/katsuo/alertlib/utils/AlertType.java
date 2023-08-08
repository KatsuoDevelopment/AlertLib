package fr.katsuo.alertlib.utils;

public enum AlertType {
    SUCCESS("/circleCheck.png"),
    INFO("/circleInfo.png"),
    WARNING("/circleWarning.png"),
    ERROR("/circleError.png");

    public final String resourceLink;

    AlertType(String resourceLink) {
        this.resourceLink = resourceLink;
    }
}

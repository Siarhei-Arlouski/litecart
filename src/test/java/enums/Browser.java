package enums;

public enum Browser {
    CHROME("CHROME"),
    FIREFOX("FIREFOX"),
    EDGE("EDGE");

    final String browserName;

    Browser(String browserName) {
        this.browserName = browserName;
    }
}

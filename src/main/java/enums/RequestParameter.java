package enums;

public enum RequestParameter {
    LOGIN       ("login"),
    PASS        ("pass"),
    PASS1       ("pass1"),
    PASS2       ("pass2"),
    CITY        ("city"),
    PHONE       ("phone"),
    EMAIL       ("email");

    private RequestParameter(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}

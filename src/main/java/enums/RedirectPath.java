package enums;

public enum RedirectPath {


    MAIN_PAGE("/olx_war/main"),
    REG_PAGE("/olx_war/reg");


    private RedirectPath(String value) {
        this.value = value;
    }
    private String value;
    public String getValue() {
        return value;
    }
}



package enums;

public enum RedirectPath {


    MAIN_PAGE("/olx_war_exploded/main"),
    MAIN_REDIRECT("main"),
    LOGIN_PAGE("/olx_war_exploded/auth"),
    REG_PAGE("/olx_war_exploded/reg"),
    AD_PAGE("/olx_war_exploded/ad");


    private RedirectPath(String value) {
        this.value = value;
    }
    private String value;
    public String getValue() {
        return value;
    }
}




package enums;

public enum RedirectPath {


    MAIN_PAGE("/olx_war_exploded/main"),
    MAIN_REDIRECT("main"),
    LOGIN_PAGE("/olx_war_exploded/auth"),
    REG_PAGE("/olx_war_exploded/reg"),
    AD_PAGE("/olx_war_exploded/ad"),
    EDIT_USER("/olx_war_exploded/editUser"),
    EDIT_AD("/olx_war_exploded/editAd");

    private RedirectPath(String value) {
        this.value = value;
    }
    private String value;
    public String getValue() {
        return value;
    }
}




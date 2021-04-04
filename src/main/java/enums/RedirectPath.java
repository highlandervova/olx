package enums;

public enum RedirectPath {
    MAIN_PAGE("/olx_war/main"),
    MAIN_REDIRECT("main"),
    LOGIN_PAGE("/olx_war/auth"),
    REG_PAGE("/olx_war/reg"),
    ADD_AD_PAGE("/olx_war/addAd"),
    EDIT_USER("/olx_war/editUser"),
    EDIT_AD("/olx_war/editAd"),
    UPLOAD_PAGE("/olx_war/uploadAd");


    private RedirectPath(String value) {
        this.value = value;
    }
    private String value;
    public String getValue() {
        return value;
    }
}




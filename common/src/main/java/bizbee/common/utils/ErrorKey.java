package bizbee.common.utils;

public enum ErrorKey {
    MISSING_REQUIRED_PARAM("missing.required.param"),
    PARTNER_NOT_FOUND("partner.not.found"),
    PARTNER_NOT_ENABLED("partner.not.enabled"),
    COMPANY_NOT_FOUND("company.not.found"),
    PHONE_ALREADY_EXISTS("phone.already.exists"),
    MALFORMED_INPUT_JSON("malformed.input.json");

    private String code;

    ErrorKey(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

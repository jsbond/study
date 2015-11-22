package bizbee.api.response;

import java.io.Serializable;


public final class APIError implements Serializable {
    private String error;

    public APIError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}

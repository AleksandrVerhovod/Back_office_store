package apitests.models;

public class UserData {
    public String status;
    public int code;
    public String message;


    public String getMessage() {
        return message;
    }

    public UserData(String status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}

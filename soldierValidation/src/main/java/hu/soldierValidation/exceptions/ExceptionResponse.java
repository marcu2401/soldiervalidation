package hu.soldierValidation.exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionResponse {
    private String time;
    private String message;
    private String details;

    public ExceptionResponse(Date time, String message, String details) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        this.time = format.format(time);
        this.message = message;
        this.details = details;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

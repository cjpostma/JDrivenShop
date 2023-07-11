package org.cjpostma.shop.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;

import java.util.Date;

public class WebError {

    private final Date timestamp = new Date();
    private final String message;

    public WebError(String message){
        this.message = message;
    }

    @JsonProperty("timeStamp")
    Date getTimestamp(){
        return this.timestamp;
    }

    @JsonProperty("message")
    @Nullable
    String getMessage(){
        return this.message;
    }
}
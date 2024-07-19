package br.com.investTracker.errors;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Data
public class ErrorResponse {
    private Date date = new Date();
    private String message;
    private String url;

    public ErrorResponse(String message, String url) {
        this.message = message;
        this.url = url.replace("url=", "");
    }
}

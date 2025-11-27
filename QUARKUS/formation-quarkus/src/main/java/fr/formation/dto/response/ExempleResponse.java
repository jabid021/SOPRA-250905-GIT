package fr.formation.dto.response;

public class ExempleResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExempleResponse(String message) {
        this.message = message;
    }
}

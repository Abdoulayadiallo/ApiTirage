package ml.freetirage.apitirage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ListePostulantException extends RuntimeException{
    public ListePostulantException(String message){
        super(message);
    }
}

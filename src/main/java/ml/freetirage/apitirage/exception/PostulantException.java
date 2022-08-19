package ml.freetirage.apitirage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PostulantException extends RuntimeException{
    public PostulantException(String message){
        super(message);
    }

}

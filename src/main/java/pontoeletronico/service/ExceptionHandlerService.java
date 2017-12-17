package pontoeletronico.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import pontoeletronico.exceptoin.APIException;
import pontoeletronico.exceptoin.PrivilegiosInsuficientesException;
import pontoeletronico.util.UtilAvisos;
import pontoeletronico.util.UtilConstantes;

@RestControllerAdvice
public class ExceptionHandlerService {

    @ExceptionHandler(value = { PrivilegiosInsuficientesException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public APIException unknownException(Exception ex, WebRequest req) {
        return new APIException(UtilConstantes.ERRO, UtilAvisos.PRIVILEGIOS_INSUFICIENTES);
    }
}

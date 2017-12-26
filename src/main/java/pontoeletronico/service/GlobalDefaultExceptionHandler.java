package pontoeletronico.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import pontoeletronico.entity.mensageria.MensagemRetorno;
import pontoeletronico.exception.ExcecaoInformativa;

@RestControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(value = { ExcecaoInformativa.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public MensagemRetorno exception(ExcecaoInformativa e) {
		return new MensagemRetorno(e.getCodigo(), e.getMensagem());
	}

}
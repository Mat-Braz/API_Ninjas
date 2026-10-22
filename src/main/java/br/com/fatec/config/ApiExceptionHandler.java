package br.com.fatec.config;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail validation(
            MethodArgumentNotValidException exception) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                "Verifique os campos informados.");

        Map<String, String> errors = new LinkedHashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(
                error -> errors.putIfAbsent(
                        error.getField(), error.getDefaultMessage()));

        problem.setProperty("campos", errors);
        return problem;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail conflict(
            DataIntegrityViolationException exception) {
        return ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT,
                "Os dados violam uma restrição do banco. "
                        + "Verifique os campos que devem ser únicos.");
    }
}

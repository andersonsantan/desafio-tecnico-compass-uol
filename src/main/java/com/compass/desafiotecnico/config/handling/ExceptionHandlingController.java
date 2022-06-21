package com.compass.desafiotecnico.config.handling;


import com.compass.desafiotecnico.service.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlingController.class);
    private MessageSource messageSource;

    public ExceptionHandlingController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorResponseForBinding> handle(MethodArgumentNotValidException exception) {
        LOGGER.error("Validation error");
        List<ErrorResponseForBinding> responseList = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        return buildValidationErrors(fieldErrors, responseList);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public List<ErrorResponseForBinding> handle(BindException exception) {
        LOGGER.error("Fields in your request are invalid");
        List<ErrorResponseForBinding> responseList = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        return buildValidationErrors(fieldErrors, responseList);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ServiceException.class)
    public GenericErrorResponse handleUseCaseException(final ServiceException e) {
        LOGGER.error("Service error");
        return GenericErrorResponse.builder()
                .message(e.getCause().getMessage())
                .build();
    }

    private List<ErrorResponseForBinding> buildValidationErrors(List<FieldError> fieldErrors, List<ErrorResponseForBinding> responseList) {
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorResponseForBinding erro = new ErrorResponseForBinding(e.getField(), mensagem);
            responseList.add(erro);
        });

        return responseList;
    }
}

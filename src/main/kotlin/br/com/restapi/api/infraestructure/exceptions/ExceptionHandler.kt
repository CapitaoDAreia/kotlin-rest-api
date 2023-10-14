package br.com.restapi.api.infraestructure.exceptions

import br.com.restapi.api.application.exceptions.NotFoundException
import br.com.restapi.api.infraestructure.exceptions.exceptionsDTO.ExceptionView
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.client.HttpServerErrorException.InternalServerError

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundExceptions(
        ex: NotFoundException,
        request: HttpServletRequest
    ): ExceptionView {
        return ExceptionView(
            message = ex.message,
            error = HttpStatus.NOT_FOUND.name,
            httpStatus = HttpStatus.NOT_FOUND.value(),
            path = request.servletPath,
        )
    }
}
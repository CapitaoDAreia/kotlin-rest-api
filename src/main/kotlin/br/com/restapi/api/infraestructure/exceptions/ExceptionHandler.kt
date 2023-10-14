package br.com.restapi.api.infraestructure.exceptions

import br.com.restapi.api.application.exceptions.NotFoundException
import br.com.restapi.api.infraestructure.exceptions.exceptionsDTO.ExceptionView
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

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

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMethodArgumentNotValidException(
        ex: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ExceptionView {
        val errorMessage = HashMap<String, String?>()
        ex.bindingResult.fieldErrors.forEach { e ->
            errorMessage[e.field] = e.defaultMessage
        }

        return ExceptionView(
            message = errorMessage.toString(),
            error = HttpStatus.BAD_REQUEST.name,
            httpStatus = HttpStatus.BAD_REQUEST.value(),
            path = request.servletPath,
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleInternalServerErrorException(
        ex: NotFoundException,
        request: HttpServletRequest
    ): ExceptionView {
        return ExceptionView(
            message = ex.message,
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            path = request.servletPath,
        )
    }
}
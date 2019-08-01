package com.brs.oa.controller;

import com.brs.oa.model.RestfulResultData;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.brs.oa.exception.UnAuthorizedException;
import com.brs.oa.model.RestfulResult;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionController {


    /**
     * 捕获其它异常
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestfulResult globalException(HttpServletRequest request, Throwable ex) {
        return new RestfulResult(getStatus(request).value(), ex.getMessage());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}


//    // 捕捉shiro的异常
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(ShiroException.class)
//    public RestfulResult handle401(ShiroException e) {
//        return new RestfulResult(403, e.getMessage());
//    }
//
//    // 捕捉UnauthorizedException
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(UnAuthorizedException.class)
//    public RestfulResult handle401() {
//        return new RestfulResult(403, "Unauthorized");
//    }




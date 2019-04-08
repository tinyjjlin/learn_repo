package com.brs.oa.comm.exception;


import com.brs.oa.comm.model.RestfulResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

/**
 * @author tiny lin
 * @date  2018/12/3
*/
@RestControllerAdvice
public class ExceptionControllerAdvice {


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
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.valueOf(statusCode);
    }

}




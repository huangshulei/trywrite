package com.example.trywrite.common;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice(annotations = {Controller.class, RestController.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理自定义的异常，为了让前端展示我们的异常信息，这里需要把异常进行全局捕获，然后返回给前端
     * @param exception
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandle(CustomException exception){
        log.error(exception.getMessage()); //报错记得打日志
        //这里拿到的message是业务类抛出的异常信息，我们把它显示到前端
        return R.error(exception.getMessage());
    }
}

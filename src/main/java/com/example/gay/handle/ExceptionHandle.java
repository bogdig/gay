package com.example.gay.handle;

import com.example.gay.domain.Result;
import com.example.gay.exception.GayException;
import com.example.gay.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(GayException.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GayException){
            GayException gayException = (GayException) e;
            return ResultUtil.error(gayException.getCode(), gayException.getMessage());
        }else{
            logger.info("【系统级异常】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}

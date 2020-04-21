package com.msr.servicebase.exception;


import com.msr.commonutils.ExceptionUtil;
import com.msr.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    //全局异常
    @ExceptionHandler
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("全局异常！");
    }
    //特定异常
    @ExceptionHandler
    @ResponseBody
    public R error(ArithmeticException e){
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();
        return R.error().message("特定异常！");
    }
    //自定义异常
    @ExceptionHandler
    @ResponseBody
    public R error(MSRException e){

        e.printStackTrace();
        return R.error().message(e.getMsg()).code(e.getCode());
    }
}

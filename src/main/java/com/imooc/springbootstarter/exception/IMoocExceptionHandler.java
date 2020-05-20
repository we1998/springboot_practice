package com.imooc.springbootstarter.exception;



import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author we
 * @date 2020/5/20 10:15
 */
//助手类
@ControllerAdvice
public class IMoocExceptionHandler {

    public  static final String IMOOC_ERROR_VIEW="error";

    //对异常进行捕获
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e)throws Exception{
        e.printStackTrace();
        ModelAndView mav= new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",request.getRequestURL());
        mav.setViewName(IMOOC_ERROR_VIEW);
        return mav;
    }
}

package com.imooc.springbootstarter.exception;

import javax.servlet.http.HttpServletRequest;

import com.imooc.springbootstarter.pojo.IMoocJSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class IMoocAjaxExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public IMoocJSONResult defaultErrorHandler(HttpServletRequest req,
											   Exception e) throws Exception {

		e.printStackTrace();
		return IMoocJSONResult.errorException(e.getMessage());
	}
}

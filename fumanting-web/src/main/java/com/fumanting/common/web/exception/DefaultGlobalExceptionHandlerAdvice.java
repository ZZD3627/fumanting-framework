package com.fumanting.common.web.exception;

import com.fumanting.common.core.entity.vo.Result;
import com.fumanting.common.core.exception.BaseException;
import com.fumanting.common.core.exception.SystemErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;

/**
 * @ClassName DefaultGlobalExceptionHandlerAdvice
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/7/26 19:45
 * @Version 1.0
 */
@Slf4j
@Order
@RestControllerAdvice
public class DefaultGlobalExceptionHandlerAdvice {


	@ExceptionHandler(value = {MissingServletRequestParameterException.class})
	public Result missingServletRequestParameterException(MissingServletRequestParameterException ex) {
		log.warn("missing servlet request parameter exception:{}", ex.getMessage());
		return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID);
	}


	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
	public Result argumentInvalidException(MethodArgumentNotValidException ex) {
		log.warn("service exception:{}", ex.getMessage());
		return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID, ex.getBindingResult().getFieldError().getDefaultMessage());
	}

	@ExceptionHandler(value = {HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException.class})
	public Result httpMessageConvertException(HttpMessageNotReadableException ex) {
		log.warn("http message convert exception:{}", ex.getMessage());
		return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID, "数据解析错误：" + ex.getMessage());
	}

	@ExceptionHandler(value = {MultipartException.class})
	public Result uploadFileLimitException(MultipartException ex) {
		log.warn("upload file size limit:{}", ex.getMessage());
		return Result.fail(SystemErrorType.UPLOAD_FILE_SIZE_LIMIT);
	}

	@ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public Result notSupportedMethodException(HttpRequestMethodNotSupportedException ex) {
		log.warn("http request method not supported exception {}", ex.getMessage());
		return Result.fail(SystemErrorType.METHOD_NOT_SUPPORTED);
	}

	@ExceptionHandler(value = {HttpMediaTypeNotSupportedException.class})
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	public Result notSupportedMethodException(HttpMediaTypeNotSupportedException ex) {
		log.warn("http request method not supported exception {}", ex.getMessage());
		return Result.fail(SystemErrorType.METHOD_NOT_SUPPORTED);
	}

	@ExceptionHandler(value = {BaseException.class})
	public Result baseException(BaseException ex) {
		log.error("base exception:{}", ex.getMessage());
		return Result.fail(ex.getErrorType());
	}

	@ExceptionHandler(value = {Exception.class, Throwable.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result exception(Throwable ex) {
		log.error("exception: ", ex);
		return Result.fail();
	}

}

package com.fumanting.common.web.exception;

import com.fumanting.common.core.entity.vo.Result;
import com.fumanting.common.core.exception.BaseException;
import com.fumanting.common.core.exception.SystemErrorType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.multipart.MultipartException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class DefaultGlobalExceptionHandlerAdviceTest {

	@Autowired
	private DefaultGlobalExceptionHandlerAdvice defaultGlobalExceptionHandlerAdvice;

	@BeforeEach
	public void before() {
		this.defaultGlobalExceptionHandlerAdvice = new DefaultGlobalExceptionHandlerAdvice();
	}

	@Test
	void missingServletRequestParameterException() {
		Result result = defaultGlobalExceptionHandlerAdvice
				.missingServletRequestParameterException(new MissingServletRequestParameterException("test", "string"));
		assertEquals(SystemErrorType.ARGUMENT_NOT_VALID.getCode(), result.getCode());
	}

	@Test
	void testUploadFileLimitException() {
		Result result = defaultGlobalExceptionHandlerAdvice.uploadFileLimitException(new MultipartException("test"));
		assertEquals(SystemErrorType.UPLOAD_FILE_SIZE_LIMIT.getCode(), result.getCode());
	}

	@Test
	void testServiceException() throws NoSuchMethodException {
		//准备数据
		MethodParameter methodParameter = new MethodParameter(Object.class.getMethod("toString"), -1);
		BindingResult bindingResult = mock(BindException.class);
		FieldError fieldError = new FieldError("test", "test", "testmessage");
		when(bindingResult.getFieldError()).thenReturn(fieldError);
		MethodArgumentNotValidException exception = new MethodArgumentNotValidException(methodParameter, bindingResult);
		//调用
		Result result = defaultGlobalExceptionHandlerAdvice.argumentInvalidException(exception);
		//验证
		assertEquals(SystemErrorType.ARGUMENT_NOT_VALID.getCode(), result.getCode());
		assertEquals("testmessage", result.getData());
	}

	@Test
	void testBaseException() {
		Result result = defaultGlobalExceptionHandlerAdvice.baseException(new BaseException(SystemErrorType.SYSTEM_BUSY));
		assertEquals(SystemErrorType.SYSTEM_BUSY.getCode(), result.getCode());
	}

	@Test
	void testException() {
		Result result = defaultGlobalExceptionHandlerAdvice.exception(new Exception("error"));
		assertEquals(SystemErrorType.SYSTEM_ERROR.getCode(), result.getCode());
	}

	@Test
	void testThrowable() {
		Result result = defaultGlobalExceptionHandlerAdvice.exception(new Throwable("error"));
		assertEquals(SystemErrorType.SYSTEM_ERROR.getCode(), result.getCode());
	}
}
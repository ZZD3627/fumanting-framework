package com.fumanting.common.core.exception;

import lombok.Getter;

/**
 * @ClassName BaseException
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/7/26 17:50
 * @Version 1.0
 */
@Getter
public class BaseException extends RuntimeException {
	/**
	 * 异常对应的错误类型
	 */
	private final ErrorType errorType;

	/**
	 * 默认是系统异常
	 */
	public BaseException() {
		this.errorType = SystemErrorType.SYSTEM_ERROR;
	}

	/**
	 * @param errorType 错误类型
	 */
	public BaseException(ErrorType errorType) {
		this.errorType = errorType;
	}

	/**
	 * @param errorType 错误类型
	 * @param message   错误信息
	 */
	public BaseException(ErrorType errorType, String message) {
		super(message);
		this.errorType = errorType;
	}

	/**
	 * @param errorType 错误类型
	 * @param message   错误信息
	 * @param cause     异常
	 */
	public BaseException(ErrorType errorType, String message, Throwable cause) {
		super(message, cause);
		this.errorType = errorType;
	}
}
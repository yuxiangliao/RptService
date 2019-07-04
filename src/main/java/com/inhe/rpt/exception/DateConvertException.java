package com.inhe.rpt.exception;

public class DateConvertException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorCode;
	
	
	public DateConvertException(){
		super();
	}
	
	/**
	 * 异常构造函数
	 * @param msg 异常的提示信息
	 * @param cause 异常信息
	 */
	public DateConvertException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	/**
	 * 异常构造函数
	 * @param errCode 错误码
	 * @param msg	错误信息
	 * @param cause	异常信息
	 */
	public DateConvertException(String errorCode, String message, Throwable cause) {
		this(message, cause);
		setErrorCode(errorCode);
	}
	/**
	 * 异常构造函数
	 * @param msg 异常的提示信息
	 */
	public DateConvertException(String message) {
		super(message);
	}

	/**
	 * 异常构造函数
	 * @param cause 异常信息
	 */
	public DateConvertException(Throwable cause) {
	    super(cause);
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	@Override
	public String toString() {
		String errorCode = getErrorCode();
		String s = (errorCode != null) ? errorCode + "--" + getClass().getName() : getClass().getName();
        String message = getLocalizedMessage();
        return (message != null) ? (s + ": " + message) : s;
	}
	
}

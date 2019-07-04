package com.inhe.rpt.exception;

/**
 * 
  * <p>Title: GxmisExceptionBase.java</p>
  * <p>Desc: 自定义异常基类</p>
  * <p>Copyright: @2010 Gxmis <a href="http://www.gxmis.com">Inhemeter</a></p>
  * @author <a href="mailto:sunlz@gxmis.com">孙立中</a>
  * @version 1.0.0.000 2010-11-22 上午10:03:54
 */
public class InheExceptionBase extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	
	public InheExceptionBase(){
		super();
	}
	
	/**
	 * 异常构造函数
	 * @param msg 异常的提示信息
	 * @param cause 异常信息
	 */
	public InheExceptionBase(String msg,Throwable cause){
		super(msg,cause);
	}
	
	/**
	 * 异常构造函数
	 * @param errCode 错误码
	 * @param msg	错误信息
	 * @param cause	异常信息
	 */
	public InheExceptionBase(String errorCode, String message, Throwable cause) {
		this(message, cause);
		setErrorCode(errorCode);
	}
	/**
	 * 异常构造函数
	 * @param msg 异常的提示信息
	 */
	public InheExceptionBase(String message) {
		super(message);
	}

	/**
	 * 异常构造函数
	 * @param cause 异常信息
	 */
	public InheExceptionBase(Throwable cause) {
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

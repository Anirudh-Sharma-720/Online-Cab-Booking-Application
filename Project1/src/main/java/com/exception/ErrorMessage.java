package com.exception;

import java.time.LocalDateTime;
public class ErrorMessage{
	private LocalDateTime date;
	private String errorMsg;
	private String validationMsg;
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getValidationMsg() {
		return validationMsg;
	}
	public void setValidationMsg(String validationMsg) {
		this.validationMsg = validationMsg;
	}
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(LocalDateTime date) {
		super();
		this.date = date;
	}
	public ErrorMessage(LocalDateTime date, String errorMsg) {
		super();
		this.date = date;
		this.errorMsg = errorMsg;
	}
	public ErrorMessage(LocalDateTime date, String errorMsg, String validationMsg) {
		super();
		this.date = date;
		this.errorMsg = errorMsg;
		this.validationMsg = validationMsg;
	}
	
}

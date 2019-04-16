package com.smart.helmet.smsnotification.dto;

import lombok.Data;

/**
 * The DTO class for sms server response.
 * 
 * @author Ritesh Sinha
 * @since 1.0.0
 *
 */
@Data
public class SmsServerResponseDto {
	/**
	 * Status for request.
	 */
	private String type;

	/**
	 * Response message
	 */
	private String message;

	/**
	 * Response code.
	 */
	private String code;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}

package com.smart.helmet.smsnotification.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart.helmet.notification.spi.SmsNotification;
import com.smart.helmet.smsnotification.dto.SmsRequestDto;
import com.smart.helmet.smsnotification.dto.SmsResponseDto;

/**
 * This controller class receives contact number and message in data transfer
 * object and sends SMS on the provided contact number.
 * 
 * @author Ritesh Sinha
 * @since 1.0.0
 */

@CrossOrigin
@RestController
public class SmsNotificationController {

	/**
	 * The reference that autowire sms notification service class.
	 */
	@Autowired
	SmsNotification<SmsResponseDto> smsNotifierService;

	/**
	 * This method sends sms to the contact number provided.
	 * 
	 * @param smsRequestDto
	 *            the request dto for sms-notification.
	 * @return the status and message as dto response.
	 */
	@PostMapping(value = "/smsnotifier/v1.0/sms/send")
	public ResponseEntity<SmsResponseDto> sendSmsNotification(@Valid @RequestBody SmsRequestDto smsRequestDto) {

		return new ResponseEntity<>(
				smsNotifierService.sendSmsNotification(smsRequestDto.getNumber(), smsRequestDto.getMessage()),
				HttpStatus.ACCEPTED);

	}
	
	@GetMapping(value = "/smsnotifier/v2.0/sms/send")
	public ResponseEntity<SmsResponseDto> sendSmsNotificationV2(@Valid @RequestParam (name="message")String  message,
			@RequestParam (name="number")String number) {
		SmsRequestDto smsRequestDto=new SmsRequestDto();
		smsRequestDto.setMessage(message);
		smsRequestDto.setNumber(number);
		return new ResponseEntity<>(
				smsNotifierService.sendSmsNotification(smsRequestDto.getNumber(), smsRequestDto.getMessage()),
				HttpStatus.ACCEPTED);

	}
	
}

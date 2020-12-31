package com.digi.unitouch;

public class ApplicationResponse {

	private Object payload;
	
	private Object payloadNext;
	
	private String message;

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public Object getPayloadNext() {
		return payloadNext;
	}

	public void setPayloadNext(Object payloadNext) {
		this.payloadNext = payloadNext;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}

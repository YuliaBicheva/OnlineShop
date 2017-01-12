package edu.bicheva.OnlineShop.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExceptionJSON {

	private Integer index;

	private String message;

	private String messageType;

	public ExceptionJSON() {
		this("","");
	}
	
	public ExceptionJSON(String message, String messageType) {
		this(null, message, messageType);
	}

	public ExceptionJSON(Integer index, String message, String messageType) {
		super();
		this.index = index;
		this.message = message;
		this.messageType = messageType;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

}

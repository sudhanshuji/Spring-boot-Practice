package com.luv2code.springdemo.rest;

public class StudentErrorResponse {
	private int status;
	private String messgae;
	private long timeStamp;

	public StudentErrorResponse(int status, String messgae, long timeStamp) {
		this.status = status;
		this.messgae = messgae;
		this.timeStamp = timeStamp;
	}

	public StudentErrorResponse() {
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the messgae
	 */
	public String getMessgae() {
		return messgae;
	}

	/**
	 * @param messgae the messgae to set
	 */
	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}

	/**
	 * @return the timeStamp
	 */
	public long getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}

package br.idea.project.resource.exception;

import java.io.Serializable;

public class BodyException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	private Integer status;
	
	public BodyException() {
		// TODO Auto-generated constructor stub
	}
	
	public BodyException(String msg, Integer status) {
		this.msg = msg;
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}

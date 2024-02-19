package com.kh.controller;

public class ModelAndView {
	// model 역활
	private String path;
	
	/*	boolean인 이유
	 	forward로 보내야하는 것을 방지하기 위해 redirect로 보낼지 말지에 대한 boolean까지 설정 => redirect, forward 둘 중 하나의 방식을 선택할 수 있음. */
	private boolean isRedirect;

	public ModelAndView() {
		super();
	}

	// forward 방식으로 보낼 경우
	public ModelAndView(String path) {
		this.path = path;
	}

	// sendRedirect 방식으로 보낼 경우 (true 값 같이 넘기면 됨)
	public ModelAndView(String path, boolean isRedirect) {
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}

package demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;

public class PayPalConfig {
	private String authToken;
	private String posturl;
	private String bussiness;
	private String returnurl;
	private String cancelurl;
	private String cmd;
	
	public PayPalConfig getConfig(HttpServletRequest request) {
		PayPalConfig pc=new PayPalConfig();
		try {
			pc.authToken=request.getServletContext().getInitParameter("authToken");
			pc.posturl=request.getServletContext().getInitParameter("posturl");
			pc.bussiness=request.getServletContext().getInitParameter("bussiness");
			pc.returnurl=request.getServletContext().getInitParameter("returnurl");
		} catch (Exception e) {
			pc=null;
		}
		return pc;
		
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getPosturl() {
		return posturl;
	}
	public void setPosturl(String posturl) {
		this.posturl = posturl;
	}
	public String getBussiness() {
		return bussiness;
	}
	public void setBussiness(String bussiness) {
		this.bussiness = bussiness;
	}
	public String getReturnurl() {
		return returnurl;
	}
	public void setReturnurl(String returnurl) {
		this.returnurl = returnurl;
	}
	public String getCancelurl() {
		return cancelurl;
	}
	public void setCancelurl(String cancelurl) {
		this.cancelurl = cancelurl;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
	
}

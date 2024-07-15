package PoJo;

import java.util.List;

import io.restassured.RestAssured;

public class Course_json {
	private List<webAutomation> webAutomation;
	private List<api> api;
	private List<mobile> mobile;
	
	public List<PoJo.webAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<PoJo.webAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<PoJo.api> getApi() {
		return api;
	}
	public void setApi(List<PoJo.api> api) {
		this.api = api;
	}
	public List<PoJo.mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<PoJo.mobile> mobile) {
		this.mobile = mobile;
	}
	
	

}

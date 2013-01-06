package com.sp.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class User extends AuditData implements InitializingBean, DisposableBean {
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("after properties set has been called for User bean");	
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy has been called for User bean");
	}
	
}

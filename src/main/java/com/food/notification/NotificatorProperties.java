package com.food.notification;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("notificator.email")
public class NotificatorProperties {
	
	/**
	 * Mail server host
	 */
	private String serverHost;
	
	/**
	 * Mail server port
	 */
	private Integer serverPort;
	
	public String getServerHost() {
		return serverHost;
	}
	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}
	public Integer getServerPort() {
		return serverPort;
	}
	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

}

package com.istv.auth.webservices.payer;

import javax.xml.ws.Endpoint;

public class WSPayerPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/payer", new WSPayerImpl());
	}
}

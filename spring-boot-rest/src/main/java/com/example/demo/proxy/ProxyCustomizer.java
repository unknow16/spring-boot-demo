package com.example.demo.proxy;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class ProxyCustomizer implements RestTemplateCustomizer{

	@Override
	public void customize(RestTemplate restTemplate) {
		String proxyHost = "183.232.231.172";
		int proxyPort = 80;
		
		HttpHost proxy = new HttpHost(proxyHost, proxyPort);
		HttpClient httpClient = HttpClientBuilder.create().setRoutePlanner(new DefaultProxyRoutePlanner(proxy){
			@Override
			protected HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context) throws HttpException {
				
				return super.determineProxy(target, request, context);
			}
		}).build();
		
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
		factory.setConnectTimeout(10000);
		factory.setReadTimeout(60000);
		restTemplate.setRequestFactory(factory);
	}

}

package com.uppi.poc.async;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class CustomHttpConnectionPool {
	private int maxConnection;
	private int maxrouteConnection;
	private int routePerConnection;
	private int restConnectionTimeOut;
	private int restReadTimeOut;
	private String connectionURL;
	
	 
	public void setMaxConnection(int maxConnection) {
		this.maxConnection = maxConnection;
	}


	public void setMaxrouteConnection(int maxrouteConnection) {
		this.maxrouteConnection = maxrouteConnection;
	}


	public void setRoutePerConnection(int routePerConnection) {
		this.routePerConnection = routePerConnection;
	}


	public void setRestConnectionTimeOut(int restConnectionTimeOut) {
		this.restConnectionTimeOut = restConnectionTimeOut;
	}


	public void setRestReadTimeOut(int restReadTimeOut) {
		this.restReadTimeOut = restReadTimeOut;
	}


	public void setConnectionURL(String connectionURL) {
		this.connectionURL = connectionURL;
	}


	public HttpClient createHttpPoolClient() {
		 PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		 connectionManager.setMaxTotal(maxConnection);
		  connectionManager
		    .setDefaultMaxPerRoute(maxrouteConnection);
		  connectionManager.setMaxPerRoute(new HttpRoute(new HttpHost(
				  connectionURL)), routePerConnection);
		  RequestConfig config = RequestConfig.custom()
				  .setConnectTimeout(restConnectionTimeOut)
				  .setConnectionRequestTimeout(restConnectionTimeOut)
				  .setSocketTimeout(restReadTimeOut).build();
		 return HttpClientBuilder.create()
				 .setConnectionManager(connectionManager)
				 .setDefaultRequestConfig(config)
				 .build();
		
		 
	}
	
	
}
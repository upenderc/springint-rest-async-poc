package com.uppi.poc.async;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;

public class LogRetryStateListener implements RetryListener {
	private static final Logger LOG = Logger.getLogger(LogRetryStateListener.class);
	
	@Override
	public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
		return true;
	}
	@Override
	public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback,
			Throwable throwable) {
		
	}
	@Override
	public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback,
			Throwable throwable) {
		LOG.info("Retrying {"+context.getRetryCount()+"} the message = "+((Message<?>)context.getAttribute("message")).getPayload());
	}

}

package com.uppi.poc.async;

import org.apache.log4j.Logger;

public class MessageConsumer {
	private static final Logger LOG = Logger.getLogger(MessageConsumer.class);
	public void onMessage(String message) {
		LOG.info(Thread.currentThread().getName()+" "+message);
	}
}

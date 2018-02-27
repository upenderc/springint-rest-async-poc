package com.uppi.poc.async;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class PubSubService {
  private static final Logger LOG = Logger.getLogger(PubSubService.class);
	@Autowired
	private RestServiceGateway serviceGw;
	
	public Message<String> recAndPublish(String message) throws InterruptedException, ExecutionException {
		Map<String,String> payload=new HashMap<>();
		payload.put("accountNumber", message);
		LOG.info("pubsub "+Thread.currentThread().getName()+" "+payload);
		return MessageBuilder.withPayload(serviceGw.send(payload).get()).build();
	}
}

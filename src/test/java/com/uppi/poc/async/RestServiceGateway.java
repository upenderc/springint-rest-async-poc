package com.uppi.poc.async;

import java.util.Map;
import java.util.concurrent.Future;

public interface RestServiceGateway {

	Future<String> send(Map<String, String>payload);
}

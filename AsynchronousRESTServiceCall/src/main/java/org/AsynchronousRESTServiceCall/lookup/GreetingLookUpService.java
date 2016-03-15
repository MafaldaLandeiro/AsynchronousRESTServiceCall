package org.AsynchronousRESTServiceCall.lookup;

import java.util.concurrent.Future;

import org.AsynchronousRESTServiceCall.response.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingLookUpService {
	private static final Logger log = LoggerFactory
			.getLogger(GreetingLookUpService.class);

	RestTemplate restTemplate = new RestTemplate();

	@Async
	public Future<Greeting> getGreeting(String name)
			throws InterruptedException {
		log.info("Looking up " + name);
		Greeting result = restTemplate.getForObject(
				"http://localhost:8080/getGreeting?name=".concat(name),
				Greeting.class);
		Thread.sleep(1000L);
		return new AsyncResult<Greeting>(result);
	}

}

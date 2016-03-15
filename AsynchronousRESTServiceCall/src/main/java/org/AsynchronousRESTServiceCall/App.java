package org.AsynchronousRESTServiceCall;

import java.util.concurrent.Future;

import org.AsynchronousRESTServiceCall.lookup.GreetingLookUpService;
import org.AsynchronousRESTServiceCall.response.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class App implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(App.class);

	@Autowired
	private GreetingLookUpService lookupService;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Clock
		long start = System.currentTimeMillis();

		// Multiple and asynchronous lookups
		Future<Greeting> greet1 = lookupService.getGreeting("Mafalda");
		Future<Greeting> greet2 = lookupService.getGreeting("Isabel");
		Future<Greeting> greet3 = lookupService.getGreeting("Teste");
		Future<Greeting> greet4 = lookupService.getGreeting("User");
		Future<Greeting> greet5 = lookupService.getGreeting("Spring");

		// Wait till they are all done
		while (!(greet1.isDone() && greet2.isDone() && greet3.isDone()
				&& greet4.isDone() && greet5.isDone())) {
			Thread.sleep(10);
		}

		log.info("Time: " + (System.currentTimeMillis() - start));
		log.info(greet1.get().toString());
		log.info(greet2.get().toString());
		log.info(greet3.get().toString());
		log.info(greet4.get().toString());
		log.info(greet5.get().toString());

	}
}

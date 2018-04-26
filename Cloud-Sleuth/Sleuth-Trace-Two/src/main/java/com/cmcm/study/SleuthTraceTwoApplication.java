package com.cmcm.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.sleuth.Span;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class SleuthTraceTwoApplication {

	private static final Logger logger = LoggerFactory.getLogger(SleuthTraceTwoApplication.class);

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/trace-2", method = RequestMethod.GET)
	public String getTrace(HttpServletRequest request) {
		logger.info("===call trace 2===, traceId={}, spanId={}",
                request.getHeader(Span.TRACE_ID_NAME), request.getHeader(Span.SPAN_ID_NAME));
		return "trace2";
	}


	public static void main(String[] args) {
		SpringApplication.run(SleuthTraceTwoApplication.class, args);
	}
}

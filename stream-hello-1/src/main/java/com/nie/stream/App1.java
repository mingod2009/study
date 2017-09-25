package com.nie.stream;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.rxjava.EnableRxJavaProcessor;
import org.springframework.cloud.stream.annotation.rxjava.RxJavaProcessor;
import org.springframework.context.annotation.Bean;

@EnableRxJavaProcessor
public class App1 {

	private static Logger logger = LoggerFactory.getLogger(App1.class);
//	@StreamListener(Processor.INPUT)
//	@SendTo(Processor.OUTPUT)
//	public Object receiveFromInput(Object user) {
//		logger.info("received : " + user);
//		return "From input channel Return - " + user;
//	}
	@Bean
	public RxJavaProcessor<String, String> processor() {
		return inputStream -> inputStream.map(data ->{
			logger.info("Received : " + data);
			return data;
		}).map(data -> String.valueOf("From input channel Return - " + data));
	}
}

package com.nie.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@EnableBinding(value={Sink.class, SinkSender.class})
public class SinkReceiver {

	private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);
	
	//@StreamListener(Sink.INPUT)
	public void receive(Object payload) {
		logger.info("Received : " + payload);
	}
}

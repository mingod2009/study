package com.nie.maven.account.email;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

public class AccountEmailServiceTest {
	
	private GreenMail greenMail;
	
	@Before
	public void setUp() throws Exception {
		greenMail = new GreenMail(ServerSetup.SMTP);
		greenMail.setUser("niemingsheng@126.com", "Loveme@5460");
		greenMail.start();
	}

	@After
	public void tearDown() throws Exception {
		greenMail.stop();
	}

	@Test
	public void test() throws AccountEmailException, InterruptedException, MessagingException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
		AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean("accountEmailService");
		String subJect = "Test subject";
		String htmlText = "<h3>Test</h3>";
		
		accountEmailService.sendMail("niemingsheng@126.com", subJect, htmlText);
		greenMail.waitForIncomingEmail(2000,1);
		Message[] msgs = greenMail.getReceivedMessages();
		System.out.println(msgs.length);
		
	}

}

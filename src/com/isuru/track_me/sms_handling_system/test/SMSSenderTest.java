package com.isuru.track_me.sms_handling_system.test;

import android.test.AndroidTestCase;

import com.isuru.track_me.sms_handling_system.SMSSender;

;

public class SMSSenderTest extends AndroidTestCase{
	
	SMSSender aSMSSender;

	@Override
	public void setUp() throws Exception {
		aSMSSender = new SMSSender();
	}

	public void testPreconditions() {
		assertNotNull(aSMSSender);
	}
	
	public void testSendSMS() {
		aSMSSender.sendSMS("0771556668", "This is a test");

	}

}

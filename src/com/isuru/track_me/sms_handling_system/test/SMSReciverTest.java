package com.isuru.track_me.sms_handling_system.test;

import static org.junit.Assert.*;
import com.android.internal.util.HexDump;

import org.junit.Before;
import org.junit.Test;
import android.telephony.SmsMessage;
import com.isuru.track_me.sms_handling_system.SMSReciever;

;

public class SMSReciverTest {
	String senderInfo, messageBody;
	SMSReciever aSMSmsReciever;

	@Before
	protected void setUp() throws Exception {
		senderInfo = null;
		messageBody = null;
		aSMSmsReciever = new SMSReciever();
	}

	@Test
	public void testGetIsTracking() {
		String pdu = "07914151551512f2040B916105551511f100006060605130308A04D4F29C0E";
		SmsMessage[] message = {
				SmsMessage.createFromPdu(HexDump.hexStringToByteArray(pdu)),
				SmsMessage.createFromPdu(HexDump.hexStringToByteArray(pdu)) };
		aSMSmsReciever.checkSMS(message);
		assertEquals(true, aSMSmsReciever.getIsTracking());

	}

}

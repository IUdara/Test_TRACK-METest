package com.isuru.track_me.location_tracking_system;

/**
 * @Author : Isuru Jayaweera
 * @email  : jayaweera.10@cse.mrt.ac.lk
 */

import org.junit.After;
import org.junit.Before;

import com.isuru.track_me.sms_handling_system.SMSSender;

import android.test.ServiceTestCase;

public class PositionNotifierTest extends ServiceTestCase<PositionNotifier> {

	private SMSSender smsSender;
	private PositionNotifier aPosNot;

	public PositionNotifierTest() {
		super(PositionNotifier.class);
		// TODO Auto-generated constructor stub
	}

	@Before
	public void setUp() throws Exception {
		smsSender = new SMSSender();
		aPosNot = new PositionNotifier();
	}

	public void testPreConditions() {
		assertTrue(smsSender != null);
		assertTrue(aPosNot != null);
	}
	
	@After
	public void tearDown() throws Exception {
		aPosNot.stopSelf();
	}

}

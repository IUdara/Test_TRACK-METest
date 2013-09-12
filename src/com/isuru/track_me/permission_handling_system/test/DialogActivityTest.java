package com.isuru.track_me.permission_handling_system.test;

/**
 * @Author : Isuru Jayaweera
 * @email  : jayaweera.10@cse.mrt.ac.lk
 */

import org.junit.After;
import org.junit.Before;

import com.isuru.track_me.permission_handling_system.DialogActivity;

import android.test.ActivityInstrumentationTestCase2;

public class DialogActivityTest extends
		ActivityInstrumentationTestCase2<DialogActivity> {

	private DialogActivity aDiagAct;

	public DialogActivityTest() {
		super(DialogActivity.class);
	}

	@Before
	public void setUp() throws Exception {
		aDiagAct = new DialogActivity();
	}

	public void testPreConditions() {
		assertTrue(aDiagAct != null);
	}

	@After
	public void tearDown() throws Exception {
		aDiagAct.finish();
	}
}

package com.isuru.track_me.test;

import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.test.ServiceTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;

import com.isuru.track_me.sms_handling_system.SMSManager;

public class SMSManagerTest extends ServiceTestCase<SMSManager> {
	private static final String TAG = "MyBindServerTest";
	Messenger mServer = null;

	public SMSManagerTest(Class<SMSManager> serviceClass) {
		super(SMSManager.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setUp() {
		try {
			super.setUp();
			Log.i(TAG, "setUp()");
			Intent bindIntent = new Intent(
					"com.isuru.track_me.sms_handling_system.SMSManager.START");
			IBinder binder = bindService(bindIntent);
			assertNotNull(binder);
			mServer = new Messenger(binder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void tearDown() {
		try {
			super.tearDown();
			Log.i(TAG, "tearDown()");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SmallTest
	public void testAHello() {
		Log.i(TAG, "testAHello");
		assertNotNull(mServer);
		Message msg = Message.obtain(null, MyBindServer.MSG_SAY_HELLO);
		Log.i(TAG, "sending SAY_HELLO");
		try {
			mServer.send(msg);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}

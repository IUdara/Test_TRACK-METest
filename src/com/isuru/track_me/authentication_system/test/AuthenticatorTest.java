package com.isuru.track_me.authentication_system.test;

/**
 * @Author : Isuru Jayaweera
 * @email  : jayaweera.10@cse.mrt.ac.lk
 */

import org.junit.After;
import org.junit.Before;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.isuru.track_me.R;
import com.isuru.track_me.authentication_system.Authenticator;

public class AuthenticatorTest extends
		ActivityInstrumentationTestCase2<Authenticator> {

	private Authenticator anAuth;
	private EditText mEmailView;
	private EditText mPasswordView;
	private View mLoginFormView;
	private View mLoginStatusView;
	private TextView mLoginStatusMessageView;
	private Button mSignin;

	public AuthenticatorTest() {
		super(Authenticator.class);
	}

	@Before
	public void setUp() throws Exception {
		// setActivityInitialTouchMode(false);

		anAuth = getActivity();

		mEmailView = (EditText) anAuth.findViewById(R.id.email);
		mPasswordView = (EditText) anAuth.findViewById(R.id.password);
		mLoginFormView = anAuth.findViewById(R.id.login_form);
		mLoginStatusView = anAuth.findViewById(R.id.login_status);
		mLoginStatusMessageView = (TextView) anAuth
				.findViewById(R.id.login_status_message);
		mSignin = (Button) anAuth.findViewById(R.id.sign_in_button);
	}

	public void testPreConditions() {
		assertTrue(mSignin != null);
		assertTrue(mEmailView != null);
		assertTrue(mPasswordView != null);
		assertTrue(mLoginFormView != null);
		assertTrue(mLoginStatusView != null);
		assertTrue(mLoginStatusMessageView != null);

	}

	@SmallTest
	public void testAuthenticator1() { // test for empty email and password

		anAuth.runOnUiThread(new Runnable() {
			public void run() {
				mSignin.requestFocus();
				mSignin.performClick();

			}
		});
		getInstrumentation().waitForIdleSync();
		assertEquals("This field is required", mPasswordView.getError()
				.toString());
		assertEquals("This field is required", mEmailView.getError().toString());
		assertNull(mLoginStatusMessageView.getEditableText());

	}

	@SmallTest
	public void testAuthenticator2() {

		anAuth.runOnUiThread(new Runnable() { // test for too short password
			public void run() {
				mEmailView.requestFocus();
				mEmailView.setText("abc@def.com");
				mPasswordView.requestFocus();
				mPasswordView.setText("aPW");
				mSignin.requestFocus();
				mSignin.performClick();

			}
		});
		getInstrumentation().waitForIdleSync();
		assertEquals("This password is too short", mPasswordView.getError()
				.toString());
		assertNull(mLoginStatusMessageView.getEditableText());

	}

	@SmallTest
	public void testAuthenticator3() { // test for invalid email identifying

		anAuth.runOnUiThread(new Runnable() {
			public void run() {
				mEmailView.requestFocus();
				mEmailView.setText("abcdef.com");
				mPasswordView.requestFocus();
				mPasswordView.setText("aPassword");
				mSignin.requestFocus();
				mSignin.performClick();

			}
		});
		getInstrumentation().waitForIdleSync();
		assertEquals("This email address is invalid", mEmailView.getError()
				.toString());
		assertNull(mLoginStatusMessageView.getEditableText());

	}

	@SmallTest
	public void testAuthenticator4() {

		anAuth.runOnUiThread(new Runnable() { // test for valid email and
												// password
			public void run() {
				mEmailView.requestFocus();
				mEmailView.setText("abc@def.com");
				mPasswordView.requestFocus();
				mPasswordView.setText("aPassword");
				mSignin.requestFocus();
				mSignin.performClick();

			}
		});
		getInstrumentation().waitForIdleSync();
		assertNull(mLoginStatusMessageView.getEditableText());

	}

	@After
	public void tearDown() throws Exception {
		anAuth.finish();
	}

}

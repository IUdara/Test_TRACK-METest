package com.isuru.track_me.permission_handling_system.test;

/**
 * @Author : Isuru Jayaweera
 * @email  : jayaweera.10@cse.mrt.ac.lk
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;

import com.isuru.track_me.permission_handling_system.Permission;
import com.isuru.track_me.permission_handling_system.PermissionManager;

import android.content.Context;
import android.test.ServiceTestCase;
import android.test.suitebuilder.annotation.SmallTest;

public class PermissionManagerTest extends ServiceTestCase<PermissionManager> {

	// private Permission aPermission;
	private PermissionManager aPermissionManager;

	public PermissionManagerTest() {
		super(PermissionManager.class);
		// TODO Auto-generated constructor stub
	}

	@Before
	public void setUp() throws Exception {
		aPermissionManager = new PermissionManager();
	}

	@SmallTest
	public void testExtractPermission() throws NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		String perm = "2013-09-11 02:30 2013-09-11 16:00";
		String phoneNo = "0771556668";

		// extractPermission() is private to PermissionManager
		// calling it using java.lang.reflect.Method
		Class<? extends PermissionManager> c = aPermissionManager.getClass();
		Method method = c.getDeclaredMethod("extractPermission", new Class[] {
				String.class, String.class });
		method.setAccessible(true);
		assertNotNull(method.invoke(aPermissionManager, new Object[] { perm,
				phoneNo }));
		assertEquals(
				phoneNo,
				((Permission) method.invoke(aPermissionManager, new Object[] {
						perm, phoneNo })).getOwner());

	}

	@SmallTest
	public void testGetContactName() throws NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		String phoneNo = "0771556668";

		// extractPermission() is private to PermissionManager
		// calling it using java.lang.reflect.Method
		Class<? extends PermissionManager> c = aPermissionManager.getClass();
		Method method = c.getDeclaredMethod("getContactName", new Class[] {
				Context.class, String.class });
		method.setAccessible(true);
		assertEquals("Isuru", method.invoke(aPermissionManager, new Object[] {
				this.mContext, phoneNo }));
	}

	@After
	public void tearDown() throws Exception {
		aPermissionManager.stopSelf();
	}

}

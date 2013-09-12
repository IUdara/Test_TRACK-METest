package com.isuru.track_me.permission_handling_system.test;

/**
 * @Author : Isuru Jayaweera
 * @email  : jayaweera.10@cse.mrt.ac.lk
 */

import static junit.framework.Assert.*;
import junit.framework.TestSuite;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.junit.Before;
import org.junit.Test;

import com.isuru.track_me.permission_handling_system.Permission;
import com.isuru.track_me.permission_handling_system.Place;

public class PermissionTest extends TestSuite {

	private Permission aPermission;
	private Place aPlace;
	private DateTime start;
	private DateTime end;
	private Period aPeriod;

	@Before
	public void setUp() throws Exception {
		int[][] dateTime = new int[][] { { 2013, 9, 13 }, { 15, 00 },
				{ 2013, 9, 13 }, { 18, 30 } };
		aPermission = new Permission(dateTime, "0771556668");

		start = new DateTime(2013, 9, 13, 15, 00);
		end = new DateTime(2013, 9, 13, 18, 30);

		aPermission.setPermissionCode("s2glr");

		aPlace = new Place("79.4532", "6.5432");
		aPermission.setDestination(aPlace);

		aPeriod = new Period(0, 10, 0, 0); // period of 10 minutes
		aPermission.setUpdatePeriod(aPeriod);
	}

	@Test
	public void testGetPermissionStart() {
		assertEquals(start, aPermission.getPermissionStart());
	}

	@Test
	public void testGetPermissionEnd() {
		assertEquals(end, aPermission.getPermissionEnd());
	}

	@Test
	public void testGetOwner() {
		assertEquals("0771556668", aPermission.getOwner());
	}

	@Test
	public void testGetPermissionCode() {
		assertEquals("s2glr", aPermission.getPermissionCode());
	}

	@Test
	public void testGetDestination() {
		assertEquals(aPlace, aPermission.getDestination());
	}

	@Test
	public void testGetUpdatePeriod() {
		assertEquals(aPeriod, aPermission.getUpdatePeriod());
	}

	@Test
	public void testGetIsPeriodic() {
		assertTrue(aPermission.getIsPeriodic());
	}

	@Test
	public void testGetIsDestinated() {
		assertTrue(aPermission.getIsDestinated());
	}

}

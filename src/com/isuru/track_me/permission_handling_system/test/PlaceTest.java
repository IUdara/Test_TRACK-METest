package com.isuru.track_me.permission_handling_system.test;

/**
 * @Author : Isuru Jayaweera
 * @email  : jayaweera.10@cse.mrt.ac.lk
 */

import static junit.framework.Assert.*;
import junit.framework.TestSuite;

import org.junit.Before;
import org.junit.Test;

import com.isuru.track_me.permission_handling_system.Place;

public class PlaceTest extends TestSuite {

	private Place aPlace;
	private Place bPlace;

	@Before
	public void setUp() throws Exception {
		aPlace = new Place("79.4532", "6.5432", "Gampaha");
		bPlace = new Place("79.4532", "6.5432");
	}

	@Test
	public void testGetLongitude() {
		assertEquals("79.4532", aPlace.getLongitude());
		assertEquals("79.4532", bPlace.getLongitude());
	}

	@Test
	public void testGetLatitude() {
		assertEquals("6.5432", aPlace.getLatitude());
		assertEquals("6.5432", bPlace.getLatitude());
	}

	@Test
	public void testGetCity() {
		assertEquals("Gampaha", aPlace.getCity());
		assertEquals(null, bPlace.getCity());
	}

}

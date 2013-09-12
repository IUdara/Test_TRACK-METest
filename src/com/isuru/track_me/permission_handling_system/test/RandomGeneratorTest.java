package com.isuru.track_me.permission_handling_system.test;

import static junit.framework.Assert.assertEquals;
import junit.framework.TestSuite;

import org.junit.Before;
import org.junit.Test;

import com.isuru.track_me.permission_handling_system.RandomGenerator;

public class RandomGeneratorTest extends TestSuite {

	RandomGenerator aRandomGen;

	@Before
	public void setUp() throws Exception {
		aRandomGen = new RandomGenerator(5);
	}

	@Test
	public void testNextString() {
		assertEquals(5, aRandomGen.nextString().length());
	}
}

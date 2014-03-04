package edu.wpi.rail.jrosbridge.messages.std;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestInt64 {

	private Int64 empty, i1;

	@Before
	public void setUp() {
		empty = new Int64();
		i1 = new Int64((long) 127);
	}

	@Test
	public void testConstructor() {
		assertEquals((long) 0, empty.getData());

		assertEquals("{\"data\":0}", empty.toString());

		assertEquals(1, empty.toJsonObject().size());
		assertEquals((long) 0,
				empty.toJsonObject().getJsonNumber(Int64.FIELD_DATA)
						.longValue());

		assertEquals(Int64.TYPE, empty.getMessageType());
	}

	@Test
	public void testLongConstructor() {
		assertEquals((long) 127, i1.getData());

		assertEquals("{\"data\":127}", i1.toString());

		assertEquals(1, i1.toJsonObject().size());
		assertEquals((long) 127,
				i1.toJsonObject().getJsonNumber(Int64.FIELD_DATA).longValue());

		assertEquals(Int64.TYPE, i1.getMessageType());
	}

	@Test
	public void testHashCode() {
		assertEquals(empty.toString().hashCode(), empty.hashCode());
		assertEquals(i1.toString().hashCode(), i1.hashCode());
	}

	@Test
	public void testEquals() {
		assertFalse(empty.equals(i1));
		assertFalse(i1.equals(empty));

		assertTrue(empty.equals(empty));
		assertTrue(i1.equals(i1));
	}

	@Test
	public void testEqualsWrongObject() {
		assertFalse(empty.equals(new String(empty.toString())));
	}

	@Test
	public void testClone() {
		Int64 clone = i1.clone();
		assertEquals(i1.toString(), clone.toString());
		assertEquals(i1.toJsonObject(), clone.toJsonObject());
		assertEquals(i1.getMessageType(), clone.getMessageType());
		assertEquals(i1.getData(), clone.getData());
		assertNotSame(i1, clone);
		assertNotSame(i1.toString(), clone.toString());
		assertNotSame(i1.toJsonObject(), clone.toJsonObject());
	}
}

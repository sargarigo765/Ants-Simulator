package ants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StartProgramTest
{
	protected static int value1;
	protected static int value2;
	String message = "Hello World";
	MessageUtil messageUtil = new MessageUtil(message);

	// assigning the values
	@BeforeAll
	public static void setUp()
	{
		value1 = 3;
		value2 = 3;
		System.out.println("JUnit test run: setUp, value1=" + value1 + ", value2=" + value2);
	}

	@Test
	void testJUintCorrectWorking()
	{
		// Ellenőrzés: két sztring egyenlő-e?
		String str = "Junit is working fine";
		assertEquals("Junit is working fine", str);
	}

	@Test
	public void testAddForTwoInitialisedValues()
	{
		// Ellenőrzés: az eredmény igaz?
		double result = value1 + value2;
		System.out.println("JUnit test run: testAddForTwoInitialisedValues, value1=" + value1 + ", value2=" + value2
				+ ", result=" + result);
		assertTrue(result == 6);
	}

	@Test
	public void testPrintMessage()
	{
		System.out.println("Inside testPrintMessage()");
		assertEquals(message, messageUtil.printMessage());
	}

	@Test
	public void testArrayElements()
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(42);
		list.add(-3);
		list.add(17);
		list.add(99);

		assertEquals(4, list.size());
		assertTrue(list.contains(-3));
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testResourcesAccess() throws IOException
	{
	/*	InputStream res = StartProgram.class.getResourceAsStream("/data/test.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(res));
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
	*/}
}

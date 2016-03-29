package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {
	private NewTelephoneCompany ntc;

	@Before
	public void setUp() throws Exception {
		ntc = new NewTelephoneCompany();
	}
	


	@Test
	public void testGetStartTime() {
		int startTime = 0;
		int result = ntc.getStartTime();
		assertEquals("Start time is " + startTime,result,startTime);
	}

	@Test
	public void testSetStartTime() {
		int startTime = 300;
		ntc.setStartTime(startTime);
		int result = ntc.getStartTime();
		assertEquals("Start time is now " + startTime,startTime,result);
	}

	@Test
	public void testGetDuration() {
		int expResult = 0;
        int result = ntc.getDuration();
        assertEquals("Length is" + expResult,expResult, result);
	}

	@Test
	public void testSetDuration() {
		int expResult = 40;
        ntc.setDuration(expResult);
        int result = ntc.getDuration();
        assertEquals("Length is now " + expResult,expResult, result);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case1() {
		ntc.setStartTime(-5);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case2() {
		ntc.setStartTime(-1);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case3() {
		ntc.setStartTime(2544);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case4() {
		ntc.setStartTime(2400);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case5() {
		ntc.setStartTime(2401);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case6() {
		ntc.setStartTime(1578);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case7() {
		ntc.setStartTime(1160);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case8() {
		ntc.setStartTime(1161);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case9() {
		ntc.setStartTime(799);
		ntc.setDuration(-5);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidDuration_Case1() {
		ntc.setStartTime(1800);
		ntc.setDuration(0);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidDuration_Case2() {
		ntc.setStartTime(1801);
		ntc.setDuration(-1);
		ntc.computeCharge();
	}
	
	@Test
	public void testComputeCharge_DiscountedStartAndDuration(){
		ntc.setStartTime(500);
		ntc.setDuration(100);
		double result = ntc.computeCharge();
		double expResult = 1768.0;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
		ntc.setStartTime(759);
		ntc.setDuration(61);
		result = ntc.computeCharge();
		expResult = 1078.48;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
		ntc.setStartTime(1959);
		ntc.setDuration(61);
		result = ntc.computeCharge();
		expResult = 1078.48;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
		ntc.setStartTime(2359);
		ntc.setDuration(65);
		result = ntc.computeCharge();
		expResult = 1149.20;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
	}
	
	@Test
	public void testComputeCharge_DiscountedStartTimeOnly(){
		ntc.setStartTime(0);
		ntc.setDuration(60);
		double expResult = 1248.00;
		double result = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
		ntc.setStartTime(400);
		ntc.setDuration(59);
		expResult = 1227.20;
		result = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
		ntc.setStartTime(759);
		ntc.setDuration(1);
		expResult = 20.80;
		result = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
		ntc.setStartTime(1800);
		ntc.setDuration(10);
		expResult = 208.00;
		result = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
		ntc.setStartTime(1801);
		ntc.setDuration(10);
		expResult = 208.00;
		result = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
		ntc.setStartTime(2359);
		ntc.setDuration(10);
		expResult = 208.00;
		result = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
	}
	
	@Test
	public void testComputeCharge_DiscountedDurationOnly(){
		ntc.setStartTime(800);
		ntc.setDuration(65);
		double expResult = 2298.40;
		double result = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
		ntc.setStartTime(900);;
		ntc.setDuration(61);
		expResult = 2156.96;
		result = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
		
	}
	
	@Test
	public void testComputeCharge_NoDiscounts(){
		ntc.setStartTime(1000);
		ntc.setDuration(40);
		double expResult = 1664.00;
		double result = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
		ntc.setStartTime(800);
		ntc.setDuration(1);
		expResult = 41.60;
		result = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
		ntc.setStartTime(801);
		ntc.setDuration(59);
		expResult = 2454.40;
		result = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
		ntc.setStartTime(1759);
		ntc.setDuration(60);
		expResult = 2496.00;
		result = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration() + expResult,expResult==result);
		
	}

}

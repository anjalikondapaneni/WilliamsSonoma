package com.min.range.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.min.range.pojo.Range;

public class MinRangeTest {

	@Test
	public void testSizeOfMinimumNoOfRanges(){
		Range range1 = new Range(1, 3);
		Range range2 = new Range(4,7);
		Range range3 = new Range(5,9);
		Range range4 = new Range(11, 13);
		
		MinRange service = new MinRange();
		service.minr(range1);
		service.minr(range2);
		service.minr(range3);
		service.minr(range4);
		
		assertEquals("Success Test Case for size of List", 2, service.getList().size());
		assertNotSame("Failure Test Case for size of List", 3, service.getList().size());
	}
	
	@Test
	public void testDataOfFinalZipcodes(){
		Range range1 = new Range(94133, 94133);
		Range range2 = new Range(94200,94299);
		Range range3 = new Range(94226,94399);
		
		MinRange service = new MinRange();
		service.minr(range1);
		service.minr(range2);
		service.minr(range3);
		
		Range finalRange1 = new Range(94133, 94133);
		Range finalRange2 = new Range(94200, 94399);
		service.getList().add(finalRange1);
		service.getList().add(finalRange2);
	
		assertEquals("Success Test Case for size of List", service.getList().size(), service.getList().size());
		assertNotSame("Failure Test Case for size of List", 3, service.getList().size());
		assertNotNull("Success Test for list not null", service.getList());
	}
}

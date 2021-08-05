package com.rest.training;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
class DataProvider1 {

	@DataProvider(name="data1")
	public Object[][] dp(){
		return new Object[][] {{2,3,5},{3,1,1}};
	}
	
	@Test(dataProvider="data1")
	public void sum(int a,int b,int r) {
		int sum=a+b;
Assert.assertEquals(r, sum);
		
	}
}

package com.mentoring.tests.listners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class MyListner implements IInvokedMethodListener {

	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		System.out.println("Execution of method " + arg0.getTestMethod().getMethodName() + " is completed");
		
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		System.out.println("Execution of method " + arg0.getTestMethod().getMethodName() + " started");
		
	}

}

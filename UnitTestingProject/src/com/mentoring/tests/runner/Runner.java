package com.mentoring.tests.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import com.mentoring.tests.listners.MyListner;

public class Runner {

	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG tng = new TestNG();
		tng.addListener(tla);
		tng.addListener(new MyListner());
		
		XmlSuite suite = new XmlSuite();
		suite.setName("Suite");
		List<String> files = new ArrayList<>();
		files.addAll(new ArrayList<String>() {
			{
				add("./testng.xml");
			}
		});
		suite.setSuiteFiles(files);
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		tng.setXmlSuites(suites);
		tng.run();

	}
}

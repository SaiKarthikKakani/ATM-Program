package com.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.utils.ReturnROICalculator;

/**
 * 
 * @author Sai Karthik
 *
 */
public class GetROI {

	public static void main(String[] args) throws IOException {
		// Importing the Properties file
		File propFile = new File("resources/ProjectDetails.properties");
		
		// Reading the Project details
		BufferedReader projProps = new BufferedReader(new FileReader(propFile));
		
		// Loading properties
		Properties props = new Properties();
		props.load(projProps);
		
		// Calculating ROI
		double roi = ReturnROICalculator.giveROI(props);
		System.out.println("The ROI on the project " + props.getProperty("ProjectName") + " is: " + roi + '%');

	}

}

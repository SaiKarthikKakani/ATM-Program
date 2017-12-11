package com.utils;

import java.util.Properties;

public class ReturnROICalculator {
	/*ROI = Cost of manual testing - (Framework set up + Scenarios development + Execution + Result analysis)
	 * 		-------------------------------------------------------------------------------------------------
	 *				(Framework set up + Scenarios development + Execution + Result analysis)
	 */
	
	public static double giveROI(Properties props) {
		int manualTestingCost = Integer.parseInt(props.getProperty("ManualCost")) * 
				Integer.parseInt(props.getProperty("ProjectDuration")) * 52;
		
		double automationTestDevCost = Integer.parseInt(props.getProperty("AutomationFrameworkSetupCost")) + 
				(Integer.parseInt(props.getProperty("AutomationScenarioDevCost")) * 0.5 * 52);
		
		int automationTestExecCost = Integer.parseInt(props.getProperty("AutomationExecutionCost")) *
				Integer.parseInt(props.getProperty("ProjectDuration")) * 52;
		
		double roi = (manualTestingCost - (automationTestDevCost + automationTestExecCost)) / 
				(automationTestDevCost + automationTestExecCost);
		
		return roi * 100;
	}
}

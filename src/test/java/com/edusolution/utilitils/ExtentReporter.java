package com.edusolution.utilitils;

import com.aventstack.extentreports.ExtentReports;   
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.edusolution.base.CommonMethods;

public class ExtentReporter extends CommonMethods {
	
	static ExtentSparkReporter htmlreport;
	static ExtentReports report;
	
	public static ExtentReports initReport() {
		htmlreport=new ExtentSparkReporter(homepath+"\\src\\test\\resources\\Reports\\ExtentReport_"+getDateTimeinMins()+".html");
		htmlreport.config().setDocumentTitle("Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		return report;		
	}

}

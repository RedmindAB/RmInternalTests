package se.redmind.rmtest.report.utils;

public class ErrorMsg {
	
	//assertEquals error message
	public static final String LegendListTextIsDifferent = "\n Expected text in legend list does not match the actual text; \n See this assert: \n";
	
	public static final String LegendListSize = "\n Expected amount of rows in legend list does not match the actual amount of rows; \n";
	
	public static final String LegendListDown = "\n Test failed because: \n"
			+ "1) Did not move DOWN in legend list \n"
			+ " or \n"
			+ "2) The legend list number did not update after moving DOWN in the legend list. \n"
			+ " Legend list number; \n";
	public static final String LegendListUp = "Test failed because: \n"
			+ "1) Did not move UP in legend list \n"
			+ " or \n"
			+ "2) The legend list number did not update after moving UP in the legend list. \n"
			+ " Legend list number; \n";
	
	//assertEquals error message
	public static final String ChartTitleIsDifferent = "\n Expected chart title differs from actual chart title. \n See this assert: ";
	//assertNotEquals error message
	public static final String ChartTitleIsSame = "\n Expected chart title does NOT differ from actual chart title. \n See this assert: ";
	
	public static final String HighchartsTitle = "Expected text in the highcharts title differs from the actual text; \n";
	public static final String HighchartsSubTitle = "\n Expected text in the highcharts (sub)title differs from the actual text; \n";
	
	public static final String PageRedirect = "\n Was not redirected to expected page.";
}

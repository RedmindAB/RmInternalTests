package se.redmind.rmtest.report.utils;

public class ErrorMsg {
	
	public static final String LegendListText = "\n Expected text in legend list does not match the actual text; \n";
	public static final String LegendListTextFirst = "\n First expected text in legend list does not match the first actual text; \n";
	public static final String LegendListTextSecond = "\n Second expected text in legend list does not match the second actual text; \n";
	
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
	
//	public static final String ChartTitleFirst = "\n First expected chart title differs from first actual chart title \n";
//	public static final String ChartTitleSecond = "\n Second expected chart title differs from second actual chart title \n";
//	public static final String ChartTitleThird = "\n Third expected chart title differs from third actual chart title \n";
	
	public static final String HighchartsTitle = "Expected text in the highcharts title differs from the actual text; \n";
	public static final String HighchartsSubTitle = "\n Expected text in the highcharts (sub)title differs from the actual text; \n";
	
	public static final String PageRedirect = "\n Was not redirected to expected page.";
}

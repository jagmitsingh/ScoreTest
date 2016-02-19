package com.soccer.league.automation.framework.frameworkUtils.XMLParser;


import org.dom4j.*;

import java.io.File;
import java.io.IOException;
import org.dom4j.io.SAXReader;


public class DomParser {
	
	private String dataFile;
	private SAXReader reader;
	private Document doc;
	private static final String NODE_PATH = "/TestSuite/TestCase";
	private File dir1 = new File(".");
	private String strBasePath = dir1.getCanonicalPath();
	private String file_path = strBasePath + File.separator + "src" + File.separator + "main" + File.separator + "resources"
			+ File.separator + "EPL_dataStore";

	/**
	 * Create an XML parser to parse the given test data file 
	 * @param dataFile           The test data file to be parsed
	 * @throws DocumentException  
	 * @throws IOException
	 */
	public DomParser(String dataFile) throws DocumentException, IOException {

		this.dataFile = file_path + File.separator + dataFile;
		reader = new SAXReader();
		doc = reader.read(this.dataFile);
	}

	
	public String getRootNode() {
		return doc.getRootElement().getName();
	}

	/**
	 * Method to check if the attribute value exists in the xml file
	 * @param node    The node for which the attribute should checked
	 * @param id      The attribute value 
	 * @return        True if the attribute value matches the id
	 */
	public boolean isAttriVal(Element node, String id) {
		Attribute attr = node.attribute("id");
		String node_val = attr.getValue();
		if (node_val == id)
			return true;
		return false;
	}

    
	/**
	 * Method to obtain the test data node (contains all the test case data)
	 * @param testCase_ID   Unique ID assigned to each test case
	 * @return              Test case node 
	 */
	
	public Node getNode(String testCase_ID){
		
		return doc.selectSingleNode(NODE_PATH + "[@id='" + testCase_ID + "']");
	}

	/**
	 * Method to obtain the test data for a given test case and input parameter  
	 * @param testCase_ID    The unique ID assigned to each test case     
	 * @param field          The parameter to retrieve
	 * @return               Value of the parameter 
	 */

	public String getData(String testCase_ID, String field){

		Node value = doc.selectSingleNode(NODE_PATH + "[@id='" + testCase_ID + "']");
		return value.selectSingleNode(field).getText(); 
	}
	
	/**
	 * Method to obtain the test data based on the NODE and parameter data
	 * @return   Value of the parameter
	 */
	
	public String getDataByNode(Node testCase, String field){
		
		return testCase.selectSingleNode(field).getText();
	}	

	
	

}

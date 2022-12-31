package jt.data;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Excel {


	private static final Fillo fillo= new Fillo();
	private static final String excelpath="src/test/resources/testdata/contentdata.xlsx";
	static Connection connection=null;

	static {
		try {
			connection= fillo.getConnection(excelpath);
		} catch (FilloException e) {

			e.printStackTrace();
		}
	}

	synchronized public static Recordset getData(String sheetName, String recordID) throws FilloException {


		String strQuery=String.format("Select * from %s Where RecordID=%s", sheetName, recordID);
		return connection.executeQuery(strQuery);
	}
	synchronized public static LoginPageData getLoginPageContent(String recordID) {
		
		Recordset loginContentRecords=null;
		LoginPageData loginPageData= new LoginPageData();
		
		try {
			
			loginContentRecords=getData("login", recordID);
			
			while(loginContentRecords.next()) {
				
				String logintext=loginContentRecords.getField("login");
				
				loginPageData.setLogin(loginContentRecords.getField("login"));
				loginPageData.setUsernaneText(loginContentRecords.getField("usernameText"));
				loginPageData.setPasswordText(loginContentRecords.getField("passwordText"));
				loginPageData.setPass(loginContentRecords.getField("user"));
				loginPageData.setPass(loginContentRecords.getField("pass"));
				loginPageData.setErrorMessage(loginContentRecords.getField("errorMessage"));
				loginPageData.setUsername(loginContentRecords.getField("username"));
				loginPageData.setPassword(loginContentRecords.getField("password"));
			}
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginContentRecords.close();
		return loginPageData;
		
	}
	
	

}

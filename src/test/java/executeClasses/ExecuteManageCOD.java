package executeClasses;

import java.util.List;

import javax.swing.text.Utilities;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageCODPage;



public class ExecuteManageCOD extends BaseClass {
	LoginPage login;
	ManageCODPage manageCOD;
  @Test
  public void verifyUserAbleToEditCODInformation() {
	  login=new LoginPage(driver);
	  manageCOD=new ManageCODPage(driver);
	  List<String> loginList = login.getLoginData();
	  login.enterUsername(loginList.get(0));
	  login.enterPassword(loginList.get(1));
	  login.clickSignin();
	  manageCOD.clickManageCODTab();
	  manageCOD.clickYesRadioButton();
	  manageCOD.clickSaveButton();
	  String actualResult=manageCOD.getAttributeValueOfSuccessMessage();
	  String expectedResult=manageCOD.getExpectedValue();
	  Assert.assertEquals(actualResult, expectedResult);
	  
		  
	  }
	  
  }
  


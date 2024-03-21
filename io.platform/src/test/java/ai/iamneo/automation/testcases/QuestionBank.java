package ai.iamneo.automation.testcases;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ai.iamneo.automation.elements.BvtElements;



public class QuestionBank extends LaunchBrowser {
	static Properties prop = new Properties();
	public static String QB_name;
	public static String testName;
	public static String qb_campus;
	public static String emailID;
	public static String password;
    public static String courseName;
	@BeforeTest
	void initialize() throws IOException {
		FileInputStream fis = new FileInputStream("../io.platform/src/test/java/Properties/data.properties");
		prop.load(fis);
		PageFactory.initElements(driver, BvtElements.class);
	}

	@Test(priority = 1)
	public static void admin_Login_with_valid_cridentials() throws IOException, InterruptedException {
		String uname = prop.getProperty("Username");
		String pass1 = prop.getProperty("password");
		BvtElements.user_name.sendKeys(uname);
		BvtElements.pass.sendKeys(pass1);
		BvtElements.login_btn.click();
	}

	@Test(priority = 2)
	public static void admin_Homepage_validation() throws IOException {
		String hp_url = prop.getProperty("HomepageURL");
		Reusability.Waits.elementToBeClickable(driver, BvtElements.dashboard_icon);
		String current_url = driver.getCurrentUrl();
		assertEquals(current_url, hp_url);
	}

	@Test(priority = 3)
	public static void clickCourseMenu() {
		driver.navigate().to("https://admin.kscollege408.examly.io/dashboard");
		Reusability.Waits.elementToBeClickable(driver, BvtElements.courseMenu);
		BvtElements.courseMenu.click();
	}

	@Test(priority = 4)
	public static void clickCourseCreationBtn() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.courseCreationBtn);
		BvtElements.courseCreationBtn.click();
	}

	@Test(priority = 5)
	public static void fillTheCourseName() throws Exception {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.courseName);
		BvtElements.courseName.click();
		courseName = Reusability.single_mail_id_generator.generate_section_name();
		BvtElements.courseName.sendKeys(courseName);
	}

	@Test(priority = 6)
	public static void selectPublishingType() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.selectPublishType);
		BvtElements.selectPublishType.click();
		String Pt = prop.getProperty("PublishinType");
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.publishingTypes, Pt);
	}

	@Test(priority = 7)
	public static void selectSharedType() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.sharedType);
		BvtElements.sharedType.click();
		try {
			Reusability.Waits.visibilityAllelements(driver, BvtElements.publishingTypes);
		} catch (Exception e) {
			Reusability.Waits.visibilityAllelements(driver, BvtElements.publishingTypes);
		}
		String St = prop.getProperty("SharedType");
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.publishingTypes, St);
	}

	@Test(priority = 8)
	public static void selectPretextForCourse() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.selectPreText);
		BvtElements.selectPreText.click();
		String Spt = prop.getProperty("Pretext");
		try {
			Reusability.Waits.visibilityAllelements(driver, BvtElements.selectPreTextList);
			Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.selectPreTextList, Spt);
		} catch (Exception e) {
			Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.selectPreTextList, Spt);
		}
	}

	@Test(priority = 9)
	public static void fillPublishingText() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.publishingText);
		BvtElements.publishingText.click();
		BvtElements.publishingText.clear();
		String pt = prop.getProperty("PublishingText");
		BvtElements.publishingText.sendKeys(pt);
	}

	@Test(priority = 10)
	public static void selectCourseValidityType() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.scheduletype);
		BvtElements.scheduletype.click();
	}

	@Test(priority = 11)
	public static void selectCourseValidityOfStartPeriod() {
		Reusability.JS_Executor.scrollToelement(driver, BvtElements.chooseStartdate);
		BvtElements.chooseStartdate.click();
		String Sd = prop.getProperty("Date");
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.dateList, Sd);
	}

	@Test(priority = 12)
	public static void selectCourseValidityOfEndPeriod() throws InterruptedException {
		Reusability.JS_Executor.scrollToelement(driver, BvtElements.chooseEndDate);
		BvtElements.chooseEndDate.click();
		try {
			Reusability.Waits.elementToBeClickable(driver, BvtElements.datePickerRightArrow);
			BvtElements.datePickerRightArrow.click();
		} catch (Exception e) {
			BvtElements.datePickerRightArrow.click();
		}
		String Ed = prop.getProperty("Date");
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.dateList, Ed);
	}

	@Test(priority = 13)
	public static void selectCampusForCourse() throws InterruptedException {
		Reusability.JS_Executor.scrollToelement(driver, BvtElements.chooseCampus);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.chooseCampus);
		BvtElements.chooseCampus.click();
		Reusability.Waits.visibilityAllelements(driver, BvtElements.testCampusList);
		String Cn = prop.getProperty("Campus");
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.testCampusList, Cn);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.courseDetailsPageDownArrow);
		BvtElements.courseDetailsPageDownArrow.click();
	}

	// @Test(priority = 14)
	public static void selectDepartmentForCourse() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.selectDepartmentdropdown);
		Reusability.JS_Executor.scrollToelement(driver, BvtElements.selectDepartmentdropdown);
		BvtElements.selectDepartmentdropdown.click();
		String Scd = prop.getProperty("CourseDepartment");
		try {
			Reusability.Waits.visibilityAllelements(driver, BvtElements.courseDepartmentList);
			Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.courseDepartmentList, Scd);
		} catch (Exception e) {
			Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.courseDepartmentList, Scd);
		}
		Reusability.Waits.elementToBeClickable(driver, BvtElements.courseDetailsPageDownArrow);
		BvtElements.courseDetailsPageDownArrow.click();
	}

	@Test(priority = 15)
	public static void selectBatchForCourse() throws InterruptedException {
		Reusability.JS_Executor.scrollToelement(driver, BvtElements.selectBatchDropdown);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.selectBatchDropdown);
		BvtElements.selectBatchDropdown.click();
		String Scb = prop.getProperty("Batch");
		try {
			Reusability.Waits.visibilityAllelements(driver, BvtElements.courseBatchList);
			Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.courseBatchList, Scb);
		} catch (Exception e) {
			Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.courseBatchList, Scb);
		}
		Reusability.Waits.elementToBeClickable(driver, BvtElements.courseDetailsPageDownArrow);
	}

	@Test(priority = 16)
	public static void saveTheCourseDetailsAndMovetoModulesSection() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.saveAndNextBtn);
		BvtElements.saveAndNextBtn.click();
	}

	@Test(priority = 17)
	public static void addNewModuleAndEnterModuleNAme() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.addNewModule);
		BvtElements.addNewModule.click();
		Reusability.Waits.elementToBeClickable(driver, BvtElements.moduleName);
		BvtElements.moduleName.click();
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		BvtElements.moduleName.sendKeys(selectAll);
		BvtElements.moduleName.sendKeys(Keys.DELETE);
		String Sn = prop.getProperty("SectionName");
		BvtElements.moduleName.sendKeys(Sn);
		BvtElements.moduleName.sendKeys(Keys.RETURN);
	}

	@Test(priority = 18)
	public static void addTestToTheCourseModule() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.addTestBtnOption);
		BvtElements.addTestBtnOption.click();
		Reusability.Waits.elementToBeClickable(driver, BvtElements.searchTestName);
		BvtElements.searchTestName.click();
		BvtElements.searchTestName.sendKeys("DemoTest133");
		BvtElements.searchTestName.sendKeys(Keys.RETURN);
		for (WebElement ele : BvtElements.testNamelisting) {
			for (WebElement ele1 : BvtElements.addTestbtn) {
				String testname = ele.getText();
				if (testname.equalsIgnoreCase("DemoTest133")) {
					ele1.click();
				}
			}
		}
		Thread.sleep(4000);
		BvtElements.testContentCloseBtn.click();
		Reusability.Waits.elementToBeClickable(driver, BvtElements.saveAndNextBtn);
		BvtElements.saveAndNextBtn.click();
		// BvtElements.saveAndNextBtn.click();
	}

	@Test(priority = 19)
	public static void clickSaveAndNextBtnAndGoToPublishScreen() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.lockTestName);
		BvtElements.lockTestName.click();
		Reusability.Waits.elementToBeClickable(driver, BvtElements.saveAndNextBtn);
		BvtElements.saveAndNextBtn.click();
	}

	@Test(priority = 20)
	public static void publishCourse() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.coursePublishBtn);
		BvtElements.coursePublishBtn.click();
	}

	@Test(priority = 21)
	public static void moveToInviteStudentPage() throws InterruptedException {
		try {
			Reusability.Waits.elementToVisibility(driver, BvtElements.addBtn);
			BvtElements.addBtn.click();
		} catch (Exception e) {
			Reusability.Waits.elementToVisibility(driver, BvtElements.addBtn);
			BvtElements.addBtn.click();
		}
	}

	@Test(priority = 22)
	public static void selectStudentForEnrollment() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.searchBy);
		BvtElements.searchBy.click();
		Reusability.Waits.visibilityAllelements(driver, BvtElements.searchByList);
		String sName = prop.getProperty("SearchName");
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.searchByList, sName);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.searchBox);
		BvtElements.searchBox.click();
		emailID = prop.getProperty("emailID");
		BvtElements.searchBox.sendKeys(emailID);
		BvtElements.searchBox.sendKeys(Keys.RETURN);
		Reusability.Waits.visibilityAllelements(driver, BvtElements.studentList);
		for (WebElement ele : BvtElements.studentList) {
			ele.click();
		}
		Reusability.Waits.elementToBeClickable(driver, BvtElements.enrollBtn);
		BvtElements.enrollBtn.click();
		Reusability.Waits.elementToBeClickable(driver, BvtElements.enrollConfirmYesBtn);
		BvtElements.enrollConfirmYesBtn.click();
		Reusability.Waits.elementToBeClickable(driver, BvtElements.closeEnrollPage);
		BvtElements.closeEnrollPage.click();
	}

	@Test(priority = 23)
	public static void publishTheCourse() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.publishBtn);
		BvtElements.publishBtn.click();

	}

	@Test(priority = 24)
	public static void studentPortalLogin() {
		String sURL = prop.getProperty("StudentURL");
		driver.navigate().to(sURL);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.bot);
		BvtElements.bot.click();
		BvtElements.username.sendKeys(emailID);
		BvtElements.username.sendKeys(Keys.RETURN);
		password = prop.getProperty("Password");
		BvtElements.password.sendKeys(password);
		String passwordCheck = BvtElements.password.getText();
		System.out.println(passwordCheck);
		if (passwordCheck.isEmpty()) {
			BvtElements.password.clear();
			BvtElements.password.sendKeys(password);
			BvtElements.password.sendKeys(Keys.RETURN);
		}
	}
	
	@Test(priority = 25)
	public static void Course_selection() {
		String menuName = prop.getProperty("Menu");
		for(WebElement list: BvtElements.Side_Menus) {
			String menu = list.getText();
			System.out.println(menu);
			if(menu.equalsIgnoreCase(menuName)) {
				list.click();
			}
		}
		BvtElements.SearchBox.sendKeys(courseName);
		BvtElements.SearchBox.sendKeys(Keys.RETURN);
		BvtElements.Coursecard.click();	
	}
	
	@Test(priority = 26)
	public static void Test_taking() throws InterruptedException {
	    BvtElements.btn_txt.click();
	    BvtElements.agree_Proceed_btn.click();
	}
    
	@Test(priority = 27)
    public static void MCQ_single_Question() throws InterruptedException {
		String MCQSingleOption = prop.getProperty("MCQSingleOption");
		Reusability.Waits.visibilityAllelements(driver, BvtElements.Ans_options);
    	Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.Ans_options, MCQSingleOption);
    	BvtElements.Next_btn.click();
    }
	
	//@Test(priority = 28)
	public static void MCQ_multiple_Question() {
		String MCQMultiOption = prop.getProperty("MCQMultiOption");
		Reusability.Waits.visibilityAllelements(driver, BvtElements.Ans_options);
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.Ans_options, MCQMultiOption);
		BvtElements.Next_btn.click();
	}
	
	
	@Test(priority = 29)
	public static void submit_test() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.Submit_Test_btn);
		Reusability.JS_Executor.ClickElement(driver,BvtElements.Submit_Test_btn);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.End_textbox);
		BvtElements.End_textbox.sendKeys("End");
		BvtElements.Yes_btn.click();
	}
	@Test(priority = 30)
	public static void course_details_page() {
		Reusability.Waits.elementToVisibility(driver, BvtElements.btn_txt);
		System.out.println(BvtElements.attempt_count.getText());
	}	

}

package ai.iamneo.automation.testcases;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.message.ReusableParameterizedMessage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ai.iamneo.automation.elements.*;

public class BvtSuite extends LaunchBrowser {
	static Properties prop = new Properties();
	public static String QB_name;
	public static String testName;
	public static String qb_campus;
	public static String val;
	public static String emailID;
	public static String password;
	public static String courseName;

	@BeforeTest
	void initialize() throws IOException {
		FileInputStream fis = new FileInputStream("../io.platform/src/test/java/Properties/data.properties");
		prop.load(fis);
		PageFactory.initElements(driver, BvtElements.class);
		BvtSuite suite = new BvtSuite();
		
	}

	@Test(priority = 1)
	public void adminLoginWithValidCridentials() throws IOException, InterruptedException {
		String uname = prop.getProperty("Username");
		String pass1 = prop.getProperty("password");
		BvtElements.user_name.sendKeys(uname);
		BvtElements.pass.sendKeys(pass1);
		BvtElements.login_btn.click();
	}

	@Test(priority = 2)
	public static void adminHomepageValidation() throws IOException {
		String hp_url = prop.getProperty("HomepageURL");
		Reusability.Waits.elementToBeClickable(driver, BvtElements.dashboard_icon);
		String current_url = driver.getCurrentUrl();
		assertEquals(current_url, hp_url);
	}

	@Test(priority = 3)
	public static void clickManageStudentPage() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.manage_tab);
		try {
			Reusability.Action_Class.moveToTwoElement(driver, BvtElements.manage_tab, BvtElements.manage_students);
			
		} catch (Exception e) {
			Reusability.Action_Class.moveToTwoElement(driver, BvtElements.manage_tab, BvtElements.manage_students);

		}
	}

	@Test(priority = 4)
	public static void clickStudentInviteButton() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.add_btn);
		BvtElements.add_btn.click();
	}

	@Test(priority = 5)
	public static void selectCampus() {
		String campus = prop.getProperty("Campus");
		Reusability.Waits.elementToBeClickable(driver, BvtElements.Select_Campus);
		BvtElements.Select_Campus.click();
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.Campus_list, campus);
	}

	@Test(priority = 6)
	public static void selectBatch() {
		String batch = prop.getProperty("Batch");
		Reusability.Waits.elementToBeClickable(driver, BvtElements.Select_batch);
		BvtElements.Select_batch.click();
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.Batch_list, batch);
	}

	@Test(priority = 7)
	public static void selectDegreeSpecialization() {
		String degree = prop.getProperty("degree&spec");
		Reusability.Waits.elementToBeClickable(driver, BvtElements.Select_Degree_and_Spec);
		BvtElements.Select_Degree_and_Spec.click();
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.Degree_Spec_list, degree);
	}

	@Test(priority = 8)
	public static void selectDepartment() throws InterruptedException {
		String depart = prop.getProperty("Department");
		Reusability.Waits.elementToBeClickable(driver, BvtElements.department);
		BvtElements.department.click();
		try {
			Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.department_list, depart);
		} catch (Exception e) {
			Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.department_list, depart);
		}

	}

	@Test(priority = 9)
	public static void enterEmailid() throws Exception {
		Reusability.JS_Executor.scrollPageDown(driver);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.email);
		Reusability.JS_Executor.ClickElement(driver, BvtElements.email);
		val = Reusability.single_mail_id_generator.generate_name();
		System.out.println(val);
		BvtElements.email.sendKeys(val);
	}

	@Test(priority = 10)
	public static void clickInviteButton() {
		Reusability.JS_Executor.ClickElement(driver, BvtElements.invite_btn);
	}

	@Test(priority = 11)
	public static void clickQuestionBank() {
		String d_url = prop.getProperty("homepageURL");
		driver.navigate().to(d_url);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.question_menu);
		Reusability.Action_Class.moveToTwoElement(driver, BvtElements.question_menu, BvtElements.question_bank);
	}

	@Test(priority = 12)
	public static void clickCreateQuestionBankButton() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.addBtn);
		BvtElements.addBtn.click();
	}

	@Test(priority = 13)
	public static void fillQuesutionBankName() throws Exception {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.QB_name);
	    QB_name = Reusability.single_mail_id_generator.generate_qb_name();
		BvtElements.QB_name.sendKeys(QB_name);
	}

	@Test(priority = 14)
	public static void selectQuestionBankCampus() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.QB_click_campus_filed);
		BvtElements.QB_click_campus_filed.click();
		qb_campus = prop.getProperty("Campus");
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.QB_campus_selection, qb_campus);
		BvtElements.QB_description.click();
	}

	@Test(priority = 15)
	public static void selectQuestionBankDepartment() {
		Reusability.JS_Executor.scrollPageDown(driver);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.QB_click_department_filed);
		BvtElements.QB_click_department_filed.click();
		String qb_department = prop.getProperty("Department");
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.QB_campus_selection, qb_department);
		BvtElements.QB_description.click();
	}

	@Test(priority = 16)
	public static void clickSaveAndCreateQuestion() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.up_arrow_btn);
		BvtElements.up_arrow_btn.click();
		BvtElements.save_create_ques_btn.click();
	}

	@Test(priority = 17)
	public static void clickQuestionCreationButton() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.create_ques_btn);
		BvtElements.create_ques_btn.click();
	}

	@Test(priority = 18)
	public static void selectQuestionTypeForMCQ() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.question_type_DD);
		BvtElements.question_type_DD.click();
		String ques_type = prop.getProperty("Question_type");
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.ques_type_selecion, ques_type);
	}

	@Test(priority = 19)
	public static void selectQuestionSubtypeForMCQ() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.ques_subtype);
		BvtElements.ques_subtype.click();
		String ques_subtype1 = prop.getProperty("ques_subtype");
		try {
			Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.ques_subtype_selection, ques_subtype1);	
		}catch(Exception e) {
			Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.ques_subtype_selection, ques_subtype1);
		}
	}

	@Test(priority = 20)
	public static void createMCQQuestion() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.question);
		Reusability.JS_Executor.scrollToelement(driver, BvtElements.question);
		String mcq1 = prop.getProperty("MCQ");
		BvtElements.question.sendKeys(mcq1);
	}

	@Test(priority = 21)
	public static void addMCQQuestionOptions() throws InterruptedException {
		Reusability.JS_Executor.scrollToelement(driver, BvtElements.add_option_btn);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.add_option_btn);
		Reusability.JS_Executor.ClickElement(driver, BvtElements.add_option_btn);
		String mcqOptions = prop.getProperty("mcq_options");
		String[] mcqOptionsArray = mcqOptions.split(",");
		for (int a = 0; a <= 1; a++) {
			BvtElements.option_Btn.click();
		}
		int i = 0;
		for (WebElement ele : BvtElements.options) {
			ele.click();
			ele.sendKeys(mcqOptionsArray[i]);
			System.out.println(mcqOptionsArray[i]);
			i++;
		}
		BvtElements.correct_ans.get(0).click();
		BvtElements.option_save_btn.click();
		BvtElements.save_create_new_ques_btn.click();
		Reusability.JS_Executor.scrollPageUP(driver);
	}

	
	@Test(priority = 22)
	public static void selectQuestionSubtypeForMultiMCQ() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.ques_subtype);
		Reusability.JS_Executor.ClickElement(driver, BvtElements.ques_subtype);
		String ques_subtype2 = prop.getProperty("ques_subtype1");
		try {
			Reusability.Waits.visibilityAllelements(driver, BvtElements.ques_subtype_selection);
			Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.ques_subtype_selection, ques_subtype2);	
		}catch(Exception e) {
			Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.ques_subtype_selection, ques_subtype2);
		}
		
	}
	
	@Test(priority = 23)
	public static void createMultiMCQQuestion() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.question);
		Reusability.JS_Executor.scrollToelement(driver, BvtElements.question);
		String m_MCQ = prop.getProperty("MCQ_multi");
		BvtElements.question.sendKeys(m_MCQ);
		
	}
	
	@Test(priority = 24)
	public static void addMCQMultiQuestionOptions() throws InterruptedException {
		Reusability.JS_Executor.scrollToelement(driver, BvtElements.add_option_btn);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.add_option_btn);
		Reusability.JS_Executor.ClickElement(driver, BvtElements.add_option_btn );
		String multi_MCQoptions = prop.getProperty("multi_mcq_options");
		String[] multi_mcqOptionsArray = multi_MCQoptions.split(",");
		for (int a = 0; a <= 1; a++) {
			BvtElements.option_Btn.click();
		}
		int i = 0;
		for (WebElement ele : BvtElements.options) {
			ele.click();
			ele.sendKeys(multi_mcqOptionsArray[i]);
			System.out.println(multi_mcqOptionsArray[i]);
			i++;
		}
		BvtElements.correct_ans.get(0).click();
		BvtElements.correct_ans.get(1).click();
		BvtElements.option_save_btn.click();	
	}
	@Test(priority = 25)
	public static void saveAndCloseTheQuestionBank() throws InterruptedException {
		Reusability.JS_Executor.scrollPageDown(driver);
		BvtElements.down_Arrow_btn.click();
		Reusability.Waits.elementToBeClickable(driver, BvtElements.save_Close_btn);
		BvtElements.save_Close_btn.click();
		Reusability.Waits.elementToBeClickable(driver, BvtElements.create_ques_btn);
	}
	
	@Test(priority = 26)
	public static void clicktheTestCreationMenu() throws InterruptedException {
		driver.navigate().to("https://admin.kscollege408.examly.io/dashboard");
		Reusability.Waits.elementToBeClickable(driver, BvtElements.testMenu);
		BvtElements.testMenu.click();
		Reusability.Waits.elementToBeClickable(driver, BvtElements.testCreationBtn);
		BvtElements.testCreationBtn.click();		
	}

	@Test(priority = 27)
	public static void enterTheNameOfTheTest() throws Exception {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.nameOfTheTest);
		BvtElements.nameOfTheTest.click();
	    testName =Reusability.single_mail_id_generator.generate_test_name();
	    BvtElements.nameOfTheTest.sendKeys(testName);
	}

	@Test(priority = 28)	
	public static void chooseTestType() throws InterruptedException {
		Reusability.JS_Executor.scrollToelement(driver, BvtElements.chooseTestType);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.chooseTestType);
		BvtElements.chooseTestType.click();
		String tt = prop.getProperty("TestType");
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.testOptionsList, tt);
	}
	
	@Test(priority = 29)
	public static void chooseTestCampus() throws InterruptedException {
		Reusability.JS_Executor.scrollToelement(driver, BvtElements.chooseCampus);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.chooseCampus);
		BvtElements.chooseCampus.click();
		String tc = prop.getProperty("Campus");
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.testCampusList, tc);
		BvtElements.downArrow.click();
	}
	
	@Test(priority = 30)
	public static void chooseTestDepartment(){
		Reusability.JS_Executor.scrollToelement(driver, BvtElements.chooseDepartment);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.chooseDepartment);
		BvtElements.chooseDepartment.click();
		String Td =prop.getProperty("Department");
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.testDepartmentList, Td);
		BvtElements.saveAndNextBtn.click();
	}
	
	@Test(priority = 31)
	public static void enterSectionName() throws Exception {
     	Reusability.Waits.elementToBeClickable(driver, BvtElements.sectionName);
     	BvtElements.sectionName.click();
     	String sectionName = Reusability.single_mail_id_generator.generate_section_name();
     	BvtElements.sectionName.sendKeys(sectionName);
	}
	
	@Test(priority = 32)
	public static void enterSectionDurationAndClickSaveAndNextBtn() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.sectionDuration);
		BvtElements.sectionDuration.click();
		String min = prop.getProperty("SectionMin");
		BvtElements.sectionDuration.sendKeys(min);
		BvtElements.addSection.click();
		BvtElements.saveAndNextBtn.click();
	}
	
	@Test(priority = 33)
	public static void selectQuestionBankForTest() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.selectQuestionBank);
		BvtElements.selectQuestionBank.click();
		Reusability.Waits.elementToBeClickable(driver, BvtElements.enterQuesBankName);
		BvtElements.enterQuesBankName.click();
		BvtElements.enterQuesBankName.sendKeys(QB_name);
		System.out.println(QB_name);
		BvtElements.enterQuesBankName.sendKeys(Keys.RETURN);
		Reusability.Waits.elementToVisibility(driver, BvtElements.qbList);
		try{
			BvtElements.qbList.click();
		}catch(Exception e) {
			BvtElements.qbList.click();
		}
		Reusability.Waits.elementToBeClickable(driver, BvtElements.confirmBtn);
		BvtElements.confirmBtn.click();
	}
	
	@Test(priority = 34)
	public static void selectSectionForTest() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.chooseSectionDropdown);
		BvtElements.chooseSectionDropdown.click();
		for(WebElement ele: BvtElements.sectionList) {
			String ele1=ele.getText();
			System.out.println(ele1);
			ele.click();
		}	
		BvtElements.saveAndNextBtn.click();
	}
	
	@Test(priority = 35)
	public static void addQuestionToSectionForTest() {
			Reusability.Waits.elementToBeClickable(driver, BvtElements.addAllQuestions);
			BvtElements.addAllQuestions.click();
			Reusability.Waits.elementToBeClickable(driver, BvtElements.saveAndNextBtn);
			BvtElements.saveAndNextBtn.click();
	}
	
	@Test(priority = 36)
	public static void publishTheTest() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.publishBtn);
		BvtElements.publishBtn.click();
	}
	
	//@Test(priority = 37)
	public static void validateTheCreatedTest() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.searchBoxForText);
		BvtElements.searchBoxForText.click();
		BvtElements.searchBoxForText.clear();
		System.out.println(testName);
		BvtElements.searchBoxForText.sendKeys(testName);
		BvtElements.searchBoxForText.sendKeys(Keys.RETURN);
		BvtElements.searchBoxForText.sendKeys(Keys.RETURN);
		Reusability.Waits.visibilityAllelements(driver, BvtElements.testNameList);
		for(WebElement ele: BvtElements.testNameList) {
			String str=ele.getText();
			if(str.equalsIgnoreCase(testName)) {
				assertEquals(str, testName);
			}
		}
	}	
	
	@Test(priority = 38)
	public static void clickCourseMenu() throws InterruptedException {
		driver.navigate().to("https://admin.kscollege408.examly.io/dashboard");
        Reusability.Waits.elementToBeClickable(driver, BvtElements.courseMenu);
		BvtElements.courseMenu.click();
	}
	
	@Test(priority = 39)
	public static void clickCourseCreationBtn() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.courseCreationBtn);
		BvtElements.courseCreationBtn.click();
	}
	
	@Test(priority = 40)
	public static void fillTheCourseName() throws Exception {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.courseName);
		BvtElements.courseName.click();
		courseName=Reusability.single_mail_id_generator.generate_Course_name();
		System.out.println("Course name: "+courseName);
		BvtElements.courseName.sendKeys(courseName);
	}
	
	@Test(priority = 41)
	public static void selectPublishingType() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.selectPublishType);
		BvtElements.selectPublishType.click();
		String Pt= prop.getProperty("PublishinType");
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.publishingTypes, Pt);
	}
	
	@Test(priority = 42)
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
	
	@Test(priority = 43)
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
	
	@Test(priority = 44)
	public static void fillPublishingText() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.publishingText);
		BvtElements.publishingText.click();
		BvtElements.publishingText.clear();
		String pt = prop.getProperty("PublishingText");
		BvtElements.publishingText.sendKeys(pt);
	}
	
	@Test(priority = 45)
	public static void selectCourseValidityType() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.scheduletype);
		BvtElements.scheduletype.click();
	}
	
	@Test(priority = 46)
	public static void selectCourseValidityOfStartPeriod() {
		Reusability.JS_Executor.scrollToelement(driver, BvtElements.chooseStartdate);
		BvtElements.chooseStartdate.click();
		String Sd = prop.getProperty("Date");
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.dateList, Sd);
	}
	
	@Test(priority = 47)
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
	
	@Test(priority = 48)
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
	
	//@Test(priority = 49)
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
	
	@Test(priority = 50)
	public static void selectBatchForCourse() throws InterruptedException {
		Reusability.JS_Executor.scrollToelement(driver, BvtElements.selectBatchDropdown);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.selectBatchDropdown);
		BvtElements.selectBatchDropdown.click();
		String Scb = prop.getProperty("Batch");
		try {
			Reusability.Waits.visibilityAllelements(driver, BvtElements.courseBatchList);
			Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.courseBatchList, Scb);
		} catch (Exception e) {
			Reusability.Waits.visibilityAllelements(driver, BvtElements.courseBatchList);
			Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.courseBatchList, Scb);
		}
		Reusability.Waits.elementToBeClickable(driver, BvtElements.courseDetailsPageDownArrow);
	}
	
	@Test(priority = 51)
	public static void saveTheCourseDetailsAndMovetoModulesSection() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.saveAndNextBtn);
		BvtElements.saveAndNextBtn.click();
	}
	
	@Test(priority = 52)
	public static void addNewModuleAndEnterModuleName() throws InterruptedException {
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
	
	@Test(priority = 53)
	public static void addTestToTheCourseModule() throws InterruptedException {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.addTestBtnOption);
		BvtElements.addTestBtnOption.click();
		Reusability.Waits.elementToBeClickable(driver, BvtElements.searchTestName);
		BvtElements.searchTestName.click();
		BvtElements.searchTestName.sendKeys(testName);
		BvtElements.searchTestName.sendKeys(Keys.RETURN);
		  for(WebElement ele: BvtElements.testNamelisting) {
			for(WebElement ele1:BvtElements.addTestbtn) { 
		        	 ele1.click();
		         }
			}
		Thread.sleep(4000);
		BvtElements.testContentCloseBtn.click();
		Reusability.Waits.elementToBeClickable(driver, BvtElements.saveAndNextBtn);
		BvtElements.saveAndNextBtn.click();
		}
	
	
	@Test(priority = 54)
	public static void clickSaveAndNextBtnAndGoToPublishScreen() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.lockTestName);
		BvtElements.lockTestName.click();
		Reusability.Waits.elementToBeClickable(driver, BvtElements.saveAndNextBtn);
		BvtElements.saveAndNextBtn.click();
	}
	
	@Test(priority = 55)
	public static void publishCourse() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.coursePublishBtn);
		BvtElements.coursePublishBtn.click();
	}
	
	@Test(priority = 56)
	public static void moveToInviteStudentPage() throws InterruptedException {
		try {
			Reusability.Waits.elementToBeClickable(driver, BvtElements.addBtn);
			BvtElements.addBtn.click();			
		} catch (Exception e) {
			Reusability.Waits.elementToBeClickable(driver, BvtElements.addBtn);
			BvtElements.addBtn.click();
		}
	}
	
	@Test(priority = 57)
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
			  for(WebElement ele: BvtElements.studentList) {
				  ele.click();
			  }
			  Reusability.Waits.elementToBeClickable(driver, BvtElements.enrollBtn);
			  BvtElements.enrollBtn.click();
			  Reusability.Waits.elementToBeClickable(driver, BvtElements.enrollConfirmYesBtn);
			  BvtElements.enrollConfirmYesBtn.click();
			  Reusability.Waits.elementToBeClickable(driver, BvtElements.closeEnrollPage);
			  BvtElements.closeEnrollPage.click();
	}
	
	@Test(priority = 58)
	public static void publishTheCourse() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.publishBtn);
		BvtElements.publishBtn.click();
	}
	
	@Test(priority = 59)
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
	
	@Test(priority = 60)
	public static void courseSelection() {
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
	
	@Test(priority = 61)
	public static void testTaking() {
	    BvtElements.btn_txt.click();
	    BvtElements.agree_Proceed_btn.click();
	}
    
	@Test(priority = 62)
    public static void mcqSingleQuestion() throws InterruptedException {
		String MCQSingleOption = prop.getProperty("MCQSingleOption");
		Reusability.Waits.visibilityAllelements(driver, BvtElements.Ans_options);
    	Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.Ans_options, MCQSingleOption);
    	BvtElements.Next_btn.click();
    }
	
	@Test(priority = 63)
	public static void mcqMultipleQuestion() {
		String MCQMultiOption = prop.getProperty("MCQMultiOption");
		Reusability.Waits.visibilityAllelements(driver, BvtElements.Ans_options);
		Reusability.Dropdown_Selection.Dropdown_selection(BvtElements.Ans_options, MCQMultiOption);
	}
	
	
	@Test(priority = 64)
	public static void submitTest() {
		Reusability.Waits.elementToBeClickable(driver, BvtElements.Submit_Test_btn);
		Reusability.JS_Executor.ClickElement(driver,BvtElements.Submit_Test_btn);
		Reusability.Waits.elementToBeClickable(driver, BvtElements.End_textbox);
		BvtElements.End_textbox.sendKeys("End");
		BvtElements.Yes_btn.click();
	}
	
	@Test(priority = 65)
	public static void courseDetailsPage() {
		Reusability.Waits.elementToVisibility(driver, BvtElements.btn_txt);
		System.out.println(BvtElements.attempt_count.getText());
	}	
}
package ai.iamneo.automation.elements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BvtElements {
	
	//logindetails
	
	@FindBy(xpath = "//input[@id='emailAddress']")
	public static WebElement user_name;
	
	@FindBy(xpath = "//input[@id='password']")
	public static WebElement pass;
	
	@FindBy(xpath ="//span[contains(text(),' Login ')]")
	public static WebElement login_btn;
	
	//Homepage details
	
	@FindBy(xpath ="//div[@id='fullHeightForSidemenu']/ul/li[1]/span")
	public static WebElement dashboard_icon;
	
	@FindBy(xpath = "//p-tieredmenu[1]/div/p-tieredmenusub/ul/li/p-tieredmenusub/ul/li[1]")
	public static WebElement manage_students;
	
	@FindBy(xpath = "//div[@id='fullHeightForSidemenu']/ul/p-tieredmenu[1]")
	public static WebElement manage_tab;
	
	//Single invite details
	
	@FindBy(xpath = "//label[text()=\"Choose Campus\"]")
	public static WebElement Select_Campus;
	
	@FindBy(xpath = "//p-dropdownitem/li")
	public static List<WebElement> Campus_list;
	
	@FindBy(xpath = "//label[text()=\"Choose Batch\"]")
	public static WebElement Select_batch;
	
	@FindBy(xpath = "//p-dropdownitem/li/span")
	public static List<WebElement> Batch_list;
	
	@FindBy(xpath = "//label[text()=\"Choose Degree & Specialization\"]")
	public static WebElement Select_Degree_and_Spec;
 
	@FindBy(xpath = "//p-dropdownitem/li/span")
	public static List<WebElement> Degree_Spec_list;
	
	@FindBy(xpath = "//button[@class='add-btn add-button-class']")
	public static WebElement add_btn;

	@FindBy(xpath = "//label[text()=\"Choose Department\"]")
	public static WebElement department;
	
	@FindBy(xpath = "//p-dropdownitem/li/span")
	public static List<WebElement> department_list;

	@FindBy(xpath = "//textarea[@formcontrolname=\"emails\"]")
	public static WebElement email;
	
	@FindBy(xpath ="//span[text()=\"Invite\"]")
	public static WebElement invite_btn;
	
	@FindBy(xpath ="//tbody[@class='ui-datatable-data ui-widget-content']/tr[1]/td[3]")
	public static WebElement invite_emailid;
	
	@FindBy(xpath ="//p-dropdown[@name='SearchBy']")
	public static WebElement searchBy;
	
	@FindBy(xpath ="//ul[@role='listbox']/p-dropdownitem/li")
	public static List<WebElement> searchBy_list;
	
	@FindBy(xpath = "//div[@id='fullHeightForSidemenu']/ul/p-tieredmenu[2]")
	public static WebElement question_menu;
	
	@FindBy(xpath = "//p-tieredmenu[2]/div/p-tieredmenusub/ul/li/p-tieredmenusub/ul/li[1]")
	public static WebElement question_bank;
	
	@FindBy(xpath = "//span[contains(text(),\"+\")]")
	public static WebElement addBtn;
	
	@FindBy(xpath = "//input[@id='qbname']")
	public static WebElement QB_name;
	
	@FindBy(xpath = "//div[@title='Select a Campus']")
	public static WebElement QB_click_campus_filed;
	
	@FindBy(xpath = "//div[@class='ui-multiselect-items-wrapper']/ul/p-multiselectitem")
	public static List<WebElement> QB_campus_selection;
	
	@FindBy(xpath = "//div[@title='Select a Department']")
	public static WebElement QB_click_department_filed;
	
	@FindBy(xpath = "//div[@class='ui-multiselect-items-wrapper']/ul/p-multiselectitem")
	public static List<WebElement> QB_department_selection;
	
	@FindBy(xpath ="//button[@icon=\"pi pi-chevron-down\"]")
	public static WebElement up_arrow_btn;
	
	@FindBy(xpath = "//span[contains(text(),'Save & Create question')]")
	public static WebElement save_create_ques_btn;
	
	@FindBy(xpath = "//label[contains(text(),'Single Question')]")
	public static WebElement question_type_DD;
	
	@FindBy(xpath ="//div[@class='ui-dropdown-items-wrapper']/ul/p-dropdownitem")
	public static List<WebElement> ques_type_selecion;
	
	@FindBy(xpath ="//label[contains(text(),'MCQ - Single Correct')]")
	public static WebElement ques_subtype;
	
	@FindBy(xpath ="//div[@class='ui-dropdown-items-wrapper']/ul/p-dropdownitem")
	public static List<WebElement> ques_subtype_selection;
	
	@FindBy(xpath ="//textarea[@name='qbdescription']")
	public static WebElement QB_description;
	
	@FindBy(xpath = "//button[@class='add-btn add-button-class float-right-class']/span")
	public static WebElement create_ques_btn;
	
	@FindBy(xpath = "//p-dropdown[@id='qsubjectsmcq']/div/div[2]")
	public static WebElement click_subject;
	
	@FindBy(xpath = "//div[@class='ui-dropdown-items-wrapper']/ul/p-dropdownitem")
	public static List<WebElement> Select_subject;
	
	@FindBy(xpath ="//p-dropdown[@id='qtopicsmcq']/div/label")
	public static WebElement click_topic;
	
	@FindBy(xpath = "//div[@class='ui-dropdown-items-wrapper']/ul/p-dropdownitem")
	public static List<WebElement> select_topic;
	
	@FindBy(xpath = "//p-dropdown[@id='qsubtopicsmcq']/div/label")
	public static WebElement click_subtopic;
	
	@FindBy(xpath = "//div[@class='ui-dropdown-items-wrapper']/ul/p-dropdownitem")
	public static List<WebElement> select_subtopic;
	
	@FindBy(xpath = "//p-dropdown[@id='qBlooms']/div/label")
	public static WebElement click_blooms;
	
	@FindBy(xpath = "//div[@class='ui-dropdown-items-wrapper']/ul/p-dropdownitem")
	public static List<WebElement> select_blooms;
	
	@FindBy(xpath = "//div[@data-placeholder='Enter Question Here']")
	public static WebElement question;
	
	@FindBy(xpath = "//span[contains(text(),'Add/Edit Option')]")
	public static WebElement add_option_btn;
	
	@FindBy(xpath ="//div[@data-placeholder='Enter Option']")
	public static List<WebElement> options;
	
	@FindBy(xpath = "//div[@formarrayname='qoptions']/div/div/span[2]/p-checkbox")
	public static List<WebElement> correct_ans;
	
	@FindBy(xpath = "//span[@class='ui-radiobutton-icon ui-clickable pi pi-circle-on']")
	public static WebElement difficulty_Mode;
	
	@FindBy(xpath = "//span[contains(text(),'Add Option')]")
	public static WebElement option_Btn;

	@FindBy(xpath = "//button[@icon=\"icon-done\"]")
	public static WebElement option_save_btn;
	
	@FindBy(xpath = "//span[contains(text(),\"Save & Create new\")]")
	public static WebElement save_create_new_ques_btn;
	
	@FindBy(xpath = "//p-splitbutton[@label=\"Save & Create new\"]/div/button[2]")
	public static WebElement down_Arrow_btn;
	
	@FindBy(xpath ="//span[contains(text(),\"Save and Close\")]")
	public static WebElement save_Close_btn;
	
	//fillups elements
	
	@FindBy(xpath = "//label[contains(text(),'MCQ - Multiple Correct')]")
	public static WebElement eassySubQuestiontype;
	
	@FindBy(xpath = "//input[@formcontrolname='blanks']")
	public static WebElement blankCount;
	
	@FindBy(xpath = "//span[contains(text(),'Add/Edit Answer')]")
	public static WebElement editAnswer;
	
	@FindBy(xpath = "//button[@label='Add Answer']")
	public static WebElement addAnswer;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Answer']")
	public static WebElement fillupsEnteranswer;
	
	@FindBy(xpath = "//button[@class='editAnswerSavebtn ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left']")
	public static WebElement fillupSavebtn;
	
	//easy writing elements
	
	@FindBy(xpath = "//input[@id='qname']")
	public static WebElement enterEassyQuestion;
	
	@FindBy(xpath = "//div[@data-placeholder='Enter Question']")
	public static WebElement enterQuestionhere;
	
	@FindBy(xpath = "//div[@data-placeholder='Enter Directions']")
	public static WebElement enterDirections;
	
	@FindBy(xpath = "//input[@placeholder='Internal Keywords']")
	public static WebElement internalKeywords;
	
	@FindBy(xpath = "//div[@id=\"right\"]/span[2]/span")
	public static WebElement noOfQuestions;
	
	// Test Creation
	@FindBy(xpath = "//li[@id='testsidemenu']")
	public static WebElement testMenu;
	
	@FindBy(xpath = "//span[contains(text(),'+')]")
	public static WebElement testCreationBtn;
	
	@FindBy(xpath = "//input[@placeholder='Test Name']")
	public static WebElement nameOfTheTest;
	
	@FindBy(xpath = "//label[contains(text(),'Choose Test type')]")
	public static WebElement chooseTestType;
	
	@FindBy(xpath = "//ul[@role='listbox']/p-dropdownitem")
	public static List<WebElement> testOptionsList;
	
	@FindBy(xpath = "//span[contains(text(),'Choose Campus')]")
	public static WebElement chooseCampus;
	
	@FindBy(xpath = "//ul[@class='ui-multiselect-items ui-multiselect-list ui-widget-content ui-widget ui-corner-all ui-helper-reset']/p-multiselectitem")
	public static List<WebElement> testCampusList;
	
	@FindBy(xpath = "//div[@title='Choose']/span")
	public static WebElement chooseDepartment;
	
	@FindBy(xpath = "//div[@class='ui-multiselect-items-wrapper']/ul/p-multiselectitem")
	public static List<WebElement> testDepartmentList;
	
	@FindBy(xpath = "//span[contains(text(),'Save and Next')]")
	public static WebElement saveAndNextBtn;
	
	@FindBy(xpath = "//button[@icon='pi pi-chevron-down']")
	public static WebElement downArrow;
	
	//Test creation - section details
	
	@FindBy(xpath = "//input[@placeholder='Section Name']")
	public static WebElement sectionName;
	
	@FindBy(xpath = "//input[@placeholder='  Sectional Duration']")
	public static WebElement sectionDuration;
	
	@FindBy(xpath = "//span[contains(text(),'Add Section')]")
	public static WebElement addSection;
	
	@FindBy(xpath = "//span[contains(text(),' Select Question Bank ')]")
	public static WebElement selectQuestionBank;
	
	@FindBy(xpath = "//input[@id='search2']")
	public static WebElement enterQuesBankName;
	
	@FindBy(xpath = "//div[@class='ng-star-inserted']/div[2]/div/p-radiobutton/div")
	public static WebElement qbList;
	
	@FindBy(xpath = "//span[contains(text(),'Confirm')]")
	public static WebElement confirmBtn;
	
	@FindBy(xpath = "//label[contains(text(),'Choose Section')]")
	public static WebElement chooseSectionDropdown;
	
	@FindBy(xpath = "//ul[@role='listbox']")
	public static List<WebElement> sectionList;
	
	@FindBy(xpath = "//span[contains(text(),'Add all questions')]") 
	public static WebElement addAllQuestions;
	
	@FindBy(xpath = "//span[contains(text(),'Update and Next')]")
	public static WebElement updateAndNextBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Publish')]")
	public static WebElement publishBtn;
	
	//Test listing page
	@FindBy(xpath = "//div[@class='ui-inputgroup alignment pull-right']/input")
	public static WebElement searchBoxForText;
	
	@FindBy(xpath = "//tbody[@class='ui-datatable-data ui-widget-content']/tr/td[4]")
	public static List<WebElement> testNameList;
	
	@FindBy(xpath = "//span[@class='number']")
	public static WebElement questionNumber;
	
	//Course Details
	
	@FindBy(xpath = "//li[@ptooltip='Courses']")
	public static WebElement courseMenu;
	
	@FindBy(xpath = "//span[contains(text(),'+')]")
	public static WebElement courseCreationBtn;
	
	@FindBy(xpath = "//input[@formcontrolname='courseName']")
	public static WebElement courseName;
	
	@FindBy(xpath = "//label[contains(text(),'Select Publish Type')]")
	public static WebElement selectPublishType;
	
	@FindBy(xpath = "//ul[@role='listbox']/p-dropdownitem")
	public static List<WebElement> publishingTypes;
	
	@FindBy(xpath = "//label[contains(text(),'Select Shared Type')]")
	public static WebElement sharedType;
	
	@FindBy(xpath = "//label[contains(text(),'Select Pre Text')]")
	public static WebElement selectPreText;
	
	@FindBy(xpath = "//ul[@role='listbox']/p-dropdownitem")
	public static List<WebElement> selectPreTextList;
	
	@FindBy(xpath = "//input[@formcontrolname='publishingText']")
	public static WebElement publishingText;
	
	@FindBy(xpath = "//label[contains(text(),'Schedule')]")
	public static WebElement scheduletype;
	
	@FindBy(xpath = "//p-calendar[@formcontrolname='courseValidityRangeStart']")
	public static WebElement chooseStartdate;
	
	@FindBy(xpath = "//p-calendar[@formcontrolname='courseValidityRangeEnd']")
	public static WebElement chooseEndDate;
	
	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td")
	public static List<WebElement> dateList;
	
	@FindBy(xpath = "//span[contains(text(),'Choose department')]")
	public static WebElement chooseCourseDepartment;
	
	@FindBy(xpath = "//div[@class='ui-multiselect-items-wrapper']/ul/p-multiselectitem")
	public static List<WebElement> courseDepartmentList;
	
	@FindBy(xpath = "//span[contains(text(),'Choose batch')]")
	public static WebElement chooseCourseBatch;
	
	@FindBy(xpath = "//div[@class='ui-multiselect-items-wrapper']/ul/p-multiselectitem")
	public static List<WebElement> courseBatchList;
	
	@FindBy(xpath = "//span[@class='ui-datepicker-next-icon pi pi-chevron-right']")
	public static WebElement datePickerRightArrow;
	
	@FindBy(xpath = "//button[@icon='pi pi-chevron-down']")
	public static WebElement courseDetailsPageDownArrow;
	
	@FindBy(xpath = "//span[contains(text(),'Choose department')]")
	public static WebElement selectDepartmentdropdown;
	
	@FindBy(xpath = "//span[contains(text(),'Choose batch')]")
	public static WebElement selectBatchDropdown;
	
	@FindBy(xpath = "//div[@class='ui-multiselect-items-wrapper']/ul/p-multiselectitem")
	public static List<WebElement> batchList;
	
	//module and submodules details for course creation
	
	@FindBy(xpath = "//span[contains(text(),' Add new Module ')]")
	public static WebElement addNewModule;
	
	@FindBy(xpath = "//div[@class='ui-g-12 ui-g-nopad ng-star-inserted']/div/div/span[1]")
	public static WebElement moduleName;
	
	@FindBy(xpath = "//i[@class='icon icon-add plus1']")
	public static WebElement addTestBtnOption;
	
	@FindBy(xpath = "//input[@placeholder='Enter your search term']")
	public static WebElement searchTestName;
	
	@FindBy(xpath = "//table[@style='top:0px']/tbody/tr/td[3]")
	public static List<WebElement> testNamelisting;
	
	@FindBy(xpath = "//table[@style='top:0px']/tbody/tr/td[1]/span")
	public static List<WebElement> addTestbtn;
	 
	@FindBy(xpath = "//span[@class='icon icon-close-1 cursorclose']")
	public static WebElement testContentCloseBtn;
	
	@FindBy(xpath = "//div[@id='ui-tabpanel-14']/div/div/div[3]/div")
	public static WebElement testSectionclick;
	
	@FindBy(xpath = "//label[@class='lock-overflow ng-star-inserted']/span[2]")
	public static WebElement lockTestName;
	
	@FindBy(xpath = "//div[@class='ng-star-inserted']/p-splitbutton/div/button[1]")
	public static WebElement coursePublishBtn;
	
	//Enroll page details for course creation
	
	@FindBy(xpath = "//label[contains(text(),'Search by')]")
	public static WebElement searchByDropdownBtn;
	
	@FindBy(xpath = "//div[@class='ui-dropdown-items-wrapper']/ul/p-dropdownitem")
	public static List<WebElement> searchByList;
	
	@FindBy(xpath = "//input[@placeholder='Enter the search key']")
	public static WebElement searchBox;
	
	@FindBy(xpath = "//p-datatable[@datakey='email']/div/div/p-header/span[2]/div[2]/span[2]")
	public static WebElement courseCampusDD;
	
	@FindBy(xpath = "//p-datatable[@datakey='email']/div/div/p-header/span[2]/div[1]/span[2]")
	public static WebElement courseBatchDD;
	
	@FindBy(xpath = "//div[@class='studentTable ui-datatable ui-widget ui-datatable-reflow']/div[2]/table/tbody/tr/td[1]/span[2]/input" )
	public static List<WebElement> studentList;
	
	@FindBy(xpath = "//button[@label='Enroll']/span")
	public static WebElement enrollBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	public static WebElement enrollConfirmYesBtn;
	
	@FindBy(xpath = "//app-course[@class='ng-star-inserted']/p-dialog[8]/div/div/a/span")
	public static WebElement closeEnrollPage;
	
	//student login details
	@FindBy(xpath = "//span[contains(text(),'Sign In')]")
	public static WebElement signBtn;
	
	@FindBy(xpath ="//input[@name='email']")
	public static WebElement username;

	@FindBy(xpath ="//input[@id='password']")
	public static WebElement password;
	
	@FindBy(xpath ="//button[@tabindex='0']")
	public static WebElement next_btn;
	
	@FindBy(xpath ="//button[@tabindex='0']")
	public static WebElement Login_btn;
	
	@FindBy(xpath ="//span[@class='cc-1rzf cc-yx2c']")
	public static WebElement bot;
	
	@FindBy(xpath ="//img[@class='t-m-w-full t-min-w-[30%] t-max-w-[40%] t-object-contain t-m-auto t-mb-15 t-w-[45px] t-h-[45px]']")
	public static WebElement collegeLogo;
	
	@FindBy(xpath ="//div[@class='p-checkbox-box']")
	public static WebElement showpassword;
	
	//course listing details
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	public static WebElement SearchBox;
	
	@FindBy(xpath = "//div[@aria-labelledby='card-list']")
	public static WebElement Coursecard;
	
	@FindBy(xpath = "//button[@class='t-relative butIcon btn-styles resume-btn-color ng-star-inserted']")
	public static WebElement ResumeTest_btn;
	
	@FindBy(xpath = "//div[@data-simplebar='true']/ul/li/a/div/div")
	public static List<WebElement> Side_Menus;
	
	//Test-taking details
	
	@FindBy(xpath = "//app-button/button[@tabindex='0']/div/div/span")
	public static WebElement btn_txt;
	
	@FindBy(xpath = "//button[@id='tt-start-accept']")
	public static WebElement agree_Proceed_btn;
	
	@FindBy(xpath = "//div[@aria-labelledby='each-option-cont']/div/label")
	public static List<WebElement> Ans_options;
	
	@FindBy(xpath = "//div[contains(text(),'Next')]")
	public static WebElement Next_btn;
	
	@FindBy(xpath = "//div[contains(text(),'Prev')]")
	public static WebElement prev_btn;

	@FindBy(xpath ="//span[contains(text(),'Clear')]")
	public static WebElement Clear_btn;
	
	@FindBy(xpath ="//div[@aria-labelledby='skip-btn-container']/div")
	public static WebElement Skip_btn;
	
	@FindBy(xpath ="//input[@aria-labelledby='Blank 1']")
	public static WebElement fillups_box;
	
	@FindBy(xpath = "//span[contains(text(),'Submit Answer')]")
	public static WebElement Submit_answer_btn;
	
	@FindBy(xpath ="//div[@aria-labelledby='answer-container']/textarea")
	public static WebElement Ans_container_descriptive;
	
	@FindBy(xpath = "//span[contains(text(),'Submit Test')]")
	public static WebElement Submit_Test_btn;
	
	@FindBy(xpath = "//input[@id='name']")
	public static WebElement End_textbox;
	
	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	public static WebElement Yes_btn;
	
	@FindBy(xpath = "//span[contains(text(),'No')]")
	public static WebElement No_btn;
	
	@FindBy(xpath = "//span[contains(text(),'Attempt :')]")
	public static WebElement attempt_count;
	
	@FindBy(xpath ="//div[@aria-labelledby ='draggable-container']/div[1]")
	public static WebElement Classification_options;
	
	@FindBy(xpath ="//div[@aria-labelledby ='draggable-container']")
	public static WebElement classification_ans_container_scroll;
	
	@FindBy(xpath ="//div[@aria-labelledby ='classification-container']")
	public static WebElement classification_container_scroll;
	
	@FindBy(xpath ="//div[@aria-labelledby='no_background']/div[5]" )
	public static WebElement Classification_answer_box;
	
}


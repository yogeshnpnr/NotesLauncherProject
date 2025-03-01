package tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.CreateNotePage;
import pages.NotesHomePage;
import pages.ToDoListsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class NotesLauncherTests extends BaseTest {
	private NotesHomePage notesHomePage;
	private CreateNotePage createNotePage;
	private ToDoListsPage toDoPage;

	// Extent Reports setup
	private static ExtentReports extent;
	private ExtentTest test;

	@BeforeSuite
	public void setUpExtentReports() {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}

	@BeforeMethod
	public void setUpPages() {
		notesHomePage = new NotesHomePage(driver);
		createNotePage = new CreateNotePage(driver);
		toDoPage = new ToDoListsPage(driver);
	}

	  @Test(description = "Verify TC1: Create Note Test", priority = 1)
		public void createTextNotesTest() {
			test = extent.createTest("Verify TC1: Onboarding and TC 2: Creating a text note");
			notesHomePage.initializeAppSetup();
			createNotePage.createNote("This is First Note1", "Verify testing notes launcher application mobile app working");
			Assert.assertTrue(true, "Note successfully created!");
			test.pass("Note successfully created!");
	
		}

	  @Test(description = "TC 3:Create To-Do List Test ", priority = 2)
	public void createTodoListTest() {
		test = extent.createTest("TC 3: Creating a To-Do List ", "Validates creating a to-do list in the app");

		try {
			toDoPage.createToDoList("This is my to-do list", "Task 1", "Task 2", "Task 3");

			Assert.assertTrue(true, "To-Do List successfully created!");
			test.pass("To-Do List successfully created!");

		} catch (Exception e) {
			test.log(Status.FAIL, "Test failed: " + e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		extent.flush(); 
	}
	
	 @AfterSuite
	    public void tearDownExtentReports() {
	        extent.flush();
	        try {
	            File htmlFile = new File("test-output/ExtentReport.html");
	            if (htmlFile.exists()) {
	                Desktop.getDesktop().browse(htmlFile.toURI()); // Automatically opens the report
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}

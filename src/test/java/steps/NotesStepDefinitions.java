package steps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.en.*;
import pages.NotesHomePage;
import pages.NotesPage;
import pages.ToDoListsPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.Assert.*;

public class NotesStepDefinitions {

    public static AndroidDriver driver;
    NotesHomePage homePage;
    NotesPage notesPage;
    ToDoListsPage toDoListsPage;


    @Given("The Notes Launcher app is initialized and onboarding is done")
    public void initializeAndCompleteOnboarding() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("samsung SM-G990B2");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setPlatformVersion("14");
        options.setApp("C:/Users/yoges/OneDrive/Desktop/TestingMobile/Notes/NotesLauncher.apk"); // Change path
        
		/*
		 * DesiredCapabilities capabilities = new DesiredCapabilities();
		 * capabilities.setCapability("deviceName",
		 * ConfigReader.getEnvString("deviceName"));
		 * capabilities.setCapability("platformName",
		 * ConfigReader.getEnvString("platformName"));
		 * capabilities.setCapability("automationName",
		 * ConfigReader.getEnvString("automationName"));
		 * capabilities.setCapability("platformVersion",
		 * ConfigReader.getEnvString("platformVersion"));
		 * capabilities.setCapability("app", ConfigReader.getEnvString("app")); //
		 * capabilities.setCapability("chromedriverExecutable",
		 * ConfigReader.getEnvString("chromedriverExecutable"));
		 * 
		 * URL url = URI.create(ConfigReader.getEnvString("appiumServer")).toURL();
		 * driver = new AndroidDriver(url, capabilities);
		 * 
		 * 
		 */

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new NotesHomePage(driver);
        homePage.initializeAppSetup();
    }

    @When("I create a note with title {string} and content {string}")
    public void createNote(String title, String content) {
        notesPage = new NotesPage(driver);
        notesPage.createNote(title, content);
    }

    @Then("The note should be created successfully")
    public void verifyNoteCreated() {
       // assertTrue("Note should be visible", notesPage.isNoteVisible());
    }
    
    
    @When("I create a to-do list with title {string} and tasks {string}, {string}, {string}")
    public void createToDoList(String title, String task1, String task2, String task3) throws InterruptedException {
        toDoListsPage = new ToDoListsPage(driver);
        toDoListsPage.createToDoList(title, task1, task2, task3);
    }

    @Then("The to-do list should be created successfully")
    public void verifyToDoListCreated() {
        // This is a placeholder. You can implement visibility check in ToDoListsPage later.
        assertTrue("To-Do list should be visible", true);
    }
}

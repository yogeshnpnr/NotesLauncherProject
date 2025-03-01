package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class NotesHomePage extends BasePage {
    
    private By getStartedButton = By.id("com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_get_started");
    private By defaultHomeRadioButton = By.xpath("(//android.widget.RadioButton[@resource-id='android:id/checkbox'])[1]");
    private By animationArrow = By.id("com.notes.todolist.notebook.checklist.notepad.android.dev:id/left_arrow");

    public NotesHomePage(AndroidDriver driver) {
        super(driver);
    }

    public void initializeAppSetup() {
        click(getStartedButton);
        waitForElementToBeClickable(defaultHomeRadioButton);
        click(defaultHomeRadioButton);
        waitForElementToBeClickable(animationArrow);
        click(animationArrow);
    }
}

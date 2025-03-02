package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


public class CreateNotePage extends BasePage {

  
    private By textNoteOption = By.id("com.notes.todolist.notebook.checklist.notepad.android.dev:id/label_text_note");
    private By noteEditor = By.xpath("//android.widget.EditText[@resource-id='editor']");
    private By noteTitle = By.id("com.notes.todolist.notebook.checklist.notepad.android.dev:id/note_title");
    private By saveButton = By.xpath("//android.widget.TextView[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_save']");

    public CreateNotePage(AndroidDriver driver) {
        super(driver);
    }

    public void createNote(String title, String content) {

    	// Step 1: Proceed with text note creation
        // dismiss the blocking element
        WebElement blockingElement = waitForElement(By.className("android.widget.ImageView"));
    	blockingElement.click();
    	
    	// Step 2:Tap on + icon
      
    	WebElement plusButton = waitForElement(By.id("com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_create_note"));
        plusButton.click();

        // Step 3: Tap on create a text note
        click(textNoteOption);
       
        
        //  Step 4:Create a note : Add title, enter paragraph, 
        enterText(noteEditor, content);
        
        pressKey(AndroidKey.ENTER);

        enterText(noteTitle, title);
        //  Step 5 :Save the note
        waitForElementToBeClickable2(saveButton);
        click(saveButton);
        
    }
}
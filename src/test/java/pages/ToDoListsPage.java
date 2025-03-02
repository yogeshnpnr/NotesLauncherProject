package pages;

import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class ToDoListsPage extends BasePage {

    private By plusButton = By.id("com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_create_note");
    private By toDoOption = By.id("com.notes.todolist.notebook.checklist.notepad.android.dev:id/label_todo_note");
    private By toDoTitle = By.id("com.notes.todolist.notebook.checklist.notepad.android.dev:id/note_title");
    private By addTaskButtonone = By.id("com.notes.todolist.notebook.checklist.notepad.android.dev:id/edit_text_id");
    private By SecondTask = By.id("com.notes.todolist.notebook.checklist.notepad.android.dev:id/add_item");
    private By addTaskButtontwo =By.xpath("(//android.widget.EditText[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/edit_text_id'])[2]");
    private By ThirdTask = By.id("com.notes.todolist.notebook.checklist.notepad.android.dev:id/add_item");
    private By addTaskButtonthree = By.xpath("(//android.widget.EditText[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/edit_text_id'])[3]");
  
    
    private By saveButton = By.id("com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_save");

    
    
    
    
    
    public ToDoListsPage(AndroidDriver driver) {
        super(driver);
    }

    public void createToDoList(String title,String taskone, String tasktwo,String taskthree) throws InterruptedException {
       
    	
    	// step1 :Tap on + icon
    	click(plusButton);
    	
    	// step2: Tap on create a To-Do list
        click(toDoOption);
        //  step3: Create a list: Add tasks
        enterText(toDoTitle, title);
           
       // click(firstTask);
        enterText(addTaskButtonone, taskone);
        
        Thread.sleep(2000);

        click(SecondTask);
        Thread.sleep(2000);

        enterText(addTaskButtontwo, tasktwo);
        Thread.sleep(2000);

        click(ThirdTask);
        Thread.sleep(2000);
        

        enterText(addTaskButtonthree, taskthree);
            
        Thread.sleep(2000);


        // step4:change background color

        WebElement colorChange = waitForElement(By.id("com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_color_change"));

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(colorChange));

        colorChange.click();
        WebElement greenColor = waitForElement(By.xpath("(//android.widget.ImageView[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/color_item'])[4]"));
        greenColor.click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_save")));

        Thread.sleep(2000);
        
        // step5:Save the note
         click(saveButton);
    }

	

	
}



/*
 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //
 * Wait up to 10 seconds WebElement element =
 * wait.until(ExpectedConditions.elementToBeClickable(plusButton));
 * element.click();
 */

/*
 * WebElement plusButton = waitForElement(By.id(
 * "com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_create_note"
 * )); plusButton.click(); test.log(Status.INFO, "Clicked on 'Create Note'");
 * 
 * WebElement tapOnTodolist = waitForElement(By.id(
 * "com.notes.todolist.notebook.checklist.notepad.android.dev:id/label_todo_note"
 * )); tapOnTodolist.click(); test.log(Status.INFO, "Selected 'To-Do List'");
 * 
 * WebElement todoTitle = waitForElement(By.id(
 * "com.notes.todolist.notebook.checklist.notepad.android.dev:id/note_title"));
 * todoTitle.sendKeys("This is my to-do list"); test.log(Status.INFO,
 * "Entered To-Do List Title");
 * 
 * WebElement task1 = waitForElement(By.id(
 * "com.notes.todolist.notebook.checklist.notepad.android.dev:id/edit_text_id"))
 * ; task1.sendKeys("Task 1"); test.log(Status.INFO, "Added Task 1");
 * 
 * 
		
		  click(colorchange); Thread.sleep(2000);
		  
		  click(greencolor);
		 /
 */


# Notes Launcher Automation - Setup and Execution Guide


## 1. Project Overview
This is  automation framework project of notes launcher application using  page object model desgin pattern and testng unit test framework  the testing of the Notes Launcher mobile application using **Appium 2.0, TestNG, and Extent Reports**.

## 2. Prerequisites
Ensure the following are installed and configured:
- **Java JDK 11+**
- **Android Studio & ADB**
- **Maven** (Dependency Management)
- **Appium 2.16.2** (`npm install -g appium@2.16.2`)
- **Appium Inspector**
- **Eclipse/IntelliJ IDEA**

## 3. Setup Instructions
1. Clone the GitHub repository:  
   ```sh
   git clone -b yogeshone https://github.com/yogeshnpnr/NotesLauncherProject.git
   cd NotesLauncherProject
Install dependencies using Maven:

Start Appium Server:appium
Connect an Android device and verify: adb devices
Run the tests:3. Right-click on NotesLauncherTests.java -> Select Run As -> TestNG Suite.


4. Execution and Reporting
Test Execution: Run tests using testng.xml
Report Location: test-output/ExtentReport.html

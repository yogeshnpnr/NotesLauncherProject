Feature: Notes Launcher App Tests

  Scenario: Create a text note after onboarding
    Given The Notes Launcher app is initialized and onboarding is done
    When I create a note with title "This is First Note1" and content "Verify testing notes launcher application mobile app working"
    Then The note should be created successfully

  Scenario: Create a To-Do List
    When I create a to-do list with title "This is my to-do list" and tasks "Task 1", "Task 2", "Task 3"
    Then The to-do list should be created successfully

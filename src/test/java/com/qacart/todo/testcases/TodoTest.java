package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {

    @Test
    public void addNewTodoSuccessfully() {

        LoginPage loginPage= new LoginPage(driver);
        String ActualResult=loginPage
                .load()
                .login("hatem@example.com","Test1234")
                .clickThePlusButton()
                .addNewTodoName("Learn Selenium")
                .clickSubmitButton()
                .getTodoItemText();

        Assert.assertEquals(ActualResult, "Learn Selenium");
        TodoPage todoPage=new TodoPage(driver);
        todoPage.clickDeleteButton(); //to ensure that no todos left when the test is done , so that won't effect the delete todo test
    }

    @Test
    public void deleteTodoSuccessfully() {

        LoginPage loginPage= new LoginPage(driver);
        boolean IsNotAvailableTodosMessageDisplayed=loginPage
                .load()
                .login("hatem@example.com","Test1234")
                .clickThePlusButton().addNewTodoName("Learn Selenium")
                .clickSubmitButton()
                .clickDeleteButton()
                .IsNotAvailableTodosMessageDisplayed();

        Assert.assertTrue(IsNotAvailableTodosMessageDisplayed);

    }
}
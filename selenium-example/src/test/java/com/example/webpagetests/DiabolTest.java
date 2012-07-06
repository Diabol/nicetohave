/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webpagetests;

import com.thoughtworks.selenium.Selenium;
import static junit.framework.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 *
 * @author danielgronberg
 */
public class DiabolTest {

    private String targetUrl = "http://www.diabol.se";
    private Selenium selenium;
    private WebDriver driver;
    
    @Before
    public void setUp() throws Exception {
        System.out.println("Starting Selenium:");
        driver = new FirefoxDriver();
        selenium = selenium == null ? new WebDriverBackedSelenium(this.driver, this.targetUrl) : selenium;
        System.out.println("Selenium started::: with base URL: " + targetUrl);
        selenium.open("/");
        selenium.waitForPageToLoad("3000");
    }
    
    @After
    public void teardown() throws Exception {
        if(this.driver != null) {
            driver.close();
        }
        System.out.println("Selenium stopped");
    }
    
    /**
     * Verify that the link "Om oss" works at www.diabol.se
     * @throws Exception 
     */
    @Test
    public void testAboutDiabol() throws Exception {
        // Find the link with text "Om oss".
        WebElement element = driver.findElement(By.linkText("Om oss"));

        // Click on the link
        element.click();
        
        //Verify that the expected headline text i present.
        assertTrue(selenium.isTextPresent("Om Diabol"));
    }

}

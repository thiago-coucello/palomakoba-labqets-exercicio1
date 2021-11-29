package com.example.conversordemoedas;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private AndroidDriver driver;
    
    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "LGM70029a76107");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.example.conversordemoedas");
        desiredCapabilities.setCapability("appActivity", "com.example.conversordemoedas.MainActivity");
        
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }
    
    @Test
    public void testeCampoVazio() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.example.conversordemoedas:id/bt_converter");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.example.conversordemoedas:id/txtValorDolares");
        el2.click();
    
        Assert.assertEquals(el2.getText(), "NENHUM VALOR INSERIDO !!!");
    }
    
    @Test
    public void testeValorGrande() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.example.conversordemoedas:id/edtValorReais");
        el1.sendKeys("99999999999999999");
        
        MobileElement el2 = (MobileElement) driver.findElementById("com.example.conversordemoedas:id/bt_converter");
        el2.click();
        
        MobileElement el3 = (MobileElement) driver.findElementById("com.example.conversordemoedas:id/txtValorDolares");
        el3.click();
        
        Assert.assertEquals(el3.getText(), "U$ 1.8691588785046732E16");
    }
    
    @Test
    public void testeValorPequeno() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.example.conversordemoedas:id/edtValorReais");
        el1.sendKeys("0.000001");
        
        MobileElement el2 = (MobileElement) driver.findElementById("com.example.conversordemoedas:id/bt_converter");
        el2.click();
    
        MobileElement el3 = (MobileElement) driver.findElementById("com.example.conversordemoedas:id/txtValorDolares");
        el3.click();
        
        Assert.assertEquals(el3.getText(), "U$ 1.8691588785046729E");
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
}
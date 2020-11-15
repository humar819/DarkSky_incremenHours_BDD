package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import runnerTest.webPages.ElementUtil;
import utilis.BasePage;
import utilis.ConfigReader;


import java.io.File;
import java.io.IOException;

public class SharedSD{
    /*
    Shared SD will communicate with my base page.

    This is my Hook class, here i create before and after method
     */
    ElementUtil elementUtil = new ElementUtil();

    private static Logger logger = Logger.getLogger(SharedSD.class);


    @Before
    public void setUp(){
        logger.info("**************************");
        logger.info("Test setup is starting...!");

        ConfigReader.getProperty("browser");
        BasePage.get().get(ConfigReader.getProperty("url"));
        BasePage.get().manage().window().maximize();
    }


    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            File scrFile = ((TakesScreenshot)BasePage.get()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(elementUtil.getScreenShot("pic")));
            } catch (IOException e) {

                e.printStackTrace();
            }
        }else{
            logger.info("Cleanup..!");
            logger.info("Test was completed...!");
        }
        logger.info("************************");
        BasePage.closeBrowser();
    }
}

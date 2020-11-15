package runnerTest.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilis.BasePage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class HomePage extends ElementUtil {

    By searchBox = By.xpath("//*[@id=\"searchForm\"]/input");
    By searchBtn = By.xpath("//a[@class='searchButton']");
    By times = By.xpath("//div[@class='hours']");


    public void enterCityName(String city) throws InterruptedException {
        clear(searchBox);
        Thread.sleep(3000);
        sendValue(searchBox, city);
    }

    public void clickSearchBtn() {
        clickOn(searchBtn);
    }


    public void verifyTimeZone(String city) throws InterruptedException {
        clear(searchBox);
        sendValue(searchBox, city);
        clickOn(searchBtn);
        Thread.sleep(4000);
        String timeZone = BasePage.get().getPageSource();
        int index = timeZone.indexOf("tz_offset = ");
        System.out.println(timeZone.substring(index + 12, index + 13));
        Date date = new Date();
        DateFormat gmtFormat = new SimpleDateFormat();
        TimeZone timeZone2 = TimeZone.getTimeZone("GMT" + "+" + timeZone.substring(index + 12, index + 13));
        gmtFormat.setTimeZone(timeZone2);
        System.out.println("Current Time at my location : " + date);
        System.out.println("Current Time at " + city + " : " + gmtFormat.format(date));
    }




    public void getTimeIncrement() {
        List<WebElement> time = BasePage.get().findElements(By.xpath("//div[@class='hours']/span/span"));

        ArrayList<Integer> hoursList = new ArrayList<>();

        for (int i=1;i<time.size();i++) {
            String allHours = time.get(i).getText();
            System.out.println("All hours : " + allHours);
            int hour = Integer.parseInt(allHours.replaceAll("[^0-9]", ""));
            hoursList.add(hour);
            System.out.println("Time list being converted to integer  : " + hoursList);
        }
        for(int j=1; j<3; j++ ){
            for(int k=j+1; k<4; k++){
                int difference =hoursList.get(k)-hoursList.get(j);

                if(!(difference==2)){
                    System.out.println("There are no 2 hours of increment");
                }else{
                    System.out.println("There are 2 hours of increment");
                }
            }
        }

    }



}
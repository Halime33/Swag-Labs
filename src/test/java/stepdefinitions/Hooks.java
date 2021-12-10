package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    @Before
    public void setUp(){

    }

    //Cucumberda normlade test fail olursa sonraki testler calismaz execution direkt durur.
    //Sayfa kapatmada yoktu. Hooks ile Eger sayfa fail verirse screenhot alacak. ve sayfayi dda kapatacak.
    //diger bir husus SeleniumGrid run edecegimiz zaman HOOKS kapatilmali.
    @After
    public void tearDown(Scenario scenario){
        final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png","screenshots");
        }
        Driver.closeDriver();
    }
}

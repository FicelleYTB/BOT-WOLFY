package fr.ficelleytb.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static WebDriver driver = null;
    public static String LoginName = "YOUR_NAME";
    public static String LoginPass = "YOUR_PASS";

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Ouvrir wolfy
        driver.navigate().to("https://wolfy.fr/auth/login");
        driver.manage().window().maximize();

        //Connection au compte
        try {
            WebElement NameloginForm = driver.findElement(By.name("login"));
            NameloginForm.sendKeys(LoginName);
            Thread.sleep(700);
            WebElement PassloginForm = driver.findElement(By.name("password"));
            PassloginForm.sendKeys(LoginPass);
            pressAnyKeyToContinue();
            Thread.sleep(600);
            System.out.println("Ok !");
            driver.findElement(By.className("Home_card__o_Q5X Home_instantPlay__3m-iu")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void pressAnyKeyToContinue()
    {
        System.out.println("Press Enter key to continue... (complete the captcha first)");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}

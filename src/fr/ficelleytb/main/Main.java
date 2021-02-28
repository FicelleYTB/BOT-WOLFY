package fr.ficelleytb.main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
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
            System.out.println("[BOT] Ok, im ready :) !");
            Thread.sleep(500);
            StartMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void pressAnyKeyToContinue() {
        System.out.println("Press Enter key to continue... (connect to your account and go to in game)");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    public static void StartMessage() {
        try {
            WebElement Chat = driver.findElement(By.tagName("textarea"));
            Chat.sendKeys("Yo les mék ça va ?" + Keys.ENTER);
            Thread.sleep(400);
            Chat.sendKeys("Moi ça va si on me demande en avance :) :D o:" + Keys.ENTER);
            Thread.sleep(400);
            Chat.sendKeys("Belle journée quand même (je raconte ma vie) :) :D o:" + Keys.ENTER);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isGameStartSoon(){
        WebElement Chat = driver.findElement(By.tagName("textarea"));
        WebElement timer = driver.findElement(By.className("Header_timeState__2bhUr Header_timer__36MsP"));
        if(timer.getText() == "0:05"){
            Chat.sendKeys("GL GL GL");
            return true;
        }
        return false;
    }
}

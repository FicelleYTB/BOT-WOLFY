package fr.ficelleytb.main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
            System.out.println("[BOT] Ok, im ready :) !");
            Thread.sleep(500);
            ToggleChat();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void pressAnyKeyToContinue() {
        System.out.println("Press Enter key to continue... (connect to your account and go to in game)");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    private static void ToggleChat() {
        try {
            WebElement Chat = driver.findElement(By.tagName("textarea"));
            Chat.sendKeys("Yo les mecs ça va ?" + Keys.ENTER);
            Thread.sleep(100);
            Chat.sendKeys("Moi ça va si on me demande en avance" + Keys.ENTER);
            Thread.sleep(100);
            Chat.sendKeys("Je parie que ça va être une bonne game pas vous?" + Keys.ENTER);
            Thread.sleep(100);
            Chat.sendKeys("Waw ça serais cool si ça commence mtn" + Keys.ENTER);
            Thread.sleep(100);
            Chat.sendKeys("Et si je vous dis que je n'ai pas écris ce message mais c'est un bout de code en java :o" + Keys.ENTER);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

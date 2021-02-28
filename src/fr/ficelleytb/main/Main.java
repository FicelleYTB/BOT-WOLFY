package fr.ficelleytb.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static WebDriver driver = null;

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Ouvrir wolfy
        driver.navigate().to("https://wolfy.fr");
        driver.manage().window().maximize();
    }
}

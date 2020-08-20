package suport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Chrome {
    public static final String AUTOMATE_USERNAME = "karolguerini1";
    public static final String AUTOMATE_ACCESS_KEY = "voD9sSxayY9a4vmr8cQY";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver creatChrome(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","/home/karolguerini/drivers/chromedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.manage().window().maximize();

        // Navegando para a página em Taskit
        navegador.get("http://www.juliodelima.com.br/taskit/");

        return navegador;
    }
    public static WebDriver creatBrowserStack() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1280x800");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "62.0");
        caps.setCapability("os", "Windows");

        WebDriver navegador = null;
        try {
            navegador = new RemoteWebDriver(new URL(URL), caps);
            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            navegador.manage().window().maximize();

            // Navegando para a página em Taskit
            navegador.get("http://www.juliodelima.com.br/taskit/");

        } catch (MalformedURLException e) {
            System.out.println("Houveram problemas com a URL" + e.getMessage());
        }

        return navegador;
    }
}

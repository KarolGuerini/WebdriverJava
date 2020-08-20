package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


    public class LoginPage extends BasePage {

        public LoginPage(WebDriver navegador) {
            super(navegador);
        }


        public LoginFormPage clicarSignIn() {
            navegador.findElement(By.linkText("Sign in")).click();

            return new LoginFormPage(navegador);
        }
    }
//em todas as páginas do pageobjects precisa ter um atributo privado e um construtor aguardando esse atributo


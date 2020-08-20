package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suport.Chrome;
import suport.Generator;
import suport.Screenshot;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "informacoesUsusarioTestData.csv")

public class informacoesUsusarioTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp() {
        navegador = Chrome.creatChrome();

        // Clicar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();

        // Identificando o formulário de Login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        // Digitar no campo com name="login" que está dentro do formulário de id="signinbox" o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        // Digitar no campo com name="password" que está dentro do formulário de id="signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        // Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        // Clicar em um link que possui a class="me"
        navegador.findElement(By.className("me")).click();

        // Clicar em um link que contenha o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }

    @Test
    public void testAdicionarUmaInformacaoDoUsuario(@Param(name = "tipo")String tipo, @Param(name = "contato")String contato, @Param(name = "mensagem")String mensagemEsperada){

        // Clicar no botão através do seu xPath //buton[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        // Identificar a modal onde está o formulário de id="addmoredata"
        WebElement modalAddMoreData = navegador.findElement(By.id("addmoredata"));

        // Na como de name="type' escolher a opção "Phone"
        WebElement campoType = modalAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        // No campo de name="contact" digitar "+5521999991234"
        modalAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        // Clicar no link que contenha o texto "SAVE" que está dentro da modal
        modalAddMoreData.findElement(By.linkText("SAVE")).click();

        // Na mensagem de id="toast-container" validar que o texto é "Your contact has been added!"
        WebElement mensagemDeOk = navegador.findElement(By.id("toast-container")); //capturei a mensagem que apareceu no popup
        String mensagem = mensagemDeOk.getText(); // atribuí o texto que estava dentro do popup a variável mensagem
        assertEquals(mensagemEsperada, mensagem); // fiz uma asserção para saber se a mensagem que tinha lá dentro era a mensagem que eu esperava

    }
    @Test
    public void RemoverUmContatoDeUmUsuario(){
    // Clicar no elemento através do xPath //span[text()="+5521999999999"]/following-sibling::a
    navegador.findElement(By.xpath("//span[text()=\"+5511999999999\"]/following-sibling::a")).click();

      // Confirmar a janela de Javascript
      navegador.switchTo().alert().accept();

      // Validar que a mensagem apresentada foi "Rest in peace, dear phone!"
      WebElement mensagemDeOk = navegador.findElement(By.id("toast-container"));
      String mensagem = mensagemDeOk.getText();
      assertEquals("Rest in peace, dear phone!", mensagem);

      String screenshotArquivo = "/home/karolguerini/prints-testes/taskit/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
      Screenshot.tirar(navegador, screenshotArquivo);


      // Aguardar até 10 segundos para que a janela desapareça do DOM(página)
        WebDriverWait aguardar = new WebDriverWait(navegador,10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemDeOk));

      // Clicar no link com o texto "Logout"
        navegador.findElement(By.linkText("Logout")).click();



    }
    @After
    public void tearDown() {
        // Fechar o navegador
        //navegador.quit();

    }
}

    // Validar que dentro do elemento class="me" está o texto "Hi, Julio"
    //WebElement me = navegador.findElement(By.className("me"));
    //String textoNoElementoMe = me.getText();
    //assertEquals("Hi, Julio", textoNoElementoMe);
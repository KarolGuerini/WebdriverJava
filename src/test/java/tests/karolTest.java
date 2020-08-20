package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class karolTest {
    @Test
    public void testMeuTesteKarol () {
        //abrindo o navegador
       System.setProperty("webdriver.chrome.driver", "/home/karolguerini/drivers/chromedriver");
        WebDriver navegacao = new ChromeDriver();

        //navegando na página about:blank
        navegacao.get("https://www.americanas.com.br");

        //validação
        assertEquals("1","1");

    }
}
//primeiro: vai em Tests, clica em nova classe java, e coloca o nome do arquivo com o final Test. ex: KarolTest
//segundo: coloca @Test que é o método de teste e ele vai importar o pacote de testes do Junit
//terceiro: coloca public void onde public é regra que o teste precisa ser público e
//void é a regra do junit que diz que o teste não pode retornar nenhum valor
//quarto: digita Assert clica enter e importa o pacote Assert
//quinto: vai em import org.junit.Assert e coloca o static após o import e um .* após o Asseert. isso quer dizer que
//você vai fazer uma importação estática de todos os métodos que tem dentro da classe Assert. Com isso, não precisa
//escrever Assert antes de uma asserção. exe:antes: Assert.assertEquals() depois: assertEquals()
//sexto: coloca  System.setProperty, que recebe o parâmetro de qual a chave você quer setar, no caso é webdriver.chrome.diver
// o outro parâmetro é onde está o binário desse parâmetro, nesse caso /home/karolguerini/drivers/chromedriver
//exemplo linux e mac: System.setProperty("webdriver.chrome.driver","/home/karolguerini/drivers/chromedriver");
//exemplo windows: System.setProperty("webdriver.chrome.driver","C:\\karolguerini\\drivers\\chromedriver.exe");
// usa-se \\ pois no windows quando se usa java e coloca / ele entende que é um comando, por isso precisa colocar  o \\
//sétimo: digita WebDriver e clica enter que ele vai importar o pacote do browser
//oitavo: após importar os pacotes de Webdriver, cria uma variável que recebe um objeto, exe: WebDriver navegador = new ChromeDriver
//no caso acima ele está dizendo que é pra abrir o navegador
//nono: após criar a variável, pega-se ela e manda ela abrir o navegador onde você deseja, usando o método get. exe: navegador.get(about:blank)
//no caso acima, você está dizendo pro navegador abrir em uma página. pode ser qualquer página (com http)
//décimo: tem que colocar uma validação(pode ser antes, durante ou no final do script). O teste precisa ser validado.


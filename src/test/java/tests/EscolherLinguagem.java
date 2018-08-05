package tests;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EscolherLinguagem {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chromer.driver","C:\\Users\\FC\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.avianca.com.br");
    }

    @Test
    public void first_EscolhendoIdiomaEspanhol() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement radioButtonES = driver.findElement(By.cssSelector("label[for='es_ES']"));
        WebElement btnEnviar = driver.findElement(By.cssSelector("button.modal-red-btn.hidden-sm.hidden-xs"));

        wait.until(ExpectedConditions.elementToBeClickable(radioButtonES));
        radioButtonES.click();

        wait.until(ExpectedConditions.elementToBeClickable(btnEnviar));
        btnEnviar.click();
        Thread.sleep(5000);

        String expectedMessage = "Mejores Ofertas de Vuelos";
        String message = driver.findElement(By.cssSelector("p[class='fwb tal fz-28 title-offer']")).getText();
        Assert.assertTrue("Mensagem não encontrada", message.contains(expectedMessage));

        System.out.println("Texto encontrado: " + message);
        System.out.println("-----------Teste realizado com sucesso-----------");
    }

    @Test
    public void second_EscolhendoIdiomaIngles() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement radioButtonEN = driver.findElement(By.cssSelector("label[for='en_US']"));
        WebElement btnEnviar = driver.findElement(By.cssSelector("button.modal-red-btn.hidden-sm.hidden-xs"));

        wait.until(ExpectedConditions.elementToBeClickable(radioButtonEN));
        radioButtonEN.click();

        wait.until(ExpectedConditions.elementToBeClickable(btnEnviar));
        btnEnviar.click();
        Thread.sleep(5000);

        String expectedMessage = "Best Offers";
        String message = driver.findElement(By.cssSelector("p[class='fwb tal fz-28 title-offer']")).getText();
        Assert.assertTrue("Mensagem não encontrada", message.contains(expectedMessage));

        System.out.println("Texto encontrado: " + message);
        System.out.println("-----------Teste realizado com sucesso-----------");
    }
    @Test
    public void third_EscolhendoIdiomaPortugues() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement radioButtonPT = driver.findElement(By.cssSelector("label[for='pt_BR']"));
        WebElement btnEnviar = driver.findElement(By.cssSelector("button.modal-red-btn.hidden-sm.hidden-xs"));

        wait.until(ExpectedConditions.elementToBeClickable(radioButtonPT));
        radioButtonPT.click();

        wait.until(ExpectedConditions.elementToBeClickable(btnEnviar));
        btnEnviar.click();
        Thread.sleep(5000);

        String expectedMessage = "Melhores ofertas de voos";
        String message = driver.findElement(By.cssSelector("p[class='fwb tal fz-28 title-offer']")).getText();
        Assert.assertTrue("Mensagem não encontrada", message.contains(expectedMessage));

        System.out.println("Texto encontrado: " + message);
        System.out.println("-----------Teste realizado com sucesso-----------");
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}


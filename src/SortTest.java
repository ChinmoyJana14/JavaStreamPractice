import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[@role='columnheader']/span[contains(.,'Veg/fruit')]/following-sibling::span"))).click();

		List<WebElement> original = driver.findElements(By.xpath("//table//tr//td[1]"));
		List<String> veggiesFromApp = original.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> ManuallySortedVeggies = veggiesFromApp.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(ManuallySortedVeggies.equals(veggiesFromApp));
		

	}


}


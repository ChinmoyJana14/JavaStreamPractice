import java.time.Duration;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FilterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Ri");
		List<WebElement> searchVeggies = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> searchVeggiesFiltered = searchVeggies.stream().filter(i->
				StringUtils.containsIgnoreCase(i.getText(),"Ri")).collect(Collectors.toList());
				//filter(s->s.getText().contains("Ri")).collect(Collectors.toList());
				//Used org.apache.commons.lang3.StringUtils.containsIgnoreCase else need to lower/upper case the string
		
		Assert.assertEquals(searchVeggies.size(), searchVeggiesFiltered.size());
	}

}

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		List<String> price;
		do {
			List<WebElement> originalVeggies = driver.findElements(By.xpath("//table//tr//td[1]"));	//This block is inside to avoid stale-element-reference-exception	
			price = originalVeggies.stream().filter(s->
			s.getText().contains("Rice")).map(s->getPrice(s)).collect(Collectors.toList());
			price.forEach(s->System.out.println(s));			
			if(price.size()<1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		} while(price.size()<1);
	}
	

	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub
		return s.findElement(By.xpath("following-sibling::td[1]")).getText(); //table//td[contains(.,'Rice')]/following-sibling::td[1]
				
	}

}

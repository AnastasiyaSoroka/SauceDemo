import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class checkLoginLocatorsTest extends Settings {

    @Test
    public void checkLoginLocators() {

        driver.findElement(By.className("login_logo"));
        driver.findElement(By.className("bot_column"));
        driver.findElement(By.id("user-name"));
        driver.findElement(By.id("password"));
        driver.findElement(By.id("login-button"));
        driver.findElement(By.id("login_credentials"));
        driver.findElement(By.className("login_password"));
    }

    @Test
    public void checkLoginWorks() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Incorrect URL opened");
    }


    @Test
    public void checkShopLocators() {


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.className("shopping_cart_container"));
        driver.findElement(By.xpath("//button[text()='Open Menu']"));
        driver.findElement(By.className("bm-menu"));
        driver.findElement(By.id("inventory_sidebar_link"));
        driver.findElement(By.id("about_sidebar_link"));
        driver.findElement(By.id("logout_sidebar_link"));
        driver.findElement(By.id("reset_sidebar_link"));
        driver.findElement(By.xpath("//button[text()='Close Menu']"));
        driver.findElement(By.className("header_secondary_container"));
        driver.findElement(By.className("product_label"));

        Select dropDown = new Select(driver.findElement(By.className("product_sort_container")));
        List<WebElement> dropDownOptions = dropDown.getOptions();
        boolean counterBoolean = false;
        if (dropDownOptions.size() != 0) {
            counterBoolean = true;
        }
        Assert.assertTrue(counterBoolean, "There should be some options in the dropdown");

        driver.findElement(By.className("inventory_list"));
        driver.findElement(By.xpath("//*[@class='inventory_list']"));

        driver.findElement(By.className("social_twitter"));
        driver.findElement(By.className("social_facebook"));
        driver.findElement(By.className("social_linkedin"));
    }

    @Test
    public void logShopItemsPrice() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        WebElement elm = driver.findElement(By.xpath("//*[@class='inventory_list']"));

        if (elm.findElements(By.className("inventory_item")).size() > 0) {


            for (int i = 1; i <= elm.findElements(By.className("inventory_item")).size(); i++) {


                String child_item_name = "//*[@class='inventory_list']/*[" + i + "]//*[@class='inventory_item_name']";
                String child_item_price = "//*[@class='inventory_list']/*[" + i + "]//*[@class='inventory_item_price']";
                System.out.println(driver.findElement(By.xpath(child_item_name)).getText() + " - " + driver.findElement(By.xpath(child_item_price)).getText());

            }

        }

    }


}



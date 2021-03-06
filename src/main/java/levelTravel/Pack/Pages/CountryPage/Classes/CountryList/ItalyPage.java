package levelTravel.Pack.Pages.CountryPage.Classes.CountryList;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryWholePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItalyPage extends CountryWholePage {

    private By heading = By.xpath("//h1[@class='search-page-title']/span");

    public String getTextLoadingHeading(){
        WebElement element = find(heading);
        return element.getText();
    }

}

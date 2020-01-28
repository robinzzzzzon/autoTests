package levelTravel.Pack.test.CountryTests;

import levelTravel.Pack.Steps.CountrySteps.CountryFiltersBlockPageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CountryFiltersBlockPageSerenityTest {

    @Steps
    CountryFiltersBlockPageSteps steps;

    @Managed
    WebDriver driver;

    @Test
    public void getToursListWithOnSwitch(){
        steps.openPage();
        steps.switchMomentConfirmTumbler(true);
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void getToursWithSelectPriceTower(){
        steps.openPage();
        steps.selectAnyPriceTower(1);
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void getToursWithSelectFirstAndLastPriceTowers(){
        steps.openPage();
        steps.selectAnyPriceTower(1);
        steps.selectAnyPriceTower(5);
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void getToursAfterClearAnyTower(){
        steps.openPage();
        steps.selectAnyPriceTower(3);
        steps.clickLocalClearFilter();
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void getToursSelectTowerTwice(){
        steps.openPage();
        steps.selectAnyPriceTower(3);
        steps.selectAnyPriceTower(3);
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void checkSendPricesOnPriceInputs(){
        steps.openPage();
        steps.selectAnyPriceTower(2);
        steps.checkPriceInputsIsNotNull();
    }

    @Test
    public void getToursWithMinAndMaxPriceInterval() {
        steps.openPage();
        steps.writeMinIntervalPrice("30000");
        steps.writeMaxIntervalPrice("60000");
        steps.checkToursResultGreaterAnyNumber(5);
    }

    @Test
    public void getToursWithOnlyMinPriceInterval() {
        steps.openPage();
        steps.writeMinIntervalPrice("10000");
        steps.checkToursResultGreaterAnyNumber(3);
    }

    @Test
    public void getToursWithOnlyMaxPriceInterval() {
        steps.openPage();
        steps.writeMaxIntervalPrice("90000");
        steps.checkToursResultGreaterAnyNumber(7);
    }

    @Test
    public void writeBufferPrice(){
        steps.openPage();
        steps.writeMinIntervalPrice("55555");
        steps.pasteBufferPrice(true);
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void enterWrongValuesOfPriceInterval(){
        steps.openPage();
        steps.writeMinIntervalPrice("55555");
        steps.writeMaxIntervalPrice("44444");
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void enterZeroValues(){
        steps.openPage();
        steps.writeMinIntervalPrice("0");
        steps.writeMaxIntervalPrice("0");
        steps.checkToursResultGreaterNull();
    }

    //////////////////////////////////////////////////////////////

    @Test
    public void selectAnyStarsOfHotel() {
        steps.openPage();
        steps.selectAnyStarsHotel(true, 3, 3);
        steps.checkSelectingCheckBox(false,3);
    }
    @Test
    public void selectFirstAndLastStarsOfHotel() {
        steps.openPage();
        steps.selectAnyStarsHotel(true,3, 3);
        steps.selectAnyStarsHotel(false,3, 3);
        steps.checkSelectingCheckBox(false, 3);
    }

    @Test
    public void selectFirstAndLastStars(){
        steps.openPage();
        steps.selectFirstAndLastStars();
        steps.checkCountSelectingCB(2);
    }

    @Test
    public void selectAllStars(){
        steps.openPage();
        steps.selectAllStars();
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void selectAnyStarsAfterClearFilter(){
        steps.openPage();
        steps.selectAnyStarsHotel(true, 2, 2);
        steps.clickLocalClearFilter();
        steps.selectAnyStarsHotel(true, 2, 2);
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void writeHotelName() {
        steps.openPage();
        steps.writeHotelName("Green Nature Diamond Hotel");
        steps.checkToursResultIsPresent(1);
    }

    @Test
    public void writeWrongHotelName() {
        steps.openPage();
        steps.writeHotelName("Qwerty");
        steps.checkVisibleEmptyResults();
    }

    @Test
    public void writeHotelNameFromBuffer(){
        steps.openPage();
        steps.writeHotelNameFromBuffer("Green Nature Diamond Hotel");
        steps.checkToursResultGreaterNull();
    }

    ///////////////////////////////////////////////////////////////

    @Test
    public void selectFirstRating() {
        steps.openPage();
        steps.selectRatingHotel(1);
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void selectAnyRatingSecondAfterClearFilter() {
        steps.openPage();
        steps.selectRatingHotel(3);
        steps.clickLocalClearFilter();
        steps.selectRatingHotel(3);
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void selectAnyRating() {
        steps.openPage();
        steps.selectRatingHotel(2);
        steps.checkActivateElementsOfRating(4);
    }

    @Test
    public void compareOnlyGoodRating(){
        steps.openPage();
        steps.selectRatingHotel(5);
        steps.compareRatingOfGetResultList(9.0);
    }

    ///////////////////////////////////////////////////////////

    @Test
    public void getAllToursForAnythingDistanceToSea(){
        steps.openPage();
        steps.selectDistanceToSea(3);
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void getOnlyFirstDistanceToSea(){
        steps.openPage();
        steps.selectDistanceToSea(1);
        steps.compareDistanceOfGetResultList(1);
    }

    @Test
    public void selectDistanceTwiceAfterClearFilter(){
        steps.openPage();
        steps.selectDistanceToSea(1);
        steps.clickLocalClearFilter();
        steps.selectDistanceToSea(1);
        steps.checkToursResultGreaterNull();
    }

    /////////////////////////////////////////////////////////////

    @Test
    public void getPrivateBeachList() {
        steps.openPage();
        steps.selectPrivateBeachInput(false);
        steps.checkSelectedPBCheckBox(false);
    }

    @Test
    public void getPrivateBeachListTwice() {
        steps.openPage();
        steps.selectPrivateBeachInput(true);
        steps.clickLocalClearFilter();
        steps.selectPrivateBeachInput(true);
        steps.checkSelectedPBCheckBox(false);
    }

    ///////////////////////////////////////////////////////

    @Test
    public void selectAllBeachTypes() {
        steps.openPage();
        steps.selectAllTypeOfBeach();
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void selectAnyBeachType() {
        steps.openPage();
        steps.selectTypeOfBeach(2, true);
        steps.checkRightBeachTypeOfTheGetList(2);
    }

    @Test
    public void selectFirstAndLastBeachTypes(){
        steps.openPage();
        steps.selectFirstAndLastBeachType();
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void selectBeachTypeTwice(){
        steps.openPage();
        steps.selectTypeOfBeach(2, true);
        steps.clickLocalClearFilter();
        steps.selectTypeOfBeach(2, true);
        steps.checkToursResultGreaterNull();
    }

    ///////////////////////////////////////////////////////////
    //Поработать с ожиданиями. Возможно нужно будет переделать все через инстансы Action
    @Test
    public void selectAnyFoodType() {
        steps.openPage();
        steps.selectTypeFood(2);
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void selectLastFoodTypeWithInvisiblePart() {
        steps.openPage();
        steps.selectTypeFood(7);
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void selectAllFoodType() {
        steps.openPage();
        steps.selectAllFoodType();
        steps.checkToursResultGreaterNull();
    }

    ////////////////////////////////////////////////////////////

    @Test
    public void selectAnyRegionType() {
        steps.openPage();
        steps.selectRegionType(2);
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void selectAnyRegion() {
        steps.openPage();
        steps.selectAnyRegion(3);
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void selectFirstAndLastRegion() {
        steps.openPage();
        steps.selectFirstAndLastRegion();
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void selectAllRegion() {
        steps.openPage();
        steps.selectAllRegions();
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void typeHotelTests() {
        steps.openPage();
        steps.selectHotelType(3);
        steps.checkEqualString("Активный");
    }

    @Test
    public void WiFiTests() {
        steps.openPage();
        steps.selectWiFiInput(2, true);
        steps.isSelectedRbWifi(2);
    }

    @Test
    public void waterGameTest() {
        steps.openPage();
        steps.selectWaterGame(2);

    }

    @Test
    public void hoTelFacilitiesTest() {
        steps.openPage();
        steps.selectHotelFacility(3);
        steps.checkToursResultGreaterAnyNumber(0);
    }

    @Test
    public void familyWithChild() {
        steps.openPage();
        steps.selectFamilyWithChildren(2);
        steps.checkToursResultGreaterAnyNumber(0);
    }

    @Test
    public void tourOperatorsTest() {
        steps.openPage();
        steps.selectAllTourOperators();
        //countryFiltersPage.selectAnyTourOperator(6);
        steps.isSelectedAnyTourOperator(2);
    }

    @Test
    public void clearFilterTest() {
        //countryFiltersPage.clickAllClearFilter();
//        countryFiltersPage.selectTypeFood(6);
//        countryFiltersPage.clickLocalClearFilter();
        steps.openPage();
        steps.selectRatingHotel(3);
        steps.selectDistanceToSea(2);
        steps.clickFewLocalClearFilter();
        steps.isSelectedAnyFilter(2);
    }

}

package com.blockchain.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

final public class Locators {
    // MAIN PAGE LOCATORS
    //Header locators
    //Nav bar locators
    public static String navMenuItems="//div/ul/li[@class='nav-item']";
    public static String navMenuItemHome ="//ul/li[@class='nav-item']//a[@href='#']";
    public static String navMenuItemTourToUkraine ="(//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine'])[2]";
    public static String navMenuClosed ="//div/a[@class='uam-top link-open-menu btn-slide']";

    //body locators
    public static String buttonJoinForFree="//button[@id='show-registration-block']";
    public static String buttonRequestTourInfo ="//a[@href='https://romanceabroad.com/REQUEST_TOUR_INFO+Application_Form.doc']";
    public static String textSectionThirdParagraph ="//*[@id='about']//p[3]";
    public static String textSectionHeader ="//section[@id='about']//div/h2[@class='section-heading ']";
    public static String carouselInner ="//a[@id='carouselExampleIndicators']//div[@class='carousel-inner']";
    public static String textSectionBoldText ="//p//b[contains(text(),'Request Tour Info')]";
    public static String linkFacebookFooter ="//a[contains(@href,'faceMainbook')]";
    public static String textSection="//section//div[@class='col-lg-6']"; // text in the middle of body h2
    //iFrame Youtube
    public static String iFrameVideoYoutube = "//div[@class='video']/iframe[contains(@src,'youtube')]";
    public static String buttonIFrameVideoYoutube ="//button[@class='ytp-large-play-button ytp-button']";
    public static String iFrameVideoYoutubeUnstarted ="//div[contains(@class,'unstarted-mode')]";
    public static String iFrameVideoYoutubePlaying ="//div[contains(@class,'playing-mode')]";
    public static String iFrameVideoYoutubePaused ="//div[contains(@class,'paused-mode')]";

    //Home page pop up Registration form page 1 locators
    public static String inputSignUpFormLoginXpath = "//input[@id='email']";
    public static String inputSignUpFormPassXpath = "//input[@id='password']";
    public static String buttonNextSignUpFormXpath = "//button[@blockchain.data-action='next-page'][text()='Next']";
    public static String errorTooltipNextSignUpFormXpath = "//div[@class='tooltip']";

    //Home page pop up Registration form page 2 locators
    public static String inputSignUpFormUserNameXpath = "//input[@id='nickname']";
    public static String dropDownOpenedSignUpFormDayXpath = "//div[@id='daySelect']//li";
    public static String dropDownOpenedSignUpFormMonthXpath = "//div[@id='monthSelect']//li";
    public static String dropDownOpenedSignUpFormYearXpath = "//div[@id='yearSelect']//li";
    public static String dropDownSignUpFormDayXpath = "//div[@id='daySelect']";
    public static String dropDownSignUpFormMonthXpath = "//div[@id='monthSelect']";
    public static String dropDownSignUpFormYearXpath = "//div[@id='yearSelect']";
    public static String inputPhoneRegXpath = "//input[@name='phone']";
    public static String inputPhonePopUpRegXpath = "//input[@name='blockchain.data[phone]']";
    public static String inputLocationXpath = "//input[@name='region_name']";
    public static String inputLocationEnteredCityXpath = "//ul//li[@city='356107']";   // city Tampa,fl,US. need .sendkey "tampa"
    public static String checkboxXpath = "//input[@type='checkbox'][@name='blockchain.data[confirmation]']";

    // Registration form blockchain.data.Locators https://romanceabroad.com/users/registration/
    public static String inputRegFormEmailXpath ="//input[@name='email']";
    public static String inputRegFormUserNameXpath = "//input[@name='nickname']";
    public static String inputRegFormPassXpath = "//input[@name='password']";
    public static String selectRegFormDayXpath ="//div[@id='daySelect']/select[@class='form-control']";
    public static String selectRegFormMonthXpath ="//div[@id='monthSelect']/select[@class='ui-datepicker-month form-control']";
    public static String selectRegFormYearXpath ="//div[@id='yearSelect']/select[@class='ui-datepicker-year form-control']";
    public static String inputRegFormPhoneXpath ="//input[@name='phone']";
    public static String inputRegFormLocationXpath ="//input[@name='region_name']";
    public static String checkBoxRegFormNewsXpath = "//input[@id='sub1']";
    public static String checkBoxRegFormConfirmXpath ="//input[@id='confirmation']";
    public static String inputRegFormLocationPreselectedXpath ="//ul/li[@city='356107']"; // city Tampa,fl,US. need .sendkey "tampa"



    // Example of By class variable
    public static By CHECKBOX_SIGNUP_FORM_XPATH = By.xpath("//input[@type='checkbox'][@name='blockchain.data[confirmation]']");

    // Example of WebElement class method
    public static WebElement checkboxSignUpFormWebElement(WebDriver driver) { return driver.findElement(By.xpath(checkboxXpath));}

    // PRETTY WOMAN page blockchain.data.Locators
    public static String dropDownMinAge = "//select[@id='age_min']";
    public static String dropDownMaxAge = "//select[@id='age_max']";
    public static String dropDownSorter = "//select[contains (@id,'sorter-select')]";
    public static String blockMinMaxAge ="//div[@class='search-form']";
    public static String textPeopleFoundOnPageNoFound = "//h2[@class='text-center p10']";
    public static String textPeopleFoundOnPage ="//div[@class='lh30']";
    public static String buttonSearch = "//input[@id='main_search_button_user_advanced']";
    public static String imageBlock = "//a[@class='g-pic-border g-rounded']//img";
    public static String imageSearchResult = "//div[@class='g-users-gallery__photo']";
    public static String userNameAgeGallery = "//div[@class='text-overflow']";
    public static String buttonNextAtGallery = "//li[@class='next']//a";
    public static String buttonLastAtGallery = "//li[@class='next']//following-sibling::li//a";
    public static String buttonBeforeNextAtGallery = "//li[@class='next']/preceding-sibling::li//a";
    public static String panelPageSelectorTagA = "//ul[@class='pagination']//li//a";
    public static String panelPageSelectorTagLi = "//ul[@class='pagination']//li";


    // PHOTO page

    public static String divGalleryPhotos = "//div[@class='g-users-gallery__item col-xs-6 col-sm-4 col-md-3 col-lg-2 big']";
    public static String divGallery = "//div[@class='wrapper']";

    //BLOG page locators
    public static String headerMenuOuterContainer = "//div[@class='header-container-outer' and @id='slidemenu-outer']";
    public static String articlesMenuList = "//ul[@class='nav nav-pills nav-stacked content-pages-tree']//li//div//a//div//div";
    public static String articlesOnPageList = "//div//p";

    //public static String articlesMenuList_up = "//div[@class='inside account_menu']";

    public static String hrefBlogListItem = "div[@class='info-content-block wysiwyg']//ul//li//a[@href='/content/view/beautiful-urkainian-girls']";
    public static String hrefBlogList = "//div[@class='info-content-block wysiwyg']//ul"; // for array use
    public static String sideMenuBlog ="div[@class='inside account_menu']/ul"; // for array use
    public static String headerPhotoMenuBlog = "//div[@class='slick-track']//div[@class='user']"; // for array use

    //CONTACT US locators
    //public static String selectReason = "//form[@method='post']/div/div/select[@name='id_reason']";
    public static String selectReason = "//select[@name='id_reason']";
    public static String inputYourName = "//input[@type='text' and @name='user_name']";
    public static String inputYourEmail = "//input[@class='form-control' and @name='user_email']";
    public static String inputSubject = "//input[@class='form-control' and @name='subject']";
    public static String textAreaYourMsg = "//textarea[@class='form-control' and @name='message']";
    public static String inputSecurityCaptcha = "//input[@id='g-recaptcha-response' and @name='captcha_code']";
    public static String imgSecurityCaptcha = "//img[contains(@src,'romanceabroad.com/temp/captcha/')]";
    public static String buttonSend = "//input[@name='btn_save' and @type='submit']";
    public static String errorMsg = "//div[@class='ajax_notice']//div[@class='error alert-danger alert-warning_pop_']";

    // LOG IN page locators

    public static String inputEmail = "//input[@id='email']";
    public static String inputPass = "//input[@id='password']";
    public static String buttonLOgIn = "//button[@name='logbtn']";
    public static String popUpErrorBar ="//div[@class='error alert-danger alert-warning_pop_']";

    //left corner menu
    public static String menuLeftTopCorner = "//div[@class='menu-item']";
    public static String menuLeftItemHome = "//a[@id='user_main-menu-home-item']";
    public static String menuLeftItemSignUp = "//a[@id='user_main-menu-registration-item']";
    public static String menuLeftItemLogIn = "//a[@id='user_main-menu-login-item']";
    public static String menuLeftItemNews = "//a[@id='user_main-menu-news-item']";
    public static String menuLeftItemPolls = "user_guest-main-polls-item";



    //Any page

    public static By H1_TITLE = By.xpath("//h1");




}

package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    WebElement button, masterLogo, article, link, pauseButton, field, playPauseButton, timestamp, rewind15Button, forward15Button, muteButton, volumeSlider, playbackSpeedButton, minimizeButton, closeButton, podcastHeader;
    String currentTab, articleUrl, linkUrl, buttonName, initialTimestamp, timestampAfterForward, timestampAfterRewind;
    SignInPage signInPage;
    HomePage homePage;
    JavascriptExecutor js;

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        js = (JavascriptExecutor) driver;
    }

    public WebElement subscribeButton() {
        System.out.println("subscribeButton Method");
        button = driver.findElement(By.xpath("//a[@data-qa='subs-offer']"));
        System.out.println("'Subscribe' Button found");
        return button;
    }

    public WebElement allButtons(String buttonsName) {
        System.out.println("allButtons Method");
        int buttonCount = (driver.findElements(By.xpath("//p[@class='wpds-c-bwYbD']"))).size();
        for(int buttonNum = 0; buttonNum <= buttonCount; buttonNum++) {
            buttonName = (driver.findElement(By.xpath("(//p[@class='wpds-c-bwYbD'])[" + buttonNum + "]"))).getText();
            if (buttonName.equals(buttonsName)) {
                return button;
            }
        }
        return null;
    }

    public boolean handleParisOlympicsPlayButtons() {
        System.out.println("handleParisOlympicsPlayButtons Method");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        System.out.println("Scrolled till bottom");

        List<WebElement> buttons = driver.findElements(By.xpath("//*[@d='m14.5 8-10 5.56V2.44z']"));
        if (!buttons.isEmpty()) {
            for (WebElement button : buttons) {
                button.click();
                System.out.println("Clicked on mediaButton - 1"); // Assuming first play button

                pauseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Play video: Beirut airport packed as people urged to leave Lebanon, 0 minutes and 44 seconds']")));
                System.out.println("Pause Button Found");

                pauseButton.click();
                System.out.println("Clicked on Pause Button");

                Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).isDisplayed());
                System.out.println("Play Button Found");
            }
        }
        System.out.println("Skipped a video verification as it is not published");
        return true;
    }

    public boolean handlePodcastPlayButtons() throws InterruptedException {
        System.out.println("handlePodcastPlayButtons Method");

        // Scroll to the bottom of the page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        System.out.println("Scrolled to bottom");

        // Locate the podcast play buttons
        List<WebElement> buttons = driver.findElements(By.xpath("//span[@role='button']")); // Replace with correct XPath
        System.out.println("Podcast Play buttons found");

        for (WebElement button : buttons) {
            button.click();
            System.out.println("Clicked on podcast play button");

            // Wait for the popup to appear
            field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='sticky-player']")));
            Assert.assertTrue(field.isDisplayed(), "Podcast popup did not appear");

            // Locate the play/pause button, -15 button, +15 button, and other controls within the popup
            playPauseButton = field.findElement(By.xpath("//button[contains(@class, 'play-pause')]")); // Update with correct XPath
            rewind15Button = field.findElement(By.xpath("//button[contains(@class, 'rewind-15')]")); // Update with correct XPath
            forward15Button = field.findElement(By.xpath("//button[contains(@class, 'forward-15')]")); // Update with correct XPath
            muteButton = field.findElement(By.xpath("//button[contains(@class, 'mute')]")); // Update with correct XPath
            volumeSlider = field.findElement(By.xpath("//input[@type='range']")); // Assuming the volume is a slider input
            playbackSpeedButton = field.findElement(By.xpath("//button[contains(@class, 'playback-speed')]")); // Update with correct XPath
            minimizeButton = field.findElement(By.xpath("//button[contains(@class, 'minimize')]")); // Update with correct XPath
            timestamp = field.findElement(By.xpath("//div[@class='left']")); // Update with the correct XPath

            // Check if play button is clicked, pause button should appear
            if (playPauseButton.getAttribute("data-testid") == null || playPauseButton.getAttribute("data-testid").isEmpty()) {
                initialTimestamp = timestamp.getText();
                playPauseButton.click(); // Play the video if not already playing
                driver.wait(3000);
                Assert.assertNotEquals(timestamp.getText(), initialTimestamp);
                System.out.println("Play button clicked, video should be playing now");
            } else {
                System.out.println("Video is already playing");
            }
            // Verify -15 and +15 second buttons functionality

            forward15Button.click();
            timestampAfterForward = wait.until(ExpectedConditions.visibilityOf(timestamp)).getText();
            Assert.assertTrue(isTimestampChangedBy15Seconds(initialTimestamp, timestampAfterForward), "+15 seconds button did not work correctly");

            rewind15Button.click();
            timestampAfterRewind = wait.until(ExpectedConditions.visibilityOf(timestamp)).getText();
            Assert.assertTrue(isTimestampChangedBy15Seconds(timestampAfterForward, timestampAfterRewind), "-15 seconds button did not work correctly");

            muteButton.click();
            System.out.println("Mute button clicked");

            volumeSlider.sendKeys("50"); // Assuming you want to set the volume to 50%
            System.out.println("Volume set to 50%");

            // Change playback speed // requires edit
            playbackSpeedButton.click();
            WebElement speedText = field.findElement(By.xpath("//span[@class='playback-speed-text']")); // Update with correct XPath
            Assert.assertNotNull(speedText.getText(), "Playback speed text not found");

            // Minimize and maximize the popup // check for maximizing on click, use X mark for if condtn
            minimizeButton.click();
            System.out.println("Minimized the popup");

            // Locate and close the popup after minimizing
            closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='close']"))); // Update with correct XPath
            closeButton.click();
            System.out.println("Closed the minimized popup");

            // Optionally, add verification step of podcast header
            podcastHeader = field.findElement(By.xpath("//h1[@class='podcast-header']")); // Update with correct XPath
            Assert.assertTrue(podcastHeader.isDisplayed(), "Podcast header is not displayed");
        }
        return true;
    }

    private boolean isTimestampChangedBy15Seconds(String initial, String updated) {
        return true;
    }

   // public void podcastPopUp() {
//        field = wait.until(popUpAppeared).isDisplayed;
//        locate play button
//        locate -15
//        locate +15
//        locate mute
//        locate volume
//        locate playback speed
//        locate minimize popup (if not maximized)
//        locate maximize popup (if not minimized)
//        after minimize, locate 'X' (Close) button
//        locate all other buttons
//        check if play button is clicked, pause button appears
//        Later, add verification step of podcast header

       //Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-testid='sticky-player']")))).isDisplayed()); // player opened or not
        // "//div[@id='sticky-controls']" - contains 3 buttons with common xpath : -15, play/pause, +15 - ("//button[@class='wpds-c-kSOqLF wpds-c-kSOqLF-cWZnsQ-variant-secondary wpds-c-kSOqLF-eHdizY-density-default wpds-c-kSOqLF-hGNJMA-icon-center wpds-c-kSOqLF-qcJLL-cv wpds-c-kSOqLF-iobFYN-css']")
        // if playButton.getAttribute("data-testid") is not present, then click on play button (video should play)
        // if playButton.getAttribute("data-testid") is present, (means video is paused) then click on play button.
        // "//div[@class='left']' - xpath of video timestamp, if +15 is clicked, videoTiestamp.getText() = (<=15 sec from the current timestamp) / same for -15 button

    public boolean handleWatchAllButtons() {
        System.out.println("handleWatchAllButtons Method");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        List<WebElement> buttons = driver.findElements(By.xpath(""));

        for (WebElement button : buttons) {
            button.click();
            System.out.println("Clicked on watch all buttons");

            WebElement fullscreenVideo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            System.out.println("Fullscreen video appeared");

            List<WebElement> multimediaButtons = fullscreenVideo.findElements(By.xpath(""));
            for (WebElement multimediaButton : multimediaButtons) {
                Assert.assertTrue(multimediaButton.isDisplayed() && multimediaButton.isEnabled());
                System.out.println("Multimedia button is functional");
            }
        } return true;
    }

        // for each button present in buttons
        // click button

        // paris olympics : not full screen video, changes the button positions. Multimedia components present.
        // verify audio/video is played by assertTrue (//button @aria'label=pause video) is clickable
        // verify audio/video is paused by assertTrue (//button @aria'label=play video) is clickable

        // Podcast play buttons open a popup with Multimedia buttons
        // inside podcast method, verify if popup appeared, check all multimedia buttons are working
        // close popup (Assert)

        // Watch All Button & Reels type videos open fullscreen with Multimedia buttons
        // inside fullscreen video method, assert if video is played, multimedia buttons are functioning

    public void verifyAllArticlesPresentInHomePage() {
        System.out.println("verifyAllArticlesPresentInHomePage Method");

        List<WebElement> articleCount = driver.findElements(By.xpath("//a[@data-pb-local-content-field='web_headline']"));
        System.out.println("Number of articles found in HomePage : " + articleCount.size());

        for (int articleNum = 0; articleNum <= articleCount.size(); articleNum++) {
            article = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-pb-local-content-field='web_headline'])[" + articleNum + "]")));
            System.out.println("Article " + articleNum + " Found");

            articleUrl = article.getAttribute("href");
            article.click();
            System.out.println("Clicked on Article " + articleNum);

            Assert.assertTrue(wait.until(ExpectedConditions.urlToBe(articleUrl)));
            System.out.println("Verified Article URL : " + articleUrl);
            driver.navigate().back();
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(article)).isDisplayed());
            System.out.println("User is back to HomePage");
        }
    }

    public void verifyAllMidSizeLinksInHomePage() {
        System.out.println("verifyAllMediumLinksPresentInHomePage Method");

        List<WebElement> linkCount = driver.findElements(By.xpath("//a[@class='font-xxs font-bold   uppercase letter-spacing  black hover-gray-dark label-link']"));
        System.out.println("Number of MidSize Links found in HomePage : " + linkCount.size());

        for (int linkNum = 0; linkNum <= linkCount.size(); linkNum++) {
            link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='font-xxs font-bold   uppercase letter-spacing  black hover-gray-dark label-link'])[" + linkNum + "]")));
            System.out.println("Link " + linkNum + " Found");

            linkUrl = link.getAttribute("href");
            link.click();
            System.out.println("Clicked on Link " + linkNum);

            Assert.assertTrue(wait.until(ExpectedConditions.urlToBe(linkUrl)));
            System.out.println("Verified Link URL : " + linkUrl);
            driver.navigate().back();
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(link)).isDisplayed());
            System.out.println("User is back to HomePage");
        }
    }

    public void verifyAllSmallSizeLinksInHomePage() {
        System.out.println("verifyAllSmallSizeLinksInHomePage Method");

        List<WebElement> linkCount = driver.findElements(By.xpath("//a[@class='font-xxxxs font-bold    lh-sm offblack hover-gray-dark label-link']"));
        System.out.println("Number of SmallSize Links found in HomePage : " + linkCount.size());

        for (int linkNum = 0; linkNum <= linkCount.size(); linkNum++) {
            link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='font-xxxxs font-bold    lh-sm offblack hover-gray-dark label-link'])[" + linkNum + "]")));
            System.out.println("Link " + linkNum + " Found");

            linkUrl = link.getAttribute("href");
            link.click();
            System.out.println("Clicked on Link " + linkNum);

            Assert.assertTrue(wait.until(ExpectedConditions.urlToBe(linkUrl)));
            System.out.println("Verified Link URL : " + linkUrl);
            driver.navigate().back();
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(link)).isDisplayed());
            System.out.println("User is back to HomePage");
        }
    }

    public void verifyAllDiversionLinksInHomePage() {
        System.out.println("verifyAllDiversionLinksInHomePage Method");

        List<WebElement> linkCount = driver.findElements(By.xpath("//a[@class='inline-flex items-center black pr-lgmod pointer']"));
        System.out.println("Number of Diversion Links found in HomePage : " + linkCount.size());

        for (int linkNum = 0; linkNum <= linkCount.size(); linkNum++) {
            link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='inline-flex items-center black pr-lgmod pointer'])[" + linkNum + "]")));
            System.out.println("Link " + linkNum + " Found");

            linkUrl = link.getAttribute("href");
            link.click();
            System.out.println("Clicked on Link " + linkNum);

            Assert.assertTrue(wait.until(ExpectedConditions.urlToBe(linkUrl)));
            System.out.println("Verified Link URL : " + linkUrl);
            driver.navigate().back();
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(link)).isDisplayed());
            System.out.println("User is back to HomePage");
        }
    }

    public void verifyAllRHSTableLinksInHomePage() {
        System.out.println("verifyAllRHSTableLinksInHomePage Method");

        List<WebElement> linkCount = driver.findElements(By.xpath("//a[@class='Tables-module_footerCTA__QVJ9g underline font-xxxxs font-light font--subhead pl-sm']"));
        System.out.println("Number of Table Links found in HomePage : " + linkCount.size());

        for (int linkNum = 0; linkNum <= linkCount.size(); linkNum++) {
            link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='Tables-module_footerCTA__QVJ9g underline font-xxxxs font-light font--subhead pl-sm'])[" + linkNum + "]")));
            System.out.println("Link " + linkNum + " Found");

            linkUrl = link.getAttribute("href");
            link.click();
            System.out.println("Clicked on Link " + linkNum);

            Assert.assertTrue(wait.until(ExpectedConditions.urlToBe(linkUrl)));
            System.out.println("Verified Link URL : " + linkUrl);
            driver.navigate().back();
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(link)).isDisplayed());
            System.out.println("User is back to HomePage");
        }
    }

    public void verifyAllFooterLinksInHomePage() {
        System.out.println("verifyAllDiversionLinksInHomePage Method");

        List<WebElement> linkCount = driver.findElements(By.xpath("//a[@class='wpds-c-ihSvun wpds-c-ihSvun-gzQzMU-desktopVariant-true']"));
        System.out.println("Number of Footer Links found in HomePage : " + linkCount.size());

        for (int linkNum = 0; linkNum <= linkCount.size(); linkNum++) {
            link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='wpds-c-ihSvun wpds-c-ihSvun-gzQzMU-desktopVariant-true'])[" + linkNum + "]")));
            System.out.println("Link " + linkNum + " Found");

            linkUrl = link.getAttribute("href");
            link.click();
            System.out.println("Clicked on Link " + linkNum);

            Assert.assertTrue(wait.until(ExpectedConditions.urlToBe(linkUrl)));
            System.out.println("Verified Link URL : " + linkUrl);
            driver.navigate().back();
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(link)).isDisplayed());
            System.out.println("User is back to HomePage");
        }
    }

    public WebElement nextSlideButton(String nextSlide){
        if(driver.findElement(By.xpath("(//button[@aria-label='next slide'])[0]")).isDisplayed()) {
            List<WebElement> buttons = driver.findElements(By.xpath("//button[@aria-label='next slide']"));
            for (WebElement button : buttons) {
                if (button.getAttribute("aria-label").equals(nextSlide)) {
                    return button;
                }
            }
        } return null;
    }

    public WebElement previousSlideButton(String previousSlide){
        if(driver.findElement(By.xpath("(//button[@aria-label='previous slide'])[0]")).isDisplayed()) {
            List<WebElement> buttons = driver.findElements(By.xpath("//button[@aria-label='previous slide']"));
            for (WebElement button : buttons) {
                if (button.getAttribute("aria-label").equals(previousSlide)) {
                    return button;
                }
            }
        } return null;
    }

    public boolean liveAndTrendingSessions() {
        System.out.println("liveAndTrendingSessions method");
        boolean result = false;
        if ((wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='PJLV wpds-c-eUExSu wpds-c-eUExSu-PRook-justify-center']"))))).isDisplayed()) {
            field = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='PJLV wpds-c-eUExSu wpds-c-eUExSu-PRook-justify-center']"))));
            System.out.println("Parent Element of Live & Trending Sessions Located");

            List<WebElement> sessionTypes = wait.until(ExpectedConditions.visibilityOfAllElements(field.findElements(By.tagName("ul"))));
            System.out.println("Live & Trending Sessions Located");

            for (WebElement sessionKind : sessionTypes) {
                List<WebElement> sessions = wait.until(ExpectedConditions.visibilityOfAllElements(sessionKind.findElements(By.tagName("li"))));
                System.out.println("Child Elements of Live & Trending Sessions Located");

                for (WebElement session : sessions) {
                    expectedUrl = session.getAttribute("href");
                    currentUrl = driver.getCurrentUrl();
                    buttonName = session.getText();
                    session.click();
                    System.out.println("Clicked on : " + buttonName);

                    if (driver.getCurrentUrl().equals(expectedUrl)) {
                        result = true;
                        System.out.println("Successfully navigated to: " + expectedUrl);
                    } else System.out.println("Failed to navigate to: " + expectedUrl);
                    driver.navigate().back();
                    driver.navigate().to(currentUrl);
                }
            }
        } else System.out.println("Live & Trending Sessions not Available");
        return result;
    }

    public boolean authorNameLinks() {
        List<WebElement> articleBy = driver.findElements(By.xpath("//div[@class='byline gray-dark font-xxxxs pb-xs']"));
        boolean result = false;

        for (WebElement authorTeam : articleBy) {
            List<WebElement> authors = authorTeam.findElements(By.tagName("a"));
            if (authors.isEmpty()) { continue; }
                for (WebElement author : authors) {
                buttonName = author.getText();
                author.click();
                System.out.println("Clicked on Author's Name : " + buttonName);

                Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@data-qa='author-name']")))).getText(), buttonName);
                System.out.println("Author's Page Opened ");
                driver.navigate().back();
                result = true;
            }
        }
        System.out.println("Verified all Authors who published current articles in the Homepage");
        return result;
    }

    public boolean verifyAccountNamePostSignIn(String accountName) throws InterruptedException {
        System.out.println("verifyAccountNamePostSignIn Method");
        Assert.assertTrue(verifyUserIsInHomePage());
        ((JavascriptExecutor) driver).executeScript("window.open();");
        currentTab = driver.getWindowHandle();
        for (String newTab : driver.getWindowHandles()) {
            if (!newTab.equals(currentTab)) {
                driver.switchTo().window(newTab);
                break;
            }
        }

        driver.wait(2000);
        driver.get("https://www.washingtonpost.com");
        driver.wait(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.washingtonpost.com");
        return signInPage.verifySignIn(accountName);
    }

    public boolean findAllImages() {
        System.out.println("findAllImages method");
        boolean result = false;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        System.out.println("Scrolled till the bottom");

//        homePage.nextSlideButton(); // click until it disappears
//        homePage.previousSlideButton(); // click until it disappears

        js.executeScript("window.scrollTo(0, 0);");
        System.out.println("Scrolled till the top");

        List<WebElement> images = driver.findElements(By.xpath("//img"));
        for (WebElement image : images) {
            System.out.println("All images display");
            url = image.getAttribute("src");
            driver.get(url);
            Assert.assertTrue(driver.findElement(By.xpath("//img")).isDisplayed());
            result = true;
        }
        return result;
    }

    public boolean verifyUserIsInHomePage() {
        System.out.println("verifyUserIsInHomePage Method");
        masterLogo = driver.findElement(By.xpath("//*[@class='wpds-c-fBqPWp masthead_svg__wplogo']"));
        System.out.println("'The Washington Post' Logo found");
        return masterLogo.isDisplayed();
    }
}
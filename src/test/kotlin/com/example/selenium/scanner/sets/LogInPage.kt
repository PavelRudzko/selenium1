package com.example.selenium.scanner.sets

import com.codeborne.selenide.Selectors.byXpath
import com.codeborne.selenide.Selenide.element
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class LogInPage {

    val usernameInput = element(By.id("username"))
    val passwordInput = element(By.id("password"))
    //    val input = element("#form-login > fieldset > div.form-col.form-col-right > input")
    val input = element(byXpath("/html/body/div/div/div/form/fieldset/div[4]/input"))


    val seeAllToolsButton = element("a.wt-button_mode_primary")
    val toolsMenu = element(byXpath("//div[contains(@class, 'menu-main__item') and text() = 'Tools']"))
    val searchButton = element("[data-test=menu-main-icon-search]")




    val linkedIn_inputLog =
//            element("//*[@id=\'session_key\']")
        element(byXpath("//*[@id=\'session_key\']"))


    val linkedIn_inputPas =
        element("#main-content > section.section.section--hero > div.sign-in-form-container > form > div.sign-in-form__form-input-container > div.input")

    val linkedIn_signInButton =
        element("#main-content > section.section.section--hero > div.sign-in-form-container > form > button")



}


package com.example.selenium.linkedIn

import com.codeborne.selenide.Selectors.byXpath
import com.codeborne.selenide.Selenide.element
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class LinkedIn {

    val inputLog = element("#session_key")
    val inputPas =  element("#session_password")
    val signInButton = element(".sign-in-form__submit-button")
//        element(byXpath("/html/body/main/section[1]/div[2]/form/button"))

    val searchEditView = element(".search-global-typeahead__input")


}


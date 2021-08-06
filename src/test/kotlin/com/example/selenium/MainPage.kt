package com.example.selenium

import com.codeborne.selenide.Selectors.byXpath
import com.codeborne.selenide.Selenide.element

class MainPage {
    val seeAllToolsButton = element("a.wt-button_mode_primary")
    val toolsMenu = element(byXpath("//div[contains(@class, 'menu-main__item') and text() = 'Tools']"))
    val searchButton = element("[data-test=menu-main-icon-search]")
}

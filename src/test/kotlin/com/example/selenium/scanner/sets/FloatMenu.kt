package com.example.selenium.scanner.sets

import com.codeborne.selenide.Selenide
import org.openqa.selenium.By

class FloatMenu {

    val goToUsers =
        Selenide.element(By.id("goToUsers"))

    val goToScans =
        Selenide.element(By.id("goToScans"))
    val goToOffices =
        Selenide.element(By.id("goToOffices"))
}
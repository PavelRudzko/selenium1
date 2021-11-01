package com.example.selenium.scanner.sets

import com.codeborne.selenide.Selenide
import org.openqa.selenium.By

class Content {

    // Filter
    val showFilter =
        Selenide.element("#showFilter")

    val sectionFilter =
        Selenide.element("#sectionFilter")

    val showResult =
        Selenide.element("#showResult")

    val resetFilter =
        Selenide.element("#resetFilter")

    // Fill form

    val inputThumbUrl =
        Selenide.element("#thumbUrl")

    val inputTopImageUrl =
        Selenide.element("#topImageUrl")
    val inputBackUrl =
        Selenide.element("#backUrl")

    val inputTopText =
        Selenide.element("#topText")
    val inputSubText =
        Selenide.element("#subText")
    val inputDescription =
        Selenide.element("#description")

    val selectSection =
        Selenide.element(By.id("section"))

    val inputColor =
        Selenide.element("#color")

    val inputLinecolor =
        Selenide.element("#linecolor")

    val btnCreateContent =
        Selenide.element("#createContent")


    // Content one
    val backToContents =
        Selenide.element("#toContent") //

}
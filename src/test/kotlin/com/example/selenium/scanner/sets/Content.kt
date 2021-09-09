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

    val imputThumbUrl =
        Selenide.element("#thumbUrl")

    val imputTopImageUrl =
        Selenide.element("#topImageUrl")
    val imputBackUrl =
        Selenide.element("#backUrl")

    val imputTopText =
        Selenide.element("#topText")
    val imputSubText=
        Selenide.element("#subText")
    val imputDescription=
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
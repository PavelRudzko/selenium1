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
    val imputTopImageUrl =
        Selenide.element("#topImageUrl")

    val imputThumbUrl =
        Selenide.element("#thumbUrl")

    val selectSection =
        Selenide.element(By.id("section"))

    val inputColor =
        Selenide.element("#color")

    val btnCreateContent =
        Selenide.element("#createContent")


    // Content one
    val backToContents =
        Selenide.element("#toContent") //

}
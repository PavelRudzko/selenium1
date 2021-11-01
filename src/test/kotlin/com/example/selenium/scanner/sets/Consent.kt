package com.example.selenium.scanner.sets

import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import java.awt.SystemColor.MENU
import kotlin.text.Typography.section

class Consent {


    // Fill form

    val inputID =
        Selenide.element("#ID")

    val inputNameSituation =
        Selenide.element("#nameSituation")
    val inputSection =
        Selenide.element("#section")

    val inputTitle =
        Selenide.element("#title")
    val inputSection2 =
        Selenide.element("#section2")
    val inputDescription =
        Selenide.element("#description")

    val inputPrivacyPolicy =
        Selenide.element("#privacyPolicy")

    val inputMinimumAgeText =
        Selenide.element("#minimumAgeText")
    val inputMinimumAge =
        Selenide.element("#minimumAge")

    val inputVersion =
        Selenide.element("#version")

    val inputRevokeWarningText =
        Selenide.element("#revokeWarningText")

    val selectSection =
        Selenide.element(By.id("#section"))


    val btnCreateContent =
        Selenide.element("#createContent")


    // Content one
    val backToContents =
        Selenide.element("#toContent") //


//    ID</th>
//    <th>Name Situation_</th>
//    <th>Language</th>
//    <th>Title</th>
//    <th>Default State</th>
//    <th>Description</th>
//    <th>Privacy Policy</th>
//    <th class="action">Edit</th>


}






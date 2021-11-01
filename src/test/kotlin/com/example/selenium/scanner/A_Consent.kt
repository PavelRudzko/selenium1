package com.example.selenium.scanner

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.logevents.SelenideLogger
import com.example.selenium.scanner.sets.Content
import com.example.selenium.scanner.sets.FloatMenu
import com.example.selenium.scanner.sets.LogInPage
import com.example.selenium.scanner.sets.Offices
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import java.awt.SystemColor
import org.openqa.selenium.By

class A_Consent {

    companion object {


        //        val urlForTest = "http://localhost:8090/"admin/scanner/content"
        val urlForTest = "http://q11.jvmhost.net/admin/scanner/consents"

        @BeforeAll
        @JvmStatic
        internal fun beforeAll() {
            println("'Before All' called")
            Configuration.browserSize = "1280x1000"
            SelenideLogger.addListener("allure", AllureSelenide())
//            Selenide.open("http://q11.jvmhost.net/admin/scanner/consents")
            Selenide.open(urlForTest)
        }
    }

    private val mainPage = LogInPage()
    private val floatMenu = FloatMenu()
    private val content = Content()
    private val office = Offices()

    private val TEST_IMAGE_URL = "https://cdn.guru99.com/images/image015(3).png"
    private val TEST_IMAGE_URL2 = "https://www.lotus-qa.com/wp-content/uploads/2020/02/testing.jpg"

    private val PAUSE_MILISEC: Long = 500L

    //lateinit var elementDeleteMy: WebElement
    lateinit var elementEditeMy: WebElement
    var rowToDelete: Int = 0

    var colToDelete: Int = 0
    private val EDIT = "Edit"
    private val DELETE = "Delete"


    @Test
    @Order(1)
    @DisplayName("Log In")
    fun test1logInTest() {
        println("---- Log In ----")
        logIn()
    }

    @Test
    @Order(2)
    @DisplayName("Edit consent")
    fun testEditConsents() {
        //        // Edit element
        println("---- Edit Consent ----")
        editConsent()

    }


    @Test
    @Order(3)
    @DisplayName("Find last Consent and click Edit")
    fun test4goToEdit() {
        println("---- Find Consent and click Edit ----")
        findAndClick(EDIT)
    }


    private fun logIn() {
        mainPage.passwordInput.sendKeys("1111")
        mainPage.usernameInput.sendKeys("1111")
        mainPage.input.click()
    }


    private fun findAndClick(clickOn: String) {
        val simpleTable = Selenide.element(".tab")
        val links: List<WebElement> = simpleTable.findElements(By.tagName("a#edit"))
        val link = links[0];
        link.click();
    }

    private fun pause() = Thread.sleep(PAUSE_MILISEC)
    private fun editConsent() {
        val simpleTables: List<WebElement> = Selenide.elements(".tab")
        val links: List<WebElement> = simpleTables[1].findElements(By.cssSelector("a#edit"))
        val link = links[0]

//        val rows: List<WebElement> = simpleTables[1].findElements(By.cssSelector("tr"))
//        for(row in rows)
//        {
//            val cells: List<WebElement> = row.findElements(By.cssSelector("td"))
//            val id = cells[0].text
//        }
//        val countBeforeChange = rows.size
//        val countAfterChange = 10;
//        link.click()
//        assert(countBeforeChange + 1 == countAfterChange)
//        pause()

    }

}
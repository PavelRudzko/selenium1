package com.example.selenium.scanner

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.logevents.SelenideLogger
import com.example.selenium.scanner.sets.Content
import com.example.selenium.scanner.sets.FloatMenu
import com.example.selenium.scanner.sets.LogInPage
import com.example.selenium.scanner.sets.Offices

import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.*
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class C_Office {

    private val mainPage = LogInPage()
    private val floatMenu = FloatMenu()
    private val PAUSE_MILISEC: Long = 500L

    companion object {
        //        val urlForTest = "http://localhost:8090/admin/scanner/content"
        val urlForTest = "http://q11.jvmhost.net/admin/scanner/content"

        @BeforeAll
        @JvmStatic
        internal fun beforeAll() {
            println("'Before All' called")
            Configuration.browserSize = "1280x1000"
            SelenideLogger.addListener("allure", AllureSelenide())
            Selenide.open(urlForTest)
        }

        @AfterAll
        @JvmStatic
        internal fun afterAll() {
            println("'After All' called")
        }

    }


    @Test
    @Order(1)
    @DisplayName("Log In")
    fun test1logInTest() {
        println("---- Log In ----")
        logIn()
    }

    @Test
    @Order(2)
    @DisplayName("Test Offices'")
    fun tes2Udsers() {
        floatMenu.goToOffices.click()
    }


    private fun logIn() {
        mainPage.passwordInput.sendKeys("1111")
        mainPage.usernameInput.sendKeys("1111")
        mainPage.input.click()
    }


    private fun pause() = Thread.sleep(PAUSE_MILISEC)

}
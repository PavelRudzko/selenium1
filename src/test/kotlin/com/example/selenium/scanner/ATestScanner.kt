package com.example.selenium.scanner

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.logevents.SelenideLogger
import com.example.selenium.scanner.sets.Content
import com.example.selenium.scanner.sets.FloatMenu
import com.example.selenium.scanner.sets.LogInPage
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.*
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class ATestScanner {

    val urlForTest = "http://localhost:8090/admin/scanner/content"
//    val urlForTest = "http://q11.jvmhost.net/admin/scanner/content"

    private val mainPage = LogInPage()
    private val content = Content()
    private val floatMenu = FloatMenu()


    val COUPONS = "1"
    val FAG = "4"
    val CONTACT_US = "6"
    val MENU = "7"

    private val TEST_IMAGE_URL = "https://cdn.guru99.com/images/image015(3).png"
    private val TEST_IMAGE_URL2 = "https://www.lotus-qa.com/wp-content/uploads/2020/02/testing.jpg"

    private val PAUSE: Long = 500L

    lateinit var elenentDeleteMy: WebElement
    lateinit var elenentEditeMy: WebElement

    var rowToDelete: Int = 0
    var colToDelete: Int = 0

    val EDITE = "Edit"
    val DELETE = "Delete"


    @BeforeEach
    fun setUpAll() {
        Configuration.browserSize = "1280x800"
        SelenideLogger.addListener("allure", AllureSelenide())
    }

    @BeforeEach
    fun setUp() {
        Selenide.open(urlForTest)
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
    @DisplayName("Go to 'user list'")
    fun tes2Users() {
        floatMenu.goToUsers.click()
    }

    @Test
    @Order(3)
    @DisplayName("Add consent")
    fun test3addConsents() {
        //        // Add element
        println("---- Add Consent ----")
        addConsent()

    }

    @Test
    @Order(4)
    @DisplayName("Find last Consent and click Edit")
    fun test4goToEdit() {
        println("---- Find Consent and click Edit ----")
        findAndClick(EDITE)

    }

    @Test
    @Order(5)
    @DisplayName("Edit Consent")
    fun test6Consents() {

        println("---- Edit Consent ----")
        editConsent(TEST_IMAGE_URL2)

        println("---- Click back to 'Consents' ----")
        content.backToContents.click()
    }


    @Test
    @Order(6)
    @DisplayName("Delete Consent")
    fun test6Consents2() {
        println("---- Find Consent and click 'Delete' ----")
        findAndClick(DELETE)
    }


    @Test
    @Order(7)
    @DisplayName("Check filter")
    fun test7Consents() {
        println("---- Check filter ----")
        filterConsents()

        println("Pause")
        Thread.sleep(5_000)
    }


    private fun logIn() {
        mainPage.passwordInput.sendKeys("1111")
        mainPage.usernameInput.sendKeys("1111")
        mainPage.input.click()
    }


    private fun editConsent(image: String = TEST_IMAGE_URL) = addConsent(image)


    private fun addConsent(image: String = TEST_IMAGE_URL) {

        val c = content.selectSection
        c.click()
        pause()

//        Select(c).selectByIndex(7 - 1)
        Select(c).selectByValue(MENU)
        pause()

        content.inputColor.clear()
        content.inputColor.sendKeys("#FFFF00")
        pause()

        content.imputTopImageUrl.clear()
        content.imputTopImageUrl.sendKeys(image)
        pause()

        content.imputThumbUrl.clear()
        content.imputThumbUrl.sendKeys(TEST_IMAGE_URL)
        pause()

        content.btnCreateContent.click()
        pause()
        println(" --- Clicked button 'Add content' ----")
    }


    private fun filterConsents() {

        val list = listOf<String>(COUPONS, FAG, CONTACT_US, MENU)

        list.forEach {
            content.showFilter.click()
            pause()

            val select =
                content.sectionFilter
            select.click()
            Select(select).selectByValue(it)
            pause()

            content.showResult.click()
        }


        content.showFilter.click()
        pause()

        content.resetFilter.click()
    }

    private fun findAndClick(clickOn: String) {
        // Find last element
        val simpleTable = element(".tab > tbody:nth-child(1)")
        val rows: List<WebElement> = simpleTable.findElements(By.tagName("tr"))

        val listId = mutableListOf<Int>()

        rows.forEachIndexed { index, row ->
            println("----- raw = $index-------")
            val cols = row.findElements(By.tagName("td"))
            cols.forEachIndexed { index, webElement ->
//                print(" ${webElement.text} \t")
                print("$index) ${webElement.text} \t")
                if (index == 1) listId.add(webElement.text.toInt())
            }
        }

        val max: Int? = listId.max()
        println("-------max = $max-----")


        rows.forEachIndexed { indexRow, row ->

            println("----- row = $indexRow ** -------")
            val cols = row.findElements(By.tagName("td"))
            var delThisElement = false
            var editThisElement = false

            cols.forEachIndexed { index, webElement ->

                if (index == 1) {
                    print("$index) ID = ${webElement.text.toInt()} * \n")
                }

                if (index == 1) {
//                    print("$index) ${webElement.text.toInt()} **  (max = $max)\n")
                    if (webElement.text.toInt() == max) {
                        delThisElement = true
                        editThisElement = true
                        rowToDelete = indexRow
                        colToDelete = index
//                        println("del Element = $delThisElement")
                    }
                }

                if (clickOn == EDITE) {

                    if (index == 7) println("$index) ${webElement.text}  / edit = $delThisElement ***")
                    if (index == 7 && editThisElement) {
                        elenentEditeMy = webElement.findElement(By.xpath(".//a"))
                        println("Found element !!!!")
                        editThisElement = false
                    }

                } else if (clickOn == DELETE) {

                    if (index == 8) println("$index) ${webElement.text}  / del = $delThisElement ***")
                    if (index == 8 && delThisElement) {
                        elenentDeleteMy = webElement.findElement(By.xpath(".//a"))
                        println("Found element !!!!")
                        delThisElement = false
                    }
                }

            }

        }

        if (clickOn == EDITE) {
            elenentEditeMy.click()
            println("Click to edit element row # $rowToDelete")

        } else {
            elenentDeleteMy.click()
            println("Click to delete element row # $rowToDelete")
        }

        println("Pause")
        Thread.sleep(5_000)
    }


    private fun pause() = Thread.sleep(PAUSE)

}
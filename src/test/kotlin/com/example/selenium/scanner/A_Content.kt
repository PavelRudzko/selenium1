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
class A_Content() {

    companion object {


        //        val urlForTest = "http://localhost:8090/admin/scanner/content"
        val urlForTest = "http://q11.jvmhost.net/admin/scanner/content"

        @BeforeAll
        @JvmStatic
        internal fun beforeAll() {
            println("'Before All' called")
            Configuration.browserSize = "1280x1000"
            SelenideLogger.addListener("allure", AllureSelenide())
//            Selenide.open("http://localhost:8090/admin/scanner/content")
            Selenide.open(urlForTest)
        }

        @AfterAll
        @JvmStatic
        internal fun afterAll() {
            println("'After All' called")
        }

    }

    private val mainPage = LogInPage()
    private val content = Content()
    private val floatMenu = FloatMenu()

    private val office = Offices()
    private val COUPONS = "1"
    private val FAG = "4"
    private val CONTACT_US = "6"

    private val MENU = "9"
    private val TEST_IMAGE_URL = "https://cdn.guru99.com/images/image015(3).png"

    private val TEST_IMAGE_URL2 = "https://www.lotus-qa.com/wp-content/uploads/2020/02/testing.jpg"

    private val PAUSE_MILISEC: Long = 500L
    lateinit var elementDeleteMy: WebElement

    lateinit var elementEditeMy: WebElement
    var rowToDelete: Int = 0

    var colToDelete: Int = 0
    private val EDITE = "Edit"


    private val DELETE = "Delete"

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
    @DisplayName("Find  Content and click Edit")
    fun test4goToEdit() {
        println("---- Find Consent and click Edit ----")
        findAndClick(EDITE)
    }

    @Test
    @Order(3)
    @DisplayName("Edit Content")
    fun testEditContent() {

        println("---- Edit Content ----")
        editContent()

        println("---- Click back to 'Consents' ----")
        content.backToContents.click()
    }


    @Test
    @Order(4)
    @DisplayName("Add content")
    fun testAddContent() {
        //        // Add element
        println("---- Add Content ----")
        addContent()

    }


    @Test
    @Order(5)
    @DisplayName("Delete Content")
    fun testDeleteContents() {
        println("---- Find Content and click 'Delete' ----")
        findAndClick(DELETE)
    }


    @Test
    @Order(6)
    @DisplayName("Check filter")
    fun testFilterContents() {
        println("---- Check filter ----")
        filterContents()

        println("Pause")
        Thread.sleep(5_000)
    }


    @Test
    @Order(7)
    @DisplayName("Go to 'user list'")
    fun testGoToUsers() {
        floatMenu.goToUsers.click()


        listOf(10, 11, 114).forEach {
            element(".show-filter").click()
            pause()
            element(".input").sendKeys("$it")
            pause()
            element(".submit").click()


        }


        val simpleTable = element(".tab > tbody:nth-child(1)")

        val rows: List<WebElement> = simpleTable.findElements(By.tagName("tr"))

        //Print data from each row
        for (row in rows) {
            val cols = row.findElements(By.tagName("td"))
            cols.forEach {
                print(it.text + "\t")
            }
            println()
        }

        for (row in rows) {
            val cols = row.findElements(By.tagName("td"))

            for (col in cols) {
                if (col.text == "1624262591862") print("We found it!!") else print("-*-")
            }
            println("------------")

        }


        println("Finish!")
        Thread.sleep(3_000)

    }


    @Test
    @Order(8)
    @DisplayName("Go to 'Offices'")
    fun testGoToOffices() {
        floatMenu.goToOffices.click()


    }


    private fun logIn() {
        mainPage.passwordInput.sendKeys("1111")
        mainPage.usernameInput.sendKeys("1111")
        mainPage.input.click()
    }


    private fun filterContents() {

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

                    if (index == 11) println("$index) ${webElement.text}  / edit = $delThisElement ***")
                    if (index == 11 && editThisElement) {
                        elementEditeMy = webElement.findElement(By.xpath(".//a"))
                        println("Found element !!!!")
                        editThisElement = false
                    }

                } else if (clickOn == DELETE) {

                    if (index == 12) println("$index) ${webElement.text}  / del = $delThisElement ***")
                    if (index == 12 && delThisElement) {
                        elementDeleteMy = webElement.findElement(By.xpath(".//a"))
                        println("Found element !!!!")
                        delThisElement = false
                    }
                }

            }

        }

        if (clickOn == EDITE) {
            elementEditeMy.click()
            println("Click to edit element row # $rowToDelete")

        } else {
            elementDeleteMy.click()
            println("Click to delete element row # $rowToDelete")
        }

        println("Pause")
        Thread.sleep(5_000)
    }


    private fun pause() = Thread.sleep(PAUSE_MILISEC)


    // private fun editContent() = addContent(isEdit = true)


    private fun addContent(isEdit: Boolean = false) {
        val button = Selenide.element("button[type='submit']")
        //val selenideElement = content.selectSection
        button.click()
        println("Content Add")
        pause()
        val selenideElement = content.selectSection

        Select(selenideElement).selectByValue(MENU)
        pause()

        content.inputColor.clear()
        content.inputColor.sendKeys(if (isEdit) "#FFFF02" else "#FFFF00")
        pause()

        content.inputLinecolor.clear()
        content.inputLinecolor.sendKeys(if (isEdit) "#008002" else "#008000")
        pause()

        content.inputTopImageUrl.clear()
        content.inputTopImageUrl.sendKeys(if (isEdit) TEST_IMAGE_URL else TEST_IMAGE_URL2)
        pause()

        content.inputBackUrl.clear()
        content.inputBackUrl.sendKeys(if (isEdit) TEST_IMAGE_URL else TEST_IMAGE_URL2)
        pause()

        content.inputThumbUrl.clear()
        content.inputThumbUrl.sendKeys(if (isEdit) TEST_IMAGE_URL else TEST_IMAGE_URL2)
        pause()


        content.inputTopText.clear()
        content.inputTopText.sendKeys(if (isEdit) "Test Tot text (Edit)" else "Test Tot text")
        pause()

        content.inputSubText.clear()
        content.inputSubText.sendKeys(if (isEdit) "Test Sub text (Edit)" else "Test Sub text")
        pause()

        content.inputDescription.clear()
        content.inputDescription.sendKeys(if (isEdit) "Test Description (Edit)" else "Test Description ")
        pause()

        content.btnCreateContent.click()
        pause()
        println(" --- Clicked button 'Add content' ----")
    }

    private fun editContent() {
        val simpleTables: List<WebElement> = Selenide.elements(".tab")
        val links: List<WebElement> = simpleTables[1].findElements(By.cssSelector("a#edit"))
        val link = links[0]

    }

}
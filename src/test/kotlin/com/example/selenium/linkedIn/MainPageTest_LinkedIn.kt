package com.example.selenium.linkedIn

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.*
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class MainPageTest_LinkedIn {
    private val linkedIn = LinkedIn()

    @BeforeEach
    fun setUpAll() {
        Configuration.browserSize = "1280x1000"
        SelenideLogger.addListener("allure", AllureSelenide())
    }

    @BeforeEach
    fun setUp() {
        open("https://www.linkedin.com")
    }

    @Test
    fun linkedIn() {



        linkedIn.inputLog.sendKeys("Test@gmail.com")
        linkedIn.inputPas.sendKeys("test")
        linkedIn.signInButton.click()
        println("dm:: click button")
//        mainPage.passwordInput.sendKeys("1111")
//        mainPage.usernameInput.sendKeys("1111")

//        Thread.sleep(3_000)
//
//        linkedIn.searchEditView.sendKeys("HR USA")


//        open("https://www.linkedin.com/search/results/all/?keywords=HR%20USA%20New%20York&origin=GLOBAL_SEARCH_HEADER")
//         element("div.ph0:nth-child(1) > div:nth-child(3) > a:nth-child(1)").click() // see all results
//

        for (i in 2..15) {
            println("dm:: --- Open page #$i --- ")
//            open("https://www.linkedin.com/search/results/people/?keywords=HR%20USA%20New%20York&origin=GLOBAL_SEARCH_HEADER&page=$i")
//            open("https://www.linkedin.com/search/results/people/?keywords=human%20resources%20USA%20California&origin=GLOBAL_SEARCH_HEADER&page=$i")
            open("https://www.linkedin.com/search/results/people/?keywords=HR%20USA%20California&origin=GLOBAL_SEARCH_HEADER&page=$i")
//            open("https://www.linkedin.com/search/results/people/?keywords=HR%LA&origin=GLOBAL_SEARCH_HEADER&page=$i")
//            open("https://www.linkedin.com/search/results/people/?keywords=hr ny&origin=CLUSTER_EXPANSION&page=$i")
//            open("https://www.linkedin.com/search/results/people/?keywords=hr new york&origin=CLUSTER_EXPANSION&page=$i")

//            Thread.sleep(1_000)
           val simpleTable = element(".reusable-search__entity-results-list")

            val rows: List<WebElement> = simpleTable.findElements(By.tagName("li"))



            rows.forEachIndexed{ i, v ->
//                println("-----$i-------")


               val tt =  v.findElement(By.className("entity-result__actions"))
                println("action = '${tt.text}'")

                if(v.text.contains( "Connect")){
                    val btn =  v.findElement(By.tagName("button"))
                    btn.click()
                    println("dm:: click on ${tt.text}")
                    Thread.sleep(2_000)


//                    val yy = element("#artdeco-modal")
//                    println("yy 00 = ${yy.toString()}")
//
//                    val jj =  yy.findElements(By.tagName("button"))
//                    println("jj 111 = ${jj.toString()}")
//                    jj.forEach {
//                        println("jj = ${it.text}")
//                    }
//
//                    Thread.sleep(2_000)

//                    element(By.tagName("button")).click()
//                    element(byXpath("//button[text()='Send now']")).click()
//                    element(("//button[contains(text(),'Send')]")).click()
//                    println("dm:: click on button 'Send'")
//                    Thread.sleep(3_000)
                }
//                else if(v.text.contains( "Follow") && v.text.equals("Follow").not()){
//                    val btn =  v.findElement(By.tagName("button"))
//                    btn.click()
//                    println("dm:: click on ${tt.text}")
//
//                }

            //                if (v.text == "Connect") println("We found it ")
            }

//            for (row in rows) {
//                val cols = row.findElements(By.tagName("button"))
//
//                for (col in cols) {
//                    print(col.text + "\t")
//                }
//
//                println("------------")
//            }

            println("-----row End------- ")

            Thread.sleep(2_000)
        }



        Thread.sleep(5_000)
        println("dm:: Finish")


//        element("#header-search").sendKeys("Selenium")
//        element(byXpath("//button[@type='submit' and text()='Search']")).click()

//        element(".js-search-input").shouldHave(attribute("value", "Selenium"))
    }
//    @Test
//    fun search() {
//        linkedIn.searchButton.click()
//
//        element("#header-search").sendKeys("Selenium")
//        element(byXpath("//button[@type='submit' and text()='Search']")).click()
//
////        element(".js-search-input").shouldHave(attribute("value", "Selenium"))
//    }
//
//    @Test
//    fun toolsMenu() {
//        linkedIn.toolsMenu.hover()
//
//        element(".menu-main__popup-wrapper").shouldBe(visible)
//    }
//
//    @Test
//    fun navigationToAllTools() {
//        linkedIn.seeAllToolsButton.click()
//
//        element(".products-list").shouldBe(visible)
//
//        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title())
//    }
}

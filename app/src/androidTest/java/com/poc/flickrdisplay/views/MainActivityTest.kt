package com.poc.flickrdisplay.views

import android.content.Intent
import com.poc.flickrdisplay.robots.MainActivityRobot
import org.junit.Before
import org.junit.Test

class MainActivityTest : EspressoBaseTest<MainActivity>(MainActivity::class.java) {

    val eyes: MainActivityRobot.Eyes = MainActivityRobot.Eyes()

    @Before
    fun startActivity() {
        startActivity(Intent())
    }

    @Test
    fun testOnServiceSuccess_itemsCount() {
        eyes.seesNumberOfItems()
    }

    @Test
    fun testItemDetails_forSecondItem() {
        eyes.seesTitleForTheItem()
                .seesIdForTheItem()
    }
}
package com.poc.flickrdisplay.views

import android.content.Intent
import androidx.test.runner.AndroidJUnit4
import com.poc.flickrdisplay.robots.ImageActivityRobot
import com.poc.flickrdisplay.util.PhotoUtil
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ImageDetailsActivityTest : EspressoBaseTest<ImageDetailsActivity>(ImageDetailsActivity::class.java) {

    val eyes: ImageActivityRobot.Eyes = ImageActivityRobot.Eyes()

    @Before
    fun startActivity() {
        var intent = Intent()
        intent.putExtra(ImageDetailsActivity.PHOTO_PARAM, PhotoUtil.createPhoto(1))
        startActivity(intent)
    }

    @Test
    fun testImageDetails() {
        eyes.seesPhotoImage()
                .seesTitle()
                .seesOwner()
                .seesId()
                .seesServer()
                .seesSecret()
    }
}
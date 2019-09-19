package com.poc.flickrdisplay.views

import android.app.Activity
import android.content.Intent
import androidx.test.rule.ActivityTestRule
import org.junit.Rule

open class EspressoBaseTest<T : Activity>(clazz: Class<T>) {

    @get:Rule
    val activityRule = ActivityTestRule(clazz, false, false)

    protected fun startActivity(intent: Intent) {
        activityRule.launchActivity(intent)
    }
}

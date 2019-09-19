package com.poc.flickrdisplay.util

import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import com.poc.flickrdisplay.robots.RecyclerViewMatcher
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matchers

object EspressoUtil {

    fun seesView(@IdRes id: Int) {
        onView(withId(id))
                .check(matches(ViewMatchers.isDisplayed()))
    }

    fun seesViewWithText(@IdRes id: Int, text: String) {
        onView(withId(id))
                .check(matches(ViewMatchers.isDisplayed()))
                .check(matches(ViewMatchers.withText(text)))
    }

    fun seesViewWithText(@IdRes id: Int, @StringRes text: Int) {
        onView(withId(id))
                .check(matches(ViewMatchers.isDisplayed()))
                .check(matches(ViewMatchers.withText(text)))
    }

    fun seesRecyclerViewIndexWithText(@IdRes recycleView: Int, index: Int) {
        onView(withId(recycleView))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(index, scrollTo()))
                .check(matches(RecyclerViewMatcher.atPosition(index, hasDescendant(withText(not(Matchers.isEmptyString()))))))
    }

    fun seesRecyclerViewItems(@IdRes recycleView: Int, expectedCount: Int) {
        onView(withId(recycleView)).check(RecyclerViewMatcher.hasItemsCount(expectedCount))
    }

    fun seesRecyclerViewIndexWithText(@IdRes recycleView: Int, index: Int, text: String) {
        onView(withId(recycleView))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(index, scrollTo()))
                .check(matches(RecyclerViewMatcher.atPosition(index, hasDescendant(withText(text)))))
    }

}

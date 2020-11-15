package com.pawelsmagala.songlistapp.songListActivity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.pawelsmagala.songlistapp.R
import com.pawelsmagala.songlistapp.assertions.RecyclerViewHasAnyItems
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class SongActivityTest {
    @get:Rule
    var activityRule: ActivityScenarioRule<SongListActivity>
            = ActivityScenarioRule(SongListActivity::class.java)


    @Test
    fun checkIfActivityLoadsData() {
        Thread.sleep(2000)
        onView(withId(R.id.songListRecycler)).check(RecyclerViewHasAnyItems())
    }

    @Test
    fun switchTabAndVerifyInternetDataLoaded() {

        onView(withText(R.string.remote)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.songListRecycler)).check(RecyclerViewHasAnyItems())
    }

    @Test
    fun switchTabAndVerifyLocalDataLoaded() {

        onView(withText(R.string.local)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.songListRecycler)).check(RecyclerViewHasAnyItems())
    }



}
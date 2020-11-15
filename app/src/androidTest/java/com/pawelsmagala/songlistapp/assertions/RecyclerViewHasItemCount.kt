package com.pawelsmagala.songlistapp.assertions

import android.view.View
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.Matcher


class RecyclerViewHasItemCount(val matcher: Matcher<Int>)  : RecyclerViewBaseAssertion() {

    constructor(expectedCount: Int): this(`is`(expectedCount)) {}

    override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
        super.check(view, noViewFoundException)
        assertThat(adapter.itemCount, matcher)
    }


}

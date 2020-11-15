package com.pawelsmagala.songlistapp.assertions

import android.view.View
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not

class RecyclerViewHasAnyItems: RecyclerViewBaseAssertion() {
    override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
        super.check(view, noViewFoundException)
        assertThat(adapter.itemCount, not(`is`(0)))
    }
}
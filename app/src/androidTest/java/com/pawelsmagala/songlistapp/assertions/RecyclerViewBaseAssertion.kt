package com.pawelsmagala.songlistapp.assertions

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion

open class RecyclerViewBaseAssertion : ViewAssertion {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerView.Adapter<*>

    override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
        if (noViewFoundException != null) {
            throw noViewFoundException
        }


        recyclerView = view as RecyclerView
        adapter = recyclerView.adapter!!

    }

}
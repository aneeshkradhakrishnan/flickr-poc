package com.poc.flickrdisplay.mvvm

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.poc.flickrdisplay.customviews.CollapsibleText

class RecyclerViewBindingAdapter {
    companion object {

        @JvmStatic
        @BindingAdapter("itemDivider")
        fun setItemDecorator(recyclerView: RecyclerView, decoration: DividerItemDecoration) {
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.addItemDecoration(decoration)
        }

        @JvmStatic
        @BindingAdapter("scrollListenerTop")
        fun setTopScrollListener(recyclerView: RecyclerView, collapsibleText: CollapsibleText) {
            recyclerView.addOnScrollListener(collapsibleText.scrollListener)
        }

        @JvmStatic
        @BindingAdapter("scrollListenerBottom")
        fun setBottomScrollListener(recyclerView: RecyclerView, collapsibleText: CollapsibleText) {
            recyclerView.addOnScrollListener(collapsibleText.scrollListener)
        }
    }
}
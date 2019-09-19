package com.poc.flickrdisplay.customviews

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView


class CollapsibleText : AppCompatTextView {
    private var originalHeight: Int = 0
    private var originalWidth: Int = 0
    private var state: ScrollState = ScrollState.NO_SCROLLING

    var scrollListener: RecyclerView.OnScrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            if(dy == 0) return

            if (dy < 0) {
                when (state) {
                    ScrollState.NO_SCROLLING, ScrollState.SCROLLING_DOWN, ScrollState.START_SCROLLING_DOWN -> state = ScrollState.START_SCROLLING_UP
                }
            } else {
                when (state) {
                    ScrollState.NO_SCROLLING, ScrollState.SCROLLING_UP, ScrollState.START_SCROLLING_UP -> state = ScrollState.START_SCROLLING_DOWN
                }
            }

            when (state) {
                ScrollState.START_SCROLLING_UP -> {
                    state = ScrollState.SCROLLING_UP
                    expand(200, originalHeight, recyclerView)
                }

                ScrollState.START_SCROLLING_DOWN -> {
                    state = ScrollState.SCROLLING_DOWN
                    collapse(200, 0, recyclerView)
                }
            }
        }
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        init()
    }

    private fun init() {
        if (originalHeight == 0) {
            originalWidth = this.measuredWidth
            originalHeight = this.measuredHeight
        }
    }

    private fun expand(duration: Int, targetHeight: Int, recyclerView: RecyclerView) {
        this.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        this.layoutParams.height = 0
        this.visibility = View.VISIBLE
        animate(duration, targetHeight, recyclerView)
    }

    private fun collapse(duration: Int, targetHeight: Int, recyclerView: RecyclerView) {
        animate(duration, targetHeight, recyclerView)
    }

    private fun animate(duration: Int, targetHeight: Int, recyclerView: RecyclerView) {
        val valueAnimator = ValueAnimator.ofInt(0, targetHeight)
        valueAnimator.interpolator = DecelerateInterpolator()
        valueAnimator.addUpdateListener { animation ->
            this.layoutParams.height = animation.animatedValue as Int
            recyclerView.setPadding(0, targetHeight, 0, 0)
            this.requestLayout()
        }
        valueAnimator.interpolator = DecelerateInterpolator()
        valueAnimator.duration = duration.toLong()
        valueAnimator.start()
    }

    enum class ScrollState {
        START_SCROLLING_UP,
        START_SCROLLING_DOWN,
        NO_SCROLLING,
        SCROLLING_UP,
        SCROLLING_DOWN,
    }
}

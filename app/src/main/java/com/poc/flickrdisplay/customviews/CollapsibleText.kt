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
    companion object {
        const val ORIENTATION_TOP: Int = 1
        const val ORIENTATION_BOTTOM: Int = 1
    }
    private var originalHeight: Int = 0
    private var originalWidth: Int = 0
    private var state: ScrollState = ScrollState.NO_SCROLLING
    var collapseOrientation:Int ? = null

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
                    when(collapseOrientation) {
                        ORIENTATION_TOP ->  expand(200, originalHeight, recyclerView)
                        else -> collapse(200, 0, recyclerView)
                    }

                }

                ScrollState.START_SCROLLING_DOWN -> {
                    state = ScrollState.SCROLLING_DOWN
                    when(collapseOrientation) {
                        ORIENTATION_TOP -> collapse(200, 0, recyclerView)
                        else -> expand(200, originalHeight, recyclerView)
                    }
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
            when(collapseOrientation) {
                ORIENTATION_TOP -> recyclerView.setPadding(0, targetHeight, 0, 0)
                else -> recyclerView.setPadding(0, 0, 0, targetHeight)
            }
            this.requestLayout()
        }
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

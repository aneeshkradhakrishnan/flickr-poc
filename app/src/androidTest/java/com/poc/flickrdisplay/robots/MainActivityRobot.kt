package com.poc.flickrdisplay.robots

import com.poc.flickrdisplay.R
import com.poc.flickrdisplay.util.EspressoUtil

interface MainActivityRobot {

    class Eyes {

        fun seesNumberOfItems(): Eyes {
            EspressoUtil.seesRecyclerViewItems(R.id.photos_view, 10)
            return this
        }

        fun seesTitleForTheItem(): Eyes {
            EspressoUtil.seesRecyclerViewIndexWithText(R.id.photos_view, 0, "I‘m With Cupid 0 Graphic Tee")
            return this
        }

        fun seesIdForTheItem(): Eyes {
            EspressoUtil.seesRecyclerViewIndexWithText(R.id.photos_view, 0, "548917-id-0")
            return this
        }
    }
}

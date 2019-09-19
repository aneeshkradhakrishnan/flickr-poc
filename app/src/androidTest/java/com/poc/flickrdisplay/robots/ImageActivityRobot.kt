package com.poc.flickrdisplay.robots

import com.poc.flickrdisplay.R
import com.poc.flickrdisplay.util.EspressoUtil

interface ImageActivityRobot {

    class Eyes {

        fun seesTitle(): Eyes {
            EspressoUtil.seesViewWithText(R.id.flickr_title, "I‘m With Cupid 1 Graphic Tee")
            return this
        }

        fun seesId(): Eyes {
            EspressoUtil.seesViewWithText(R.id.flickr_id_value, "548917-id-1")
            EspressoUtil.seesViewWithText(R.id.flickr_id, R.string.id)
            return this
        }

        fun seesServer(): Eyes {
            EspressoUtil.seesViewWithText(R.id.flickr_server_value, "server-4b92-1")
            EspressoUtil.seesViewWithText(R.id.flickr_server, R.string.server)
            return this
        }

        fun seesOwner(): Eyes {
            EspressoUtil.seesViewWithText(R.id.flickr_owner_value, "owner-1")
            EspressoUtil.seesViewWithText(R.id.flickr_owner, R.string.owner)
            return this
        }

        fun seesSecret(): Eyes {
            EspressoUtil.seesViewWithText(R.id.flickr_secret_value, "secret-1")
            EspressoUtil.seesViewWithText(R.id.flickr_secret, R.string.secret)
            return this
        }

        fun seesPhotoImage(): Eyes {
            EspressoUtil.seesView(R.id.flickr_photo)
            return this
        }
    }
}

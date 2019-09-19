package com.poc.flickrdisplay.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.poc.flickrdisplay.R
import com.poc.flickrdisplay.databinding.ActivityPhotoDetailBinding
import com.poc.flickrdisplay.model.Photo

class ImageDetailsActivity : AppCompatActivity() {

    companion object {
        const val PHOTO_PARAM: String = "PHOTO"
        const val REQUEST: Int = 100
        const val RESULT_OK: Int = 200
        const val TITLE_DATA: String = "TITLE"
    }

    lateinit var binding: ActivityPhotoDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_photo_detail)
        binding.photo = intent.getSerializableExtra(PHOTO_PARAM) as Photo?
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra(TITLE_DATA, binding.photo?.title?:"")
        setResult(RESULT_OK, intent)
        super.onBackPressed()
    }
}
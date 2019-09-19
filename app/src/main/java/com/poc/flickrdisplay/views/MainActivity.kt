package com.poc.flickrdisplay.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.poc.flickrdisplay.R
import com.poc.flickrdisplay.databinding.ActivityMainBinding
import com.poc.flickrdisplay.model.Photo
import com.poc.flickrdisplay.viewmodels.MainViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, com.poc.flickrdisplay.R.layout.activity_main)
        viewModel.itemDivider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        viewModel.startImageDetailsActivity = this::startImageDetailActivity
        viewModel.title.set(getString(R.string.title))
        binding.vm = viewModel
        lifecycle.addObserver(viewModel)
    }

    private fun startImageDetailActivity(photo: Photo) {
        val intent = Intent(baseContext, ImageDetailsActivity::class.java)
        intent.putExtra(ImageDetailsActivity.PHOTO_PARAM, photo)
        startActivityForResult(intent, ImageDetailsActivity.REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ImageDetailsActivity.REQUEST && resultCode == ImageDetailsActivity.RESULT_OK) {
            data?.let { viewModel.title.set(it.getStringExtra(ImageDetailsActivity.TITLE_DATA)) }
        }
    }
}

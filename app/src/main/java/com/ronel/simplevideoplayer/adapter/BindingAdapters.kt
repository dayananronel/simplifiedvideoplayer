package com.ronel.simplevideoplayer.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.ronel.simplevideoplayer.R


@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, resource: String?) {
    if (resource == null){
        Glide.with(imageView.context)
            .load(R.drawable.ic_baseline_broken_image_24)
            .into(imageView)
    }else{
        Glide.with(imageView.context)
            .load(resource)
            .centerCrop()
            .error(R.drawable.ic_launcher_foreground)
            .into(imageView)
    }

}

@BindingAdapter("load_text")
fun loadText(view: TextView, resource: String?) {
    view.apply {
        text   = resource ?: "Title not available."
    }
}
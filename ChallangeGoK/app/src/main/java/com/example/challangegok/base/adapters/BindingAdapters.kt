package com.example.challangegok.base.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.challangegok.R
import com.squareup.picasso.Picasso

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("visible")
    fun setVisible(view: View, visibility: Boolean) {
        view.visibility = if (visibility) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("image_url")
    fun setImage(imageView: ImageView, url: String?) {
        if (!url.isNullOrBlank()) {
            Picasso
                .get()
                .load(url)
                .error(R.drawable.ic_baseline_info_24)
                .into(imageView)
        }else{
            imageView.setImageDrawable(null)
        }
    }

    @JvmStatic
    @BindingAdapter("text")
    fun setText(view: TextView, text: String?){
        text?.let {
            view.text = text
        }
    }
}
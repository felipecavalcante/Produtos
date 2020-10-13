package com.example.challangegok.base.extensions

import android.app.Activity
import android.os.Parcelable

inline fun <reified T : Parcelable> Activity.requireParcelable(key: String): T {
    return intent.getParcelableExtra(key)!!
}

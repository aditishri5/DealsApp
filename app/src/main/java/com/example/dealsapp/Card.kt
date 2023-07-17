package com.example.dealsapp

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

// Card of Deals data
@Parcelize
data class Card  (
    @SerializedName ("title") @Expose var title: String? = null,
    @SerializedName ("description") @Expose var description: String? = null
    ) : Parcelable

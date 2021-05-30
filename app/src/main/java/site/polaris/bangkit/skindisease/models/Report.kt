package site.polaris.bangkit.skindisease.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Report(
    var title: String?,
    var image: String?,
    var description: String?,
    var suggestion: String?,
    var sendDate: String?,
    var resultDate: String?
) : Parcelable

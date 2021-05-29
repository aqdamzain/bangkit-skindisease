package site.polaris.bangkit.skindisease.models

import android.os.Parcel
import android.os.Parcelable

data class Report(
    var title: String?,
    var image: String?,
    var description: String?,
    var suggestion: String?,
    var sendDate: String?,
    var resultDate: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(image)
        parcel.writeString(description)
        parcel.writeString(suggestion)
        parcel.writeString(sendDate)
        parcel.writeString(resultDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Report> {
        override fun createFromParcel(parcel: Parcel): Report {
            return Report(parcel)
        }

        override fun newArray(size: Int): Array<Report?> {
            return arrayOfNulls(size)
        }
    }
}

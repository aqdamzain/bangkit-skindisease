package site.polaris.bangkit.skindisease.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Report(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "image")
    var image: String? = null,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @ColumnInfo(name = "suggestion")
    var suggestion: String? = null,

    @ColumnInfo(name = "send_date")
    var sendDate: String? = null,

    @ColumnInfo(name = "result_date")
    var resultDate: String? = null
) : Parcelable

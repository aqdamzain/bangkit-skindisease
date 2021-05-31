package site.polaris.bangkit.skindisease.models.remote

import com.google.gson.annotations.SerializedName

data class ReportResponse(
    @field:SerializedName("disease")
    val disease: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("suggestion")
    val suggestion: String
)
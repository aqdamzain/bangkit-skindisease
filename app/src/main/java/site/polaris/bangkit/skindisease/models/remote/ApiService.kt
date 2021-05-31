package site.polaris.bangkit.skindisease.models.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("testmodel")
    fun postImage(@Body reportRequest: ReportRequest): Call<ReportResponse>
}
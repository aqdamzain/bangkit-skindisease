package site.polaris.bangkit.skindisease.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import site.polaris.bangkit.skindisease.models.remote.ApiConfig
import site.polaris.bangkit.skindisease.models.remote.ReportRequest
import site.polaris.bangkit.skindisease.models.remote.ReportResponse

class RemoteReportRepository {
    fun postFeatures(data: ReportRequest): LiveData<ReportResponse> {
        val reportResponse = MutableLiveData<ReportResponse>()

        val client = ApiConfig.getApiService().postImage(data)
        client.enqueue(object : Callback<ReportResponse> {
            override fun onResponse(
                call: Call<ReportResponse>,
                response: Response<ReportResponse>
            ) {
                if(response.isSuccessful) {
                    reportResponse.postValue(response.body())
                } else {
                    Log.e("RemoteReportRepository", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                Log.e("RemoteReportRepository", "onFailure: ${t.message.toString()}")
            }

        })

        return reportResponse
    }
}
package site.polaris.bangkit.skindisease

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

object Utils {
    fun base64toBitmap(data: String?) : Bitmap {
        val imageBytes = Base64.decode(data, 0)
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }
}
package site.polaris.bangkit.skindisease.models.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import site.polaris.bangkit.skindisease.models.Report

@Database(entities = [Report::class], version = 1)
abstract class ReportRoomDatabase : RoomDatabase() {
    abstract fun reportDao(): ReportDao

    companion object {
        @Volatile
        private var INSTANCE: ReportRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): ReportRoomDatabase {
            if(INSTANCE == null) {
                synchronized(ReportRoomDatabase::class.java){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ReportRoomDatabase::class.java, "report_database")
                        .build()
                }
            }
            return INSTANCE as ReportRoomDatabase
        }
    }
}
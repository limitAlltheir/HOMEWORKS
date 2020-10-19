package by.limitAlltheir.myapplication.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "doctor_table")
data class Doctor(
    @ColumnInfo(name = "doctor_name")
    val name: String,
    @ColumnInfo(name = "doctor_position")
    val position: String,
    @ColumnInfo(name = "doctor_cabinet")
    val cabinet: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
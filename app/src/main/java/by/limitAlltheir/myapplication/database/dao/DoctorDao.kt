package by.limitAlltheir.myapplication.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import by.limitAlltheir.myapplication.database.entity.Doctor

@Dao
interface DoctorDao {

    @Insert
    suspend fun addDoctor(doc: Doctor)

    @Delete
    suspend fun deleteDoctor(doc: Doctor)

    @Query("SELECT * FROM doctor_table")
    suspend fun getAllDoctors(): List<Doctor>

    @Query("DELETE FROM doctor_table WHERE id=:id")
    suspend fun deleteDoctorById(id: Int)
}
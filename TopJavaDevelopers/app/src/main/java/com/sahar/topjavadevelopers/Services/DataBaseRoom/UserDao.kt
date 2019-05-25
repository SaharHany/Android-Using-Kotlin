package com.sahar.topjavadevelopers.Services.DataBaseRoom

import androidx.room.*
import com.sahar.topjavadevelopers.Model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAllUsers():List<User>

    @Query("SELECT * FROM User WHERE login LIKE :name")
    fun getUserByName(name:String):User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(vararg user:User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user:User)

    @Delete
    fun deleteUser(user:User)

}
package com.sahar.topjavadevelopers.Services.DataBaseRoom

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sahar.topjavadevelopers.Model.User

@Database(entities = arrayOf(User::class),version = 1)
abstract class GithubDatabase : RoomDatabase(){
    abstract fun getUserDaoInstance(): UserDao
}
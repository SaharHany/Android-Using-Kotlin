package com.sahar.topjavadevelopers.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Result(
    val incomplete_results: Boolean,
    val items: List<User>,
    val total_count: Int
)

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId : Int,
    @ColumnInfo
    val avatar_url: String,
    @ColumnInfo
    val events_url: String,
    @ColumnInfo
    val followers_url: String,
    @ColumnInfo
    val following_url: String,
    @ColumnInfo
    val gists_url: String,
    @ColumnInfo
    val gravatar_id: String,
    @ColumnInfo
    val html_url: String,
    @ColumnInfo
    val id: Int,
    @ColumnInfo
    val login: String,
    @ColumnInfo
    val node_id: String,
    @ColumnInfo
    val organizations_url: String,
    @ColumnInfo
    val received_events_url: String,
    @ColumnInfo
    val repos_url: String,
    @ColumnInfo
    val score: Double,
    @ColumnInfo
    val site_admin: Boolean,
    @ColumnInfo
    val starred_url: String,
    @ColumnInfo
    val subscriptions_url: String,
    @ColumnInfo
    val type: String,
    @ColumnInfo
    val url: String
)
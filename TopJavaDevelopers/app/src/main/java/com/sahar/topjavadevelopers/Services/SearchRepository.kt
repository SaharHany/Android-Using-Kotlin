package com.sahar.topjavadevelopers.Services

import com.sahar.topjavadevelopers.Model.Result
import io.reactivex.Observable

class SearchRepository (val apiService: GithubApiService){
    fun searchUsers(location: String , language: String):Observable<Result>{
        return apiService.search(query = "location:$location language:$language")
    }


}
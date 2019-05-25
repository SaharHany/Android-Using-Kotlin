package com.sahar.topjavadevelopers.Screens.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.sahar.topjavadevelopers.Model.Result
import com.sahar.topjavadevelopers.Model.User
import com.sahar.topjavadevelopers.R
import com.sahar.topjavadevelopers.Services.DataBaseRoom.GithubDatabase
import com.sahar.topjavadevelopers.Services.GithubApiService
import com.sahar.topjavadevelopers.Services.SearchRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    var developers = arrayListOf<User>()
    val adapter = Adapter(users = developers)
 //   var presenter = MainPresenter(this)
    lateinit var db :GithubDatabase
    val githubApiService = GithubApiService.create()
    val repository = SearchRepository(githubApiService)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initDatabaseRoom()




        getAllUsers()



    }

    private fun initDatabaseRoom() {
         db = Room.databaseBuilder(applicationContext,
            GithubDatabase::class.java, "Github.db")
            .build()
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recView)
        recyclerView.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    private fun insertAll(users:List<User>){
        Thread {
          //  db.getUserDaoInstance().insertAllUsers(*users.toTypedArray())
            users.forEach { t: User? ->  db.getUserDaoInstance().insertUser(user = t!!)
            println("inside inserted")
            }
        }.start()

    }

    private fun getAllUsers(){
        println("getAllUsers")
        Thread {
            developers.addAll(db.getUserDaoInstance().getAllUsers())
            println("inside getAllUsers:"+developers.size)

            println(developers.size)
            if(developers.size == 0) {
                println("getting from repo")
                repository.searchUsers("Egypt", "Java")
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({ result: Result? ->
                        developers.addAll(result?.items as ArrayList<User>)
                        println("result: " + result.items.size)
                        println("result: " + developers.size)
                        adapter.notifyDataSetChanged()
                        insertAll(developers)
                    }, { error ->
                        error.printStackTrace()
                    }
                    )

            }else{
                println("getting from database")
                println("result: " + developers.size)
                adapter.notifyDataSetChanged()
            }
        }.start()
    }


    private fun getUserByName(name:String){
        var user : User
        Thread {
            user = db.getUserDaoInstance().getUserByName(name)
        }.start()

    }

    private fun deleteUser(user:User){

    }
}

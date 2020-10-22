package com.example.submission1_dicoding

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import com.example.submission1_dicoding.Adapter.AdapterUser
import com.example.submission1_dicoding.Model.ModelGithub

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: AdapterUser
    private lateinit var dataName: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var GithubUser = arrayListOf<ModelGithub>()

    private lateinit var listUser: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar!!.title= "Github User List"


        listUser = findViewById(R.id.lvDataUser)
        adapter = AdapterUser(this)
        listUser.adapter = adapter

        listUser.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->  
            val clickItem = parent.getItemAtPosition(position) as ModelGithub
            val detailClick = Intent(this, DetailUser::class.java)
            detailClick.putExtra(DetailUser.nameUser, clickItem.name)
            detailClick.putExtra(DetailUser.followers, clickItem.followers)
            detailClick.putExtra(DetailUser.following, clickItem.following)
            detailClick.putExtra(DetailUser.photo, clickItem.avatar)
            detailClick.putExtra(DetailUser.username, clickItem.username)
            detailClick.putExtra(DetailUser.repository, clickItem.repository)
            detailClick.putExtra(DetailUser.company, clickItem.company)
            detailClick.putExtra(DetailUser.location, clickItem.location)
            startActivity(detailClick)
        }

        prepare()
        addItem()
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.name)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataRepository = resources.getStringArray(R.array.repository)
        dataLocation = resources.getStringArray(R.array.location)
        dataCompany = resources.getStringArray(R.array.company)
        dataUsername = resources.getStringArray(R.array.username)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val Github = ModelGithub(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataUsername[position],
                dataLocation[position],
                dataRepository[position],
                dataFollowers[position],
                dataFollowing[position],
                dataCompany[position],
            )
            GithubUser.add(Github)
        }
        adapter.userGithub = GithubUser
    }



}
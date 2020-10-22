package com.example.submission1_dicoding

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailUser : AppCompatActivity() {
    companion object {
        const val nameUser = "nameUser"
        const val followers = "followers"
        const val following = "following"
        const val photo = "photo"
        const val username = "username"
        const val repository = "repository"
        const val location = "location"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val actionBar = supportActionBar
        actionBar!!.title= "Detail User"
        supportActionBar?.setHomeAsUpIndicator(R.drawable.backicon)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        val tvNameUser: TextView = findViewById(R.id.tvNameUser)
        val tvUsername: TextView = findViewById(R.id.tvUsername)
        val tvFollowers: TextView = findViewById(R.id.tvFollowers)
        val tvFollowing: TextView = findViewById(R.id.tvFollowing)
        val tvLocation: TextView = findViewById(R.id.tvLocation)
        val tvRepository: TextView = findViewById(R.id.tvRepository)
        val ivAvatar: ImageView = findViewById(R.id.ivAvatar)

        val gambar = intent.getIntExtra(photo, 0)
        val nameUsers  = intent.getStringExtra(nameUser)
        val followersUser  = intent.getStringExtra(followers)
        val followingsUser  = intent.getStringExtra(following)
        val locationUser  = intent.getStringExtra(location)
        val repositoryUser  = intent.getStringExtra(repository)
        val usernameUser  = intent.getStringExtra(username)

        tvNameUser.setText(nameUsers)
        tvUsername.setText(usernameUser)
        tvFollowers.setText(followersUser)
        tvFollowing.setText(followingsUser)
        tvLocation.setText(locationUser)
        tvRepository.setText(repositoryUser)
        Glide.with(this)
            .load(gambar)
            .into(ivAvatar);
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}



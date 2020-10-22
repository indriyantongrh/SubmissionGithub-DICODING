package com.example.submission1_dicoding.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.submission1_dicoding.Model.ModelUser
import com.example.submission1_dicoding.R



/**
 * Created by Indriyantongrh on 15/10/20.
 */
class AdapterUser internal constructor(private val context: Context) : BaseAdapter() {

    internal var userGithub = arrayListOf<ModelUser>()



    override fun getCount(): Int {
        return userGithub.size
    }

    override fun getItem(position: Int): Any {
        return userGithub[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if(itemView==null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)
        val User = getItem(position) as ModelUser
        viewHolder.bind(User)

        return  itemView

    }

}


class ViewHolder(view: View) {
    private val tvNameUser: TextView = view.findViewById(R.id.tvNameUser)
    private val ivAvatar: ImageView = view.findViewById(R.id.ivAvatar)
    private val tvFollowers: TextView = view.findViewById(R.id.tvFollowers)
    private val tvFollowing: TextView = view.findViewById(R.id.tvFollowing)



    fun bind(user: ModelUser) {
        tvNameUser.text =user.name
        tvFollowers.text =user.followers
        tvFollowing.text = user.following
        ivAvatar.setImageResource(user.photo)

    }

}

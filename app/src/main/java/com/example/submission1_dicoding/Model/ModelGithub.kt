package com.example.submission1_dicoding.Model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Indriyantongrh on 22/10/20.
 */
data class ModelGithub(

    var avatar: Int,
    var name: String?,
    var username: String?,
    var location: String?,
    var repository: String?,
    var followers: String?,
    var following: String?,
    var company: String?

): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(avatar)
        parcel.writeString(name)
        parcel.writeString(username)
        parcel.writeString(location)
        parcel.writeString(repository)
        parcel.writeString(followers)
        parcel.writeString(following)
        parcel.writeString(company)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModelGithub> {
        override fun createFromParcel(parcel: Parcel): ModelGithub {
            return ModelGithub(parcel)
        }

        override fun newArray(size: Int): Array<ModelGithub?> {
            return arrayOfNulls(size)
        }
    }
}
package com.example.submission1_dicoding.Model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Indriyantongrh on 12/10/20.
 */

data class ModelUser(

    var photo: Int,
    var name: String?,
    var followers: String?,
    var following: String?,
    var username: String?,
    var location: String?,
    var repository: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(photo)
        parcel.writeString(name)
        parcel.writeString(followers)
        parcel.writeString(following)
        parcel.writeString(username)
        parcel.writeString(location)
        parcel.writeString(repository)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModelUser> {
        override fun createFromParcel(parcel: Parcel): ModelUser {
            return ModelUser(parcel)
        }

        override fun newArray(size: Int): Array<ModelUser?> {
            return arrayOfNulls(size)
        }
    }
}

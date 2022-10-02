package com.example.flix

import android.graphics.Movie
import android.os.Parcelable
import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.json.JSONArray


@Serializable
data class Person(
    val movieId: Int?,
    val profilePath: String?,
    val name: String?,
    val knownFor: String,

    ) : java.io.Serializable {
    val profileImageUrl = "https://image.tmdb.org/t/p/w342/$profilePath"

    companion object {
        fun fromJasonArray(movieJsonArray: JSONArray): List<Person> {
            val people = mutableListOf<Person>()
            for(i in 0 until movieJsonArray.length()){
                val peopleJson = movieJsonArray.getJSONObject(i)
                people.add(
                    Person(
                        peopleJson.getInt("id"),
                        peopleJson.getString("profile_path"),
                        peopleJson.getString("name"),
                        peopleJson.getString("known_for")
                        )
                )
            }
            return people
        }
    }
}

package com.example.dbassignment

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ActorResponseItem(
    val actor_id: Int,
    val actor_image: String,
    val actor_name: String,
    val actor_role: String,
    val enter_date: String,
    val image: String,
    val journal_count: Int,
    val journal_evaluation: String,
    val movie_id: Int,
    val movie_rate: String,
    val movie_title: String,
    val netizen_count: Int,
    val netizen_evaluation: Double,
    val opening_date: String,
    val playing_time: Int,
    val totalaudience: String,
    val watcher_count: Int,
    val watcher_evaluation: Double
):Serializable
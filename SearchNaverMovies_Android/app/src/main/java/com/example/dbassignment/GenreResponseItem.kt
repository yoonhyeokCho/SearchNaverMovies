package com.example.dbassignment

import java.io.Serializable

data class GenreResponseItem(
    val content: String,
    val enter_date: String,
    val id: Int,
    val image: String,
    val journal_count: Int,
    val journal_evaluation: String,
    val movie_id: Int,
    val movie_rate: String,
    val movie_title: String,
    val netizen_count: Int,
    val netizen_evaluation: Float,
    val opening_date: String,
    val playing_time: Int,
    val totalaudience: String,
    val watcher_count: Int,
    val watcher_evaluation: Float
):Serializable
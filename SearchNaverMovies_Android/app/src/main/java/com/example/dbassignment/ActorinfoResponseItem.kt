package com.example.dbassignment

import java.io.Serializable

data class ActorinfoResponseItem(
    val actor_id: Int,
    val actor_image: String,
    val actor_name: String,
    val actor_role: String,
    val movie_id: Int
):Serializable
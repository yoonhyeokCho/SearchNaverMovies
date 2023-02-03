package com.example.dbassignment

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MovieInterface {

    @POST("/getdata/country")
    suspend fun postCountryRequest(
        @Body country: Country
    ): Response<MovieResponse>

    @POST("/getdata/actor")
    suspend fun postAcotrRequest(
        @Body actor: Actor
    ): Response<ActorResponse>

    @POST("/getdata/director")
    suspend fun postDirectorRequest(
        @Body director: Director
    ): Response<DirectorResponse>

    @POST("/getdata/genre")
    suspend fun postgenreRequest(
        @Body genre: Genre
    ): Response<GenreResponse>

    @POST("/getdata/title")
    suspend fun posttitleRequest(
        @Body movie_title: Title
    ): Response<TitleResponse>

    @POST("/getdata/actor/opening")
    suspend fun postOpeningAcotrRequest(
        @Body actor: Actor
    ): Response<ActorResponse>

    @POST("/getdata/director/opening")
    suspend fun postOpeningDirectorRequest(
        @Body director: Director
    ): Response<DirectorResponse>

    @POST("/getdata/genre/opening")
    suspend fun postOpeninggenreRequest(
        @Body genre: Genre
    ): Response<GenreResponse>

    @POST("/getdata/title/opening")
    suspend fun postOpeningtitleRequest(
        @Body movie_title: Title
    ): Response<TitleResponse>

    @POST("/getdata/country/opening")
    suspend fun postOpeningCountryRequest(
        @Body country: Country
    ): Response<MovieResponse>

    @POST("/getdata/actor/country")
    suspend fun actorcountryRequest(
        @Body movieid: ActorCountry
    ): Response<ActorCountryResponse>

    @POST("/getdata/actor/director")
    suspend fun actordirectorRequset(
        @Body moviedid: ActorDirector
    ):Response<ActorDirectorResponse>

    @POST("/getdata/actor/genre")
    suspend fun actorgenreRequest(
        @Body moviedid: ActorGenre
    ):Response<ActorGenreResponse>

    @POST("/getdata/actor/review")
    suspend fun actorreviewRequest(
        @Body moviedid: ActorReview
    ):Response<ActorReviewResponse>

    @POST("/getdata/actor/quotes")
    suspend fun actorquotesRequest(
        @Body moviedid:ActorQuotes
    ):Response<ActorQuotesResponse>

    @POST("/getdata/actor/actors")
    suspend fun actorinfoRequest(
        @Body moviedid:ActorInfo
    ):Response<ActorinfoResponse>

}
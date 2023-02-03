package com.example.dbassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbassignment.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: MyAdapter
    lateinit var actorAdapter: ActorAdapter
    lateinit var directorAdapter: DirectorAdapter
    lateinit var genreAdapter: GenreAdapter
    lateinit var titleAdapter: TitleAdapter

    lateinit var openingactorAdapter:ActorAdapter
    lateinit var openingdirectorAdapter:DirectorAdapter
    lateinit var openingCountryAdapter: MyAdapter
    lateinit var openinggenreAdapter:GenreAdapter
    lateinit var openingtitleAdapter:TitleAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        initLayout()
    }

    private fun initData() {
    }

    private fun initLayout() {

        binding.playtimesort.setOnClickListener {
            binding.actorButton.isEnabled = true
            binding.directorButton.isEnabled = true
            binding.countryButton.isEnabled = true
            binding.genreButton.isEnabled = true
            binding.titleButton.isEnabled = true

            binding.actorButton.setOnClickListener {
                binding.searchButton.isEnabled = true
                binding.editTextTextPersonName.isEnabled = true


                binding.searchButton.setOnClickListener {
                    var actor = binding.editTextTextPersonName.text
                    CoroutineScope(Dispatchers.Main).launch {
                        var actorResponse: Response<ActorResponse>
                        withContext(Dispatchers.IO) {
                            actorResponse =
                                MovieServiceImp.movieInterface.postAcotrRequest(Actor(actor.toString()))
                        }

                        if (actorResponse.isSuccessful) {
                            binding.recyclerview.layoutManager = LinearLayoutManager(
                                this@MainActivity, LinearLayoutManager.VERTICAL, false
                            )
                            actorAdapter = ActorAdapter(actorResponse.body()!!)
                            actorAdapter.itemClickListener =
                                object : ActorAdapter.OnItemClickListener {
                                    override fun OnItemClick(data: ActorResponseItem) {
                                        CoroutineScope(Dispatchers.Main).launch {
                                            var countryResponse: Response<ActorCountryResponse>
                                            var directorResponse: Response<ActorDirectorResponse>
                                            var genreResponse: Response<ActorGenreResponse>
                                            var reviewResponse: Response<ActorReviewResponse>
                                            var quotesResponse: Response<ActorQuotesResponse>
                                            var actorinfoResponse: Response<ActorinfoResponse>

                                            withContext(Dispatchers.IO) {
                                                Log.i("sdsdsd", "sd1 :${data.movie_id} ")
                                                countryResponse =
                                                    MovieServiceImp.movieInterface.actorcountryRequest(
                                                        ActorCountry(data.movie_id.toString())
                                                    )
                                                directorResponse =
                                                    MovieServiceImp.movieInterface.actordirectorRequset(
                                                        ActorDirector(data.movie_id.toString())
                                                    )
                                                genreResponse =
                                                    MovieServiceImp.movieInterface.actorgenreRequest(
                                                        ActorGenre(data.movie_id.toString())
                                                    )
                                                reviewResponse =
                                                    MovieServiceImp.movieInterface.actorreviewRequest(
                                                        ActorReview(data.movie_id.toString())
                                                    )
                                                quotesResponse =
                                                    MovieServiceImp.movieInterface.actorquotesRequest(
                                                        ActorQuotes(data.movie_id.toString())
                                                    )
                                                actorinfoResponse =
                                                    MovieServiceImp.movieInterface.actorinfoRequest(
                                                        ActorInfo(data.movie_id.toString())
                                                    )

                                            }
                                            if (countryResponse.isSuccessful && directorResponse.isSuccessful) {
                                                val intent = Intent(
                                                    this@MainActivity,
                                                    SecondActivity::class.java
                                                )
                                                intent.putExtra("dividenum", 1)
                                                intent.putExtra("actordata", data)
                                                intent.putExtra(
                                                    "countrydata",
                                                    countryResponse.body()
                                                )
                                                intent.putExtra(
                                                    "directordata",
                                                    directorResponse.body()
                                                )
                                                intent.putExtra("genredata", genreResponse.body())
                                                intent.putExtra("reviewdata", reviewResponse.body())
                                                intent.putExtra("quotesdata", quotesResponse.body())
                                                intent.putExtra(
                                                    "actorinfo",
                                                    actorinfoResponse.body()
                                                )
                                                startActivity(intent)
                                            } else {
                                                Log.i(
                                                    "MainActivty",
                                                    "initLayout: actorcountry failed "
                                                )
                                            }
                                        }
                                    }
                                }
                            binding.recyclerview.adapter = actorAdapter
                        } else {
                            Log.i("MainActivty", "initLayout: ActorAdapter failed ")
                        }
                    }
                }
            }

            binding.countryButton.setOnClickListener {
                binding.searchButton.isEnabled = true
                binding.editTextTextPersonName.isEnabled = true


                binding.searchButton.setOnClickListener {
                    var country = binding.editTextTextPersonName.text
                    CoroutineScope(Dispatchers.Main).launch {
                        var movieResponse: Response<MovieResponse>
                        withContext(Dispatchers.IO) {
                            movieResponse =
                                MovieServiceImp.movieInterface.postCountryRequest(Country(country.toString()))
                        }
                        if (movieResponse.isSuccessful) {
                            binding.recyclerview.layoutManager = LinearLayoutManager(
                                this@MainActivity, LinearLayoutManager.VERTICAL, false
                            )
                            adapter = MyAdapter(movieResponse.body()!!)
                            adapter.itemClickListener = object : MyAdapter.OnItemClickListener {
                                override fun OnItemClick(data: MovieResponseItem) {
                                    CoroutineScope(Dispatchers.Main).launch {
                                        var countryResponse: Response<ActorCountryResponse>
                                        var directorResponse: Response<ActorDirectorResponse>
                                        var genreResponse: Response<ActorGenreResponse>
                                        var reviewResponse: Response<ActorReviewResponse>
                                        var quotesResponse: Response<ActorQuotesResponse>
                                        var actorinfoResponse: Response<ActorinfoResponse>

                                        withContext(Dispatchers.IO) {
                                            countryResponse =
                                                MovieServiceImp.movieInterface.actorcountryRequest(
                                                    ActorCountry(data.movie_id.toString())
                                                )
                                            directorResponse =
                                                MovieServiceImp.movieInterface.actordirectorRequset(
                                                    ActorDirector(data.movie_id.toString())
                                                )
                                            genreResponse =
                                                MovieServiceImp.movieInterface.actorgenreRequest(
                                                    ActorGenre(data.movie_id.toString())
                                                )
                                            reviewResponse =
                                                MovieServiceImp.movieInterface.actorreviewRequest(
                                                    ActorReview(data.movie_id.toString())
                                                )
                                            quotesResponse =
                                                MovieServiceImp.movieInterface.actorquotesRequest(
                                                    ActorQuotes(data.movie_id.toString())
                                                )
                                            actorinfoResponse =
                                                MovieServiceImp.movieInterface.actorinfoRequest(
                                                    ActorInfo(data.movie_id.toString())
                                                )
                                        }
                                        if (countryResponse.isSuccessful && directorResponse.isSuccessful) {
                                            val intent = Intent(
                                                this@MainActivity,
                                                SecondActivity::class.java
                                            )
                                            intent.putExtra("dividenum", 3)
                                            intent.putExtra("actordata", data)
                                            intent.putExtra("countrydata", countryResponse.body())
                                            intent.putExtra("directordata", directorResponse.body())
                                            intent.putExtra("genredata", genreResponse.body())
                                            intent.putExtra("reviewdata", reviewResponse.body())
                                            intent.putExtra("quotesdata", quotesResponse.body())
                                            intent.putExtra("actorinfo", actorinfoResponse.body())
                                            startActivity(intent)
                                        } else {
                                            Log.i("MainActivty", "initLayout: actorcountry failed ")
                                        }
                                    }
                                }

                            }

                            binding.recyclerview.adapter = adapter

                        } else {
                            Log.i("MainActivty", "initLayout: country failed ")
                        }
                    }
                }
            }


            binding.directorButton.setOnClickListener {
                binding.searchButton.isEnabled = true
                binding.editTextTextPersonName.isEnabled = true

                binding.searchButton.setOnClickListener {

                    var director = binding.editTextTextPersonName.text
                    CoroutineScope(Dispatchers.Main).launch {
                        var directorResponse: Response<DirectorResponse>
                        withContext(Dispatchers.IO) {
                            directorResponse =
                                MovieServiceImp.movieInterface.postDirectorRequest(Director(director.toString()))
                        }
                        if (directorResponse.isSuccessful) {
                            binding.recyclerview.layoutManager = LinearLayoutManager(
                                this@MainActivity, LinearLayoutManager.VERTICAL, false
                            )
                            directorAdapter = DirectorAdapter(directorResponse.body()!!)
                            directorAdapter.itemClickListener =
                                object : DirectorAdapter.OnItemClickListener {
                                    override fun OnItemClick(data: DirectorResponseItem) {
                                        CoroutineScope(Dispatchers.Main).launch {
                                            var countryResponse: Response<ActorCountryResponse>
                                            var directorResponse: Response<ActorDirectorResponse>
                                            var genreResponse: Response<ActorGenreResponse>
                                            var reviewResponse: Response<ActorReviewResponse>
                                            var quotesResponse: Response<ActorQuotesResponse>
                                            var actorinfoResponse: Response<ActorinfoResponse>

                                            withContext(Dispatchers.IO) {
                                                Log.i("sdsdsd", "sd1 :${data.movie_id} ")
                                                countryResponse =
                                                    MovieServiceImp.movieInterface.actorcountryRequest(
                                                        ActorCountry(data.movie_id.toString())
                                                    )
                                                directorResponse =
                                                    MovieServiceImp.movieInterface.actordirectorRequset(
                                                        ActorDirector(data.movie_id.toString())
                                                    )
                                                genreResponse =
                                                    MovieServiceImp.movieInterface.actorgenreRequest(
                                                        ActorGenre(data.movie_id.toString())
                                                    )
                                                reviewResponse =
                                                    MovieServiceImp.movieInterface.actorreviewRequest(
                                                        ActorReview(data.movie_id.toString())
                                                    )
                                                quotesResponse =
                                                    MovieServiceImp.movieInterface.actorquotesRequest(
                                                        ActorQuotes(data.movie_id.toString())
                                                    )
                                                actorinfoResponse =
                                                    MovieServiceImp.movieInterface.actorinfoRequest(
                                                        ActorInfo(data.movie_id.toString())
                                                    )

                                            }
                                            if (countryResponse.isSuccessful && directorResponse.isSuccessful) {
                                                val intent = Intent(
                                                    this@MainActivity,
                                                    SecondActivity::class.java
                                                )
                                                intent.putExtra("dividenum", 2)
                                                intent.putExtra("actordata", data)
                                                intent.putExtra(
                                                    "countrydata",
                                                    countryResponse.body()
                                                )
                                                intent.putExtra(
                                                    "directordata",
                                                    directorResponse.body()
                                                )
                                                intent.putExtra("genredata", genreResponse.body())
                                                intent.putExtra("reviewdata", reviewResponse.body())
                                                intent.putExtra("quotesdata", quotesResponse.body())
                                                intent.putExtra(
                                                    "actorinfo",
                                                    actorinfoResponse.body()
                                                )
                                                startActivity(intent)
                                            } else {
                                                Log.i(
                                                    "MainActivty",
                                                    "initLayout: actorcountry failed "
                                                )
                                            }
                                        }
                                    }
                                }
                            binding.recyclerview.adapter = directorAdapter
                        } else {
                            Log.i("MainActivty", "initLayout:directorAdapter failed ")
                        }
                    }
                }
            }
            binding.genreButton.setOnClickListener {
                binding.searchButton.isEnabled = true
                binding.editTextTextPersonName.isEnabled = true

                binding.searchButton.setOnClickListener {

                    var genre = binding.editTextTextPersonName.text
                    CoroutineScope(Dispatchers.Main).launch {
                        var genreResponse: Response<GenreResponse>
                        withContext(Dispatchers.IO) {
                            genreResponse =
                                MovieServiceImp.movieInterface.postgenreRequest(Genre(genre.toString()))
                        }
                        if (genreResponse.isSuccessful) {
                            binding.recyclerview.layoutManager = LinearLayoutManager(
                                this@MainActivity, LinearLayoutManager.VERTICAL, false
                            )
                            genreAdapter = GenreAdapter(genreResponse.body()!!)
                            genreAdapter.itemClickListener =
                                object : GenreAdapter.OnItemClickListener {
                                    override fun OnItemClick(data: GenreResponseItem) {
                                        CoroutineScope(Dispatchers.Main).launch {
                                            var countryResponse: Response<ActorCountryResponse>
                                            var directorResponse: Response<ActorDirectorResponse>
                                            var genreResponse: Response<ActorGenreResponse>
                                            var reviewResponse: Response<ActorReviewResponse>
                                            var quotesResponse: Response<ActorQuotesResponse>
                                            var actorinfoResponse: Response<ActorinfoResponse>

                                            withContext(Dispatchers.IO) {
                                                countryResponse =
                                                    MovieServiceImp.movieInterface.actorcountryRequest(
                                                        ActorCountry(data.movie_id.toString())
                                                    )
                                                directorResponse =
                                                    MovieServiceImp.movieInterface.actordirectorRequset(
                                                        ActorDirector(data.movie_id.toString())
                                                    )
                                                genreResponse =
                                                    MovieServiceImp.movieInterface.actorgenreRequest(
                                                        ActorGenre(data.movie_id.toString())
                                                    )
                                                reviewResponse =
                                                    MovieServiceImp.movieInterface.actorreviewRequest(
                                                        ActorReview(data.movie_id.toString())
                                                    )
                                                quotesResponse =
                                                    MovieServiceImp.movieInterface.actorquotesRequest(
                                                        ActorQuotes(data.movie_id.toString())
                                                    )
                                                actorinfoResponse =
                                                    MovieServiceImp.movieInterface.actorinfoRequest(
                                                        ActorInfo(data.movie_id.toString())
                                                    )

                                            }
                                            if (countryResponse.isSuccessful && directorResponse.isSuccessful) {
                                                val intent = Intent(
                                                    this@MainActivity,
                                                    SecondActivity::class.java
                                                )
                                                intent.putExtra("dividenum", 4)
                                                intent.putExtra("actordata", data)
                                                intent.putExtra(
                                                    "countrydata",
                                                    countryResponse.body()
                                                )
                                                intent.putExtra(
                                                    "directordata",
                                                    directorResponse.body()
                                                )
                                                intent.putExtra("genredata", genreResponse.body())
                                                intent.putExtra("reviewdata", reviewResponse.body())
                                                intent.putExtra("quotesdata", quotesResponse.body())
                                                intent.putExtra(
                                                    "actorinfo",
                                                    actorinfoResponse.body()
                                                )
                                                startActivity(intent)
                                            } else {
                                                Log.i(
                                                    "MainActivty",
                                                    "initLayout: actorcountry failed "
                                                )
                                            }
                                        }
                                    }
                                }
                            binding.recyclerview.adapter = genreAdapter

                        } else {
                            Log.i("MainActivty", "initLayout: genreAdapter failed ")
                        }
                    }
                }
            }
            binding.titleButton.setOnClickListener {
                binding.searchButton.isEnabled = true
                binding.editTextTextPersonName.isEnabled = true


                binding.searchButton.setOnClickListener {
                    var title = binding.editTextTextPersonName.text
                    CoroutineScope(Dispatchers.Main).launch {
                        var titleResponse: Response<TitleResponse>
                        withContext(Dispatchers.IO) {
                            titleResponse =
                                MovieServiceImp.movieInterface.posttitleRequest(Title(title.toString()))
                        }

                        if (titleResponse.isSuccessful) {
                            binding.recyclerview.layoutManager = LinearLayoutManager(
                                this@MainActivity, LinearLayoutManager.VERTICAL, false
                            )
                            titleAdapter = TitleAdapter(titleResponse.body()!!)
                            titleAdapter.itemClickListener =
                                object : TitleAdapter.OnItemClickListener {
                                    override fun OnItemClick(data: TitleResponseItem) {
                                        CoroutineScope(Dispatchers.Main).launch {
                                            var countryResponse: Response<ActorCountryResponse>
                                            var directorResponse: Response<ActorDirectorResponse>
                                            var genreResponse: Response<ActorGenreResponse>
                                            var reviewResponse: Response<ActorReviewResponse>
                                            var quotesResponse: Response<ActorQuotesResponse>
                                            var actorinfoResponse: Response<ActorinfoResponse>

                                            withContext(Dispatchers.IO) {
                                                Log.i("sdsdsd", "sd1 :${data.movie_id} ")
                                                countryResponse =
                                                    MovieServiceImp.movieInterface.actorcountryRequest(
                                                        ActorCountry(data.movie_id.toString())
                                                    )
                                                directorResponse =
                                                    MovieServiceImp.movieInterface.actordirectorRequset(
                                                        ActorDirector(data.movie_id.toString())
                                                    )
                                                genreResponse =
                                                    MovieServiceImp.movieInterface.actorgenreRequest(
                                                        ActorGenre(data.movie_id.toString())
                                                    )
                                                reviewResponse =
                                                    MovieServiceImp.movieInterface.actorreviewRequest(
                                                        ActorReview(data.movie_id.toString())
                                                    )
                                                quotesResponse =
                                                    MovieServiceImp.movieInterface.actorquotesRequest(
                                                        ActorQuotes(data.movie_id.toString())
                                                    )
                                                actorinfoResponse =
                                                    MovieServiceImp.movieInterface.actorinfoRequest(
                                                        ActorInfo(data.movie_id.toString())
                                                    )

                                            }
                                            if (countryResponse.isSuccessful && directorResponse.isSuccessful) {
                                                val intent = Intent(
                                                    this@MainActivity,
                                                    SecondActivity::class.java
                                                )
                                                intent.putExtra("dividenum", 4)
                                                intent.putExtra("actordata", data)
                                                intent.putExtra(
                                                    "countrydata",
                                                    countryResponse.body()
                                                )
                                                intent.putExtra(
                                                    "directordata",
                                                    directorResponse.body()
                                                )
                                                intent.putExtra("genredata", genreResponse.body())
                                                intent.putExtra("reviewdata", reviewResponse.body())
                                                intent.putExtra("quotesdata", quotesResponse.body())
                                                intent.putExtra(
                                                    "actorinfo",
                                                    actorinfoResponse.body()
                                                )
                                                startActivity(intent)
                                            } else {
                                                Log.i(
                                                    "MainActivty",
                                                    "initLayout: actorcountry failed "
                                                )
                                            }
                                        }
                                    }
                                }
                            binding.recyclerview.adapter = titleAdapter
                        } else {
                            Log.i("MainActivty", "initLayout: ActorAdapter failed ")
                        }
                    }
                }
            }
        }
        binding.openingsort.setOnClickListener {
            binding.actorButton.isEnabled = true
            binding.directorButton.isEnabled = true
            binding.countryButton.isEnabled = true
            binding.genreButton.isEnabled = true
            binding.titleButton.isEnabled = true

            binding.actorButton.setOnClickListener {
                binding.searchButton.isEnabled = true
                binding.editTextTextPersonName.isEnabled = true


                binding.searchButton.setOnClickListener {
                    var actor = binding.editTextTextPersonName.text
                    CoroutineScope(Dispatchers.Main).launch {
                        var actorResponse: Response<ActorResponse>
                        withContext(Dispatchers.IO) {
                            actorResponse =
                                MovieServiceImp.movieInterface.postOpeningAcotrRequest(Actor(actor.toString()))
                        }

                        if (actorResponse.isSuccessful) {
                            binding.recyclerview.layoutManager = LinearLayoutManager(
                                this@MainActivity, LinearLayoutManager.VERTICAL, false
                            )
                            openingactorAdapter = ActorAdapter(actorResponse.body()!!)
                            openingactorAdapter.itemClickListener =
                                object : ActorAdapter.OnItemClickListener {
                                    override fun OnItemClick(data: ActorResponseItem) {
                                        CoroutineScope(Dispatchers.Main).launch {
                                            var countryResponse: Response<ActorCountryResponse>
                                            var directorResponse: Response<ActorDirectorResponse>
                                            var genreResponse: Response<ActorGenreResponse>
                                            var reviewResponse: Response<ActorReviewResponse>
                                            var quotesResponse: Response<ActorQuotesResponse>
                                            var actorinfoResponse: Response<ActorinfoResponse>

                                            withContext(Dispatchers.IO) {
                                                countryResponse =
                                                    MovieServiceImp.movieInterface.actorcountryRequest(
                                                        ActorCountry(data.movie_id.toString())
                                                    )
                                                directorResponse =
                                                    MovieServiceImp.movieInterface.actordirectorRequset(
                                                        ActorDirector(data.movie_id.toString())
                                                    )
                                                genreResponse =
                                                    MovieServiceImp.movieInterface.actorgenreRequest(
                                                        ActorGenre(data.movie_id.toString())
                                                    )
                                                reviewResponse =
                                                    MovieServiceImp.movieInterface.actorreviewRequest(
                                                        ActorReview(data.movie_id.toString())
                                                    )
                                                quotesResponse =
                                                    MovieServiceImp.movieInterface.actorquotesRequest(
                                                        ActorQuotes(data.movie_id.toString())
                                                    )
                                                actorinfoResponse =
                                                    MovieServiceImp.movieInterface.actorinfoRequest(
                                                        ActorInfo(data.movie_id.toString())
                                                    )

                                            }
                                            if (countryResponse.isSuccessful && directorResponse.isSuccessful) {
                                                val intent = Intent(
                                                    this@MainActivity,
                                                    SecondActivity::class.java
                                                )
                                                intent.putExtra("dividenum", 1)
                                                intent.putExtra("actordata", data)
                                                intent.putExtra(
                                                    "countrydata",
                                                    countryResponse.body()
                                                )
                                                intent.putExtra(
                                                    "directordata",
                                                    directorResponse.body()
                                                )
                                                intent.putExtra("genredata", genreResponse.body())
                                                intent.putExtra("reviewdata", reviewResponse.body())
                                                intent.putExtra("quotesdata", quotesResponse.body())
                                                intent.putExtra(
                                                    "actorinfo",
                                                    actorinfoResponse.body()
                                                )
                                                startActivity(intent)
                                            } else {
                                                Log.i(
                                                    "MainActivty",
                                                    "initLayout: actorcountry failed "
                                                )
                                            }
                                        }
                                    }
                                }
                            binding.recyclerview.adapter = openingactorAdapter
                        } else {
                            Log.i("MainActivty", "initLayout: ActorAdapter failed ")
                        }
                    }
                }
            }

            binding.countryButton.setOnClickListener {
                binding.searchButton.isEnabled = true
                binding.editTextTextPersonName.isEnabled = true


                binding.searchButton.setOnClickListener {
                    var country = binding.editTextTextPersonName.text
                    CoroutineScope(Dispatchers.Main).launch {
                        var movieResponse: Response<MovieResponse>
                        withContext(Dispatchers.IO) {
                            movieResponse =
                                MovieServiceImp.movieInterface.postOpeningCountryRequest(Country(country.toString()))
                        }
                        if (movieResponse.isSuccessful) {
                            binding.recyclerview.layoutManager = LinearLayoutManager(
                                this@MainActivity, LinearLayoutManager.VERTICAL, false
                            )
                            openingCountryAdapter = MyAdapter(movieResponse.body()!!)
                            openingCountryAdapter.itemClickListener = object : MyAdapter.OnItemClickListener {
                                override fun OnItemClick(data: MovieResponseItem) {
                                    CoroutineScope(Dispatchers.Main).launch {
                                        var countryResponse: Response<ActorCountryResponse>
                                        var directorResponse: Response<ActorDirectorResponse>
                                        var genreResponse: Response<ActorGenreResponse>
                                        var reviewResponse: Response<ActorReviewResponse>
                                        var quotesResponse: Response<ActorQuotesResponse>
                                        var actorinfoResponse: Response<ActorinfoResponse>

                                        withContext(Dispatchers.IO) {
                                            countryResponse =
                                                MovieServiceImp.movieInterface.actorcountryRequest(
                                                    ActorCountry(data.movie_id.toString())
                                                )
                                            directorResponse =
                                                MovieServiceImp.movieInterface.actordirectorRequset(
                                                    ActorDirector(data.movie_id.toString())
                                                )
                                            genreResponse =
                                                MovieServiceImp.movieInterface.actorgenreRequest(
                                                    ActorGenre(data.movie_id.toString())
                                                )
                                            reviewResponse =
                                                MovieServiceImp.movieInterface.actorreviewRequest(
                                                    ActorReview(data.movie_id.toString())
                                                )
                                            quotesResponse =
                                                MovieServiceImp.movieInterface.actorquotesRequest(
                                                    ActorQuotes(data.movie_id.toString())
                                                )
                                            actorinfoResponse =
                                                MovieServiceImp.movieInterface.actorinfoRequest(
                                                    ActorInfo(data.movie_id.toString())
                                                )
                                        }
                                        if (countryResponse.isSuccessful && directorResponse.isSuccessful) {
                                            val intent = Intent(
                                                this@MainActivity,
                                                SecondActivity::class.java
                                            )
                                            intent.putExtra("dividenum", 3)
                                            intent.putExtra("actordata", data)
                                            intent.putExtra("countrydata", countryResponse.body())
                                            intent.putExtra("directordata", directorResponse.body())
                                            intent.putExtra("genredata", genreResponse.body())
                                            intent.putExtra("reviewdata", reviewResponse.body())
                                            intent.putExtra("quotesdata", quotesResponse.body())
                                            intent.putExtra("actorinfo", actorinfoResponse.body())
                                            startActivity(intent)
                                        } else {
                                            Log.i("MainActivty", "initLayout: actorcountry failed ")
                                        }
                                    }
                                }

                            }

                            binding.recyclerview.adapter = openingCountryAdapter

                        } else {
                            Log.i("MainActivty", "initLayout: country failed ")
                        }
                    }
                }
            }


            binding.directorButton.setOnClickListener {
                binding.searchButton.isEnabled = true
                binding.editTextTextPersonName.isEnabled = true

                binding.searchButton.setOnClickListener {

                    var director = binding.editTextTextPersonName.text
                    CoroutineScope(Dispatchers.Main).launch {
                        var directorResponse: Response<DirectorResponse>
                        withContext(Dispatchers.IO) {
                            directorResponse =
                                MovieServiceImp.movieInterface.postOpeningDirectorRequest(Director(director.toString()))
                        }
                        if (directorResponse.isSuccessful) {
                            binding.recyclerview.layoutManager = LinearLayoutManager(
                                this@MainActivity, LinearLayoutManager.VERTICAL, false
                            )
                            openingdirectorAdapter = DirectorAdapter(directorResponse.body()!!)
                            openingdirectorAdapter.itemClickListener =
                                object : DirectorAdapter.OnItemClickListener {
                                    override fun OnItemClick(data: DirectorResponseItem) {
                                        CoroutineScope(Dispatchers.Main).launch {
                                            var countryResponse: Response<ActorCountryResponse>
                                            var directorResponse: Response<ActorDirectorResponse>
                                            var genreResponse: Response<ActorGenreResponse>
                                            var reviewResponse: Response<ActorReviewResponse>
                                            var quotesResponse: Response<ActorQuotesResponse>
                                            var actorinfoResponse: Response<ActorinfoResponse>

                                            withContext(Dispatchers.IO) {
                                                Log.i("sdsdsd", "sd1 :${data.movie_id} ")
                                                countryResponse =
                                                    MovieServiceImp.movieInterface.actorcountryRequest(
                                                        ActorCountry(data.movie_id.toString())
                                                    )
                                                directorResponse =
                                                    MovieServiceImp.movieInterface.actordirectorRequset(
                                                        ActorDirector(data.movie_id.toString())
                                                    )
                                                genreResponse =
                                                    MovieServiceImp.movieInterface.actorgenreRequest(
                                                        ActorGenre(data.movie_id.toString())
                                                    )
                                                reviewResponse =
                                                    MovieServiceImp.movieInterface.actorreviewRequest(
                                                        ActorReview(data.movie_id.toString())
                                                    )
                                                quotesResponse =
                                                    MovieServiceImp.movieInterface.actorquotesRequest(
                                                        ActorQuotes(data.movie_id.toString())
                                                    )
                                                actorinfoResponse =
                                                    MovieServiceImp.movieInterface.actorinfoRequest(
                                                        ActorInfo(data.movie_id.toString())
                                                    )

                                            }
                                            if (countryResponse.isSuccessful && directorResponse.isSuccessful) {
                                                val intent = Intent(
                                                    this@MainActivity,
                                                    SecondActivity::class.java
                                                )
                                                intent.putExtra("dividenum", 2)
                                                intent.putExtra("actordata", data)
                                                intent.putExtra(
                                                    "countrydata",
                                                    countryResponse.body()
                                                )
                                                intent.putExtra(
                                                    "directordata",
                                                    directorResponse.body()
                                                )
                                                intent.putExtra("genredata", genreResponse.body())
                                                intent.putExtra("reviewdata", reviewResponse.body())
                                                intent.putExtra("quotesdata", quotesResponse.body())
                                                intent.putExtra(
                                                    "actorinfo",
                                                    actorinfoResponse.body()
                                                )
                                                startActivity(intent)
                                            } else {
                                                Log.i(
                                                    "MainActivty",
                                                    "initLayout: actorcountry failed "
                                                )
                                            }
                                        }
                                    }
                                }
                            binding.recyclerview.adapter = openingdirectorAdapter
                        } else {
                            Log.i("MainActivty", "initLayout:directorAdapter failed ")
                        }
                    }
                }
            }
            binding.genreButton.setOnClickListener {
                binding.searchButton.isEnabled = true
                binding.editTextTextPersonName.isEnabled = true

                binding.searchButton.setOnClickListener {

                    var genre = binding.editTextTextPersonName.text
                    CoroutineScope(Dispatchers.Main).launch {
                        var genreResponse: Response<GenreResponse>
                        withContext(Dispatchers.IO) {
                            genreResponse =
                                MovieServiceImp.movieInterface.postOpeninggenreRequest(Genre(genre.toString()))
                        }
                        if (genreResponse.isSuccessful) {
                            binding.recyclerview.layoutManager = LinearLayoutManager(
                                this@MainActivity, LinearLayoutManager.VERTICAL, false
                            )
                            openinggenreAdapter = GenreAdapter(genreResponse.body()!!)
                            openinggenreAdapter.itemClickListener =
                                object : GenreAdapter.OnItemClickListener {
                                    override fun OnItemClick(data: GenreResponseItem) {
                                        CoroutineScope(Dispatchers.Main).launch {
                                            var countryResponse: Response<ActorCountryResponse>
                                            var directorResponse: Response<ActorDirectorResponse>
                                            var genreResponse: Response<ActorGenreResponse>
                                            var reviewResponse: Response<ActorReviewResponse>
                                            var quotesResponse: Response<ActorQuotesResponse>
                                            var actorinfoResponse: Response<ActorinfoResponse>

                                            withContext(Dispatchers.IO) {
                                                countryResponse =
                                                    MovieServiceImp.movieInterface.actorcountryRequest(
                                                        ActorCountry(data.movie_id.toString())
                                                    )
                                                directorResponse =
                                                    MovieServiceImp.movieInterface.actordirectorRequset(
                                                        ActorDirector(data.movie_id.toString())
                                                    )
                                                genreResponse =
                                                    MovieServiceImp.movieInterface.actorgenreRequest(
                                                        ActorGenre(data.movie_id.toString())
                                                    )
                                                reviewResponse =
                                                    MovieServiceImp.movieInterface.actorreviewRequest(
                                                        ActorReview(data.movie_id.toString())
                                                    )
                                                quotesResponse =
                                                    MovieServiceImp.movieInterface.actorquotesRequest(
                                                        ActorQuotes(data.movie_id.toString())
                                                    )
                                                actorinfoResponse =
                                                    MovieServiceImp.movieInterface.actorinfoRequest(
                                                        ActorInfo(data.movie_id.toString())
                                                    )

                                            }
                                            if (countryResponse.isSuccessful && directorResponse.isSuccessful) {
                                                val intent = Intent(
                                                    this@MainActivity,
                                                    SecondActivity::class.java
                                                )
                                                intent.putExtra("dividenum", 4)
                                                intent.putExtra("actordata", data)
                                                intent.putExtra(
                                                    "countrydata",
                                                    countryResponse.body()
                                                )
                                                intent.putExtra(
                                                    "directordata",
                                                    directorResponse.body()
                                                )
                                                intent.putExtra("genredata", genreResponse.body())
                                                intent.putExtra("reviewdata", reviewResponse.body())
                                                intent.putExtra("quotesdata", quotesResponse.body())
                                                intent.putExtra(
                                                    "actorinfo",
                                                    actorinfoResponse.body()
                                                )
                                                startActivity(intent)
                                            } else {
                                                Log.i(
                                                    "MainActivty",
                                                    "initLayout: actorcountry failed "
                                                )
                                            }
                                        }
                                    }
                                }
                            binding.recyclerview.adapter = openinggenreAdapter

                        } else {
                            Log.i("MainActivty", "initLayout: genreAdapter failed ")
                        }
                    }
                }
            }
            binding.titleButton.setOnClickListener {
                binding.searchButton.isEnabled = true
                binding.editTextTextPersonName.isEnabled = true


                binding.searchButton.setOnClickListener {
                    var title = binding.editTextTextPersonName.text
                    CoroutineScope(Dispatchers.Main).launch {
                        var titleResponse: Response<TitleResponse>
                        withContext(Dispatchers.IO) {
                            titleResponse =
                                MovieServiceImp.movieInterface.postOpeningtitleRequest(Title(title.toString()))
                        }

                        if (titleResponse.isSuccessful) {
                            binding.recyclerview.layoutManager = LinearLayoutManager(
                                this@MainActivity, LinearLayoutManager.VERTICAL, false
                            )
                            openingtitleAdapter = TitleAdapter(titleResponse.body()!!)
                            openingtitleAdapter.itemClickListener =
                                object : TitleAdapter.OnItemClickListener {
                                    override fun OnItemClick(data: TitleResponseItem) {
                                        CoroutineScope(Dispatchers.Main).launch {
                                            var countryResponse: Response<ActorCountryResponse>
                                            var directorResponse: Response<ActorDirectorResponse>
                                            var genreResponse: Response<ActorGenreResponse>
                                            var reviewResponse: Response<ActorReviewResponse>
                                            var quotesResponse: Response<ActorQuotesResponse>
                                            var actorinfoResponse: Response<ActorinfoResponse>

                                            withContext(Dispatchers.IO) {
                                                Log.i("sdsdsd", "sd1 :${data.movie_id} ")
                                                countryResponse =
                                                    MovieServiceImp.movieInterface.actorcountryRequest(
                                                        ActorCountry(data.movie_id.toString())
                                                    )
                                                directorResponse =
                                                    MovieServiceImp.movieInterface.actordirectorRequset(
                                                        ActorDirector(data.movie_id.toString())
                                                    )
                                                genreResponse =
                                                    MovieServiceImp.movieInterface.actorgenreRequest(
                                                        ActorGenre(data.movie_id.toString())
                                                    )
                                                reviewResponse =
                                                    MovieServiceImp.movieInterface.actorreviewRequest(
                                                        ActorReview(data.movie_id.toString())
                                                    )
                                                quotesResponse =
                                                    MovieServiceImp.movieInterface.actorquotesRequest(
                                                        ActorQuotes(data.movie_id.toString())
                                                    )
                                                actorinfoResponse =
                                                    MovieServiceImp.movieInterface.actorinfoRequest(
                                                        ActorInfo(data.movie_id.toString())
                                                    )

                                            }
                                            if (countryResponse.isSuccessful && directorResponse.isSuccessful) {
                                                val intent = Intent(
                                                    this@MainActivity,
                                                    SecondActivity::class.java
                                                )
                                                intent.putExtra("dividenum", 4)
                                                intent.putExtra("actordata", data)
                                                intent.putExtra(
                                                    "countrydata",
                                                    countryResponse.body()
                                                )
                                                intent.putExtra(
                                                    "directordata",
                                                    directorResponse.body()
                                                )
                                                intent.putExtra("genredata", genreResponse.body())
                                                intent.putExtra("reviewdata", reviewResponse.body())
                                                intent.putExtra("quotesdata", quotesResponse.body())
                                                intent.putExtra(
                                                    "actorinfo",
                                                    actorinfoResponse.body()
                                                )
                                                startActivity(intent)
                                            } else {
                                                Log.i(
                                                    "MainActivty",
                                                    "initLayout: actorcountry failed "
                                                )
                                            }
                                        }
                                    }
                                }
                            binding.recyclerview.adapter = openingtitleAdapter
                        } else {
                            Log.i("MainActivty", "initLayout: ActorAdapter failed ")
                        }
                    }
                }
            }


        }
    }
}


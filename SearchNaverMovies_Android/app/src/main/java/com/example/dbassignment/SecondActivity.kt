package com.example.dbassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbassignment.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding:ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
    }


    private fun initLayout() {


        val info = intent
        var dividenum = info.getIntExtra("dividenum",0)
        if(dividenum ==1){
            val movieinfo = info.getSerializableExtra("actordata") as? ActorResponseItem
            val countryinfo = info.getSerializableExtra("countrydata") as? ArrayList<ActorCountryResponseItem>
            val directorinfo = info.getSerializableExtra("directordata") as? ArrayList<ActorDirectorResponseItem>
            val genreinfo = info.getSerializableExtra("genredata") as? ArrayList<ActorGenreResponseItem>
            val reviewinfo = info.getSerializableExtra("reviewdata") as? ArrayList<ActorReviewResponseItem>
            val quotesinfo = info.getSerializableExtra("quotesdata") as? ArrayList<ActorQuotesResponseItem>
            val actorinfo = info.getSerializableExtra("actorinfo") as? ArrayList<ActorinfoResponseItem>
            var actorArray:ArrayList<ActorForSecond> = arrayListOf()
            var strgenre = ""
            var strcountry=""
            var strdirector=""
            var strreview=""
            var strquotes=""


            if(actorinfo!!.isNotEmpty()){
                for(i in 0 until actorinfo!!.size){
                    actorArray.add(ActorForSecond(actorinfo[i].actor_name,actorinfo[i].actor_image,actorinfo[i].actor_role))
                }
            }

            if(genreinfo!!.isNotEmpty()){
                for(i in 0 until genreinfo!!.size ){
                    strgenre += genreinfo[i].content + " "
                }
            }else{
                strgenre = "null"
            }
            if(countryinfo!!.isNotEmpty()){
                for(i in 0 until countryinfo!!.size){
                    strcountry +=countryinfo[i].country_name+" "
                }
            }else{
                strcountry ="null"
            }

            if(directorinfo!!.isNotEmpty()){
                for(i in 0 until directorinfo!!.size){
                    strdirector +=directorinfo[i].director_name+" "
                }
            }else{
                strdirector ="null"
            }
            if(reviewinfo!!.isNotEmpty()){
                for(i in 0 until reviewinfo!!.size){
                    strreview +=reviewinfo[i].review_main+" "
                }
            }else{
                strreview ="null"
            }



            if(quotesinfo!!.isNotEmpty()){
                for(i in 0 until quotesinfo!!.size){
                    strquotes +=quotesinfo[i].quotes_content+"\n"
                }
            }else{
                strquotes ="null"
            }

            binding.apply {
                movieTitle.text = movieinfo!!.movie_title                                          //영화제목
                openingDateText.text = "개봉년도:"+movieinfo!!.opening_date                                    //개봉년도
                playingTimeText.text = "러닝타임:"+movieinfo!!.playing_time.toString() +"분"                   //러닝타임
                netizenRate.text = "네티즌 평점 : " + movieinfo.netizen_evaluation.toString()      //관람객 평점
                netizenCount.text = movieinfo.netizen_count.toString()+"명"                       //관람객 평점 수
                jourRate.text = "기자 평점 : " + movieinfo.journal_evaluation                      //기자 평점
                jourCount.text = movieinfo.journal_count.toString() +"명"                         //기자 평점 수
                audienceRate.text ="관람객 평점 : " +  movieinfo.watcher_evaluation.toString()      //네티즌 평점
                audienceCount.text = movieinfo.watcher_count.toString() +"명"                     //네티즌 평점 수
                totalAudienceText.text = "총 관람객 "+ movieinfo.totalaudience+"명"                             //총 관람객
                countryText.text = "국가:"+strcountry                                  //국가
                DirectorText.text = "감독:"+ strdirector                                 //감독
                genreText.text = "장르:"+strgenre
                if (strreview.length>=50){
                    reviewText.text = "${strreview.substring(0,50)} ..."
                }else{
                    reviewText.text = strreview
                }
                if(strquotes.length>=50){
                    lineText.text = "${strquotes.substring(0,50)}..."
                }else{
                    lineText.text = strquotes
                }

                secondRecyclerView.layoutManager = LinearLayoutManager(
                    this@SecondActivity, LinearLayoutManager.VERTICAL, false
                )
                val adapter:SecondAdapter = SecondAdapter(actorArray)
                secondRecyclerView.adapter = adapter

            }



        }
        if(dividenum ==2){
            val movieinfo = info.getSerializableExtra("actordata") as? DirectorResponseItem
            val countryinfo = info.getSerializableExtra("countrydata") as? ArrayList<ActorCountryResponseItem>
            val directorinfo = info.getSerializableExtra("directordata") as? ArrayList<ActorDirectorResponseItem>
            val genreinfo = info.getSerializableExtra("genredata") as? ArrayList<ActorGenreResponseItem>
            val reviewinfo = info.getSerializableExtra("reviewdata") as? ArrayList<ActorReviewResponseItem>
            val quotesinfo = info.getSerializableExtra("quotesdata") as? ArrayList<ActorQuotesResponseItem>
            val actorinfo = info.getSerializableExtra("actorinfo") as? ArrayList<ActorinfoResponseItem>
            var actorArray:ArrayList<ActorForSecond> = arrayListOf()
            var strgenre = ""
            var strcountry=""
            var strdirector=""
            var strreview=""
            var strquotes=""

            if(actorinfo!!.isNotEmpty()){
                for(i in 0 until actorinfo!!.size){
                    actorArray.add(ActorForSecond(actorinfo[i].actor_name,actorinfo[i].actor_image,actorinfo[i].actor_role))
                }
            }

            if(genreinfo!!.isNotEmpty()){
                for(i in 0 until genreinfo!!.size ){
                    strgenre += genreinfo[i].content + " "
                }
            }else{
                strgenre = "null"
            }
            if(countryinfo!!.isNotEmpty()){
                for(i in 0 until countryinfo!!.size){
                    strcountry +=countryinfo[i].country_name+" "
                }
            }else{
                strcountry ="null"
            }

            if(directorinfo!!.isNotEmpty()){
                for(i in 0 until directorinfo!!.size){
                    strdirector +=directorinfo[i].director_name+" "
                }
            }else{
                strdirector ="null"
            }
            if(reviewinfo!!.isNotEmpty()){
                for(i in 0 until reviewinfo!!.size){
                    strreview +=reviewinfo[i].review_main+" "
                }
            }else{
                strreview ="null"
            }



            if(quotesinfo!!.isNotEmpty()){
                for(i in 0 until quotesinfo!!.size){
                    strquotes +=quotesinfo[i].quotes_content+" "
                }
            }else{
                strquotes ="null"
            }
            binding.apply {
                movieTitle.text = movieinfo!!.movie_title                                          //영화제목
                openingDateText.text = "개봉년도:"+movieinfo!!.opening_date                                    //개봉년도
                playingTimeText.text = "러닝타임:"+movieinfo!!.playing_time.toString() +"분"                   //러닝타임
                netizenRate.text = "네티즌 평점 : " + movieinfo.netizen_evaluation.toString()      //관람객 평점
                netizenCount.text = movieinfo.netizen_count.toString()+"명"                       //관람객 평점 수
                jourRate.text = "기자 평점 : " + movieinfo.journal_evaluation                      //기자 평점
                jourCount.text = movieinfo.journal_count.toString() +"명"                         //기자 평점 수
                audienceRate.text ="관람객 평점 : " +  movieinfo.watcher_evaluation.toString()      //네티즌 평점
                audienceCount.text = movieinfo.watcher_count.toString() +"명"                     //네티즌 평점 수
                totalAudienceText.text = "총 관람객 "+ movieinfo.totalaudience+"명"                             //총 관람객
                countryText.text = "국가:"+strcountry                                  //국가
                DirectorText.text = "감독:"+ strdirector                                 //감독
                genreText.text = "장르:"+strgenre
                if (strreview.length>=50){
                    reviewText.text = "${strreview.substring(0,50)} ..."
                }else{
                    reviewText.text = strreview
                }
                if(strquotes.length>=50){
                    lineText.text = "${strquotes.substring(0,50)}..."
                }else{
                    lineText.text = strquotes
                }

                secondRecyclerView.layoutManager = LinearLayoutManager(
                    this@SecondActivity, LinearLayoutManager.VERTICAL, false
                )
                val adapter:SecondAdapter = SecondAdapter(actorArray)
                secondRecyclerView.adapter = adapter
            }
        }
        if(dividenum ==3){
            val movieinfo = info.getSerializableExtra("actordata") as? MovieResponseItem
            val countryinfo = info.getSerializableExtra("countrydata") as? ArrayList<ActorCountryResponseItem>
            val directorinfo = info.getSerializableExtra("directordata") as? ArrayList<ActorDirectorResponseItem>
            val genreinfo = info.getSerializableExtra("genredata") as? ArrayList<ActorGenreResponseItem>
            val reviewinfo = info.getSerializableExtra("reviewdata") as? ArrayList<ActorReviewResponseItem>
            val quotesinfo = info.getSerializableExtra("quotesdata") as? ArrayList<ActorQuotesResponseItem>
            val actorinfo = info.getSerializableExtra("actorinfo") as? ArrayList<ActorinfoResponseItem>
            var actorArray:ArrayList<ActorForSecond> = arrayListOf()
            var strgenre = ""
            var strcountry=""
            var strdirector=""
            var strreview=""
            var strquotes=""

            if(actorinfo!!.isNotEmpty()){
                for(i in 0 until actorinfo!!.size){
                    actorArray.add(ActorForSecond(actorinfo[i].actor_name,actorinfo[i].actor_image,actorinfo[i].actor_role))
                }
            }

            if(genreinfo!!.isNotEmpty()){
                for(i in 0 until genreinfo!!.size ){
                    strgenre += genreinfo[i].content + " "
                }
            }else{
                strgenre = "null"
            }
            if(countryinfo!!.isNotEmpty()){
                for(i in 0 until countryinfo!!.size){
                    strcountry +=countryinfo[i].country_name+" "
                }
            }else{
                strcountry ="null"
            }

            if(directorinfo!!.isNotEmpty()){
                for(i in 0 until directorinfo!!.size){
                    strdirector +=directorinfo[i].director_name+" "
                }
            }else{
                strdirector ="null"
            }
            if(reviewinfo!!.isNotEmpty()){
                for(i in 0 until reviewinfo!!.size){
                    strreview +=reviewinfo[i].review_main+" "
                }
            }else{
                strreview ="null"
            }



            if(quotesinfo!!.isNotEmpty()){
                for(i in 0 until quotesinfo!!.size){
                    strquotes +=quotesinfo[i].quotes_content+" "
                }
            }else{
                strquotes ="null"
            }
            binding.apply {
                movieTitle.text = movieinfo!!.movie_title                                          //영화제목
                openingDateText.text = "개봉년도:"+movieinfo!!.opening_date                                    //개봉년도
                playingTimeText.text = "러닝타임:"+movieinfo!!.playing_time.toString() +"분"                   //러닝타임
                netizenRate.text = "네티즌 평점 : " + movieinfo.netizen_evaluation.toString()      //관람객 평점
                netizenCount.text = movieinfo.netizen_count.toString()+"명"                       //관람객 평점 수
                jourRate.text = "기자 평점 : " + movieinfo.journal_evaluation                      //기자 평점
                jourCount.text = movieinfo.journal_count.toString() +"명"                         //기자 평점 수
                audienceRate.text ="관람객 평점 : " +  movieinfo.watcher_evaluation.toString()      //네티즌 평점
                audienceCount.text = movieinfo.watcher_count.toString() +"명"                     //네티즌 평점 수
                totalAudienceText.text = "총 관람객 "+ movieinfo.totalaudience+"명"                             //총 관람객
                countryText.text = "국가:"+strcountry                                  //국가
                DirectorText.text = "감독:"+ strdirector                                 //감독
                genreText.text = "장르:"+strgenre
                if (strreview.length>=50){
                    reviewText.text = "${strreview.substring(0,50)} ..."
                }else{
                    reviewText.text = strreview
                }
                if(strquotes.length>=50){
                    lineText.text = "${strquotes.substring(0,50)}..."
                }else{
                    lineText.text = strquotes
                }

                secondRecyclerView.layoutManager = LinearLayoutManager(
                    this@SecondActivity, LinearLayoutManager.VERTICAL, false
                )
                val adapter:SecondAdapter = SecondAdapter(actorArray)
                secondRecyclerView.adapter = adapter
            }
        }
        if(dividenum ==4){
            val movieinfo = info.getSerializableExtra("actordata") as? TitleResponseItem
            val countryinfo = info.getSerializableExtra("countrydata") as? ArrayList<ActorCountryResponseItem>
            val directorinfo = info.getSerializableExtra("directordata") as? ArrayList<ActorDirectorResponseItem>
            val genreinfo = info.getSerializableExtra("genredata") as? ArrayList<ActorGenreResponseItem>
            val reviewinfo = info.getSerializableExtra("reviewdata") as? ArrayList<ActorReviewResponseItem>
            val quotesinfo = info.getSerializableExtra("quotesdata") as? ArrayList<ActorQuotesResponseItem>
            val actorinfo = info.getSerializableExtra("actorinfo") as? ArrayList<ActorinfoResponseItem>
            var actorArray:ArrayList<ActorForSecond> = arrayListOf()
            var strgenre = ""
            var strcountry=""
            var strdirector=""
            var strreview=""
            var strquotes=""

            if(actorinfo!!.isNotEmpty()){
                for(i in 0 until actorinfo!!.size){
                    actorArray.add(ActorForSecond(actorinfo[i].actor_name,actorinfo[i].actor_image,actorinfo[i].actor_role))
                }
            }

            if(genreinfo!!.isNotEmpty()){
                for(i in 0 until genreinfo!!.size ){
                    strgenre += genreinfo[i].content + " "
                }
            }else{
                strgenre = "null"
            }
            if(countryinfo!!.isNotEmpty()){
                for(i in 0 until countryinfo!!.size){
                    strcountry +=countryinfo[i].country_name+" "
                }
            }else{
                strcountry ="null"
            }

            if(directorinfo!!.isNotEmpty()){
                for(i in 0 until directorinfo!!.size){
                    strdirector +=directorinfo[i].director_name+" "
                }
            }else{
                strdirector ="null"
            }
            if(reviewinfo!!.isNotEmpty()){
                for(i in 0 until reviewinfo!!.size){
                    strreview +=reviewinfo[i].review_main+" "
                }
            }else{
                strreview ="null"
            }



            if(quotesinfo!!.isNotEmpty()){
                for(i in 0 until quotesinfo!!.size){
                    strquotes +=quotesinfo[i].quotes_content+" "
                }
            }else{
                strquotes ="null"
            }

            binding.apply {
                movieTitle.text = movieinfo!!.movie_title                                          //영화제목
                openingDateText.text = "개봉년도:"+movieinfo!!.opening_date                                    //개봉년도
                playingTimeText.text = "러닝타임:"+movieinfo!!.playing_time.toString() +"분"                   //러닝타임
                netizenRate.text = "네티즌 평점 : " + movieinfo.netizen_evaluation.toString()      //관람객 평점
                netizenCount.text = movieinfo.netizen_count.toString()+"명"                       //관람객 평점 수
                jourRate.text = "기자 평점 : " + movieinfo.journal_evaluation                      //기자 평점
                jourCount.text = movieinfo.journal_count.toString() +"명"                         //기자 평점 수
                audienceRate.text ="관람객 평점 : " +  movieinfo.watcher_evaluation.toString()      //네티즌 평점
                audienceCount.text = movieinfo.watcher_count.toString() +"명"                     //네티즌 평점 수
                totalAudienceText.text = "총 관람객 "+ movieinfo.totalaudience+"명"                             //총 관람객
                countryText.text = "국가:"+strcountry                                  //국가
                DirectorText.text = "감독:"+ strdirector                                 //감독
                genreText.text = "장르:"+strgenre
                if (strreview.length>=50){
                    reviewText.text = "${strreview.substring(0,50)} ..."
                }else{
                    reviewText.text = strreview
                }
                if(strquotes.length>=50){
                    lineText.text = "${strquotes.substring(0,50)}..."
                }else{
                    lineText.text = strquotes
                }

                secondRecyclerView.layoutManager = LinearLayoutManager(
                    this@SecondActivity, LinearLayoutManager.VERTICAL, false
                )
                val adapter:SecondAdapter = SecondAdapter(actorArray)
                secondRecyclerView.adapter = adapter
            }
        }
    }
}
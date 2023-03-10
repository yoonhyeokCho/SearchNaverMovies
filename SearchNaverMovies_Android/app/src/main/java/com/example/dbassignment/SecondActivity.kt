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
                movieTitle.text = movieinfo!!.movie_title                                          //????????????
                openingDateText.text = "????????????:"+movieinfo!!.opening_date                                    //????????????
                playingTimeText.text = "????????????:"+movieinfo!!.playing_time.toString() +"???"                   //????????????
                netizenRate.text = "????????? ?????? : " + movieinfo.netizen_evaluation.toString()      //????????? ??????
                netizenCount.text = movieinfo.netizen_count.toString()+"???"                       //????????? ?????? ???
                jourRate.text = "?????? ?????? : " + movieinfo.journal_evaluation                      //?????? ??????
                jourCount.text = movieinfo.journal_count.toString() +"???"                         //?????? ?????? ???
                audienceRate.text ="????????? ?????? : " +  movieinfo.watcher_evaluation.toString()      //????????? ??????
                audienceCount.text = movieinfo.watcher_count.toString() +"???"                     //????????? ?????? ???
                totalAudienceText.text = "??? ????????? "+ movieinfo.totalaudience+"???"                             //??? ?????????
                countryText.text = "??????:"+strcountry                                  //??????
                DirectorText.text = "??????:"+ strdirector                                 //??????
                genreText.text = "??????:"+strgenre
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
                movieTitle.text = movieinfo!!.movie_title                                          //????????????
                openingDateText.text = "????????????:"+movieinfo!!.opening_date                                    //????????????
                playingTimeText.text = "????????????:"+movieinfo!!.playing_time.toString() +"???"                   //????????????
                netizenRate.text = "????????? ?????? : " + movieinfo.netizen_evaluation.toString()      //????????? ??????
                netizenCount.text = movieinfo.netizen_count.toString()+"???"                       //????????? ?????? ???
                jourRate.text = "?????? ?????? : " + movieinfo.journal_evaluation                      //?????? ??????
                jourCount.text = movieinfo.journal_count.toString() +"???"                         //?????? ?????? ???
                audienceRate.text ="????????? ?????? : " +  movieinfo.watcher_evaluation.toString()      //????????? ??????
                audienceCount.text = movieinfo.watcher_count.toString() +"???"                     //????????? ?????? ???
                totalAudienceText.text = "??? ????????? "+ movieinfo.totalaudience+"???"                             //??? ?????????
                countryText.text = "??????:"+strcountry                                  //??????
                DirectorText.text = "??????:"+ strdirector                                 //??????
                genreText.text = "??????:"+strgenre
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
                movieTitle.text = movieinfo!!.movie_title                                          //????????????
                openingDateText.text = "????????????:"+movieinfo!!.opening_date                                    //????????????
                playingTimeText.text = "????????????:"+movieinfo!!.playing_time.toString() +"???"                   //????????????
                netizenRate.text = "????????? ?????? : " + movieinfo.netizen_evaluation.toString()      //????????? ??????
                netizenCount.text = movieinfo.netizen_count.toString()+"???"                       //????????? ?????? ???
                jourRate.text = "?????? ?????? : " + movieinfo.journal_evaluation                      //?????? ??????
                jourCount.text = movieinfo.journal_count.toString() +"???"                         //?????? ?????? ???
                audienceRate.text ="????????? ?????? : " +  movieinfo.watcher_evaluation.toString()      //????????? ??????
                audienceCount.text = movieinfo.watcher_count.toString() +"???"                     //????????? ?????? ???
                totalAudienceText.text = "??? ????????? "+ movieinfo.totalaudience+"???"                             //??? ?????????
                countryText.text = "??????:"+strcountry                                  //??????
                DirectorText.text = "??????:"+ strdirector                                 //??????
                genreText.text = "??????:"+strgenre
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
                movieTitle.text = movieinfo!!.movie_title                                          //????????????
                openingDateText.text = "????????????:"+movieinfo!!.opening_date                                    //????????????
                playingTimeText.text = "????????????:"+movieinfo!!.playing_time.toString() +"???"                   //????????????
                netizenRate.text = "????????? ?????? : " + movieinfo.netizen_evaluation.toString()      //????????? ??????
                netizenCount.text = movieinfo.netizen_count.toString()+"???"                       //????????? ?????? ???
                jourRate.text = "?????? ?????? : " + movieinfo.journal_evaluation                      //?????? ??????
                jourCount.text = movieinfo.journal_count.toString() +"???"                         //?????? ?????? ???
                audienceRate.text ="????????? ?????? : " +  movieinfo.watcher_evaluation.toString()      //????????? ??????
                audienceCount.text = movieinfo.watcher_count.toString() +"???"                     //????????? ?????? ???
                totalAudienceText.text = "??? ????????? "+ movieinfo.totalaudience+"???"                             //??? ?????????
                countryText.text = "??????:"+strcountry                                  //??????
                DirectorText.text = "??????:"+ strdirector                                 //??????
                genreText.text = "??????:"+strgenre
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
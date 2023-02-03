const express = require("express");
const router = express.Router();
const mysql = require("mysql");
const dbconfig = {
    host: "localhost",
    port: "3306",         //db 전용 포트
    user: "root",
    password: "dbswnsvoa353",
    database: "naver_movie",
};

const connection = mysql.createConnection(dbconfig);

//제목 러닝타임 소닝
router.all("/title",(req,res,next)=>{
    let title = req.body.movie_title
    let query = `
    select * from movie where movie_title="${title}" order by playing_time desc
    `
    connection.query(query,(err,result) => {
        console.log(err)
        console.log(result)
        res.status(200).send(result)
    })
})
//제목 오프닝소팅
router.all("/title/opening",(req,res,next)=>{
    let title = req.body.movie_title
    let query = `
    select * from movie where movie_title="${title}" order by opening_date 
    `
    connection.query(query,(err,result) => {
        console.log(err)
        console.log(result)
        res.status(200).send(result)
    })
})

//장르 러닝타임 소닝
router.all("/genre",(req,res,next)=>{
    let genre = req.body.genre
    let query = `
    select * from genre g, movie m where g.movie_id=m.movie_id and g.content = "${genre}" order by m.playing_time desc
    `
    connection.query(query,(err,result) => {
        res.status(200).send(result)
    })
})
//장르 오프닝소팅
router.all("/genre/opening",(req,res,next)=>{
    let genre = req.body.genre
    let query = `
    select * from genre g, movie m where g.movie_id=m.movie_id and g.content = "${genre}" order by m.opening_date
    `
    connection.query(query,(err,result) => {
        res.status(200).send(result)
    })
})

//나라 러닝타임 소닝
router.post("/country",(req,res,next)=>{
    let country = req.body.country;
    console.log("req.body\n")  
    console.log(req.body)   
    console.log(country)
    let query = `
    select * from country c, movie m where c.movie_id=m.movie_id and c.country_name='${country}' order by m.playing_time desc
    `
    connection.query(query,(err,result) => {
        res.status(200).send(result)
    })
})
//나라 오프닝 소팅
router.post("/country/opening",(req,res,next)=>{
    let country = req.body.country;
    console.log("req.body\n")  
    console.log(req.body)   
    console.log(country)
    let query = `
    select * from country c, movie m where c.movie_id=m.movie_id and c.country_name='${country}' order by m.opening_date
    `
    connection.query(query,(err,result) => {
        console.log(err)
        console.log(result)
        res.status(200).send(result)
    })
})

//감독 러닝타임 소팅
router.post("/director",(req,res,next)=>{   
    let director = req.body.director
    let query = `
    select * from director d, movie m where d.movie_id=m.movie_id and d.director_name="${director}" order by m.playing_time desc
    `
   
    connection.query(query,(err,result) => {  
        res.status(200).send(result)
    })
})
//감독 오프닝 타임 소팅
router.post("/director/opening",(req,res,next)=>{   
    let director = req.body.director
    let query = `
    select * from director d, movie m where d.movie_id=m.movie_id and d.director_name="${director}" order by m.opening_date
    `
   
    connection.query(query,(err,result) => {  
        res.status(200).send(result)
    })
})

//배우 러닝타임 소팅
router.post("/actor",(req,res,next)=>{
    let actor = req.body.actor
    let query = `
    select * from actor a, movie m where a.movie_id=m.movie_id and a.actor_name="${actor}" order by m.playing_time desc
    `
   
    connection.query(query,(err,result) => {
        res.status(200).send(result)
    })

})
//배우 오프닝 소팅
router.post("/actor/opening",(req,res,next)=>{
    let actor = req.body.actor
    let query = `
    select * from actor a, movie m where a.movie_id=m.movie_id and a.actor_name="${actor}" order by m.opening_date
    `
   
    connection.query(query,(err,result) => {
        res.status(200).send(result)
    })

})

//배우 - 영화 .국가
router.post("/actor/country",(req,res,next)=>{
    let movieid = req.body.movieid
    let query = `
    select country_name from country where movie_id = ${movieid}
    `
    console.log(movieid);
   
    connection.query(query,(err,result) => {
        res.status(200).send(result)
    })

})

//배우 - 영화 .감독
router.post("/actor/director",(req,res,next)=>{
    let movieid = req.body.movieid
    let query = `
    select director_name from director where movie_id = ${movieid}
    `
    console.log(movieid);
   
    connection.query(query,(err,result) => {
        console.log(err)
        res.status(200).send(result)
    })

});

//배우 - 영화 .genre
router.post("/actor/genre",(req,res,next)=>{
    let movieid = req.body.movieid
    let query = `
    select content from genre where movie_id = ${movieid}
    `
    console.log(movieid);
   
    connection.query(query,(err,result) => {
        console.log(err)
        res.status(200).send(result)
    });

});
//배우 - 영화 .review
router.post("/actor/review",(req,res,next)=>{
    let movieid = req.body.movieid
    let query = `
    select review_main from review where movie_id = ${movieid}
    `
    console.log(movieid);
   
    connection.query(query,(err,result) => {
        console.log(err)
        res.status(200).send(result)
    })

});

//배우 -영화  quotes
router.post("/actor/quotes",(req,res,next)=>{
    let movieid = req.body.movieid
    let query = `
    select quotes_content from quotes where movie_id = ${movieid}
    `
    console.log(movieid);
   
    connection.query(query,(err,result) => {
        console.log(err)
        res.status(200).send(result)
    })

});
//배우-영화 actor
router.post("/actor/actors",(req,res,next)=>{
    let movieid = req.body.movieid
    let query = `
    select * from actor where movie_id = ${movieid}
    `
    console.log(movieid);
   
    connection.query(query,(err,result) => {
        console.log(err)
        res.status(200).send(result)
    })

});


module.exports = router;


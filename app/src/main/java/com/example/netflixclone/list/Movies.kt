package com.example.netflixclone.list

import com.example.netflixclone.R

data class Movies(

    val movieCover: Int
)

class MoviesBuilder{
    var movieCover: Int = 0
    fun build(): Movies = Movies(movieCover)
}

fun movies(block: MoviesBuilder.() -> Unit): Movies = MoviesBuilder().apply(block).build()

fun addMovies(): MutableList<Movies> = mutableListOf(

    movies {
        movieCover = R.drawable.filme1
    },

    movies {
        movieCover = R.drawable.filme2
    },

    movies {
        movieCover = R.drawable.filme3
    },

    movies {
        movieCover = R.drawable.filme4
    },

    movies {
        movieCover = R.drawable.filme5
    },

    movies {
        movieCover = R.drawable.filme6
    },

    movies {
        movieCover = R.drawable.filme7
    },

    movies {
        movieCover = R.drawable.filme8
    },

    movies {
        movieCover = R.drawable.filme9
    },

    movies {
        movieCover = R.drawable.filme10
    },

    movies {
        movieCover = R.drawable.filme11
    },

    movies {
        movieCover = R.drawable.filme12
    }
)


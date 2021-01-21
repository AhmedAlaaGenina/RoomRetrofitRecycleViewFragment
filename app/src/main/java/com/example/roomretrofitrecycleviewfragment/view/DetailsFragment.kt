package com.example.roomretrofitrecycleviewfragment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.roomretrofitrecycleviewfragment.R
import com.example.roomretrofitrecycleviewfragment.data.FilmDB
import com.example.roomretrofitrecycleviewfragment.model.Result
import kotlinx.android.synthetic.main.fragment_deteils.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailsFragment : Fragment() {

    lateinit var data: Result
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            data = it.getParcelable("films")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_deteils, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtViewMovieName.text = data.original_title
        txtViewMovieRate.text = data.popularity.toString()
        Glide.with(view).load("http://image.tmdb.org/t/p/w500${data.backdrop_path}")
            .into(imageViewMovie)

//        GlobalScope.launch {
//            val db = FilmDB.getFilmsDB(view.context!!)
//            val allMovies = db.getDoaInstance().getAllNotes()
//            withContext(Dispatchers.Main) {
//                allMovies.observe(this@DetailsFragment, Observer {
//                    for ()
//                })
//            }
//        }

        favourite.setOnClickListener {
            GlobalScope.launch {
                val db = FilmDB.getFilmsDB(view.context!!)
                db.getDoaInstance().insertFilm(data)
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
package com.example.roomretrofitrecycleviewfragment.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomretrofitrecycleviewfragment.R
import com.example.roomretrofitrecycleviewfragment.data.ApiMovies
import com.example.roomretrofitrecycleviewfragment.model.ItemAdapter
import com.example.roomretrofitrecycleviewfragment.model.Result
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainFragment : Fragment(), CellClickListener {
    private lateinit var result: List<Result>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            Dispatchers.IO
            val response = ApiMovies.getApiService()
                .getMovies("837aa67b269303622a476bbe24283a57")
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    if (response != null) {
                        result = response.body()!!.results
                        Log.i("TAG", "onCreate: ${result}")
                        rcvMain.apply {
                            this.layoutManager = LinearLayoutManager(activity)
                            this.adapter = ItemAdapter(context, result, this@MainFragment)
                        }
                    }
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onCellClickListener(data: Result) {
        Toast.makeText(context, "cell called ${data.original_title}", Toast.LENGTH_SHORT).show()
        arguments = Bundle().apply {
            putParcelable("films", data)
        }
        view?.let {
            Navigation.findNavController(it)
                .navigate(R.id.action_mainFragment_to_deteilsFragment, arguments)
        }
    }
}

interface CellClickListener {
    fun onCellClickListener(data: Result)
}


package com.example.roomretrofitrecycleviewfragment.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.roomretrofitrecycleviewfragment.R
import com.example.roomretrofitrecycleviewfragment.view.CellClickListener
import kotlinx.android.synthetic.main.gridview.view.*

class ItemAdapter(
    private val context: Context,
    private val dataSet: List<Result>,
    private val cellClickListener: CellClickListener
) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView
        val imageView: ImageView

        init {
            textView = itemView.txtMovies
            imageView = itemView.imageView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.gridview, parent, false)
        );
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textView.text = dataSet[position].original_title
        val data = dataSet[position]

        Glide.with(context)
            .load("http://image.tmdb.org/t/p/w500${dataSet[position].backdrop_path}")
            .into(holder.imageView)
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(data)
        }
    }
}






















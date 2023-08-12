package com.ronel.simplevideoplayer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ronel.simplevideoplayer.R
import com.ronel.simplevideoplayer.data.VideoData
import com.ronel.simplevideoplayer.databinding.ItemLayoutVideoBinding



class VideoAdapter : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    private lateinit var itemListener: OnItemListener
    var movieList = mutableListOf<VideoData>()


    fun setItemListener(listener :OnItemListener){
        itemListener = listener
    }

    fun setMovies(movies: List<VideoData>) {
        this.movieList = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutVideoBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }


    class ViewHolder(val binding: ItemLayoutVideoBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList[position]
        with(holder){

            this.binding.root.setOnClickListener {
                itemListener.movieClicked(movie)
            }
            with(movie){
                System.out.println("MOVIE : $this")
              holder.binding.video = this
            }
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}


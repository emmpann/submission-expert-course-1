package com.github.emmpann.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.emmpann.core.R
import com.github.emmpann.core.databinding.MovieItemBinding
import com.github.emmpann.core.domain.model.Movie

class MovieAdapter : ListAdapter<Movie, MovieAdapter.ListViewHolder>(DIFF_CALLBACK) {

    interface OnClickCallback {
        fun onItemClick(item: Movie)
    }

    private lateinit var onItemClickCallback: OnClickCallback

    fun setOnClickCallback(onItemClickCallback: OnClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClick(getItem(holder.adapterPosition)) }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = MovieItemBinding.bind(itemView)
        fun bind(data: Movie) {
            with(binding) {
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${data.posterPath}")
                    .into(ivMovie)
                tvMovieTitle.text = data.title
                tvMovieDesc.text = data.overview
            }
        }
    }
}
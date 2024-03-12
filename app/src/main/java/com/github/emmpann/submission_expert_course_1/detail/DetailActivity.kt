package com.github.emmpann.submission_expert_course_1.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.github.emmpann.core.domain.model.Movie
import com.github.emmpann.submission_expert_course_1.R
import com.github.emmpann.submission_expert_course_1.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailViewModel: DetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailMovie(detailMovie)
    }

    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            binding.content.tvRating.text =
                String.format("%s", detailMovie.voteAverage.substring(0, 3))
            binding.content.tvDetailTitle.text = detailMovie.title
            binding.content.tvDetailRelease.text = detailMovie.releaseDate
            binding.content.tvDetailDescription.text = detailMovie.overview
            Glide.with(this@DetailActivity)
                .load("https://image.tmdb.org/t/p/w500${detailMovie.backdropPath}")
                .centerCrop()
                .into(binding.ivDetailImage)

            var statusFavorite = detailMovie.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavorite(detailMovie, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_fav))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_fav))
        }
    }
}
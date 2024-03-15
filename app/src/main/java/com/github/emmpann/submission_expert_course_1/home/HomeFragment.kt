package com.github.emmpann.submission_expert_course_1.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.emmpann.core.data.Resource
import com.github.emmpann.core.domain.model.Movie
import com.github.emmpann.core.ui.MovieAdapter
import com.github.emmpann.submission_expert_course_1.R
import com.github.emmpann.submission_expert_course_1.databinding.FragmentHomeBinding
import com.github.emmpann.submission_expert_course_1.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val movieAdapter = MovieAdapter()
            movieAdapter.setOnClickCallback(object : MovieAdapter.OnClickCallback {
                override fun onItemClick(item: Movie) {
                    val intent = Intent(activity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, item)
                    startActivity(intent)
                }
            })

            homeViewModel.movie.observe(viewLifecycleOwner) { movie ->
                if (movie != null) {
                    when (movie) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            movieAdapter.submitList(movie.data)
                        }

                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.tvError.visibility = View.VISIBLE
                            binding.tvError.text =
                                movie.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            }

            with(binding.rvMovie) {
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
                adapter = movieAdapter
            }

            binding.fabFavorite.setOnClickListener {
                // move to favorite page, using multi module
                val uri = Uri.parse("moviefavorite://favorite")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
        }
    }
}
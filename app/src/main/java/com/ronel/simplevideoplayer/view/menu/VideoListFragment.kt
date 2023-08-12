package com.ronel.simplevideoplayer.view.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.ronel.simplevideoplayer.R
import com.ronel.simplevideoplayer.adapter.OnItemListener
import com.ronel.simplevideoplayer.adapter.VideoAdapter
import com.ronel.simplevideoplayer.data.VideoData
import com.ronel.simplevideoplayer.databinding.FragmentVideoListBinding
import com.ronel.simplevideoplayer.network.RetrofitService
import com.ronel.simplevideoplayer.repository.MainRepository


class VideoListFragment : Fragment(), OnItemListener {

    private lateinit var binding : FragmentVideoListBinding
    private lateinit var viewModel : VideoViewModel

    private var rvAdapter : VideoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentVideoListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner


        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext())
        binding.videoRV.layoutManager = layoutManager


        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)
        rvAdapter = VideoAdapter()
        binding.videoRV.adapter = rvAdapter
        rvAdapter?.setItemListener(this)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(mainRepository)
        )[VideoViewModel::class.java]

        binding.viewModel = viewModel


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.videoResponse.observe(this) {
            it.data.videos.data?.let { it1 -> rvAdapter?.setMovies(it1) }
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        viewModel.loading.observe(this, Observer {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        })

        viewModel.getAllMovies()
    }

    override fun movieClicked(video: VideoData) {
        val bundle = bundleOf("video" to Gson().toJson(video))
        view?.findNavController()
            ?.navigate(R.id.action_videoListFragment_to_videoInfoFragment,bundle)
    }

}
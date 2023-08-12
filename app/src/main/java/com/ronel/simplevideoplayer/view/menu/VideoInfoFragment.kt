package com.ronel.simplevideoplayer.view.menu

import android.R
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.gson.Gson
import com.ronel.simplevideoplayer.data.VideoData
import com.ronel.simplevideoplayer.databinding.FragmentVideoInfoBinding


class VideoInfoFragment : Fragment() {

    private var videoData: VideoData? = null
    private lateinit var binding : FragmentVideoInfoBinding

    // creating a variable for exoplayerview.
    var exoPlayerView: SimpleExoPlayerView? = null

    // creating a variable for exoplayer
    var exoPlayer: SimpleExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       var value =  arguments?.getString("video")
       System.out.println("VIDEO : "+value)

        videoData = Gson().fromJson(value,VideoData::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVideoInfoBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = viewLifecycleOwner


        requireActivity().title = videoData?.video_title

        exoPlayerView = binding.idExoPlayerVIew
        try {
            //bandwisthmeter is used for getting default bandwidth
            val bandwidthMeter: BandwidthMeter = DefaultBandwidthMeter()
            // track selector is used to navigate between video using a default seekbar.
            val trackSelector: TrackSelector =
                DefaultTrackSelector(AdaptiveTrackSelection.Factory(bandwidthMeter))
            //we are ading our track selector to exoplayer.
            exoPlayer = ExoPlayerFactory.newSimpleInstance(requireContext(), trackSelector)
            // we are parsing a video url and parsing its video uri.
            //val videouri = Uri.parse(videoData?.mp4_video_source)
            val videouri = Uri.parse("https://joy.videvo.net/videvo_files/video/premium/partners0040/large_watermarked/BB_8e780b7f-3eba-4c54-9fe5-e135eff52d1e_preview.mp4")
            // we are creating a variable for datasource factory and setting its user agent as 'exoplayer_view'
            val dataSourceFactory = DefaultHttpDataSourceFactory("exoplayer_video")
            // we are creating a variable for extractor factory and setting it to default extractor factory.
            val extractorsFactory: ExtractorsFactory = DefaultExtractorsFactory()
            //we are creating a media source with above variables and passing our event handler as null,
            val mediaSource: MediaSource =
                ExtractorMediaSource(videouri, dataSourceFactory, extractorsFactory, null, null)
            //inside our exoplayer view we are setting our player
            exoPlayerView!!.player = exoPlayer
            //we are preparing our exoplayer with media source.
            exoPlayer!!.prepare(mediaSource)
            //we are setting our exoplayer when it is ready.
            exoPlayer!!.playWhenReady = true

        } catch (e: Exception) {
            // below line is used for handling our errors.
            Log.e("TAG", "Error : $e")
        }



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.videoTitle.text = videoData?.video_title
        binding.videoDesc.text = videoData?.video_description
        binding.videoViews.text = videoData?.view_count.toString()

        setHasOptionsMenu(true);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === android.R.id.home) {
            findNavController().popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

}
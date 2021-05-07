package com.example.test.publish

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.test.databinding.FragmentPublishBinding

class PublishFragment: Fragment() {

    private val viewModel: PublishViewModel by lazy {
        ViewModelProvider(this).get(PublishViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentPublishBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        viewModel.addDate()

        val adapter = PublishAdapter()
        binding.articles.adapter = adapter


        viewModel.mock.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.notifyDataSetChanged()
                adapter.submitList(it)
                Log.d("article","article = ${viewModel.mock.value}")
            }
        })

        binding.addArticle.setOnClickListener {view: View -> view.findNavController().navigate(
            PublishFragmentDirections.actionPublishFragmentToPublishDialog()
        )
        }


        return binding.root
    }


}

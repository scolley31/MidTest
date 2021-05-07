package com.example.test.publishDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.test.R
import com.example.test.databinding.FragmentPublishDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PublishDialog(): DialogFragment() {

    private lateinit var binding: FragmentPublishDialogBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setStyle(STYLE_NORMAL, R.style.BottomSheetDialog)
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPublishDialogBinding.inflate(inflater)





        return binding.root
    }


}
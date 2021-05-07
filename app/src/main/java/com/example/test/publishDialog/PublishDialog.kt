package com.example.test.publishDialog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.test.R
import com.example.test.databinding.FragmentPublishDialogBinding
import com.example.test.publish.PublishViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.firestore.FirebaseFirestore

class PublishDialog(): DialogFragment() {

    private lateinit var binding: FragmentPublishDialogBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setStyle(STYLE_NORMAL, R.style.BottomSheetDialog)
//    }

    val db = FirebaseFirestore.getInstance()

    private val viewModel: PublishDialogViewModel by lazy {
        ViewModelProvider(this).get(PublishDialogViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPublishDialogBinding.inflate(inflater)

        binding.inputTitle.doOnTextChanged { text, start, before, count ->
            viewModel.title.value = text.toString()
            Log.d("test", "viewModel.title.value = ${viewModel.title.value}")
        }

        binding.inputCategory.doOnTextChanged { text, start, before, count ->
            viewModel.category.value = text.toString()
            Log.d("test", "viewModel.category.value = ${viewModel.category.value}")
        }

        binding.inputContent.doOnTextChanged { text, start, before, count ->
            viewModel.content.value = text.toString()
            Log.d("test", "viewModel.content.value = ${viewModel.content.value}")
        }

        binding.sendarticlebutton.setOnClickListener {
            addPost()
        }

        return binding.root
    }

    private fun addPost() {

        viewModel.author["author"] = "Scolley"
        viewModel.author["id"] = "19900412"
        viewModel.author["title"] = viewModel.title.value.toString()
        viewModel.author["category"] = viewModel.category.value.toString()
        viewModel.author["content"] = viewModel.content.value.toString()
        viewModel.author["createdTime"] = viewModel.date

        db.collection("articles")
            .add(viewModel.author)
            .addOnSuccessListener { documentReference ->
                Log.d(
                    "TAG",
                    "DocumentSnapshot added with ID: " + documentReference.id
                )
            }
            .addOnFailureListener { e -> Log.w("TAG", "Error adding document", e) }


        db.collection("articles")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        Log.d("ADD", document.id + " => " + document.data)
                    }
                } else {
                    Log.w("ADD", "Error getting documents.", task.exception)
                }
            }

    }


}
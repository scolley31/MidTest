package com.example.test.publish

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test.Article
import com.example.test.databinding.ItemPublishBinding

class PublishAdapter() : androidx.recyclerview.widget.ListAdapter<Article, PublishAdapter.ArticleHolder>(CartDiffCallback()){

    class ArticleHolder private constructor(val binding: ItemPublishBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.article = article
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ArticleHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPublishBinding.inflate(layoutInflater, parent, false)
                return ArticleHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        return ArticleHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CartDiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }
}
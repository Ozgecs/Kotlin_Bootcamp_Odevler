package com.ozge.retrofitmvvm.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ozge.retrofitmvvm.data.model.Book

class BooksAdapter(private val bookListener: BookListener) :
    ListAdapter<Book, BooksAdapter.BookViewHolder>(BookDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
        BookViewHolder(
            ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            bookListener
        )

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class BookViewHolder(
        private val binding: Bind, private val bookListener: BookListener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) = with(binding) {
            tvTitle.text = book.name
            tvPrice.text = "${book.price} ₺"

            Glide.with(ivCover.context).load(book.imageUrl).into(ivCover)

            if (book.isBestSeller == true) {
                ivBestSeller.setImageResource(R.drawable.ic_best)
            }

            root.setOnClickListener {
                bookListener.onBookClick(book.id ?: 1)
            }
        }

    }

    class BookDiffCallBack : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }

    }

    interface BookListener {
        fun onBookClick(id: Int)
    }

}
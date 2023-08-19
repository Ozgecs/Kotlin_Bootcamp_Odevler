package com.ozge.booksretrofit.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ozge.booksretrofit.MainApplication
import com.ozge.booksretrofit.R
import com.ozge.booksretrofit.common.loadImage
import com.ozge.booksretrofit.common.viewBinding
import com.ozge.booksretrofit.data.model.GetBookDetailResponse
import com.ozge.booksretrofit.databinding.FragmentDetailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created on 19.08.2023
 * @author Özge Şahin
 */

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)

    private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBookDetail(args.id)

    }

    private fun getBookDetail(id: Int) {
        MainApplication.bookService?.getBookDetail(id)?.enqueue(object :
            Callback<GetBookDetailResponse> {
            override fun onResponse(
                call: Call<GetBookDetailResponse>,
                response: Response<GetBookDetailResponse>
            ) {
                val result = response.body()?.book

                if (result != null) {
                    with(binding) {
                        tvName.text = result.name
                        tvAuthor.text = result.author
                        tvPublisher.text = result.publisher
                        tvPrice.text = "${result.price} ₺"
                        ivBook.loadImage(result.imageUrl)
                    }
                }
            }

            override fun onFailure(call: Call<GetBookDetailResponse>, t: Throwable) {
                Log.e("GetBooks", t.message.orEmpty())
            }
        })
    }
}
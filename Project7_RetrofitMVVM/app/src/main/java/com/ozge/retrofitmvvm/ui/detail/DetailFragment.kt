package com.ozge.retrofitmvvm.ui
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.ozge.retrofitmvvm.R
import com.ozge.retrofitmvvm.common.viewBinding
import com.ozge.retrofitmvvm.data.model.GetBookDetailResponse
import com.ozge.retrofitmvvm.ui.detail.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)

    private val args by navArgs<DetailFragmentArgs>()

    private val viewModel by viewModels<DetailViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getBookDetail(args.id)

        observeData()
    }

    private fun observeData()  = with(binding) {
        viewModel.loadingLiveData.observe(viewLifecycleOwner) {
            binding.detailProgressBar.isVisible = it
        }

        viewModel.booksDetailLiveData.observe(viewLifecycleOwner) { book ->
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

        viewModel.errorMessageLiveData.observe(viewLifecycleOwner) {
            Snackbar.make(requireView(), it, 1000).show()
        }
    }

}
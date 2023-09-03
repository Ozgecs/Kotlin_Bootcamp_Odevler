package com.ozge.retrofitmvvm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozge.retrofitmvvm.data.model.Book
import com.ozge.retrofitmvvm.data.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: BooksRepository
): ViewModel() {

    private var _bookDetailLiveData = MutableLiveData<Book?>()
    val bookDetailLiveData: LiveData<Book?>
        get() = _bookDetailLiveData

    private var _errorMessageLiveData = MutableLiveData<String>()
    val errorMessageLiveData: LiveData<String>
        get() = _errorMessageLiveData

    private var _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean>
        get() = _loadingLiveData

    init {
        _bookDetailLiveData = repository.bookDetailLiveData
        _errorMessageLiveData = repository.errorMessageLiveData
        _loadingLiveData = repository.loadingLiveData
    }
    fun getBookDetail(id:Int){
        repository.getBookDetail(id)
    }
}
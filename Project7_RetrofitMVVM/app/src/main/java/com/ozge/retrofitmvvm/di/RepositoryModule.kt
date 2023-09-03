package com.ozge.retrofitmvvm.di

import com.ozge.retrofitmvvm.data.repository.BooksRepository
import com.ozge.retrofitmvvm.data.source.BookService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBookRepository(service: BookService): BooksRepository = BooksRepository(service)
}
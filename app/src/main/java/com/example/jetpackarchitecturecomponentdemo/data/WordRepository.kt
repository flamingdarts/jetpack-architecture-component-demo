package com.example.jetpackarchitecturecomponentdemo.data

import androidx.lifecycle.LiveData
import com.example.jetpackarchitecturecomponentdemo.data.model.Word
import com.example.jetpackarchitecturecomponentdemo.data.model.WordDao

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class WordRepository(private val wordDao: WordDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}
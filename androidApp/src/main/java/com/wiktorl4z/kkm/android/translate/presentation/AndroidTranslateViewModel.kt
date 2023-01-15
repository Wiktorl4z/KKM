package com.wiktorl4z.kkm.android.translate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wiktorl4z.kkm.core.presentation.TranslateEvent
import com.wiktorl4z.kkm.core.presentation.TranslateViewModel
import com.wiktorl4z.kkm.translate.domain.history.HistoryDataSource
import com.wiktorl4z.kkm.translate.domain.translate.TranslateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidTranslateViewModel @Inject constructor(
    private val translateUseCase: TranslateUseCase,
    private val historyDataSource: HistoryDataSource,
) : ViewModel() {

    private val viewModel by lazy {
        TranslateViewModel(
            translateUseCase = translateUseCase,
            historyDataSource = historyDataSource,
            coroutineScope = viewModelScope
        )
    }

    val state = viewModel.state

    fun onEvent(event:TranslateEvent){
        viewModel.onEvent(event)
    }
}
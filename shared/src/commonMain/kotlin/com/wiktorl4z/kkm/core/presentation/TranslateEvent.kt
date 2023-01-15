package com.wiktorl4z.kkm.core.presentation

sealed class TranslateEvent {
    data class OnChooseFromLanguage(val language: UiLanguage) : TranslateEvent()
    data class OnChooseToLanguage(val language: UiLanguage) : TranslateEvent()
    object OnStopChoosingLanguage : TranslateEvent()
    object OnSwapLanguages : TranslateEvent()
    data class OnChangeTranslationText(val text: String) : TranslateEvent()
    object OnTranslate : TranslateEvent()
    object OnOpenFromLanguageDropDown : TranslateEvent()
    object OnOpenToLanguageDropDown : TranslateEvent()
    object OnCloseTranslation : TranslateEvent()
    data class OnSelectHistoryItem(val item: UiHistoryItem) : TranslateEvent()
    object OnEditTranslation : TranslateEvent()
    object OnRecordAudio : TranslateEvent()
    data class OnSubmitVoiceResult(val result: String?) : TranslateEvent()
    object OnErrorSeen : TranslateEvent()
}
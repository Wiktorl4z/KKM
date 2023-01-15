package com.wiktorl4z.kkm.core.presentation

import com.wiktorl4z.kkm.core.domain.language.Language

expect class UiLanguage {
    val language: Language

    companion object {
        fun byCode(langCode: String): UiLanguage
        val allLanguages: List<UiLanguage>
    }
}
package com.wiktorl4z.kkm.translate.domain.translate

import com.wiktorl4z.kkm.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language,
    ): String
}
package com.wiktorl4z.kkm.translate.domain.history

import com.wiktorl4z.kkm.core.domain.util.CommonFlow

interface HistoryDataSource {
    fun getHistory(): CommonFlow<List<HistoryItem>>
    suspend fun insertHistoryItem(item: HistoryItem)
}
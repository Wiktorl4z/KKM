package com.wiktorl4z.kkm.translate.data.history

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.wiktorl4z.kkm.core.domain.util.CommonFlow
import com.wiktorl4z.kkm.core.domain.util.toCommonFlow
import com.wiktorl4z.kkm.database.TranslateDatabase
import com.wiktorl4z.kkm.translate.domain.history.HistoryDataSource
import com.wiktorl4z.kkm.translate.domain.history.HistoryItem
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SqlDelightHistoryDataSource(
    db: TranslateDatabase
) : HistoryDataSource {

    private val queries = db.translateQueries

    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return queries.getHistory().asFlow()
            .mapToList()
            .map { history ->
                history.map { it.toHistoryItem() }
            }.toCommonFlow()
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        queries.insertHistoryEntity(
            id = item.id,
            fromLanguageCode = item.fromLanguageCode,
            fromText = item.fromText,
            toLanguageCode = item.toLanguageCode,
            toText = item.toText,
            timestamp = Clock.System.now().toEpochMilliseconds()
        )
    }
}
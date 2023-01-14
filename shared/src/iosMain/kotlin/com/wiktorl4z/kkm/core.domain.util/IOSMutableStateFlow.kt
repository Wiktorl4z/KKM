package com.wiktorl4z.kkm.core.domain.util

import kotlinx.coroutines.flow.MutableStateFlow

class IOSMutableStateFlow<T>(
    initialValue: T
) : CommonMutableStateFlow<T>(MutableStateFlow(initialValue)) {
}
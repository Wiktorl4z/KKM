package com.wiktorl4z.kkm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
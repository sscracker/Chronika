package dev.vova.chronica

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
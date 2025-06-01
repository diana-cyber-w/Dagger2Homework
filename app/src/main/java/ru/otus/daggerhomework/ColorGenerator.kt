package ru.otus.daggerhomework

import android.graphics.Color
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.util.Random

interface ColorGenerator {

    fun generateColor()

    val color: SharedFlow<Int>
}

class ColorGeneratorImpl : ColorGenerator {

    private val _color = MutableSharedFlow<Int>(
        replay = 1,
        extraBufferCapacity = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    override fun generateColor() {
        val rnd = Random()
        _color.tryEmit(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)))
    }

    override val color: SharedFlow<Int>
        get() = _color.asSharedFlow()
}
package com.example.testdagger.utils.bus

import org.greenrobot.eventbus.EventBus
import kotlin.reflect.full.findAnnotation

class RegisterClasses(private val classList: ArrayList<Any>) {

    private val bus = EventBus.getDefault()

    fun register() =
        classList
            .forEach { classItem ->
                classItem::class.findAnnotation<BusRegister>()
                    .let { bus.register(classItem) }
            }

    fun unregister() = classList.forEach { bus.unregister(it) }

}
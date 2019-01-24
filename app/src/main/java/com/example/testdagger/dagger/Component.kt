package com.example.testdagger.dagger

import com.example.testdagger.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [Injector::class])
interface Component {
    fun inject(mainActivity: MainActivity)
}
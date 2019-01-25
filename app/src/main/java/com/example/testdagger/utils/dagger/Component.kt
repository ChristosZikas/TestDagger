package com.example.testdagger.utils.dagger

import com.example.testdagger.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [Module::class])
interface Component {
    fun inject(mainActivity: MainActivity)
}
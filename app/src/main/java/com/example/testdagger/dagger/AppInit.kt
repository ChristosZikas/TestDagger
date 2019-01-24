package com.example.testdagger.dagger

import android.app.Application
import android.util.Log

class AppInit : Application() {

    lateinit var component: Component

    override fun onCreate() {
        component = DaggerComponent.create()
        super.onCreate()
    }

}
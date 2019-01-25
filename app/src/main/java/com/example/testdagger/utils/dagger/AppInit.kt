package com.example.testdagger.utils.dagger

import android.app.Application

class AppInit : Application() {

    lateinit var component: Component

    override fun onCreate() {
        component = DaggerComponent.create()
        super.onCreate()
    }

}
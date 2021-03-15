package com.runtimeterror.aild

import android.app.Application

class AILDApplication: Application() {

    override fun onCreate(){
        super.onCreate()
        Repository.initialize(this)
    }
}
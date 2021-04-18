package com.anushka.hiltdemo0

import dagger.Component

@Component(modules = [DataModule::class])
interface DataComponent {
    fun inject(mainActivity: MainActivity)
}
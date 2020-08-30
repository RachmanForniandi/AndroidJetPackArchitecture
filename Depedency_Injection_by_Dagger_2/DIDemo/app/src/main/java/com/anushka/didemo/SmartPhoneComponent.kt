package com.anushka.didemo

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MemoryCardModule::class, NCBatteryModule::class])
interface SmartPhoneComponent {
    //fun getSmartPhone() : SmartPhone
    fun inject(mainActivity: MainActivity)
}
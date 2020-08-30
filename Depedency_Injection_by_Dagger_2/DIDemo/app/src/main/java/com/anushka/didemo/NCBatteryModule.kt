package com.anushka.didemo

import dagger.Binds
import dagger.Module
import dagger.Provides

/*
@Module
class NCBatteryModule {

    @Provides
    fun providesNBCBattery(nickelCadmiumBattery: NickelCadmiumBattery):Battery{
        return nickelCadmiumBattery
    }
}*/
@Module
abstract class NCBatteryModule {

    @Binds
    abstract fun providesNBCBattery(nickelCadmiumBattery: NickelCadmiumBattery):Battery

}

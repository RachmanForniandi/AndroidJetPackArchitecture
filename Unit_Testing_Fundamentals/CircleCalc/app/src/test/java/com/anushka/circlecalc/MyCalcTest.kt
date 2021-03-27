package com.anushka.circlecalc

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class MyCalcTest{

    private lateinit var myCalc: MyCalc

    @Before
    fun setUp() {
        myCalc = MyCalc()
    }

    @Test
    fun calculateCircumferences_radius_given_returnsCorrectResult(){

        val result:Double = myCalc.calculateCircumference(2.1)
        assertThat(result).isEqualTo(13.188)
    }

    @Test
    fun calculateCircumferences_zeroRadius_given_returnsCorrectResult(){
        val result:Double = myCalc.calculateCircumference(0.0)
        assertThat(result).isEqualTo(0.0)
    }
}
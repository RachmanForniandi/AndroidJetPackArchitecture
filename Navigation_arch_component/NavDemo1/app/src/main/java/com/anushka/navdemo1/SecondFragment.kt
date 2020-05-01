package com.anushka.navdemo1

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.anushka.navdemo1.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {
    private lateinit var secondBinding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        secondBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_second, container, false)

        val receivedBundle = arguments?.getString("user_input")
        secondBinding.textView.text = receivedBundle.toString()

        return secondBinding.root
    }

}

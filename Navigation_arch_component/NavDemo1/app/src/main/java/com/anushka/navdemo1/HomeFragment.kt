package com.anushka.navdemo1

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.anushka.navdemo1.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentHomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        fragmentHomeBinding.btnSubmit.setOnClickListener {
            if (!TextUtils.isEmpty(fragmentHomeBinding.etInput.text.toString())){
                val bundle:Bundle = bundleOf("user_input" to fragmentHomeBinding.etInput.text.toString())
                it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment,bundle)
            }else{
                Toast.makeText(activity,"Please insert input",Toast.LENGTH_SHORT).show()
            }

        }

        return fragmentHomeBinding.root
    }

}

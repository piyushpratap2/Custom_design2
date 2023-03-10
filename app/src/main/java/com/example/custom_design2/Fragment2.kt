package com.example.custom_design2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.custom_design2.databinding.Fragment2Binding
import com.saurabhbadola.statesman.BaseFragment

class Fragment2 : BaseFragment<MyViewModel>() {
    private lateinit var binding: Fragment2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment2Binding.inflate(layoutInflater, container, false)
        binding.myviewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.executePendingBindings()

        /*activity?.onBackPressedDispatcher?.addCallback(requireActivity(), object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed(){
               *//* val fm = activity?.supportFragmentManager?.beginTransaction()?.remove(this@Fragment2)
                if (fm != null) {
                    fm.commit()
                }*//*
                viewModel.BackNavigation2()
            }
        })*/
        return binding.root
    }
    fun fragmentAnimation(){
        val fm = activity?.supportFragmentManager?.beginTransaction()
        if (fm != null) {
            fm.setCustomAnimations(R.anim.fade_in2,R.anim.fade_out2,R.anim.slide_in2,R.anim.slide_out2)
            fm.replace(R.id.container,Fragment1())
            fm.addToBackStack(null)
            fm.commit()
        }
    }

}
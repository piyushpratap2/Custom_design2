package com.example.custom_design2

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.custom_design2.databinding.Fragment1Binding
import com.saurabhbadola.statesman.BaseFragment
import com.saurabhbadola.statesman.BaseViewModel


 class Fragment1 : BaseFragment<MyViewModel>() {
   private lateinit var binding: Fragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = Fragment1Binding.inflate(layoutInflater,container,false)
       binding.myviewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.executePendingBindings()

       /* binding.btn1.setOnClickListener {
            binding.motionLayout1.setTransition(binding.motionLayout1.currentState,R.id.end)
            binding.motionLayout1.setTransitionDuration(300)
            binding.motionLayout1.transitionToEnd()
        }*/

        activity?.onBackPressedDispatcher?.addCallback(requireActivity(), object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                viewModel.BackNavigation2()
            }
        })

        /*binding.btn2.setOnClickListener {
            val fm = activity?.supportFragmentManager?.beginTransaction()
            if (fm != null) {
                fm.setCustomAnimations(R.anim.fade_in,R.anim.fade_out,R.anim.slide_in,R.anim.slide_out)
                fm.add(R.id.container,Fragment2())
                fm.addToBackStack(null)
                fm.commit()
            }
        }*/
        return binding.root
    }

     fun motionScene(){
         Toast.makeText(requireContext(),"YES",Toast.LENGTH_LONG).show()
         var state:Int = binding.motionLayout1.currentState
         Log.d(TAG, "motionScene: $state ")
         binding.motionLayout1.setTransition(R.id.start,R.id.end)
         binding.motionLayout1.setTransitionDuration(300)
         binding.motionLayout1.transitionToEnd()
     }

      fun motionScene1(){
           binding.motionLayout1.setTransition(binding.motionLayout1.currentState,R.id.start)
           binding.motionLayout1.setTransitionDuration(300)
           binding.motionLayout1.transitionToEnd()
       }

}
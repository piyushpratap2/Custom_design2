package com.example.custom_design2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionScene.Transition
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.transition.Transition.TransitionListener
import com.example.custom_design2.databinding.ActivityMainBinding
import com.saurabhbadola.statesman.BaseActivity
import com.saurabhbadola.statesman.BaseViewModel
import com.saurabhbadola.statesman.NavigationRoute
import java.util.Objects

class MainActivity : BaseActivity<MainState>() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*binding.container.setOnClickListener {
            binding.motionLayout.setTransition(binding.motionLayout.currentState,R.id.collapse)
            binding.motionLayout.setTransitionDuration(500)
            binding.motionLayout.transitionToEnd()
        }*/

        val fm = supportFragmentManager.beginTransaction()
        fm.add(R.id.container,fragment)
        fm.addToBackStack(null)
        fm.commit()

        binding.myviewmodel = myViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()

    }
    val fragment = Fragment1()

    override fun createViewModel(): BaseViewModel<MainState> {
        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        return myViewModel
    }

    override fun onNavigationRouteChange(newRoute: NavigationRoute, oldRoute: NavigationRoute){
        Log.d(TAG, "onNavigationRouteChange: $newRoute:: $oldRoute")
        when(newRoute.routeName){
             Route.OPEN.name->{
                 fragment.motionScene()
                 myViewModel.navigation()
             }
            Route.NOTOPEN.name->{
                if(supportFragmentManager.backStackEntryCount != 0){
                    supportFragmentManager.popBackStack()
                }
                myViewModel.BackNavigation()
                myViewModel.reset()
            }
            Route.SUBMIT.name ->{
                val fm = supportFragmentManager.beginTransaction()
                fm.setCustomAnimations(R.anim.fade_in,R.anim.fade_out,R.anim.slide_in,R.anim.slide_out)
                fm.replace(R.id.container,Fragment2())
                fm.addToBackStack(null)
                fm.commit()
                myViewModel.FragmentChange()
                myViewModel.reset()
            }

            Route.Back.name->{
                val count = supportFragmentManager.backStackEntryCount
                Toast.makeText(this,"$count",Toast.LENGTH_LONG).show()
                supportFragmentManager.popBackStack()
                if (count==0)
                    finish()
                myViewModel.reset()
            }

        }
    }

    override fun onStateChanged(newState: MainState, oldState: MainState) {
        TODO("Not yet implemented")
    }

}
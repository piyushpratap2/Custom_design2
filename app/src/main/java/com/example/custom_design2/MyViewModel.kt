package com.example.custom_design2

import android.app.Application
import com.saurabhbadola.statesman.BaseViewModel
import com.saurabhbadola.statesman.NavigationRoute

class MyViewModel(application: Application): BaseViewModel<MainState>(application = application) {
    override fun createInitialState(): MainState {
        return MainState(
            "piyush",
            "piyush@gmail.com",
            "123456"
        )
    }
     fun navigation(){
          navigateTo(NavigationRoute(Route.OPEN.name,Route.OPEN.ordinal))
     }
    fun BackNavigation(){
        navigateTo(NavigationRoute(Route.NOTOPEN.name,Route.NOTOPEN.ordinal))
    }
    fun FragmentChange(){
        navigateTo(NavigationRoute(Route.SUBMIT.name,Route.SUBMIT.ordinal))
    }
    fun BackNavigation2(){
        navigateTo(NavigationRoute(Route.Back.name,Route.Back.ordinal))
    }

    fun reset(){
        navigateTo(NavigationRoute(Route.RESET.name,Route.RESET.ordinal))
    }
}

enum class Route {
    OPEN,
    SUBMIT,
    NOTOPEN,
    Back,
    RESET
}
package com.nandaadisaputra.semarangtourism.ui.navigation

import com.nandaadisaputra.semarangtourism.data.constant.Const

sealed class Screen(val route: String) {
    object Detail : Screen(Const.Cons.DETAIL) {
        fun createRoute(tourismId: Int) = "home/$tourismId"
    }
    object Home : Screen(Const.Cons.HOME)
    object AboutMe : Screen(Const.Cons.ABOUT)

}

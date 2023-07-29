package files.app.bottomnavigation.Navigation

import files.app.bottomnavigation.R

sealed class BottomItem(val item:String, val iconID:Int,val route:String){
    object Screen1:BottomItem("Home", R.drawable.home,"screen_1")
    object Screen2:BottomItem("Search", R.drawable.search,"screen_2")
    object Screen3:BottomItem("History", R.drawable.history,"screen_3")
    object Screen4:BottomItem("My account", R.drawable.person,"screen_4")
}

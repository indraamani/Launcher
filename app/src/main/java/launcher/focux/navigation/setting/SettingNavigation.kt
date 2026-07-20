package launcher.focux.navigation.setting

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import launcher.focux.ui.screen.FontScreen
import launcher.focux.ui.screen.SettingScreen
import launcher.focux.ui.screen.TopWidgetScreen

@Composable
fun SettingNavigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Setting) {

        composable<Setting> {
            SettingScreen(
                openFontScreen = {
                    navController.navigate(FontScreen)
                },
                openTopwidgetScreen = {
                    navController.navigate(TopWidgetScreen)
                },
            )
        }
        composable<FontScreen> {

            FontScreen(
                closeScreen = {
                    navController.popBackStack()

                }
            )
        }
        composable<TopWidgetScreen> {
            TopWidgetScreen(
                closeScreen = {
                    navController.popBackStack()
                }
            )
        }

//        composable<ThemeScreen> {
//        }
//        composable<BottomWidgetScreen> {
//        }
//        composable<GestureScreen> {
//        }
    }

}
package launcher.focux

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager

class Packages(val ctx: Context) {
    val packageManager: PackageManager = ctx.packageManager

    fun fetchAllPackages() : List<AppModel> {
        val apps : List<PackageInfo> = packageManager.getInstalledPackages(PackageManager.GET_META_DATA)
        val appList : MutableList<AppModel> = mutableListOf<AppModel>()

        for (app in apps) {
            if(packageManager.getLaunchIntentForPackage(app.packageName) != null) {
                val name : String = packageManager.getApplicationLabel(app.applicationInfo!!).toString()
                appList.add(
                    AppModel(
                        name = name,
                        launcherIntent = packageManager.getLaunchIntentForPackage(app.packageName)!!
                    )
                )
            }
        }

        return appList
    }


}
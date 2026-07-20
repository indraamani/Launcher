package launcher.focux.utils

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager

class Packages(ctx: Context) {
    private val packageManager: PackageManager = ctx.packageManager

    fun fetchAllPackages() : List<AppModel> {
        val apps : List<PackageInfo> = packageManager.getInstalledPackages(PackageManager.GET_META_DATA)
        val appList : MutableList<AppModel> = mutableListOf<AppModel>()

        for (app in apps) {
            if(packageManager.getLaunchIntentForPackage(app.packageName) != null) {
                val name : String = packageManager.getApplicationLabel(app.applicationInfo!!).toString()
                appList.add(
                    AppModel(
                        name = name,
                        packageName = app.packageName
                    )
                )
            }
        }

        return appList
    }


}
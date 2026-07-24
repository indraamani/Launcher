package launcher.focux.datastore.app

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import launcher.focux.datastore.pinnedapp.PinnedApp
import launcher.focux.datastore.pinnedapp.pinnedAppModelDatastore
import launcher.focux.utils.AppModel
import launcher.focux.utils.sort

class ApplicationRepo(
    private val context: Context
) {

    val applicationFlow: Flow<InstalledPackage> = context.applicationDatastore.data
        .catch { exception ->
            throw exception
        }

    suspend fun update(allApps: Map<String, List<AppModel>>) {
        context.applicationDatastore.updateData { current ->
            current.copy(allApps)
        }
    }

    suspend fun rename(oldName: String, newName: AppModel) {
        context.applicationDatastore.updateData { current ->
            val allPackage = current.allPackages.values.flatten().toMutableList()
            allPackage.apply {
                removeIf {
                   newName.packageName == it.packageName
                }
                add(newName)
            }
            current.copy(allPackage.toList().sort())
        }

        context.pinnedAppModelDatastore.updateData { current ->
            val appList = current.appList.toMutableList()

            for((index, app) in appList.withIndex()) {
                if (app.name == oldName) {
                    appList[index] = PinnedApp(newName.name, app.packageName)
                }
            }
            current.copy(appList)
        }
    }

}
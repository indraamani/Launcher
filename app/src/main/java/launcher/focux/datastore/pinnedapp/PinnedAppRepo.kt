package launcher.focux.datastore.pinnedapp

import android.content.Context
import androidx.compose.runtime.currentComposer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class PinnedAppRepo(
    private val context: Context
) {

    val pinnedAppFlow: Flow<List<PinnedApp>> = context.pinnedAppModelDatastore.data
        .map { app -> app.appList  }
        .catch { exception ->
            throw exception
        }

    suspend fun add(app: PinnedApp) {
        context.pinnedAppModelDatastore.updateData { current ->
            if (current.appList.size >= 6) {
                val updatedList = current.appList.toMutableList().apply {
                    set(5, app)
                }
                current.copy(appList = updatedList)
            } else {
                current.copy(appList = (current.appList + app))
            }
        }
    }

    suspend fun update(app: PinnedApp, position: Int) {
        context.pinnedAppModelDatastore.updateData { current ->
            if (position in current.appList.indices) {
                val updatedList = current.appList.toMutableList().apply {
                    set(position, app)
                }
                current.copy(appList = updatedList)
            } else {
                current
            }
        }
    }

    suspend fun delete(name: String) {
        context.pinnedAppModelDatastore.updateData { current ->
            current.copy(
                appList = current.appList.filterNot { app -> app.name == name  }
            )
        }
    }
}
package launcher.focux.datastore.app

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import launcher.focux.AppModel
import java.util.SortedMap

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

}
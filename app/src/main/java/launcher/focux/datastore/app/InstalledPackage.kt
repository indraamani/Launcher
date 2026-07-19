package launcher.focux.datastore.app

import kotlinx.serialization.Serializable
import launcher.focux.AppModel
import java.util.SortedMap


@Serializable
data class InstalledPackage(
    val allPackages: Map<String, List<AppModel>> = mapOf()
)
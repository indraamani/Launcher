package launcher.focux.datastore.app

import kotlinx.serialization.Serializable
import launcher.focux.utils.AppModel


@Serializable
data class InstalledPackage(
    val allPackages: Map<String, List<AppModel>> = mapOf()
)
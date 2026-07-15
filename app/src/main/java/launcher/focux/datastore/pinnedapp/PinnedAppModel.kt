package launcher.focux.datastore.pinnedapp

import kotlinx.serialization.Serializable

@Serializable
data class PinnedApp(
    val name: String = "",
    val packageName: String = ""
)

@Serializable
data class PinnedAppModel(
    val appList: List<PinnedApp> = emptyList()
)
package launcher.focux

import android.content.Intent
import kotlinx.serialization.Serializable

@Serializable
data class AppModel(
    val name: String,
    val packageName: String
)

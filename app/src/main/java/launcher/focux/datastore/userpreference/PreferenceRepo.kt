package launcher.focux.datastore.userpreference

import android.content.Context
import androidx.compose.runtime.currentComposer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import launcher.focux.utils.BottomWidget
import launcher.focux.utils.TopWidget

class PreferenceRepo(
    private val ctx: Context
) {

    val setting : Flow<PreferencesModel> = ctx.preferenceDatastore.data
        .catch { exception ->
            throw exception
        }

    suspend fun toggleStatusBar(visiblity: Boolean) {
        ctx.preferenceDatastore.updateData { current ->
            current.copy(showStatusBar = visiblity)
        }
    }

    suspend fun toggleClock(visiblity: Boolean) {
        ctx.preferenceDatastore.updateData { current ->
            current.copy(showClock = visiblity)
        }
    }

    /***
     * true = 12 hour format
     * false = 24 hour format
     ***/
    suspend fun changeClockFormat(format: Boolean) {
        ctx.preferenceDatastore.updateData { current ->
            current.copy(clockFormat = format)
        }
    }

    suspend fun changeFont(font: Int) {
        ctx.preferenceDatastore.updateData { current ->
            current.copy(font = font)
        }
    }

    suspend fun changeTopWidget(widget: TopWidget) {
        ctx.preferenceDatastore.updateData { current ->
            current.copy(topWidget = widget)
        }
    }

    suspend fun changeBottomWidget(widget: BottomWidget) {
        ctx.preferenceDatastore.updateData { current ->
            current.copy(bottomWidget = widget)
        }
    }
}
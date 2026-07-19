package launcher.focux.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import launcher.focux.datastore.app.applicationDatastore
import launcher.focux.datastore.userpreference.PreferenceRepo
import launcher.focux.datastore.userpreference.PreferenceModel

class DrawerViewmodel(application: Application) : AndroidViewModel(application) {

    val packages = application.applicationDatastore.data

    val setting: StateFlow<PreferenceModel> = PreferenceRepo(application).setting.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = PreferenceModel()
    )
}
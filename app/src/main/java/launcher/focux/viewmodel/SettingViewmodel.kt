package launcher.focux.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import launcher.focux.datastore.userpreference.PreferenceModel
import launcher.focux.datastore.userpreference.PreferenceRepo
import launcher.focux.datastore.userpreference.preferenceDatastore

class SettingViewmodel(application : Application) : AndroidViewModel(application) {

    val setting : StateFlow<PreferenceModel> = PreferenceRepo(application).setting.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = PreferenceModel()
    )



}
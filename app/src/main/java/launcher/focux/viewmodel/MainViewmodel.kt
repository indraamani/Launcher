package launcher.focux.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.application
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import launcher.focux.utils.AppModel
import launcher.focux.datastore.pinnedapp.PinnedApp
import launcher.focux.datastore.pinnedapp.PinnedAppRepo
import launcher.focux.datastore.userpreference.PreferenceRepo
import launcher.focux.datastore.userpreference.PreferenceModel
import launcher.focux.utils.Packages
import launcher.focux.utils.sort
import java.util.Collections.emptySortedMap

class MainViewmodel(application: Application) : AndroidViewModel(application) {

    val pinnedAppRepo = PinnedAppRepo(application)

    val pinnedApp: StateFlow<List<PinnedApp>> = pinnedAppRepo.pinnedAppFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList<PinnedApp>()
    )

    val setting: StateFlow<PreferenceModel> = PreferenceRepo(application).setting.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = PreferenceModel()
    )

    private var _packages = MutableStateFlow<Map<String, List<AppModel>>>(emptySortedMap<String, List<AppModel>>())
    val packages = _packages.asStateFlow()

    init {
        loadApplication()
    }

    fun loadApplication() {

        viewModelScope.launch(Dispatchers.IO) {
            val pkgs = Packages(application).fetchAllPackages()
            _packages.value = pkgs.sort()
        }
    }
}
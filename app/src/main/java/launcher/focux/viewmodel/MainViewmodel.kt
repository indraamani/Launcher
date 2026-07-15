package launcher.focux.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import launcher.focux.datastore.pinnedapp.PinnedApp
import launcher.focux.datastore.pinnedapp.PinnedAppRepo

class MainViewmodel(application: Application) : AndroidViewModel(application) {

    val pinnedAppRepo = PinnedAppRepo(application)

    val pinnedApp: StateFlow<List<PinnedApp>> = pinnedAppRepo.pinnedAppFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList<PinnedApp>()
    )


}
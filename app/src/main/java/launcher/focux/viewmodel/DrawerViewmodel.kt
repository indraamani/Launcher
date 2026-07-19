package launcher.focux.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.application
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import launcher.focux.AppModel
import launcher.focux.datastore.app.applicationDatastore
import launcher.focux.utils.Packages
import launcher.focux.utils.sort
import java.util.Collections.emptySortedMap
import java.util.SortedMap

class DrawerViewmodel(application: Application) : AndroidViewModel(application) {

    val packages = application.applicationDatastore.data
}
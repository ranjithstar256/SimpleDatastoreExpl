package kp.ran.mytstap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
 import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DataStoreViewModel @Inject constructor(
    private val dataStore: TutorialDataStore
) : ViewModel() {

    val readName: StateFlow<String> = dataStore.readName.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ""
    )

    fun saveName(name: String) = viewModelScope.launch { dataStore.saveName(name) }
}
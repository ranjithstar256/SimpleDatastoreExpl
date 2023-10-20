package kp.ran.nodivw

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataStoreExpl {
    private var name: String = ""
    private val _nameStateFlow: MutableStateFlow<String> = MutableStateFlow("")

    fun saveName(name: String) {
        this.name = name
        _nameStateFlow.value = name
    }

    fun readName(): StateFlow<String> {
        return _nameStateFlow
    }
}

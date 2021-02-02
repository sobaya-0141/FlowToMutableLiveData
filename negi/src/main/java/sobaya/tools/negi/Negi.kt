package sobaya.tools.negi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

fun <T> ViewModel.flowToMutableLiveData(flow: Flow<T>): MutableLiveData<T> {
    val liveData = MutableLiveData<T>()
    viewModelScope.launch {
        liveData.postValue(flow.firstOrNull())
    }

    return liveData
}

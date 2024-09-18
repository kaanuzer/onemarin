import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.uzer.onemarin.network.ApiService
import com.uzer.onemarin.viewmodel.HealthControlViewModel

class HealthControlViewModelFactory(private val repository: ApiService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HealthControlViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HealthControlViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

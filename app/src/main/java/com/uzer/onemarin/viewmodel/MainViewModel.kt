
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uzer.onemarin.viewmodel.BaseViewModel


open class MainViewModel : BaseViewModel()  {
    private val _text = MutableLiveData<String>().apply {
        value = "Merhaba MainActivity'den!"
    }

    val text: LiveData<String> = _text

    fun updateText(newText: String) {
        _text.value = newText
    }
}
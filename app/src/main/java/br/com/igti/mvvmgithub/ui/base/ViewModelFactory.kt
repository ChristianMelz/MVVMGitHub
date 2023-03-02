package br.com.igti.mvvmgithub.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.igti.mvvmgithub.data.api.ApiHelper
import br.com.igti.mvvmgithub.data.repository.MainReporitory
import br.com.igti.mvvmgithub.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((MainViewModel::class.java))) {
            return MainViewModel(MainReporitory(apiHelper)) as T
        }
        throw java.lang.IllegalArgumentException("Não encontrado essa classe")
    }
}
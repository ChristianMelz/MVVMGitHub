package br.com.igti.mvvmgithub.ui.main.viewmodel

//import com.bumptech.glide.load.engine.Resource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.igti.mvvmgithub.data.model.User
import br.com.igti.mvvmgithub.data.repository.MainReporitory
import br.com.igti.mvvmgithub.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainReporitory: MainReporitory): ViewModel() {
    private val users = MutableLiveData<Resource<List<User>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        users.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainReporitory.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({userList -> users.postValue((Resource.success(userList)))},
                    {throwable -> users.postValue(Resource.error("Erro Inesperado!",null))})
        )
    }
    override fun onCleared(){
        super.onCleared()
        compositeDisposable.dispose()
    }
    fun getUsers(): LiveData<Resource<List<User>>>{
        return users
    }
}
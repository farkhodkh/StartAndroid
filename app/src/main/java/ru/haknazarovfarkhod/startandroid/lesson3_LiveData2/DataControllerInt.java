package ru.haknazarovfarkhod.startandroid.lesson3_LiveData2;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;

public class DataControllerInt {
    private static DataControllerInt instance;
    private MutableLiveData<String> liveData = new MutableLiveData<>();
    private LiveData<Integer> liveDataInt = new MutableLiveData<>();
    public void DataController() {

    }

    public static synchronized DataControllerInt getInstance() {
        if (instance == null) {
            instance = new DataControllerInt();
        }
        return instance;
    }

    public void setData(String value){
        liveData.postValue(value);
    }

    public LiveData<Integer> getIntegerLiveData(){
        liveDataInt = Transformations.map(liveData, new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return Integer.parseInt(input);
            }
        });
        return liveDataInt;

//        LiveData<Long> liveDataId = ...;
//
//        LiveData<User> liveDataUser = Transformations.switchMap(liveDataId, new Function<Long, LiveData<User>>() {
//            @Override
//            public LiveData<User> apply(Long id) {
//                return getUser(id);
//            }
//        });
    }
}

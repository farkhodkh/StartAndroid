package ru.haknazarovfarkhod.startandroid.lesson2_LiveData;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

public class DataController {

    private static DataController instance;
    private MutableLiveData<String> liveData = new MutableLiveData<>();

    private DataController(){

    }

    public static synchronized DataController getInstance(){
        if(instance==null){
            instance = new DataController();
        }
        return instance;
    }

    public LiveData<String> getData(){
        return liveData;
    }

    public void setDataIntoLiveData(String value) {
        liveData.setValue(value);
    }
}

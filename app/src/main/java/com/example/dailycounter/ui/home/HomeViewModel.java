package com.example.dailycounter.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dailycounter.helper.SharedPreferencesHelper;

public class HomeViewModel extends ViewModel {

    private static final String incomingCountKey = "incomingCount";
    private static final String outgoingCountKey = "outgoingCount";

    private MutableLiveData<String> mText;
    private MutableLiveData<String> incomingCount;
    private MutableLiveData<String> outgoingCount;
    private SharedPreferencesHelper prefHelper = new SharedPreferencesHelper();

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Welcome to Daily Counter");

        //read incoming count from shared preferences
        incomingCount = new MutableLiveData<>();
        incomingCount.setValue(Integer.toString(prefHelper.getIntegerValue(incomingCountKey)));

        //read outgoing count from shared preferences
        outgoingCount = new MutableLiveData<>();
        outgoingCount.setValue(Integer.toString(prefHelper.getIntegerValue(outgoingCountKey)));
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<String> getIncomingCount() {
        return incomingCount;
    }

    public LiveData<String> getOutgoingCount() { return outgoingCount; }

    public void addIncomingCount()
    {
        int value = prefHelper.getIntegerValue(incomingCountKey)+1;
        incomingCount.setValue(Integer.toString(value));
        prefHelper.putIntegerValue(incomingCountKey, value);
    }

    public void subtractIncomingCount()
    {
        int value = prefHelper.getIntegerValue(incomingCountKey);
        if(value>0) {
            value--;
        }
        incomingCount.setValue(Integer.toString(value));
        prefHelper.putIntegerValue(incomingCountKey, value);

    }

    public void addOutgoingCount()
    {
        int value = prefHelper.getIntegerValue(outgoingCountKey)+1;
        outgoingCount.setValue(Integer.toString(value));
        prefHelper.putIntegerValue(outgoingCountKey, value);
    }

    public void subtractOutgoingCount() {
        int value = prefHelper.getIntegerValue(outgoingCountKey);
        if (value > 0) {
            value--;
        }
        outgoingCount.setValue(Integer.toString(value));
        prefHelper.putIntegerValue(outgoingCountKey, value);
    }
}
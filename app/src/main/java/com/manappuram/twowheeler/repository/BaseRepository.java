package com.manappuram.twowheeler.repository;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;



import com.manappuram.twowheeler.response.BaseResponse;
import com.manappuram.twowheeler.utils.Event;

public class BaseRepository {
    public MutableLiveData<Event<BaseResponse>> errorsMutable;
    public MutableLiveData<Lifecycle.Event> errorData;
    public MutableLiveData<Event<String>> failMessageMutable;

    @FunctionalInterface
    public interface SuccessResponse<T> {
        void onResponse(T t);
    }

    public BaseRepository() {
        errorsMutable = new MutableLiveData<>();
        failMessageMutable = new MutableLiveData<>();
        errorData = new MutableLiveData<>();
    }

    public MutableLiveData<Event<BaseResponse>> getErrorsMutable() {
        return errorsMutable;
    }

    public MutableLiveData<Event<String>> getFailMessageMutable() {
        return failMessageMutable;
    }
}

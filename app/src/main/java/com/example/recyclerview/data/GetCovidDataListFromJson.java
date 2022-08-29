package com.example.recyclerview.data;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class GetCovidDataListFromJson implements GetCountryCovidDataListUseCase {

    private final String TAG = "Get Covida Data List";
    private final String filePath = "covid_all.json";

    public List<CountryCovidData> execute(Context appContext) {
        String jsonFileString = JsonReader.jsonToString(appContext, filePath);
        Log.i(TAG, jsonFileString);
        Gson gson = new Gson();
        Type dataType = new TypeToken<List<CountryCovidData>>() { }.getType();
        List<CountryCovidData> data = gson.fromJson(jsonFileString, dataType);
        return data;
    }
}

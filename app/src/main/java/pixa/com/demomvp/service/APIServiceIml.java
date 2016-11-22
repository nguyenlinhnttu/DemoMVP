package pixa.com.demomvp.service;

import android.util.Log;

import org.json.JSONArray;

import okhttp3.ResponseBody;
import pixa.com.demomvp.presenter.FetchData;
import pixa.com.demomvp.presenter.FetchDataCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LynkMieu on 11/22/2016.
 */

public class APIServiceIml implements FetchData{
    String TAG = APIServiceIml.class.getSimpleName();
    APIService apiService;

    @Override
    public void getAllProduct(final FetchDataCallback dataCallback) {
        apiService = APIService.retrofit.create(APIService.class);
        Call<ResponseBody> getProduct = apiService.getAllProduct();
        getProduct.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONArray obj = new JSONArray(response.body().string());
                    dataCallback.onFetchSuccess(obj);
                } catch (Exception e) {
                    dataCallback.onFetchFault(e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, t.toString());
                dataCallback.onFetchFault(new Exception(t));
            }
        });
    }
}

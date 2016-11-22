package pixa.com.demomvp.service;

import okhttp3.ResponseBody;
import pixa.com.demomvp.util.Config;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by LynkMieu on 11/22/2016.
 */

public interface APIService {

    @GET("getallproducts.php")
    Call<ResponseBody> getAllProduct ();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Config.URL_PRODUCT)
    .addConverterFactory(GsonConverterFactory.create())
            .build();
}

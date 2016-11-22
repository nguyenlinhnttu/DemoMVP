package pixa.com.demomvp.presenter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pixa.com.demomvp.adapter.ProductAdapter;
import pixa.com.demomvp.model.Products;
import pixa.com.demomvp.service.APIServiceIml;

/**
 * Created by LynkMieu on 11/22/2016.
 */

public class MainPresenter extends BasePresenter{
    String TAG = MainPresenter.class.getSimpleName();
    private RecyclerView.LayoutManager layoutManager;
    private ProductAdapter productAdapter;
    private List<Products> productsList;
    APIServiceIml apiServiceIml;

    public MainPresenter(Context context, RecyclerView recyclerView) {
        super(context);
        apiServiceIml = new APIServiceIml();
        layoutManager = new GridLayoutManager(context,2);
        recyclerView.setLayoutManager(layoutManager);
        productsList = new ArrayList<>();
        productAdapter = new ProductAdapter(productsList,context);
        recyclerView.setAdapter(productAdapter);
    }

    /**
     * parse data
     * Noti adapter
     * */
    public void fetchData() {
        productsList.clear();
        FetchDataCallback dataCallback = new FetchDataCallback() {
            @Override
            public void onFetchSuccess(JSONArray data) {
                try {
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject jsonObject = data.getJSONObject(i);
                        Products products = new Products();
                        products.setIdProduct(jsonObject.getInt("id_product"));
                        products.setProductName(jsonObject.getString("product_name"));
                        products.setDecription(jsonObject.getString("decription"));
                        products.setPrice(jsonObject.getString("price"));
                        products.setThumnail(jsonObject.getString("thumnail"));
                        productsList.add(products);
                    }
                    productAdapter.notifyDataSetChanged();
                } catch (Exception ex) {
                    Log.e(TAG, ex.toString());
                }
            }

            @Override
            public void onFetchFault(Exception e) {
                Log.e(TAG, e.toString());
            }
        };
        //Call method getAllProduct in API
        apiServiceIml.getAllProduct(dataCallback);
    }
}

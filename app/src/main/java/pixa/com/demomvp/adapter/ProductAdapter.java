package pixa.com.demomvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pixa.com.demomvp.R;
import pixa.com.demomvp.model.Products;

/**
 * Created by LynkMieu on 11/22/2016.
 */

public class ProductAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Products> listProduct;
    private Context context;

    public ProductAdapter(List<Products> listProduct ,Context context) {
        this.listProduct = listProduct;
        this.context  = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Products products = listProduct.get(position);
        holder.txtName.setText(products.getProductName());
        Glide.with(context).load(products.getThumnail())
                .override(150,150)
                .centerCrop()
                .into(holder.imgThumnal);
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.img_Thumnail)
    ImageView imgThumnal;
    @BindView(R.id.tv_Name)
    TextView txtName;
    public ViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}

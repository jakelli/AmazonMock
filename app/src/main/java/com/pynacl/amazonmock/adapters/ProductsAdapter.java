package com.pynacl.amazonmock.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pynacl.amazonmock.IMainActivity;
import com.pynacl.amazonmock.R;
import com.pynacl.amazonmock.databinding.ProductItemBinding;
import com.pynacl.amazonmock.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends  RecyclerView.Adapter<ProductsAdapter.BindingHolder>{

    private static final String TAG = "ProductsAdapter";

    private List<Product> mProducts = new ArrayList<>();
    private Context mContext;


    public ProductsAdapter(Context context, List<Product> products) {
        mProducts = products;
        mContext = context;
    }

    public void refreshList(List<Product> products){
        mProducts.clear();
        mProducts.addAll(products);
        notifyDataSetChanged();
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        ViewDataBinding binding = DataBindingUtil.inflate(
//                LayoutInflater.from(mContext), R.layout.product_item, parent, false);
        ProductItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext), R.layout.product_item, parent, false);

        return new BindingHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        Product product = mProducts.get(position);
        holder.binding.setProduct(product);
//        holder.binding.setVariable(BR.product, product);
	    holder.binding.setIMainActivity((IMainActivity) mContext);
        holder.binding.executePendingBindings();
    }

	@Override
	public void onAttachedToRecyclerView(RecyclerView recyclerView) {
		super.onAttachedToRecyclerView(recyclerView);
	}

	@Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class BindingHolder extends RecyclerView.ViewHolder{

//        ViewDataBinding binding;
        ProductItemBinding binding;

        public BindingHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

}













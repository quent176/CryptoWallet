package fr.wcs.cryptowallet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListCoinAdapter extends RecyclerView.Adapter<ListCoinAdapter.MyViewHolder> {

    private Context mContext;
    private List<CoinListModel> mItem;

    public ListCoinAdapter (List<CoinListModel> item, Context context){
        this.mItem = item;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_coin, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.display(mItem.get(position));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mShortNameCoin, mLongNameCoin, mPriceCoin;

        public MyViewHolder(View itemView) {
            super(itemView);

            mShortNameCoin = itemView.findViewById(R.id.coin_shortname_list);
            mLongNameCoin = itemView.findViewById(R.id.coin_longname_list);
            mPriceCoin = itemView.findViewById(R.id.coin_price_list);
        }

        public void display(CoinListModel coinListModel) {
            mShortNameCoin.setText(coinListModel.getShortNameCoin());
            mLongNameCoin.setText(coinListModel.getLongNameCoin());
            mPriceCoin.setText(coinListModel.getActualValueCoin());
        }
    }
}

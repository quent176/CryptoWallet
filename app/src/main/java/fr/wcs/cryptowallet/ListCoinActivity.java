package fr.wcs.cryptowallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListCoinActivity extends AppCompatActivity {

   // List<CoinJsonModel> mCoinListModelList = new ArrayList<>();
    String url = "https://api.coinmarketcap.com/v1/ticker/";
    ListCoinAdapter mListCoinAdapter;
    List<CoinJsonModel> mListCoinsMarket = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_coin);

        RecyclerView recyclerView = findViewById(R.id.recycler_list);
        mListCoinAdapter = new ListCoinAdapter(mListCoinsMarket, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mListCoinAdapter);

        JsonListController jsonListController = new JsonListController(getApplicationContext());
        jsonListController.fillRecycler(new JsonListController.JsonListener() {
            @Override
            public void onResult(List<CoinJsonModel> coinJsonModelList) {
                mListCoinsMarket.clear(); // clear existing items if needed
                mListCoinsMarket.addAll(coinJsonModelList); // add new items
                mListCoinAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError() {

            }
        });
    }
}

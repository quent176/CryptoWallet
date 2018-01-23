package fr.wcs.cryptowallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListCoinActivity extends AppCompatActivity {

    List<CoinListModel> mCoinListModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_coin);

        mCoinListModelList.add(new CoinListModel("btc","bitcoin","134,23","empty"));
        mCoinListModelList.add(new CoinListModel("btc","bitcoin","134,23","empty"));

        RecyclerView recyclerView = findViewById(R.id.recycler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListCoinAdapter(mCoinListModelList, this));

    }
}

package fr.wcs.cryptowallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsCoinActivity extends AppCompatActivity {

    TextView mShortNameCoin, mLongNameCoin, mPriceCoin;
    CoinListModel mCoinListModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_coin);

        //récupération de l'objet via Intent
        mCoinListModel = getIntent().getExtras().getParcelable("ThisCoin");

        mShortNameCoin = findViewById(R.id.shortname_coin_details);
        mLongNameCoin = findViewById(R.id.longname_coin_details);

        mShortNameCoin.setText(mCoinListModel.getShortNameCoin());
        mLongNameCoin.setText(mCoinListModel.getLongNameCoin());

    }
}

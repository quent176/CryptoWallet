package fr.wcs.cryptowallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailsCoinActivity extends AppCompatActivity {

    TextView mShortNameCoin, mLongNameCoin, mPriceCoin;
    CoinListModel mCoinListModel;
    String url = "https://api.coinmarketcap.com/v1/ticker/";

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

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        // Initialize a new JsonArrayRequest instance
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                    Log.d("nickname", response.toString());
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                Log.d("CACA", "onResponse: " + object.toString(2));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("LOG", error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}

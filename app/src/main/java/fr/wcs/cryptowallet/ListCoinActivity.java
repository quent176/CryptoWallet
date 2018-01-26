package fr.wcs.cryptowallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

import java.util.ArrayList;
import java.util.List;

public class ListCoinActivity extends AppCompatActivity {

   // List<CoinJsonModel> mCoinListModelList = new ArrayList<>();
    String url = "https://api.coinmarketcap.com/v1/ticker/";
    ListCoinAdapter mListCoinAdapter;
    List<CoinJsonModel> ListCoinsMarket = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_coin);

       // mCoinListModelList.add(new CoinListModel("btc","bitcoin","134,23","empty"));
        // mCoinListModelList.add(new CoinListModel("btc","bitcoin","134,23","empty"));

        RecyclerView recyclerView = findViewById(R.id.recycler_list);
        mListCoinAdapter = new ListCoinAdapter(ListCoinsMarket, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListCoinAdapter(ListCoinsMarket, this));

        fillRecycler();
    }

    public void fillRecycler(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        // Initialize a new JsonArrayRequest instance
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //JSONArray businessesJson = response.getJSONArray();
                // Now we have an array of business objects
                // Might now create an adapter BusinessArrayAdapter<Business> to load the businesses into a list
                // You might also simply update the data in an existing array and then notify the adapter
                ListCoinsMarket.clear(); // clear existing items if needed
                ListCoinsMarket.addAll(CoinJsonModel.fromJson(response)); // add new items
                mListCoinAdapter.updatelist(ListCoinsMarket);
                mListCoinAdapter.notifyDataSetChanged();

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

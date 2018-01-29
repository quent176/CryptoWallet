package fr.wcs.cryptowallet;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class JsonActivity {

    String url = "https://api.coinmarketcap.com/v1/ticker/";
    Context mContext;

    public JsonActivity (Context context) {
        this.mContext = context;
    }

    public void fillRecycler(final JsonListener jsonListener){
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        // Initialize a new JsonArrayRequest instance
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //JSONArray businessesJson = response.getJSONArray();
                // Now we have an array of business objects
                // Might now create an adapter BusinessArrayAdapter<Business> to load the businesses into a list
                // You might also simply update the data in an existing array and then notify the adapter

               // mListCoinsMarket.addAll(CoinJsonModel.fromJson(response)); // add new items

                jsonListener.onResult(CoinJsonModel.fromJson(response));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("LOG", error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    public interface JsonListener{
        void onResult (List<CoinJsonModel> coinJsonModelList);
        void onError ();
    }

}

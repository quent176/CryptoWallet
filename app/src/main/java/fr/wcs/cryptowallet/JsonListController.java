package fr.wcs.cryptowallet;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.List;

public class JsonListController {

    private String mUrl = "https://api.coinmarketcap.com/v1/ticker/";
    private Context mContext;

    public JsonListController(Context context) {
        this.mContext = context;
    }

    public void fillRecycler(final JsonListener jsonListener){
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        // Initialize a new JsonArrayRequest instance
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, mUrl,null, new Response.Listener<JSONArray>() {
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

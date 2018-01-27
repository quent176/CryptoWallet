package fr.wcs.cryptowallet;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CoinJsonModel implements Parcelable {

    private String symbol;

    private String available_supply;

    private String percent_change_1h;

    private String price_usd;

    private String price_btc;

    private String id;

    private String total_supply;

    private String percent_change_24h;

    private String max_supply;

    private String rank;

    private String name;

    private String last_updated;

    private String percent_change_7d;

    private String market_cap_usd;

    public CoinJsonModel() {

    }

    public String getSymbol ()
    {
        return symbol;
    }

    public void setSymbol (String symbol)
    {
        this.symbol = symbol;
    }

    public String getAvailable_supply ()
    {
        return available_supply;
    }

    public void setAvailable_supply (String available_supply)
    {
        this.available_supply = available_supply;
    }

    public String getPercent_change_1h ()
    {
        return percent_change_1h;
    }

    public void setPercent_change_1h (String percent_change_1h)
    {
        this.percent_change_1h = percent_change_1h;
    }

    public String getPrice_usd ()
    {
        return price_usd;
    }

    public void setPrice_usd (String price_usd)
    {
        this.price_usd = price_usd;
    }

    public String getPrice_btc ()
    {
        return price_btc;
    }

    public void setPrice_btc (String price_btc)
    {
        this.price_btc = price_btc;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTotal_supply ()
    {
        return total_supply;
    }

    public void setTotal_supply (String total_supply)
    {
        this.total_supply = total_supply;
    }

    public String getPercent_change_24h ()
    {
        return percent_change_24h;
    }

    public void setPercent_change_24h (String percent_change_24h)
    {
        this.percent_change_24h = percent_change_24h;
    }

    public String getMax_supply ()
    {
        return max_supply;
    }

    public void setMax_supply (String max_supply)
    {
        this.max_supply = max_supply;
    }

    public String getRank ()
    {
        return rank;
    }

    public void setRank (String rank)
    {
        this.rank = rank;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getLast_updated ()
    {
        return last_updated;
    }

    public void setLast_updated (String last_updated)
    {
        this.last_updated = last_updated;
    }

    public String getPercent_change_7d ()
    {
        return percent_change_7d;
    }

    public void setPercent_change_7d (String percent_change_7d)
    {
        this.percent_change_7d = percent_change_7d;
    }

    public String getMarket_cap_usd ()
    {
        return market_cap_usd;
    }

    public void setMarket_cap_usd (String market_cap_usd)
    {
        this.market_cap_usd = market_cap_usd;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [symbol = "+symbol+", available_supply = "+available_supply+", percent_change_1h = "+percent_change_1h+", price_usd = "+price_usd+", price_btc = "+price_btc+", id = "+id+", total_supply = "+total_supply+", percent_change_24h = "+percent_change_24h+", max_supply = "+max_supply+", rank = "+rank+", name = "+name+", last_updated = "+last_updated+", percent_change_7d = "+percent_change_7d+", market_cap_usd = "+market_cap_usd+"]";
    }

    public static CoinJsonModel fromJson(JSONObject jsonObject) {
        CoinJsonModel coinJsonModel = new CoinJsonModel();
        // Deserialize json into object fields
        try {
            coinJsonModel.id = jsonObject.getString("id");
            coinJsonModel.name = jsonObject.getString("name");
            coinJsonModel.symbol = jsonObject.getString("symbol");
            coinJsonModel.rank = jsonObject.getString("rank");
            coinJsonModel.price_usd = jsonObject.getString("price_usd");
            coinJsonModel.price_btc = jsonObject.getString("price_btc");
            coinJsonModel.market_cap_usd = jsonObject.getString("market_cap_usd");
            coinJsonModel.available_supply = jsonObject.getString("available_supply");
            coinJsonModel.total_supply = jsonObject.getString("total_supply");
            coinJsonModel.max_supply = jsonObject.getString("max_supply");
            coinJsonModel.percent_change_1h = jsonObject.getString("percent_change_1h");
            coinJsonModel.percent_change_24h = jsonObject.getString("percent_change_24h");
            coinJsonModel.percent_change_7d = jsonObject.getString("percent_change_7d");
            coinJsonModel.last_updated = jsonObject.getString("last_updated");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return coinJsonModel;
    }

    public static ArrayList<CoinJsonModel> fromJson(JSONArray jsonArray) {
        JSONObject CoinMarketJson;
        ArrayList<CoinJsonModel> listCoins = new ArrayList<CoinJsonModel>(jsonArray.length());
        // Process each result in json array, decode and convert to business object
        for (int i=0; i < jsonArray.length(); i++) {
            try {
                CoinMarketJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            CoinJsonModel coinJsonModel = CoinJsonModel.fromJson(CoinMarketJson);
            if (coinJsonModel != null) {
                listCoins.add(coinJsonModel);
            }
        }

        return listCoins;
    }

    protected CoinJsonModel(Parcel in) {
        symbol = in.readString();
        available_supply = in.readString();
        percent_change_1h = in.readString();
        price_usd = in.readString();
        price_btc = in.readString();
        id = in.readString();
        total_supply = in.readString();
        percent_change_24h = in.readString();
        max_supply = in.readString();
        rank = in.readString();
        name = in.readString();
        last_updated = in.readString();
        percent_change_7d = in.readString();
        market_cap_usd = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(symbol);
        dest.writeString(available_supply);
        dest.writeString(percent_change_1h);
        dest.writeString(price_usd);
        dest.writeString(price_btc);
        dest.writeString(id);
        dest.writeString(total_supply);
        dest.writeString(percent_change_24h);
        dest.writeString(max_supply);
        dest.writeString(rank);
        dest.writeString(name);
        dest.writeString(last_updated);
        dest.writeString(percent_change_7d);
        dest.writeString(market_cap_usd);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CoinJsonModel> CREATOR = new Parcelable.Creator<CoinJsonModel>() {
        @Override
        public CoinJsonModel createFromParcel(Parcel in) {
            return new CoinJsonModel(in);
        }

        @Override
        public CoinJsonModel[] newArray(int size) {
            return new CoinJsonModel[size];
        }
    };
}
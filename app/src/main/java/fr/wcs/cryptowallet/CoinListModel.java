package fr.wcs.cryptowallet;

import android.os.Parcel;
import android.os.Parcelable;

public class CoinListModel implements Parcelable {

    private String shortNameCoin;
    private String longNameCoin;
    private String actualValueCoin;
    private String photoURLCoin;

    public CoinListModel(String shortNameCoin, String longNameCoin, String actualValueCoin, String photoURLCoin) {
        this.shortNameCoin = shortNameCoin;
        this.longNameCoin = longNameCoin;
        this.actualValueCoin = actualValueCoin;
        this.photoURLCoin = photoURLCoin;
    }

    public CoinListModel(){
        //For Firebase
    }

    public String getShortNameCoin() {
        return shortNameCoin;
    }

    public void setShortNameCoin(String shortNameCoin) {
        this.shortNameCoin = shortNameCoin;
    }

    public String getLongNameCoin() {
        return longNameCoin;
    }

    public void setLongNameCoin(String longNameCoin) {
        this.longNameCoin = longNameCoin;
    }

    public String getActualValueCoin() {
        return actualValueCoin;
    }

    public void setActualValueCoin(String actualValueCoin) {
        this.actualValueCoin = actualValueCoin;
    }

    public String getPhotoURLCoin() {
        return photoURLCoin;
    }

    public void setPhotoURLCoin(String photoURLCoin) {
        this.photoURLCoin = photoURLCoin;
    }


    protected CoinListModel(Parcel in) {
        shortNameCoin = in.readString();
        longNameCoin = in.readString();
        actualValueCoin = in.readString();
        photoURLCoin = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(shortNameCoin);
        dest.writeString(longNameCoin);
        dest.writeString(actualValueCoin);
        dest.writeString(photoURLCoin);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CoinListModel> CREATOR = new Parcelable.Creator<CoinListModel>() {
        @Override
        public CoinListModel createFromParcel(Parcel in) {
            return new CoinListModel(in);
        }

        @Override
        public CoinListModel[] newArray(int size) {
            return new CoinListModel[size];
        }
    };
}
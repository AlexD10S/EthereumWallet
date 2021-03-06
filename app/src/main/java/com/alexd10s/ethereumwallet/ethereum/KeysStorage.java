package com.alexd10s.ethereumwallet.ethereum;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Pair;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by alex on 24/08/2018.
 */

public class KeysStorage {

    private Context cntx;
    private final String MY_PREFS_NAME = "ETH_KEYS";

    public KeysStorage(Context context){
        cntx = context;
    }

    public void storeKeys(Pair<String,String> keys){
        SharedPreferences.Editor editor = cntx.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("publicKey", keys.first);
        editor.putString("privateKey", keys.second);
        editor.apply();

    }

    public Pair<String,String> retrieveKeys(){
        SharedPreferences prefs = cntx.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String publicKey = prefs.getString("publicKey", "");
        String privateKey = prefs.getString("privateKey", "");

        Pair<String,String> keys = new Pair<>(publicKey,privateKey);
        return keys;

    }

    public void deleteKeys(){
        SharedPreferences.Editor editor = cntx.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.remove("publicKey");
        editor.remove("privateKey");

        editor.commit();
    }

}

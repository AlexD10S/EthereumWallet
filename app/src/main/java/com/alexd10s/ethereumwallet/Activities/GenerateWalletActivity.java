package com.alexd10s.ethereumwallet.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alexd10s.ethereumwallet.Cryptography;
import com.alexd10s.ethereumwallet.Ethereum.EthereumHandler;
import com.alexd10s.ethereumwallet.R;

public class GenerateWalletActivity extends AppCompatActivity {

    private Button storeBtn;
    private Button cancelBtn;
    private EditText inputPublic;
    private EditText inputPrivate;
    Cryptography crypto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_wallet);

        crypto = new Cryptography(this);
        setupComponents();
        checkIntents();
    }

    private void setupComponents(){
        storeBtn = (Button) findViewById(R.id.store_keys);
        cancelBtn = (Button) findViewById(R.id.cancel_store);
        inputPublic = (EditText) findViewById(R.id.public_key_input);
        inputPrivate = (EditText) findViewById(R.id.private_key_input);

        storeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String publicKey = inputPublic.getText().toString();
                String privateKey = inputPrivate.getText().toString();
                Pair<String,String> pair = new Pair<>(publicKey,privateKey);
                crypto.storeKeys(pair);
                //TODO:Dialog
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanInputs();
                finish();
            }
        });
    }

    private void checkIntents(){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (getIntent().getStringExtra("Operation") != null) {
                String operation = getIntent().getStringExtra("Operation");

                if(operation.equals("generateKeys")){
                    EthereumHandler ethHandler = new EthereumHandler();
                    Pair<String,String> keys = ethHandler.generateWallet();
                    inputPublic.setText(keys.first);
                    inputPrivate.setText(keys.second);
                }
                else if (operation.equals("storeKeys")){

                }
                else if (operation.equals("seeKeys")){
                    storeBtn.setVisibility(View.GONE);
                    cancelBtn.setVisibility(View.GONE);
                    Pair<String,String> keys = crypto.retrieveKeys();
                    inputPublic.setText(keys.first);
                    inputPrivate.setText(keys.second);

                }
            }
        }

    }

    private void cleanInputs(){
        inputPublic.setText("");
        inputPrivate.setText("");
    }
}

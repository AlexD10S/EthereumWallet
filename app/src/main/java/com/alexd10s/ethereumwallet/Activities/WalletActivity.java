package com.alexd10s.ethereumwallet.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alexd10s.ethereumwallet.R;

public class WalletActivity extends AppCompatActivity {

    private Button generateWallet;
    private Button addKeys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        setupButtons();
    }

    private void setupButtons(){
        generateWallet = (Button) findViewById(R.id.generate_wallet);
        addKeys = (Button) findViewById(R.id.keys_ether);

        generateWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), GenerateWalletActivity.class);
                intent.putExtra("Operation", "generateKeys");
                startActivity(intent);
            }
        });

        addKeys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), GenerateWalletActivity.class);
                intent.putExtra("Operation", "storeKeys");
                startActivity(intent);
            }
        });
    }


}

package com.alexd10s.ethereumwallet.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alexd10s.ethereumwallet.R;

public class MainActivity extends AppCompatActivity {

    private Button walletBtn;
    private Button sendBtn;
    private Button receiveBtn;
    private Button buyBtn;
    private Button seeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButtons();
    }

    private void setupButtons(){
        walletBtn = (Button) findViewById(R.id.create_wallet);
        walletBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createWallet();
            }
        });

        sendBtn = (Button) findViewById(R.id.send_ether);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEther();
            }
        });

        receiveBtn = (Button) findViewById(R.id.receive_ether);
        receiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receiveEther();
            }
        });

        buyBtn = (Button) findViewById(R.id.buy_ether);
        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyEther();
            }
        });

        seeBtn = (Button) findViewById(R.id.keys_ether);
        seeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seeKeys();
            }
        });
    }


    private void createWallet(){
        Intent intent = new Intent(getBaseContext(), WalletActivity.class);
        startActivity(intent);
    }

    private void sendEther(){
        Intent intent = new Intent(getBaseContext(), SendActivity.class);
        startActivity(intent);
    }
    private void receiveEther(){
        Intent intent = new Intent(getBaseContext(), ReceiveActivity.class);
        startActivity(intent);
    }
    private void buyEther(){
        //TODO: Send 3 Ethers from my account and refresh it.
    }

    private void seeKeys(){
        Intent intent = new Intent(getBaseContext(), GenerateWalletActivity.class);
        intent.putExtra("Operation", "seeKeys");
        startActivity(intent);
    }
}

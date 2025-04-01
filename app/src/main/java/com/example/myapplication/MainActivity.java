package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity
{
    public final static String CHANNEL_ID = "mainViewID";
    Button sendNotif;
    Button redirectToBrowser;
    Button selectContact;
    Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotif = findViewById(R.id.sendNotif);
        redirectToBrowser = findViewById(R.id.redirectToSiteBrowser);
        selectContact = findViewById(R.id.selectContact);
        showDialog = findViewById(R.id.showDialog);

        sendNotif.setOnClickListener(v ->
        {
            NotificationHelper.sendNotification(1, this, this, "Nowe powiadomienie!", "Kliknij, aby otworzyć aplikację.", NotificationCompat.PRIORITY_DEFAULT);
        });

        redirectToBrowser.setOnClickListener(v ->
        {
            openWebpage("https://www.google.com");
        });

        selectContact.setOnClickListener(v ->
        {
            dialNumber();
        });

        showDialog.setOnClickListener(v ->
        {
            showDialog();
        });
    }

    private void openWebpage(String url)
    {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        try
        {
            startActivity(intent);
        } catch(Exception e)
        {

        }
    }

    private void dialNumber()
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        try
        {
            startActivity(intent);
        } catch(Exception e)
        {

        }
    }

    private void showDialog()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this)
                .setTitle("Czy chcesz zamknąć aplikację?")
                .setPositiveButton("TAK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("NIE", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.show();
    }
}
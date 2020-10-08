package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnOpenInGoogleMaps (View view) {
        EditText teamAddress = (EditText) findViewById(R.id.teamAddressField);
        Uri gmmIntentUri = Uri.parse("https://maps.google.co.in/maps?q=" + teamAddress.getText());
        Intent mapIntent = new Intent (Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void OnSetAvatarButton (View view) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;
        ImageView avatarImage = (ImageView) findViewById(R.id.logoimage);
        String drawableName = "ic_logo_00";
        switch (data.getIntExtra("imageID", R.id.logoImage00)) {
            case R.id.logoImage00:
                drawableName = "ic_logo_00";
                break;
            case R.id.logoImage01:
                drawableName = "ic_logo_01";
                break;
            case R.id.logoImage02:
                drawableName = "ic_logo_02";
                break;
            case R.id.logoImage03:
                drawableName = "ic_logo_03";
                break;
            case R.id.logoImage04:
                drawableName = "ic_logo_04";
                break;
            case R.id.logoImage05:
                drawableName = "ic_logo_05";
                break;
            default:
                drawableName = "ic_logo_00";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }
}
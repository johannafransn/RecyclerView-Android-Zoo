package edu.sjsu.android.farmzoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ZooInfo extends MenuActivity
{
    Button buttonCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_info);

      buttonCall = findViewById(R.id.phone_button);
      buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL);
                    intentCall.setData(Uri.parse("tel:8888888"));
                    startActivity(intentCall);
            }
        });
    }
}
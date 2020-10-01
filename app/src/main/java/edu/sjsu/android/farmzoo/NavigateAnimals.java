package edu.sjsu.android.farmzoo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NavigateAnimals extends MenuActivity {

    ImageView mainImageView;
    TextView title, descrip;

    String data1, data2, data3;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate_animals);

        mainImageView = findViewById(R.id.imageView);
        title = findViewById(R.id.navig_title);
        descrip = findViewById(R.id.navig_descrip);

        getData();
        setData();
    }

    private void getData()
    {
        //only if these data values exist we can execute
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1")
                && getIntent().hasExtra("data2"))
        {
            data1 = getIntent().getStringExtra("data1");
            data3 = getIntent().getStringExtra("data3");
            myImage = getIntent().getIntExtra("myImage", 1);
        }
        else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        title.setText(data1);
        descrip.setText(data3);
        mainImageView.setImageResource(myImage);
    }
}
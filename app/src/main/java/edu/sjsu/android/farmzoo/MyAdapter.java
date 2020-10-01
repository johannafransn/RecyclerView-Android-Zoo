package edu.sjsu.android.farmzoo;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    //new variables to hold our values which we will pass inside main activity
    String data1[], data2[], data3[];
    int images[];
    Context context;
    Dialog myDialogLastAnimal;

    public MyAdapter(Context ct, String s1[], String s2[], String s3[], int img[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        //Dynamically add values into recyclerview
        holder.title.setText(data1[position]);
        holder.descrip.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);
        //Set onclick listener for the main layout
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //If the position is the last animal, show pop up dialog
                if(data1[position].equals("Goat"))
                {
                    new AlertDialog.Builder(context)
                            .setTitle("Warning")
                            .setMessage("Greta the Goat has babies right now, are you sure you want to go in?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    Intent intent = new Intent(context, NavigateAnimals.class);
                                    intent.putExtra("data1", data1[position]);
                                    intent.putExtra("data2", data2[position]);
                                    intent.putExtra("data3", data3[position]);
                                    intent.putExtra("myImage", images[position]);
                                    context.startActivity(intent);
                                }
                            })
                            .setNegativeButton(android.R.string.no, null).show();
                }
                else {
                    Intent intent = new Intent(context, NavigateAnimals.class);
                    //Pass in 3 values, title, description, image
                    intent.putExtra("data1", data1[position]);
                    intent.putExtra("data2", data2[position]);
                    intent.putExtra("data3", data3[position]);
                    intent.putExtra("myImage", images[position]);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        //get dynamical array length
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView title, descrip, descripLong;
        ImageView myImage;
        ConstraintLayout mainLayout;
        LinearLayout warning_lastanimal;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //Find ids
            title = itemView.findViewById(R.id.animal_title);
            descrip = itemView.findViewById(R.id.animal_descrip);
            descripLong = itemView.findViewById(R.id.navig_descrip);
            myImage = itemView.findViewById(R.id.icon);
            mainLayout = itemView.findViewById(R.id.mainLayout);
           // warning_lastanimal = itemView.findViewById()
        }
    }
}

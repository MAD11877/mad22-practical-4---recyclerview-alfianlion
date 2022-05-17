package sg.edu.np.mad.exercise_2;

import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgViewHolder> {

    ArrayList<MainActivity.User> data;
    ListActivity nav;

    public MsgAdapter(ArrayList<MainActivity.User> data, ListActivity listActivity){
        this.data = data;
    }

    @NonNull
    @Override
    public MsgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_holder, null, false);

        Log.d("P02","OnCreate");
        return new MsgViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MsgViewHolder holder, int position) {
        String s = data.get(position).name;
        String d = data.get(position).description;
        int id = data.get(position).id;
        Boolean b = data.get(position).followed;
        holder.txt.setText(s);
        holder.desc.setText(d);
        Log.d("String Name", s + " " + position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Profile").setMessage(s);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent newIntent =  new Intent(view.getContext(), MainActivity.class);
                        newIntent.putExtra("name", s);
                        newIntent.putExtra("desc", d);
                        newIntent.putExtra("id", id);
                        newIntent.putExtra("followed",b);
                        (view.getContext()).startActivity(newIntent);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}

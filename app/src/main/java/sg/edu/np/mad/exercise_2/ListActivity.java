package sg.edu.np.mad.exercise_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<MainActivity.User> userList = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            String name = "Name";
            String desc = "Description";
            boolean followed = true;

            int randomNumName = new Random().nextInt(99999);
            int randomNumDesc = new Random().nextInt(99999);

            name = name + randomNumName;
            desc = desc + randomNumDesc;

            MainActivity.User newUser = new MainActivity.User(name,desc,i,followed);
            userList.add(newUser);
        }

        RecyclerView viewlist = (RecyclerView) findViewById(R.id.listRecycle);
        MsgAdapter adapter = new MsgAdapter(userList, ListActivity.this);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        viewlist.setLayoutManager(layout);
        viewlist.setAdapter(adapter);

//        viewlist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
//                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Intent newIntent =  new Intent(ListActivity.this, MainActivity.class);
//                        newIntent.putExtra("name", userList.get(i).name);
//                        newIntent.putExtra("desc", userList.get(i).description);
//                        startActivity(newIntent);
//                    }
//                });
//                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//                builder.show();
//            }
//        });
//        ImageView listButton = (ImageView) findViewById(R.id.listView);
//
//        listButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
//                builder.setTitle("Profile")
//                .setMessage("MADness");
//                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        double randomNumber = Math.random();
//                        Intent newIntent =  new Intent(ListActivity.this, MainActivity.class);
//                        newIntent.putExtra("randomNumber",randomNumber);
//                        startActivity(newIntent);
//                    }
//                });
//                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//                builder.show();
//            }
//        });
    }
}
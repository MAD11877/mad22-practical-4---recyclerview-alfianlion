package sg.edu.np.mad.exercise_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.lang.UProperty;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    static class User {
        String name = "";
        String description = "";
        Integer id = 0;
        Boolean followed = false;

        public User(String n, String d, Integer idc, Boolean f){
            name = n;
            description = d;
            id = idc;
            followed = f;
        }
    }

    private String Tag = "Main Activity";
    final String[] words = {"Unfollow", "Follow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receivingIntent = getIntent();
        String intentName = receivingIntent.getStringExtra("name");
        String intentDesc = receivingIntent.getStringExtra("desc");
        Integer intentId = receivingIntent.getIntExtra("id", 0);
        Boolean intentFollowed = receivingIntent.getBooleanExtra("followed",true);
        User initUser = new User(intentName, intentDesc, intentId, intentFollowed);

        TextView displayTxt = (TextView)findViewById(R.id.textView2);
        displayTxt.setText(intentName);

        Button followButton = (Button)findViewById(R.id.followButton);
        if (initUser.followed == true){
            followButton.setText(words[1]);
        } else {
            followButton.setText(words[0]);
        }

        Button messageButton = (Button)findViewById(R.id.messageButton);

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (initUser.followed == true){
                    initUser.followed = false;
                    followButton.setText(words[0]);
                    Log.v(Tag, "Status change to Unfollow = " + initUser.followed);
                    Toast.makeText(MainActivity.this, words[0], Toast.LENGTH_SHORT).show();
                } else {
                    initUser.followed = true;
                    followButton.setText(words[1]);
                    Log.v(Tag, "Status change to Follow = " + initUser.followed);
                    Toast.makeText(MainActivity.this, words[1], Toast.LENGTH_SHORT).show();

                }
            }
        });
//        public void changeText(View button){
//            if (initUser.followed == false ){
//                initUser.followed = true;
//                followButton.setText("Follow");
//            } else {
//                initUser.followed = true;
//                followButton.setText("Unfollow");
//            }
//        }
    }




}
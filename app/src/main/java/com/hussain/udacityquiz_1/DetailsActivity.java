package com.hussain.udacityquiz_1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.hussain.udacityquiz_1.MainActivity.MyPREFERENCES;

public class DetailsActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView mUserNameDisplay = findViewById(R.id.userNameDisplay);
        TextView mEmailDisplay = findViewById(R.id.userEmailDisplay);
        TextView mAboutDisplay = findViewById(R.id.userAboutDisplay);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
            String uName = sharedPreferences.getString("username", null);
            String eMail = sharedPreferences.getString("email", null);
            String aUser = sharedPreferences.getString("aboutUser", null);
        mUserNameDisplay.setText(uName);
        mEmailDisplay.setText(eMail);
        mAboutDisplay.setText(aUser);
    }
}

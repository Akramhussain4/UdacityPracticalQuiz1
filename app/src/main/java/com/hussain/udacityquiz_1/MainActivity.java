package com.hussain.udacityquiz_1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    private String userName, email, aboutUser;
    private SharedPreferences sharedPreferences;
    private EditText mUserName,mEmail,mAboutUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserName = findViewById(R.id.userName);
        mEmail = findViewById(R.id.Email);
        mAboutUser = findViewById(R.id.aboutUser);
        if (savedInstanceState != null) {
            mUserName.setText(savedInstanceState.getString("username"));
            mEmail.setText(savedInstanceState.getString("email"));
            mAboutUser.setText(savedInstanceState.getString("about"));
        }
        sharedPreferences = getApplicationContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }

    public void detailsActivity(View view) {
        userName = mUserName.getText().toString();
        email = mEmail.getText().toString();
        aboutUser = mAboutUser.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username",userName);
        editor.putString("email", email);
        editor.putString("aboutUser", aboutUser);
        editor.apply();
        mUserName.setText("");
        mEmail.setText("");
        mAboutUser.setText("");
        Intent intent = new Intent(this,DetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("username",userName);
        outState.putString("email",email);
        outState.putString("about",aboutUser);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.userDetails) {
            Intent intent = new Intent(this, DetailsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

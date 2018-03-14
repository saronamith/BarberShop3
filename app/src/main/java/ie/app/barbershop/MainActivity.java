package ie.app.barbershop;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.util.Log;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {


    private Button loginButton;
    private Button registerNowButton;
    private SharedPreferences settings;
    private boolean mIsBackButtonPressed;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settings = getSharedPreferences("login", 0);
        if (settings.getBoolean("loggedIn", false))
            startHomeScreen();

        setContentView(R.layout.activity_main);


        Button btn1 = (Button) findViewById(R.id.loginButton);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Landing.class));
            }
        });


        Button btn = (Button) findViewById(R.id.registerNowButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }

        });

    }



    public void register(View v) {
        startActivity(new Intent(this, Register.class));
    }






    private void startHomeScreen() {

        Intent intent = new Intent(MainActivity.this, Landing.class);
        MainActivity.this.startActivity(intent);


        public void loginButtonPressed (View view)
            {
                Log.v("Login", "Logged In");
            }

        public void registerButtonPressed (View view)
            {
                Log.v("Register", "Registered Now");
            }




    public void login(View v) {

        CharSequence username = ((TextView) findViewById(R.id.userName))
                .getText();

        CharSequence password = ((TextView) findViewById(R.id.passWord))
                .getText();

        String validUsername = settings.getString("username", "");
        String validPassword = settings.getString("password", "");

        if (username.length() <= 0 || password.length() <= 0)
            Toast.makeText(this, "You must enter a valid email & password",
                    Toast.LENGTH_SHORT).show();

        else if (!username.toString().matches(validUsername)
                || !password.toString().matches(validPassword))
            Toast.makeText(this, "Unable to validate your email & password",
                    Toast.LENGTH_SHORT).show();

        else if (!mIsBackButtonPressed) {

            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("loggedin", true);
            editor.commit();

            startHomeScreen();
            this.finish();




        }
    }


    //Action Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //When user clicks contact us they are brought to the contact us page
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.contactUs:
                startActivity(new Intent(this, ContactUs.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public boolean onOptionsItemsSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}

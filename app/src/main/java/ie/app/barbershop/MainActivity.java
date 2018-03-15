package ie.app.barbershop;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.util.Log;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText passWordEditText;
    private EditText userNameEditText;
    private Button loginButton;
    private Button registerNowButton;
    private SharedPreferences settings;
    public boolean mIsBackButtonPressed;

    public void onCreate(Bundle savedInstanceState) {

        redirectToHomeIfAllowed();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.userNameEditText);
        passWordEditText = findViewById(R.id.passWordEditText);
        registerNowButton = findViewById(R.id.registerNowButton);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                userNameEditText.getText();
                passWordEditText.getText();
                startActivity(new Intent(MainActivity.this, Landing.class));
            }

        });

        registerNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }

        });

    }

    public void redirectToHomeIfAllowed() {

        settings = getSharedPreferences("login", 0);

        if (settings.getBoolean("loggedin", false))
            startHomeScreen();

    }

    public void register(View v) {

        startActivity(new Intent(this, Register.class));
    }

    private void startHomeScreen() {

        Intent intent = new Intent(MainActivity.this, Landing.class);
        MainActivity.this.startActivity(intent);
    }

    public void loginButtonPressed(View view) {
        Log.v("Login", "Logged In");

    }

    public void registerButtonPressed(View view) {
        Log.v("Register", "Registered Now");
    }


    public void login(View v) {

        CharSequence username = ((EditText) findViewById(R.id.userNameEditText)).getText();
        CharSequence password = ((EditText) findViewById(R.id.passWordEditText)).getText();
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
            case R.id.contactUs:startActivity
                (new Intent(this,
                        ContactUs.class));break;}
        return super.onOptionsItemSelected(item);
    }


    public boolean onOptionsItemsSelected(MenuItem item) {
        int id = item.getItemId();
                if (id == R.id.action_settings)
                {return true;}
                return super.onOptionsItemSelected(item);
    }

}


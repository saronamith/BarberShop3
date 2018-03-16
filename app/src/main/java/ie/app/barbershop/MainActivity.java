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
    private SharedPreferences sharedPreferences;
    public boolean accessGranted;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.userNameEditText);
        passWordEditText = findViewById(R.id.passWordEditText);
        registerNowButton = findViewById(R.id.registerNowButton);
        loginButton = findViewById(R.id.loginButton);
        sharedPreferences = getSharedPreferences("login", 0);
        redirectToHomeIfAllowed();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
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

        if (sharedPreferences.getBoolean("loggedin", false)){
            startHomeScreen();
        }
    }

    public void register(View v) {
        startActivity(new Intent(this, Register.class));
    }

    private void startHomeScreen() {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        MainActivity.this.startActivity(intent);
    }

    public void login() {
        String username = userNameEditText.toString();
        String password = passWordEditText.toString();

        String validUsername = sharedPreferences.getString("username", "");
        String validPassword = sharedPreferences.getString("password", "");

        if (username.isEmpty() || password.isEmpty() )
            Toast.makeText(this, "You must enter a valid email & password", Toast.LENGTH_SHORT).show();
        else if (!userNameEditText.toString().matches(validUsername) || !passWordEditText.toString().matches(validPassword))
            Toast.makeText(this, "Unable to validate your email & password", Toast.LENGTH_SHORT).show();
        else if (!accessGranted) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("loggedin", true);
            editor.apply();

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
                    (new Intent(this, ContactUs.class));
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

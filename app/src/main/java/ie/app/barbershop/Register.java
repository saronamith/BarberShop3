package ie.app.barbershop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;



public class Register extends AppCompatActivity {

    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_register);


        registerButton = (Button) findViewById(R.id.registerButton);

        if (registerButton != null) {
            Log.v("Register", "Account Created");
        }


        Button btn = (Button) findViewById(R.id.registerButton);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Landing.class));
            }

        });








    }













}
package ie.app.barbershop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class Landing extends AppCompatActivity{

    private Button buttonProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_landing);

        Button buttonCreateAppointment = (Button) findViewById(R.id.buttonCreateAppointment);
        buttonCreateAppointment.setOnClickListener(new OnClickListenerCreateAppointment());

        Button buttonProducts = (Button) findViewById(R.id.buttonProducts);
        buttonProducts.setOnClickListener(new OnClickListenerCreateAppointment());





    }
}

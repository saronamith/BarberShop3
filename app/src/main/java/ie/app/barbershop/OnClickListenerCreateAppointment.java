package ie.app.barbershop;

import android.view.View;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class OnClickListenerCreateAppointment implements View.OnClickListener {
    private ObjectAppointment objectAppointment;

    @Override
    public void onClick(View view){

        Context context = view.getRootView().getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.appointment_input_form, null, false);
        final EditText editTextFullName = (EditText) formElementsView.findViewById(R.id.editTextFullName);
        final EditText editTextContactNumber = (EditText) formElementsView.findViewById(R.id.editTextContactNumber);


        boolean createSuccessful = new TableControllerAppointments(context).create(objectAppointment);

        if(createSuccessful){
            Toast.makeText(context, "Appointment Information was saved.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "unable to save appointment information", Toast.LENGTH_SHORT).show();
        }

        new AlertDialog.Builder(context)


                .setView(formElementsView)
                .setTitle("Create Appointment")
                .setPositiveButton("Add",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                String fullname = editTextFullName.getText().toString();
                                String contactno = editTextContactNumber.getText().toString();

                                ObjectAppointment objectAppointment = new ObjectAppointment();
                                


                                dialog.cancel();
                            }

                        }).show();

    }
}

package ie.app.barbershop;

import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class TableControllerAppointments extends DatabaseHandler {

    public TableControllerAppointments(Context context) {
        super(context);
    }

    public boolean create(ObjectAppointment objectAppointments) {

        ContentValues values = new ContentValues();

        values.put("fullname", objectAppointments.fullName);
        values.put("contactno", objectAppointments.contactNumber);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("contactno", null, values) > 0;
        db.close();

        return createSuccessful;
    }
}

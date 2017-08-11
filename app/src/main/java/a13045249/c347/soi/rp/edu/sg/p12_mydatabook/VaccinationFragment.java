package a13045249.c347.soi.rp.edu.sg.p12_mydatabook;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class VaccinationFragment extends Fragment {
    Button btnEdit;
    TextView tvVac;
    EditText etVac;
    String a;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.vaccinationfragment, container, false);

        View view = inflater.inflate(R.layout.vaccinationfragment, container, false);

        btnEdit = (Button) view.findViewById(R.id.btnFragVac);
        tvVac = (TextView) view.findViewById(R.id.textViewVac);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                final View mView = inflater.inflate(R.layout.edit_vac, null);


                builder.setTitle("Edit Vaccination")
                        // Set text for the positive button and the corresponding
                        //  OnClickListener when it is clicked
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                EditText etVac = (EditText) mView.findViewById(R.id.editTextVac);
                                a = etVac.getText().toString();
                            }
                        })

                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getContext(), "You clicked no", Toast.LENGTH_LONG).show();
                            }
                        });
                builder.setView(mView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }


        });

        //Step 2a: Obtain an instance of the shared preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Step 2b: Retrieve the saved data with the key, greeting from the shared preferences object.
        String a = prefs.getString("type", "aa");

        Toast toast = Toast.makeText(getContext(), a, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("type", a);
        prefEdit.commit();
    }
}



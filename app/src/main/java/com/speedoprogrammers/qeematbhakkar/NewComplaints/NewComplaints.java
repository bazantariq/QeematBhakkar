package com.speedoprogrammers.qeematbhakkar.NewComplaints;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.speedoprogrammers.qeematbhakkar.ErrorMessages.ErrorAlerts;
import com.speedoprogrammers.qeematbhakkar.R;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class NewComplaints extends AppCompatActivity {

    NiceSpinner niceSpinner;
    Button Submit;
    EditText name,mobile,details;
    String name1,mobile1,details1,tehsil;

    ErrorAlerts error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_new_complaints);

            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("New Complaint");


            error= new ErrorAlerts();
            niceSpinner = (NiceSpinner) findViewById(R.id.nice_spinner);
            List<String> dataset = new LinkedList<>(Arrays.asList("Bhakkar", "Darya Khan", "Kallur Kot", "Mankera"));
            niceSpinner.attachDataSource(dataset);

            Submit = findViewById(R.id.submit);
            Submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    name = findViewById(R.id.nameUser);
                    mobile = findViewById(R.id.mobileUser);
                    details = findViewById(R.id.detailsUser);

                    name1 = name.getText().toString().trim();
                    mobile1 = mobile.getText().toString().trim();
                    details1 = details.getText().toString().trim();
                    tehsil = niceSpinner.getSelectedItem().toString();

                    if (TextUtils.isEmpty(name1)) {
                        name.setError("Required");
                        return;
                    }
                    if (TextUtils.isEmpty(mobile1)) {
                        mobile.setError("Required");
                        return;
                    }
                    if (TextUtils.isEmpty(details1)) {
                        details.setError("Required");
                        return;
                    }

                    if (!error.isConnected(NewComplaints.this)) {

                        Snackbar.make(v, "No Internet Connection", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        return;
                    }
                    else {

                        ComplaintSend(NewComplaints.this);
                     //   Toast.makeText(getApplicationContext(), tehsil + name1 + mobile1 + details1, Toast.LENGTH_LONG).show();
                    }
                }
            });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    public void ComplaintSend(final Context context){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(context,SweetAlertDialog.SUCCESS_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(18)
                .setTitleText("Complaint Send")
                .setContentText("Thank You")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        finish();
                    }
                })
                .show();
    }
}

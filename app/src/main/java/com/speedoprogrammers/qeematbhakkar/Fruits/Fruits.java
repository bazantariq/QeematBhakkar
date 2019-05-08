package com.speedoprogrammers.qeematbhakkar.Fruits;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.speedoprogrammers.qeematbhakkar.AdaptersModel.Adapter_qeemat;
import com.speedoprogrammers.qeematbhakkar.AdaptersModel.qeemat_model;
import com.speedoprogrammers.qeematbhakkar.ErrorMessages.ErrorAlerts;
import com.speedoprogrammers.qeematbhakkar.R;

import org.angmarch.views.NiceSpinner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;
import dmax.dialog.SpotsDialog;

public class Fruits extends AppCompatActivity {

    NiceSpinner niceSpinner;
    Button GetFruits;
    String city;
    String userID;

    android.app.AlertDialog ProgressDots;

    RequestQueue requestQueue;
    private Adapter_qeemat vAdapter;
    ArrayList<qeemat_model> list = new ArrayList<>();
    qeemat_model items;
    ListView lv;
    ErrorAlerts error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Fruits Rates");

        error = new ErrorAlerts();



        lv = findViewById(R.id.lv);



        niceSpinner = (NiceSpinner) findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("Bhakkar", "Darya Khan", "Kallur Kot", "Mankera"));
        niceSpinner.attachDataSource(dataset);

        GetFruits=findViewById(R.id.getfruits);
        GetFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                city= niceSpinner.getSelectedItem().toString();

                if (city.equals("Bhakkar")){
                    userID="2027";
                }
                else
                    userID= "2048";

                list.clear();
                WebServiceAPICall();
            }
        });


        //  loading dialog
        ProgressDots= new SpotsDialog(Fruits.this, R.style.Custom);
        ProgressDots.setCanceledOnTouchOutside(false);
        ProgressDots.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                finish();
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

    private void WebServiceAPICall() {

        ProgressDots.show();

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        String urlAddress = "http://hispanic-chock.000webhostapp.com/XONON/homepg1.php?u_id="+userID;


        final StringRequest request = new StringRequest(Request.Method.POST, urlAddress, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("", "onResponse: " + response);
               Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                if(response.equals("null")){
                    error.NoData(Fruits.this,"No Data Found");
                }

                JSONObject jObj = null;
                JSONArray jArray = null;

                try {

                    jArray = new JSONArray(response);

                    for (int i= 0; i < jArray.length() ; i++ ) {

                        jObj = jArray.getJSONObject(i);

                        String nameItem=jObj.getString("u_manager");
                        String price1=jObj.getString("total_pts");
                        String price2=jObj.getString("total_teams");

                        items=new qeemat_model();

                        items.setSrNo("1");
                        items.setName(nameItem);
                        items.setPrice1(price1);
                        items.setPrice2(price2);
                        list.add(items);
                        list.add(items);
                        list.add(items);



                    }
                    //________initialize adapters
                    vAdapter = new Adapter_qeemat(getApplicationContext(),list);
                    lv.setAdapter(vAdapter);

                    /*if(mInterstitialAd.isLoaded()){
                        mInterstitialAd.show();
                    }*/

                   /* Log.i(TAG, "Name: " + sname + "\n" + "age: " +
                            Sage + "\n" + "gender: " + Sgender +"\n" + "department: " + Sdept);*/

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ProgressDots.dismiss();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error2) {
                ProgressDots.dismiss();

                if (error2 instanceof com.android.volley.TimeoutError) {
                    error.ErrorServerConnection(Fruits.this,"Request Time Out");
                } else if (error2 instanceof com.android.volley.NoConnectionError) {
                    error.ErrorServerConnection(Fruits.this,"No Internet Connection");
                } else if (error2 instanceof com.android.volley.AuthFailureError) {
                    error.ErrorServerConnection(Fruits.this,"Authentication Failure");
                } else if (error2 instanceof com.android.volley.NetworkError) {
                    error.ErrorServerConnection(Fruits.this,"Network Error");
                } else if (error2 instanceof com.android.volley.ServerError) {
                    error.ErrorServerConnection(Fruits.this,"Server Is Down For Maintainence.");
                } else if (error2 instanceof com.android.volley.ParseError) {
                    error.ErrorServerConnection(Fruits.this,"Something Went Wrong");
                } else {
                    error.ErrorServerConnection(Fruits.this,"Something Went Wrong");
                }

            }
        })
        {
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> parameters = new HashMap<>();
                parameters.put("u_id",userID);
                return parameters;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(5000,5,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(request);
    }
    public void TrialEnded(final Context context){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(context,SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(18)
                .setContentText("Trial is over. You have not paid development cost yet.")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        finishAffinity();
                    }
                })
                .show();
    }

}
package com.speedoprogrammers.qeematbhakkar.ErrorMessages;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ErrorAlerts {
    public boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if ((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting()))
                return true;
            else return false;
        } else
            return false;
    }
    public void ErrorMessage2(Context c){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(c,SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("No Internet Connection")
                .setContentText("You need to have Mobile Data or WiFi. Press OK to Exit")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }



    public void UserAlreadyExist(Context c){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(c,SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("User Already Exist")
                .setContentText("Please Signup with different account :)")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }

    public void ManagerExist(Context c){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(c,SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("Manager Name Taken")
                .setContentText("Please Signup with different Manager Name :)")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }
    public void ErrorLeagueTaken(Context c){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(c,SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("League Name Taken")
                .setContentText("Please create league with different name.")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }

    public void ErrorTerms(Context c){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(c,SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("Terms & Conditions")
                .setContentText("Please Accept Terms & Conditions.")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }

    public void ErrorBAT(Context context){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(context,SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("BATSMAN LIMIT")
                .setContentText("MAX BATSMAN LIMIT REACHED")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }

    public void ErrorBWL(Context c){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(c,SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("BOWLER LIMIT")
                .setContentText("MAX BOWLER LIMIT REACHED")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }
    public void ErrorALL(Context c){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(c,SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("ALL-ROUNDER LIMIT")
                .setContentText("MAX ALL-ROUNDER LIMIT REACHED")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }
    public void ErrorWKT(Context c){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(c,SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("WICKET-KEEPER LIMIT")
                .setContentText("MAX WICKET-KEEPER LIMIT REACHED")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }


    public void ErrorCPT(Context c){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(c,SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("Captain")
                .setContentText("Select Captain For Your Team")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }
    public void ErrorCPT2(Context c){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(c,SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("Captain")
                .setContentText("Captain is Already Selected")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }

    public void ErrorTeam(Context c){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(c,SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("Team")
                .setContentText("Select Exactly 11 Players & Make Sure No Button Is Red.")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }

    public void ErrorNot(Context c){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(c,SweetAlertDialog.NORMAL_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);

        sweetAlertDialog.setTitleText("User Not Found")
                .setContentText("Check Your Email or Password")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }
    public void ErrorPesy(Context context){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(context,SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("BUDGET LIMIT")
                .setContentText("You have not engough budget to select this player")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }
    public void ErrorTransfer(Context context){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(context,SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("Transfer LIMIT")
                .setContentText("You have not engough transfers to change your players")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }

    public void ErrorServer(final Context context){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(context,SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("Error !")
                .setContentText("Something Went Wrong !")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();

                    }
                })
                .show();
    }

    public void NoData(final Context context,String message){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(context,SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("Error !")
                .setContentText(message)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();

                    }
                })
                .show();
    }

    public void Trial(final Context context,String message){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(context,SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("Attention Please")
                .setContentText(message)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();

                    }
                })
                .show();
    }

    public void ErrorServerConnection(final Context context,String message){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(context,SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("Error !")
                .setContentText(message)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();

                    }
                })
                .show();
    }


    public void MyTeam(Context context){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(context,SweetAlertDialog.NORMAL_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(18)
                .setContentText("Please Signin First")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }


    public void ForgetNotFound(Context c){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(c,SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("Wrong Email Address")
                .setContentText("Email Address Associated With This Account Is Not Found")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }



    public void ForgetEmail(Context c){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(c,SweetAlertDialog.SUCCESS_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setContentTextSize(13);
        sweetAlertDialog.setTitleText("Sent")
                .setContentText("Password Has Been Sent To Your Email Account")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }
}

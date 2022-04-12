package com.example.ExemploIntencao;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnTelefonarClick(View v){
        Uri uri= Uri.parse("tel:011975606020");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        //crio a intenção e starta a activity
        //startActivity(intent);

        //verificando se tem perissão para realizar ligaçao
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if(permissionCheck != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
        } else{
            startActivity(intent);
        }

    }
    //abrir uma URL
    public void btnAbrirNavegadorClick(View v){
        Uri uri= Uri.parse("https://google.com");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    //busca por geolocalização é por latitude e longitude ou endereço e o espaço usa o "+"
    public void btnAbrirMapaClick(View v){
        Uri uri = Uri.parse("geo:0,0?q=Rua+Faustino+henrique+dacosta+367");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);

        //setar o pacote que quero que abra
        //intent.setPackage("com.google.android.apps.maps");
    }
    public void btnNavegarClick(View v){
        Uri uri = Uri.parse("google.navigation:q=Avenida+general+Carneiro+1456");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);

    }
    public void btnAbrirTelaMsgClick (View view){
        //primeiro quem vai tratar o contesto(no caso esse programa mesmo e cloca o this) e o segundo lugar é a tela que desejo chamar

        Intent intent = new Intent(this,EnviarMensagemActivity2.class);
        startActivity(intent);
    }
}
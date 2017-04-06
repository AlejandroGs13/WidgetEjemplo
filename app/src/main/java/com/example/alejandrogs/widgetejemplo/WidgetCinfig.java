package com.example.alejandrogs.widgetejemplo;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WidgetCinfig extends AppCompatActivity {
    private int widgetID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_cinfig);

        Intent intentOrigen = getIntent();
        Bundle params = intentOrigen.getExtras();

        widgetID = params.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,AppWidgetManager.INVALID_APPWIDGET_ID);

        setResult(RESULT_CANCELED);

        final Button bAceptar = (Button)findViewById(R.id.botonaceptar);
        final Button bCancelar = (Button)findViewById(R.id.botoncancelar);

        bAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("WidgetPreferens",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                //editor.putString("msj_"+ widgetID,Txtmensaje.getText().toString());
                editor.commit();

                /////////Actualizacion widget
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(WidgetCinfig.this);
                //NewAppWidget.actualizarWidget (WidgetCinfig.this,appWidgetManager,widgetID);

                //////////777Devolvamos aceptar
                Intent resultado = new Intent();


            }
        });

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}

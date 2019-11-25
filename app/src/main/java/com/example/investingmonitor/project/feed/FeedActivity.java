package com.example.investingmonitor.project.feed;

import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import java.util.Date;
import android.view.View;
import android.text.format.DateUtils;
import android.widget.Toast;

import com.example.investingmonitor.R;
import com.example.investingmonitor.project.models.Stock;
import com.example.investingmonitor.project.webService.ApiServiceGenerator;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class FeedActivity extends AppCompatActivity implements FeedContract.View {

    private static final String TAG = "INVESTING_MONITOR_TAG";

    private GraphView graphHigh;
    private GraphView graphLow;
    private GraphView graphOpen;
    private GraphView graphClose;
    private GraphView graphVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        graphHigh = (GraphView) findViewById(R.id.graphHigh);
        graphLow = (GraphView) findViewById(R.id.graphLow);
        graphOpen = (GraphView) findViewById(R.id.graphOpen);
        graphClose = (GraphView) findViewById(R.id.graphClose);
        graphVolume = (GraphView) findViewById(R.id.graphVolume);

        graphHigh.setVisibility(android.view.View.GONE);
        graphLow.setVisibility(android.view.View.GONE);
        graphClose.setVisibility(android.view.View.GONE);
        graphOpen.setVisibility(android.view.View.GONE);
        graphVolume.setVisibility(android.view.View.GONE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ApiServiceGenerator.getInstance(this).generate();
    }

    @Override
    public void showUnsucessMessage(String code) {
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setTitleText("Atenção");
        sweetAlertDialog.setContentText("Aparentemente não foi possível acessar a API -> Código: " + code);
        sweetAlertDialog.setConfirmText(getString(R.string.dialog_ok));

        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismiss();
            }
        });
        sweetAlertDialog.show();
    }

    @Override
    public void showStockResults(Stock body) {
        graphHigh.setVisibility(android.view.View.VISIBLE);
       // Date date = DateUtils.parseDate(dateInString, new String[] { "yyyy-MM-dd HH:mm:ss", "dd/MM-yyyy" });
        try {
            int i = 0;
            LineGraphSeries <DataPoint> series = new LineGraphSeries< >(new DataPoint[] {
                    new DataPoint(new Date(body.getDate()[0]), Double.valueOf(body.getLow()[0])),
                    new DataPoint(new Date(body.getDate()[1]), Double.valueOf(body.getLow()[1])),
                    new DataPoint(new Date(body.getDate()[2]), Double.valueOf(body.getLow()[2])),
                    new DataPoint(new Date(body.getDate()[3]), Double.valueOf(body.getLow()[3]))
            });
            graphHigh.addSeries(series);
        } catch (IllegalArgumentException e) {
            Toast.makeText(FeedActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showErrorMessage(String message) {
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setTitleText("Erro Inesperado");
        sweetAlertDialog.setContentText("Aparentemente não foi possível acessar a API:" + message + "\n\n");
        sweetAlertDialog.setConfirmText(getString(R.string.dialog_ok));

        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismiss();
            }
        });
        sweetAlertDialog.show();
    }
}

package com.example.investingmonitor.HGBrasil.HGBrasil;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.investingmonitor.MainPresenter;
import com.example.investingmonitor.R;
import com.example.investingmonitor.models.Tax;
import com.example.investingmonitor.webService.HGBrasilApiService;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HGBrasilActivity extends AppCompatActivity{


        private static final String TAG = "INVESTING_MONITOR_TAG";

        private MainPresenter presenter;

        private SweetAlertDialog dialog;

        private EditText editText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_hgbrasil);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            editText = (EditText) findViewById(R.id.editText);

            Button button = (Button) findViewById(R.id.request_button);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Do something in response to button click

                    Retrofit retrofit = createRetrofitInstance();

                    HGBrasilApiService service = retrofit.create(HGBrasilApiService.class);

                    Call<Tax> taxRequest = service.taxes();

                    taxRequest.enqueue(new Callback<Tax>() {
                        @Override
                        public void onResponse(Call<Tax> call, Response<Tax> response) {

                            if(!response.isSuccessful()) {

                                Log.e(TAG, "Error Code: " + response.code());
                                showErrorMessage(getString(response.code()));

                            } else {
                                //showSuccessMessage(response.message());
                                Tax results = response.body();
                                showTaxes(results);
                            }
                        }

                        @Override
                        public void onFailure(Call<Tax> call, Throwable t) {
                            Log.e(TAG, "Error: " + t.getMessage());
                            showErrorMessage(t.getMessage());
                        }
                    });
                }
            });

            FloatingActionButton fab = findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }

        private void showTaxes(Tax results) {

            String indexString = editText.getText().toString();
            dialog = new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);

            String message = "";

            try {
                int index = (int) Integer.valueOf(indexString);
                message = "Selic: " + results.results.get(index).selic + " date: " + results.results.get(index).date + " cdi: "
                        + results.results.get(index).cdi + " daily_factor: " + results.results.get(index).daily_Factor;

                dialog.setTitleText(getString(R.string.success))
                        .setContentText(message)
                        .showCancelButton(false)
                        .setConfirmText(getString(R.string.concern));
                dialog.show();

            } catch (Exception e){
                showErrorMessage(e.getMessage());
            }
        }

        private void showSuccessMessage(String message) {
            dialog = new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);

            dialog.setTitleText(getString(R.string.success))
                    .setContentText(message)
                    .showCancelButton(false)
                    .setConfirmText(getString(R.string.concern));
            dialog.show();
        }

        private void showErrorMessage(String message) {
            dialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);

            dialog.setTitleText(getString(R.string.error))
                    .setContentText(message)
                    .showCancelButton(false)
                    .setConfirmText(getString(R.string.concern));
            dialog.show();
        }

        private Retrofit createRetrofitInstance() {
            return new Retrofit.Builder()
                    .baseUrl(HGBrasilApiService.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
}

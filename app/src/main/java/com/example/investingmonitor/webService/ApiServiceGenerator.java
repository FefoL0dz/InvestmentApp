package com.example.investingmonitor.webService;

import com.example.investingmonitor.models.Stock;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceGenerator {

    public static ApiServiceGenerator getInstance() {
        return new ApiServiceGenerator();
    }

    public void generate () {

        Retrofit retrofit = createRetrofitInstance();

        HorukoApiService service = retrofit.create(HorukoApiService.class);

        Call<Stock> taxRequest = service.stocks();

        taxRequest.enqueue(new Callback<Stock>() {
            @Override
            public void onResponse(Call<Stock> call, Response<Stock> response) {

                if(!response.isSuccessful()) {

                   // showErrorMessage(getString(response.code()));

                } else {
                    //showSuccessMessage(response.message());
                    Stock results = response.body();
                   // showTaxes(results);
                }
            }

            @Override
            public void onFailure(Call<Stock> call, Throwable t) {
                //showErrorMessage(t.getMessage());
            }
        });
    }

    private Retrofit createRetrofitInstance() {
        return new Retrofit.Builder()
        .baseUrl(HorukoApiService.TESTE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
        }
}

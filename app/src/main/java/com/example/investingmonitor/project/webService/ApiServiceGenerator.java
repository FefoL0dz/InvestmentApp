package com.example.investingmonitor.project.webService;

import com.example.investingmonitor.project.feed.FeedContract;
import com.example.investingmonitor.project.models.Stock;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceGenerator {
private FeedContract.View view;

    public ApiServiceGenerator(FeedContract.View view) {
        this.view = view;
    }

    public static ApiServiceGenerator getInstance(FeedContract.View view) {
        return new ApiServiceGenerator(view);
    }

    public Response<Stock> results;

    public Response<Stock> generate () {

        Retrofit retrofit = createRetrofitInstance();

        HorukoApiService service = retrofit.create(HorukoApiService.class);

        Call<Stock> taxRequest = service.stocks();

        results = null;

        taxRequest.enqueue(new Callback<Stock>() {
            @Override
            public void onResponse(Call<Stock> call, Response<Stock> response) {

                if(!response.isSuccessful()) {
                   // showErrorMessage(getString(response.code()));
                    results = response;
                } else {
                    //showSuccessMessage(response.message());
                    results = response;
                   // showTaxes(results);
                }
            }

            @Override
            public void onFailure(Call<Stock> call, Throwable t) {
                //showErrorMessage(t.getMessage());
                view.showErrorMessage(t.getMessage());
            }
        });

        return results;
    }

    private Retrofit createRetrofitInstance() {
        return new Retrofit.Builder()
        .baseUrl(HorukoApiService.TESTE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
        }
}

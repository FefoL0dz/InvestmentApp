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

    public void generate () {

        Retrofit retrofit = createRetrofitInstance();

        HorukoApiService service = retrofit.create(HorukoApiService.class);

        Call<Stock> taxRequest = service.stocks();

        taxRequest.enqueue(new Callback<Stock>() {
            @Override
            public void onResponse(Call<Stock> call, Response<Stock> response) {
                if(response.isSuccessful()) {
                    //Stock result =  insertionSortst(response.body());
                    view.showStockResults(response.body());
                }
                else
                    view.showUnsucessMessage(String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<Stock> call, Throwable t) {
                view.showErrorMessage(t.getMessage());
            }
        });
    }

//    public Stock insertionSortst(Stock vetor) {
//        int j;
//        double key;
//        double key2;
//        int i;
//
//        for (j = 1; j < vetor.getHigh().length; j++)
//        {
//            key = Double.valueOf(vetor.getHigh()[j]);
//            key2= Double.valueOf(vetor.getLow()[j]);
//            for (i = j - 1; (i >= 0) && (Double.valueOf(vetor.getHigh()[i]) > key); i--)
//            {
////                vetor.getHigh()[i + 1] = vetor.getHigh()[i];
////                vetor.getLow()[i + 1] = vetor.getLow()[i];
//                vetor.setHighAtIndex(vetor.getHigh()[i], i + 1);
//                vetor.setLowAtIndex(vetor.getLow()[i], i + 1);
//            }
////            vetor.getHigh()[i + 1] = String.valueOf(key);
////            vetor.getLow()[i + 1] = String.valueOf(key2);
//            vetor.setHighAtIndex(String.valueOf(key), i + 1);
//            vetor.setLowAtIndex(String.valueOf(key2), i + 1);
//        }
//        return vetor;
//    }

    private Retrofit createRetrofitInstance() {
        return new Retrofit.Builder()
        .baseUrl(HorukoApiService.TESTE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
        }
}

package com.example.investingmonitor.project.webService;

import com.example.investingmonitor.project.models.Stock;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HorukoApiService {
    /**
     * Created by Felipe Lodes in 18/08/2019
     *
     */
    String BASE_URL_ ="https://usp-rp2.herokuapp.com/usp_rp2/?";

    String TIME_SERIES_DAILY = "TIME_SERIES_DAILY";

    String TIME_SERIES_WEEKLY = "TIME_SERIES_WEEKLY";

    String TIME_SERIES_MONTHLY = "TIME_SERIES_MONTHLY";

    String AND = "&";

    String SYMBOL = "symbol";

    String EQUALS = "=";

    String BRKM5_SAO = "BRKM5.SAO";

    String INTERVAL = "interval";

    String TIME_SERIES_INTRADAY = "TIME_SERIES_INTRADAY";

    //https://usp-rp2.herokuapp.com/usp_rp2/?function=TIME_SERIES_INTRADAY&symbol=BRKM5.SAO&interval=5min

    
    String TESTE_URL = "https://usp-rp2.herokuapp.com/usp_rp2/?function=TIME_SERIES_INTRADAY&symbol=BRKM5.SAO&interval=5min";

    @GET(TESTE_URL)
    Call<Stock> stocks();
}

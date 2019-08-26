package com.example.investingmonitor.webService;

import com.example.investingmonitor.models.Quotation;
import com.example.investingmonitor.models.Results;
import com.example.investingmonitor.models.Tax;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HGBrasilApiService {
    /**
     * Created by Felipe Lodes in 18/08/2019
     *
     */
    public static final String BASE_URL = "https://api.hgbrasil.com/finance/";

    public static final String PARSER = "?key=";

    static final String privateKey = "b0256ef9";

    public static final String QUOTATIONS = "quotations";

    public static final String TAXES = "taxes";

    @GET(QUOTATIONS + PARSER + privateKey)
    Call<Quotation> quotations();

    @GET(TAXES + PARSER + privateKey)
    Call<Tax> taxes();


}

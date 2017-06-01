package sindicomerciarios.com.br.sindicom.retrofit;

import sindicomerciarios.com.br.sindicom.AdvantageService;
import sindicomerciarios.com.br.sindicom.NewService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by alura on 11/28/16.
 */

public class RetrofitInicializador {

    private final Retrofit retrofit;

    public RetrofitInicializador(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(interceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://162.243.245.197:8082/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public AdvantageService getAdvantageService() {
        return retrofit.create(AdvantageService.class);
    }

    public NewService getNewService() {
        return retrofit.create(NewService.class);
    }

}


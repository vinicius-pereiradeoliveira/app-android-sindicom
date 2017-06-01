package sindicomerciarios.com.br.sindicom;

import sindicomerciarios.com.br.sindicom.dto.ListAdvantageSync;
import sindicomerciarios.com.br.sindicom.dto.ListNewSync;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vinicius.oliveira on 30/03/2017.
 */

public interface NewService {
    public static final String BASE_URL = "http://162.243.245.197:8082/";

    @GET("api/news")
    Call<ListNewSync> listNews();
}

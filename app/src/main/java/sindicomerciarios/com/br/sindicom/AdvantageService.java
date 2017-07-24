package sindicomerciarios.com.br.sindicom;

import java.util.List;


import sindicomerciarios.com.br.sindicom.dto.ListAdvantageSync;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vinicius.oliveira on 08/03/2017.
 */

public interface AdvantageService {

    public static final String BASE_URL = "http://174.138.38.45:8082/";

    @GET("api/advantages")
    Call<ListAdvantageSync> listAdvantages();
}

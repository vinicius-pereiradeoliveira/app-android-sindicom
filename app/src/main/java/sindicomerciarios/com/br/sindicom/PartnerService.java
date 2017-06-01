package sindicomerciarios.com.br.sindicom;

import sindicomerciarios.com.br.sindicom.model.Partner;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by vinicius.oliveira on 17/04/2017.
 */

public interface PartnerService {

    @POST("saveuser")
    Call<Partner> createPartner(@Body Partner partner);
}

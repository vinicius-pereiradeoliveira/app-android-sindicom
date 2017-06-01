package sindicomerciarios.com.br.sindicom.firebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by vinicius.oliveira on 01/06/2017.
 */

public class CDCInstanceIDService extends FirebaseInstanceIdService {
     // Esta classe gera um token único para vincular o dispositivo ao Firebase
     // Caso o dispositivo atualize a versão do app ou faça reinstalação do app, o Firebase reconhecerá pelo token.
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("Token da App", token);
    }
}

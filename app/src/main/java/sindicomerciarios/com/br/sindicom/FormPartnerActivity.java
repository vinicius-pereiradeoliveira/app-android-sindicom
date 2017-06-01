package sindicomerciarios.com.br.sindicom;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;

import sindicomerciarios.com.br.sindicom.model.Partner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormPartnerActivity extends AppCompatActivity {

    public EditText name, cpf, celular, empresa, dt_nascimento, password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_partner);

        name = (EditText) findViewById(R.id.editText);
        cpf = (EditText) findViewById(R.id.editText2);
        celular = (EditText) findViewById(R.id.editText3);
        empresa = (EditText) findViewById(R.id.editText4);
        dt_nascimento = (EditText) findViewById(R.id.editText5);
        password = (EditText) findViewById(R.id.editText6);

        Button createPartnerButton = (Button) findViewById(R.id.button7);
        createPartnerButton.setOnClickListener((view) -> {
            Partner partner = new Partner(
                    name.getText().toString(),
                    cpf.getText().toString(),
                    celular.getText().toString(),
                    empresa.getText().toString(),
                    dt_nascimento.getText().toString(),
                    password.getText().toString()
            );

            sendNetworkPostRequest(partner);
        });
    }

    private void sendNetworkPostRequest(Partner partner) {
        Boolean validForm = validFields();

        if (validForm) {
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl("http://162.243.245.197:8082/")
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.build();

            PartnerService partnerService = retrofit.create(PartnerService.class);
            Call<Partner> call = partnerService.createPartner(partner);

            Intent intent = new Intent(this, MainActivity.class);

            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    Context context = getApplicationContext();
                    CharSequence text = "Voce agora faz parte dos associados do Sindicato!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    startActivity(intent);
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Context context = getApplicationContext();
                    CharSequence text = "Ocorreu um erro de acesso com a internet ou servidor! Tente novamente mais tarde!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    startActivity(intent);
                }
            });
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Voce nao preencheu campos obrigatorios!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    private Boolean validFields(){
        Boolean validField = true;

        if (name.getText().toString().length() == 0) {
            validField = false;
            name.setError("Digite um nome!");
        }

        if (cpf.getText().toString().length() == 0) {
            validField = false;
            cpf.setError("Digite o CPF!");
        }

        if (empresa.getText().toString().length() == 0) {
            validField = false;
            empresa.setError("Digite a empresa!");
        }

        return validField;
    }


}


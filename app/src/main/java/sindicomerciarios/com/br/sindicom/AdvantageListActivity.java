package sindicomerciarios.com.br.sindicom;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sindicomerciarios.com.br.sindicom.adapter.AdapterListAdvantages;
import sindicomerciarios.com.br.sindicom.dto.ListAdvantageSync;
import sindicomerciarios.com.br.sindicom.model.Advantages;
import sindicomerciarios.com.br.sindicom.retrofit.RetrofitInicializador;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.id.list;


public class AdvantageListActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advantage_list);
        final List list = new ArrayList<Advantages>();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(AdvantageService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AdvantageService service = retrofit.create(AdvantageService.class);
        Call<ListAdvantageSync> call = new RetrofitInicializador().getAdvantageService().listAdvantages();

        call.enqueue(new Callback<ListAdvantageSync>() {
            @Override
            public void onResponse(Call<ListAdvantageSync> call, Response<ListAdvantageSync> response) {
                ListAdvantageSync alunoSync = response.body();
                ArrayList<Advantages> advantages = new ArrayList<Advantages>();
                listView = (ListView) findViewById(R.id.listAdvantages);

                for (Advantages ad : alunoSync.getAdvantages()) {
                    advantages.add(ad);
                }

                AdapterListAdvantages adapter = new AdapterListAdvantages(AdvantageListActivity.this, advantages);

                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ListAdvantageSync> call, Throwable t) {
                Log.e("onFailure chamado", t.getMessage());
            }
        });
    }
}


package sindicomerciarios.com.br.sindicom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import sindicomerciarios.com.br.sindicom.adapter.AdapterListNews;
import sindicomerciarios.com.br.sindicom.dto.ListNewSync;
import sindicomerciarios.com.br.sindicom.model.News;
import sindicomerciarios.com.br.sindicom.retrofit.RetrofitInicializador;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsListActivity extends AppCompatActivity {

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        final List list = new ArrayList<News>();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(NewService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Call<ListNewSync> call = new RetrofitInicializador().getNewService().listNews();

        call.enqueue(new Callback<ListNewSync>() {
            @Override
            public void onResponse(Call<ListNewSync> call, Response<ListNewSync> response) {
                ListNewSync newSync = response.body();
                ArrayList<News> advantages = new ArrayList<News>();
                listView = (ListView) findViewById(R.id.listNews);

                for (News nw : newSync.getNews()) {
                    advantages.add(nw);
                }

                AdapterListNews adapter = new AdapterListNews(NewsListActivity.this, advantages);

                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ListNewSync> call, Throwable t) {
                Log.e("onFailure chamado", t.getMessage());
            }
        });
    }
}


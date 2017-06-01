package sindicomerciarios.com.br.sindicom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import sindicomerciarios.com.br.sindicom.R;
import sindicomerciarios.com.br.sindicom.model.News;

/**
 * Created by vinicius.oliveira on 30/03/2017.
 */

public class AdapterListNews extends BaseAdapter{
    private final List<News> news;
    private final Context context;

    public AdapterListNews(Context context, List<News> news) {
        this.context = context;
        this.news = news;
    }

    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public Object getItem(int position) {

        return news.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        News ns = news.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.news_list_items, parent, false);
        }

        //pegando as referências das Views
        TextView name = (TextView) view.findViewById(R.id.list_name);
        TextView description = (TextView) view.findViewById(R.id.list_description);

        //populando as Views
        name.setText(ns.getName());
        description.setText(ns.getDescription());

        return view;
    }
}

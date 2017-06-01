package sindicomerciarios.com.br.sindicom.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sindicomerciarios.com.br.sindicom.R;
import sindicomerciarios.com.br.sindicom.model.Advantages;

/**
 * Created by vinicius.oliveira on 17/03/2017.
 */

public class AdapterListAdvantages extends BaseAdapter {

    private final List<Advantages> advantages;
    private final Context context;

    public AdapterListAdvantages(Context context, List<Advantages> advantages) {
        this.context = context;
        this.advantages = advantages;
    }

    @Override
    public int getCount() {
        return advantages.size();
    }

    @Override
    public Object getItem(int position) {
        return advantages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Advantages adv = advantages.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.advantage_list_items, parent, false);
        }

        //pegando as referências das Views
        TextView name = (TextView) view.findViewById(R.id.list_name);
        TextView description = (TextView) view.findViewById(R.id.list_description);

        //populando as Views
        name.setText(adv.getName());
        description.setText(adv.getDescription());

        return view;
    }
}

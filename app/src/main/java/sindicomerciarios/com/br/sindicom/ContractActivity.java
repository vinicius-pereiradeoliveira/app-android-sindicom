package sindicomerciarios.com.br.sindicom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ContractActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);
    }

    public void getFormPartner(View view) {
        Intent intent = new Intent(this, FormPartnerActivity.class);
        startActivity(intent);
    }

    public void getCancelPartner(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}


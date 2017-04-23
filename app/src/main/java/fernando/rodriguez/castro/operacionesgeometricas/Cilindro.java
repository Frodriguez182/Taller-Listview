package fernando.rodriguez.castro.operacionesgeometricas;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cilindro extends AppCompatActivity {

    private EditText radio, altura;
    private Resources res;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);

        res=this.getResources();
        radio=(EditText)findViewById(R.id.txtRadioEsfera);
        altura=(EditText)findViewById(R.id.txtAlturaCilindro);
        context=this;
    }

    public void guardar(View v){
        String opera, dato, result;

        int radioFinal = Integer.parseInt(radio.getText().toString());
        int alturaFinal = Integer.parseInt(altura.getText().toString());
        opera = res.getString(R.string.txtOperacion6);
        String str = res.getString(R.string.txtValorRadioCilindro);
        String str2 = res.getString(R.string.txtValorAlturaCilindro);
        dato = str+"\n "+radioFinal+"\n"+str2+"\n "+alturaFinal;

        double volumen = Math.PI*radioFinal*radioFinal*alturaFinal;
        volumen = (double)((int)(volumen*100.0)/100.0);
        result = Double.toString(volumen);

        new AlertDialog.Builder(context).setTitle(opera).setMessage(result).show();

        Operacion o = new Operacion(opera, dato, result);
        o.guardar();
        borrar(v);
    }

    public void borrar(View v){
        radio.setText("");
        altura.setText("");
        radio.requestFocus();
    }


}

package fernando.rodriguez.castro.operacionesgeometricas;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Esfera extends AppCompatActivity {

    private EditText radio;
    private Resources res;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esfera);

        res=this.getResources();
        radio=(EditText)findViewById(R.id.txtRadioEsfera);
        context=this;
    }

    public void guardar(View v){
        String opera, dato, result;

        int radioFinal = Integer.parseInt(radio.getText().toString());
        opera = res.getString(R.string.txtOperacion5);
        String str = res.getString(R.string.txtValorRadioEsfera);
        dato = str+"\n "+radioFinal;

        double volumen = (4/3)*Math.PI*radioFinal*radioFinal*radioFinal;
        volumen = (double)((int)(volumen*100.0)/100.0);
        result = Double.toString(volumen);

        new AlertDialog.Builder(context).setTitle(opera).setMessage(result).show();

        Operacion o = new Operacion(opera, dato, result);
        o.guardar();
        borrar(v);
    }

    public void borrar(View v){
        radio.setText("");
        radio.requestFocus();
    }

}

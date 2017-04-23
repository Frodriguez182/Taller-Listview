package fernando.rodriguez.castro.operacionesgeometricas;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cono extends AppCompatActivity {

    private EditText radio, altura;
    private Resources res;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cono);

        res=this.getResources();
        radio=(EditText)findViewById(R.id.txtRadioCono);
        altura=(EditText)findViewById(R.id.txtAlturaCono);
        context=this;
    }

    public void guardar(View v){
        String opera, dato, result;

        int radioFinal = Integer.parseInt(radio.getText().toString());
        int alturaFinal = Integer.parseInt(altura.getText().toString());
        opera = res.getString(R.string.txtOperacion7);
        String str = res.getString(R.string.txtValorRadioCono);
        String str2 = res.getString(R.string.txtValorAlturaCono);
        dato = str+"\n "+radioFinal+"\n"+str2+"\n "+alturaFinal;

        double volumen = (Math.PI*radioFinal*radioFinal*alturaFinal)/3;
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

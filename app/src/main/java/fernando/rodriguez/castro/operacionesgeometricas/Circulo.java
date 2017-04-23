package fernando.rodriguez.castro.operacionesgeometricas;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.lang.Math;

public class Circulo extends AppCompatActivity {

    private EditText radio;
    private Resources res;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        res=this.getResources();
        radio=(EditText)findViewById(R.id.txtRadio);
        context=this;
    }

    public void guardar(View v){
        String opera, dato, result;

        int radioFinal = Integer.parseInt(radio.getText().toString());
        opera = res.getString(R.string.txtOperacion4);
        String str = res.getString(R.string.txtValorRadioCirculo);
        dato = str+"\n "+radioFinal;

        double area = Math.PI*radioFinal*radioFinal;
        area = (double)((int)(area*100.0)/100.0);
        result = Double.toString(area);

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

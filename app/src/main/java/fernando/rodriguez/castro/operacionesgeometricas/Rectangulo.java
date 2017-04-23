package fernando.rodriguez.castro.operacionesgeometricas;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



public class Rectangulo extends AppCompatActivity {

    private EditText base, altura;
    private Resources res;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        res=this.getResources();
        base=(EditText)findViewById(R.id.txtLongBaseRectangulo);
        altura=(EditText)findViewById(R.id.txtAlturaRectangulo);
        context=this;
    }

    public void guardar(View v){
        String opera, dato, result;

        int baseFinal = Integer.parseInt(base.getText().toString());
        int alturaFinal = Integer.parseInt(altura.getText().toString());
        opera = res.getString(R.string.txtOperacion2);
        String str1 = res.getString(R.string.txtValorBaseRectangulo)+"\n "+baseFinal;
        String str2 = res.getString(R.string.txtValorAlturaRectangulo)+"\n "+alturaFinal;
        dato = str1+"\n "+str2;

        int area = baseFinal*alturaFinal;
        result = Integer.toString(area);

        new AlertDialog.Builder(context).setTitle(opera).setMessage(result).show();

        Operacion o = new Operacion(opera, dato, result);
        o.guardar();
        borrar(v);
    }

    public void borrar(View v){
        base.setText("");
        altura.setText("");
        base.requestFocus();
    }


}

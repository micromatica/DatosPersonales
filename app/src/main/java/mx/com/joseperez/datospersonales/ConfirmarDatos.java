package mx.com.joseperez.datospersonales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmardatos);

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.nombre));
        String fechaNacimiento = parametros.getString("fechaNacimiento");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");
        String descripcion = parametros.getString("descripcion");

        final TextView tvNombre = (TextView) findViewById(R.id.nombre);
        final TextView tvFechaNacimiento = (TextView)findViewById(R.id.fechaNacimiento);
        final TextView tvTelefono = (TextView)findViewById(R.id.telefono);
        final TextView tvEmail = (TextView)findViewById(R.id.email);
        final TextView tvDescripcion = (TextView)findViewById(R.id.descripcion);

        tvNombre.setText(nombre);
        tvFechaNacimiento.setText(fechaNacimiento);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        Button btnRegresar = (Button)findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmarDatos.this,MainActivity.class);
                intent.putExtra("nombre",tvNombre.getText());
                intent.putExtra("fechaNacimiento",tvFechaNacimiento.getText());
                intent.putExtra("telefono",tvTelefono.getText());
                intent.putExtra("email",tvEmail.getText());
                intent.putExtra("descripcion",tvDescripcion.getText());
                startActivity(intent);
                finish();
            }
        });
    }
}

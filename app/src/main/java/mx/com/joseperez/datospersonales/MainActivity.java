package mx.com.joseperez.datospersonales;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
//import android.widget.Toast;
//import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity  { // showDatePickerDialog

    Calendar calendario;
    DatePickerDialog datePickerDialog;

    TextView tvNombre;
    TextView tvFechaNacimiento;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    Button btnAceptar;

    DatosPersonales datos;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNombre = (TextView)findViewById(R.id.nombre);
        tvFechaNacimiento = (TextView)findViewById(R.id.fechaNacimiento);
        tvTelefono = (TextView)findViewById(R.id.telefono);
        tvEmail = (TextView)findViewById(R.id.email);
        tvDescripcion = (TextView)findViewById(R.id.descripcion);

        calendario = Calendar.getInstance();

        // No estoy seguro de que sea la mejor manera de mostrar los datos para editar
        // después de que el usuario notó que los datos estaban mal y dio clic en el botón "regresar" en la actividad ConfirmarDatos
        // para corregir los datos.
        try {
            Bundle parametros = getIntent().getExtras();
            tvNombre.setText(parametros.getString("nombre"));
            tvFechaNacimiento.setText(parametros.getString("fechaNacimiento"));
            tvTelefono.setText(parametros.getString("telefono"));
            tvEmail.setText(parametros.getString("email"));
            tvDescripcion.setText(parametros.getString("descripcion"));
        }
        catch(Exception ex){

        }

           tvFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calendario = Calendar.getInstance();
                int dia = calendario.get(Calendar.DAY_OF_MONTH) - 1;        // ¡HELP! ¿como evito restar 1, para que me de el día correcto, sino resto -, me da el día siguiente.
                int mes = calendario.get(Calendar.MONTH);
                int anio = calendario.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvFechaNacimiento.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },dia,mes,anio);
                datePickerDialog.updateDate(anio,mes,dia);
                datePickerDialog.show();
            }
        });

        btnAceptar = (Button)findViewById(R.id.btnAceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datos = new DatosPersonales(tvNombre.getText().toString(),
                                            tvFechaNacimiento.getText().toString(),
                                            tvTelefono.getText().toString(),
                                            tvEmail.getText().toString(),
                                            tvDescripcion.getText().toString());

                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                intent.putExtra(getResources().getString(R.string.nombre),datos.getNombre());                               // Solo para probar que se puede obtener el parámetro del recurso string
                intent.putExtra("fechaNacimiento",datos.getFechaNacimiento());      // o teclearlo directamente
                intent.putExtra("telefono",datos.getTelefono());
                intent.putExtra("email",datos.getEmail());
                intent.putExtra("descripcion",datos.getDescripcion());

                startActivity(intent);
                finish();     // Termina la activity
            }
        });
     }
}


// https://www.youtube.com/watch?v=-mJmScTAWyQ  DatePicker


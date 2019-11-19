package com.carloss2020.menub;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class formulario extends AppCompatActivity {

    EditText edtNombres, edtepellidos, edtdireccion,edtedad;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        edtNombres =(EditText)findViewById(R.id.txtnombres);
        edtepellidos =(EditText)findViewById(R.id.txtapellidos);
        edtdireccion =(EditText)findViewById(R.id.txtdireccion);
        edtedad =(EditText)findViewById(R.id.txtedad);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarUsuario();

            }
        });

    }

 public Connection conexionBD(){

        Connection conexion = null;

     try{
         StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
         StrictMode.setThreadPolicy(policy);
         Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
         conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.37;databaseName=Developeru;user=sa;password=123;");

     }catch(Exception e){
         Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();


     }

     return conexion;

 }


 public void agregarUsuario(){

        try{

            PreparedStatement pst = conexionBD().prepareStatement("insert into usuarios values(?,?,?,?)");
            pst.setString(1,edtNombres.getText().toString());
            pst.setString(2,edtepellidos.getText().toString());
            pst.setString(3,edtdireccion.getText().toString());
            pst.setString(4,edtedad.getText().toString());
            pst.executeUpdate();

            Toast.makeText(getApplicationContext(),"REGISTRO AGREGADO CORRECTAMENTE",Toast.LENGTH_SHORT).show();

        }catch (Exception e){

            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();


        }

 }







}














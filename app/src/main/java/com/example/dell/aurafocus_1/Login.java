package com.example.musha.aninterface;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Pattern;
public class Login extends AppCompatActivity {

    Button butlog;
    EditText uname,pass;
    //SQLiteDatabase dbl;
    //SQLiteOpenHelper open;
    DatabaseHelper mydb;
    Cursor cursor;
    String uid;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^"+
                    //"(?=.*[0-9])" +
                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    // "(?=.*[@#$%^&+=])" +
                    //"(?=\\S+$)" +
                    ".{3,}" +
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mydb = new DatabaseHelper(this);
        //open = new DatabaseHelper(this);
        //dbl = open.getReadableDatabase();

        butlog = (Button) findViewById(R.id.login);
        uname = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);

        butlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username1 = uname.getText().toString();
                String password1 = pass.getText().toString();

                validateName();
                validatePassword();

                boolean chkunamepass = mydb.loginCheck(username1,password1);

                if(username1.equals("admin") && password1.equals("Admin")){
                    Toast.makeText(getApplicationContext(), "Admin Login", Toast.LENGTH_LONG).show();
                    Intent admin = new Intent(Login.this, Admin.class);
                    startActivity(admin);
                }
                else{
                    if(chkunamepass == true) {
                        Cursor ck = mydb.getname(username1,password1);
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                        Intent profile = new Intent(Login.this, ProPic.class);
                        startActivity(profile);
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Invalid password", Toast.LENGTH_LONG).show();


                }























                /*cursor = dbl.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_4 + " =? AND " + DatabaseHelper.COL_5 + " =? ", new String[]{username1, password1});
                //cursor=db1.rawQuery(" SELECT*FROM "+ DatabaseHelper.TABLE_NAME +" WHERE "+ DatabaseHelper.COL_4 + " =? AND "+ DatabaseHelper.COL_5 + " =? ",new String[]{username1,password1});

                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        cursor.moveToNext();


                        if (username1.equals("admin") && password1.equals("admin")) {

                           Intent int1 = new Intent(Login.this,Admin.class);
                            startActivity(int1);
                            Toast.makeText(getApplicationContext(), "Admin Login", Toast.LENGTH_LONG).show();
                        }
                        else{

                            if ((!username1.equals("")) && (!password1.equals(""))) {
                                //String passname = dbl.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_4 + " =? AND " + DatabaseHelper.COL_5 + " =? ", new String[]{username1, password1});
                                //mydb.getname(username1,password1);
                                Toast.makeText(getApplicationContext(), "Welcome " + mydb.getname(username1, password1), Toast.LENGTH_LONG).show();
                                Intent homeIntent = new Intent(Login.this, ProPic.class);
                                startActivity(homeIntent);
                            }
                            else if (username1.equals("") && password1.equals("") ) {
                                    Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_LONG).show();
                             }
                    }
                    }

                }*/



            }

        });

    }

    /*
    cursor.moveToNext();
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();

                    //String ouid =  dbl.execSQL("SELECT * FROM "+DatabaseHelper.TABLE_NAME+" where "+DatabaseHelper.COL_4+" =? and "+DatabaseHelper.COL_5+" =?",new String[]{username1,password1});

                    openActivity();



    public boolean logincheck(){
        String username1 = uname.getText().toString();
        String password1 = pass.getText().toString();
        Cursor log = dbl.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_4 + " =? AND " + DatabaseHelper.COL_5 + " =? ", new String[]{username1, password1});
        if(log.)

    }

*/


    private boolean validateName(){
        String nameInput = uname.getEditableText().toString().trim();

        if(nameInput.isEmpty()){
            uname.setError("Fields can't be empty");
        }else{
            uname.setError(null);
        }
        return true;
    }
    private boolean validatePassword(){
        String passwordInput = pass.getEditableText().toString().trim();

        if(passwordInput.isEmpty()){
            pass.setError("Fields can't be empty");
            return false;
        }else if(!PASSWORD_PATTERN.matcher(passwordInput).matches()){
            pass.setError("Password too weak");
            return false;
        }else{
            pass.setError(null);
            return true;
        }
    }

}

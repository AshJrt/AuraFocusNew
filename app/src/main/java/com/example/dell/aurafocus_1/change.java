package com.example.musha.aninterface;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class change extends AppCompatActivity {

    SQLiteDatabase db;

    EditText name, email, username, password;
    Button btnupdate, btncancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        db = openOrCreateDatabase("users.db", Context.MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS users_table(userid INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,email TEXT,username TEXT,password TEXT)");
        //myDb = new DatabaseHelper(this);


        name = (EditText) findViewById(R.id.editname);
        email = (EditText) findViewById(R.id.editemail);
        username = (EditText) findViewById(R.id.editusername);
        password = (EditText) findViewById(R.id.editpassword);
        btnupdate = (Button) findViewById(R.id.btnupdate);
        btncancel = (Button) findViewById(R.id.btncancel);

        update();


    }

    private boolean validatename() {
        String nameinput = name.getText().toString().trim();

        if (nameinput.isEmpty()) {
            Toast.makeText(change.this, "Invalid name", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validateemail() {
        String emailinput = email.getText().toString().trim();

        if (emailinput.isEmpty()) {
            Toast.makeText(change.this, "Invalid Email", Toast.LENGTH_LONG).show();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailinput).matches()) {
            Toast.makeText(change.this, "Invalid Email", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }


    private boolean validatepassword() {
        String pass = password.getText().toString().trim();

        if (pass.isEmpty()) {
            Toast.makeText(change.this, "Invalid Password", Toast.LENGTH_LONG).show();
            return false;
        } /*else if(!PASSWORD_PATTERN.matcher(pass).matches()){
            Toast.makeText(Register.this,"Invalid Password",Toast.LENGTH_LONG).show();
            return false;
        }*/ else {
            return true;
        }

    }

    public void update() {

        btnupdate.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                        validatename();
                        validateemail();
                        validatepassword();
                        if (validatename() && validateemail() && validatepassword()) {
                           /* boolean isUpdate = myDb.updateData(name.getText().toString(),
                                    email.getText().toString(),
                                    username.getText().toString(),
                                    password.getText().toString());
                            */

                            Cursor c=db.rawQuery("SELECT * FROM users_table WHERE name='"+ name.getText()+"'", null);
                            if(c.moveToFirst()) {
                                db.execSQL("UPDATE users_table  SET email='"+ email.getText()+"', username='"+ username.getText()+"',password ='"+ password.getText()+"', WHERE name ='"+name.getText()+"'");
                                Toast.makeText(change.this, "Record Modified",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(change.this, "Invalid Employee Name",Toast.LENGTH_SHORT);
                            }
                           /* if (isUpdate = true)
                                Toast.makeText(change.this, "Data is Modified", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(change.this, "Data is not Modified", Toast.LENGTH_LONG).show();
                                */
                        }
                    }
                }
        );
    }
}

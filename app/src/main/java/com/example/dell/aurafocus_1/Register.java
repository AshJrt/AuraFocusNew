package com.example.dell.aurafocus_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^"+
                    //"(?=.*[0-9])" +
                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    // "(?=.*[@#$%^&+=])" +
                    //"(?=\\S+$)" +
                    ".{3,}" +
                    "$");

    DatabaseHelper myDb;

    EditText name,email,username,password;
    Button btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myDb = new DatabaseHelper(this);




            name = (EditText) findViewById(R.id.regname);
            email = (EditText) findViewById(R.id.regemail);
            username = (EditText) findViewById(R.id.regusername);
            password = (EditText) findViewById(R.id.regpassword);
            btnadd = (Button) findViewById(R.id.btnadd);

            adddata();

    }

    private boolean validatename(){
        String nameinput = name.getText().toString().trim();

        if(nameinput.isEmpty()){
            name.setError("FIELD CANNOT BE EMPTY");
            return false;
        }else if(!nameinput.matches("^[A-Za-z]+$")){
            name.setError("ENTER ONLY ALPHABETICAL CHARACTER");
            return false;
        } else{
            return true;
        }
    }

    private boolean validateemail(){
            String emailinput = email.getText().toString().trim();

            if(emailinput.isEmpty()){
                email.setError("INVALID EMAIL");
                return false;
            }else if(!Patterns.EMAIL_ADDRESS.matcher(emailinput).matches()){
                email.setError("INVALID EMAIL");
                return false;
            }else{
                return true;
            }
    }


   /*private boolean validatepassword(){
        String pass = password.getText().toString().trim();

        if(pass.isEmpty()){
            Toast.makeText(Register.this,"Invalid Password",Toast.LENGTH_LONG).show();
            return false;
        } /*else if(!PASSWORD_PATTERN.matcher(pass).matches()){
            Toast.makeText(Register.this,"Invalid Password",Toast.LENGTH_LONG).show();
            return false;
        }
        else {
            return true;
        }

    }*/

    private boolean validatePassword2(){
        String passwordInput = password.getEditableText().toString().trim();

        if(passwordInput.isEmpty()){
            password.setError("FIELD CANNOT BE EMPTY");
            return false;
        }else if(!PASSWORD_PATTERN.matcher(passwordInput).matches()){
            password.setError("PASSWORD IS TOO WEAK");
            return false;
        }else{
            password.setError(null);
            return true;
        }
    }

    private boolean validateUsername(){
        String user = username.getEditableText().toString().trim();

        if(user.isEmpty()){
            username.setError("FIELD CANNOT BE EMPTY");
            return false;
        }else{
            username.setError(null);
            return true;
        }
    }


    public void adddata(){

        btnadd.setOnClickListener(
            new View.OnClickListener(){
                public void onClick(View v){

                        validatename();
                        validateemail();
                        validatePassword2();
                        validateUsername();
                        if(validatename() && validateemail() && validatePassword2() && validateUsername() )
                        {
                            boolean isInserted = myDb.insertData(name.getText().toString(),
                                    email.getText().toString(),
                                    username.getText().toString(),
                                    password.getText().toString());

                            if (isInserted = true)
                                Toast.makeText(Register.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(Register.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                }
            }
        );


    }




}

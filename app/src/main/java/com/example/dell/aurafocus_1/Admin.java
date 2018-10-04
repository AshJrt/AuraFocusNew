package com.example.dell.aurafocus_1;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Admin extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^"+
                    //"(?=.*[0-9])" +
                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    // "(?=.*[@#$%^&+=])" +
                    //"(?=\\S+$)" +
                    ".{3,}" +
                    "$");

    DatabaseHelper mydb;
    TextView aduserid,adname,ademail,aduser,adpass;
    Button add;
    Button update;
    Button delete;
    Button viewall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        mydb = new DatabaseHelper(this);

        aduserid = (EditText)findViewById(R.id.aduserid);
        adname = (EditText)findViewById(R.id.adname);
        ademail = (EditText)findViewById(R.id.ademail);
        aduser = (EditText)findViewById(R.id.adusername);
        adpass = (EditText)findViewById(R.id.adpassword);
        add = (Button) findViewById(R.id.btnadd);
        update = (Button) findViewById(R.id.btnupdate);
        delete = (Button) findViewById(R.id.btndelete);
        viewall = (Button) findViewById(R.id.btnview);

        adddata();
        viewall();
        UpdateDate();
        DeleteData();
    }




    public void adddata() {

        add.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                        validatename();
                        validateemail();
                        validatePassword2();
                        validateUsername();
                        if (validatename() && validateemail() && validatePassword2() && validateUsername()) {
                            boolean isInserted = mydb.insertData(adname.getText().toString(),
                                    ademail.getText().toString(),
                                    aduser.getText().toString(),
                                    adpass.getText().toString());

                            if (isInserted = true)
                                Toast.makeText(Admin.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(Admin.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );


    }

    public void viewall(){
        viewall.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Cursor res =  mydb.getAllData();
                        if(res.getCount() == 0){
                            Toast.makeText(Admin.this, "No Data", Toast.LENGTH_LONG).show();
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("ID: "+ res.getString(0)+"\n");
                            buffer.append("Name: "+ res.getString(1)+"\n");
                            buffer.append("E-Mail: "+ res.getString(2)+"\n");
                            buffer.append("Username: "+ res.getString(3)+"\n");
                            buffer.append("Password: "+ res.getString(4)+"\n\n");

                        }

                        showMessages("Data",buffer.toString());

                    }
                }

        );

    }

    public void DeleteData(){
        delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deleteRows = mydb.deleteData(aduserid.getText().toString());
                        if(deleteRows > 0)
                            Toast.makeText(Admin.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Admin.this, "Data not Deleted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void UpdateDate(){
        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        validatename();
                        validateemail();
                        validatePassword2();
                        validateUsername();
                        if (validatename() && validateemail() && validatePassword2() && validateUsername()) {
                            boolean isUpdate = mydb.updateData(aduserid.getText().toString(), adname.getText().toString(), ademail.getText().toString(), aduser.getText().toString(), adpass.getText().toString());
                            if (isUpdate == true)
                                Toast.makeText(Admin.this, "Data Updated", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(Admin.this, "Data not Updated", Toast.LENGTH_LONG).show();
                        }
                    }

                }

        );
    }

    public void showMessages(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    private boolean validatename(){
        String nameinput = adname.getText().toString().trim();

        if(nameinput.isEmpty()){
            adname.setError("FIELD CANNOT BE EMPTY");
            return false;
        }else if(!nameinput.matches("^[A-Za-z]+$")){
            adname.setError("ENTER ONLY ALPHABETICAL CHARACTER");
            return false;
        } else{
            return true;
        }
    }

    private boolean validateemail(){
        String emailinput = ademail.getText().toString().trim();

        if(emailinput.isEmpty()){
            ademail.setError("INVALID EMAIL");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(emailinput).matches()){
            ademail.setError("INVALID EMAIL");
            return false;
        }else{
            return true;
        }
    }


    private boolean validateUsername(){
        String user = aduser.getEditableText().toString().trim();

        if(user.isEmpty()){
            aduser.setError("FIELD CANNOT BE EMPTY");
            return false;
        }else{
            aduser.setError(null);
            return true;
        }
    }




    private boolean validatePassword2(){
        String passwordInput = adpass.getEditableText().toString().trim();

        if(passwordInput.isEmpty()){
            adpass.setError("FIELD CANNOT BE EMPTY");
            return false;
        }else if(!PASSWORD_PATTERN.matcher(passwordInput).matches()){
            adpass.setError("PASSWORD IS TOO WEAK");
            return false;
        }else{
            adpass.setError(null);
            return true;
        }
    }

}

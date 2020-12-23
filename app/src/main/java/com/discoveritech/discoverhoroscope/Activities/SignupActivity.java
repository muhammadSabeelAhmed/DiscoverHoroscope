package com.discoveritech.discoverhoroscope.Activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.discoveritech.discoverhoroscope.GeneralClasses.Global;
import com.discoveritech.discoverhoroscope.GeneralClasses.PreferencesHandler;
import com.discoveritech.discoverhoroscope.GeneralClasses.User;
import com.discoveritech.discoverhoroscope.R;

public class SignupActivity extends Activity implements View.OnClickListener {

    private TextView lbl_signup;
    private EditText txt_full_name;
    private EditText txt_user_email;
    private EditText txt_password;
    private Button btn_signup;
    private TextView btn_already_account;
    private ImageView btn_back;
    private TextView lbl_by_pressing_cont;
    private TextView lbl_terms;
    private TextView lbl_pravicy_policy;
    private TextView versionText;
    private String btn_already_account_txt = "<font color=#FFFFFF>Already have?</font>" + " " + "<font color=#ffcc00>Sign In</font>";
    private String lbl_terms_txt = "<font color=#ffcc00>Terms </font>" + " " + "<font color=#FFFFFF>& </font>";
    private Global global;
    private String txt_full_name_txt;
    private String txt_user_email_txt;
    private PreferencesHandler preferencesHandler;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    private void Init() {
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        preferencesHandler = new PreferencesHandler(SignupActivity.this);

        lbl_signup = (TextView) findViewById(R.id.lbl_signup);
        global.SetView(SignupActivity.this, lbl_signup, false, true);

        txt_full_name = (EditText) findViewById(R.id.txt_full_name);
        global.SetView(SignupActivity.this, txt_full_name, false);

        txt_user_email = (EditText) findViewById(R.id.txt_user_email);
        global.SetView(SignupActivity.this, txt_user_email, false);

        txt_password = (EditText) findViewById(R.id.txt_user_password);
        global.SetView(SignupActivity.this, txt_password, false);

        btn_signup = (Button) findViewById(R.id.btn_signup);
        global.SetView(SignupActivity.this, btn_signup, false, true);
        btn_signup.setOnClickListener(this);

        btn_already_account = (TextView) findViewById(R.id.btn_already_account);
        global.SetView(SignupActivity.this, btn_already_account, false, true);
        btn_already_account.setText(Html.fromHtml(btn_already_account_txt));
        btn_already_account.setOnClickListener(this);

        lbl_by_pressing_cont = (TextView) findViewById(R.id.lbl_by_pressing_cont);
        global.SetView(SignupActivity.this, lbl_by_pressing_cont, false, true);

        lbl_terms = (TextView) findViewById(R.id.lbl_terms);
        global.SetView(SignupActivity.this, lbl_terms, false, true);
        lbl_terms.setText(Html.fromHtml(lbl_terms_txt));
        lbl_terms.setOnClickListener(this);

        lbl_pravicy_policy = (TextView) findViewById(R.id.lbl_pravicy_policy);
        global.SetView(SignupActivity.this, lbl_pravicy_policy, false, true);
        lbl_pravicy_policy.setOnClickListener(this);


        btn_back = (ImageView) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Init();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signup:
                global.HideKeyBoard(SignupActivity.this, v);

                if (fields_validation() == false) {

                } else {
                    final String txt_email = txt_user_email.getText().toString();
                    final String txt_username = txt_full_name.getText().toString();
                    final String password = txt_password.getText().toString();

                    if (Global.CheckInternetConnectivity(SignupActivity.this)) {
                        mAuth.createUserWithEmailAndPassword(txt_email, password).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignupActivity.this, "Account Created Successfully", Toast.LENGTH_LONG).show();
                                    User user = new User(txt_username, txt_email, password);
                                    DatabaseReference newRef = databaseReference.push();
                                    newRef.setValue(user);
                                    txt_user_email.setText("");
                                    txt_full_name.setText("");
                                    txt_password.setText("");
                                } else {
                                    Toast.makeText(SignupActivity.this, "fail to create account", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                }

                break;
            case R.id.btn_already_account:
                global.HideKeyBoard(SignupActivity.this, v);
                global.changeActivity(SignupActivity.this, new LoginActivity());
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
                break;

            case R.id.btn_back:
                global.HideKeyBoard(SignupActivity.this, v);
                global.changeActivity(SignupActivity.this, new LoginActivity());
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
                break;

            case R.id.lbl_pravicy_policy:
            /*    Intent browserIntentpolicy = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.casvpn.com/privacy-policy"));
                startActivity(browserIntentpolicy);*/
                break;

            case R.id.lbl_terms:
              /*  Intent browserIntentservices = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.casvpn.com/terms-of-services"));
                startActivity(browserIntentservices);*/
                break;
        }
    }

    public boolean fields_validation() {
        boolean valid = true;

        txt_full_name_txt = txt_full_name.getText().toString();
        txt_user_email_txt = txt_user_email.getText().toString();

        if (txt_full_name_txt.isEmpty()) {
            Toast.makeText(SignupActivity.this, R.string.rd_full_name, Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (txt_user_email_txt.isEmpty() || !txt_user_email_txt.matches(global.emailPattern)) {
            Toast.makeText(SignupActivity.this, R.string.rd_email, Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (txt_user_email_txt.isEmpty() || !txt_user_email_txt.matches(global.emailPattern) || txt_password.getText().toString().isEmpty()) {
            Toast.makeText(SignupActivity.this, R.string.re_password, Toast.LENGTH_SHORT).show();
            valid = false;
        }

        return valid;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Global.ReleaseMemoryOnDestory();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();

//        global.HideKeyBoard(ResetPasswordActivity.this, v);
        global.changeActivity(SignupActivity.this, new LoginActivity());
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

}


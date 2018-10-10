package eai.uts_dimasdwicahya_1202152166;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import android.content.Intent;
import android.util.Log;



public class MainActivity extends AppCompatActivity {
    private CallbackManager callbackManager;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // membuat callbackManager//
        setContentView(R.layout.activity_main);

        // inisialisasi callbackManager//
        callbackManager = CallbackManager.Factory.create();

        // Daftarkan callback//
        LoginManager.getInstance().registerCallback(callbackManager,

                // Kalo login berhasil//
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        //Tampilkan id user/
                        Log.d(TAG, "User ID: " +
                                loginResult.getAccessToken().getUserId() + "\n" +
                                "Auth Token: " + loginResult.getAccessToken().getToken());
                    }

                    // kalo di cancel//
                    @Override
                    public void onCancel() {
                    }

                    //kalau eror loginnya/
                    @Override
                    public void onError(FacebookException exception) {
                    }
                });
    }

    // Override the onActivityResult method and pass its parameters to the callbackManager//
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }



}
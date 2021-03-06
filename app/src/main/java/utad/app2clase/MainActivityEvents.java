package utad.app2clase;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthException;

import utad.app2clase.MainActivity;
import utad.app2clase.firebase.FirebaseAdminListener;
import utad.milib.Fragments.LoginFragmentListener;
import utad.milib.Fragments.RegisterFragmentListener;

/**
 * Created by Juanma on 21/11/17.
 */

public class MainActivityEvents implements LoginFragmentListener, RegisterFragmentListener, FirebaseAdminListener {


    private MainActivity mainActivity;
    private SecondActivity secondActivity;

    public MainActivityEvents(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    public void OnRegisteredClicked() {
        android.support.v4.app.FragmentTransaction transition = mainActivity.getSupportFragmentManager().beginTransaction();
        transition.hide(this.mainActivity.getLoginFragment());
        transition.show(this.mainActivity.getRegisterFragment());
        transition.commit();

    }



    @Override
    public void OnLoginClicked() {
        this.signInWithEmailAndPassword(this.mainActivity.getLoginFragment().getTxtEmail().getText().toString(), this.mainActivity.getLoginFragment().getTxtPass().getText().toString());

    }


    public void OnClickRegistered() {

        this.createUserWithEmailAndPassword(this.mainActivity.getRegisterFragment().getTxtEmail().getText().toString(), this.mainActivity.getRegisterFragment().getTxtPass().getText().toString());

    }


    @Override
    public void createUserWithEmailAndPassword(String emailAddress, String password) {
        System.out.println("Email: " + emailAddress + " Pass: " + password);
        this.mainActivity.getFirebaseAdmin().getmAuth().createUserWithEmailAndPassword(emailAddress, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            mainActivity.getFirebaseAdmin().getmAuth().signOut();
                            android.support.v4.app.FragmentTransaction transition = mainActivity.getSupportFragmentManager().beginTransaction();
                            transition.hide(mainActivity.getRegisterFragment());
                            transition.show(mainActivity.getLoginFragment());
                            transition.commit();
                        }
                    }
                });
    }

    @Override
    public void signInWithEmailAndPassword(String emailAddress, String password) {
        System.out.println("EmailAcceso: " + emailAddress + " PassAcceso: " + password);
        if (this.mainActivity.getFirebaseAdmin().getmAuth().getCurrentUser() != null) {
            // Already signed in
            // Do nothing
            System.out.println("    ESTOY LOGUEADO!!!!!!!!!");
            secondActivity = new SecondActivity();
            Intent intent = new Intent(mainActivity, SecondActivity.class);
            mainActivity.startActivity(intent);
            mainActivity.finish();
        } else {
            this.mainActivity.getFirebaseAdmin().getmAuth().signInWithEmailAndPassword(emailAddress, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            System.out.println("ACABO DE LOGUEARME!!!!!!!!");
                            if (task.isSuccessful()) {
                                System.out.println("LOGUEADO CORRECTO");
                                Intent intent = new Intent(mainActivity, SecondActivity.class);
                                mainActivity.startActivity(intent);
                                mainActivity.finish();
                            }
                            else{
                                System.out.println("NOPE "+task.getResult());
                            }
                        }
                    });
        }
    }

    @Override
    public void logOut() {



    }


}

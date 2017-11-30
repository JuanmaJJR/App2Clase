package utad.app2clase;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.view.View;


import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import utad.app2clase.firebase.FirebaseAdminListener;

/**
 * Created by Juanma on 25/11/17.
 */

public class SecondActivityEvents implements View.OnClickListener,FirebaseAdminListener {

    private SecondActivity secondActivity;

    public SecondActivityEvents(SecondActivity secondActivity) {
        this.secondActivity = secondActivity;
    }

    public SecondActivity getSecondActivity() {
        return secondActivity;
    }

    public void setSecondActivity(SecondActivity secondActivity) {
        this.secondActivity = secondActivity;
    }

    @Override
    public void createUserWithEmailAndPassword(String emailAddress, String password) {

    }

    @Override
    public void signInWithEmailAndPassword(String emailAddress, String password) {

    }

    @Override
    public void logOut() {
        DataHolder.MyDataHolder.getFirebaseAuth().signOut();

        Intent intent = new Intent(secondActivity, MainActivity.class);
        secondActivity.startActivity(intent);
        secondActivity.finish();

    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnLogOut){
            this.logOut();

        }
    }
}

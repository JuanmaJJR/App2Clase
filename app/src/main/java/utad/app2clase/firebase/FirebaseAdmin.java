package utad.app2clase.firebase;

import android.widget.DatePicker;



import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import utad.app2clase.DataHolder;

/**
 * Created by Juanma on 25/11/17.
 */

public class FirebaseAdmin {

    private FirebaseAuth mAuth;

    public FirebaseAdmin() {
        this.onCreate();
    }

    public void onCreate() {
        this.setmAuth(FirebaseAuth.getInstance());
        DataHolder.MyDataHolder.setFirebaseAuth(this.getmAuth());

    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }

    public void setmAuth(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }


}

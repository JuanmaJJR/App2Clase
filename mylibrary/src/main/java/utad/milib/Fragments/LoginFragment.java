package utad.milib.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import utad.mylibrary.R;


public class LoginFragment extends Fragment {
    private Button btnRegistrar, btnLogin;
    LoginFragmentListener loginFragmentListener;
    LoginFragmentEvents loginFragmentEvents;

    public void setListener(LoginFragmentListener loginFragmentListener) {
        this.loginFragmentListener = loginFragmentListener;
    }
    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        this.setListener(loginFragmentListener);
        loginFragmentEvents = new LoginFragmentEvents(this);

        btnRegistrar=v.findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(loginFragmentEvents);

        btnLogin=v.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(loginFragmentEvents);

        return v;
    }

    public Button getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(Button btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public Button getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(Button btnLogin) {
        this.btnLogin = btnLogin;
    }

    public LoginFragmentListener getLoginFragmentListener() {
        return loginFragmentListener;
    }

    public void setLoginFragmentListener(LoginFragmentListener loginFragmentListener) {
        this.loginFragmentListener = loginFragmentListener;
    }

    public LoginFragmentEvents getLoginFragmentEvents() {
        return loginFragmentEvents;
    }

    public void setLoginFragmentEvents(LoginFragmentEvents loginFragmentEvents) {
        this.loginFragmentEvents = loginFragmentEvents;
    }
}

class LoginFragmentEvents implements View.OnClickListener{
        LoginFragment loginFragment;
    public LoginFragmentEvents(LoginFragment loginFragment){
            this.loginFragment=loginFragment;
        }

        @Override
        public void onClick(View v) {
            if (v.getId()==R.id.btnRegistrar){
                if (this.loginFragment.loginFragmentListener!=null);
                this.loginFragment.loginFragmentListener.OnRegisterClicked();
            }else if (v.getId()==R.id.btnLogin){
                if (this.loginFragment.loginFragmentListener!=null);
                this.loginFragment.loginFragmentListener.OnLoginClicked();
            }

        }
}

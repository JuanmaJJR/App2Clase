package utad.milib.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import utad.mylibrary.R;


public class LoginFragment extends Fragment {
    private EditText txtEmail, txtPass;
    private Button btnRegister, btnLogin;
    private LoginFragmentEvents events;
    private LoginFragmentListener listener;

    public LoginFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Dado que métodos como el findViewById pertenece a la clase AppCompatActivity necesitamos guardar el fragment en una View para invocar este métodos
        View fragmentLoginView = inflater.inflate(R.layout.fragment_login, container, false);

        //Vinculamos las variables con los componentes y con el String.xml
        this.btnRegister =(Button) fragmentLoginView.findViewById(R.id.btnRegister);
        this.btnLogin =(Button) fragmentLoginView.findViewById(R.id.btnLogin);
        this.txtEmail =(EditText) fragmentLoginView.findViewById(R.id.txtEmailRegistro);
        this.txtPass =(EditText) fragmentLoginView.findViewById(R.id.txtPass);

      //  this.btnRegister.setText(R.string.btnRegister);
        // this.btnLogin.setText(R.string.btnLogin);


        //Inicializamos el LoginFragmentEvents pasándole por parámetro el propio LoginFragment
        events=new LoginFragmentEvents(this);
        //Seteamos el escuchador para los botones. Events para a escuchar a los botones btnRegister y btnLogin
        btnRegister.setOnClickListener(events);
        btnLogin.setOnClickListener(events);

        //
        return fragmentLoginView;
    }



    public EditText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(EditText txtEmail) {
        this.txtEmail = txtEmail;
    }

    public EditText getTxtPass() {
        return txtPass;
    }

    public void setTxtPass(EditText txtPass) {
        this.txtPass = txtPass;
    }

    public Button getBtnRegister() {
        return btnRegister;
    }

    public void setBtnRegister(Button btnRegister) {
        this.btnRegister = btnRegister;
    }

    public Button getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(Button btnLogin) {
        this.btnLogin = btnLogin;
    }

    public LoginFragmentEvents getEvents() {
        return events;
    }

    public void setEvents(LoginFragmentEvents events) {
        this.events = events;
    }

    public LoginFragmentListener getLoginFragmentListener() {
        return listener;
    }

    public void setLoginFragmentListener(LoginFragmentListener listener) {
        this.listener = listener;
    }
}

    class LoginFragmentEvents implements View.OnClickListener {
    private LoginFragment loginFragment;

    public LoginFragmentEvents(LoginFragment loginFragment) {
        //Mediante el constructor seteamos el LoginFragment para poder usarlo para llamar al listener
        this.loginFragment = loginFragment;
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnRegister){
            if(this.loginFragment.getLoginFragmentListener()!=null)
                System.out.println("click registro");
            this.loginFragment.getLoginFragmentListener().OnRegisteredClicked();
        }
        else if(view.getId() == R.id.btnLogin){
            if(this.loginFragment.getLoginFragmentListener()!=null)
                this.loginFragment.getLoginFragmentListener().OnLoginClicked();
        }
    }


}

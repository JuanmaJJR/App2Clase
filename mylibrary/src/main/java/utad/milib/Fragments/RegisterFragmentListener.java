package utad.milib.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import utad.mylibrary.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegisterFragmentsListener.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegisterFragmentsListener#newInstance} factory method to
 * create an instance of this fragment.
 */

public interface RegisterFragmentListener {
    public void OnCancelarClicked();
    public void OnAceptarClicked();
}

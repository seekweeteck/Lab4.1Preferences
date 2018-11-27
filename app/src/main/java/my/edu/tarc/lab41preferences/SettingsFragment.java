package my.edu.tarc.lab41preferences;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {
    private static final String USER_NAME = "my.edu.tarc.lab41preferences.NAME";
    private static final String USER_GENDER = "my.edu.tarc.lab41preferences.GENDER";
    private EditText editTextName;
    private RadioGroup radioGroupGender;
    private ImageView imageViewProfile;

    private SharedPreferences mPreferences;
    private String sharedPrefFile = "my.edu.tarc.lab41preferences";

    private String name="";
    private int gender=-1;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        editTextName = view.findViewById(R.id.editTextName);
        radioGroupGender = view.findViewById(R.id.radioGroupGender);
        imageViewProfile = view.findViewById(R.id.imageViewProfile);

        //Shared Preference
        mPreferences = getActivity().getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString(USER_NAME, name);
        preferencesEditor.putInt(USER_GENDER, gender);
        preferencesEditor.apply();
    }
}

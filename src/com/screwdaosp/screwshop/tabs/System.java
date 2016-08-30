package com.screwdaosp.screwshop.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.screwdaosp.screwshop.PowerMenuActions;
import com.screwdaosp.screwshop.R;

/**
 * Created by cedwards on 6/3/2016.
 */
public class System extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {

    private static final String KEY_POWER_MENU = "power_menu";

    private Preference mPowerMenu;


    public System() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.system_tab);

        mPowerMenu = (Preference) findPreference(KEY_POWER_MENU);
        mPowerMenu.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == mPowerMenu) {
            //Intent intent = new Intent(getActivity(), PowerMenuActions.class);
            //startActivity(intent);
             getFragmentManager().beginTransaction().replace(android.R.id.content,
                new PowerMenuActions()).commit();
            return true;
        }

        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    public boolean onPreferenceChange(Preference preference, Object objValue) {
        final String key = preference.getKey();
        return true;
    }
}

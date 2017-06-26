package ai.api.narato;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
public class AISettingsActivity extends BaseActivity implements
        View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {

    private CheckBox bluetoothSwitch;
    private Switch agentSwitch;

    private SettingsManager settingsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settingsManager = ((AIApplication) getApplication()).getSettingsManager();

        ViewGroup bluetoothSection = (ViewGroup) findViewById(R.id.activity_settings_bluetooth_section);
        //ViewGroup agentSection = (ViewGroup) findViewById(R.id.activity_settings_agent_section);
        bluetoothSection.setOnClickListener(this);
        //agentSection.setOnClickListener(this);

        bluetoothSwitch = (CheckBox) findViewById(R.id.activity_settings_bluetooth_swith);
        //agentSwitch = (Switch) findViewById(R.id.Load_Video_Agent);
        bluetoothSwitch.setChecked(settingsManager.isUseBluetooth());
        bluetoothSwitch.setOnCheckedChangeListener(this);
        //agentSwitch.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_settings_bluetooth_section:
                bluetoothSwitch.performClick();
                break;
            //case R.id.activity_settings_agent_section:
                //agentSwitch.performClick();
                //break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.activity_settings_bluetooth_swith:
                settingsManager.setUseBluetooth(isChecked);
                break;
            //case R.id.Load_Video_Agent:
                //settingsManager.ChangeToken(isChecked);
                //break;
        }
    }
}

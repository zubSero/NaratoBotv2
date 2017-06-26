package ai.api.narato;

import android.content.Context;
import android.content.SharedPreferences;

import ai.api.util.BluetoothController;
public class SettingsManager {

    private static final String SETTINGS_PREFS_NAME = "ai.api.APP_SETTINGS";
    private static final String PREF_USE_BLUETOOTH = "USE_BLUETOOTH";
    private static final String PREF_CHANGE_VIDEO = "LOAD_VIDEO_AGENT";

    private final Context context;
    private SharedPreferences prefs;

    private boolean useBluetooth;
    private  boolean changeAgent;

    public SettingsManager(final Context context) {
        this.context = context;
        prefs = context.getSharedPreferences(SETTINGS_PREFS_NAME, Context.MODE_PRIVATE);

        useBluetooth = prefs.getBoolean(PREF_USE_BLUETOOTH, true);
        changeAgent = prefs.getBoolean(PREF_CHANGE_VIDEO, true);

    }

    public void setUseBluetooth(final boolean useBluetooth) {
        this.useBluetooth = useBluetooth;

        prefs.edit().putBoolean(PREF_USE_BLUETOOTH, useBluetooth).commit();
        final BluetoothController controller = ((AIApplication) context.getApplicationContext()).getBluetoothController();
        if (useBluetooth) {
            controller.start();
        } else {
            controller.stop();
        }
    }
    public void ChangeToken(final boolean changeAgent) {
        this.changeAgent = changeAgent;

        prefs.edit().putBoolean(PREF_CHANGE_VIDEO, changeAgent).commit();

        if (changeAgent) {
            //Config.ACCESS_TOKEN = "925f605bded8470eab2bace57ea7395e";
        } else {
            //Config.ACCESS_TOKEN = "959ebd5ccbe4470cb49c4a74ad20db6d";
        }
    }

    public boolean isUseBluetooth() {
        return useBluetooth;
    }
    public boolean isVideoAgent() {
        return changeAgent;
    }
}

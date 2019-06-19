package ke.co.muniu.wifiscanner;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getWifiInfo(View view){


    WifiManager wifiManager =(WifiManager)getApplicationContext().getSystemService(getApplicationContext().WIFI_SERVICE);
    //this will give the permission to access Wifi

       if(wifiManager.isWifiEnabled()) {
           WifiInfo wifiInfo = wifiManager.getConnectionInfo();
           //this code will get the wifi info if it is on or off.

           if (String.valueOf(wifiInfo.getSupplicantState()).equals("COMPLETED")) {
               //COMPLETED means our connection is authenticated
               Toast.makeText(this, wifiInfo.getSSID(), Toast.LENGTH_SHORT).show();

           } else {
               Toast.makeText(this, "please connect to Wifi", Toast.LENGTH_SHORT).show();
               //this will show message that connect to Wifi
           }

       }
              else {
           wifiManager.setWifiEnabled(true);
           //this will enable Wifi
       }
}
}

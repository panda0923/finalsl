package com.example.finalsl;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;



import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class OutRequestActivity extends FragmentActivity {
	GoogleMap map;
	public static final int RESPONSE_CODE_OK = 200;
	public static final int RESPONSE_CODE_ERROR = 400;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_out_request);
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		
		startLocationService();
	}
    private void startLocationService() {
     
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        GPSListener gpsListener = new GPSListener();
        long minTime = 10000;
        float minDistance = 0;

        manager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                minTime,
                minDistance,
                gpsListener);

        manager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                
                
                minTime,
                minDistance,
                gpsListener);

        Toast.makeText(getApplicationContext(), "������ġã����", Toast.LENGTH_SHORT).show();
      
    }

   
    private class GPSListener implements LocationListener {
      
        public void onLocationChanged(Location location) {
            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();

            String msg = "Latitude : "+ latitude + "\nLongitude:"+ longitude;
            Log.i("GPSLocationService", msg);

            showCurrentLocation1(latitude, longitude);
        }

        public void onProviderDisabled(String provider) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

    }

   
    private void showCurrentLocation1(Double latitude, Double longitude) {
     
        LatLng curPoint = new LatLng(latitude, longitude);

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15));


        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    }




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.out_request, menu);
		return true;
	}
	public void onLocationChaged(Location location){
		Double logitude = null;
		Double latitude = null;
		showCurrentLocation1(latitude,logitude);
	}
	private void showCurrentLocation(Double latitude,Double longitude){
		LatLng curPoint = null;
		map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15));
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

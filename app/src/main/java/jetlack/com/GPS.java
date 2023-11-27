package jetlack.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GPS extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    EditText txtlatitud,txtlongitud;
    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        txtlatitud=findViewById(R.id.txtlatitud);
        txtlongitud=findViewById(R.id.txtlongitud);


        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap=googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);
        LatLng chile =new LatLng(-36.6124536,-72.1243113);
        mMap.addMarker(new MarkerOptions().position(chile).title("Chile"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(chile));

    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txtlatitud.setText(""+latLng.latitude);
        txtlongitud.setText(""+latLng.longitude);

    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtlatitud.setText(""+latLng.latitude);
        txtlongitud.setText(""+latLng.longitude);

    }
}
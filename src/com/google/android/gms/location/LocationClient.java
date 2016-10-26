package com.google.android.gms.location;

import android.location.Location;

public interface LocationClient {

	void connect();

	void disconnect();

	Location getLastLocation();

}

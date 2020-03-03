package com.revature.services;

import com.revature.beans.Location;

public interface LocationService {
	Location create(Location location);
	Location getById(Integer id);
	Location updateLocation(Location location);
}

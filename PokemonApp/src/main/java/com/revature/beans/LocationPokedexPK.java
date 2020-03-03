package com.revature.beans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class LocationPokedexPK implements Serializable {
	@Column(name="location_id")
	private Integer locationId;
	@Column(name="pokedex_id")
	private Integer pokedexId;
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public Integer getPokedexId() {
		return pokedexId;
	}
	public void setPokedexId(Integer pokedexId) {
		this.pokedexId = pokedexId;
	}
    @Override
    public int hashCode() {
        return Objects.hash(locationId, pokedexId);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        LocationPokedexPK that = (LocationPokedexPK) o;
        return Objects.equals(locationId, that.locationId) &&
               Objects.equals(pokedexId, that.pokedexId);
    }
	@Override
	public String toString() {
		return "LocationPokedexPK [locationId=" + locationId + ", pokedexId=" + pokedexId + "]";
	}
	
}

package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="location_pokedex")
public class LocationPokedex {
	@EmbeddedId
	private LocationPokedexPK id;
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("locationId")
	@JoinColumn(insertable=false, updatable=false)
	@JsonIgnoreProperties({"north", "east", "south", "west", "pokemon", "hibernateLazyInitializer", "handler"})
    private Location location;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pokedexId")
    @JoinColumn(insertable=false, updatable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Pokedex pokedex;
	@Column(name="min_level")
	private Integer minLevel;
	@Column(name="max_level")
	private Integer maxLevel;
	public LocationPokedexPK getId() {
		return id;
	}
	public void setId(LocationPokedexPK id) {
		this.id = id;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Pokedex getPokedex() {
		return pokedex;
	}
	public void setPokedex(Pokedex pokedex) {
		this.pokedex = pokedex;
	}
	public Integer getMinLevel() {
		return minLevel;
	}
	public void setMinLevel(Integer minLevel) {
		this.minLevel = minLevel;
	}
	public Integer getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(Integer maxLevel) {
		this.maxLevel = maxLevel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((maxLevel == null) ? 0 : maxLevel.hashCode());
		result = prime * result + ((minLevel == null) ? 0 : minLevel.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationPokedex other = (LocationPokedex) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maxLevel == null) {
			if (other.maxLevel != null)
				return false;
		} else if (!maxLevel.equals(other.maxLevel))
			return false;
		if (minLevel == null) {
			if (other.minLevel != null)
				return false;
		} else if (!minLevel.equals(other.minLevel))
			return false;
		return true;
	}
	@Override
	public String toString() {
		String str = "";
		str += "LocationPokedex [id=" + id;
		/*if(location != null) {
			str += ", location=" + location.getName();
		} else {
			str += ", location=null";
		}
		if(pokedex != null) {
			str += ", pokedex=" + pokedex.getName();
		} else {
			str += ", pokedex=null";
		}*/
		str += ", minLevel=" + minLevel + ", maxLevel=" + maxLevel + "]";
		
		return str;
	}
	
}

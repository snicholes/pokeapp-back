package com.revature.beans;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="location")
	@SequenceGenerator(name="location", sequenceName="location_seq", allocationSize=1)
	private Integer id;
	private String name;
	@ManyToOne
	@JoinColumn(name="north_id")
	@JsonIgnoreProperties({"north", "east", "south", "west", "pokemon"})
	private Location north;
	@ManyToOne
	@JoinColumn(name="east_id")
	@JsonIgnoreProperties({"north", "east", "south", "west", "pokemon"})
	private Location east;
	@ManyToOne
	@JoinColumn(name="south_id")
	@JsonIgnoreProperties({"north", "east", "south", "west", "pokemon"})
	private Location south;
	@ManyToOne
	@JoinColumn(name="west_id")
	@JsonIgnoreProperties({"north", "east", "south", "west", "pokemon"})
	private Location west;
	@OneToMany(mappedBy="location")
	@JsonProperty("pokemon")
	private Set<LocationPokedex> pokemon;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location getNorth() {
		return north;
	}
	public void setNorth(Location north) {
		this.north = north;
	}
	public Location getEast() {
		return east;
	}
	public void setEast(Location east) {
		this.east = east;
	}
	public Location getSouth() {
		return south;
	}
	public void setSouth(Location south) {
		this.south = south;
	}
	public Location getWest() {
		return west;
	}
	public void setWest(Location west) {
		this.west = west;
	}
	public Set<LocationPokedex> getPokemon() {
		return pokemon;
	}
	public void setPokemon(Set<LocationPokedex> pokemon) {
		this.pokemon = pokemon;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((east == null) ? 0 : east.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((north == null) ? 0 : north.hashCode());
		result = prime * result + ((pokemon == null) ? 0 : pokemon.hashCode());
		result = prime * result + ((south == null) ? 0 : south.hashCode());
		result = prime * result + ((west == null) ? 0 : west.hashCode());
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
		Location other = (Location) obj;
		if (east == null) {
			if (other.east != null)
				return false;
		} else if (!east.equals(other.east))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (north == null) {
			if (other.north != null)
				return false;
		} else if (!north.equals(other.north))
			return false;
		if (pokemon == null) {
			if (other.pokemon != null)
				return false;
		} else if (!pokemon.equals(other.pokemon))
			return false;
		if (south == null) {
			if (other.south != null)
				return false;
		} else if (!south.equals(other.south))
			return false;
		if (west == null) {
			if (other.west != null)
				return false;
		} else if (!west.equals(other.west))
			return false;
		return true;
	}
	@Override
	public String toString() {
		String str = "";
		str += "Location [id=" + id + ", name=" + name;
		if(north!=null) {
			str += ", north=" + north.getId();
		} else {
			str += ", north=null";
		}
		if(east!=null) {
			str += ", east=" + east.getId();
		} else {
			str += ", east=null";
		}
		if(south!=null) {
			str += ", south=" + south.getId();
		} else {
			str += ", south=null";
		}
		if(west!=null) {
			str += ", west=" + west.getId();
		} else {
			str += ", west=null";
		}
		str += ", pokemon=" + pokemon + "]";
		return str;
	}
	
}

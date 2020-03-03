package com.revature.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Pokedex {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pokedex")
	@SequenceGenerator(name="pokedex", sequenceName="pokedex_seq", allocationSize=1)
	private Integer pokedexId;
	private String name;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="pokedex_type", joinColumns=@JoinColumn(name="pokedex_id"), inverseJoinColumns=@JoinColumn(name="type_id"))
	private Set<Type> types;
	@OneToMany(mappedBy="pokedex")
	private Set<LocationPokedex> location;
	public Integer getPokedexId() {
		return pokedexId;
	}
	public void setPokedexId(Integer pokedexId) {
		this.pokedexId = pokedexId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Type> getTypes() {
		return types;
	}
	public void setTypes(Set<Type> types) {
		this.types = types;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pokedexId == null) ? 0 : pokedexId.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
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
		Pokedex other = (Pokedex) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pokedexId == null) {
			if (other.pokedexId != null)
				return false;
		} else if (!pokedexId.equals(other.pokedexId))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pokedex [pokedexId=" + pokedexId + ", name=" + name + ", types=" + types + "]";
	}
}

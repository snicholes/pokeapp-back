package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Pokemon {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pokemon")
	@SequenceGenerator(name="pokemon", sequenceName="pokemon_seq")
	private Integer id;
	private String nickname;
	private Integer lvl;
	private Integer hp;
	@Column(name="max_hp")
	private Integer maxHp;
	private Integer shiny;
	@Column(name="exp_pts")
	private Integer expPts;
	@ManyToOne
	@JoinColumn(name="pokedex_id")
	@JsonIgnoreProperties({"locations", "hibernateLazyInitializer", "handler"})
	private Pokedex pokedex;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="owner_id")
	@JsonIgnoreProperties({"pokemon"})
	private Person owner;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getLvl() {
		return lvl;
	}
	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}
	public Integer getHp() {
		return hp;
	}
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	public Integer getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(Integer maxHp) {
		this.maxHp = maxHp;
	}
	public Integer getShiny() {
		return shiny;
	}
	public void setShiny(Integer shiny) {
		this.shiny = shiny;
	}
	public Integer getExpPts() {
		return expPts;
	}
	public void setExpPts(Integer expPts) {
		this.expPts = expPts;
	}
	public Pokedex getPokedex() {
		return pokedex;
	}
	public void setPokedex(Pokedex pokedex) {
		this.pokedex = pokedex;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expPts == null) ? 0 : expPts.hashCode());
		result = prime * result + ((hp == null) ? 0 : hp.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lvl == null) ? 0 : lvl.hashCode());
		result = prime * result + ((maxHp == null) ? 0 : maxHp.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((pokedex == null) ? 0 : pokedex.hashCode());
		result = prime * result + ((shiny == null) ? 0 : shiny.hashCode());
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
		Pokemon other = (Pokemon) obj;
		if (expPts == null) {
			if (other.expPts != null)
				return false;
		} else if (!expPts.equals(other.expPts))
			return false;
		if (hp == null) {
			if (other.hp != null)
				return false;
		} else if (!hp.equals(other.hp))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lvl == null) {
			if (other.lvl != null)
				return false;
		} else if (!lvl.equals(other.lvl))
			return false;
		if (maxHp == null) {
			if (other.maxHp != null)
				return false;
		} else if (!maxHp.equals(other.maxHp))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (pokedex == null) {
			if (other.pokedex != null)
				return false;
		} else if (!pokedex.equals(other.pokedex))
			return false;
		if (shiny == null) {
			if (other.shiny != null)
				return false;
		} else if (!shiny.equals(other.shiny))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nickname=" + nickname + ", lvl=" + lvl + ", hp=" + hp + ", maxHp=" + maxHp
				+ ", shiny=" + shiny + ", expPts=" + expPts + ", pokedex=" + pokedex + ", owner=" + owner + "]";
	}
	
}

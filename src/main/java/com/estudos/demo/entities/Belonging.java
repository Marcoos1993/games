package com.estudos.demo.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

	@EmbeddedId
	private BelongigPK id = new BelongigPK();
	
	private String position;
	
	public Belonging() {
	}

	public Belonging(Game game, GameList list, String position) {
		id.setGame(game);
		id.setGameList(list);
		this.position = position;
	}

	public Game getGame() {
		return id.getGame();
	}

	public void setGame(Game game) {
		id.setGame(game);
	}
	
	public GameList getList() {
		return id.getGameList();
	}

	public void setGameList(GameList list) {
		id.setGameList(list);
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}

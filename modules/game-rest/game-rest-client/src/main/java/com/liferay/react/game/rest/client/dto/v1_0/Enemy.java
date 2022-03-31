package com.liferay.react.game.rest.client.dto.v1_0;

import com.liferay.react.game.rest.client.function.UnsafeSupplier;
import com.liferay.react.game.rest.client.serdes.v1_0.EnemySerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Charles Pederson
 * @generated
 */
@Generated("")
public class Enemy implements Cloneable, Serializable {

	public static Enemy toDTO(String json) {
		return EnemySerDes.toDTO(json);
	}

	public Ability[] getAbilities() {
		return abilities;
	}

	public void setAbilities(Ability[] abilities) {
		this.abilities = abilities;
	}

	public void setAbilities(
		UnsafeSupplier<Ability[], Exception> abilitiesUnsafeSupplier) {

		try {
			abilities = abilitiesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Ability[] abilities;

	public Integer getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(Integer hitPoints) {
		this.hitPoints = hitPoints;
	}

	public void setHitPoints(
		UnsafeSupplier<Integer, Exception> hitPointsUnsafeSupplier) {

		try {
			hitPoints = hitPointsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer hitPoints;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long id;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setImage(
		UnsafeSupplier<String, Exception> imageUnsafeSupplier) {

		try {
			image = imageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String image;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public void setLevel(
		UnsafeSupplier<Integer, Exception> levelUnsafeSupplier) {

		try {
			level = levelUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	public Integer getXpDrop() {
		return xpDrop;
	}

	public void setXpDrop(Integer xpDrop) {
		this.xpDrop = xpDrop;
	}

	public void setXpDrop(
		UnsafeSupplier<Integer, Exception> xpDropUnsafeSupplier) {

		try {
			xpDrop = xpDropUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer xpDrop;

	@Override
	public Enemy clone() throws CloneNotSupportedException {
		return (Enemy)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Enemy)) {
			return false;
		}

		Enemy enemy = (Enemy)object;

		return Objects.equals(toString(), enemy.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return EnemySerDes.toJSON(this);
	}

}
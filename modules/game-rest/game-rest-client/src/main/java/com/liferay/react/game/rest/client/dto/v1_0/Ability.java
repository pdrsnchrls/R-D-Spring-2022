package com.liferay.react.game.rest.client.dto.v1_0;

import com.liferay.react.game.rest.client.function.UnsafeSupplier;
import com.liferay.react.game.rest.client.serdes.v1_0.AbilitySerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Charles Pederson
 * @generated
 */
@Generated("")
public class Ability implements Cloneable, Serializable {

	public static Ability toDTO(String json) {
		return AbilitySerDes.toDTO(json);
	}

	public Boolean getHealing() {
		return healing;
	}

	public void setHealing(Boolean healing) {
		this.healing = healing;
	}

	public void setHealing(
		UnsafeSupplier<Boolean, Exception> healingUnsafeSupplier) {

		try {
			healing = healingUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean healing;

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

	@Override
	public Ability clone() throws CloneNotSupportedException {
		return (Ability)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Ability)) {
			return false;
		}

		Ability ability = (Ability)object;

		return Objects.equals(toString(), ability.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return AbilitySerDes.toJSON(this);
	}

}
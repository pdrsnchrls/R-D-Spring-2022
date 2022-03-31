/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.react.game.core.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Ability}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Ability
 * @generated
 */
public class AbilityWrapper
	extends BaseModelWrapper<Ability>
	implements Ability, ModelWrapper<Ability> {

	public AbilityWrapper(Ability ability) {
		super(ability);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("abilityId", getAbilityId());
		attributes.put("abilityName", getAbilityName());
		attributes.put("healing", isHealing());
		attributes.put("hitPoints", getHitPoints());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long abilityId = (Long)attributes.get("abilityId");

		if (abilityId != null) {
			setAbilityId(abilityId);
		}

		String abilityName = (String)attributes.get("abilityName");

		if (abilityName != null) {
			setAbilityName(abilityName);
		}

		Boolean healing = (Boolean)attributes.get("healing");

		if (healing != null) {
			setHealing(healing);
		}

		Integer hitPoints = (Integer)attributes.get("hitPoints");

		if (hitPoints != null) {
			setHitPoints(hitPoints);
		}
	}

	@Override
	public Ability cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ability ID of this ability.
	 *
	 * @return the ability ID of this ability
	 */
	@Override
	public long getAbilityId() {
		return model.getAbilityId();
	}

	/**
	 * Returns the ability name of this ability.
	 *
	 * @return the ability name of this ability
	 */
	@Override
	public String getAbilityName() {
		return model.getAbilityName();
	}

	/**
	 * Returns the healing of this ability.
	 *
	 * @return the healing of this ability
	 */
	@Override
	public boolean getHealing() {
		return model.getHealing();
	}

	/**
	 * Returns the hit points of this ability.
	 *
	 * @return the hit points of this ability
	 */
	@Override
	public int getHitPoints() {
		return model.getHitPoints();
	}

	/**
	 * Returns the primary key of this ability.
	 *
	 * @return the primary key of this ability
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this ability.
	 *
	 * @return the uuid of this ability
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this ability is healing.
	 *
	 * @return <code>true</code> if this ability is healing; <code>false</code> otherwise
	 */
	@Override
	public boolean isHealing() {
		return model.isHealing();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ability ID of this ability.
	 *
	 * @param abilityId the ability ID of this ability
	 */
	@Override
	public void setAbilityId(long abilityId) {
		model.setAbilityId(abilityId);
	}

	/**
	 * Sets the ability name of this ability.
	 *
	 * @param abilityName the ability name of this ability
	 */
	@Override
	public void setAbilityName(String abilityName) {
		model.setAbilityName(abilityName);
	}

	/**
	 * Sets whether this ability is healing.
	 *
	 * @param healing the healing of this ability
	 */
	@Override
	public void setHealing(boolean healing) {
		model.setHealing(healing);
	}

	/**
	 * Sets the hit points of this ability.
	 *
	 * @param hitPoints the hit points of this ability
	 */
	@Override
	public void setHitPoints(int hitPoints) {
		model.setHitPoints(hitPoints);
	}

	/**
	 * Sets the primary key of this ability.
	 *
	 * @param primaryKey the primary key of this ability
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this ability.
	 *
	 * @param uuid the uuid of this ability
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected AbilityWrapper wrap(Ability ability) {
		return new AbilityWrapper(ability);
	}

}
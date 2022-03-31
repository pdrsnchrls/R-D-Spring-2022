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
 * This class is a wrapper for {@link PlayerEnemyAbility}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlayerEnemyAbility
 * @generated
 */
public class PlayerEnemyAbilityWrapper
	extends BaseModelWrapper<PlayerEnemyAbility>
	implements ModelWrapper<PlayerEnemyAbility>, PlayerEnemyAbility {

	public PlayerEnemyAbilityWrapper(PlayerEnemyAbility playerEnemyAbility) {
		super(playerEnemyAbility);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("playerEnemyAbilityId", getPlayerEnemyAbilityId());
		attributes.put("enemy", isEnemy());
		attributes.put("playerOrEnemyId", getPlayerOrEnemyId());
		attributes.put("abilityId", getAbilityId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long playerEnemyAbilityId = (Long)attributes.get(
			"playerEnemyAbilityId");

		if (playerEnemyAbilityId != null) {
			setPlayerEnemyAbilityId(playerEnemyAbilityId);
		}

		Boolean enemy = (Boolean)attributes.get("enemy");

		if (enemy != null) {
			setEnemy(enemy);
		}

		Long playerOrEnemyId = (Long)attributes.get("playerOrEnemyId");

		if (playerOrEnemyId != null) {
			setPlayerOrEnemyId(playerOrEnemyId);
		}

		Long abilityId = (Long)attributes.get("abilityId");

		if (abilityId != null) {
			setAbilityId(abilityId);
		}
	}

	@Override
	public PlayerEnemyAbility cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ability ID of this player enemy ability.
	 *
	 * @return the ability ID of this player enemy ability
	 */
	@Override
	public long getAbilityId() {
		return model.getAbilityId();
	}

	/**
	 * Returns the enemy of this player enemy ability.
	 *
	 * @return the enemy of this player enemy ability
	 */
	@Override
	public boolean getEnemy() {
		return model.getEnemy();
	}

	/**
	 * Returns the player enemy ability ID of this player enemy ability.
	 *
	 * @return the player enemy ability ID of this player enemy ability
	 */
	@Override
	public long getPlayerEnemyAbilityId() {
		return model.getPlayerEnemyAbilityId();
	}

	/**
	 * Returns the player or enemy ID of this player enemy ability.
	 *
	 * @return the player or enemy ID of this player enemy ability
	 */
	@Override
	public long getPlayerOrEnemyId() {
		return model.getPlayerOrEnemyId();
	}

	/**
	 * Returns the primary key of this player enemy ability.
	 *
	 * @return the primary key of this player enemy ability
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this player enemy ability.
	 *
	 * @return the uuid of this player enemy ability
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this player enemy ability is enemy.
	 *
	 * @return <code>true</code> if this player enemy ability is enemy; <code>false</code> otherwise
	 */
	@Override
	public boolean isEnemy() {
		return model.isEnemy();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ability ID of this player enemy ability.
	 *
	 * @param abilityId the ability ID of this player enemy ability
	 */
	@Override
	public void setAbilityId(long abilityId) {
		model.setAbilityId(abilityId);
	}

	/**
	 * Sets whether this player enemy ability is enemy.
	 *
	 * @param enemy the enemy of this player enemy ability
	 */
	@Override
	public void setEnemy(boolean enemy) {
		model.setEnemy(enemy);
	}

	/**
	 * Sets the player enemy ability ID of this player enemy ability.
	 *
	 * @param playerEnemyAbilityId the player enemy ability ID of this player enemy ability
	 */
	@Override
	public void setPlayerEnemyAbilityId(long playerEnemyAbilityId) {
		model.setPlayerEnemyAbilityId(playerEnemyAbilityId);
	}

	/**
	 * Sets the player or enemy ID of this player enemy ability.
	 *
	 * @param playerOrEnemyId the player or enemy ID of this player enemy ability
	 */
	@Override
	public void setPlayerOrEnemyId(long playerOrEnemyId) {
		model.setPlayerOrEnemyId(playerOrEnemyId);
	}

	/**
	 * Sets the primary key of this player enemy ability.
	 *
	 * @param primaryKey the primary key of this player enemy ability
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this player enemy ability.
	 *
	 * @param uuid the uuid of this player enemy ability
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected PlayerEnemyAbilityWrapper wrap(
		PlayerEnemyAbility playerEnemyAbility) {

		return new PlayerEnemyAbilityWrapper(playerEnemyAbility);
	}

}
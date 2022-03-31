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
 * This class is a wrapper for {@link Player}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Player
 * @generated
 */
public class PlayerWrapper
	extends BaseModelWrapper<Player> implements ModelWrapper<Player>, Player {

	public PlayerWrapper(Player player) {
		super(player);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("playerId", getPlayerId());
		attributes.put("userId", getUserId());
		attributes.put("playerName", getPlayerName());
		attributes.put("level", getLevel());
		attributes.put("xpPoints", getXpPoints());
		attributes.put("hitPoints", getHitPoints());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long playerId = (Long)attributes.get("playerId");

		if (playerId != null) {
			setPlayerId(playerId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String playerName = (String)attributes.get("playerName");

		if (playerName != null) {
			setPlayerName(playerName);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Integer xpPoints = (Integer)attributes.get("xpPoints");

		if (xpPoints != null) {
			setXpPoints(xpPoints);
		}

		Integer hitPoints = (Integer)attributes.get("hitPoints");

		if (hitPoints != null) {
			setHitPoints(hitPoints);
		}
	}

	@Override
	public Player cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the hit points of this player.
	 *
	 * @return the hit points of this player
	 */
	@Override
	public int getHitPoints() {
		return model.getHitPoints();
	}

	/**
	 * Returns the level of this player.
	 *
	 * @return the level of this player
	 */
	@Override
	public int getLevel() {
		return model.getLevel();
	}

	/**
	 * Returns the player ID of this player.
	 *
	 * @return the player ID of this player
	 */
	@Override
	public long getPlayerId() {
		return model.getPlayerId();
	}

	/**
	 * Returns the player name of this player.
	 *
	 * @return the player name of this player
	 */
	@Override
	public String getPlayerName() {
		return model.getPlayerName();
	}

	/**
	 * Returns the primary key of this player.
	 *
	 * @return the primary key of this player
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this player.
	 *
	 * @return the user ID of this player
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this player.
	 *
	 * @return the user uuid of this player
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this player.
	 *
	 * @return the uuid of this player
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the xp points of this player.
	 *
	 * @return the xp points of this player
	 */
	@Override
	public int getXpPoints() {
		return model.getXpPoints();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the hit points of this player.
	 *
	 * @param hitPoints the hit points of this player
	 */
	@Override
	public void setHitPoints(int hitPoints) {
		model.setHitPoints(hitPoints);
	}

	/**
	 * Sets the level of this player.
	 *
	 * @param level the level of this player
	 */
	@Override
	public void setLevel(int level) {
		model.setLevel(level);
	}

	/**
	 * Sets the player ID of this player.
	 *
	 * @param playerId the player ID of this player
	 */
	@Override
	public void setPlayerId(long playerId) {
		model.setPlayerId(playerId);
	}

	/**
	 * Sets the player name of this player.
	 *
	 * @param playerName the player name of this player
	 */
	@Override
	public void setPlayerName(String playerName) {
		model.setPlayerName(playerName);
	}

	/**
	 * Sets the primary key of this player.
	 *
	 * @param primaryKey the primary key of this player
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this player.
	 *
	 * @param userId the user ID of this player
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this player.
	 *
	 * @param userUuid the user uuid of this player
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this player.
	 *
	 * @param uuid the uuid of this player
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the xp points of this player.
	 *
	 * @param xpPoints the xp points of this player
	 */
	@Override
	public void setXpPoints(int xpPoints) {
		model.setXpPoints(xpPoints);
	}

	@Override
	protected PlayerWrapper wrap(Player player) {
		return new PlayerWrapper(player);
	}

}
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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Player service. Represents a row in the &quot;ReactGame_Player&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.react.game.core.service.model.impl.PlayerModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.react.game.core.service.model.impl.PlayerImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Player
 * @generated
 */
@ProviderType
public interface PlayerModel extends BaseModel<Player> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a player model instance should use the {@link Player} interface instead.
	 */

	/**
	 * Returns the primary key of this player.
	 *
	 * @return the primary key of this player
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this player.
	 *
	 * @param primaryKey the primary key of this player
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this player.
	 *
	 * @return the uuid of this player
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this player.
	 *
	 * @param uuid the uuid of this player
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the player ID of this player.
	 *
	 * @return the player ID of this player
	 */
	public long getPlayerId();

	/**
	 * Sets the player ID of this player.
	 *
	 * @param playerId the player ID of this player
	 */
	public void setPlayerId(long playerId);

	/**
	 * Returns the user ID of this player.
	 *
	 * @return the user ID of this player
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this player.
	 *
	 * @param userId the user ID of this player
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this player.
	 *
	 * @return the user uuid of this player
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this player.
	 *
	 * @param userUuid the user uuid of this player
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the player name of this player.
	 *
	 * @return the player name of this player
	 */
	@AutoEscape
	public String getPlayerName();

	/**
	 * Sets the player name of this player.
	 *
	 * @param playerName the player name of this player
	 */
	public void setPlayerName(String playerName);

	/**
	 * Returns the level of this player.
	 *
	 * @return the level of this player
	 */
	public int getLevel();

	/**
	 * Sets the level of this player.
	 *
	 * @param level the level of this player
	 */
	public void setLevel(int level);

	/**
	 * Returns the xp points of this player.
	 *
	 * @return the xp points of this player
	 */
	public int getXpPoints();

	/**
	 * Sets the xp points of this player.
	 *
	 * @param xpPoints the xp points of this player
	 */
	public void setXpPoints(int xpPoints);

	/**
	 * Returns the hit points of this player.
	 *
	 * @return the hit points of this player
	 */
	public int getHitPoints();

	/**
	 * Sets the hit points of this player.
	 *
	 * @param hitPoints the hit points of this player
	 */
	public void setHitPoints(int hitPoints);

	@Override
	public Player cloneWithOriginalValues();

}
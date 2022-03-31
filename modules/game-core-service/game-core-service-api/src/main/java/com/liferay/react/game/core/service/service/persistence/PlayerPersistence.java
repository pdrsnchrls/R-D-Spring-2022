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

package com.liferay.react.game.core.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.react.game.core.service.exception.NoSuchPlayerException;
import com.liferay.react.game.core.service.model.Player;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the player service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlayerUtil
 * @generated
 */
@ProviderType
public interface PlayerPersistence extends BasePersistence<Player> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PlayerUtil} to access the player persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the players where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching players
	 */
	public java.util.List<Player> findByUuid(String uuid);

	/**
	 * Returns a range of all the players where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of players
	 * @param end the upper bound of the range of players (not inclusive)
	 * @return the range of matching players
	 */
	public java.util.List<Player> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the players where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of players
	 * @param end the upper bound of the range of players (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching players
	 */
	public java.util.List<Player> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Player>
			orderByComparator);

	/**
	 * Returns an ordered range of all the players where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of players
	 * @param end the upper bound of the range of players (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching players
	 */
	public java.util.List<Player> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Player>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first player in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching player
	 * @throws NoSuchPlayerException if a matching player could not be found
	 */
	public Player findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Player>
				orderByComparator)
		throws NoSuchPlayerException;

	/**
	 * Returns the first player in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching player, or <code>null</code> if a matching player could not be found
	 */
	public Player fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Player>
			orderByComparator);

	/**
	 * Returns the last player in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching player
	 * @throws NoSuchPlayerException if a matching player could not be found
	 */
	public Player findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Player>
				orderByComparator)
		throws NoSuchPlayerException;

	/**
	 * Returns the last player in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching player, or <code>null</code> if a matching player could not be found
	 */
	public Player fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Player>
			orderByComparator);

	/**
	 * Returns the players before and after the current player in the ordered set where uuid = &#63;.
	 *
	 * @param playerId the primary key of the current player
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next player
	 * @throws NoSuchPlayerException if a player with the primary key could not be found
	 */
	public Player[] findByUuid_PrevAndNext(
			long playerId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Player>
				orderByComparator)
		throws NoSuchPlayerException;

	/**
	 * Removes all the players where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of players where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching players
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the player where userId = &#63; or throws a <code>NoSuchPlayerException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching player
	 * @throws NoSuchPlayerException if a matching player could not be found
	 */
	public Player findByUserId(long userId) throws NoSuchPlayerException;

	/**
	 * Returns the player where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching player, or <code>null</code> if a matching player could not be found
	 */
	public Player fetchByUserId(long userId);

	/**
	 * Returns the player where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching player, or <code>null</code> if a matching player could not be found
	 */
	public Player fetchByUserId(long userId, boolean useFinderCache);

	/**
	 * Removes the player where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the player that was removed
	 */
	public Player removeByUserId(long userId) throws NoSuchPlayerException;

	/**
	 * Returns the number of players where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching players
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the player in the entity cache if it is enabled.
	 *
	 * @param player the player
	 */
	public void cacheResult(Player player);

	/**
	 * Caches the players in the entity cache if it is enabled.
	 *
	 * @param players the players
	 */
	public void cacheResult(java.util.List<Player> players);

	/**
	 * Creates a new player with the primary key. Does not add the player to the database.
	 *
	 * @param playerId the primary key for the new player
	 * @return the new player
	 */
	public Player create(long playerId);

	/**
	 * Removes the player with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param playerId the primary key of the player
	 * @return the player that was removed
	 * @throws NoSuchPlayerException if a player with the primary key could not be found
	 */
	public Player remove(long playerId) throws NoSuchPlayerException;

	public Player updateImpl(Player player);

	/**
	 * Returns the player with the primary key or throws a <code>NoSuchPlayerException</code> if it could not be found.
	 *
	 * @param playerId the primary key of the player
	 * @return the player
	 * @throws NoSuchPlayerException if a player with the primary key could not be found
	 */
	public Player findByPrimaryKey(long playerId) throws NoSuchPlayerException;

	/**
	 * Returns the player with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param playerId the primary key of the player
	 * @return the player, or <code>null</code> if a player with the primary key could not be found
	 */
	public Player fetchByPrimaryKey(long playerId);

	/**
	 * Returns all the players.
	 *
	 * @return the players
	 */
	public java.util.List<Player> findAll();

	/**
	 * Returns a range of all the players.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of players
	 * @param end the upper bound of the range of players (not inclusive)
	 * @return the range of players
	 */
	public java.util.List<Player> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the players.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of players
	 * @param end the upper bound of the range of players (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of players
	 */
	public java.util.List<Player> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Player>
			orderByComparator);

	/**
	 * Returns an ordered range of all the players.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of players
	 * @param end the upper bound of the range of players (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of players
	 */
	public java.util.List<Player> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Player>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the players from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of players.
	 *
	 * @return the number of players
	 */
	public int countAll();

}
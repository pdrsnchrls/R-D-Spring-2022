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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.react.game.core.service.model.Player;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the player service. This utility wraps <code>com.liferay.react.game.core.service.service.persistence.impl.PlayerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlayerPersistence
 * @generated
 */
public class PlayerUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Player player) {
		getPersistence().clearCache(player);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Player> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Player> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Player> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Player> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Player> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Player update(Player player) {
		return getPersistence().update(player);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Player update(Player player, ServiceContext serviceContext) {
		return getPersistence().update(player, serviceContext);
	}

	/**
	 * Returns all the players where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching players
	 */
	public static List<Player> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Player> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Player> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Player> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Player> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Player> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first player in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching player
	 * @throws NoSuchPlayerException if a matching player could not be found
	 */
	public static Player findByUuid_First(
			String uuid, OrderByComparator<Player> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchPlayerException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first player in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching player, or <code>null</code> if a matching player could not be found
	 */
	public static Player fetchByUuid_First(
		String uuid, OrderByComparator<Player> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last player in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching player
	 * @throws NoSuchPlayerException if a matching player could not be found
	 */
	public static Player findByUuid_Last(
			String uuid, OrderByComparator<Player> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchPlayerException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last player in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching player, or <code>null</code> if a matching player could not be found
	 */
	public static Player fetchByUuid_Last(
		String uuid, OrderByComparator<Player> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the players before and after the current player in the ordered set where uuid = &#63;.
	 *
	 * @param playerId the primary key of the current player
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next player
	 * @throws NoSuchPlayerException if a player with the primary key could not be found
	 */
	public static Player[] findByUuid_PrevAndNext(
			long playerId, String uuid,
			OrderByComparator<Player> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchPlayerException {

		return getPersistence().findByUuid_PrevAndNext(
			playerId, uuid, orderByComparator);
	}

	/**
	 * Removes all the players where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of players where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching players
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the player where userId = &#63; or throws a <code>NoSuchPlayerException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching player
	 * @throws NoSuchPlayerException if a matching player could not be found
	 */
	public static Player findByUserId(long userId)
		throws com.liferay.react.game.core.service.exception.
			NoSuchPlayerException {

		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns the player where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching player, or <code>null</code> if a matching player could not be found
	 */
	public static Player fetchByUserId(long userId) {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	 * Returns the player where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching player, or <code>null</code> if a matching player could not be found
	 */
	public static Player fetchByUserId(long userId, boolean useFinderCache) {
		return getPersistence().fetchByUserId(userId, useFinderCache);
	}

	/**
	 * Removes the player where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the player that was removed
	 */
	public static Player removeByUserId(long userId)
		throws com.liferay.react.game.core.service.exception.
			NoSuchPlayerException {

		return getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of players where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching players
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the player in the entity cache if it is enabled.
	 *
	 * @param player the player
	 */
	public static void cacheResult(Player player) {
		getPersistence().cacheResult(player);
	}

	/**
	 * Caches the players in the entity cache if it is enabled.
	 *
	 * @param players the players
	 */
	public static void cacheResult(List<Player> players) {
		getPersistence().cacheResult(players);
	}

	/**
	 * Creates a new player with the primary key. Does not add the player to the database.
	 *
	 * @param playerId the primary key for the new player
	 * @return the new player
	 */
	public static Player create(long playerId) {
		return getPersistence().create(playerId);
	}

	/**
	 * Removes the player with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param playerId the primary key of the player
	 * @return the player that was removed
	 * @throws NoSuchPlayerException if a player with the primary key could not be found
	 */
	public static Player remove(long playerId)
		throws com.liferay.react.game.core.service.exception.
			NoSuchPlayerException {

		return getPersistence().remove(playerId);
	}

	public static Player updateImpl(Player player) {
		return getPersistence().updateImpl(player);
	}

	/**
	 * Returns the player with the primary key or throws a <code>NoSuchPlayerException</code> if it could not be found.
	 *
	 * @param playerId the primary key of the player
	 * @return the player
	 * @throws NoSuchPlayerException if a player with the primary key could not be found
	 */
	public static Player findByPrimaryKey(long playerId)
		throws com.liferay.react.game.core.service.exception.
			NoSuchPlayerException {

		return getPersistence().findByPrimaryKey(playerId);
	}

	/**
	 * Returns the player with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param playerId the primary key of the player
	 * @return the player, or <code>null</code> if a player with the primary key could not be found
	 */
	public static Player fetchByPrimaryKey(long playerId) {
		return getPersistence().fetchByPrimaryKey(playerId);
	}

	/**
	 * Returns all the players.
	 *
	 * @return the players
	 */
	public static List<Player> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Player> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Player> findAll(
		int start, int end, OrderByComparator<Player> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Player> findAll(
		int start, int end, OrderByComparator<Player> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the players from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of players.
	 *
	 * @return the number of players
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PlayerPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PlayerPersistence _persistence;

}
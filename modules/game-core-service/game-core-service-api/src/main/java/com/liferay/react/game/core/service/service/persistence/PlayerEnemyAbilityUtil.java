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
import com.liferay.react.game.core.service.model.PlayerEnemyAbility;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the player enemy ability service. This utility wraps <code>com.liferay.react.game.core.service.service.persistence.impl.PlayerEnemyAbilityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlayerEnemyAbilityPersistence
 * @generated
 */
public class PlayerEnemyAbilityUtil {

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
	public static void clearCache(PlayerEnemyAbility playerEnemyAbility) {
		getPersistence().clearCache(playerEnemyAbility);
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
	public static Map<Serializable, PlayerEnemyAbility> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PlayerEnemyAbility> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PlayerEnemyAbility> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PlayerEnemyAbility> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PlayerEnemyAbility> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PlayerEnemyAbility update(
		PlayerEnemyAbility playerEnemyAbility) {

		return getPersistence().update(playerEnemyAbility);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PlayerEnemyAbility update(
		PlayerEnemyAbility playerEnemyAbility, ServiceContext serviceContext) {

		return getPersistence().update(playerEnemyAbility, serviceContext);
	}

	/**
	 * Returns all the player enemy abilities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching player enemy abilities
	 */
	public static List<PlayerEnemyAbility> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the player enemy abilities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @return the range of matching player enemy abilities
	 */
	public static List<PlayerEnemyAbility> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the player enemy abilities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching player enemy abilities
	 */
	public static List<PlayerEnemyAbility> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PlayerEnemyAbility> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the player enemy abilities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching player enemy abilities
	 */
	public static List<PlayerEnemyAbility> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PlayerEnemyAbility> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first player enemy ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a matching player enemy ability could not be found
	 */
	public static PlayerEnemyAbility findByUuid_First(
			String uuid,
			OrderByComparator<PlayerEnemyAbility> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchPlayerEnemyAbilityException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first player enemy ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching player enemy ability, or <code>null</code> if a matching player enemy ability could not be found
	 */
	public static PlayerEnemyAbility fetchByUuid_First(
		String uuid, OrderByComparator<PlayerEnemyAbility> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last player enemy ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a matching player enemy ability could not be found
	 */
	public static PlayerEnemyAbility findByUuid_Last(
			String uuid,
			OrderByComparator<PlayerEnemyAbility> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchPlayerEnemyAbilityException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last player enemy ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching player enemy ability, or <code>null</code> if a matching player enemy ability could not be found
	 */
	public static PlayerEnemyAbility fetchByUuid_Last(
		String uuid, OrderByComparator<PlayerEnemyAbility> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the player enemy abilities before and after the current player enemy ability in the ordered set where uuid = &#63;.
	 *
	 * @param playerEnemyAbilityId the primary key of the current player enemy ability
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a player enemy ability with the primary key could not be found
	 */
	public static PlayerEnemyAbility[] findByUuid_PrevAndNext(
			long playerEnemyAbilityId, String uuid,
			OrderByComparator<PlayerEnemyAbility> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchPlayerEnemyAbilityException {

		return getPersistence().findByUuid_PrevAndNext(
			playerEnemyAbilityId, uuid, orderByComparator);
	}

	/**
	 * Removes all the player enemy abilities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of player enemy abilities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching player enemy abilities
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the player enemy ability in the entity cache if it is enabled.
	 *
	 * @param playerEnemyAbility the player enemy ability
	 */
	public static void cacheResult(PlayerEnemyAbility playerEnemyAbility) {
		getPersistence().cacheResult(playerEnemyAbility);
	}

	/**
	 * Caches the player enemy abilities in the entity cache if it is enabled.
	 *
	 * @param playerEnemyAbilities the player enemy abilities
	 */
	public static void cacheResult(
		List<PlayerEnemyAbility> playerEnemyAbilities) {

		getPersistence().cacheResult(playerEnemyAbilities);
	}

	/**
	 * Creates a new player enemy ability with the primary key. Does not add the player enemy ability to the database.
	 *
	 * @param playerEnemyAbilityId the primary key for the new player enemy ability
	 * @return the new player enemy ability
	 */
	public static PlayerEnemyAbility create(long playerEnemyAbilityId) {
		return getPersistence().create(playerEnemyAbilityId);
	}

	/**
	 * Removes the player enemy ability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param playerEnemyAbilityId the primary key of the player enemy ability
	 * @return the player enemy ability that was removed
	 * @throws NoSuchPlayerEnemyAbilityException if a player enemy ability with the primary key could not be found
	 */
	public static PlayerEnemyAbility remove(long playerEnemyAbilityId)
		throws com.liferay.react.game.core.service.exception.
			NoSuchPlayerEnemyAbilityException {

		return getPersistence().remove(playerEnemyAbilityId);
	}

	public static PlayerEnemyAbility updateImpl(
		PlayerEnemyAbility playerEnemyAbility) {

		return getPersistence().updateImpl(playerEnemyAbility);
	}

	/**
	 * Returns the player enemy ability with the primary key or throws a <code>NoSuchPlayerEnemyAbilityException</code> if it could not be found.
	 *
	 * @param playerEnemyAbilityId the primary key of the player enemy ability
	 * @return the player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a player enemy ability with the primary key could not be found
	 */
	public static PlayerEnemyAbility findByPrimaryKey(long playerEnemyAbilityId)
		throws com.liferay.react.game.core.service.exception.
			NoSuchPlayerEnemyAbilityException {

		return getPersistence().findByPrimaryKey(playerEnemyAbilityId);
	}

	/**
	 * Returns the player enemy ability with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param playerEnemyAbilityId the primary key of the player enemy ability
	 * @return the player enemy ability, or <code>null</code> if a player enemy ability with the primary key could not be found
	 */
	public static PlayerEnemyAbility fetchByPrimaryKey(
		long playerEnemyAbilityId) {

		return getPersistence().fetchByPrimaryKey(playerEnemyAbilityId);
	}

	/**
	 * Returns all the player enemy abilities.
	 *
	 * @return the player enemy abilities
	 */
	public static List<PlayerEnemyAbility> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the player enemy abilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @return the range of player enemy abilities
	 */
	public static List<PlayerEnemyAbility> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the player enemy abilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of player enemy abilities
	 */
	public static List<PlayerEnemyAbility> findAll(
		int start, int end,
		OrderByComparator<PlayerEnemyAbility> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the player enemy abilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of player enemy abilities
	 */
	public static List<PlayerEnemyAbility> findAll(
		int start, int end,
		OrderByComparator<PlayerEnemyAbility> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the player enemy abilities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of player enemy abilities.
	 *
	 * @return the number of player enemy abilities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PlayerEnemyAbilityPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PlayerEnemyAbilityPersistence _persistence;

}
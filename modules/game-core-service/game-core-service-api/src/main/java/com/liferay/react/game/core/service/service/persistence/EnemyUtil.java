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
import com.liferay.react.game.core.service.model.Enemy;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the enemy service. This utility wraps <code>com.liferay.react.game.core.service.service.persistence.impl.EnemyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnemyPersistence
 * @generated
 */
public class EnemyUtil {

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
	public static void clearCache(Enemy enemy) {
		getPersistence().clearCache(enemy);
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
	public static Map<Serializable, Enemy> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Enemy> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Enemy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Enemy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Enemy> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Enemy update(Enemy enemy) {
		return getPersistence().update(enemy);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Enemy update(Enemy enemy, ServiceContext serviceContext) {
		return getPersistence().update(enemy, serviceContext);
	}

	/**
	 * Returns all the enemies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching enemies
	 */
	public static List<Enemy> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the enemies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @return the range of matching enemies
	 */
	public static List<Enemy> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the enemies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enemies
	 */
	public static List<Enemy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Enemy> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the enemies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching enemies
	 */
	public static List<Enemy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Enemy> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first enemy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enemy
	 * @throws NoSuchEnemyException if a matching enemy could not be found
	 */
	public static Enemy findByUuid_First(
			String uuid, OrderByComparator<Enemy> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchEnemyException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first enemy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enemy, or <code>null</code> if a matching enemy could not be found
	 */
	public static Enemy fetchByUuid_First(
		String uuid, OrderByComparator<Enemy> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last enemy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enemy
	 * @throws NoSuchEnemyException if a matching enemy could not be found
	 */
	public static Enemy findByUuid_Last(
			String uuid, OrderByComparator<Enemy> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchEnemyException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last enemy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enemy, or <code>null</code> if a matching enemy could not be found
	 */
	public static Enemy fetchByUuid_Last(
		String uuid, OrderByComparator<Enemy> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the enemies before and after the current enemy in the ordered set where uuid = &#63;.
	 *
	 * @param enemyId the primary key of the current enemy
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next enemy
	 * @throws NoSuchEnemyException if a enemy with the primary key could not be found
	 */
	public static Enemy[] findByUuid_PrevAndNext(
			long enemyId, String uuid,
			OrderByComparator<Enemy> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchEnemyException {

		return getPersistence().findByUuid_PrevAndNext(
			enemyId, uuid, orderByComparator);
	}

	/**
	 * Removes all the enemies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of enemies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching enemies
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the enemies where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @return the matching enemies
	 */
	public static List<Enemy> findByEnemyName(String enemyName) {
		return getPersistence().findByEnemyName(enemyName);
	}

	/**
	 * Returns a range of all the enemies where enemyName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param enemyName the enemy name
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @return the range of matching enemies
	 */
	public static List<Enemy> findByEnemyName(
		String enemyName, int start, int end) {

		return getPersistence().findByEnemyName(enemyName, start, end);
	}

	/**
	 * Returns an ordered range of all the enemies where enemyName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param enemyName the enemy name
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enemies
	 */
	public static List<Enemy> findByEnemyName(
		String enemyName, int start, int end,
		OrderByComparator<Enemy> orderByComparator) {

		return getPersistence().findByEnemyName(
			enemyName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the enemies where enemyName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param enemyName the enemy name
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching enemies
	 */
	public static List<Enemy> findByEnemyName(
		String enemyName, int start, int end,
		OrderByComparator<Enemy> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByEnemyName(
			enemyName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first enemy in the ordered set where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enemy
	 * @throws NoSuchEnemyException if a matching enemy could not be found
	 */
	public static Enemy findByEnemyName_First(
			String enemyName, OrderByComparator<Enemy> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchEnemyException {

		return getPersistence().findByEnemyName_First(
			enemyName, orderByComparator);
	}

	/**
	 * Returns the first enemy in the ordered set where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enemy, or <code>null</code> if a matching enemy could not be found
	 */
	public static Enemy fetchByEnemyName_First(
		String enemyName, OrderByComparator<Enemy> orderByComparator) {

		return getPersistence().fetchByEnemyName_First(
			enemyName, orderByComparator);
	}

	/**
	 * Returns the last enemy in the ordered set where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enemy
	 * @throws NoSuchEnemyException if a matching enemy could not be found
	 */
	public static Enemy findByEnemyName_Last(
			String enemyName, OrderByComparator<Enemy> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchEnemyException {

		return getPersistence().findByEnemyName_Last(
			enemyName, orderByComparator);
	}

	/**
	 * Returns the last enemy in the ordered set where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enemy, or <code>null</code> if a matching enemy could not be found
	 */
	public static Enemy fetchByEnemyName_Last(
		String enemyName, OrderByComparator<Enemy> orderByComparator) {

		return getPersistence().fetchByEnemyName_Last(
			enemyName, orderByComparator);
	}

	/**
	 * Returns the enemies before and after the current enemy in the ordered set where enemyName = &#63;.
	 *
	 * @param enemyId the primary key of the current enemy
	 * @param enemyName the enemy name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next enemy
	 * @throws NoSuchEnemyException if a enemy with the primary key could not be found
	 */
	public static Enemy[] findByEnemyName_PrevAndNext(
			long enemyId, String enemyName,
			OrderByComparator<Enemy> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchEnemyException {

		return getPersistence().findByEnemyName_PrevAndNext(
			enemyId, enemyName, orderByComparator);
	}

	/**
	 * Removes all the enemies where enemyName = &#63; from the database.
	 *
	 * @param enemyName the enemy name
	 */
	public static void removeByEnemyName(String enemyName) {
		getPersistence().removeByEnemyName(enemyName);
	}

	/**
	 * Returns the number of enemies where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @return the number of matching enemies
	 */
	public static int countByEnemyName(String enemyName) {
		return getPersistence().countByEnemyName(enemyName);
	}

	/**
	 * Caches the enemy in the entity cache if it is enabled.
	 *
	 * @param enemy the enemy
	 */
	public static void cacheResult(Enemy enemy) {
		getPersistence().cacheResult(enemy);
	}

	/**
	 * Caches the enemies in the entity cache if it is enabled.
	 *
	 * @param enemies the enemies
	 */
	public static void cacheResult(List<Enemy> enemies) {
		getPersistence().cacheResult(enemies);
	}

	/**
	 * Creates a new enemy with the primary key. Does not add the enemy to the database.
	 *
	 * @param enemyId the primary key for the new enemy
	 * @return the new enemy
	 */
	public static Enemy create(long enemyId) {
		return getPersistence().create(enemyId);
	}

	/**
	 * Removes the enemy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param enemyId the primary key of the enemy
	 * @return the enemy that was removed
	 * @throws NoSuchEnemyException if a enemy with the primary key could not be found
	 */
	public static Enemy remove(long enemyId)
		throws com.liferay.react.game.core.service.exception.
			NoSuchEnemyException {

		return getPersistence().remove(enemyId);
	}

	public static Enemy updateImpl(Enemy enemy) {
		return getPersistence().updateImpl(enemy);
	}

	/**
	 * Returns the enemy with the primary key or throws a <code>NoSuchEnemyException</code> if it could not be found.
	 *
	 * @param enemyId the primary key of the enemy
	 * @return the enemy
	 * @throws NoSuchEnemyException if a enemy with the primary key could not be found
	 */
	public static Enemy findByPrimaryKey(long enemyId)
		throws com.liferay.react.game.core.service.exception.
			NoSuchEnemyException {

		return getPersistence().findByPrimaryKey(enemyId);
	}

	/**
	 * Returns the enemy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param enemyId the primary key of the enemy
	 * @return the enemy, or <code>null</code> if a enemy with the primary key could not be found
	 */
	public static Enemy fetchByPrimaryKey(long enemyId) {
		return getPersistence().fetchByPrimaryKey(enemyId);
	}

	/**
	 * Returns all the enemies.
	 *
	 * @return the enemies
	 */
	public static List<Enemy> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the enemies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @return the range of enemies
	 */
	public static List<Enemy> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the enemies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of enemies
	 */
	public static List<Enemy> findAll(
		int start, int end, OrderByComparator<Enemy> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the enemies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of enemies
	 */
	public static List<Enemy> findAll(
		int start, int end, OrderByComparator<Enemy> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the enemies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of enemies.
	 *
	 * @return the number of enemies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EnemyPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EnemyPersistence _persistence;

}
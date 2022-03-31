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
import com.liferay.react.game.core.service.exception.NoSuchEnemyException;
import com.liferay.react.game.core.service.model.Enemy;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the enemy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnemyUtil
 * @generated
 */
@ProviderType
public interface EnemyPersistence extends BasePersistence<Enemy> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EnemyUtil} to access the enemy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the enemies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching enemies
	 */
	public java.util.List<Enemy> findByUuid(String uuid);

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
	public java.util.List<Enemy> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Enemy> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Enemy>
			orderByComparator);

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
	public java.util.List<Enemy> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Enemy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first enemy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enemy
	 * @throws NoSuchEnemyException if a matching enemy could not be found
	 */
	public Enemy findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Enemy>
				orderByComparator)
		throws NoSuchEnemyException;

	/**
	 * Returns the first enemy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enemy, or <code>null</code> if a matching enemy could not be found
	 */
	public Enemy fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Enemy>
			orderByComparator);

	/**
	 * Returns the last enemy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enemy
	 * @throws NoSuchEnemyException if a matching enemy could not be found
	 */
	public Enemy findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Enemy>
				orderByComparator)
		throws NoSuchEnemyException;

	/**
	 * Returns the last enemy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enemy, or <code>null</code> if a matching enemy could not be found
	 */
	public Enemy fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Enemy>
			orderByComparator);

	/**
	 * Returns the enemies before and after the current enemy in the ordered set where uuid = &#63;.
	 *
	 * @param enemyId the primary key of the current enemy
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next enemy
	 * @throws NoSuchEnemyException if a enemy with the primary key could not be found
	 */
	public Enemy[] findByUuid_PrevAndNext(
			long enemyId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Enemy>
				orderByComparator)
		throws NoSuchEnemyException;

	/**
	 * Removes all the enemies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of enemies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching enemies
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the enemies where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @return the matching enemies
	 */
	public java.util.List<Enemy> findByEnemyName(String enemyName);

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
	public java.util.List<Enemy> findByEnemyName(
		String enemyName, int start, int end);

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
	public java.util.List<Enemy> findByEnemyName(
		String enemyName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Enemy>
			orderByComparator);

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
	public java.util.List<Enemy> findByEnemyName(
		String enemyName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Enemy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first enemy in the ordered set where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enemy
	 * @throws NoSuchEnemyException if a matching enemy could not be found
	 */
	public Enemy findByEnemyName_First(
			String enemyName,
			com.liferay.portal.kernel.util.OrderByComparator<Enemy>
				orderByComparator)
		throws NoSuchEnemyException;

	/**
	 * Returns the first enemy in the ordered set where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enemy, or <code>null</code> if a matching enemy could not be found
	 */
	public Enemy fetchByEnemyName_First(
		String enemyName,
		com.liferay.portal.kernel.util.OrderByComparator<Enemy>
			orderByComparator);

	/**
	 * Returns the last enemy in the ordered set where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enemy
	 * @throws NoSuchEnemyException if a matching enemy could not be found
	 */
	public Enemy findByEnemyName_Last(
			String enemyName,
			com.liferay.portal.kernel.util.OrderByComparator<Enemy>
				orderByComparator)
		throws NoSuchEnemyException;

	/**
	 * Returns the last enemy in the ordered set where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enemy, or <code>null</code> if a matching enemy could not be found
	 */
	public Enemy fetchByEnemyName_Last(
		String enemyName,
		com.liferay.portal.kernel.util.OrderByComparator<Enemy>
			orderByComparator);

	/**
	 * Returns the enemies before and after the current enemy in the ordered set where enemyName = &#63;.
	 *
	 * @param enemyId the primary key of the current enemy
	 * @param enemyName the enemy name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next enemy
	 * @throws NoSuchEnemyException if a enemy with the primary key could not be found
	 */
	public Enemy[] findByEnemyName_PrevAndNext(
			long enemyId, String enemyName,
			com.liferay.portal.kernel.util.OrderByComparator<Enemy>
				orderByComparator)
		throws NoSuchEnemyException;

	/**
	 * Removes all the enemies where enemyName = &#63; from the database.
	 *
	 * @param enemyName the enemy name
	 */
	public void removeByEnemyName(String enemyName);

	/**
	 * Returns the number of enemies where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @return the number of matching enemies
	 */
	public int countByEnemyName(String enemyName);

	/**
	 * Caches the enemy in the entity cache if it is enabled.
	 *
	 * @param enemy the enemy
	 */
	public void cacheResult(Enemy enemy);

	/**
	 * Caches the enemies in the entity cache if it is enabled.
	 *
	 * @param enemies the enemies
	 */
	public void cacheResult(java.util.List<Enemy> enemies);

	/**
	 * Creates a new enemy with the primary key. Does not add the enemy to the database.
	 *
	 * @param enemyId the primary key for the new enemy
	 * @return the new enemy
	 */
	public Enemy create(long enemyId);

	/**
	 * Removes the enemy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param enemyId the primary key of the enemy
	 * @return the enemy that was removed
	 * @throws NoSuchEnemyException if a enemy with the primary key could not be found
	 */
	public Enemy remove(long enemyId) throws NoSuchEnemyException;

	public Enemy updateImpl(Enemy enemy);

	/**
	 * Returns the enemy with the primary key or throws a <code>NoSuchEnemyException</code> if it could not be found.
	 *
	 * @param enemyId the primary key of the enemy
	 * @return the enemy
	 * @throws NoSuchEnemyException if a enemy with the primary key could not be found
	 */
	public Enemy findByPrimaryKey(long enemyId) throws NoSuchEnemyException;

	/**
	 * Returns the enemy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param enemyId the primary key of the enemy
	 * @return the enemy, or <code>null</code> if a enemy with the primary key could not be found
	 */
	public Enemy fetchByPrimaryKey(long enemyId);

	/**
	 * Returns all the enemies.
	 *
	 * @return the enemies
	 */
	public java.util.List<Enemy> findAll();

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
	public java.util.List<Enemy> findAll(int start, int end);

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
	public java.util.List<Enemy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Enemy>
			orderByComparator);

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
	public java.util.List<Enemy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Enemy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the enemies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of enemies.
	 *
	 * @return the number of enemies
	 */
	public int countAll();

}
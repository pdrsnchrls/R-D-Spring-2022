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
import com.liferay.react.game.core.service.exception.NoSuchPlayerEnemyAbilityException;
import com.liferay.react.game.core.service.model.PlayerEnemyAbility;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the player enemy ability service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlayerEnemyAbilityUtil
 * @generated
 */
@ProviderType
public interface PlayerEnemyAbilityPersistence
	extends BasePersistence<PlayerEnemyAbility> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PlayerEnemyAbilityUtil} to access the player enemy ability persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the player enemy abilities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching player enemy abilities
	 */
	public java.util.List<PlayerEnemyAbility> findByUuid(String uuid);

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
	public java.util.List<PlayerEnemyAbility> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<PlayerEnemyAbility> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PlayerEnemyAbility>
			orderByComparator);

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
	public java.util.List<PlayerEnemyAbility> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PlayerEnemyAbility>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first player enemy ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a matching player enemy ability could not be found
	 */
	public PlayerEnemyAbility findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PlayerEnemyAbility>
				orderByComparator)
		throws NoSuchPlayerEnemyAbilityException;

	/**
	 * Returns the first player enemy ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching player enemy ability, or <code>null</code> if a matching player enemy ability could not be found
	 */
	public PlayerEnemyAbility fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PlayerEnemyAbility>
			orderByComparator);

	/**
	 * Returns the last player enemy ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a matching player enemy ability could not be found
	 */
	public PlayerEnemyAbility findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PlayerEnemyAbility>
				orderByComparator)
		throws NoSuchPlayerEnemyAbilityException;

	/**
	 * Returns the last player enemy ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching player enemy ability, or <code>null</code> if a matching player enemy ability could not be found
	 */
	public PlayerEnemyAbility fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PlayerEnemyAbility>
			orderByComparator);

	/**
	 * Returns the player enemy abilities before and after the current player enemy ability in the ordered set where uuid = &#63;.
	 *
	 * @param playerEnemyAbilityId the primary key of the current player enemy ability
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a player enemy ability with the primary key could not be found
	 */
	public PlayerEnemyAbility[] findByUuid_PrevAndNext(
			long playerEnemyAbilityId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PlayerEnemyAbility>
				orderByComparator)
		throws NoSuchPlayerEnemyAbilityException;

	/**
	 * Removes all the player enemy abilities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of player enemy abilities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching player enemy abilities
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the player enemy ability in the entity cache if it is enabled.
	 *
	 * @param playerEnemyAbility the player enemy ability
	 */
	public void cacheResult(PlayerEnemyAbility playerEnemyAbility);

	/**
	 * Caches the player enemy abilities in the entity cache if it is enabled.
	 *
	 * @param playerEnemyAbilities the player enemy abilities
	 */
	public void cacheResult(
		java.util.List<PlayerEnemyAbility> playerEnemyAbilities);

	/**
	 * Creates a new player enemy ability with the primary key. Does not add the player enemy ability to the database.
	 *
	 * @param playerEnemyAbilityId the primary key for the new player enemy ability
	 * @return the new player enemy ability
	 */
	public PlayerEnemyAbility create(long playerEnemyAbilityId);

	/**
	 * Removes the player enemy ability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param playerEnemyAbilityId the primary key of the player enemy ability
	 * @return the player enemy ability that was removed
	 * @throws NoSuchPlayerEnemyAbilityException if a player enemy ability with the primary key could not be found
	 */
	public PlayerEnemyAbility remove(long playerEnemyAbilityId)
		throws NoSuchPlayerEnemyAbilityException;

	public PlayerEnemyAbility updateImpl(PlayerEnemyAbility playerEnemyAbility);

	/**
	 * Returns the player enemy ability with the primary key or throws a <code>NoSuchPlayerEnemyAbilityException</code> if it could not be found.
	 *
	 * @param playerEnemyAbilityId the primary key of the player enemy ability
	 * @return the player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a player enemy ability with the primary key could not be found
	 */
	public PlayerEnemyAbility findByPrimaryKey(long playerEnemyAbilityId)
		throws NoSuchPlayerEnemyAbilityException;

	/**
	 * Returns the player enemy ability with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param playerEnemyAbilityId the primary key of the player enemy ability
	 * @return the player enemy ability, or <code>null</code> if a player enemy ability with the primary key could not be found
	 */
	public PlayerEnemyAbility fetchByPrimaryKey(long playerEnemyAbilityId);

	/**
	 * Returns all the player enemy abilities.
	 *
	 * @return the player enemy abilities
	 */
	public java.util.List<PlayerEnemyAbility> findAll();

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
	public java.util.List<PlayerEnemyAbility> findAll(int start, int end);

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
	public java.util.List<PlayerEnemyAbility> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PlayerEnemyAbility>
			orderByComparator);

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
	public java.util.List<PlayerEnemyAbility> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PlayerEnemyAbility>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the player enemy abilities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of player enemy abilities.
	 *
	 * @return the number of player enemy abilities
	 */
	public int countAll();

}
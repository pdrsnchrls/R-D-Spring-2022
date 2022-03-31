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
import com.liferay.react.game.core.service.exception.NoSuchAbilityException;
import com.liferay.react.game.core.service.model.Ability;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ability service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AbilityUtil
 * @generated
 */
@ProviderType
public interface AbilityPersistence extends BasePersistence<Ability> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AbilityUtil} to access the ability persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the abilities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching abilities
	 */
	public java.util.List<Ability> findByUuid(String uuid);

	/**
	 * Returns a range of all the abilities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @return the range of matching abilities
	 */
	public java.util.List<Ability> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the abilities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching abilities
	 */
	public java.util.List<Ability> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ability>
			orderByComparator);

	/**
	 * Returns an ordered range of all the abilities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching abilities
	 */
	public java.util.List<Ability> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ability>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ability
	 * @throws NoSuchAbilityException if a matching ability could not be found
	 */
	public Ability findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Ability>
				orderByComparator)
		throws NoSuchAbilityException;

	/**
	 * Returns the first ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ability, or <code>null</code> if a matching ability could not be found
	 */
	public Ability fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Ability>
			orderByComparator);

	/**
	 * Returns the last ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ability
	 * @throws NoSuchAbilityException if a matching ability could not be found
	 */
	public Ability findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Ability>
				orderByComparator)
		throws NoSuchAbilityException;

	/**
	 * Returns the last ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ability, or <code>null</code> if a matching ability could not be found
	 */
	public Ability fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Ability>
			orderByComparator);

	/**
	 * Returns the abilities before and after the current ability in the ordered set where uuid = &#63;.
	 *
	 * @param abilityId the primary key of the current ability
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ability
	 * @throws NoSuchAbilityException if a ability with the primary key could not be found
	 */
	public Ability[] findByUuid_PrevAndNext(
			long abilityId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Ability>
				orderByComparator)
		throws NoSuchAbilityException;

	/**
	 * Removes all the abilities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of abilities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching abilities
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the abilities where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @return the matching abilities
	 */
	public java.util.List<Ability> findByAbilityName(String abilityName);

	/**
	 * Returns a range of all the abilities where abilityName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param abilityName the ability name
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @return the range of matching abilities
	 */
	public java.util.List<Ability> findByAbilityName(
		String abilityName, int start, int end);

	/**
	 * Returns an ordered range of all the abilities where abilityName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param abilityName the ability name
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching abilities
	 */
	public java.util.List<Ability> findByAbilityName(
		String abilityName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ability>
			orderByComparator);

	/**
	 * Returns an ordered range of all the abilities where abilityName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param abilityName the ability name
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching abilities
	 */
	public java.util.List<Ability> findByAbilityName(
		String abilityName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ability>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ability in the ordered set where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ability
	 * @throws NoSuchAbilityException if a matching ability could not be found
	 */
	public Ability findByAbilityName_First(
			String abilityName,
			com.liferay.portal.kernel.util.OrderByComparator<Ability>
				orderByComparator)
		throws NoSuchAbilityException;

	/**
	 * Returns the first ability in the ordered set where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ability, or <code>null</code> if a matching ability could not be found
	 */
	public Ability fetchByAbilityName_First(
		String abilityName,
		com.liferay.portal.kernel.util.OrderByComparator<Ability>
			orderByComparator);

	/**
	 * Returns the last ability in the ordered set where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ability
	 * @throws NoSuchAbilityException if a matching ability could not be found
	 */
	public Ability findByAbilityName_Last(
			String abilityName,
			com.liferay.portal.kernel.util.OrderByComparator<Ability>
				orderByComparator)
		throws NoSuchAbilityException;

	/**
	 * Returns the last ability in the ordered set where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ability, or <code>null</code> if a matching ability could not be found
	 */
	public Ability fetchByAbilityName_Last(
		String abilityName,
		com.liferay.portal.kernel.util.OrderByComparator<Ability>
			orderByComparator);

	/**
	 * Returns the abilities before and after the current ability in the ordered set where abilityName = &#63;.
	 *
	 * @param abilityId the primary key of the current ability
	 * @param abilityName the ability name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ability
	 * @throws NoSuchAbilityException if a ability with the primary key could not be found
	 */
	public Ability[] findByAbilityName_PrevAndNext(
			long abilityId, String abilityName,
			com.liferay.portal.kernel.util.OrderByComparator<Ability>
				orderByComparator)
		throws NoSuchAbilityException;

	/**
	 * Removes all the abilities where abilityName = &#63; from the database.
	 *
	 * @param abilityName the ability name
	 */
	public void removeByAbilityName(String abilityName);

	/**
	 * Returns the number of abilities where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @return the number of matching abilities
	 */
	public int countByAbilityName(String abilityName);

	/**
	 * Caches the ability in the entity cache if it is enabled.
	 *
	 * @param ability the ability
	 */
	public void cacheResult(Ability ability);

	/**
	 * Caches the abilities in the entity cache if it is enabled.
	 *
	 * @param abilities the abilities
	 */
	public void cacheResult(java.util.List<Ability> abilities);

	/**
	 * Creates a new ability with the primary key. Does not add the ability to the database.
	 *
	 * @param abilityId the primary key for the new ability
	 * @return the new ability
	 */
	public Ability create(long abilityId);

	/**
	 * Removes the ability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param abilityId the primary key of the ability
	 * @return the ability that was removed
	 * @throws NoSuchAbilityException if a ability with the primary key could not be found
	 */
	public Ability remove(long abilityId) throws NoSuchAbilityException;

	public Ability updateImpl(Ability ability);

	/**
	 * Returns the ability with the primary key or throws a <code>NoSuchAbilityException</code> if it could not be found.
	 *
	 * @param abilityId the primary key of the ability
	 * @return the ability
	 * @throws NoSuchAbilityException if a ability with the primary key could not be found
	 */
	public Ability findByPrimaryKey(long abilityId)
		throws NoSuchAbilityException;

	/**
	 * Returns the ability with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param abilityId the primary key of the ability
	 * @return the ability, or <code>null</code> if a ability with the primary key could not be found
	 */
	public Ability fetchByPrimaryKey(long abilityId);

	/**
	 * Returns all the abilities.
	 *
	 * @return the abilities
	 */
	public java.util.List<Ability> findAll();

	/**
	 * Returns a range of all the abilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @return the range of abilities
	 */
	public java.util.List<Ability> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the abilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of abilities
	 */
	public java.util.List<Ability> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ability>
			orderByComparator);

	/**
	 * Returns an ordered range of all the abilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of abilities
	 */
	public java.util.List<Ability> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ability>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the abilities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of abilities.
	 *
	 * @return the number of abilities
	 */
	public int countAll();

}
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
import com.liferay.react.game.core.service.model.Ability;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ability service. This utility wraps <code>com.liferay.react.game.core.service.service.persistence.impl.AbilityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AbilityPersistence
 * @generated
 */
public class AbilityUtil {

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
	public static void clearCache(Ability ability) {
		getPersistence().clearCache(ability);
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
	public static Map<Serializable, Ability> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Ability> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Ability> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Ability> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Ability> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Ability update(Ability ability) {
		return getPersistence().update(ability);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Ability update(
		Ability ability, ServiceContext serviceContext) {

		return getPersistence().update(ability, serviceContext);
	}

	/**
	 * Returns all the abilities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching abilities
	 */
	public static List<Ability> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Ability> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Ability> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Ability> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Ability> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Ability> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ability
	 * @throws NoSuchAbilityException if a matching ability could not be found
	 */
	public static Ability findByUuid_First(
			String uuid, OrderByComparator<Ability> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchAbilityException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ability, or <code>null</code> if a matching ability could not be found
	 */
	public static Ability fetchByUuid_First(
		String uuid, OrderByComparator<Ability> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ability
	 * @throws NoSuchAbilityException if a matching ability could not be found
	 */
	public static Ability findByUuid_Last(
			String uuid, OrderByComparator<Ability> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchAbilityException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ability, or <code>null</code> if a matching ability could not be found
	 */
	public static Ability fetchByUuid_Last(
		String uuid, OrderByComparator<Ability> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the abilities before and after the current ability in the ordered set where uuid = &#63;.
	 *
	 * @param abilityId the primary key of the current ability
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ability
	 * @throws NoSuchAbilityException if a ability with the primary key could not be found
	 */
	public static Ability[] findByUuid_PrevAndNext(
			long abilityId, String uuid,
			OrderByComparator<Ability> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchAbilityException {

		return getPersistence().findByUuid_PrevAndNext(
			abilityId, uuid, orderByComparator);
	}

	/**
	 * Removes all the abilities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of abilities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching abilities
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the abilities where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @return the matching abilities
	 */
	public static List<Ability> findByAbilityName(String abilityName) {
		return getPersistence().findByAbilityName(abilityName);
	}

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
	public static List<Ability> findByAbilityName(
		String abilityName, int start, int end) {

		return getPersistence().findByAbilityName(abilityName, start, end);
	}

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
	public static List<Ability> findByAbilityName(
		String abilityName, int start, int end,
		OrderByComparator<Ability> orderByComparator) {

		return getPersistence().findByAbilityName(
			abilityName, start, end, orderByComparator);
	}

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
	public static List<Ability> findByAbilityName(
		String abilityName, int start, int end,
		OrderByComparator<Ability> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAbilityName(
			abilityName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ability in the ordered set where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ability
	 * @throws NoSuchAbilityException if a matching ability could not be found
	 */
	public static Ability findByAbilityName_First(
			String abilityName, OrderByComparator<Ability> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchAbilityException {

		return getPersistence().findByAbilityName_First(
			abilityName, orderByComparator);
	}

	/**
	 * Returns the first ability in the ordered set where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ability, or <code>null</code> if a matching ability could not be found
	 */
	public static Ability fetchByAbilityName_First(
		String abilityName, OrderByComparator<Ability> orderByComparator) {

		return getPersistence().fetchByAbilityName_First(
			abilityName, orderByComparator);
	}

	/**
	 * Returns the last ability in the ordered set where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ability
	 * @throws NoSuchAbilityException if a matching ability could not be found
	 */
	public static Ability findByAbilityName_Last(
			String abilityName, OrderByComparator<Ability> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchAbilityException {

		return getPersistence().findByAbilityName_Last(
			abilityName, orderByComparator);
	}

	/**
	 * Returns the last ability in the ordered set where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ability, or <code>null</code> if a matching ability could not be found
	 */
	public static Ability fetchByAbilityName_Last(
		String abilityName, OrderByComparator<Ability> orderByComparator) {

		return getPersistence().fetchByAbilityName_Last(
			abilityName, orderByComparator);
	}

	/**
	 * Returns the abilities before and after the current ability in the ordered set where abilityName = &#63;.
	 *
	 * @param abilityId the primary key of the current ability
	 * @param abilityName the ability name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ability
	 * @throws NoSuchAbilityException if a ability with the primary key could not be found
	 */
	public static Ability[] findByAbilityName_PrevAndNext(
			long abilityId, String abilityName,
			OrderByComparator<Ability> orderByComparator)
		throws com.liferay.react.game.core.service.exception.
			NoSuchAbilityException {

		return getPersistence().findByAbilityName_PrevAndNext(
			abilityId, abilityName, orderByComparator);
	}

	/**
	 * Removes all the abilities where abilityName = &#63; from the database.
	 *
	 * @param abilityName the ability name
	 */
	public static void removeByAbilityName(String abilityName) {
		getPersistence().removeByAbilityName(abilityName);
	}

	/**
	 * Returns the number of abilities where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @return the number of matching abilities
	 */
	public static int countByAbilityName(String abilityName) {
		return getPersistence().countByAbilityName(abilityName);
	}

	/**
	 * Caches the ability in the entity cache if it is enabled.
	 *
	 * @param ability the ability
	 */
	public static void cacheResult(Ability ability) {
		getPersistence().cacheResult(ability);
	}

	/**
	 * Caches the abilities in the entity cache if it is enabled.
	 *
	 * @param abilities the abilities
	 */
	public static void cacheResult(List<Ability> abilities) {
		getPersistence().cacheResult(abilities);
	}

	/**
	 * Creates a new ability with the primary key. Does not add the ability to the database.
	 *
	 * @param abilityId the primary key for the new ability
	 * @return the new ability
	 */
	public static Ability create(long abilityId) {
		return getPersistence().create(abilityId);
	}

	/**
	 * Removes the ability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param abilityId the primary key of the ability
	 * @return the ability that was removed
	 * @throws NoSuchAbilityException if a ability with the primary key could not be found
	 */
	public static Ability remove(long abilityId)
		throws com.liferay.react.game.core.service.exception.
			NoSuchAbilityException {

		return getPersistence().remove(abilityId);
	}

	public static Ability updateImpl(Ability ability) {
		return getPersistence().updateImpl(ability);
	}

	/**
	 * Returns the ability with the primary key or throws a <code>NoSuchAbilityException</code> if it could not be found.
	 *
	 * @param abilityId the primary key of the ability
	 * @return the ability
	 * @throws NoSuchAbilityException if a ability with the primary key could not be found
	 */
	public static Ability findByPrimaryKey(long abilityId)
		throws com.liferay.react.game.core.service.exception.
			NoSuchAbilityException {

		return getPersistence().findByPrimaryKey(abilityId);
	}

	/**
	 * Returns the ability with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param abilityId the primary key of the ability
	 * @return the ability, or <code>null</code> if a ability with the primary key could not be found
	 */
	public static Ability fetchByPrimaryKey(long abilityId) {
		return getPersistence().fetchByPrimaryKey(abilityId);
	}

	/**
	 * Returns all the abilities.
	 *
	 * @return the abilities
	 */
	public static List<Ability> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Ability> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Ability> findAll(
		int start, int end, OrderByComparator<Ability> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Ability> findAll(
		int start, int end, OrderByComparator<Ability> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the abilities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of abilities.
	 *
	 * @return the number of abilities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AbilityPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AbilityPersistence _persistence;

}
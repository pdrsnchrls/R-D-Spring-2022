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

package com.liferay.react.game.core.service.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.react.game.core.service.model.PlayerEnemyAbility;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PlayerEnemyAbility. This utility wraps
 * <code>com.liferay.react.game.core.service.service.impl.PlayerEnemyAbilityLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PlayerEnemyAbilityLocalService
 * @generated
 */
public class PlayerEnemyAbilityLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.react.game.core.service.service.impl.PlayerEnemyAbilityLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the player enemy ability to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlayerEnemyAbilityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param playerEnemyAbility the player enemy ability
	 * @return the player enemy ability that was added
	 */
	public static PlayerEnemyAbility addPlayerEnemyAbility(
		PlayerEnemyAbility playerEnemyAbility) {

		return getService().addPlayerEnemyAbility(playerEnemyAbility);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new player enemy ability with the primary key. Does not add the player enemy ability to the database.
	 *
	 * @param playerEnemyAbilityId the primary key for the new player enemy ability
	 * @return the new player enemy ability
	 */
	public static PlayerEnemyAbility createPlayerEnemyAbility(
		long playerEnemyAbilityId) {

		return getService().createPlayerEnemyAbility(playerEnemyAbilityId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the player enemy ability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlayerEnemyAbilityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param playerEnemyAbilityId the primary key of the player enemy ability
	 * @return the player enemy ability that was removed
	 * @throws PortalException if a player enemy ability with the primary key could not be found
	 */
	public static PlayerEnemyAbility deletePlayerEnemyAbility(
			long playerEnemyAbilityId)
		throws PortalException {

		return getService().deletePlayerEnemyAbility(playerEnemyAbilityId);
	}

	/**
	 * Deletes the player enemy ability from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlayerEnemyAbilityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param playerEnemyAbility the player enemy ability
	 * @return the player enemy ability that was removed
	 */
	public static PlayerEnemyAbility deletePlayerEnemyAbility(
		PlayerEnemyAbility playerEnemyAbility) {

		return getService().deletePlayerEnemyAbility(playerEnemyAbility);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.react.game.core.service.model.impl.PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.react.game.core.service.model.impl.PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static PlayerEnemyAbility fetchPlayerEnemyAbility(
		long playerEnemyAbilityId) {

		return getService().fetchPlayerEnemyAbility(playerEnemyAbilityId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the player enemy abilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.react.game.core.service.model.impl.PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @return the range of player enemy abilities
	 */
	public static List<PlayerEnemyAbility> getPlayerEnemyAbilities(
		int start, int end) {

		return getService().getPlayerEnemyAbilities(start, end);
	}

	/**
	 * Returns the number of player enemy abilities.
	 *
	 * @return the number of player enemy abilities
	 */
	public static int getPlayerEnemyAbilitiesCount() {
		return getService().getPlayerEnemyAbilitiesCount();
	}

	/**
	 * Returns the player enemy ability with the primary key.
	 *
	 * @param playerEnemyAbilityId the primary key of the player enemy ability
	 * @return the player enemy ability
	 * @throws PortalException if a player enemy ability with the primary key could not be found
	 */
	public static PlayerEnemyAbility getPlayerEnemyAbility(
			long playerEnemyAbilityId)
		throws PortalException {

		return getService().getPlayerEnemyAbility(playerEnemyAbilityId);
	}

	/**
	 * Updates the player enemy ability in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlayerEnemyAbilityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param playerEnemyAbility the player enemy ability
	 * @return the player enemy ability that was updated
	 */
	public static PlayerEnemyAbility updatePlayerEnemyAbility(
		PlayerEnemyAbility playerEnemyAbility) {

		return getService().updatePlayerEnemyAbility(playerEnemyAbility);
	}

	public static PlayerEnemyAbilityLocalService getService() {
		return _service;
	}

	private static volatile PlayerEnemyAbilityLocalService _service;

}
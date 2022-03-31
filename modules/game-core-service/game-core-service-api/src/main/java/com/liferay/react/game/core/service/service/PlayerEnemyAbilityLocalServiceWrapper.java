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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PlayerEnemyAbilityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PlayerEnemyAbilityLocalService
 * @generated
 */
public class PlayerEnemyAbilityLocalServiceWrapper
	implements PlayerEnemyAbilityLocalService,
			   ServiceWrapper<PlayerEnemyAbilityLocalService> {

	public PlayerEnemyAbilityLocalServiceWrapper(
		PlayerEnemyAbilityLocalService playerEnemyAbilityLocalService) {

		_playerEnemyAbilityLocalService = playerEnemyAbilityLocalService;
	}

	@Override
	public void addPlayerEnemyAbility(
		boolean enemy, long playerOrEnemyId, long abilityId) {

		_playerEnemyAbilityLocalService.addPlayerEnemyAbility(
			enemy, playerOrEnemyId, abilityId);
	}

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
	@Override
	public com.liferay.react.game.core.service.model.PlayerEnemyAbility
		addPlayerEnemyAbility(
			com.liferay.react.game.core.service.model.PlayerEnemyAbility
				playerEnemyAbility) {

		return _playerEnemyAbilityLocalService.addPlayerEnemyAbility(
			playerEnemyAbility);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _playerEnemyAbilityLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new player enemy ability with the primary key. Does not add the player enemy ability to the database.
	 *
	 * @param playerEnemyAbilityId the primary key for the new player enemy ability
	 * @return the new player enemy ability
	 */
	@Override
	public com.liferay.react.game.core.service.model.PlayerEnemyAbility
		createPlayerEnemyAbility(long playerEnemyAbilityId) {

		return _playerEnemyAbilityLocalService.createPlayerEnemyAbility(
			playerEnemyAbilityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _playerEnemyAbilityLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public com.liferay.react.game.core.service.model.PlayerEnemyAbility
			deletePlayerEnemyAbility(long playerEnemyAbilityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _playerEnemyAbilityLocalService.deletePlayerEnemyAbility(
			playerEnemyAbilityId);
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
	@Override
	public com.liferay.react.game.core.service.model.PlayerEnemyAbility
		deletePlayerEnemyAbility(
			com.liferay.react.game.core.service.model.PlayerEnemyAbility
				playerEnemyAbility) {

		return _playerEnemyAbilityLocalService.deletePlayerEnemyAbility(
			playerEnemyAbility);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _playerEnemyAbilityLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _playerEnemyAbilityLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _playerEnemyAbilityLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _playerEnemyAbilityLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _playerEnemyAbilityLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _playerEnemyAbilityLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _playerEnemyAbilityLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _playerEnemyAbilityLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.react.game.core.service.model.PlayerEnemyAbility
		fetchPlayerEnemyAbility(long playerEnemyAbilityId) {

		return _playerEnemyAbilityLocalService.fetchPlayerEnemyAbility(
			playerEnemyAbilityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _playerEnemyAbilityLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _playerEnemyAbilityLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _playerEnemyAbilityLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _playerEnemyAbilityLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List
		<com.liferay.react.game.core.service.model.PlayerEnemyAbility>
			getPlayerEnemyAbilities(int start, int end) {

		return _playerEnemyAbilityLocalService.getPlayerEnemyAbilities(
			start, end);
	}

	@Override
	public java.util.List<com.liferay.react.game.core.service.model.Ability>
		getPlayerEnemyAbilities(long playerOrEnemyId) {

		return _playerEnemyAbilityLocalService.getPlayerEnemyAbilities(
			playerOrEnemyId);
	}

	/**
	 * Returns the number of player enemy abilities.
	 *
	 * @return the number of player enemy abilities
	 */
	@Override
	public int getPlayerEnemyAbilitiesCount() {
		return _playerEnemyAbilityLocalService.getPlayerEnemyAbilitiesCount();
	}

	/**
	 * Returns the player enemy ability with the primary key.
	 *
	 * @param playerEnemyAbilityId the primary key of the player enemy ability
	 * @return the player enemy ability
	 * @throws PortalException if a player enemy ability with the primary key could not be found
	 */
	@Override
	public com.liferay.react.game.core.service.model.PlayerEnemyAbility
			getPlayerEnemyAbility(long playerEnemyAbilityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _playerEnemyAbilityLocalService.getPlayerEnemyAbility(
			playerEnemyAbilityId);
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
	@Override
	public com.liferay.react.game.core.service.model.PlayerEnemyAbility
		updatePlayerEnemyAbility(
			com.liferay.react.game.core.service.model.PlayerEnemyAbility
				playerEnemyAbility) {

		return _playerEnemyAbilityLocalService.updatePlayerEnemyAbility(
			playerEnemyAbility);
	}

	@Override
	public PlayerEnemyAbilityLocalService getWrappedService() {
		return _playerEnemyAbilityLocalService;
	}

	@Override
	public void setWrappedService(
		PlayerEnemyAbilityLocalService playerEnemyAbilityLocalService) {

		_playerEnemyAbilityLocalService = playerEnemyAbilityLocalService;
	}

	private PlayerEnemyAbilityLocalService _playerEnemyAbilityLocalService;

}
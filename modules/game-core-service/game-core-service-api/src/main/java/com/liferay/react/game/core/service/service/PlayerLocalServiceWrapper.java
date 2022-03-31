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
 * Provides a wrapper for {@link PlayerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PlayerLocalService
 * @generated
 */
public class PlayerLocalServiceWrapper
	implements PlayerLocalService, ServiceWrapper<PlayerLocalService> {

	public PlayerLocalServiceWrapper(PlayerLocalService playerLocalService) {
		_playerLocalService = playerLocalService;
	}

	/**
	 * Adds the player to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlayerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param player the player
	 * @return the player that was added
	 */
	@Override
	public com.liferay.react.game.core.service.model.Player addPlayer(
		com.liferay.react.game.core.service.model.Player player) {

		return _playerLocalService.addPlayer(player);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _playerLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new player with the primary key. Does not add the player to the database.
	 *
	 * @param playerId the primary key for the new player
	 * @return the new player
	 */
	@Override
	public com.liferay.react.game.core.service.model.Player createPlayer(
		long playerId) {

		return _playerLocalService.createPlayer(playerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _playerLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the player with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlayerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param playerId the primary key of the player
	 * @return the player that was removed
	 * @throws PortalException if a player with the primary key could not be found
	 */
	@Override
	public com.liferay.react.game.core.service.model.Player deletePlayer(
			long playerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _playerLocalService.deletePlayer(playerId);
	}

	/**
	 * Deletes the player from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlayerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param player the player
	 * @return the player that was removed
	 */
	@Override
	public com.liferay.react.game.core.service.model.Player deletePlayer(
		com.liferay.react.game.core.service.model.Player player) {

		return _playerLocalService.deletePlayer(player);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _playerLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _playerLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _playerLocalService.dynamicQuery();
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

		return _playerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.react.game.core.service.model.impl.PlayerModelImpl</code>.
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

		return _playerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.react.game.core.service.model.impl.PlayerModelImpl</code>.
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

		return _playerLocalService.dynamicQuery(
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

		return _playerLocalService.dynamicQueryCount(dynamicQuery);
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

		return _playerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.react.game.core.service.model.Player fetchPlayer(
		long playerId) {

		return _playerLocalService.fetchPlayer(playerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _playerLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _playerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _playerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _playerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the player with the primary key.
	 *
	 * @param playerId the primary key of the player
	 * @return the player
	 * @throws PortalException if a player with the primary key could not be found
	 */
	@Override
	public com.liferay.react.game.core.service.model.Player getPlayer(
			long playerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _playerLocalService.getPlayer(playerId);
	}

	/**
	 * Returns a range of all the players.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.react.game.core.service.model.impl.PlayerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of players
	 * @param end the upper bound of the range of players (not inclusive)
	 * @return the range of players
	 */
	@Override
	public java.util.List<com.liferay.react.game.core.service.model.Player>
		getPlayers(int start, int end) {

		return _playerLocalService.getPlayers(start, end);
	}

	/**
	 * Returns the number of players.
	 *
	 * @return the number of players
	 */
	@Override
	public int getPlayersCount() {
		return _playerLocalService.getPlayersCount();
	}

	/**
	 * Updates the player in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlayerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param player the player
	 * @return the player that was updated
	 */
	@Override
	public com.liferay.react.game.core.service.model.Player updatePlayer(
		com.liferay.react.game.core.service.model.Player player) {

		return _playerLocalService.updatePlayer(player);
	}

	@Override
	public PlayerLocalService getWrappedService() {
		return _playerLocalService;
	}

	@Override
	public void setWrappedService(PlayerLocalService playerLocalService) {
		_playerLocalService = playerLocalService;
	}

	private PlayerLocalService _playerLocalService;

}
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
 * Provides a wrapper for {@link EnemyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EnemyLocalService
 * @generated
 */
public class EnemyLocalServiceWrapper
	implements EnemyLocalService, ServiceWrapper<EnemyLocalService> {

	public EnemyLocalServiceWrapper(EnemyLocalService enemyLocalService) {
		_enemyLocalService = enemyLocalService;
	}

	/**
	 * Adds the enemy to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnemyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param enemy the enemy
	 * @return the enemy that was added
	 */
	@Override
	public com.liferay.react.game.core.service.model.Enemy addEnemy(
		com.liferay.react.game.core.service.model.Enemy enemy) {

		return _enemyLocalService.addEnemy(enemy);
	}

	/**
	 * Creates a new enemy with the primary key. Does not add the enemy to the database.
	 *
	 * @param enemyId the primary key for the new enemy
	 * @return the new enemy
	 */
	@Override
	public com.liferay.react.game.core.service.model.Enemy createEnemy(
		long enemyId) {

		return _enemyLocalService.createEnemy(enemyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enemyLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the enemy from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnemyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param enemy the enemy
	 * @return the enemy that was removed
	 */
	@Override
	public com.liferay.react.game.core.service.model.Enemy deleteEnemy(
		com.liferay.react.game.core.service.model.Enemy enemy) {

		return _enemyLocalService.deleteEnemy(enemy);
	}

	/**
	 * Deletes the enemy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnemyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param enemyId the primary key of the enemy
	 * @return the enemy that was removed
	 * @throws PortalException if a enemy with the primary key could not be found
	 */
	@Override
	public com.liferay.react.game.core.service.model.Enemy deleteEnemy(
			long enemyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enemyLocalService.deleteEnemy(enemyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enemyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _enemyLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _enemyLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _enemyLocalService.dynamicQuery();
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

		return _enemyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.react.game.core.service.model.impl.EnemyModelImpl</code>.
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

		return _enemyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.react.game.core.service.model.impl.EnemyModelImpl</code>.
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

		return _enemyLocalService.dynamicQuery(
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

		return _enemyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _enemyLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.react.game.core.service.model.Enemy fetchEnemy(
		long enemyId) {

		return _enemyLocalService.fetchEnemy(enemyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _enemyLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the enemies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.react.game.core.service.model.impl.EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @return the range of enemies
	 */
	@Override
	public java.util.List<com.liferay.react.game.core.service.model.Enemy>
		getEnemies(int start, int end) {

		return _enemyLocalService.getEnemies(start, end);
	}

	/**
	 * Returns the number of enemies.
	 *
	 * @return the number of enemies
	 */
	@Override
	public int getEnemiesCount() {
		return _enemyLocalService.getEnemiesCount();
	}

	/**
	 * Returns the enemy with the primary key.
	 *
	 * @param enemyId the primary key of the enemy
	 * @return the enemy
	 * @throws PortalException if a enemy with the primary key could not be found
	 */
	@Override
	public com.liferay.react.game.core.service.model.Enemy getEnemy(
			long enemyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enemyLocalService.getEnemy(enemyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _enemyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _enemyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _enemyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the enemy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EnemyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param enemy the enemy
	 * @return the enemy that was updated
	 */
	@Override
	public com.liferay.react.game.core.service.model.Enemy updateEnemy(
		com.liferay.react.game.core.service.model.Enemy enemy) {

		return _enemyLocalService.updateEnemy(enemy);
	}

	@Override
	public EnemyLocalService getWrappedService() {
		return _enemyLocalService;
	}

	@Override
	public void setWrappedService(EnemyLocalService enemyLocalService) {
		_enemyLocalService = enemyLocalService;
	}

	private EnemyLocalService _enemyLocalService;

}
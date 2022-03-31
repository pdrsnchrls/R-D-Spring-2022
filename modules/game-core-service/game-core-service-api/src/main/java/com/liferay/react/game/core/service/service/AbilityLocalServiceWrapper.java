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
 * Provides a wrapper for {@link AbilityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AbilityLocalService
 * @generated
 */
public class AbilityLocalServiceWrapper
	implements AbilityLocalService, ServiceWrapper<AbilityLocalService> {

	public AbilityLocalServiceWrapper(AbilityLocalService abilityLocalService) {
		_abilityLocalService = abilityLocalService;
	}

	/**
	 * Adds the ability to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AbilityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ability the ability
	 * @return the ability that was added
	 */
	@Override
	public com.liferay.react.game.core.service.model.Ability addAbility(
		com.liferay.react.game.core.service.model.Ability ability) {

		return _abilityLocalService.addAbility(ability);
	}

	@Override
	public com.liferay.react.game.core.service.model.Ability addAbility(
		String abilityName, boolean healing, int hitPoints) {

		return _abilityLocalService.addAbility(abilityName, healing, hitPoints);
	}

	/**
	 * Creates a new ability with the primary key. Does not add the ability to the database.
	 *
	 * @param abilityId the primary key for the new ability
	 * @return the new ability
	 */
	@Override
	public com.liferay.react.game.core.service.model.Ability createAbility(
		long abilityId) {

		return _abilityLocalService.createAbility(abilityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _abilityLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the ability from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AbilityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ability the ability
	 * @return the ability that was removed
	 */
	@Override
	public com.liferay.react.game.core.service.model.Ability deleteAbility(
		com.liferay.react.game.core.service.model.Ability ability) {

		return _abilityLocalService.deleteAbility(ability);
	}

	/**
	 * Deletes the ability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AbilityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param abilityId the primary key of the ability
	 * @return the ability that was removed
	 * @throws PortalException if a ability with the primary key could not be found
	 */
	@Override
	public com.liferay.react.game.core.service.model.Ability deleteAbility(
			long abilityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _abilityLocalService.deleteAbility(abilityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _abilityLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _abilityLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _abilityLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _abilityLocalService.dynamicQuery();
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

		return _abilityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.react.game.core.service.model.impl.AbilityModelImpl</code>.
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

		return _abilityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.react.game.core.service.model.impl.AbilityModelImpl</code>.
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

		return _abilityLocalService.dynamicQuery(
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

		return _abilityLocalService.dynamicQueryCount(dynamicQuery);
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

		return _abilityLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.react.game.core.service.model.Ability fetchAbility(
		long abilityId) {

		return _abilityLocalService.fetchAbility(abilityId);
	}

	/**
	 * Returns a range of all the abilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.react.game.core.service.model.impl.AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @return the range of abilities
	 */
	@Override
	public java.util.List<com.liferay.react.game.core.service.model.Ability>
		getAbilities(int start, int end) {

		return _abilityLocalService.getAbilities(start, end);
	}

	/**
	 * Returns the number of abilities.
	 *
	 * @return the number of abilities
	 */
	@Override
	public int getAbilitiesCount() {
		return _abilityLocalService.getAbilitiesCount();
	}

	/**
	 * Returns the ability with the primary key.
	 *
	 * @param abilityId the primary key of the ability
	 * @return the ability
	 * @throws PortalException if a ability with the primary key could not be found
	 */
	@Override
	public com.liferay.react.game.core.service.model.Ability getAbility(
			long abilityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _abilityLocalService.getAbility(abilityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _abilityLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _abilityLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _abilityLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _abilityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the ability in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AbilityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ability the ability
	 * @return the ability that was updated
	 */
	@Override
	public com.liferay.react.game.core.service.model.Ability updateAbility(
		com.liferay.react.game.core.service.model.Ability ability) {

		return _abilityLocalService.updateAbility(ability);
	}

	@Override
	public AbilityLocalService getWrappedService() {
		return _abilityLocalService;
	}

	@Override
	public void setWrappedService(AbilityLocalService abilityLocalService) {
		_abilityLocalService = abilityLocalService;
	}

	private AbilityLocalService _abilityLocalService;

}
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

package com.liferay.react.game.core.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.react.game.core.service.model.Ability;
import com.liferay.react.game.core.service.service.base.AbilityLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.react.game.core.service.model.Ability",
	service = AopService.class
)
public class AbilityLocalServiceImpl extends AbilityLocalServiceBaseImpl {

	public Ability addAbility(
		String abilityName, boolean healing, int hitPoints) {

		Ability ability = abilityLocalService.createAbility(
			counterLocalService.increment());

		ability.setAbilityName(abilityName);
		ability.setHealing(healing);
		ability.setHitPoints(Math.abs(hitPoints));

		return abilityLocalService.addAbility(ability);
	}

}
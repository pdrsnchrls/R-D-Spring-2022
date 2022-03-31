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
import com.liferay.react.game.core.service.model.PlayerEnemyAbility;
import com.liferay.react.game.core.service.service.base.PlayerEnemyAbilityLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.react.game.core.service.model.PlayerEnemyAbility",
	service = AopService.class
)
public class PlayerEnemyAbilityLocalServiceImpl
	extends PlayerEnemyAbilityLocalServiceBaseImpl {

	public void addPlayerEnemyAbility(boolean enemy, long playerOrEnemyId, long abilityId) {
		PlayerEnemyAbility playerEnemyAbility = playerEnemyAbilityLocalService.createPlayerEnemyAbility(counterLocalService.increment());

		playerEnemyAbility.setEnemy(enemy);
		playerEnemyAbility.setPlayerOrEnemyId(playerOrEnemyId);
		playerEnemyAbility.setAbilityId(abilityId);

		playerEnemyAbilityLocalService.addPlayerEnemyAbility(playerEnemyAbility);
		
	}
}
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
import com.liferay.react.game.core.service.model.Player;
import com.liferay.react.game.core.service.service.base.PlayerLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Objects;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.react.game.core.service.model.Player",
	service = AopService.class
)
public class PlayerLocalServiceImpl extends PlayerLocalServiceBaseImpl {

	public Player addNewPlayer(String playerName, long userId) {
		Player player = playerLocalService.createPlayer(counterLocalService.increment());

		player.setPlayerName(playerName);
		player.setUserId(userId);
		player.setLevel(0);
		player.setXpPoints(0);
		player.setHitPoints(50);

		player = playerLocalService.addPlayer(player);

		return player;
	}

	public Player levelUpPlayer(long playerId) {
		Player player = playerLocalService.fetchPlayer(playerId);

		if (Objects.nonNull(player)) {
			player.setLevel(player.getLevel() + 1);
			player.setHitPoints(player.getHitPoints() + 5);
		}

		return playerLocalService.updatePlayer(player);
	}

	public Player addPlayerXP(long playerId, int xpPoints) {
		Player player = playerLocalService.fetchPlayer(playerId);

		if (Objects.nonNull(player)) {
			int totalXP = player.getXpPoints() + xpPoints;

			player.setXpPoints(totalXP);

			if (totalXP % 100 >= 1) {
				return levelUpPlayer(playerId);
			}

			return playerLocalService.updatePlayer(player);
		} else {
			return null;
		}
	}
}
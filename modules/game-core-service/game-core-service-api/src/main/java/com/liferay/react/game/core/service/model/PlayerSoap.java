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

package com.liferay.react.game.core.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PlayerSoap implements Serializable {

	public static PlayerSoap toSoapModel(Player model) {
		PlayerSoap soapModel = new PlayerSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPlayerId(model.getPlayerId());
		soapModel.setUserId(model.getUserId());
		soapModel.setPlayerName(model.getPlayerName());
		soapModel.setLevel(model.getLevel());
		soapModel.setXpPoints(model.getXpPoints());
		soapModel.setHitPoints(model.getHitPoints());

		return soapModel;
	}

	public static PlayerSoap[] toSoapModels(Player[] models) {
		PlayerSoap[] soapModels = new PlayerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PlayerSoap[][] toSoapModels(Player[][] models) {
		PlayerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PlayerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PlayerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PlayerSoap[] toSoapModels(List<Player> models) {
		List<PlayerSoap> soapModels = new ArrayList<PlayerSoap>(models.size());

		for (Player model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PlayerSoap[soapModels.size()]);
	}

	public PlayerSoap() {
	}

	public long getPrimaryKey() {
		return _playerId;
	}

	public void setPrimaryKey(long pk) {
		setPlayerId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPlayerId() {
		return _playerId;
	}

	public void setPlayerId(long playerId) {
		_playerId = playerId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getPlayerName() {
		return _playerName;
	}

	public void setPlayerName(String playerName) {
		_playerName = playerName;
	}

	public int getLevel() {
		return _level;
	}

	public void setLevel(int level) {
		_level = level;
	}

	public int getXpPoints() {
		return _xpPoints;
	}

	public void setXpPoints(int xpPoints) {
		_xpPoints = xpPoints;
	}

	public int getHitPoints() {
		return _hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		_hitPoints = hitPoints;
	}

	private String _uuid;
	private long _playerId;
	private long _userId;
	private String _playerName;
	private int _level;
	private int _xpPoints;
	private int _hitPoints;

}
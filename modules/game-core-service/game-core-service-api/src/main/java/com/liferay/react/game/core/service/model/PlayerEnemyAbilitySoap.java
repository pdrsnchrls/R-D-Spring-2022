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
public class PlayerEnemyAbilitySoap implements Serializable {

	public static PlayerEnemyAbilitySoap toSoapModel(PlayerEnemyAbility model) {
		PlayerEnemyAbilitySoap soapModel = new PlayerEnemyAbilitySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPlayerEnemyAbilityId(model.getPlayerEnemyAbilityId());
		soapModel.setEnemy(model.isEnemy());
		soapModel.setPlayerOrEnemyId(model.getPlayerOrEnemyId());
		soapModel.setAbilityId(model.getAbilityId());

		return soapModel;
	}

	public static PlayerEnemyAbilitySoap[] toSoapModels(
		PlayerEnemyAbility[] models) {

		PlayerEnemyAbilitySoap[] soapModels =
			new PlayerEnemyAbilitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PlayerEnemyAbilitySoap[][] toSoapModels(
		PlayerEnemyAbility[][] models) {

		PlayerEnemyAbilitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PlayerEnemyAbilitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new PlayerEnemyAbilitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PlayerEnemyAbilitySoap[] toSoapModels(
		List<PlayerEnemyAbility> models) {

		List<PlayerEnemyAbilitySoap> soapModels =
			new ArrayList<PlayerEnemyAbilitySoap>(models.size());

		for (PlayerEnemyAbility model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new PlayerEnemyAbilitySoap[soapModels.size()]);
	}

	public PlayerEnemyAbilitySoap() {
	}

	public long getPrimaryKey() {
		return _playerEnemyAbilityId;
	}

	public void setPrimaryKey(long pk) {
		setPlayerEnemyAbilityId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPlayerEnemyAbilityId() {
		return _playerEnemyAbilityId;
	}

	public void setPlayerEnemyAbilityId(long playerEnemyAbilityId) {
		_playerEnemyAbilityId = playerEnemyAbilityId;
	}

	public boolean getEnemy() {
		return _enemy;
	}

	public boolean isEnemy() {
		return _enemy;
	}

	public void setEnemy(boolean enemy) {
		_enemy = enemy;
	}

	public long getPlayerOrEnemyId() {
		return _playerOrEnemyId;
	}

	public void setPlayerOrEnemyId(long playerOrEnemyId) {
		_playerOrEnemyId = playerOrEnemyId;
	}

	public long getAbilityId() {
		return _abilityId;
	}

	public void setAbilityId(long abilityId) {
		_abilityId = abilityId;
	}

	private String _uuid;
	private long _playerEnemyAbilityId;
	private boolean _enemy;
	private long _playerOrEnemyId;
	private long _abilityId;

}
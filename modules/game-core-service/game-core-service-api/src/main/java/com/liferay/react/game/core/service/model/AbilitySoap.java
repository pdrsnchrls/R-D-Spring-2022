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
public class AbilitySoap implements Serializable {

	public static AbilitySoap toSoapModel(Ability model) {
		AbilitySoap soapModel = new AbilitySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAbilityId(model.getAbilityId());
		soapModel.setAbilityName(model.getAbilityName());
		soapModel.setHealing(model.isHealing());
		soapModel.setHitPoints(model.getHitPoints());

		return soapModel;
	}

	public static AbilitySoap[] toSoapModels(Ability[] models) {
		AbilitySoap[] soapModels = new AbilitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AbilitySoap[][] toSoapModels(Ability[][] models) {
		AbilitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AbilitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AbilitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AbilitySoap[] toSoapModels(List<Ability> models) {
		List<AbilitySoap> soapModels = new ArrayList<AbilitySoap>(
			models.size());

		for (Ability model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AbilitySoap[soapModels.size()]);
	}

	public AbilitySoap() {
	}

	public long getPrimaryKey() {
		return _abilityId;
	}

	public void setPrimaryKey(long pk) {
		setAbilityId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAbilityId() {
		return _abilityId;
	}

	public void setAbilityId(long abilityId) {
		_abilityId = abilityId;
	}

	public String getAbilityName() {
		return _abilityName;
	}

	public void setAbilityName(String abilityName) {
		_abilityName = abilityName;
	}

	public boolean getHealing() {
		return _healing;
	}

	public boolean isHealing() {
		return _healing;
	}

	public void setHealing(boolean healing) {
		_healing = healing;
	}

	public int getHitPoints() {
		return _hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		_hitPoints = hitPoints;
	}

	private String _uuid;
	private long _abilityId;
	private String _abilityName;
	private boolean _healing;
	private int _hitPoints;

}
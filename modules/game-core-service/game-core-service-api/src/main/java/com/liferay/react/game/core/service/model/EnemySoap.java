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
public class EnemySoap implements Serializable {

	public static EnemySoap toSoapModel(Enemy model) {
		EnemySoap soapModel = new EnemySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEnemyId(model.getEnemyId());
		soapModel.setEnemyName(model.getEnemyName());
		soapModel.setLevel(model.getLevel());
		soapModel.setHitPoints(model.getHitPoints());
		soapModel.setXpDrop(model.getXpDrop());
		soapModel.setImageURL(model.getImageURL());

		return soapModel;
	}

	public static EnemySoap[] toSoapModels(Enemy[] models) {
		EnemySoap[] soapModels = new EnemySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EnemySoap[][] toSoapModels(Enemy[][] models) {
		EnemySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EnemySoap[models.length][models[0].length];
		}
		else {
			soapModels = new EnemySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EnemySoap[] toSoapModels(List<Enemy> models) {
		List<EnemySoap> soapModels = new ArrayList<EnemySoap>(models.size());

		for (Enemy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EnemySoap[soapModels.size()]);
	}

	public EnemySoap() {
	}

	public long getPrimaryKey() {
		return _enemyId;
	}

	public void setPrimaryKey(long pk) {
		setEnemyId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEnemyId() {
		return _enemyId;
	}

	public void setEnemyId(long enemyId) {
		_enemyId = enemyId;
	}

	public String getEnemyName() {
		return _enemyName;
	}

	public void setEnemyName(String enemyName) {
		_enemyName = enemyName;
	}

	public int getLevel() {
		return _level;
	}

	public void setLevel(int level) {
		_level = level;
	}

	public int getHitPoints() {
		return _hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		_hitPoints = hitPoints;
	}

	public int getXpDrop() {
		return _xpDrop;
	}

	public void setXpDrop(int xpDrop) {
		_xpDrop = xpDrop;
	}

	public String getImageURL() {
		return _imageURL;
	}

	public void setImageURL(String imageURL) {
		_imageURL = imageURL;
	}

	private String _uuid;
	private long _enemyId;
	private String _enemyName;
	private int _level;
	private int _hitPoints;
	private int _xpDrop;
	private String _imageURL;

}
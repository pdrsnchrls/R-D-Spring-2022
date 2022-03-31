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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Enemy}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Enemy
 * @generated
 */
public class EnemyWrapper
	extends BaseModelWrapper<Enemy> implements Enemy, ModelWrapper<Enemy> {

	public EnemyWrapper(Enemy enemy) {
		super(enemy);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("enemyId", getEnemyId());
		attributes.put("enemyName", getEnemyName());
		attributes.put("level", getLevel());
		attributes.put("hitPoints", getHitPoints());
		attributes.put("xpDrop", getXpDrop());
		attributes.put("imageURL", getImageURL());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long enemyId = (Long)attributes.get("enemyId");

		if (enemyId != null) {
			setEnemyId(enemyId);
		}

		String enemyName = (String)attributes.get("enemyName");

		if (enemyName != null) {
			setEnemyName(enemyName);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Integer hitPoints = (Integer)attributes.get("hitPoints");

		if (hitPoints != null) {
			setHitPoints(hitPoints);
		}

		Integer xpDrop = (Integer)attributes.get("xpDrop");

		if (xpDrop != null) {
			setXpDrop(xpDrop);
		}

		String imageURL = (String)attributes.get("imageURL");

		if (imageURL != null) {
			setImageURL(imageURL);
		}
	}

	@Override
	public Enemy cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the enemy ID of this enemy.
	 *
	 * @return the enemy ID of this enemy
	 */
	@Override
	public long getEnemyId() {
		return model.getEnemyId();
	}

	/**
	 * Returns the enemy name of this enemy.
	 *
	 * @return the enemy name of this enemy
	 */
	@Override
	public String getEnemyName() {
		return model.getEnemyName();
	}

	/**
	 * Returns the hit points of this enemy.
	 *
	 * @return the hit points of this enemy
	 */
	@Override
	public int getHitPoints() {
		return model.getHitPoints();
	}

	/**
	 * Returns the image url of this enemy.
	 *
	 * @return the image url of this enemy
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Returns the level of this enemy.
	 *
	 * @return the level of this enemy
	 */
	@Override
	public int getLevel() {
		return model.getLevel();
	}

	/**
	 * Returns the primary key of this enemy.
	 *
	 * @return the primary key of this enemy
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this enemy.
	 *
	 * @return the uuid of this enemy
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the xp drop of this enemy.
	 *
	 * @return the xp drop of this enemy
	 */
	@Override
	public int getXpDrop() {
		return model.getXpDrop();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the enemy ID of this enemy.
	 *
	 * @param enemyId the enemy ID of this enemy
	 */
	@Override
	public void setEnemyId(long enemyId) {
		model.setEnemyId(enemyId);
	}

	/**
	 * Sets the enemy name of this enemy.
	 *
	 * @param enemyName the enemy name of this enemy
	 */
	@Override
	public void setEnemyName(String enemyName) {
		model.setEnemyName(enemyName);
	}

	/**
	 * Sets the hit points of this enemy.
	 *
	 * @param hitPoints the hit points of this enemy
	 */
	@Override
	public void setHitPoints(int hitPoints) {
		model.setHitPoints(hitPoints);
	}

	/**
	 * Sets the image url of this enemy.
	 *
	 * @param imageURL the image url of this enemy
	 */
	@Override
	public void setImageURL(String imageURL) {
		model.setImageURL(imageURL);
	}

	/**
	 * Sets the level of this enemy.
	 *
	 * @param level the level of this enemy
	 */
	@Override
	public void setLevel(int level) {
		model.setLevel(level);
	}

	/**
	 * Sets the primary key of this enemy.
	 *
	 * @param primaryKey the primary key of this enemy
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this enemy.
	 *
	 * @param uuid the uuid of this enemy
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the xp drop of this enemy.
	 *
	 * @param xpDrop the xp drop of this enemy
	 */
	@Override
	public void setXpDrop(int xpDrop) {
		model.setXpDrop(xpDrop);
	}

	@Override
	protected EnemyWrapper wrap(Enemy enemy) {
		return new EnemyWrapper(enemy);
	}

}
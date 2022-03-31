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

package com.liferay.react.game.core.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.react.game.core.service.model.Enemy;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Enemy in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EnemyCacheModel implements CacheModel<Enemy>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EnemyCacheModel)) {
			return false;
		}

		EnemyCacheModel enemyCacheModel = (EnemyCacheModel)object;

		if (enemyId == enemyCacheModel.enemyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, enemyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", enemyId=");
		sb.append(enemyId);
		sb.append(", enemyName=");
		sb.append(enemyName);
		sb.append(", level=");
		sb.append(level);
		sb.append(", hitPoints=");
		sb.append(hitPoints);
		sb.append(", xpDrop=");
		sb.append(xpDrop);
		sb.append(", imageURL=");
		sb.append(imageURL);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Enemy toEntityModel() {
		EnemyImpl enemyImpl = new EnemyImpl();

		if (uuid == null) {
			enemyImpl.setUuid("");
		}
		else {
			enemyImpl.setUuid(uuid);
		}

		enemyImpl.setEnemyId(enemyId);

		if (enemyName == null) {
			enemyImpl.setEnemyName("");
		}
		else {
			enemyImpl.setEnemyName(enemyName);
		}

		enemyImpl.setLevel(level);
		enemyImpl.setHitPoints(hitPoints);
		enemyImpl.setXpDrop(xpDrop);

		if (imageURL == null) {
			enemyImpl.setImageURL("");
		}
		else {
			enemyImpl.setImageURL(imageURL);
		}

		enemyImpl.resetOriginalValues();

		return enemyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		enemyId = objectInput.readLong();
		enemyName = objectInput.readUTF();

		level = objectInput.readInt();

		hitPoints = objectInput.readInt();

		xpDrop = objectInput.readInt();
		imageURL = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(enemyId);

		if (enemyName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(enemyName);
		}

		objectOutput.writeInt(level);

		objectOutput.writeInt(hitPoints);

		objectOutput.writeInt(xpDrop);

		if (imageURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imageURL);
		}
	}

	public String uuid;
	public long enemyId;
	public String enemyName;
	public int level;
	public int hitPoints;
	public int xpDrop;
	public String imageURL;

}
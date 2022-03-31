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
import com.liferay.react.game.core.service.model.Player;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Player in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PlayerCacheModel implements CacheModel<Player>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PlayerCacheModel)) {
			return false;
		}

		PlayerCacheModel playerCacheModel = (PlayerCacheModel)object;

		if (playerId == playerCacheModel.playerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, playerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", playerId=");
		sb.append(playerId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", playerName=");
		sb.append(playerName);
		sb.append(", level=");
		sb.append(level);
		sb.append(", xpPoints=");
		sb.append(xpPoints);
		sb.append(", hitPoints=");
		sb.append(hitPoints);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Player toEntityModel() {
		PlayerImpl playerImpl = new PlayerImpl();

		if (uuid == null) {
			playerImpl.setUuid("");
		}
		else {
			playerImpl.setUuid(uuid);
		}

		playerImpl.setPlayerId(playerId);
		playerImpl.setUserId(userId);

		if (playerName == null) {
			playerImpl.setPlayerName("");
		}
		else {
			playerImpl.setPlayerName(playerName);
		}

		playerImpl.setLevel(level);
		playerImpl.setXpPoints(xpPoints);
		playerImpl.setHitPoints(hitPoints);

		playerImpl.resetOriginalValues();

		return playerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		playerId = objectInput.readLong();

		userId = objectInput.readLong();
		playerName = objectInput.readUTF();

		level = objectInput.readInt();

		xpPoints = objectInput.readInt();

		hitPoints = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(playerId);

		objectOutput.writeLong(userId);

		if (playerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(playerName);
		}

		objectOutput.writeInt(level);

		objectOutput.writeInt(xpPoints);

		objectOutput.writeInt(hitPoints);
	}

	public String uuid;
	public long playerId;
	public long userId;
	public String playerName;
	public int level;
	public int xpPoints;
	public int hitPoints;

}
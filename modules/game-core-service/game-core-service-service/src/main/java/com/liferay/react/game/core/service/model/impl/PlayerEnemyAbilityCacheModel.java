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
import com.liferay.react.game.core.service.model.PlayerEnemyAbility;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PlayerEnemyAbility in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PlayerEnemyAbilityCacheModel
	implements CacheModel<PlayerEnemyAbility>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PlayerEnemyAbilityCacheModel)) {
			return false;
		}

		PlayerEnemyAbilityCacheModel playerEnemyAbilityCacheModel =
			(PlayerEnemyAbilityCacheModel)object;

		if (playerEnemyAbilityId ==
				playerEnemyAbilityCacheModel.playerEnemyAbilityId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, playerEnemyAbilityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", playerEnemyAbilityId=");
		sb.append(playerEnemyAbilityId);
		sb.append(", enemy=");
		sb.append(enemy);
		sb.append(", playerOrEnemyId=");
		sb.append(playerOrEnemyId);
		sb.append(", abilityId=");
		sb.append(abilityId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PlayerEnemyAbility toEntityModel() {
		PlayerEnemyAbilityImpl playerEnemyAbilityImpl =
			new PlayerEnemyAbilityImpl();

		if (uuid == null) {
			playerEnemyAbilityImpl.setUuid("");
		}
		else {
			playerEnemyAbilityImpl.setUuid(uuid);
		}

		playerEnemyAbilityImpl.setPlayerEnemyAbilityId(playerEnemyAbilityId);
		playerEnemyAbilityImpl.setEnemy(enemy);
		playerEnemyAbilityImpl.setPlayerOrEnemyId(playerOrEnemyId);
		playerEnemyAbilityImpl.setAbilityId(abilityId);

		playerEnemyAbilityImpl.resetOriginalValues();

		return playerEnemyAbilityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		playerEnemyAbilityId = objectInput.readLong();

		enemy = objectInput.readBoolean();

		playerOrEnemyId = objectInput.readLong();

		abilityId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(playerEnemyAbilityId);

		objectOutput.writeBoolean(enemy);

		objectOutput.writeLong(playerOrEnemyId);

		objectOutput.writeLong(abilityId);
	}

	public String uuid;
	public long playerEnemyAbilityId;
	public boolean enemy;
	public long playerOrEnemyId;
	public long abilityId;

}
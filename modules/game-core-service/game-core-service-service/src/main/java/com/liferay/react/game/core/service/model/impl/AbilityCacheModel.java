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
import com.liferay.react.game.core.service.model.Ability;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Ability in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AbilityCacheModel implements CacheModel<Ability>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AbilityCacheModel)) {
			return false;
		}

		AbilityCacheModel abilityCacheModel = (AbilityCacheModel)object;

		if (abilityId == abilityCacheModel.abilityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, abilityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", abilityId=");
		sb.append(abilityId);
		sb.append(", abilityName=");
		sb.append(abilityName);
		sb.append(", healing=");
		sb.append(healing);
		sb.append(", hitPoints=");
		sb.append(hitPoints);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Ability toEntityModel() {
		AbilityImpl abilityImpl = new AbilityImpl();

		if (uuid == null) {
			abilityImpl.setUuid("");
		}
		else {
			abilityImpl.setUuid(uuid);
		}

		abilityImpl.setAbilityId(abilityId);

		if (abilityName == null) {
			abilityImpl.setAbilityName("");
		}
		else {
			abilityImpl.setAbilityName(abilityName);
		}

		abilityImpl.setHealing(healing);
		abilityImpl.setHitPoints(hitPoints);

		abilityImpl.resetOriginalValues();

		return abilityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		abilityId = objectInput.readLong();
		abilityName = objectInput.readUTF();

		healing = objectInput.readBoolean();

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

		objectOutput.writeLong(abilityId);

		if (abilityName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(abilityName);
		}

		objectOutput.writeBoolean(healing);

		objectOutput.writeInt(hitPoints);
	}

	public String uuid;
	public long abilityId;
	public String abilityName;
	public boolean healing;
	public int hitPoints;

}
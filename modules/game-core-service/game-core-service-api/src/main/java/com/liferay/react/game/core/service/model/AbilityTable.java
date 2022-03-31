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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;ReactGame_Ability&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Ability
 * @generated
 */
public class AbilityTable extends BaseTable<AbilityTable> {

	public static final AbilityTable INSTANCE = new AbilityTable();

	public final Column<AbilityTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AbilityTable, Long> abilityId = createColumn(
		"abilityId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AbilityTable, String> abilityName = createColumn(
		"abilityName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AbilityTable, Boolean> healing = createColumn(
		"healing", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AbilityTable, Integer> hitPoints = createColumn(
		"hitPoints", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private AbilityTable() {
		super("ReactGame_Ability", AbilityTable::new);
	}

}
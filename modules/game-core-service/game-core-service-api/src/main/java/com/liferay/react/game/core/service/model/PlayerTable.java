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
 * The table class for the &quot;ReactGame_Player&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Player
 * @generated
 */
public class PlayerTable extends BaseTable<PlayerTable> {

	public static final PlayerTable INSTANCE = new PlayerTable();

	public final Column<PlayerTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlayerTable, Long> playerId = createColumn(
		"playerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PlayerTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlayerTable, String> playerName = createColumn(
		"playerName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlayerTable, Integer> level = createColumn(
		"level", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PlayerTable, Integer> xpPoints = createColumn(
		"xpPoints", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PlayerTable, Integer> hitPoints = createColumn(
		"hitPoints", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private PlayerTable() {
		super("ReactGame_Player", PlayerTable::new);
	}

}
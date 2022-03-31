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
 * The table class for the &quot;ReactGame_Enemy&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Enemy
 * @generated
 */
public class EnemyTable extends BaseTable<EnemyTable> {

	public static final EnemyTable INSTANCE = new EnemyTable();

	public final Column<EnemyTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EnemyTable, Long> enemyId = createColumn(
		"enemyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EnemyTable, String> enemyName = createColumn(
		"enemyName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EnemyTable, Integer> level = createColumn(
		"level", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<EnemyTable, Integer> hitPoints = createColumn(
		"hitPoints", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<EnemyTable, Integer> xpDrop = createColumn(
		"xpDrop", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<EnemyTable, String> imageURL = createColumn(
		"imageURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private EnemyTable() {
		super("ReactGame_Enemy", EnemyTable::new);
	}

}
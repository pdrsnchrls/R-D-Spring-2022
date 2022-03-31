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

package com.liferay.react.game.core.service.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.react.game.core.service.exception.NoSuchEnemyException;
import com.liferay.react.game.core.service.model.Enemy;
import com.liferay.react.game.core.service.model.EnemyTable;
import com.liferay.react.game.core.service.model.impl.EnemyImpl;
import com.liferay.react.game.core.service.model.impl.EnemyModelImpl;
import com.liferay.react.game.core.service.service.persistence.EnemyPersistence;
import com.liferay.react.game.core.service.service.persistence.EnemyUtil;
import com.liferay.react.game.core.service.service.persistence.impl.constants.ReactGamePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the enemy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {EnemyPersistence.class, BasePersistence.class})
public class EnemyPersistenceImpl
	extends BasePersistenceImpl<Enemy> implements EnemyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EnemyUtil</code> to access the enemy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EnemyImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the enemies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching enemies
	 */
	@Override
	public List<Enemy> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enemies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @return the range of matching enemies
	 */
	@Override
	public List<Enemy> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enemies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enemies
	 */
	@Override
	public List<Enemy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Enemy> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the enemies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching enemies
	 */
	@Override
	public List<Enemy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Enemy> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Enemy> list = null;

		if (useFinderCache) {
			list = (List<Enemy>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Enemy enemy : list) {
					if (!uuid.equals(enemy.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ENEMY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EnemyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Enemy>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first enemy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enemy
	 * @throws NoSuchEnemyException if a matching enemy could not be found
	 */
	@Override
	public Enemy findByUuid_First(
			String uuid, OrderByComparator<Enemy> orderByComparator)
		throws NoSuchEnemyException {

		Enemy enemy = fetchByUuid_First(uuid, orderByComparator);

		if (enemy != null) {
			return enemy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEnemyException(sb.toString());
	}

	/**
	 * Returns the first enemy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enemy, or <code>null</code> if a matching enemy could not be found
	 */
	@Override
	public Enemy fetchByUuid_First(
		String uuid, OrderByComparator<Enemy> orderByComparator) {

		List<Enemy> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last enemy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enemy
	 * @throws NoSuchEnemyException if a matching enemy could not be found
	 */
	@Override
	public Enemy findByUuid_Last(
			String uuid, OrderByComparator<Enemy> orderByComparator)
		throws NoSuchEnemyException {

		Enemy enemy = fetchByUuid_Last(uuid, orderByComparator);

		if (enemy != null) {
			return enemy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEnemyException(sb.toString());
	}

	/**
	 * Returns the last enemy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enemy, or <code>null</code> if a matching enemy could not be found
	 */
	@Override
	public Enemy fetchByUuid_Last(
		String uuid, OrderByComparator<Enemy> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Enemy> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enemies before and after the current enemy in the ordered set where uuid = &#63;.
	 *
	 * @param enemyId the primary key of the current enemy
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next enemy
	 * @throws NoSuchEnemyException if a enemy with the primary key could not be found
	 */
	@Override
	public Enemy[] findByUuid_PrevAndNext(
			long enemyId, String uuid,
			OrderByComparator<Enemy> orderByComparator)
		throws NoSuchEnemyException {

		uuid = Objects.toString(uuid, "");

		Enemy enemy = findByPrimaryKey(enemyId);

		Session session = null;

		try {
			session = openSession();

			Enemy[] array = new EnemyImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, enemy, uuid, orderByComparator, true);

			array[1] = enemy;

			array[2] = getByUuid_PrevAndNext(
				session, enemy, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Enemy getByUuid_PrevAndNext(
		Session session, Enemy enemy, String uuid,
		OrderByComparator<Enemy> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ENEMY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EnemyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(enemy)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Enemy> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enemies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Enemy enemy :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(enemy);
		}
	}

	/**
	 * Returns the number of enemies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching enemies
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENEMY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "enemy.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(enemy.uuid IS NULL OR enemy.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByEnemyName;
	private FinderPath _finderPathWithoutPaginationFindByEnemyName;
	private FinderPath _finderPathCountByEnemyName;

	/**
	 * Returns all the enemies where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @return the matching enemies
	 */
	@Override
	public List<Enemy> findByEnemyName(String enemyName) {
		return findByEnemyName(
			enemyName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enemies where enemyName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param enemyName the enemy name
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @return the range of matching enemies
	 */
	@Override
	public List<Enemy> findByEnemyName(String enemyName, int start, int end) {
		return findByEnemyName(enemyName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enemies where enemyName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param enemyName the enemy name
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enemies
	 */
	@Override
	public List<Enemy> findByEnemyName(
		String enemyName, int start, int end,
		OrderByComparator<Enemy> orderByComparator) {

		return findByEnemyName(enemyName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the enemies where enemyName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param enemyName the enemy name
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching enemies
	 */
	@Override
	public List<Enemy> findByEnemyName(
		String enemyName, int start, int end,
		OrderByComparator<Enemy> orderByComparator, boolean useFinderCache) {

		enemyName = Objects.toString(enemyName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEnemyName;
				finderArgs = new Object[] {enemyName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEnemyName;
			finderArgs = new Object[] {
				enemyName, start, end, orderByComparator
			};
		}

		List<Enemy> list = null;

		if (useFinderCache) {
			list = (List<Enemy>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Enemy enemy : list) {
					if (!enemyName.equals(enemy.getEnemyName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ENEMY_WHERE);

			boolean bindEnemyName = false;

			if (enemyName.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENEMYNAME_ENEMYNAME_3);
			}
			else {
				bindEnemyName = true;

				sb.append(_FINDER_COLUMN_ENEMYNAME_ENEMYNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EnemyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEnemyName) {
					queryPos.add(enemyName);
				}

				list = (List<Enemy>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first enemy in the ordered set where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enemy
	 * @throws NoSuchEnemyException if a matching enemy could not be found
	 */
	@Override
	public Enemy findByEnemyName_First(
			String enemyName, OrderByComparator<Enemy> orderByComparator)
		throws NoSuchEnemyException {

		Enemy enemy = fetchByEnemyName_First(enemyName, orderByComparator);

		if (enemy != null) {
			return enemy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("enemyName=");
		sb.append(enemyName);

		sb.append("}");

		throw new NoSuchEnemyException(sb.toString());
	}

	/**
	 * Returns the first enemy in the ordered set where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enemy, or <code>null</code> if a matching enemy could not be found
	 */
	@Override
	public Enemy fetchByEnemyName_First(
		String enemyName, OrderByComparator<Enemy> orderByComparator) {

		List<Enemy> list = findByEnemyName(enemyName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last enemy in the ordered set where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enemy
	 * @throws NoSuchEnemyException if a matching enemy could not be found
	 */
	@Override
	public Enemy findByEnemyName_Last(
			String enemyName, OrderByComparator<Enemy> orderByComparator)
		throws NoSuchEnemyException {

		Enemy enemy = fetchByEnemyName_Last(enemyName, orderByComparator);

		if (enemy != null) {
			return enemy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("enemyName=");
		sb.append(enemyName);

		sb.append("}");

		throw new NoSuchEnemyException(sb.toString());
	}

	/**
	 * Returns the last enemy in the ordered set where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enemy, or <code>null</code> if a matching enemy could not be found
	 */
	@Override
	public Enemy fetchByEnemyName_Last(
		String enemyName, OrderByComparator<Enemy> orderByComparator) {

		int count = countByEnemyName(enemyName);

		if (count == 0) {
			return null;
		}

		List<Enemy> list = findByEnemyName(
			enemyName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enemies before and after the current enemy in the ordered set where enemyName = &#63;.
	 *
	 * @param enemyId the primary key of the current enemy
	 * @param enemyName the enemy name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next enemy
	 * @throws NoSuchEnemyException if a enemy with the primary key could not be found
	 */
	@Override
	public Enemy[] findByEnemyName_PrevAndNext(
			long enemyId, String enemyName,
			OrderByComparator<Enemy> orderByComparator)
		throws NoSuchEnemyException {

		enemyName = Objects.toString(enemyName, "");

		Enemy enemy = findByPrimaryKey(enemyId);

		Session session = null;

		try {
			session = openSession();

			Enemy[] array = new EnemyImpl[3];

			array[0] = getByEnemyName_PrevAndNext(
				session, enemy, enemyName, orderByComparator, true);

			array[1] = enemy;

			array[2] = getByEnemyName_PrevAndNext(
				session, enemy, enemyName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Enemy getByEnemyName_PrevAndNext(
		Session session, Enemy enemy, String enemyName,
		OrderByComparator<Enemy> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ENEMY_WHERE);

		boolean bindEnemyName = false;

		if (enemyName.isEmpty()) {
			sb.append(_FINDER_COLUMN_ENEMYNAME_ENEMYNAME_3);
		}
		else {
			bindEnemyName = true;

			sb.append(_FINDER_COLUMN_ENEMYNAME_ENEMYNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EnemyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEnemyName) {
			queryPos.add(enemyName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(enemy)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Enemy> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enemies where enemyName = &#63; from the database.
	 *
	 * @param enemyName the enemy name
	 */
	@Override
	public void removeByEnemyName(String enemyName) {
		for (Enemy enemy :
				findByEnemyName(
					enemyName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(enemy);
		}
	}

	/**
	 * Returns the number of enemies where enemyName = &#63;.
	 *
	 * @param enemyName the enemy name
	 * @return the number of matching enemies
	 */
	@Override
	public int countByEnemyName(String enemyName) {
		enemyName = Objects.toString(enemyName, "");

		FinderPath finderPath = _finderPathCountByEnemyName;

		Object[] finderArgs = new Object[] {enemyName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ENEMY_WHERE);

			boolean bindEnemyName = false;

			if (enemyName.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENEMYNAME_ENEMYNAME_3);
			}
			else {
				bindEnemyName = true;

				sb.append(_FINDER_COLUMN_ENEMYNAME_ENEMYNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEnemyName) {
					queryPos.add(enemyName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ENEMYNAME_ENEMYNAME_2 =
		"enemy.enemyName = ?";

	private static final String _FINDER_COLUMN_ENEMYNAME_ENEMYNAME_3 =
		"(enemy.enemyName IS NULL OR enemy.enemyName = '')";

	public EnemyPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Enemy.class);

		setModelImplClass(EnemyImpl.class);
		setModelPKClass(long.class);

		setTable(EnemyTable.INSTANCE);
	}

	/**
	 * Caches the enemy in the entity cache if it is enabled.
	 *
	 * @param enemy the enemy
	 */
	@Override
	public void cacheResult(Enemy enemy) {
		entityCache.putResult(EnemyImpl.class, enemy.getPrimaryKey(), enemy);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the enemies in the entity cache if it is enabled.
	 *
	 * @param enemies the enemies
	 */
	@Override
	public void cacheResult(List<Enemy> enemies) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (enemies.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Enemy enemy : enemies) {
			if (entityCache.getResult(EnemyImpl.class, enemy.getPrimaryKey()) ==
					null) {

				cacheResult(enemy);
			}
		}
	}

	/**
	 * Clears the cache for all enemies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EnemyImpl.class);

		finderCache.clearCache(EnemyImpl.class);
	}

	/**
	 * Clears the cache for the enemy.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Enemy enemy) {
		entityCache.removeResult(EnemyImpl.class, enemy);
	}

	@Override
	public void clearCache(List<Enemy> enemies) {
		for (Enemy enemy : enemies) {
			entityCache.removeResult(EnemyImpl.class, enemy);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EnemyImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EnemyImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new enemy with the primary key. Does not add the enemy to the database.
	 *
	 * @param enemyId the primary key for the new enemy
	 * @return the new enemy
	 */
	@Override
	public Enemy create(long enemyId) {
		Enemy enemy = new EnemyImpl();

		enemy.setNew(true);
		enemy.setPrimaryKey(enemyId);

		String uuid = PortalUUIDUtil.generate();

		enemy.setUuid(uuid);

		return enemy;
	}

	/**
	 * Removes the enemy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param enemyId the primary key of the enemy
	 * @return the enemy that was removed
	 * @throws NoSuchEnemyException if a enemy with the primary key could not be found
	 */
	@Override
	public Enemy remove(long enemyId) throws NoSuchEnemyException {
		return remove((Serializable)enemyId);
	}

	/**
	 * Removes the enemy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the enemy
	 * @return the enemy that was removed
	 * @throws NoSuchEnemyException if a enemy with the primary key could not be found
	 */
	@Override
	public Enemy remove(Serializable primaryKey) throws NoSuchEnemyException {
		Session session = null;

		try {
			session = openSession();

			Enemy enemy = (Enemy)session.get(EnemyImpl.class, primaryKey);

			if (enemy == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEnemyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(enemy);
		}
		catch (NoSuchEnemyException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Enemy removeImpl(Enemy enemy) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(enemy)) {
				enemy = (Enemy)session.get(
					EnemyImpl.class, enemy.getPrimaryKeyObj());
			}

			if (enemy != null) {
				session.delete(enemy);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (enemy != null) {
			clearCache(enemy);
		}

		return enemy;
	}

	@Override
	public Enemy updateImpl(Enemy enemy) {
		boolean isNew = enemy.isNew();

		if (!(enemy instanceof EnemyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(enemy.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(enemy);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in enemy proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Enemy implementation " +
					enemy.getClass());
		}

		EnemyModelImpl enemyModelImpl = (EnemyModelImpl)enemy;

		if (Validator.isNull(enemy.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			enemy.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(enemy);
			}
			else {
				enemy = (Enemy)session.merge(enemy);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(EnemyImpl.class, enemyModelImpl, false, true);

		if (isNew) {
			enemy.setNew(false);
		}

		enemy.resetOriginalValues();

		return enemy;
	}

	/**
	 * Returns the enemy with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the enemy
	 * @return the enemy
	 * @throws NoSuchEnemyException if a enemy with the primary key could not be found
	 */
	@Override
	public Enemy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEnemyException {

		Enemy enemy = fetchByPrimaryKey(primaryKey);

		if (enemy == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEnemyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return enemy;
	}

	/**
	 * Returns the enemy with the primary key or throws a <code>NoSuchEnemyException</code> if it could not be found.
	 *
	 * @param enemyId the primary key of the enemy
	 * @return the enemy
	 * @throws NoSuchEnemyException if a enemy with the primary key could not be found
	 */
	@Override
	public Enemy findByPrimaryKey(long enemyId) throws NoSuchEnemyException {
		return findByPrimaryKey((Serializable)enemyId);
	}

	/**
	 * Returns the enemy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param enemyId the primary key of the enemy
	 * @return the enemy, or <code>null</code> if a enemy with the primary key could not be found
	 */
	@Override
	public Enemy fetchByPrimaryKey(long enemyId) {
		return fetchByPrimaryKey((Serializable)enemyId);
	}

	/**
	 * Returns all the enemies.
	 *
	 * @return the enemies
	 */
	@Override
	public List<Enemy> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enemies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @return the range of enemies
	 */
	@Override
	public List<Enemy> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the enemies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of enemies
	 */
	@Override
	public List<Enemy> findAll(
		int start, int end, OrderByComparator<Enemy> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the enemies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EnemyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of enemies
	 * @param end the upper bound of the range of enemies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of enemies
	 */
	@Override
	public List<Enemy> findAll(
		int start, int end, OrderByComparator<Enemy> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Enemy> list = null;

		if (useFinderCache) {
			list = (List<Enemy>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ENEMY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ENEMY;

				sql = sql.concat(EnemyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Enemy>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the enemies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Enemy enemy : findAll()) {
			remove(enemy);
		}
	}

	/**
	 * Returns the number of enemies.
	 *
	 * @return the number of enemies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ENEMY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "enemyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ENEMY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EnemyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the enemy persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindByEnemyName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEnemyName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"enemyName"}, true);

		_finderPathWithoutPaginationFindByEnemyName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEnemyName",
			new String[] {String.class.getName()}, new String[] {"enemyName"},
			true);

		_finderPathCountByEnemyName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEnemyName",
			new String[] {String.class.getName()}, new String[] {"enemyName"},
			false);

		_setEnemyUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEnemyUtilPersistence(null);

		entityCache.removeCache(EnemyImpl.class.getName());
	}

	private void _setEnemyUtilPersistence(EnemyPersistence enemyPersistence) {
		try {
			Field field = EnemyUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, enemyPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = ReactGamePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ReactGamePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ReactGamePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ENEMY =
		"SELECT enemy FROM Enemy enemy";

	private static final String _SQL_SELECT_ENEMY_WHERE =
		"SELECT enemy FROM Enemy enemy WHERE ";

	private static final String _SQL_COUNT_ENEMY =
		"SELECT COUNT(enemy) FROM Enemy enemy";

	private static final String _SQL_COUNT_ENEMY_WHERE =
		"SELECT COUNT(enemy) FROM Enemy enemy WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "enemy.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Enemy exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Enemy exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EnemyPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private EnemyModelArgumentsResolver _enemyModelArgumentsResolver;

}
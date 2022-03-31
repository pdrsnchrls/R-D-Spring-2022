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
import com.liferay.react.game.core.service.exception.NoSuchPlayerEnemyAbilityException;
import com.liferay.react.game.core.service.model.PlayerEnemyAbility;
import com.liferay.react.game.core.service.model.PlayerEnemyAbilityTable;
import com.liferay.react.game.core.service.model.impl.PlayerEnemyAbilityImpl;
import com.liferay.react.game.core.service.model.impl.PlayerEnemyAbilityModelImpl;
import com.liferay.react.game.core.service.service.persistence.PlayerEnemyAbilityPersistence;
import com.liferay.react.game.core.service.service.persistence.PlayerEnemyAbilityUtil;
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
 * The persistence implementation for the player enemy ability service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {PlayerEnemyAbilityPersistence.class, BasePersistence.class}
)
public class PlayerEnemyAbilityPersistenceImpl
	extends BasePersistenceImpl<PlayerEnemyAbility>
	implements PlayerEnemyAbilityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PlayerEnemyAbilityUtil</code> to access the player enemy ability persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PlayerEnemyAbilityImpl.class.getName();

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
	 * Returns all the player enemy abilities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching player enemy abilities
	 */
	@Override
	public List<PlayerEnemyAbility> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the player enemy abilities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @return the range of matching player enemy abilities
	 */
	@Override
	public List<PlayerEnemyAbility> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the player enemy abilities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching player enemy abilities
	 */
	@Override
	public List<PlayerEnemyAbility> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PlayerEnemyAbility> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the player enemy abilities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching player enemy abilities
	 */
	@Override
	public List<PlayerEnemyAbility> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PlayerEnemyAbility> orderByComparator,
		boolean useFinderCache) {

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

		List<PlayerEnemyAbility> list = null;

		if (useFinderCache) {
			list = (List<PlayerEnemyAbility>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PlayerEnemyAbility playerEnemyAbility : list) {
					if (!uuid.equals(playerEnemyAbility.getUuid())) {
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

			sb.append(_SQL_SELECT_PLAYERENEMYABILITY_WHERE);

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
				sb.append(PlayerEnemyAbilityModelImpl.ORDER_BY_JPQL);
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

				list = (List<PlayerEnemyAbility>)QueryUtil.list(
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
	 * Returns the first player enemy ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a matching player enemy ability could not be found
	 */
	@Override
	public PlayerEnemyAbility findByUuid_First(
			String uuid,
			OrderByComparator<PlayerEnemyAbility> orderByComparator)
		throws NoSuchPlayerEnemyAbilityException {

		PlayerEnemyAbility playerEnemyAbility = fetchByUuid_First(
			uuid, orderByComparator);

		if (playerEnemyAbility != null) {
			return playerEnemyAbility;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPlayerEnemyAbilityException(sb.toString());
	}

	/**
	 * Returns the first player enemy ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching player enemy ability, or <code>null</code> if a matching player enemy ability could not be found
	 */
	@Override
	public PlayerEnemyAbility fetchByUuid_First(
		String uuid, OrderByComparator<PlayerEnemyAbility> orderByComparator) {

		List<PlayerEnemyAbility> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last player enemy ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a matching player enemy ability could not be found
	 */
	@Override
	public PlayerEnemyAbility findByUuid_Last(
			String uuid,
			OrderByComparator<PlayerEnemyAbility> orderByComparator)
		throws NoSuchPlayerEnemyAbilityException {

		PlayerEnemyAbility playerEnemyAbility = fetchByUuid_Last(
			uuid, orderByComparator);

		if (playerEnemyAbility != null) {
			return playerEnemyAbility;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPlayerEnemyAbilityException(sb.toString());
	}

	/**
	 * Returns the last player enemy ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching player enemy ability, or <code>null</code> if a matching player enemy ability could not be found
	 */
	@Override
	public PlayerEnemyAbility fetchByUuid_Last(
		String uuid, OrderByComparator<PlayerEnemyAbility> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PlayerEnemyAbility> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the player enemy abilities before and after the current player enemy ability in the ordered set where uuid = &#63;.
	 *
	 * @param playerEnemyAbilityId the primary key of the current player enemy ability
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a player enemy ability with the primary key could not be found
	 */
	@Override
	public PlayerEnemyAbility[] findByUuid_PrevAndNext(
			long playerEnemyAbilityId, String uuid,
			OrderByComparator<PlayerEnemyAbility> orderByComparator)
		throws NoSuchPlayerEnemyAbilityException {

		uuid = Objects.toString(uuid, "");

		PlayerEnemyAbility playerEnemyAbility = findByPrimaryKey(
			playerEnemyAbilityId);

		Session session = null;

		try {
			session = openSession();

			PlayerEnemyAbility[] array = new PlayerEnemyAbilityImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, playerEnemyAbility, uuid, orderByComparator, true);

			array[1] = playerEnemyAbility;

			array[2] = getByUuid_PrevAndNext(
				session, playerEnemyAbility, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PlayerEnemyAbility getByUuid_PrevAndNext(
		Session session, PlayerEnemyAbility playerEnemyAbility, String uuid,
		OrderByComparator<PlayerEnemyAbility> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLAYERENEMYABILITY_WHERE);

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
			sb.append(PlayerEnemyAbilityModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						playerEnemyAbility)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PlayerEnemyAbility> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the player enemy abilities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PlayerEnemyAbility playerEnemyAbility :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(playerEnemyAbility);
		}
	}

	/**
	 * Returns the number of player enemy abilities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching player enemy abilities
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLAYERENEMYABILITY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"playerEnemyAbility.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(playerEnemyAbility.uuid IS NULL OR playerEnemyAbility.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByPlayerOrEnemyId;
	private FinderPath _finderPathWithoutPaginationFindByPlayerOrEnemyId;
	private FinderPath _finderPathCountByPlayerOrEnemyId;

	/**
	 * Returns all the player enemy abilities where playerOrEnemyId = &#63;.
	 *
	 * @param playerOrEnemyId the player or enemy ID
	 * @return the matching player enemy abilities
	 */
	@Override
	public List<PlayerEnemyAbility> findByPlayerOrEnemyId(
		long playerOrEnemyId) {

		return findByPlayerOrEnemyId(
			playerOrEnemyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the player enemy abilities where playerOrEnemyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param playerOrEnemyId the player or enemy ID
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @return the range of matching player enemy abilities
	 */
	@Override
	public List<PlayerEnemyAbility> findByPlayerOrEnemyId(
		long playerOrEnemyId, int start, int end) {

		return findByPlayerOrEnemyId(playerOrEnemyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the player enemy abilities where playerOrEnemyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param playerOrEnemyId the player or enemy ID
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching player enemy abilities
	 */
	@Override
	public List<PlayerEnemyAbility> findByPlayerOrEnemyId(
		long playerOrEnemyId, int start, int end,
		OrderByComparator<PlayerEnemyAbility> orderByComparator) {

		return findByPlayerOrEnemyId(
			playerOrEnemyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the player enemy abilities where playerOrEnemyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param playerOrEnemyId the player or enemy ID
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching player enemy abilities
	 */
	@Override
	public List<PlayerEnemyAbility> findByPlayerOrEnemyId(
		long playerOrEnemyId, int start, int end,
		OrderByComparator<PlayerEnemyAbility> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPlayerOrEnemyId;
				finderArgs = new Object[] {playerOrEnemyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPlayerOrEnemyId;
			finderArgs = new Object[] {
				playerOrEnemyId, start, end, orderByComparator
			};
		}

		List<PlayerEnemyAbility> list = null;

		if (useFinderCache) {
			list = (List<PlayerEnemyAbility>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PlayerEnemyAbility playerEnemyAbility : list) {
					if (playerOrEnemyId !=
							playerEnemyAbility.getPlayerOrEnemyId()) {

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

			sb.append(_SQL_SELECT_PLAYERENEMYABILITY_WHERE);

			sb.append(_FINDER_COLUMN_PLAYERORENEMYID_PLAYERORENEMYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PlayerEnemyAbilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(playerOrEnemyId);

				list = (List<PlayerEnemyAbility>)QueryUtil.list(
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
	 * Returns the first player enemy ability in the ordered set where playerOrEnemyId = &#63;.
	 *
	 * @param playerOrEnemyId the player or enemy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a matching player enemy ability could not be found
	 */
	@Override
	public PlayerEnemyAbility findByPlayerOrEnemyId_First(
			long playerOrEnemyId,
			OrderByComparator<PlayerEnemyAbility> orderByComparator)
		throws NoSuchPlayerEnemyAbilityException {

		PlayerEnemyAbility playerEnemyAbility = fetchByPlayerOrEnemyId_First(
			playerOrEnemyId, orderByComparator);

		if (playerEnemyAbility != null) {
			return playerEnemyAbility;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("playerOrEnemyId=");
		sb.append(playerOrEnemyId);

		sb.append("}");

		throw new NoSuchPlayerEnemyAbilityException(sb.toString());
	}

	/**
	 * Returns the first player enemy ability in the ordered set where playerOrEnemyId = &#63;.
	 *
	 * @param playerOrEnemyId the player or enemy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching player enemy ability, or <code>null</code> if a matching player enemy ability could not be found
	 */
	@Override
	public PlayerEnemyAbility fetchByPlayerOrEnemyId_First(
		long playerOrEnemyId,
		OrderByComparator<PlayerEnemyAbility> orderByComparator) {

		List<PlayerEnemyAbility> list = findByPlayerOrEnemyId(
			playerOrEnemyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last player enemy ability in the ordered set where playerOrEnemyId = &#63;.
	 *
	 * @param playerOrEnemyId the player or enemy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a matching player enemy ability could not be found
	 */
	@Override
	public PlayerEnemyAbility findByPlayerOrEnemyId_Last(
			long playerOrEnemyId,
			OrderByComparator<PlayerEnemyAbility> orderByComparator)
		throws NoSuchPlayerEnemyAbilityException {

		PlayerEnemyAbility playerEnemyAbility = fetchByPlayerOrEnemyId_Last(
			playerOrEnemyId, orderByComparator);

		if (playerEnemyAbility != null) {
			return playerEnemyAbility;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("playerOrEnemyId=");
		sb.append(playerOrEnemyId);

		sb.append("}");

		throw new NoSuchPlayerEnemyAbilityException(sb.toString());
	}

	/**
	 * Returns the last player enemy ability in the ordered set where playerOrEnemyId = &#63;.
	 *
	 * @param playerOrEnemyId the player or enemy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching player enemy ability, or <code>null</code> if a matching player enemy ability could not be found
	 */
	@Override
	public PlayerEnemyAbility fetchByPlayerOrEnemyId_Last(
		long playerOrEnemyId,
		OrderByComparator<PlayerEnemyAbility> orderByComparator) {

		int count = countByPlayerOrEnemyId(playerOrEnemyId);

		if (count == 0) {
			return null;
		}

		List<PlayerEnemyAbility> list = findByPlayerOrEnemyId(
			playerOrEnemyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the player enemy abilities before and after the current player enemy ability in the ordered set where playerOrEnemyId = &#63;.
	 *
	 * @param playerEnemyAbilityId the primary key of the current player enemy ability
	 * @param playerOrEnemyId the player or enemy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a player enemy ability with the primary key could not be found
	 */
	@Override
	public PlayerEnemyAbility[] findByPlayerOrEnemyId_PrevAndNext(
			long playerEnemyAbilityId, long playerOrEnemyId,
			OrderByComparator<PlayerEnemyAbility> orderByComparator)
		throws NoSuchPlayerEnemyAbilityException {

		PlayerEnemyAbility playerEnemyAbility = findByPrimaryKey(
			playerEnemyAbilityId);

		Session session = null;

		try {
			session = openSession();

			PlayerEnemyAbility[] array = new PlayerEnemyAbilityImpl[3];

			array[0] = getByPlayerOrEnemyId_PrevAndNext(
				session, playerEnemyAbility, playerOrEnemyId, orderByComparator,
				true);

			array[1] = playerEnemyAbility;

			array[2] = getByPlayerOrEnemyId_PrevAndNext(
				session, playerEnemyAbility, playerOrEnemyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PlayerEnemyAbility getByPlayerOrEnemyId_PrevAndNext(
		Session session, PlayerEnemyAbility playerEnemyAbility,
		long playerOrEnemyId,
		OrderByComparator<PlayerEnemyAbility> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLAYERENEMYABILITY_WHERE);

		sb.append(_FINDER_COLUMN_PLAYERORENEMYID_PLAYERORENEMYID_2);

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
			sb.append(PlayerEnemyAbilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(playerOrEnemyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						playerEnemyAbility)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PlayerEnemyAbility> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the player enemy abilities where playerOrEnemyId = &#63; from the database.
	 *
	 * @param playerOrEnemyId the player or enemy ID
	 */
	@Override
	public void removeByPlayerOrEnemyId(long playerOrEnemyId) {
		for (PlayerEnemyAbility playerEnemyAbility :
				findByPlayerOrEnemyId(
					playerOrEnemyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(playerEnemyAbility);
		}
	}

	/**
	 * Returns the number of player enemy abilities where playerOrEnemyId = &#63;.
	 *
	 * @param playerOrEnemyId the player or enemy ID
	 * @return the number of matching player enemy abilities
	 */
	@Override
	public int countByPlayerOrEnemyId(long playerOrEnemyId) {
		FinderPath finderPath = _finderPathCountByPlayerOrEnemyId;

		Object[] finderArgs = new Object[] {playerOrEnemyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLAYERENEMYABILITY_WHERE);

			sb.append(_FINDER_COLUMN_PLAYERORENEMYID_PLAYERORENEMYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(playerOrEnemyId);

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

	private static final String
		_FINDER_COLUMN_PLAYERORENEMYID_PLAYERORENEMYID_2 =
			"playerEnemyAbility.playerOrEnemyId = ?";

	public PlayerEnemyAbilityPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PlayerEnemyAbility.class);

		setModelImplClass(PlayerEnemyAbilityImpl.class);
		setModelPKClass(long.class);

		setTable(PlayerEnemyAbilityTable.INSTANCE);
	}

	/**
	 * Caches the player enemy ability in the entity cache if it is enabled.
	 *
	 * @param playerEnemyAbility the player enemy ability
	 */
	@Override
	public void cacheResult(PlayerEnemyAbility playerEnemyAbility) {
		entityCache.putResult(
			PlayerEnemyAbilityImpl.class, playerEnemyAbility.getPrimaryKey(),
			playerEnemyAbility);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the player enemy abilities in the entity cache if it is enabled.
	 *
	 * @param playerEnemyAbilities the player enemy abilities
	 */
	@Override
	public void cacheResult(List<PlayerEnemyAbility> playerEnemyAbilities) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (playerEnemyAbilities.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PlayerEnemyAbility playerEnemyAbility : playerEnemyAbilities) {
			if (entityCache.getResult(
					PlayerEnemyAbilityImpl.class,
					playerEnemyAbility.getPrimaryKey()) == null) {

				cacheResult(playerEnemyAbility);
			}
		}
	}

	/**
	 * Clears the cache for all player enemy abilities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PlayerEnemyAbilityImpl.class);

		finderCache.clearCache(PlayerEnemyAbilityImpl.class);
	}

	/**
	 * Clears the cache for the player enemy ability.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PlayerEnemyAbility playerEnemyAbility) {
		entityCache.removeResult(
			PlayerEnemyAbilityImpl.class, playerEnemyAbility);
	}

	@Override
	public void clearCache(List<PlayerEnemyAbility> playerEnemyAbilities) {
		for (PlayerEnemyAbility playerEnemyAbility : playerEnemyAbilities) {
			entityCache.removeResult(
				PlayerEnemyAbilityImpl.class, playerEnemyAbility);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PlayerEnemyAbilityImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PlayerEnemyAbilityImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new player enemy ability with the primary key. Does not add the player enemy ability to the database.
	 *
	 * @param playerEnemyAbilityId the primary key for the new player enemy ability
	 * @return the new player enemy ability
	 */
	@Override
	public PlayerEnemyAbility create(long playerEnemyAbilityId) {
		PlayerEnemyAbility playerEnemyAbility = new PlayerEnemyAbilityImpl();

		playerEnemyAbility.setNew(true);
		playerEnemyAbility.setPrimaryKey(playerEnemyAbilityId);

		String uuid = PortalUUIDUtil.generate();

		playerEnemyAbility.setUuid(uuid);

		return playerEnemyAbility;
	}

	/**
	 * Removes the player enemy ability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param playerEnemyAbilityId the primary key of the player enemy ability
	 * @return the player enemy ability that was removed
	 * @throws NoSuchPlayerEnemyAbilityException if a player enemy ability with the primary key could not be found
	 */
	@Override
	public PlayerEnemyAbility remove(long playerEnemyAbilityId)
		throws NoSuchPlayerEnemyAbilityException {

		return remove((Serializable)playerEnemyAbilityId);
	}

	/**
	 * Removes the player enemy ability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the player enemy ability
	 * @return the player enemy ability that was removed
	 * @throws NoSuchPlayerEnemyAbilityException if a player enemy ability with the primary key could not be found
	 */
	@Override
	public PlayerEnemyAbility remove(Serializable primaryKey)
		throws NoSuchPlayerEnemyAbilityException {

		Session session = null;

		try {
			session = openSession();

			PlayerEnemyAbility playerEnemyAbility =
				(PlayerEnemyAbility)session.get(
					PlayerEnemyAbilityImpl.class, primaryKey);

			if (playerEnemyAbility == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPlayerEnemyAbilityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(playerEnemyAbility);
		}
		catch (NoSuchPlayerEnemyAbilityException noSuchEntityException) {
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
	protected PlayerEnemyAbility removeImpl(
		PlayerEnemyAbility playerEnemyAbility) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(playerEnemyAbility)) {
				playerEnemyAbility = (PlayerEnemyAbility)session.get(
					PlayerEnemyAbilityImpl.class,
					playerEnemyAbility.getPrimaryKeyObj());
			}

			if (playerEnemyAbility != null) {
				session.delete(playerEnemyAbility);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (playerEnemyAbility != null) {
			clearCache(playerEnemyAbility);
		}

		return playerEnemyAbility;
	}

	@Override
	public PlayerEnemyAbility updateImpl(
		PlayerEnemyAbility playerEnemyAbility) {

		boolean isNew = playerEnemyAbility.isNew();

		if (!(playerEnemyAbility instanceof PlayerEnemyAbilityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(playerEnemyAbility.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					playerEnemyAbility);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in playerEnemyAbility proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PlayerEnemyAbility implementation " +
					playerEnemyAbility.getClass());
		}

		PlayerEnemyAbilityModelImpl playerEnemyAbilityModelImpl =
			(PlayerEnemyAbilityModelImpl)playerEnemyAbility;

		if (Validator.isNull(playerEnemyAbility.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			playerEnemyAbility.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(playerEnemyAbility);
			}
			else {
				playerEnemyAbility = (PlayerEnemyAbility)session.merge(
					playerEnemyAbility);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PlayerEnemyAbilityImpl.class, playerEnemyAbilityModelImpl, false,
			true);

		if (isNew) {
			playerEnemyAbility.setNew(false);
		}

		playerEnemyAbility.resetOriginalValues();

		return playerEnemyAbility;
	}

	/**
	 * Returns the player enemy ability with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the player enemy ability
	 * @return the player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a player enemy ability with the primary key could not be found
	 */
	@Override
	public PlayerEnemyAbility findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPlayerEnemyAbilityException {

		PlayerEnemyAbility playerEnemyAbility = fetchByPrimaryKey(primaryKey);

		if (playerEnemyAbility == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPlayerEnemyAbilityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return playerEnemyAbility;
	}

	/**
	 * Returns the player enemy ability with the primary key or throws a <code>NoSuchPlayerEnemyAbilityException</code> if it could not be found.
	 *
	 * @param playerEnemyAbilityId the primary key of the player enemy ability
	 * @return the player enemy ability
	 * @throws NoSuchPlayerEnemyAbilityException if a player enemy ability with the primary key could not be found
	 */
	@Override
	public PlayerEnemyAbility findByPrimaryKey(long playerEnemyAbilityId)
		throws NoSuchPlayerEnemyAbilityException {

		return findByPrimaryKey((Serializable)playerEnemyAbilityId);
	}

	/**
	 * Returns the player enemy ability with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param playerEnemyAbilityId the primary key of the player enemy ability
	 * @return the player enemy ability, or <code>null</code> if a player enemy ability with the primary key could not be found
	 */
	@Override
	public PlayerEnemyAbility fetchByPrimaryKey(long playerEnemyAbilityId) {
		return fetchByPrimaryKey((Serializable)playerEnemyAbilityId);
	}

	/**
	 * Returns all the player enemy abilities.
	 *
	 * @return the player enemy abilities
	 */
	@Override
	public List<PlayerEnemyAbility> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the player enemy abilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @return the range of player enemy abilities
	 */
	@Override
	public List<PlayerEnemyAbility> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the player enemy abilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of player enemy abilities
	 */
	@Override
	public List<PlayerEnemyAbility> findAll(
		int start, int end,
		OrderByComparator<PlayerEnemyAbility> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the player enemy abilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerEnemyAbilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of player enemy abilities
	 * @param end the upper bound of the range of player enemy abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of player enemy abilities
	 */
	@Override
	public List<PlayerEnemyAbility> findAll(
		int start, int end,
		OrderByComparator<PlayerEnemyAbility> orderByComparator,
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

		List<PlayerEnemyAbility> list = null;

		if (useFinderCache) {
			list = (List<PlayerEnemyAbility>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PLAYERENEMYABILITY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PLAYERENEMYABILITY;

				sql = sql.concat(PlayerEnemyAbilityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PlayerEnemyAbility>)QueryUtil.list(
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
	 * Removes all the player enemy abilities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PlayerEnemyAbility playerEnemyAbility : findAll()) {
			remove(playerEnemyAbility);
		}
	}

	/**
	 * Returns the number of player enemy abilities.
	 *
	 * @return the number of player enemy abilities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_PLAYERENEMYABILITY);

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
		return "playerEnemyAbilityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PLAYERENEMYABILITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PlayerEnemyAbilityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the player enemy ability persistence.
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

		_finderPathWithPaginationFindByPlayerOrEnemyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPlayerOrEnemyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"playerOrEnemyId"}, true);

		_finderPathWithoutPaginationFindByPlayerOrEnemyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPlayerOrEnemyId",
			new String[] {Long.class.getName()},
			new String[] {"playerOrEnemyId"}, true);

		_finderPathCountByPlayerOrEnemyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPlayerOrEnemyId",
			new String[] {Long.class.getName()},
			new String[] {"playerOrEnemyId"}, false);

		_setPlayerEnemyAbilityUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPlayerEnemyAbilityUtilPersistence(null);

		entityCache.removeCache(PlayerEnemyAbilityImpl.class.getName());
	}

	private void _setPlayerEnemyAbilityUtilPersistence(
		PlayerEnemyAbilityPersistence playerEnemyAbilityPersistence) {

		try {
			Field field = PlayerEnemyAbilityUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, playerEnemyAbilityPersistence);
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

	private static final String _SQL_SELECT_PLAYERENEMYABILITY =
		"SELECT playerEnemyAbility FROM PlayerEnemyAbility playerEnemyAbility";

	private static final String _SQL_SELECT_PLAYERENEMYABILITY_WHERE =
		"SELECT playerEnemyAbility FROM PlayerEnemyAbility playerEnemyAbility WHERE ";

	private static final String _SQL_COUNT_PLAYERENEMYABILITY =
		"SELECT COUNT(playerEnemyAbility) FROM PlayerEnemyAbility playerEnemyAbility";

	private static final String _SQL_COUNT_PLAYERENEMYABILITY_WHERE =
		"SELECT COUNT(playerEnemyAbility) FROM PlayerEnemyAbility playerEnemyAbility WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "playerEnemyAbility.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PlayerEnemyAbility exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PlayerEnemyAbility exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PlayerEnemyAbilityPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PlayerEnemyAbilityModelArgumentsResolver
		_playerEnemyAbilityModelArgumentsResolver;

}
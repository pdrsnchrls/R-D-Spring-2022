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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.react.game.core.service.exception.NoSuchPlayerException;
import com.liferay.react.game.core.service.model.Player;
import com.liferay.react.game.core.service.model.PlayerTable;
import com.liferay.react.game.core.service.model.impl.PlayerImpl;
import com.liferay.react.game.core.service.model.impl.PlayerModelImpl;
import com.liferay.react.game.core.service.service.persistence.PlayerPersistence;
import com.liferay.react.game.core.service.service.persistence.PlayerUtil;
import com.liferay.react.game.core.service.service.persistence.impl.constants.ReactGamePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the player service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {PlayerPersistence.class, BasePersistence.class})
public class PlayerPersistenceImpl
	extends BasePersistenceImpl<Player> implements PlayerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PlayerUtil</code> to access the player persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PlayerImpl.class.getName();

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
	 * Returns all the players where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching players
	 */
	@Override
	public List<Player> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the players where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of players
	 * @param end the upper bound of the range of players (not inclusive)
	 * @return the range of matching players
	 */
	@Override
	public List<Player> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the players where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of players
	 * @param end the upper bound of the range of players (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching players
	 */
	@Override
	public List<Player> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Player> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the players where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of players
	 * @param end the upper bound of the range of players (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching players
	 */
	@Override
	public List<Player> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Player> orderByComparator, boolean useFinderCache) {

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

		List<Player> list = null;

		if (useFinderCache) {
			list = (List<Player>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Player player : list) {
					if (!uuid.equals(player.getUuid())) {
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

			sb.append(_SQL_SELECT_PLAYER_WHERE);

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
				sb.append(PlayerModelImpl.ORDER_BY_JPQL);
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

				list = (List<Player>)QueryUtil.list(
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
	 * Returns the first player in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching player
	 * @throws NoSuchPlayerException if a matching player could not be found
	 */
	@Override
	public Player findByUuid_First(
			String uuid, OrderByComparator<Player> orderByComparator)
		throws NoSuchPlayerException {

		Player player = fetchByUuid_First(uuid, orderByComparator);

		if (player != null) {
			return player;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPlayerException(sb.toString());
	}

	/**
	 * Returns the first player in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching player, or <code>null</code> if a matching player could not be found
	 */
	@Override
	public Player fetchByUuid_First(
		String uuid, OrderByComparator<Player> orderByComparator) {

		List<Player> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last player in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching player
	 * @throws NoSuchPlayerException if a matching player could not be found
	 */
	@Override
	public Player findByUuid_Last(
			String uuid, OrderByComparator<Player> orderByComparator)
		throws NoSuchPlayerException {

		Player player = fetchByUuid_Last(uuid, orderByComparator);

		if (player != null) {
			return player;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPlayerException(sb.toString());
	}

	/**
	 * Returns the last player in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching player, or <code>null</code> if a matching player could not be found
	 */
	@Override
	public Player fetchByUuid_Last(
		String uuid, OrderByComparator<Player> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Player> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the players before and after the current player in the ordered set where uuid = &#63;.
	 *
	 * @param playerId the primary key of the current player
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next player
	 * @throws NoSuchPlayerException if a player with the primary key could not be found
	 */
	@Override
	public Player[] findByUuid_PrevAndNext(
			long playerId, String uuid,
			OrderByComparator<Player> orderByComparator)
		throws NoSuchPlayerException {

		uuid = Objects.toString(uuid, "");

		Player player = findByPrimaryKey(playerId);

		Session session = null;

		try {
			session = openSession();

			Player[] array = new PlayerImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, player, uuid, orderByComparator, true);

			array[1] = player;

			array[2] = getByUuid_PrevAndNext(
				session, player, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Player getByUuid_PrevAndNext(
		Session session, Player player, String uuid,
		OrderByComparator<Player> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLAYER_WHERE);

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
			sb.append(PlayerModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(player)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Player> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the players where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Player player :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(player);
		}
	}

	/**
	 * Returns the number of players where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching players
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLAYER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "player.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(player.uuid IS NULL OR player.uuid = '')";

	private FinderPath _finderPathFetchByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns the player where userId = &#63; or throws a <code>NoSuchPlayerException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching player
	 * @throws NoSuchPlayerException if a matching player could not be found
	 */
	@Override
	public Player findByUserId(long userId) throws NoSuchPlayerException {
		Player player = fetchByUserId(userId);

		if (player == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPlayerException(sb.toString());
		}

		return player;
	}

	/**
	 * Returns the player where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching player, or <code>null</code> if a matching player could not be found
	 */
	@Override
	public Player fetchByUserId(long userId) {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the player where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching player, or <code>null</code> if a matching player could not be found
	 */
	@Override
	public Player fetchByUserId(long userId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUserId, finderArgs);
		}

		if (result instanceof Player) {
			Player player = (Player)result;

			if (userId != player.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PLAYER_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<Player> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUserId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userId};
							}

							_log.warn(
								"PlayerPersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Player player = list.get(0);

					result = player;

					cacheResult(player);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Player)result;
		}
	}

	/**
	 * Removes the player where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the player that was removed
	 */
	@Override
	public Player removeByUserId(long userId) throws NoSuchPlayerException {
		Player player = findByUserId(userId);

		return remove(player);
	}

	/**
	 * Returns the number of players where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching players
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLAYER_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"player.userId = ?";

	public PlayerPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Player.class);

		setModelImplClass(PlayerImpl.class);
		setModelPKClass(long.class);

		setTable(PlayerTable.INSTANCE);
	}

	/**
	 * Caches the player in the entity cache if it is enabled.
	 *
	 * @param player the player
	 */
	@Override
	public void cacheResult(Player player) {
		entityCache.putResult(PlayerImpl.class, player.getPrimaryKey(), player);

		finderCache.putResult(
			_finderPathFetchByUserId, new Object[] {player.getUserId()},
			player);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the players in the entity cache if it is enabled.
	 *
	 * @param players the players
	 */
	@Override
	public void cacheResult(List<Player> players) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (players.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Player player : players) {
			if (entityCache.getResult(
					PlayerImpl.class, player.getPrimaryKey()) == null) {

				cacheResult(player);
			}
		}
	}

	/**
	 * Clears the cache for all players.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PlayerImpl.class);

		finderCache.clearCache(PlayerImpl.class);
	}

	/**
	 * Clears the cache for the player.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Player player) {
		entityCache.removeResult(PlayerImpl.class, player);
	}

	@Override
	public void clearCache(List<Player> players) {
		for (Player player : players) {
			entityCache.removeResult(PlayerImpl.class, player);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PlayerImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PlayerImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(PlayerModelImpl playerModelImpl) {
		Object[] args = new Object[] {playerModelImpl.getUserId()};

		finderCache.putResult(_finderPathCountByUserId, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUserId, args, playerModelImpl);
	}

	/**
	 * Creates a new player with the primary key. Does not add the player to the database.
	 *
	 * @param playerId the primary key for the new player
	 * @return the new player
	 */
	@Override
	public Player create(long playerId) {
		Player player = new PlayerImpl();

		player.setNew(true);
		player.setPrimaryKey(playerId);

		String uuid = PortalUUIDUtil.generate();

		player.setUuid(uuid);

		return player;
	}

	/**
	 * Removes the player with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param playerId the primary key of the player
	 * @return the player that was removed
	 * @throws NoSuchPlayerException if a player with the primary key could not be found
	 */
	@Override
	public Player remove(long playerId) throws NoSuchPlayerException {
		return remove((Serializable)playerId);
	}

	/**
	 * Removes the player with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the player
	 * @return the player that was removed
	 * @throws NoSuchPlayerException if a player with the primary key could not be found
	 */
	@Override
	public Player remove(Serializable primaryKey) throws NoSuchPlayerException {
		Session session = null;

		try {
			session = openSession();

			Player player = (Player)session.get(PlayerImpl.class, primaryKey);

			if (player == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPlayerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(player);
		}
		catch (NoSuchPlayerException noSuchEntityException) {
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
	protected Player removeImpl(Player player) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(player)) {
				player = (Player)session.get(
					PlayerImpl.class, player.getPrimaryKeyObj());
			}

			if (player != null) {
				session.delete(player);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (player != null) {
			clearCache(player);
		}

		return player;
	}

	@Override
	public Player updateImpl(Player player) {
		boolean isNew = player.isNew();

		if (!(player instanceof PlayerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(player.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(player);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in player proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Player implementation " +
					player.getClass());
		}

		PlayerModelImpl playerModelImpl = (PlayerModelImpl)player;

		if (Validator.isNull(player.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			player.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(player);
			}
			else {
				player = (Player)session.merge(player);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PlayerImpl.class, playerModelImpl, false, true);

		cacheUniqueFindersCache(playerModelImpl);

		if (isNew) {
			player.setNew(false);
		}

		player.resetOriginalValues();

		return player;
	}

	/**
	 * Returns the player with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the player
	 * @return the player
	 * @throws NoSuchPlayerException if a player with the primary key could not be found
	 */
	@Override
	public Player findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPlayerException {

		Player player = fetchByPrimaryKey(primaryKey);

		if (player == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPlayerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return player;
	}

	/**
	 * Returns the player with the primary key or throws a <code>NoSuchPlayerException</code> if it could not be found.
	 *
	 * @param playerId the primary key of the player
	 * @return the player
	 * @throws NoSuchPlayerException if a player with the primary key could not be found
	 */
	@Override
	public Player findByPrimaryKey(long playerId) throws NoSuchPlayerException {
		return findByPrimaryKey((Serializable)playerId);
	}

	/**
	 * Returns the player with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param playerId the primary key of the player
	 * @return the player, or <code>null</code> if a player with the primary key could not be found
	 */
	@Override
	public Player fetchByPrimaryKey(long playerId) {
		return fetchByPrimaryKey((Serializable)playerId);
	}

	/**
	 * Returns all the players.
	 *
	 * @return the players
	 */
	@Override
	public List<Player> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the players.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of players
	 * @param end the upper bound of the range of players (not inclusive)
	 * @return the range of players
	 */
	@Override
	public List<Player> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the players.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of players
	 * @param end the upper bound of the range of players (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of players
	 */
	@Override
	public List<Player> findAll(
		int start, int end, OrderByComparator<Player> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the players.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlayerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of players
	 * @param end the upper bound of the range of players (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of players
	 */
	@Override
	public List<Player> findAll(
		int start, int end, OrderByComparator<Player> orderByComparator,
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

		List<Player> list = null;

		if (useFinderCache) {
			list = (List<Player>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PLAYER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PLAYER;

				sql = sql.concat(PlayerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Player>)QueryUtil.list(
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
	 * Removes all the players from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Player player : findAll()) {
			remove(player);
		}
	}

	/**
	 * Returns the number of players.
	 *
	 * @return the number of players
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PLAYER);

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
		return "playerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PLAYER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PlayerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the player persistence.
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

		_finderPathFetchByUserId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_setPlayerUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPlayerUtilPersistence(null);

		entityCache.removeCache(PlayerImpl.class.getName());
	}

	private void _setPlayerUtilPersistence(
		PlayerPersistence playerPersistence) {

		try {
			Field field = PlayerUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, playerPersistence);
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

	private static final String _SQL_SELECT_PLAYER =
		"SELECT player FROM Player player";

	private static final String _SQL_SELECT_PLAYER_WHERE =
		"SELECT player FROM Player player WHERE ";

	private static final String _SQL_COUNT_PLAYER =
		"SELECT COUNT(player) FROM Player player";

	private static final String _SQL_COUNT_PLAYER_WHERE =
		"SELECT COUNT(player) FROM Player player WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "player.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Player exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Player exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PlayerPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PlayerModelArgumentsResolver _playerModelArgumentsResolver;

}
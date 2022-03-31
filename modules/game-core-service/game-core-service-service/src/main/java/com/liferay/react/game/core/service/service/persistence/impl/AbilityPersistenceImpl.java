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
import com.liferay.react.game.core.service.exception.NoSuchAbilityException;
import com.liferay.react.game.core.service.model.Ability;
import com.liferay.react.game.core.service.model.AbilityTable;
import com.liferay.react.game.core.service.model.impl.AbilityImpl;
import com.liferay.react.game.core.service.model.impl.AbilityModelImpl;
import com.liferay.react.game.core.service.service.persistence.AbilityPersistence;
import com.liferay.react.game.core.service.service.persistence.AbilityUtil;
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
 * The persistence implementation for the ability service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {AbilityPersistence.class, BasePersistence.class})
public class AbilityPersistenceImpl
	extends BasePersistenceImpl<Ability> implements AbilityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AbilityUtil</code> to access the ability persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AbilityImpl.class.getName();

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
	 * Returns all the abilities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching abilities
	 */
	@Override
	public List<Ability> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the abilities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @return the range of matching abilities
	 */
	@Override
	public List<Ability> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the abilities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching abilities
	 */
	@Override
	public List<Ability> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Ability> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the abilities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching abilities
	 */
	@Override
	public List<Ability> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Ability> orderByComparator, boolean useFinderCache) {

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

		List<Ability> list = null;

		if (useFinderCache) {
			list = (List<Ability>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Ability ability : list) {
					if (!uuid.equals(ability.getUuid())) {
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

			sb.append(_SQL_SELECT_ABILITY_WHERE);

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
				sb.append(AbilityModelImpl.ORDER_BY_JPQL);
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

				list = (List<Ability>)QueryUtil.list(
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
	 * Returns the first ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ability
	 * @throws NoSuchAbilityException if a matching ability could not be found
	 */
	@Override
	public Ability findByUuid_First(
			String uuid, OrderByComparator<Ability> orderByComparator)
		throws NoSuchAbilityException {

		Ability ability = fetchByUuid_First(uuid, orderByComparator);

		if (ability != null) {
			return ability;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAbilityException(sb.toString());
	}

	/**
	 * Returns the first ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ability, or <code>null</code> if a matching ability could not be found
	 */
	@Override
	public Ability fetchByUuid_First(
		String uuid, OrderByComparator<Ability> orderByComparator) {

		List<Ability> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ability
	 * @throws NoSuchAbilityException if a matching ability could not be found
	 */
	@Override
	public Ability findByUuid_Last(
			String uuid, OrderByComparator<Ability> orderByComparator)
		throws NoSuchAbilityException {

		Ability ability = fetchByUuid_Last(uuid, orderByComparator);

		if (ability != null) {
			return ability;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAbilityException(sb.toString());
	}

	/**
	 * Returns the last ability in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ability, or <code>null</code> if a matching ability could not be found
	 */
	@Override
	public Ability fetchByUuid_Last(
		String uuid, OrderByComparator<Ability> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Ability> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the abilities before and after the current ability in the ordered set where uuid = &#63;.
	 *
	 * @param abilityId the primary key of the current ability
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ability
	 * @throws NoSuchAbilityException if a ability with the primary key could not be found
	 */
	@Override
	public Ability[] findByUuid_PrevAndNext(
			long abilityId, String uuid,
			OrderByComparator<Ability> orderByComparator)
		throws NoSuchAbilityException {

		uuid = Objects.toString(uuid, "");

		Ability ability = findByPrimaryKey(abilityId);

		Session session = null;

		try {
			session = openSession();

			Ability[] array = new AbilityImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, ability, uuid, orderByComparator, true);

			array[1] = ability;

			array[2] = getByUuid_PrevAndNext(
				session, ability, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ability getByUuid_PrevAndNext(
		Session session, Ability ability, String uuid,
		OrderByComparator<Ability> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ABILITY_WHERE);

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
			sb.append(AbilityModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(ability)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Ability> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the abilities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Ability ability :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ability);
		}
	}

	/**
	 * Returns the number of abilities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching abilities
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ABILITY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "ability.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(ability.uuid IS NULL OR ability.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByAbilityName;
	private FinderPath _finderPathWithoutPaginationFindByAbilityName;
	private FinderPath _finderPathCountByAbilityName;

	/**
	 * Returns all the abilities where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @return the matching abilities
	 */
	@Override
	public List<Ability> findByAbilityName(String abilityName) {
		return findByAbilityName(
			abilityName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the abilities where abilityName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param abilityName the ability name
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @return the range of matching abilities
	 */
	@Override
	public List<Ability> findByAbilityName(
		String abilityName, int start, int end) {

		return findByAbilityName(abilityName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the abilities where abilityName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param abilityName the ability name
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching abilities
	 */
	@Override
	public List<Ability> findByAbilityName(
		String abilityName, int start, int end,
		OrderByComparator<Ability> orderByComparator) {

		return findByAbilityName(
			abilityName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the abilities where abilityName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param abilityName the ability name
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching abilities
	 */
	@Override
	public List<Ability> findByAbilityName(
		String abilityName, int start, int end,
		OrderByComparator<Ability> orderByComparator, boolean useFinderCache) {

		abilityName = Objects.toString(abilityName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAbilityName;
				finderArgs = new Object[] {abilityName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAbilityName;
			finderArgs = new Object[] {
				abilityName, start, end, orderByComparator
			};
		}

		List<Ability> list = null;

		if (useFinderCache) {
			list = (List<Ability>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Ability ability : list) {
					if (!abilityName.equals(ability.getAbilityName())) {
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

			sb.append(_SQL_SELECT_ABILITY_WHERE);

			boolean bindAbilityName = false;

			if (abilityName.isEmpty()) {
				sb.append(_FINDER_COLUMN_ABILITYNAME_ABILITYNAME_3);
			}
			else {
				bindAbilityName = true;

				sb.append(_FINDER_COLUMN_ABILITYNAME_ABILITYNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AbilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAbilityName) {
					queryPos.add(abilityName);
				}

				list = (List<Ability>)QueryUtil.list(
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
	 * Returns the first ability in the ordered set where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ability
	 * @throws NoSuchAbilityException if a matching ability could not be found
	 */
	@Override
	public Ability findByAbilityName_First(
			String abilityName, OrderByComparator<Ability> orderByComparator)
		throws NoSuchAbilityException {

		Ability ability = fetchByAbilityName_First(
			abilityName, orderByComparator);

		if (ability != null) {
			return ability;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("abilityName=");
		sb.append(abilityName);

		sb.append("}");

		throw new NoSuchAbilityException(sb.toString());
	}

	/**
	 * Returns the first ability in the ordered set where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ability, or <code>null</code> if a matching ability could not be found
	 */
	@Override
	public Ability fetchByAbilityName_First(
		String abilityName, OrderByComparator<Ability> orderByComparator) {

		List<Ability> list = findByAbilityName(
			abilityName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ability in the ordered set where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ability
	 * @throws NoSuchAbilityException if a matching ability could not be found
	 */
	@Override
	public Ability findByAbilityName_Last(
			String abilityName, OrderByComparator<Ability> orderByComparator)
		throws NoSuchAbilityException {

		Ability ability = fetchByAbilityName_Last(
			abilityName, orderByComparator);

		if (ability != null) {
			return ability;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("abilityName=");
		sb.append(abilityName);

		sb.append("}");

		throw new NoSuchAbilityException(sb.toString());
	}

	/**
	 * Returns the last ability in the ordered set where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ability, or <code>null</code> if a matching ability could not be found
	 */
	@Override
	public Ability fetchByAbilityName_Last(
		String abilityName, OrderByComparator<Ability> orderByComparator) {

		int count = countByAbilityName(abilityName);

		if (count == 0) {
			return null;
		}

		List<Ability> list = findByAbilityName(
			abilityName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the abilities before and after the current ability in the ordered set where abilityName = &#63;.
	 *
	 * @param abilityId the primary key of the current ability
	 * @param abilityName the ability name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ability
	 * @throws NoSuchAbilityException if a ability with the primary key could not be found
	 */
	@Override
	public Ability[] findByAbilityName_PrevAndNext(
			long abilityId, String abilityName,
			OrderByComparator<Ability> orderByComparator)
		throws NoSuchAbilityException {

		abilityName = Objects.toString(abilityName, "");

		Ability ability = findByPrimaryKey(abilityId);

		Session session = null;

		try {
			session = openSession();

			Ability[] array = new AbilityImpl[3];

			array[0] = getByAbilityName_PrevAndNext(
				session, ability, abilityName, orderByComparator, true);

			array[1] = ability;

			array[2] = getByAbilityName_PrevAndNext(
				session, ability, abilityName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ability getByAbilityName_PrevAndNext(
		Session session, Ability ability, String abilityName,
		OrderByComparator<Ability> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ABILITY_WHERE);

		boolean bindAbilityName = false;

		if (abilityName.isEmpty()) {
			sb.append(_FINDER_COLUMN_ABILITYNAME_ABILITYNAME_3);
		}
		else {
			bindAbilityName = true;

			sb.append(_FINDER_COLUMN_ABILITYNAME_ABILITYNAME_2);
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
			sb.append(AbilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindAbilityName) {
			queryPos.add(abilityName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ability)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Ability> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the abilities where abilityName = &#63; from the database.
	 *
	 * @param abilityName the ability name
	 */
	@Override
	public void removeByAbilityName(String abilityName) {
		for (Ability ability :
				findByAbilityName(
					abilityName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ability);
		}
	}

	/**
	 * Returns the number of abilities where abilityName = &#63;.
	 *
	 * @param abilityName the ability name
	 * @return the number of matching abilities
	 */
	@Override
	public int countByAbilityName(String abilityName) {
		abilityName = Objects.toString(abilityName, "");

		FinderPath finderPath = _finderPathCountByAbilityName;

		Object[] finderArgs = new Object[] {abilityName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ABILITY_WHERE);

			boolean bindAbilityName = false;

			if (abilityName.isEmpty()) {
				sb.append(_FINDER_COLUMN_ABILITYNAME_ABILITYNAME_3);
			}
			else {
				bindAbilityName = true;

				sb.append(_FINDER_COLUMN_ABILITYNAME_ABILITYNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAbilityName) {
					queryPos.add(abilityName);
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

	private static final String _FINDER_COLUMN_ABILITYNAME_ABILITYNAME_2 =
		"ability.abilityName = ?";

	private static final String _FINDER_COLUMN_ABILITYNAME_ABILITYNAME_3 =
		"(ability.abilityName IS NULL OR ability.abilityName = '')";

	public AbilityPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Ability.class);

		setModelImplClass(AbilityImpl.class);
		setModelPKClass(long.class);

		setTable(AbilityTable.INSTANCE);
	}

	/**
	 * Caches the ability in the entity cache if it is enabled.
	 *
	 * @param ability the ability
	 */
	@Override
	public void cacheResult(Ability ability) {
		entityCache.putResult(
			AbilityImpl.class, ability.getPrimaryKey(), ability);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the abilities in the entity cache if it is enabled.
	 *
	 * @param abilities the abilities
	 */
	@Override
	public void cacheResult(List<Ability> abilities) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (abilities.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Ability ability : abilities) {
			if (entityCache.getResult(
					AbilityImpl.class, ability.getPrimaryKey()) == null) {

				cacheResult(ability);
			}
		}
	}

	/**
	 * Clears the cache for all abilities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AbilityImpl.class);

		finderCache.clearCache(AbilityImpl.class);
	}

	/**
	 * Clears the cache for the ability.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Ability ability) {
		entityCache.removeResult(AbilityImpl.class, ability);
	}

	@Override
	public void clearCache(List<Ability> abilities) {
		for (Ability ability : abilities) {
			entityCache.removeResult(AbilityImpl.class, ability);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AbilityImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AbilityImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new ability with the primary key. Does not add the ability to the database.
	 *
	 * @param abilityId the primary key for the new ability
	 * @return the new ability
	 */
	@Override
	public Ability create(long abilityId) {
		Ability ability = new AbilityImpl();

		ability.setNew(true);
		ability.setPrimaryKey(abilityId);

		String uuid = PortalUUIDUtil.generate();

		ability.setUuid(uuid);

		return ability;
	}

	/**
	 * Removes the ability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param abilityId the primary key of the ability
	 * @return the ability that was removed
	 * @throws NoSuchAbilityException if a ability with the primary key could not be found
	 */
	@Override
	public Ability remove(long abilityId) throws NoSuchAbilityException {
		return remove((Serializable)abilityId);
	}

	/**
	 * Removes the ability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ability
	 * @return the ability that was removed
	 * @throws NoSuchAbilityException if a ability with the primary key could not be found
	 */
	@Override
	public Ability remove(Serializable primaryKey)
		throws NoSuchAbilityException {

		Session session = null;

		try {
			session = openSession();

			Ability ability = (Ability)session.get(
				AbilityImpl.class, primaryKey);

			if (ability == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAbilityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ability);
		}
		catch (NoSuchAbilityException noSuchEntityException) {
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
	protected Ability removeImpl(Ability ability) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ability)) {
				ability = (Ability)session.get(
					AbilityImpl.class, ability.getPrimaryKeyObj());
			}

			if (ability != null) {
				session.delete(ability);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ability != null) {
			clearCache(ability);
		}

		return ability;
	}

	@Override
	public Ability updateImpl(Ability ability) {
		boolean isNew = ability.isNew();

		if (!(ability instanceof AbilityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ability.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ability);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ability proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Ability implementation " +
					ability.getClass());
		}

		AbilityModelImpl abilityModelImpl = (AbilityModelImpl)ability;

		if (Validator.isNull(ability.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ability.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ability);
			}
			else {
				ability = (Ability)session.merge(ability);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(AbilityImpl.class, abilityModelImpl, false, true);

		if (isNew) {
			ability.setNew(false);
		}

		ability.resetOriginalValues();

		return ability;
	}

	/**
	 * Returns the ability with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ability
	 * @return the ability
	 * @throws NoSuchAbilityException if a ability with the primary key could not be found
	 */
	@Override
	public Ability findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAbilityException {

		Ability ability = fetchByPrimaryKey(primaryKey);

		if (ability == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAbilityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ability;
	}

	/**
	 * Returns the ability with the primary key or throws a <code>NoSuchAbilityException</code> if it could not be found.
	 *
	 * @param abilityId the primary key of the ability
	 * @return the ability
	 * @throws NoSuchAbilityException if a ability with the primary key could not be found
	 */
	@Override
	public Ability findByPrimaryKey(long abilityId)
		throws NoSuchAbilityException {

		return findByPrimaryKey((Serializable)abilityId);
	}

	/**
	 * Returns the ability with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param abilityId the primary key of the ability
	 * @return the ability, or <code>null</code> if a ability with the primary key could not be found
	 */
	@Override
	public Ability fetchByPrimaryKey(long abilityId) {
		return fetchByPrimaryKey((Serializable)abilityId);
	}

	/**
	 * Returns all the abilities.
	 *
	 * @return the abilities
	 */
	@Override
	public List<Ability> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the abilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @return the range of abilities
	 */
	@Override
	public List<Ability> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the abilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of abilities
	 */
	@Override
	public List<Ability> findAll(
		int start, int end, OrderByComparator<Ability> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the abilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of abilities
	 * @param end the upper bound of the range of abilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of abilities
	 */
	@Override
	public List<Ability> findAll(
		int start, int end, OrderByComparator<Ability> orderByComparator,
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

		List<Ability> list = null;

		if (useFinderCache) {
			list = (List<Ability>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ABILITY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ABILITY;

				sql = sql.concat(AbilityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Ability>)QueryUtil.list(
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
	 * Removes all the abilities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Ability ability : findAll()) {
			remove(ability);
		}
	}

	/**
	 * Returns the number of abilities.
	 *
	 * @return the number of abilities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ABILITY);

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
		return "abilityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ABILITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AbilityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ability persistence.
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

		_finderPathWithPaginationFindByAbilityName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAbilityName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"abilityName"}, true);

		_finderPathWithoutPaginationFindByAbilityName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAbilityName",
			new String[] {String.class.getName()}, new String[] {"abilityName"},
			true);

		_finderPathCountByAbilityName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAbilityName",
			new String[] {String.class.getName()}, new String[] {"abilityName"},
			false);

		_setAbilityUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAbilityUtilPersistence(null);

		entityCache.removeCache(AbilityImpl.class.getName());
	}

	private void _setAbilityUtilPersistence(
		AbilityPersistence abilityPersistence) {

		try {
			Field field = AbilityUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, abilityPersistence);
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

	private static final String _SQL_SELECT_ABILITY =
		"SELECT ability FROM Ability ability";

	private static final String _SQL_SELECT_ABILITY_WHERE =
		"SELECT ability FROM Ability ability WHERE ";

	private static final String _SQL_COUNT_ABILITY =
		"SELECT COUNT(ability) FROM Ability ability";

	private static final String _SQL_COUNT_ABILITY_WHERE =
		"SELECT COUNT(ability) FROM Ability ability WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ability.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Ability exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Ability exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AbilityPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AbilityModelArgumentsResolver _abilityModelArgumentsResolver;

}
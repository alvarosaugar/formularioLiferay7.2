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

package com.modulo.registro.service.persistence.impl;

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
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.modulo.registro.exception.NoSuchRegistroException;
import com.modulo.registro.model.Registro;
import com.modulo.registro.model.impl.RegistroImpl;
import com.modulo.registro.model.impl.RegistroModelImpl;
import com.modulo.registro.service.persistence.RegistroPersistence;
import com.modulo.registro.service.persistence.impl.constants.REGPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the registro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RegistroPersistence.class)
@ProviderType
public class RegistroPersistenceImpl
	extends BasePersistenceImpl<Registro> implements RegistroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RegistroUtil</code> to access the registro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RegistroImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByEmail;
	private FinderPath _finderPathWithoutPaginationFindByEmail;
	private FinderPath _finderPathCountByEmail;

	/**
	 * Returns all the registros where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching registros
	 */
	@Override
	public List<Registro> findByEmail(String email) {
		return findByEmail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registros where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegistroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of registros
	 * @param end the upper bound of the range of registros (not inclusive)
	 * @return the range of matching registros
	 */
	@Override
	public List<Registro> findByEmail(String email, int start, int end) {
		return findByEmail(email, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registros where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegistroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of registros
	 * @param end the upper bound of the range of registros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registros
	 */
	@Override
	public List<Registro> findByEmail(
		String email, int start, int end,
		OrderByComparator<Registro> orderByComparator) {

		return findByEmail(email, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registros where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegistroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of registros
	 * @param end the upper bound of the range of registros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching registros
	 */
	@Override
	public List<Registro> findByEmail(
		String email, int start, int end,
		OrderByComparator<Registro> orderByComparator,
		boolean retrieveFromCache) {

		email = Objects.toString(email, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByEmail;
			finderArgs = new Object[] {email};
		}
		else {
			finderPath = _finderPathWithPaginationFindByEmail;
			finderArgs = new Object[] {email, start, end, orderByComparator};
		}

		List<Registro> list = null;

		if (retrieveFromCache) {
			list = (List<Registro>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Registro registro : list) {
					if (!email.equals(registro.getEmail())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_REGISTRO_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RegistroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				if (!pagination) {
					list = (List<Registro>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Registro>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first registro in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registro
	 * @throws NoSuchRegistroException if a matching registro could not be found
	 */
	@Override
	public Registro findByEmail_First(
			String email, OrderByComparator<Registro> orderByComparator)
		throws NoSuchRegistroException {

		Registro registro = fetchByEmail_First(email, orderByComparator);

		if (registro != null) {
			return registro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("email=");
		msg.append(email);

		msg.append("}");

		throw new NoSuchRegistroException(msg.toString());
	}

	/**
	 * Returns the first registro in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registro, or <code>null</code> if a matching registro could not be found
	 */
	@Override
	public Registro fetchByEmail_First(
		String email, OrderByComparator<Registro> orderByComparator) {

		List<Registro> list = findByEmail(email, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registro in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registro
	 * @throws NoSuchRegistroException if a matching registro could not be found
	 */
	@Override
	public Registro findByEmail_Last(
			String email, OrderByComparator<Registro> orderByComparator)
		throws NoSuchRegistroException {

		Registro registro = fetchByEmail_Last(email, orderByComparator);

		if (registro != null) {
			return registro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("email=");
		msg.append(email);

		msg.append("}");

		throw new NoSuchRegistroException(msg.toString());
	}

	/**
	 * Returns the last registro in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registro, or <code>null</code> if a matching registro could not be found
	 */
	@Override
	public Registro fetchByEmail_Last(
		String email, OrderByComparator<Registro> orderByComparator) {

		int count = countByEmail(email);

		if (count == 0) {
			return null;
		}

		List<Registro> list = findByEmail(
			email, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registros before and after the current registro in the ordered set where email = &#63;.
	 *
	 * @param registroId the primary key of the current registro
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registro
	 * @throws NoSuchRegistroException if a registro with the primary key could not be found
	 */
	@Override
	public Registro[] findByEmail_PrevAndNext(
			long registroId, String email,
			OrderByComparator<Registro> orderByComparator)
		throws NoSuchRegistroException {

		email = Objects.toString(email, "");

		Registro registro = findByPrimaryKey(registroId);

		Session session = null;

		try {
			session = openSession();

			Registro[] array = new RegistroImpl[3];

			array[0] = getByEmail_PrevAndNext(
				session, registro, email, orderByComparator, true);

			array[1] = registro;

			array[2] = getByEmail_PrevAndNext(
				session, registro, email, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Registro getByEmail_PrevAndNext(
		Session session, Registro registro, String email,
		OrderByComparator<Registro> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REGISTRO_WHERE);

		boolean bindEmail = false;

		if (email.isEmpty()) {
			query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
		}
		else {
			bindEmail = true;

			query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(RegistroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEmail) {
			qPos.add(email);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(registro)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Registro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registros where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	@Override
	public void removeByEmail(String email) {
		for (Registro registro :
				findByEmail(
					email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(registro);
		}
	}

	/**
	 * Returns the number of registros where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching registros
	 */
	@Override
	public int countByEmail(String email) {
		email = Objects.toString(email, "");

		FinderPath finderPath = _finderPathCountByEmail;

		Object[] finderArgs = new Object[] {email};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REGISTRO_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 =
		"registro.email = ?";

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 =
		"(registro.email IS NULL OR registro.email = '')";

	public RegistroPersistenceImpl() {
		setModelClass(Registro.class);

		setModelImplClass(RegistroImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the registro in the entity cache if it is enabled.
	 *
	 * @param registro the registro
	 */
	@Override
	public void cacheResult(Registro registro) {
		entityCache.putResult(
			entityCacheEnabled, RegistroImpl.class, registro.getPrimaryKey(),
			registro);

		registro.resetOriginalValues();
	}

	/**
	 * Caches the registros in the entity cache if it is enabled.
	 *
	 * @param registros the registros
	 */
	@Override
	public void cacheResult(List<Registro> registros) {
		for (Registro registro : registros) {
			if (entityCache.getResult(
					entityCacheEnabled, RegistroImpl.class,
					registro.getPrimaryKey()) == null) {

				cacheResult(registro);
			}
			else {
				registro.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all registros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RegistroImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the registro.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Registro registro) {
		entityCache.removeResult(
			entityCacheEnabled, RegistroImpl.class, registro.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Registro> registros) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Registro registro : registros) {
			entityCache.removeResult(
				entityCacheEnabled, RegistroImpl.class,
				registro.getPrimaryKey());
		}
	}

	/**
	 * Creates a new registro with the primary key. Does not add the registro to the database.
	 *
	 * @param registroId the primary key for the new registro
	 * @return the new registro
	 */
	@Override
	public Registro create(long registroId) {
		Registro registro = new RegistroImpl();

		registro.setNew(true);
		registro.setPrimaryKey(registroId);

		registro.setCompanyId(companyProvider.getCompanyId());

		return registro;
	}

	/**
	 * Removes the registro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registroId the primary key of the registro
	 * @return the registro that was removed
	 * @throws NoSuchRegistroException if a registro with the primary key could not be found
	 */
	@Override
	public Registro remove(long registroId) throws NoSuchRegistroException {
		return remove((Serializable)registroId);
	}

	/**
	 * Removes the registro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the registro
	 * @return the registro that was removed
	 * @throws NoSuchRegistroException if a registro with the primary key could not be found
	 */
	@Override
	public Registro remove(Serializable primaryKey)
		throws NoSuchRegistroException {

		Session session = null;

		try {
			session = openSession();

			Registro registro = (Registro)session.get(
				RegistroImpl.class, primaryKey);

			if (registro == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRegistroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(registro);
		}
		catch (NoSuchRegistroException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Registro removeImpl(Registro registro) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(registro)) {
				registro = (Registro)session.get(
					RegistroImpl.class, registro.getPrimaryKeyObj());
			}

			if (registro != null) {
				session.delete(registro);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (registro != null) {
			clearCache(registro);
		}

		return registro;
	}

	@Override
	public Registro updateImpl(Registro registro) {
		boolean isNew = registro.isNew();

		if (!(registro instanceof RegistroModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(registro.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(registro);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in registro proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Registro implementation " +
					registro.getClass());
		}

		RegistroModelImpl registroModelImpl = (RegistroModelImpl)registro;

		Session session = null;

		try {
			session = openSession();

			if (registro.isNew()) {
				session.save(registro);

				registro.setNew(false);
			}
			else {
				registro = (Registro)session.merge(registro);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {registroModelImpl.getEmail()};

			finderCache.removeResult(_finderPathCountByEmail, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByEmail, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((registroModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByEmail.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					registroModelImpl.getOriginalEmail()
				};

				finderCache.removeResult(_finderPathCountByEmail, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByEmail, args);

				args = new Object[] {registroModelImpl.getEmail()};

				finderCache.removeResult(_finderPathCountByEmail, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByEmail, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, RegistroImpl.class, registro.getPrimaryKey(),
			registro, false);

		registro.resetOriginalValues();

		return registro;
	}

	/**
	 * Returns the registro with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the registro
	 * @return the registro
	 * @throws NoSuchRegistroException if a registro with the primary key could not be found
	 */
	@Override
	public Registro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRegistroException {

		Registro registro = fetchByPrimaryKey(primaryKey);

		if (registro == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRegistroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return registro;
	}

	/**
	 * Returns the registro with the primary key or throws a <code>NoSuchRegistroException</code> if it could not be found.
	 *
	 * @param registroId the primary key of the registro
	 * @return the registro
	 * @throws NoSuchRegistroException if a registro with the primary key could not be found
	 */
	@Override
	public Registro findByPrimaryKey(long registroId)
		throws NoSuchRegistroException {

		return findByPrimaryKey((Serializable)registroId);
	}

	/**
	 * Returns the registro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param registroId the primary key of the registro
	 * @return the registro, or <code>null</code> if a registro with the primary key could not be found
	 */
	@Override
	public Registro fetchByPrimaryKey(long registroId) {
		return fetchByPrimaryKey((Serializable)registroId);
	}

	/**
	 * Returns all the registros.
	 *
	 * @return the registros
	 */
	@Override
	public List<Registro> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegistroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of registros
	 * @param end the upper bound of the range of registros (not inclusive)
	 * @return the range of registros
	 */
	@Override
	public List<Registro> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the registros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegistroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of registros
	 * @param end the upper bound of the range of registros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of registros
	 */
	@Override
	public List<Registro> findAll(
		int start, int end, OrderByComparator<Registro> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegistroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of registros
	 * @param end the upper bound of the range of registros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of registros
	 */
	@Override
	public List<Registro> findAll(
		int start, int end, OrderByComparator<Registro> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Registro> list = null;

		if (retrieveFromCache) {
			list = (List<Registro>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_REGISTRO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REGISTRO;

				if (pagination) {
					sql = sql.concat(RegistroModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Registro>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Registro>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the registros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Registro registro : findAll()) {
			remove(registro);
		}
	}

	/**
	 * Returns the number of registros.
	 *
	 * @return the number of registros
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_REGISTRO);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "registroId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_REGISTRO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RegistroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the registro persistence.
	 */
	@Activate
	public void activate() {
		RegistroModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		RegistroModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RegistroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RegistroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByEmail = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RegistroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmail",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByEmail = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RegistroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmail",
			new String[] {String.class.getName()},
			RegistroModelImpl.EMAIL_COLUMN_BITMASK);

		_finderPathCountByEmail = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(RegistroImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = REGPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.modulo.registro.model.Registro"),
			true);
	}

	@Override
	@Reference(
		target = REGPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = REGPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference(service = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_REGISTRO =
		"SELECT registro FROM Registro registro";

	private static final String _SQL_SELECT_REGISTRO_WHERE =
		"SELECT registro FROM Registro registro WHERE ";

	private static final String _SQL_COUNT_REGISTRO =
		"SELECT COUNT(registro) FROM Registro registro";

	private static final String _SQL_COUNT_REGISTRO_WHERE =
		"SELECT COUNT(registro) FROM Registro registro WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "registro.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Registro exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Registro exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RegistroPersistenceImpl.class);

}
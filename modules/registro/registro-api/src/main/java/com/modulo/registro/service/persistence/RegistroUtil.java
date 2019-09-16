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

package com.modulo.registro.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.modulo.registro.model.Registro;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the registro service. This utility wraps <code>com.modulo.registro.service.persistence.impl.RegistroPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistroPersistence
 * @generated
 */
@ProviderType
public class RegistroUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Registro registro) {
		getPersistence().clearCache(registro);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Registro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Registro> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Registro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Registro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Registro> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Registro update(Registro registro) {
		return getPersistence().update(registro);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Registro update(
		Registro registro, ServiceContext serviceContext) {

		return getPersistence().update(registro, serviceContext);
	}

	/**
	 * Returns all the registros where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching registros
	 */
	public static List<Registro> findByEmail(String email) {
		return getPersistence().findByEmail(email);
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
	public static List<Registro> findByEmail(String email, int start, int end) {
		return getPersistence().findByEmail(email, start, end);
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
	public static List<Registro> findByEmail(
		String email, int start, int end,
		OrderByComparator<Registro> orderByComparator) {

		return getPersistence().findByEmail(
			email, start, end, orderByComparator);
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
	public static List<Registro> findByEmail(
		String email, int start, int end,
		OrderByComparator<Registro> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByEmail(
			email, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first registro in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registro
	 * @throws NoSuchRegistroException if a matching registro could not be found
	 */
	public static Registro findByEmail_First(
			String email, OrderByComparator<Registro> orderByComparator)
		throws com.modulo.registro.exception.NoSuchRegistroException {

		return getPersistence().findByEmail_First(email, orderByComparator);
	}

	/**
	 * Returns the first registro in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registro, or <code>null</code> if a matching registro could not be found
	 */
	public static Registro fetchByEmail_First(
		String email, OrderByComparator<Registro> orderByComparator) {

		return getPersistence().fetchByEmail_First(email, orderByComparator);
	}

	/**
	 * Returns the last registro in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registro
	 * @throws NoSuchRegistroException if a matching registro could not be found
	 */
	public static Registro findByEmail_Last(
			String email, OrderByComparator<Registro> orderByComparator)
		throws com.modulo.registro.exception.NoSuchRegistroException {

		return getPersistence().findByEmail_Last(email, orderByComparator);
	}

	/**
	 * Returns the last registro in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registro, or <code>null</code> if a matching registro could not be found
	 */
	public static Registro fetchByEmail_Last(
		String email, OrderByComparator<Registro> orderByComparator) {

		return getPersistence().fetchByEmail_Last(email, orderByComparator);
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
	public static Registro[] findByEmail_PrevAndNext(
			long registroId, String email,
			OrderByComparator<Registro> orderByComparator)
		throws com.modulo.registro.exception.NoSuchRegistroException {

		return getPersistence().findByEmail_PrevAndNext(
			registroId, email, orderByComparator);
	}

	/**
	 * Removes all the registros where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public static void removeByEmail(String email) {
		getPersistence().removeByEmail(email);
	}

	/**
	 * Returns the number of registros where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching registros
	 */
	public static int countByEmail(String email) {
		return getPersistence().countByEmail(email);
	}

	/**
	 * Caches the registro in the entity cache if it is enabled.
	 *
	 * @param registro the registro
	 */
	public static void cacheResult(Registro registro) {
		getPersistence().cacheResult(registro);
	}

	/**
	 * Caches the registros in the entity cache if it is enabled.
	 *
	 * @param registros the registros
	 */
	public static void cacheResult(List<Registro> registros) {
		getPersistence().cacheResult(registros);
	}

	/**
	 * Creates a new registro with the primary key. Does not add the registro to the database.
	 *
	 * @param registroId the primary key for the new registro
	 * @return the new registro
	 */
	public static Registro create(long registroId) {
		return getPersistence().create(registroId);
	}

	/**
	 * Removes the registro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registroId the primary key of the registro
	 * @return the registro that was removed
	 * @throws NoSuchRegistroException if a registro with the primary key could not be found
	 */
	public static Registro remove(long registroId)
		throws com.modulo.registro.exception.NoSuchRegistroException {

		return getPersistence().remove(registroId);
	}

	public static Registro updateImpl(Registro registro) {
		return getPersistence().updateImpl(registro);
	}

	/**
	 * Returns the registro with the primary key or throws a <code>NoSuchRegistroException</code> if it could not be found.
	 *
	 * @param registroId the primary key of the registro
	 * @return the registro
	 * @throws NoSuchRegistroException if a registro with the primary key could not be found
	 */
	public static Registro findByPrimaryKey(long registroId)
		throws com.modulo.registro.exception.NoSuchRegistroException {

		return getPersistence().findByPrimaryKey(registroId);
	}

	/**
	 * Returns the registro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param registroId the primary key of the registro
	 * @return the registro, or <code>null</code> if a registro with the primary key could not be found
	 */
	public static Registro fetchByPrimaryKey(long registroId) {
		return getPersistence().fetchByPrimaryKey(registroId);
	}

	/**
	 * Returns all the registros.
	 *
	 * @return the registros
	 */
	public static List<Registro> findAll() {
		return getPersistence().findAll();
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
	public static List<Registro> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Registro> findAll(
		int start, int end, OrderByComparator<Registro> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Registro> findAll(
		int start, int end, OrderByComparator<Registro> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the registros from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of registros.
	 *
	 * @return the number of registros
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RegistroPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RegistroPersistence, RegistroPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RegistroPersistence.class);

		ServiceTracker<RegistroPersistence, RegistroPersistence>
			serviceTracker =
				new ServiceTracker<RegistroPersistence, RegistroPersistence>(
					bundle.getBundleContext(), RegistroPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.modulo.registro.exception.NoSuchRegistroException;
import com.modulo.registro.model.Registro;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the registro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistroUtil
 * @generated
 */
@ProviderType
public interface RegistroPersistence extends BasePersistence<Registro> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RegistroUtil} to access the registro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the registros where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching registros
	 */
	public java.util.List<Registro> findByEmail(String email);

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
	public java.util.List<Registro> findByEmail(
		String email, int start, int end);

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
	public java.util.List<Registro> findByEmail(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Registro>
			orderByComparator);

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
	public java.util.List<Registro> findByEmail(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Registro>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first registro in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registro
	 * @throws NoSuchRegistroException if a matching registro could not be found
	 */
	public Registro findByEmail_First(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<Registro>
				orderByComparator)
		throws NoSuchRegistroException;

	/**
	 * Returns the first registro in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registro, or <code>null</code> if a matching registro could not be found
	 */
	public Registro fetchByEmail_First(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<Registro>
			orderByComparator);

	/**
	 * Returns the last registro in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registro
	 * @throws NoSuchRegistroException if a matching registro could not be found
	 */
	public Registro findByEmail_Last(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<Registro>
				orderByComparator)
		throws NoSuchRegistroException;

	/**
	 * Returns the last registro in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registro, or <code>null</code> if a matching registro could not be found
	 */
	public Registro fetchByEmail_Last(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<Registro>
			orderByComparator);

	/**
	 * Returns the registros before and after the current registro in the ordered set where email = &#63;.
	 *
	 * @param registroId the primary key of the current registro
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registro
	 * @throws NoSuchRegistroException if a registro with the primary key could not be found
	 */
	public Registro[] findByEmail_PrevAndNext(
			long registroId, String email,
			com.liferay.portal.kernel.util.OrderByComparator<Registro>
				orderByComparator)
		throws NoSuchRegistroException;

	/**
	 * Removes all the registros where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public void removeByEmail(String email);

	/**
	 * Returns the number of registros where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching registros
	 */
	public int countByEmail(String email);

	/**
	 * Caches the registro in the entity cache if it is enabled.
	 *
	 * @param registro the registro
	 */
	public void cacheResult(Registro registro);

	/**
	 * Caches the registros in the entity cache if it is enabled.
	 *
	 * @param registros the registros
	 */
	public void cacheResult(java.util.List<Registro> registros);

	/**
	 * Creates a new registro with the primary key. Does not add the registro to the database.
	 *
	 * @param registroId the primary key for the new registro
	 * @return the new registro
	 */
	public Registro create(long registroId);

	/**
	 * Removes the registro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registroId the primary key of the registro
	 * @return the registro that was removed
	 * @throws NoSuchRegistroException if a registro with the primary key could not be found
	 */
	public Registro remove(long registroId) throws NoSuchRegistroException;

	public Registro updateImpl(Registro registro);

	/**
	 * Returns the registro with the primary key or throws a <code>NoSuchRegistroException</code> if it could not be found.
	 *
	 * @param registroId the primary key of the registro
	 * @return the registro
	 * @throws NoSuchRegistroException if a registro with the primary key could not be found
	 */
	public Registro findByPrimaryKey(long registroId)
		throws NoSuchRegistroException;

	/**
	 * Returns the registro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param registroId the primary key of the registro
	 * @return the registro, or <code>null</code> if a registro with the primary key could not be found
	 */
	public Registro fetchByPrimaryKey(long registroId);

	/**
	 * Returns all the registros.
	 *
	 * @return the registros
	 */
	public java.util.List<Registro> findAll();

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
	public java.util.List<Registro> findAll(int start, int end);

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
	public java.util.List<Registro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Registro>
			orderByComparator);

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
	public java.util.List<Registro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Registro>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the registros from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of registros.
	 *
	 * @return the number of registros
	 */
	public int countAll();

}
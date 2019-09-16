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

package com.modulo.registro.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Registro. This utility wraps
 * <code>com.modulo.registro.service.impl.RegistroLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RegistroLocalService
 * @generated
 */
@ProviderType
public class RegistroLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.modulo.registro.service.impl.RegistroLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.modulo.registro.model.Registro addRegistro(
			long groupId, String name, String lastname, String email,
			java.util.Date birthDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addRegistro(
			groupId, name, lastname, email, birthDate, serviceContext);
	}

	/**
	 * Adds the registro to the database. Also notifies the appropriate model listeners.
	 *
	 * @param registro the registro
	 * @return the registro that was added
	 */
	public static com.modulo.registro.model.Registro addRegistro(
		com.modulo.registro.model.Registro registro) {

		return getService().addRegistro(registro);
	}

	public static int countByEmail(String email) {
		return getService().countByEmail(email);
	}

	/**
	 * Creates a new registro with the primary key. Does not add the registro to the database.
	 *
	 * @param registroId the primary key for the new registro
	 * @return the new registro
	 */
	public static com.modulo.registro.model.Registro createRegistro(
		long registroId) {

		return getService().createRegistro(registroId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the registro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registroId the primary key of the registro
	 * @return the registro that was removed
	 * @throws PortalException if a registro with the primary key could not be found
	 */
	public static com.modulo.registro.model.Registro deleteRegistro(
			long registroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteRegistro(registroId);
	}

	/**
	 * Deletes the registro from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registro the registro
	 * @return the registro that was removed
	 */
	public static com.modulo.registro.model.Registro deleteRegistro(
		com.modulo.registro.model.Registro registro) {

		return getService().deleteRegistro(registro);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.modulo.registro.model.impl.RegistroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.modulo.registro.model.impl.RegistroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.modulo.registro.model.Registro fetchRegistro(
		long registroId) {

		return getService().fetchRegistro(registroId);
	}

	public static java.util.List<com.modulo.registro.model.Registro>
		findByEmail(String email) {

		return getService().findByEmail(email);
	}

	public static java.util.List<com.modulo.registro.model.Registro>
		findByEmail(String email, int start, int end) {

		return getService().findByEmail(email, start, end);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the registro with the primary key.
	 *
	 * @param registroId the primary key of the registro
	 * @return the registro
	 * @throws PortalException if a registro with the primary key could not be found
	 */
	public static com.modulo.registro.model.Registro getRegistro(
			long registroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRegistro(registroId);
	}

	/**
	 * Returns a range of all the registros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.modulo.registro.model.impl.RegistroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of registros
	 * @param end the upper bound of the range of registros (not inclusive)
	 * @return the range of registros
	 */
	public static java.util.List<com.modulo.registro.model.Registro>
		getRegistros(int start, int end) {

		return getService().getRegistros(start, end);
	}

	/**
	 * Returns the number of registros.
	 *
	 * @return the number of registros
	 */
	public static int getRegistrosCount() {
		return getService().getRegistrosCount();
	}

	/**
	 * Updates the registro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param registro the registro
	 * @return the registro that was updated
	 */
	public static com.modulo.registro.model.Registro updateRegistro(
		com.modulo.registro.model.Registro registro) {

		return getService().updateRegistro(registro);
	}

	public static RegistroLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RegistroLocalService, RegistroLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RegistroLocalService.class);

		ServiceTracker<RegistroLocalService, RegistroLocalService>
			serviceTracker =
				new ServiceTracker<RegistroLocalService, RegistroLocalService>(
					bundle.getBundleContext(), RegistroLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
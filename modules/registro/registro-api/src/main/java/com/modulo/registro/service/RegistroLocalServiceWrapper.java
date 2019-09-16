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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link RegistroLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RegistroLocalService
 * @generated
 */
@ProviderType
public class RegistroLocalServiceWrapper
	implements RegistroLocalService, ServiceWrapper<RegistroLocalService> {

	public RegistroLocalServiceWrapper(
		RegistroLocalService registroLocalService) {

		_registroLocalService = registroLocalService;
	}

	@Override
	public com.modulo.registro.model.Registro addRegistro(
			long groupId, String name, String lastname, String email,
			java.util.Date birthDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registroLocalService.addRegistro(
			groupId, name, lastname, email, birthDate, serviceContext);
	}

	/**
	 * Adds the registro to the database. Also notifies the appropriate model listeners.
	 *
	 * @param registro the registro
	 * @return the registro that was added
	 */
	@Override
	public com.modulo.registro.model.Registro addRegistro(
		com.modulo.registro.model.Registro registro) {

		return _registroLocalService.addRegistro(registro);
	}

	@Override
	public int countByEmail(String email) {
		return _registroLocalService.countByEmail(email);
	}

	/**
	 * Creates a new registro with the primary key. Does not add the registro to the database.
	 *
	 * @param registroId the primary key for the new registro
	 * @return the new registro
	 */
	@Override
	public com.modulo.registro.model.Registro createRegistro(long registroId) {
		return _registroLocalService.createRegistro(registroId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registroLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the registro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registroId the primary key of the registro
	 * @return the registro that was removed
	 * @throws PortalException if a registro with the primary key could not be found
	 */
	@Override
	public com.modulo.registro.model.Registro deleteRegistro(long registroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registroLocalService.deleteRegistro(registroId);
	}

	/**
	 * Deletes the registro from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registro the registro
	 * @return the registro that was removed
	 */
	@Override
	public com.modulo.registro.model.Registro deleteRegistro(
		com.modulo.registro.model.Registro registro) {

		return _registroLocalService.deleteRegistro(registro);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _registroLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _registroLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _registroLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _registroLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _registroLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _registroLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.modulo.registro.model.Registro fetchRegistro(long registroId) {
		return _registroLocalService.fetchRegistro(registroId);
	}

	@Override
	public java.util.List<com.modulo.registro.model.Registro> findByEmail(
		String email) {

		return _registroLocalService.findByEmail(email);
	}

	@Override
	public java.util.List<com.modulo.registro.model.Registro> findByEmail(
		String email, int start, int end) {

		return _registroLocalService.findByEmail(email, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _registroLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _registroLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _registroLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registroLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the registro with the primary key.
	 *
	 * @param registroId the primary key of the registro
	 * @return the registro
	 * @throws PortalException if a registro with the primary key could not be found
	 */
	@Override
	public com.modulo.registro.model.Registro getRegistro(long registroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registroLocalService.getRegistro(registroId);
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
	@Override
	public java.util.List<com.modulo.registro.model.Registro> getRegistros(
		int start, int end) {

		return _registroLocalService.getRegistros(start, end);
	}

	/**
	 * Returns the number of registros.
	 *
	 * @return the number of registros
	 */
	@Override
	public int getRegistrosCount() {
		return _registroLocalService.getRegistrosCount();
	}

	/**
	 * Updates the registro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param registro the registro
	 * @return the registro that was updated
	 */
	@Override
	public com.modulo.registro.model.Registro updateRegistro(
		com.modulo.registro.model.Registro registro) {

		return _registroLocalService.updateRegistro(registro);
	}

	@Override
	public RegistroLocalService getWrappedService() {
		return _registroLocalService;
	}

	@Override
	public void setWrappedService(RegistroLocalService registroLocalService) {
		_registroLocalService = registroLocalService;
	}

	private RegistroLocalService _registroLocalService;

}
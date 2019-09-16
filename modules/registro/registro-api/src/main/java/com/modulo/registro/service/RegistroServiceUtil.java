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
 * Provides the remote service utility for Registro. This utility wraps
 * <code>com.modulo.registro.service.impl.RegistroServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see RegistroService
 * @generated
 */
@ProviderType
public class RegistroServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.modulo.registro.service.impl.RegistroServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.modulo.registro.model.Registro addRegistro(
			long groupId, String name, String lastname, String email,
			java.util.Date birthDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addRegistro(
			groupId, name, lastname, email, birthDate, serviceContext);
	}

	public static int countByEmail(String email) {
		return getService().countByEmail(email);
	}

	public static java.util.List<com.modulo.registro.model.Registro>
		findByEmail(String email) {

		return getService().findByEmail(email);
	}

	public static java.util.List<com.modulo.registro.model.Registro>
		findByEmail(String email, int start, int end) {

		return getService().findByEmail(email, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static RegistroService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RegistroService, RegistroService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RegistroService.class);

		ServiceTracker<RegistroService, RegistroService> serviceTracker =
			new ServiceTracker<RegistroService, RegistroService>(
				bundle.getBundleContext(), RegistroService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
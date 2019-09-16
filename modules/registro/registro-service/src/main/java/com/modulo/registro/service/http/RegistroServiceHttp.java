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

package com.modulo.registro.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.modulo.registro.service.RegistroServiceUtil;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the HTTP utility for the
 * <code>RegistroServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistroServiceSoap
 * @generated
 */
@ProviderType
public class RegistroServiceHttp {

	public static com.modulo.registro.model.Registro addRegistro(
			HttpPrincipal httpPrincipal, long groupId, String name,
			String lastname, String email, java.util.Date birthDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				RegistroServiceUtil.class, "addRegistro",
				_addRegistroParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, name, lastname, email, birthDate,
				serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.modulo.registro.model.Registro)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.modulo.registro.model.Registro>
		findByEmail(HttpPrincipal httpPrincipal, String email) {

		try {
			MethodKey methodKey = new MethodKey(
				RegistroServiceUtil.class, "findByEmail",
				_findByEmailParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, email);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List<com.modulo.registro.model.Registro>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.modulo.registro.model.Registro>
		findByEmail(
			HttpPrincipal httpPrincipal, String email, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				RegistroServiceUtil.class, "findByEmail",
				_findByEmailParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, email, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List<com.modulo.registro.model.Registro>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int countByEmail(HttpPrincipal httpPrincipal, String email) {
		try {
			MethodKey methodKey = new MethodKey(
				RegistroServiceUtil.class, "countByEmail",
				_countByEmailParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, email);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(RegistroServiceHttp.class);

	private static final Class<?>[] _addRegistroParameterTypes0 = new Class[] {
		long.class, String.class, String.class, String.class,
		java.util.Date.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _findByEmailParameterTypes1 = new Class[] {
		String.class
	};
	private static final Class<?>[] _findByEmailParameterTypes2 = new Class[] {
		String.class, int.class, int.class
	};
	private static final Class<?>[] _countByEmailParameterTypes3 = new Class[] {
		String.class
	};

}
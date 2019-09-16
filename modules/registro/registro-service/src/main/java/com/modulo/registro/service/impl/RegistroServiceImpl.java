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

package com.modulo.registro.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.modulo.registro.model.Registro;
import com.modulo.registro.service.base.RegistroServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the registro remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.modulo.registro.service.RegistroService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistroServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=reg",
		"json.web.service.context.path=Registro"
	},
	service = AopService.class
)
public class RegistroServiceImpl extends RegistroServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.modulo.registro.service.RegistroServiceUtil</code> to access the registro remote service.
	 */
	
	public Registro addRegistro(long groupId, String name, String lastname, String email, Date birthDate, ServiceContext serviceContext)
			  throws PortalException {
		return registroLocalService.addRegistro(groupId, name, lastname, email, birthDate, serviceContext);
	}
	
	
	public List<Registro> findByEmail(String email) {
		 return registroLocalService.findByEmail(email);
	}
		 
		public List<Registro> findByEmail(String email, int start, int end) {
		 return registroLocalService.findByEmail(email, start, end);
	}
		 
		public int countByEmail(String email) {
		 return registroLocalService.countByEmail(email);
	}
	
	
	
	
}
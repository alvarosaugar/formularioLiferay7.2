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
import com.modulo.registro.service.base.RegistroLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the registro local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.modulo.registro.service.RegistroLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistroLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.modulo.registro.model.Registro",
	service = AopService.class
)
public class RegistroLocalServiceImpl extends RegistroLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.modulo.registro.service.RegistroLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.modulo.registro.service.RegistroLocalServiceUtil</code>.
	 */
	
	public Registro addRegistro(long groupId, String name, String lastname, String email, Date birthDate, ServiceContext serviceContext)
			  throws PortalException {
		
			 long registroId = counterLocalService.increment(Registro.class.getName()); 
			 Registro registro = super.createRegistro(registroId); 
			 registro.setCompanyId(serviceContext.getCompanyId()); 
			 registro.setGroupId(groupId); 
			 registro.setUserName(name); 
			 registro.setLastname(lastname);
			 registro.setEmail(email);
			 registro.setBirthDate(birthDate);
			 registro.setCreateDate(serviceContext.getCreateDate(new Date())); 
			 return super.addRegistro(registro); 
			 
	}
	
	
	public List<Registro> findByEmail(String email) {
		 return registroPersistence.findByEmail(email);
	}
		 
		public List<Registro> findByEmail(String email, int start, int end) {
		 return registroPersistence.findByEmail(email, start, end);
	}
		 
		public int countByEmail(String email) {
		 return registroPersistence.countByEmail(email);
	}
	
	
	
}
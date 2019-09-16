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

package com.modulo.registro.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Registro}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Registro
 * @generated
 */
@ProviderType
public class RegistroWrapper
	extends BaseModelWrapper<Registro>
	implements Registro, ModelWrapper<Registro> {

	public RegistroWrapper(Registro registro) {
		super(registro);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("registroId", getRegistroId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userName", getUserName());
		attributes.put("lastname", getLastname());
		attributes.put("email", getEmail());
		attributes.put("birthDate", getBirthDate());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long registroId = (Long)attributes.get("registroId");

		if (registroId != null) {
			setRegistroId(registroId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String lastname = (String)attributes.get("lastname");

		if (lastname != null) {
			setLastname(lastname);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date birthDate = (Date)attributes.get("birthDate");

		if (birthDate != null) {
			setBirthDate(birthDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	 * Returns the birth date of this registro.
	 *
	 * @return the birth date of this registro
	 */
	@Override
	public Date getBirthDate() {
		return model.getBirthDate();
	}

	/**
	 * Returns the company ID of this registro.
	 *
	 * @return the company ID of this registro
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this registro.
	 *
	 * @return the create date of this registro
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this registro.
	 *
	 * @return the email of this registro
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this registro.
	 *
	 * @return the group ID of this registro
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the lastname of this registro.
	 *
	 * @return the lastname of this registro
	 */
	@Override
	public String getLastname() {
		return model.getLastname();
	}

	/**
	 * Returns the primary key of this registro.
	 *
	 * @return the primary key of this registro
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the registro ID of this registro.
	 *
	 * @return the registro ID of this registro
	 */
	@Override
	public long getRegistroId() {
		return model.getRegistroId();
	}

	/**
	 * Returns the user name of this registro.
	 *
	 * @return the user name of this registro
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the birth date of this registro.
	 *
	 * @param birthDate the birth date of this registro
	 */
	@Override
	public void setBirthDate(Date birthDate) {
		model.setBirthDate(birthDate);
	}

	/**
	 * Sets the company ID of this registro.
	 *
	 * @param companyId the company ID of this registro
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this registro.
	 *
	 * @param createDate the create date of this registro
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this registro.
	 *
	 * @param email the email of this registro
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this registro.
	 *
	 * @param groupId the group ID of this registro
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the lastname of this registro.
	 *
	 * @param lastname the lastname of this registro
	 */
	@Override
	public void setLastname(String lastname) {
		model.setLastname(lastname);
	}

	/**
	 * Sets the primary key of this registro.
	 *
	 * @param primaryKey the primary key of this registro
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the registro ID of this registro.
	 *
	 * @param registroId the registro ID of this registro
	 */
	@Override
	public void setRegistroId(long registroId) {
		model.setRegistroId(registroId);
	}

	/**
	 * Sets the user name of this registro.
	 *
	 * @param userName the user name of this registro
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	@Override
	protected RegistroWrapper wrap(Registro registro) {
		return new RegistroWrapper(registro);
	}

}
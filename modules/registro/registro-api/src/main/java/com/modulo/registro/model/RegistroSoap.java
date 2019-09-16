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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.modulo.registro.service.http.RegistroServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class RegistroSoap implements Serializable {

	public static RegistroSoap toSoapModel(Registro model) {
		RegistroSoap soapModel = new RegistroSoap();

		soapModel.setRegistroId(model.getRegistroId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserName(model.getUserName());
		soapModel.setLastname(model.getLastname());
		soapModel.setEmail(model.getEmail());
		soapModel.setBirthDate(model.getBirthDate());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static RegistroSoap[] toSoapModels(Registro[] models) {
		RegistroSoap[] soapModels = new RegistroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RegistroSoap[][] toSoapModels(Registro[][] models) {
		RegistroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RegistroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RegistroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RegistroSoap[] toSoapModels(List<Registro> models) {
		List<RegistroSoap> soapModels = new ArrayList<RegistroSoap>(
			models.size());

		for (Registro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RegistroSoap[soapModels.size()]);
	}

	public RegistroSoap() {
	}

	public long getPrimaryKey() {
		return _registroId;
	}

	public void setPrimaryKey(long pk) {
		setRegistroId(pk);
	}

	public long getRegistroId() {
		return _registroId;
	}

	public void setRegistroId(long registroId) {
		_registroId = registroId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getLastname() {
		return _lastname;
	}

	public void setLastname(String lastname) {
		_lastname = lastname;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Date getBirthDate() {
		return _birthDate;
	}

	public void setBirthDate(Date birthDate) {
		_birthDate = birthDate;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _registroId;
	private long _companyId;
	private long _groupId;
	private String _userName;
	private String _lastname;
	private String _email;
	private Date _birthDate;
	private Date _createDate;

}
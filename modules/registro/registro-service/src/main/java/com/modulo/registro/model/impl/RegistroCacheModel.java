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

package com.modulo.registro.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.modulo.registro.model.Registro;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Registro in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class RegistroCacheModel
	implements CacheModel<Registro>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RegistroCacheModel)) {
			return false;
		}

		RegistroCacheModel registroCacheModel = (RegistroCacheModel)obj;

		if (registroId == registroCacheModel.registroId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, registroId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{registroId=");
		sb.append(registroId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", lastname=");
		sb.append(lastname);
		sb.append(", email=");
		sb.append(email);
		sb.append(", birthDate=");
		sb.append(birthDate);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Registro toEntityModel() {
		RegistroImpl registroImpl = new RegistroImpl();

		registroImpl.setRegistroId(registroId);
		registroImpl.setCompanyId(companyId);
		registroImpl.setGroupId(groupId);

		if (userName == null) {
			registroImpl.setUserName("");
		}
		else {
			registroImpl.setUserName(userName);
		}

		if (lastname == null) {
			registroImpl.setLastname("");
		}
		else {
			registroImpl.setLastname(lastname);
		}

		if (email == null) {
			registroImpl.setEmail("");
		}
		else {
			registroImpl.setEmail(email);
		}

		if (birthDate == Long.MIN_VALUE) {
			registroImpl.setBirthDate(null);
		}
		else {
			registroImpl.setBirthDate(new Date(birthDate));
		}

		if (createDate == Long.MIN_VALUE) {
			registroImpl.setCreateDate(null);
		}
		else {
			registroImpl.setCreateDate(new Date(createDate));
		}

		registroImpl.resetOriginalValues();

		return registroImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		registroId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
		userName = objectInput.readUTF();
		lastname = objectInput.readUTF();
		email = objectInput.readUTF();
		birthDate = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(registroId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (lastname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastname);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(birthDate);
		objectOutput.writeLong(createDate);
	}

	public long registroId;
	public long companyId;
	public long groupId;
	public String userName;
	public String lastname;
	public String email;
	public long birthDate;
	public long createDate;

}
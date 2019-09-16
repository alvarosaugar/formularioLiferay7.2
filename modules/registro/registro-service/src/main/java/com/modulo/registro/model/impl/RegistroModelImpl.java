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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.modulo.registro.model.Registro;
import com.modulo.registro.model.RegistroModel;
import com.modulo.registro.model.RegistroSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the Registro service. Represents a row in the &quot;REG_Registro&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>RegistroModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RegistroImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistroImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class RegistroModelImpl
	extends BaseModelImpl<Registro> implements RegistroModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a registro model instance should use the <code>Registro</code> interface instead.
	 */
	public static final String TABLE_NAME = "REG_Registro";

	public static final Object[][] TABLE_COLUMNS = {
		{"registroId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"lastname", Types.VARCHAR}, {"email", Types.VARCHAR},
		{"birthDate", Types.TIMESTAMP}, {"createDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("registroId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("birthDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table REG_Registro (registroId LONG not null primary key,companyId LONG,groupId LONG,userName VARCHAR(75) null,lastname VARCHAR(75) null,email VARCHAR(75) null,birthDate DATE null,createDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table REG_Registro";

	public static final String ORDER_BY_JPQL =
		" ORDER BY registro.registroId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY REG_Registro.registroId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long EMAIL_COLUMN_BITMASK = 1L;

	public static final long REGISTROID_COLUMN_BITMASK = 2L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Registro toModel(RegistroSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Registro model = new RegistroImpl();

		model.setRegistroId(soapModel.getRegistroId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserName(soapModel.getUserName());
		model.setLastname(soapModel.getLastname());
		model.setEmail(soapModel.getEmail());
		model.setBirthDate(soapModel.getBirthDate());
		model.setCreateDate(soapModel.getCreateDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Registro> toModels(RegistroSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Registro> models = new ArrayList<Registro>(soapModels.length);

		for (RegistroSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public RegistroModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _registroId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRegistroId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _registroId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Registro.class;
	}

	@Override
	public String getModelClassName() {
		return Registro.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Registro, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Registro, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Registro, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Registro)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Registro, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Registro, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Registro)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Registro, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Registro, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Registro>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Registro.class.getClassLoader(), Registro.class,
			ModelWrapper.class);

		try {
			Constructor<Registro> constructor =
				(Constructor<Registro>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<Registro, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Registro, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Registro, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Registro, Object>>();
		Map<String, BiConsumer<Registro, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Registro, ?>>();

		attributeGetterFunctions.put("registroId", Registro::getRegistroId);
		attributeSetterBiConsumers.put(
			"registroId", (BiConsumer<Registro, Long>)Registro::setRegistroId);
		attributeGetterFunctions.put("companyId", Registro::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Registro, Long>)Registro::setCompanyId);
		attributeGetterFunctions.put("groupId", Registro::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Registro, Long>)Registro::setGroupId);
		attributeGetterFunctions.put("userName", Registro::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Registro, String>)Registro::setUserName);
		attributeGetterFunctions.put("lastname", Registro::getLastname);
		attributeSetterBiConsumers.put(
			"lastname", (BiConsumer<Registro, String>)Registro::setLastname);
		attributeGetterFunctions.put("email", Registro::getEmail);
		attributeSetterBiConsumers.put(
			"email", (BiConsumer<Registro, String>)Registro::setEmail);
		attributeGetterFunctions.put("birthDate", Registro::getBirthDate);
		attributeSetterBiConsumers.put(
			"birthDate", (BiConsumer<Registro, Date>)Registro::setBirthDate);
		attributeGetterFunctions.put("createDate", Registro::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Registro, Date>)Registro::setCreateDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getRegistroId() {
		return _registroId;
	}

	@Override
	public void setRegistroId(long registroId) {
		_registroId = registroId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public String getLastname() {
		if (_lastname == null) {
			return "";
		}
		else {
			return _lastname;
		}
	}

	@Override
	public void setLastname(String lastname) {
		_lastname = lastname;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_columnBitmask |= EMAIL_COLUMN_BITMASK;

		if (_originalEmail == null) {
			_originalEmail = _email;
		}

		_email = email;
	}

	public String getOriginalEmail() {
		return GetterUtil.getString(_originalEmail);
	}

	@JSON
	@Override
	public Date getBirthDate() {
		return _birthDate;
	}

	@Override
	public void setBirthDate(Date birthDate) {
		_birthDate = birthDate;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Registro.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Registro toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RegistroImpl registroImpl = new RegistroImpl();

		registroImpl.setRegistroId(getRegistroId());
		registroImpl.setCompanyId(getCompanyId());
		registroImpl.setGroupId(getGroupId());
		registroImpl.setUserName(getUserName());
		registroImpl.setLastname(getLastname());
		registroImpl.setEmail(getEmail());
		registroImpl.setBirthDate(getBirthDate());
		registroImpl.setCreateDate(getCreateDate());

		registroImpl.resetOriginalValues();

		return registroImpl;
	}

	@Override
	public int compareTo(Registro registro) {
		long primaryKey = registro.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Registro)) {
			return false;
		}

		Registro registro = (Registro)obj;

		long primaryKey = registro.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		RegistroModelImpl registroModelImpl = this;

		registroModelImpl._originalEmail = registroModelImpl._email;

		registroModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Registro> toCacheModel() {
		RegistroCacheModel registroCacheModel = new RegistroCacheModel();

		registroCacheModel.registroId = getRegistroId();

		registroCacheModel.companyId = getCompanyId();

		registroCacheModel.groupId = getGroupId();

		registroCacheModel.userName = getUserName();

		String userName = registroCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			registroCacheModel.userName = null;
		}

		registroCacheModel.lastname = getLastname();

		String lastname = registroCacheModel.lastname;

		if ((lastname != null) && (lastname.length() == 0)) {
			registroCacheModel.lastname = null;
		}

		registroCacheModel.email = getEmail();

		String email = registroCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			registroCacheModel.email = null;
		}

		Date birthDate = getBirthDate();

		if (birthDate != null) {
			registroCacheModel.birthDate = birthDate.getTime();
		}
		else {
			registroCacheModel.birthDate = Long.MIN_VALUE;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			registroCacheModel.createDate = createDate.getTime();
		}
		else {
			registroCacheModel.createDate = Long.MIN_VALUE;
		}

		return registroCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Registro, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Registro, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Registro, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Registro)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Registro, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Registro, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Registro, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Registro)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Registro>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _registroId;
	private long _companyId;
	private long _groupId;
	private String _userName;
	private String _lastname;
	private String _email;
	private String _originalEmail;
	private Date _birthDate;
	private Date _createDate;
	private long _columnBitmask;
	private Registro _escapedModel;

}
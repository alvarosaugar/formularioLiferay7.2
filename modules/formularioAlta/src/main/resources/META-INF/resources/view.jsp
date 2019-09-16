<%@ include file="/init.jsp" %>

<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException"%>

<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>
<%@ page import="com.liferay.portal.kernel.captcha.Captcha" %>

	<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="formulario.error.texto.verificacion" />
	<liferay-ui:error exception="<%= CaptchaMaxChallengesException.class %>" message="formulario.error.texto.intentos" />


 <liferay-portlet:actionURL var="updateURL" name="/form/update">
 </liferay-portlet:actionURL>
 
 
 <aui:form action="<%= updateURL %>">
	<aui:input name="name" label="form.name" type="text">
		<aui:validator name="required" />
	</aui:input>
	<aui:input name="lastname" label="form.lastname" type="text">
		<aui:validator name="required" />
	</aui:input>
	<aui:input name="email" label="form.email" type="text">
		<aui:validator name="required" />
		<aui:validator name="email" />
	</aui:input>
	<aui:input name="date" label="form.date" type="date">
		<aui:validator name="required" />
	</aui:input>
 	
 	<portlet:resourceURL id="/form/captcha" var="captchaURL" />
 	
 	<liferay-captcha:captcha url="<%= captchaURL%>"/>  
 
 	
	<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
	</aui:button-row> 	
 	
 	
 	
 </aui:form>
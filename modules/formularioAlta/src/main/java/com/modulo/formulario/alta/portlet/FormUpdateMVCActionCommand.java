package com.modulo.formulario.alta.portlet;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.modulo.formulario.alta.constants.FormularioAltaPortletKeys;
import com.modulo.registro.service.RegistroLocalServiceUtil;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + FormularioAltaPortletKeys.FORMULARIOALTA,
			"mvc.command.name=/form/update"
		},
		service = MVCActionCommand.class
)
public class FormUpdateMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		Boolean ok = true;
		
		String name = ParamUtil.getString(actionRequest, "name");
		String lastname = ParamUtil.getString(actionRequest, "lastname");
		String email = ParamUtil.getString(actionRequest, "email");
		String date = ParamUtil.getString(actionRequest, "date");
		
		_log.info("name: " + name);
		_log.info("lastname: " + lastname);
		_log.info("email: " + email);
		_log.info("date: " + date);
		
		long companyId = PortalUtil.getCompanyId(actionRequest);
		ThemeDisplay themeDisplay= (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId= themeDisplay.getCompanyGroupId();
		long companyId1 = themeDisplay.getCompanyId();
		
		
		_log.info("companyId: " + companyId);
		_log.info("companyId1: " + companyId1);
		
		
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(companyId1);
		
		try {
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date birthDate = formatter.parse(date);
			
			
			RegistroLocalServiceUtil.addRegistro(groupId, name, lastname, email, birthDate, serviceContext);
			
			notificacionEmail(actionRequest, name, email);
			
		} catch (ParseException e) {
			_log.error("Error al parsear la fecha");
			_log.error(e.getMessage());	
			SessionErrors.add(actionRequest, ParseException.class.getName());
			ok = false;
		} catch (PortalException e) {
			_log.error("Error al guardar en base de datos");
			_log.error(e.getMessage());
			SessionErrors.add(actionRequest, SystemException.class.getName());
			ok = false;

		} catch (UnsupportedEncodingException e) {
			_log.error("Error al guardar en base de datos");
			_log.error(e.getMessage());
			SessionErrors.add(actionRequest, SystemException.class.getName());
			ok = false;
		}
		
		return ok;
	}

	
	private void notificacionEmail(ActionRequest actionRequest, String nombre, String email) throws UnsupportedEncodingException {

		PortletPreferences prefs = actionRequest.getPreferences();
	    String asunto = "Solicitud alta";
	    String cuerpo = "Estimado [$usuario$],<br> ha sido dado de alta correctamente.<br> Un saludo.";

	    List<InternetAddress> bcc = new ArrayList<InternetAddress>();
	    InternetAddress emailAddress = new InternetAddress(email, email);
        bcc.add(emailAddress); 

        InternetAddress[] bccA = new InternetAddress[bcc.size()];
        bccA = bcc.toArray(bccA);
        
		enviarMail(bccA, asunto, cuerpo, nombre);
	}

	
	public Boolean validarFecha(Integer year, Integer month, Integer day, Calendar cal) {
		
		Boolean valido = true;
		
		//Calendar cal = Calendar.getInstance();		
		if ((year == cal.get(Calendar.YEAR)) && 
				(month == cal.get(Calendar.MONTH)) && (day == cal.get(Calendar.DAY_OF_MONTH))) {
			valido=false;
		}
		
		return valido;
	}



	public Boolean enviarMail (InternetAddress[] bcc,String asunto,String cuerpo, String nombre) throws UnsupportedEncodingException{
		
		Boolean enviado = true;
		
		String fromEmail = PropsUtil.get("mail.session.mail.smtp.user");
	    if(fromEmail == null){
	    	 enviado = false;
	    }
		  	                
	    InternetAddress from = new InternetAddress(fromEmail, fromEmail);
        String cuerpoFinal = StringUtil.replace(cuerpo,
                new String[] {"[$usuario$]"},
            new String[] {nombre});
            
       MailMessage mailMessage=new MailMessage();
       mailMessage.setBCC(bcc);
       mailMessage.setFrom(from);
       mailMessage.setBody(cuerpoFinal);
       mailMessage.setSubject(asunto);
       mailMessage.setHTMLFormat(true);
       MailServiceUtil.sendEmail(mailMessage);
              
       return enviado;

	}
	
	
	
	private static final Log _log = LogFactoryUtil.getLog(FormUpdateMVCActionCommand.class);
	
}

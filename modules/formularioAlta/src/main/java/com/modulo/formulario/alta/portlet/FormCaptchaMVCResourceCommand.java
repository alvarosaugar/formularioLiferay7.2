package com.modulo.formulario.alta.portlet;

import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.modulo.formulario.alta.constants.FormularioAltaPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + FormularioAltaPortletKeys.FORMULARIOALTA,
			"mvc.command.name=/form/captcha"
		},
		service = MVCResourceCommand.class
)
public class FormCaptchaMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		Boolean ok = true;
		
		
		ParamUtil.print(resourceRequest);
        try {
            
            CaptchaUtil.serveImage(
                    resourceRequest, resourceResponse);
            
            return false;
            
        } catch (Exception e) {
            _log.error(e.getMessage());
            
            return true;
        }
		
		
		
		//return ok;
	}

	private static final Log _log = LogFactoryUtil.getLog(FormCaptchaMVCResourceCommand.class);
	
	
}

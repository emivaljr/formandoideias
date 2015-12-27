package br.com.formandoideias.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import br.com.formandoideias.util.ConverterUtil;

/**
 * @author Eduardo Monteiro
 * @since 15/03/2014
 *
 */
@FacesConverter("br.com.formandoideias.converter.telefone")
public class TelefoneConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(StringUtils.isEmpty(value)) {
            return null;
        } else {
            return ConverterUtil.limpaMascara(value);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            return ConverterUtil.aplicaMascaraTelefone(value.toString());
        } else {
            return "";
        }
    }

}

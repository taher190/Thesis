package com.thesis.converter;

import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.WeakHashMap;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "entityConverter")
public class EntityConverter implements Converter {

    private static Map<Object, String> entities = new WeakHashMap<Object, String>();
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object entity) {
    	
    	if(entity == null) {
            return null;
        }
    	
        synchronized (entities) {
            if (!entities.containsKey(entity)) {
                String uuid = UUID.randomUUID().toString();
                entities.put(entity, uuid);
                return uuid;
            } else {
                return entities.get(entity);
            }
        }
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String uuid) {
    	
        if(StringUtils.isEmpty(uuid)) {
            return null;
        }
    	
        for (Entry<Object, String> entry : entities.entrySet()) {
            if (entry.getValue().equals(uuid)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
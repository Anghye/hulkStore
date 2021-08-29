package com.hulkStore.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

/**
 * Hello world!
 *
 */
public class UtilObjects 
{
	public static void copiarPropiedades(Object origin, Object dest, boolean canBeNull) {
		BeanUtilsBean.getInstance().getConvertUtils().register(false, canBeNull, 0);

		try {
			BeanUtils.copyProperties(dest, origin);
		} catch (IllegalAccessException | InvocationTargetException ex) {

		}
	}
	
	public static void copiarPropiedades(Object origin, Object dest) {
		copiarPropiedades(origin, dest, false);
	}
}

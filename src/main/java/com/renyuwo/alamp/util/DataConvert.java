package com.renyuwo.alamp.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class DataConvert {
	public static String beanToXml(Object obj, Class<?> load) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(load);
		Marshaller marshaller = context.createMarshaller();
//		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
//		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		return writer.toString();
	}
	
	public static <T> T xmlToBean(String template, Class<?> load) throws JAXBException{
	 JAXBContext context = JAXBContext.newInstance(load);
     Unmarshaller unmarshaller = context.createUnmarshaller();
     T chart = (T) unmarshaller.unmarshal(new StringReader(template));
     
     return chart;  
	}
}

package com.meila.soa.proxy.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/***************************************************************************
 * <PRE>
 *
 *  className       : XMLUtils.java
 * 
 *  Description     : XML工具包
 * 
 *  AUTHOR          : mike
 * 
 *  Date   		    : 2015-10-10
 * 
 * </PRE>
 ***************************************************************************/
public class XMLUtils {

    /**
     * JavaBean转换成xml 默认编码UTF-8
     * 
     * @param obj
     * @param writer
     * @return
     * @throws Exception
     */
    public static String convertToXml(Object obj) throws Exception {
        return convertToXml(obj, "UTF-8");
    }

    /**
     * JavaBean转换成xml
     * 
     * @param obj
     * @param encoding
     * @return
     */
    public static String convertToXml(Object obj, String encoding) throws Exception {
        String result = null;
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        result = writer.toString();
        return result;
    }

    /**
     * xml转换成JavaBean
     * 
     * @param xml
     * @param c
     * @return
     * @throws JAXBException 
     */
    @SuppressWarnings("unchecked")
    public static <T> T converyToJavaBean(String xml, Class<T> c) throws Exception {
        T t = null;
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        t = (T) unmarshaller.unmarshal(new StringReader(xml));
        return t;
    }
    
    
    /**
     * 功能描述：格式化xml
     * @param xml
     * @return String
     */
    public static String formatXML(String xml) {
        try {
            Document document = null;
            document = DocumentHelper.parseText(xml);
            // 格式化输出格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("utf-8");
            StringWriter writer = new StringWriter();
            // 格式化输出流
            XMLWriter xmlWriter = new XMLWriter(writer, format);
            // 将document写入到输出流
            xmlWriter.write(document);
            xmlWriter.close();
            return writer.toString();
        } catch (Exception e) {
//            e.printStackTrace();
            return xml;
        }
    }
}

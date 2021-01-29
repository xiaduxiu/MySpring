package com.xcr.spring.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.xcr.spring.beans.PropertyValue;
import com.xcr.spring.beans.factory.config.BeanDefinition;
import com.xcr.spring.beans.factory.config.BeanReference;
import com.xcr.spring.beans.factory.support.AbstractBeanDefinitionReader;
import com.xcr.spring.beans.factory.support.BeanDefinitionRegistry;
import com.xcr.spring.core.io.Resource;
import com.xcr.spring.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;

/**
 * @Author: xia
 * @Date: 2021/1/26 11:45
 * @Version: v1.0
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public static final String BEAN_ELEMENT = "bean";
    public static final String PROPERTY_ELEMENT = "property";
    public static final String ID_ATTRIBUTE = "id";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String REF_ATTRIBUTE = "ref";

    public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        super(beanDefinitionRegistry);
    }

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader, BeanDefinitionRegistry beanDefinitionRegistry) {
        super(resourceLoader, beanDefinitionRegistry);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        Resource resource = getResourceLoader().getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws Exception {
        try (InputStream inputStream = resource.getInputStream()) {
            doLoadBeanDefinitions(inputStream);
        }
    }

    private void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        Document document = XmlUtil.readXML(inputStream);
        Element documentElement = document.getDocumentElement();
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeName().equals(BEAN_ELEMENT)) {
                Element bean = (Element)childNodes.item(i);
                String id = bean.getAttribute(ID_ATTRIBUTE);
                String name = bean.getAttribute(NAME_ATTRIBUTE);
                String className = bean.getAttribute(CLASS_ATTRIBUTE);
                Class<?> classz = null;
                try {
                    classz = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    throw new Exception("no such class" + className);
                }
                String beanName = StrUtil.isEmpty(id) ? name : id;
                if(StrUtil.isBlank(beanName)) {
                    beanName = StrUtil.lowerFirst(classz.getSimpleName());
                }

                BeanDefinition beanDefinition = new BeanDefinition(classz);
                for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                    if (bean.getChildNodes().item(j) instanceof Element) {
                        if (PROPERTY_ELEMENT.equals(bean.getChildNodes().item(j).getNodeName())) {
                            Element property = (Element) bean.getChildNodes().item(j);
                            String nameAttribute = property.getAttribute(NAME_ATTRIBUTE);
                            String valueAttribute = property.getAttribute(VALUE_ATTRIBUTE);
                            String refAttribute = property.getAttribute(REF_ATTRIBUTE);
                            if (StrUtil.isBlank(nameAttribute)) {
                                throw new Exception("property name has null");
                            }
                            Object value =  valueAttribute;
                            if (StrUtil.isNotBlank(refAttribute)) {
                                value = new BeanReference(refAttribute);
                            }
                            PropertyValue propertyValue = new PropertyValue(nameAttribute, value);
                            beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
                        }
                    }
                }
                if (getRegistry().containsBeanDefinition(beanName)) {
                    //beanName不能重名
                    throw new Exception("Duplicate beanName[" + beanName + "] is not allowed");
                }
                getRegistry().registerBeanDefinition(beanName, beanDefinition);
            }
        }
    }
}

package com.meila.soa.product.service.utils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.web.client.RestTemplate;

/**
 * @类名： MeiLaRestTemplate.java @描述： @作者： Toney @修改日期： 2015年8月27日
 */
@Component("meiLaRestTemplate")
public class MeiLaRestTemplate extends RestTemplate {
    private static Logger LOG = LoggerFactory.getLogger(MeiLaRestTemplate.class);
    private static boolean romePresent = ClassUtils.isPresent("com.sun.syndication.feed.WireFeed", MeiLaRestTemplate.class.getClassLoader());

    private static final boolean jaxb2Present = ClassUtils.isPresent("javax.xml.bind.Binder", MeiLaRestTemplate.class.getClassLoader());

    private static final boolean jackson2Present = ClassUtils.isPresent("com.fasterxml.jackson.databind.ObjectMapper",
        MeiLaRestTemplate.class.getClassLoader())
            && ClassUtils.isPresent("com.fasterxml.jackson.core.JsonGenerator", MeiLaRestTemplate.class.getClassLoader());

    private static final boolean jacksonPresent = ClassUtils.isPresent("org.codehaus.jackson.map.ObjectMapper",
        MeiLaRestTemplate.class.getClassLoader())
            && ClassUtils.isPresent("org.codehaus.jackson.JsonGenerator", MeiLaRestTemplate.class.getClassLoader());
    private final List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();

    private final int timeout = 10 * 1000; // 毫秒

    public MeiLaRestTemplate() {
        this.messageConverters.add(new ByteArrayHttpMessageConverter());
        this.messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        this.messageConverters.add(new ResourceHttpMessageConverter());
        this.messageConverters.add(new SourceHttpMessageConverter<Source>());
        this.messageConverters.add(new AllEncompassingFormHttpMessageConverter());
        if (jaxb2Present) {
            this.messageConverters.add(new Jaxb2RootElementHttpMessageConverter());
        }
        if (jackson2Present) {
            this.messageConverters.add(new MappingJackson2HttpMessageConverter());
        } else if (jacksonPresent) {
            // this.messageConverters.add(new
            // org.springframework.http.converter.json.MappingJacksonHttpMessageConverter());
        }

        // 设置超时时间
        if (getRequestFactory() instanceof SimpleClientHttpRequestFactory) {
            LOG.info(" MeiLaRestTemplate (SimpleClientHttpRequestFactory)设置超时时间为 {} ms.", timeout);
            ((SimpleClientHttpRequestFactory) getRequestFactory()).setConnectTimeout(timeout);
            ((SimpleClientHttpRequestFactory) getRequestFactory()).setReadTimeout(timeout);
        } else if (getRequestFactory() instanceof HttpComponentsClientHttpRequestFactory) {
            LOG.info(" MeiLaRestTemplate (HttpComponentsClientHttpRequestFactory)设置超时时间为 {} ms.", timeout);
            ((HttpComponentsClientHttpRequestFactory) getRequestFactory()).setReadTimeout(timeout);
            ((HttpComponentsClientHttpRequestFactory) getRequestFactory()).setConnectTimeout(timeout);
        }
    }

    public List<HttpMessageConverter<?>> getMessageConverters() {
        return messageConverters;
    }

    @Override
    public void setMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
        Assert.notEmpty(messageConverters, "'messageConverters' must not be empty");
        this.messageConverters.clear();
        this.messageConverters.addAll(messageConverters);
    }

}

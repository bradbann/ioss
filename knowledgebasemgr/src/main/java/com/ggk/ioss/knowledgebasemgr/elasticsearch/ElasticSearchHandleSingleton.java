/*
 * File Name：ElasticSearchHandleSingleton.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年9月30日 下午5:15:35
 */
package com.ggk.ioss.knowledgebasemgr.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import com.ggk.ioss.knowledgebasemgr.conf.SystemConfigs;

@Service
@EnableConfigurationProperties(SystemConfigs.class)
public class ElasticSearchHandleSingleton {
    
    private ElasticSearchHandle handle = null;
    
    @Autowired
    public ElasticSearchHandleSingleton(SystemConfigs conf) {
        handle = new ElasticSearchHandle(conf.getEsip(),Integer.parseInt(conf.getEsport()), conf.getEscluster());
    } 

    public ElasticSearchHandle getHandle() {
        return handle;
    }
    
    public void destory() {
        if (null != this.handle) {
            this.handle.destory();
        }
    }
}


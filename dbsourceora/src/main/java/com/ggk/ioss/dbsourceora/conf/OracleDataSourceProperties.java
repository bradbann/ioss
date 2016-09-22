/*
 * File Name：OracleDataSourceProperties.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年9月20日 上午10:33:00
 */
package com.ggk.ioss.dbsourceora.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author lcc (lincc@ggkbigdata.com)
 * @version 1.0, 2016年9月20日 上午10:33:00
 */
@ConfigurationProperties(prefix = "oracle",ignoreUnknownFields = false)
public class OracleDataSourceProperties {
    private String diverClassName;
    private String url;
    private String username;
    private String password;
    private int initialSize;
    private int maxActive;
    private int maxIdle;
    private int minIdle;
    private int maxWait;
    private boolean testWhileIdle;
    private int timeBetweenEvictionRunsMillis;
    private int minEvictableIdleTimeMillis;
    private int numTestsPerEvictionRun;
    private boolean poolPreparedStatements;
    private int maxOpenPreparedStatements;
    private boolean defaultAutoCommit;
    private boolean removeAbandoned;
    private int removeAbandonedTimeout;
    private boolean logAbandoned;
    
    public String getDiverClassName() {
        return diverClassName;
    }
    public void setDiverClassName(String diverClassName) {
        this.diverClassName = diverClassName;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getInitialSize() {
        return initialSize;
    }
    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }
    public int getMaxActive() {
        return maxActive;
    }
    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }
    public int getMaxIdle() {
        return maxIdle;
    }
    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }
    public int getMinIdle() {
        return minIdle;
    }
    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }
    public int getMaxWait() {
        return maxWait;
    }
    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }
    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }
    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }
    public int getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }
    public void setTimeBetweenEvictionRunsMillis(
            int timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }
    public int getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }
    public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }
    public int getNumTestsPerEvictionRun() {
        return numTestsPerEvictionRun;
    }
    public void setNumTestsPerEvictionRun(int numTestsPerEvictionRun) {
        this.numTestsPerEvictionRun = numTestsPerEvictionRun;
    }
    public boolean isPoolPreparedStatements() {
        return poolPreparedStatements;
    }
    public void setPoolPreparedStatements(boolean poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
    }
    public int getMaxOpenPreparedStatements() {
        return maxOpenPreparedStatements;
    }
    public void setMaxOpenPreparedStatements(int maxOpenPreparedStatements) {
        this.maxOpenPreparedStatements = maxOpenPreparedStatements;
    }
    public boolean isDefaultAutoCommit() {
        return defaultAutoCommit;
    }
    public void setDefaultAutoCommit(boolean defaultAutoCommit) {
        this.defaultAutoCommit = defaultAutoCommit;
    }
    public boolean isRemoveAbandoned() {
        return removeAbandoned;
    }
    public void setRemoveAbandoned(boolean removeAbandoned) {
        this.removeAbandoned = removeAbandoned;
    }
    public int getRemoveAbandonedTimeout() {
        return removeAbandonedTimeout;
    }
    public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
        this.removeAbandonedTimeout = removeAbandonedTimeout;
    }
    public boolean isLogAbandoned() {
        return logAbandoned;
    }
    public void setLogAbandoned(boolean logAbandoned) {
        this.logAbandoned = logAbandoned;
    }
}


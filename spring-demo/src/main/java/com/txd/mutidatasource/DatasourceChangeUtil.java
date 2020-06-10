package com.txd.mutidatasource;

import org.springframework.stereotype.Component;

/**
 * 数据源切换的工具类
 */
@Component
public class DatasourceChangeUtil {
    /**
     * 根据线程设置数据源的key
     */
    private ThreadLocal<String> dataSourceKey = new ThreadLocal<String>();

    /**
     * aop中添加
     *
     * @param key 数据源的key
     */
    public void setDataSourceKey(String key) {
        dataSourceKey.set(key);
    }

    /**
     * AbstractRoutingDataSource中获取
     *
     * @return
     */
    public String getDataSourceKey() {
        return dataSourceKey.get();
    }
}

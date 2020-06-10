package com.txd.mutidatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 多个数据源动态切换
 */
public class MydatasourceManager extends AbstractRoutingDataSource {

    private DatasourceChangeUtil DatasourceChangeUtil;

    @Override
    protected Object determineCurrentLookupKey() {
        return DatasourceChangeUtil.getDataSourceKey();
    }

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
    }

    public void setDatasourceChangeUtil(com.txd.mutidatasource.DatasourceChangeUtil datasourceChangeUtil) {
        DatasourceChangeUtil = datasourceChangeUtil;
    }
}

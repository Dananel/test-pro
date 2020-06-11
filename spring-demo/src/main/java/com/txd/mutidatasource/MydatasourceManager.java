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

    private DatasourceChangeUtil datasourceChangeUtil;

    @Override
    protected Object determineCurrentLookupKey() {
        return datasourceChangeUtil.getDataSourceKey();
    }

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
    }

    public void setDatasourceChangeUtil(DatasourceChangeUtil datasourceChangeUtil) {
        this.datasourceChangeUtil = datasourceChangeUtil;
    }

    public DatasourceChangeUtil getDatasourceChangeUtil() {
        return datasourceChangeUtil;
    }
}

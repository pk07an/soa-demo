package com.meila.soa.product.dal.dao.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.product.ProdSync;

public interface ProdSyncMapper {

    ProdSync load(String id);

    List<ProdSync> loadAll();

    List<ProdSync> selectByPassedShopId(String shopId);

    List<ProdSync> selectByShopId(@Param("shopId") String shopId, @Param("auditSts") String auditSts);

    List<ProdSync> loadByAuditSts(String auditSts);

    int insert(ProdSync e);

    int delete(String id);

    List<ProdSync> selectUnsynced(@Param("auditSts") String auditSts);

    int updateForSynced(@Param("shopId") String shopId, @Param("synced") Boolean synced);

    boolean existShop(@Param("shopId") String shopId);

    Long countSyncShops(@Param(value = "params") Map<String, Object> params);

    List<ProdSync> findByParmas(@Param(value = "params") Map<String, Object> params, @Param(value = "page") Map<String, Object> page);

    int update(ProdSync record);

}

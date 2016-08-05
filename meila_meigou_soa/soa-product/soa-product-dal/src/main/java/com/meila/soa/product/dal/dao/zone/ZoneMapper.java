package com.meila.soa.product.dal.dao.zone;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.PostConf;
import com.meila.soa.product.dal.entity.Zone;

public interface ZoneMapper {
    Zone selectByPrimaryKey(String id);

    List<Zone> listRoots();

    List<Zone> listChildren(String zoneId);

    Zone findParent(String zoneId);

    List<Zone> selectByIds(@Param(value = "params") List<String> params);

    List<Zone> findByName(String name);

    List<PostConf> findPostArea(String name);

    List<PostConf> selectPostConf();

    void updatePath(String id, String path);

    boolean isDescendant(String id, String decendantId);

    List<Zone> listSiblings(String zoneId);

    List<Zone> listPostAgeArea();

    List<Zone> selectCity4PostAge();

}

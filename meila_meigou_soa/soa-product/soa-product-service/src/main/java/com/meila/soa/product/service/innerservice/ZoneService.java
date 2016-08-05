package com.meila.soa.product.service.innerservice;

import java.util.List;
import java.util.Map;

import com.meila.soa.product.dal.entity.Zone;

public interface ZoneService {

    Zone load(String id);

    List<Zone> listRoots();

    List<Zone> listChildren(String zoneId);

    List<Zone> listSiblings(String zoneId);

    Zone findParent(String zoneId);

    List<Zone> listParents(String zoneId);

    Map<String, List<String>> loadPostFreeList();

    void updateZonePath(String id);

    List<Zone> listPostageZones();

    List<Zone> listPostageCityZones();

    Map<String, Zone> selectByIds(List<String> params);
}

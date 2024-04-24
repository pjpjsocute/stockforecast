package org.pjpjcute.stockforecast.core.infrastructure.persistence.convertor;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */
public interface BaseConverter<T, DO> {

    /**
     * do批量转DOMAIN
     *
     * @param doList list
     * @return list
     */
    default List<T> convert2OjbList(List<DO> doList) {
        return CollectionUtils.emptyIfNull(doList)
                .stream()
                .map(this::convert2Obj)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * domain批量转DO
     *
     * @param doList list
     * @return do
     */
    default List<DO> convert2DoList(List<T> doList) {
        return CollectionUtils.emptyIfNull(doList)
                .stream()
                .map(this::convert2DO)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * do -> domainObj
     *
     * @param doObj do
     * @return domain
     */
    T convert2Obj(DO doObj);

    /**
     * domainObj -> do
     *
     * @param domainObj domainObj
     * @return do
     */
    DO convert2DO(T domainObj);

}

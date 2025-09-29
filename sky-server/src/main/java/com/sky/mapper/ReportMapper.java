package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ReportMapper {
    Double getTurnoverStatistics(HashMap<String, Object> map);

    Integer getUserStatistics(HashMap<String, Object> map);

    Integer getOrderCount(HashMap<String, Object> map);
}

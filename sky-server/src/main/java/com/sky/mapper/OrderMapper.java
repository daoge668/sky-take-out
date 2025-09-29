package com.sky.mapper;


import com.github.pagehelper.Page;
import com.sky.dto.GoodsSalesDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.OrderDetail;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    void insert(Orders order);

    void insertBatch(List<OrderDetail> orderDetails);

    /**
     * 根据订单号和用户id查询订单
     * @param orderNumber
     * @param userId
     */
    @Select("select * from orders where number = #{orderNumber} and user_id= #{userId}")
    Orders getByNumberAndUserId(String orderNumber, Long userId);

    /**
     * 修改订单信息
     * @param orders
     */
    void update(Orders orders);

    /**
     * 分页查询
     * @param ordersPageQueryDTO
     * @return
     */
    Page<Orders> pageQueryUser(OrdersPageQueryDTO ordersPageQueryDTO);

    Orders getById(Long id);


    @Select("select count(id) from orders where status = #{status}")
    Integer countStatus(Integer status);

    Page<Orders> conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO);

    List<Orders> getByStatusAndOrderTime(Integer status, LocalDateTime time);

    List<GoodsSalesDTO> getSalesTop10(LocalDateTime begin, LocalDateTime end);
    /**
     * 根据动态条件统计营业额数据
     * @param map
     * @return
     */
    Double sumByMap(Map map);

    /**
     * 根据动态条件统计订单数量
     * @param map
     * @return
     */
    Integer countByMap(Map map);
}

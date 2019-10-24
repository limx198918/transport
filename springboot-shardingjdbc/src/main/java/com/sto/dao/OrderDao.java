package com.sto.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OrderDao {

	@Insert("insert into t_order(orderno,sellerid) values(#{orderno},#{sellerid})")
	int insertOrder(@Param("orderno") String orderno,@Param("sellerid") Long sellerid);
	
	@Select("select * from t_order where 1=1 and orderid=#{orderid} and sellerid=#{sellerid}")
	List<Map> queryOrder(@Param("orderid") Long orderid,@Param("sellerid") Long sellerid);
	
	
	@Select("<script>"
			+ "select * from t_order where 1=1 "
			+ "and orderid in"
			+ "<foreach item=\"item\" open=\"(\" separator=\",\"  close=\")\" collection=\"ids\">"
			+ "#{item}"
			+"</foreach>"
			+ "and sellerid=#{sellerid}"
			+ "</script>")
	List<Map> queryList(@Param("ids") List<Long> ids,@Param("sellerid") Long sellerid);
}

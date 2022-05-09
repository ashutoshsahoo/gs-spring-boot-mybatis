package com.ashu.practice.mapper;

import com.ashu.practice.domain.Hotel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HotelMapper {

    Hotel selectByCityId(int cityId);

}

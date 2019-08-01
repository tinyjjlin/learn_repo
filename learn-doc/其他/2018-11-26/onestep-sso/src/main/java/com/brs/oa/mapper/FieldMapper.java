package com.brs.oa.mapper;

import com.brs.oa.comm.fieldAuth.FieldSchema;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FieldMapper {

    @Select("\n" +
            "select bf.field_name,bf.field_desc,bf.from_dto,brf.accessable from brs_field as bf\n" +
            "left join  brs_role_field as brf\n" +
            "on bf.id = brf.field_id\n" +
            "left join brs_role as br\n" +
            "on br.id = brf.role_id\n" +
            "left join brs_user_role as bur\n" +
            "on br.id = bur.role_id\n" +
            "left join brs_user as bu\n" +
            "on bu.id = bur.user_id\n" +
            "where bu.code =#{userCode} and bf.from_dto =#{dtoName};")
    public List<FieldSchema> queryFieldByUserCodeAndDtoName(@Param("userCode") String userCode, @Param("dtoName") String dtoName);
}

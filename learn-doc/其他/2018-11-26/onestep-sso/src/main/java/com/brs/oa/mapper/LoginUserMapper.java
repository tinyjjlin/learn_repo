package com.brs.oa.mapper;

import com.brs.oa.model.Permission;
import com.brs.oa.model.User;
import com.brs.oa.model.UserPermission;
import com.brs.oa.model.UserRole;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface LoginUserMapper {

    @Select("select uid,code,name,pwd from brs_user where code=#{userCode} ")
    public User queryUserByUserCode(@Param("userCode")String userCode);

    @Select("select  P.id,P.code,P.name,P.type,P.parent_code,P.parent_ids,P.url,P.pre_code from brs_permission as P \n" +
            "left join brs_role_permission as RP\n" +
            "on P.id = RP.permi_id\n" +
            "left join brs_role as R\n" +
            "on R.id = RP.role_id\n" +
            "left join brs_user_role as UR\n" +
            "on UR.role_id = R.id\n" +
            "left join brs_user as U\n" +
            "on U.id = UR.user_id\n" +
            "where U.code =#{userCode}")
    public  List<Permission> queryPermissionByUserCode(@Param("userCode") String  userCode);





    @Select("select uid,name,pwd from brs_user where uid=#{userId} ")
    public User queryUserByName(@Param("userId")String userName);

    @Select("select uid,name,pwd from brs_user where uid=#{userId} and pwd =#{pwd}")
    public User queryUserByUserIdAndPwd(@Param("userId") Integer userId,@Param("pwd") String password);

    @Select("select A.id,A.code,A.name,A.avaliable from brs_role as A\n" +
            "left join\n" +
            "brs_user_role as B on A.id= B.role_id\n" +
            "left join\n" +
            "brs_user as C on C.id= B.user_id\n" +
            "where C.uid =#{userId}")
    public List<UserRole> queryUserRoleByUserId(@Param("userId") Integer userId );

    @Select("select P.id,P.code,P.name\n" +
            "from brs_permission as P\n" +
            "left join brs_role_permission as RP\n" +
            "on P.id = RP.permi_id\n" +
            "left join brs_role as R\n" +
            "on R.id = RP.role_id\n" +
            "where R.code =#{roleCode}")
    public  List<UserPermission> queryActionPermissonByRoleCode(String roleCode);
}

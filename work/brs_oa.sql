# brs_oa

------------------------------
## sql

## 查询指定用户
select uid,name,pwd from brs_user where uid="100057" and pwd ="linlin00";

## 查询指定用户的角色

select A.id,A.code,A.name,A.avaliable from brs_role as A
left join
brs_user_role as B on A.id= B.role_id
left join
brs_user as C on C.id= B.user_id
where C.name ="纪俊林"

## 根据角色查询对应的权限

select permission.id,permission.code,permission.name,permission.resource_type,permission.url,permission.parent_id,permission.parent_ids,permission.permission,permission.avaliable 
from permission
left join role_permission
on permission.id = role_permission.permission_id
left join role
on role.id = role_permission.role_id
where role.code ="01"

select P.id,P.code,P.name
from brs_permission as P
left join brs_role_permission as RP
on P.id = RP.permi_id
left join brs_role as R
on R.id = RP.role_id
where R.code ="01"

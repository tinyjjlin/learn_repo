use brs_oa_sys;
SET SQL_SAFE_UPDATES = 0;
update attendance_record set clock_in_records = concat("2018-12-18 16:20:00",",",IFNULL(clock_in_records,""))
where emp_no =100090;
select * from attendance_record;


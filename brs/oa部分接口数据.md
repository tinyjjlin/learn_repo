#oa部分接口数据


## login
 url: http://localhost:8080/api/login
 请求方式：post
 请求数据：
{
  "password": "123456",
  "username": "j100057"
}
返回数据：
{
  "code": 200,
  "msg": "登录成功!",
  "data": {
    "loginName": "j100057",
    "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpbl9uYW1lIjoiajEwMDA1NyIsImVtcGxveWVlX25vIjoxMDAwNTcsImV4cCI6MTU0Njg0MTYxMiwiaWF0IjoxNTQ2ODM5ODEyfQ.vQg0jhKImBAKFaQO4LuOAnjbmlioborQNsxaM5EnTVA"
  }
}

##获取登录用户信息
url:http://localhost:8080/api/login/userInfo
请求方式：get
请求头部数据保存在字段Authorization中
返回数据：
{
  "code": 200,
  "msg": "退出操作成功!",
  "data": {
    "empNo": 100057,
    "name": "纪俊林",
    "avatar": "https://mypics.zhaopin.cn//attachment/2018/11/6/603f07d8-cc13-49ca-a612-cc83a9a7d0e1.jpg",
    "roles": [
      "贝偌偲成员"
    ],
    "introduction": "贝偌偲员工"
  }
}

## 获取员工详细信息
url：http://localhost:8080/api/staffs/personal/info
method：get
Request Headers：
{
  "Accept": "*/*",
  "Authorization": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpbl9uYW1lIjoiajEwMDA1NyIsImVtcGxveWVlX25vIjoxMDAwNTcsImV4cCI6MTU0Njg1MzExMCwiaWF0IjoxNTQ2ODUxMzEwfQ.r0a0dixFNc8Il7lj-VZHuJUJllcLKpxjHo5jlWgWack"
}
Response Body:
{
  "code": 200,
  "msg": "查看员工个人信息操作成功！",
  "data": {
    "picture": "https://mypics.zhaopin.cn//attachment/2018/11/6/603f07d8-cc13-49ca-a612-cc83a9a7d0e1.jpg",
    "name": "纪俊林",
    "gender": 0,
    "nation": "汉",
    "politicsStatus": "群众",
    "empNo": 100057,
    "position": "java软件工程师",
    "deptNo": 101101,
    "deptName": "IT部门",
    "hireDate": "2018-10-26",
    "mobile": "15195988793",
    "email": "tinyjjlin@163.com",
    "hobby": null,
    "maritalStatus": 1,
    "highestDegree": "大专",
    "birthday": "1989-09-17",
    "currentAddress": "南京市玄武区孝陵卫街道钟鼎山庄",
    "address": "江苏省泗阳县",
    "nationIdcard": "321323XXXX",
    "socialInsuranceAccount": "1444444444444",
    "emergencyContact": "bbbbb",
    "emergencyContactPhone": "15555",
    "educationRecordList": [
      {
        "educationRecordId": 6,
        "schoolName": "南京农业大学",
        "educationStartEndTime": "2019-01-07,2019-02-12",
        "major": "大专",
        "diplomas": "硕士",
        "staffEmpNo": null,
        "isNationalUnified": 1
      }
    ],
    "workExperienceList": [
      {
        "workExperienceId": 1,
        "workStartEndTime": "2019-01-22,2019-02-18",
        "companyName": "南京",
        "oldPosition": "Java",
        "reasonToLeave": "考研",
        "certifier": "人",
        "certifierMobile": "34232ddd",
        "staffEmpNo": null
      }
    ],
    "trainRecordList": [
      {
        "trainRecordId": 4,
        "staffEmpNo": null,
        "trainStartEndTime": "2019-01-29,2019-02-05",
        "trainAgency": "dfdf",
        "trainCourse": "fdfd"
      }
    ]
  }
}
# java keytool 使用说明

---

## keytool 命令
![keytool 命令](../doc_img/keytool_cmd.png)

[使用参考](https://www.cnblogs.com/xdp-gacl/p/3750965.html)

## 使用场景 ：导入AD证书
```
keytool -importcert -keystore cacerts -storepass changeit -keypass changeit -alias brs_ad -file C:\dev\file\brs_ad.cer
```
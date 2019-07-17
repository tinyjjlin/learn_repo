# vue 异步数据组件间传递

# 解决方案
1. 让子组件有条件渲染, v-if
```
<div v-if='propsValue'></div>

```
2. watch监听
```
watch:{
    propsValue(val){
       this.value = val;
    }
}
```
3. $nextTick()
4. Promise
```
new Promise((resolve,reject) => {
if (res.status === 200){
resolve(res);
}
}).then((res) => {
this.category = res.data.data.category;
this.adBar = res.data.data.advertesPicture.PICTURE_ADDRESS;
this.bannerSwipePics = res.data.data.slides;
this.recommendGoods = res.data.data.recommend;
// 也可异步获取再传给子组件 Promise
this.floorSeafood = res.data.data.floor1;
this.floorBeverage = res.data.data.floor2;
this.floorFruits = res.data.data.floor3;
console.log(this.floorFruits);
this._initScroll();
})
}).catch(err => {
console.log(err);
});
```

## reference
1. [vue父组件向子组件动态传值的两种方法](http://oa.beiruosi.wang:9018/#/dashboard)

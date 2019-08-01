router.beforeEach((to, from, next) => {
  store.dispatch('user/getRemoteToken').then(data => {
    console.log('# remote token..........' + data.data.token)
    if (data.data.token) {
      if (to.path === '/login') {
        next({ path: '/' })
      } else {
        if (store.getters.roles.length === 0) {
          store.dispatch('user/GetUserInfo')
            .then(data => {
              const roles = []
              data.data.roleList.forEach(value => {
                roles.push(value.roleId)
              })
              store.dispatch('permission/GenerateRouters', roles)
                .then(() => {
                  // 添加跳转错误页面路由
                  router.addRoutes([{ path: '*', redirect: '/404' }])
                  router.addRoutes(store.getters.addRouters) // 动态添加可访问路由表
                  next({ ...to, replace: true })
                })
            })
            .catch(err => {
              store.dispatch('user/PassiveOut')
              Message.error(err || '获取角色失败,请重新登陆!')
            })
        } else {
          console.log(store.getters.roles)
          // 4.动态验证路由权限
          if (hasPermission(store.getters.roles, to.meta.roles)) {
            // 已登录并拥有前往页面权限
            next()
          } else {
            // 已登录但前往页面无权限
            next({ path: '/401', replace: true, query: { noGoBack: true } })
          }
        }
      }
    } else {
      console.log('#......重新登.......')
      next(`/login?redirectUrl=${to.path}`)
      Message.info('请重新登录!')
    }
  })
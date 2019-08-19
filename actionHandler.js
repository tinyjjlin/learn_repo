const ROLE_RECEIVER = 'receiver'
const ROLE_DISPATCHER_ARR = ['dispatcher_A', 'dispatcher_B', 'dispatcher_D']
const ORDER_STATUS_NEW = '新订单'
const ORDER_STATUS_ALLOCATION = ['排单', '数据排单', '实验排单', '投稿排单']
// 根据服务器返回的动作列表，判断是否显示按钮
export function showAction(actionName, serviceActionList) {
  for (const i in serviceActionList) {
    if (actionName === i) {
      return true
    }
  }
  return false
}
// 接单员 (签单，拒签，打回) 动作
export function showReceiverAction(role, orderStatus) {
  if (role === ROLE_RECEIVER && orderStatus === ORDER_STATUS_NEW) {
    return true
  }
  return false
}
// 排单员 (分配) 动作
export function showDispatcherAction(role, orderStatus) {
  var result = 0
  for (const i in ROLE_DISPATCHER_ARR) {
    if (role === i) ++result
  }
  for (const i in ORDER_STATUS_ALLOCATION) {
    if (orderStatus === i) ++result
  }
  if (result === 2) {
    return true
  }
  return false
}

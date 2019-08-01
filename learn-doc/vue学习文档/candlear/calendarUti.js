// 日历工具类

// 判断润年
export function isLeap(year) {
  return (year % 100 === 0 ? (year % 400 === 0 ? 1 : 0) : (year % 4 === 0 ? 1 : 0))
}

// 获取某年每个月对应的天数数组
export function getDaysInMonthArr(year) {
  return [31, 28 + isLeap(year), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
}
// 获取某年某月对应的天数
export function getDaysInMonth(year, month) {
  return getDaysInMonthArr(year)[month - 1]
}

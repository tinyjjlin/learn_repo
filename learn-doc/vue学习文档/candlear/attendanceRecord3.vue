<template>
<div class="calendar">
    <div class="title">
        <h2 class="green" id="calendar-year">{{curYear}}年</h2>
        <h2 class="green" id="calendar-title">{{curMonth}}月</h2>
        <button id="pre" type="" @click="getPreviousMonth()">上个月</button> 
        <button id = "next" type="" @click="getNextMonth()"> 下个月</button>
    </div>

    <div>
        <div class="lightgrey body-list clearfix">
            <ul>
              <li v-for="(item,i) in weeks"> {{item}}</li>
            </ul>
        </div>
        <div class="darkgrey body-list">
            <ul id="days">
              <li v-for="(item,i) in showDays">{{item}}</li>
            </ul>
        </div>
    </div>
</div>
</template>

<script>
import { getDaysInMonth } from '@/utils/calendarUti.js'
export default {
    name: 'attendanceRecord',
  data(){
    return {
      weeks: ['一','二','三','四','五','六','日'],
      showDays: '',
      curYear: '',
      curMonth:'' ,
      curDay:''
    }
  },
  created(){
     this.initData()
  },
  mounted(){
   
  },
  methods: {
    initData: function() {
        //获取当前日期
        let curDate = new Date();
        this.curYear = curDate.getFullYear();
        //月份从1开始
        this.curMonth = curDate.getMonth() + 1;
        this.curDay = curDate.getDay();
        this.refreshView();
    },
    refreshView: function(){
        //获取当前显示的日期
        this.showDays = this.getDisplayDays(this.curYear,this.curMonth)
    },
    // 获取日期对应星期几
    getWeek: function(year,month,day){
        let theWeek = new Date(year,month,day).getDay()
        if(theWeek === 0) {theeWeek =7}
        return theWeek;
    },
    getDisplayDays: function(year,month){
        //获取当前月有多少天
        let daysInMonth = getDaysInMonth(year,month);
        //获取这个月第一天对应周几
        let dayStart =  this.getWeek(year,month-1,1)
        //获取这个月最后一天对应周几
        let dayEnd = this.getWeek(year,month-1,daysInMonth)

        console.log("$..........daysMonth:"+daysInMonth+",dayStart:"+dayStart+",dayEnd:"+dayEnd);
   
        let preMonth = month-1;
        let preYear = year;
        if(preMonth<1){
           preYear --;
           preMonth =12;
        }
        console.log("$...........preYear:"+preYear+",preMonth:"+preMonth);
        let preShowDays = []
        let preDaysInMonth = getDaysInMonth(preYear,preMonth);
        for(let i=0;i<dayStart-1;i++){
            preShowDays[i] = preDaysInMonth -dayStart+i+2;
        }

        let nextMonth = month +1;
        let nextYear = year;
        if(nextMonth>12){
           nextYear++;
           nextMonth = 1;
        }
        console.log("$.............nextYear:"+nextYear+",nextMonth:"+nextMonth);
        let nextShowDays =[]
        let nextDaysInMonth = getDaysInMonth(nextYear,nextMonth)
        for(let i=0;i<7-dayEnd;i++){
           nextShowDays[i]=i+1;
        }
        let daysInMonthArr = []
        for(let i=0;i<daysInMonth;i++){
           daysInMonthArr[i] =i+1;
        }
        return preShowDays.concat(daysInMonthArr).concat(nextShowDays)

    },
    getPreviousMonth: function(){
      this.curMonth--;
      if(this.curMonth<1){
        this.curYear--;
        this.curMonth = 12;
      }
      this.refreshView();
    },
    getNextMonth: function(){
      this.curMonth++;
      if(this.curMonth>12){
        this.curYear++;
        this.curMonth =1;
      }
      this.refreshView();
    }
  }
}
</script>

<style scoped>
 
    .clearfix:after{content:".";display:block;height:0;clear:both;visibility:hidden}
    .calendar{
        margin: 45px;
        width: 600px;
        height: 400px;
        background: white;
        box-shadow: 0px 1px 1px rgba(0,0,0,.1);
    }

    .title{
        height: 100px;
        border-bottom: 1px solid rgba(0,0,0,.1);
        position: relative;
        text-align: center;
    }

    #calendar-title{
        font-size: 25px;
        text-transform: uppercase;
        font-family: Arial, Helvetica, sans-serif;
        padding: 14px 0 0 0;
    }

    #calendar-year{
        font-size: 15px;
        font-family: Arial, Helvetica, sans-serif;
        font-weight: normal;
    }

    #pre{
        position: absolute;
        top: 0px;
        left: 0px;

        /*没规定大小时，图片显示 0X0*/
        width: 100px;
        height: 70px;
        
    }

    #next{
        position: absolute;
        top: 0px;
        right: 0px;
        width: 100px;
        height: 70px;
    }  

    .body-list ul{
        font-size: 14px;
        font-family: Arial, Helvetica, sans-serif;
        font-weight: bold;
        width: 100%;
        box-sizing: border-box;
  
    }  

    .body-list ul li{
        list-style: none;
        /*
        display:inline-block; 
        width: 13.3%;
        */

        /*100/7 = 14.28%*/
        display: block;
        width: 14.28%;
        float: left;

        /*规定行高，垂直居中*/
        height: 36px;
        line-height: 36px;
        box-sizing: border-box;
        text-align: center;
        
    }


    .green{
        color:#6ac13c;
    }

    .lightgrey{ /*浅灰色显示过去的日期*/
        color:#a8a8a8;
    }   
    .darkgrey{ /*深灰色显示将来的日期*/
        color:#565656;
    }

    /*日期当天用绿色背景绿色文字加以显示*/
    .greenbox{
        border: 1px solid #6ac13c;
        background: #e9f8df;
    }


</style>

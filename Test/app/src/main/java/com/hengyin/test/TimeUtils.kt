package com.hengyin.test

class TimeUtils {
    companion object{
        @JvmStatic
        fun getTimeFormat(second:Int):String{
            var temp = 0
            var sb =  StringBuffer()
            if (second > 3600) {
                temp =  (second / 3600)
                sb.append(if((second / 3600) < 10) "0${temp}m" else  "${temp}m");
                temp =  (second % 3600 / 60)
                changeSeconds(second, temp, sb)
            } else {
                temp =  (second % 3600 / 60)
                changeSeconds(second, temp, sb)
            }
            return sb.toString();
        }
       private fun changeSeconds( second:Int, temp:Int,  sb:StringBuffer) {
            sb.append(if((temp < 10)) "0${temp}m" else "${temp}m")
            var temp =  (second % 3600 % 60)
            sb.append(if(temp < 10) "0$temp" else "" + temp)
        }
    }
}
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d21f85d"],{d9d6:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{top:"0",left:"0",bottom:"0",right:"0",margin:"auto",width:"100%",height:"100%"},attrs:{id:"chart-cpu"}})},r=[],o=(a("a481"),a("bc3a")),i=a.n(o),s={name:"echarts",data:function(){return{}},mounted:function(){this.drawCpuLine()},methods:{drawCpuLine:function(){for(var t=[0],e=1;e<20;e++)t.push(0);var a=this.$echarts.init(document.getElementById("chart-cpu")),n={tooltip:{trigger:"axis",position:function(t){return[t[0],"10%"]}},title:{left:"center",text:"e3base03号主机CPU实时监控图"},toolbox:{feature:{dataZoom:{yAxisIndex:"none"},restore:{},saveAsImage:{}}},xAxis:{type:"category",boundaryGap:!1,data:function(){var t=new Date,e=[],a=20;while(a--)e.unshift(t.toLocaleTimeString().replace(/^\D*/,"")),t=new Date(t-2e3);return e}()},yAxis:{type:"value",boundaryGap:[0,"100%"]},series:[{name:"CPU使用率",type:"line",smooth:!0,symbol:"none",sampling:"average",itemStyle:{color:"rgb(255, 70, 131)"},areaStyle:{color:new this.$echarts.graphic.LinearGradient(0,0,0,1,[{offset:0,color:"rgb(255, 158, 68)"},{offset:1,color:"rgb(255, 70, 131)"}])},data:t}]};a.setOption(n),setInterval(function(){var t=(new Date).toLocaleTimeString().replace(/^\D*/,"");n.xAxis.data.shift(),n.xAxis.data.push(t);var e=n.series[0].data;i()({url:"/getCpuUsage",method:"get",params:{}}).then(function(t){var a=t.data;console.log(a),e.shift(),e.push(a.CpuUsage)}).catch(function(t){alert(t.data)}),a.setOption(n)},2100)}}},c=s,u=a("2877"),l=Object(u["a"])(c,n,r,!1,null,null,null);e["default"]=l.exports}}]);
//# sourceMappingURL=chunk-2d21f85d.04d56db9.js.map
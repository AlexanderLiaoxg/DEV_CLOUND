(function(t){function e(e){for(var r,a,u=e[0],l=e[1],c=e[2],s=0,p=[];s<u.length;s++)a=u[s],o[a]&&p.push(o[a][0]),o[a]=0;for(r in l)Object.prototype.hasOwnProperty.call(l,r)&&(t[r]=l[r]);d&&d(e);while(p.length)p.shift()();return i.push.apply(i,c||[]),n()}function n(){for(var t,e=0;e<i.length;e++){for(var n=i[e],r=!0,a=1;a<n.length;a++){var l=n[a];0!==o[l]&&(r=!1)}r&&(i.splice(e--,1),t=u(u.s=n[0]))}return t}var r={},o={app:0},i=[];function a(t){return u.p+"js/"+({}[t]||t)+"."+{"chunk-2edb2bab":"06b7987d","chunk-2d21e1d7":"117742f6","chunk-2d21f85d":"c1ca8c45","chunk-37b55e0e":"18046ae5","chunk-ab6403c2":"0c85746d"}[t]+".js"}function u(e){if(r[e])return r[e].exports;var n=r[e]={i:e,l:!1,exports:{}};return t[e].call(n.exports,n,n.exports,u),n.l=!0,n.exports}u.e=function(t){var e=[],n=o[t];if(0!==n)if(n)e.push(n[2]);else{var r=new Promise(function(e,r){n=o[t]=[e,r]});e.push(n[2]=r);var i,l=document.createElement("script");l.charset="utf-8",l.timeout=120,u.nc&&l.setAttribute("nonce",u.nc),l.src=a(t),i=function(e){l.onerror=l.onload=null,clearTimeout(c);var n=o[t];if(0!==n){if(n){var r=e&&("load"===e.type?"missing":e.type),i=e&&e.target&&e.target.src,a=new Error("Loading chunk "+t+" failed.\n("+r+": "+i+")");a.type=r,a.request=i,n[1](a)}o[t]=void 0}};var c=setTimeout(function(){i({type:"timeout",target:l})},12e4);l.onerror=l.onload=i,document.head.appendChild(l)}return Promise.all(e)},u.m=t,u.c=r,u.d=function(t,e,n){u.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:n})},u.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},u.t=function(t,e){if(1&e&&(t=u(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var n=Object.create(null);if(u.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var r in t)u.d(n,r,function(e){return t[e]}.bind(null,r));return n},u.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return u.d(e,"a",e),e},u.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},u.p="/",u.oe=function(t){throw console.error(t),t};var l=window["webpackJsonp"]=window["webpackJsonp"]||[],c=l.push.bind(l);l.push=e,l=l.slice();for(var s=0;s<l.length;s++)e(l[s]);var d=c;i.push([0,"chunk-vendors"]),n()})({0:function(t,e,n){t.exports=n("56d7")},"034f":function(t,e,n){"use strict";var r=n("64a9"),o=n.n(r);o.a},"07bb":function(t,e,n){},"2c65":function(t,e,n){"use strict";var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[t._v("廖兴广")])},o=[];n.d(e,"a",function(){return r}),n.d(e,"b",function(){return o})},"56d7":function(t,e,n){"use strict";n.r(e);n("cadf"),n("551c"),n("f751"),n("097d");var r=n("2b0e"),o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("el-container",{staticStyle:{height:"110%",position:"absolute",width:"100%",padding:"0"},attrs:{direction:"vertical"}},[n("el-header",[n("img",{staticClass:"pngfix",staticStyle:{"min-height":"30px",width:"110px","background-color":"rgb(127, 157, 182)","border-radius":"5px","padding-left":"8px","padding-right":"8px","padding-top":"2px","margin-top":"11px"},attrs:{id:"logo",onerror:"logoOnloadError();",src:"http://media.teamshub.com/10000/logo/logo.png"}})]),n("el-container",[n("el-aside",{attrs:{width:"200px",height:"600px"}},[n("div",{staticStyle:{margin:"0"},attrs:{id:"navigation"}},[n("el-menu",{staticClass:"el-menu-vertical-demo",attrs:{"default-active":"2"}},[n("el-submenu",{attrs:{index:"1"}},[n("template",{slot:"title"},[n("i",{staticClass:"el-icon-location"}),n("span",[t._v("主机性能")])]),n("el-menu-item-group",[n("template",{slot:"title"},[t._v("\n\t\t\t\t\t\t\t\t性能监控\n\t\t\t\t\t\t\t")]),n("el-menu-item",{attrs:{index:"1-1"},on:{click:t.goCpu}},[t._v("\n\t\t\t\t\t\t\t\tCPU监控\n\t\t\t\t\t\t\t")]),n("el-menu-item",{attrs:{index:"1-2"},on:{click:t.goRam}},[t._v("内存信息监控")])],2),n("el-menu-item-group",{attrs:{title:"分组2"}},[n("el-menu-item",{attrs:{index:"1-3"}},[t._v("选项3")])],1),n("el-submenu",{attrs:{index:"1-4"}},[n("template",{slot:"title"},[t._v("选项4")]),n("el-menu-item",{attrs:{index:"1-4-1"}},[t._v("选项1")])],2)],2),n("el-menu-item",{attrs:{index:"2"},on:{click:t.goHistory}},[n("i",{staticClass:"el-icon-menu"}),n("span",{attrs:{slot:"title"},slot:"title"},[t._v("历史性能")])]),n("el-menu-item",{attrs:{index:"3",disabled:""}},[n("i",{staticClass:"el-icon-document"}),n("span",{attrs:{slot:"title"},slot:"title"},[t._v("导航三")])]),n("el-menu-item",{attrs:{index:"4"}},[n("i",{staticClass:"el-icon-setting"}),n("span",{attrs:{slot:"title"},slot:"title"},[t._v("导航四")])])],1)],1)]),n("el-container",[n("el-main",[n("div",{staticStyle:{margin:"0",width:"100%",height:"100%"},attrs:{id:"app"}},[n("router-view",{staticStyle:{margin:"0",width:"100%",height:"100%"}})],1)]),n("el-footer",{staticClass:"myFooter"},[t._v("\n\t\t\t\t© 2016 北京易信掌中云科技有限公司\n\t\t\t\t"),n("span",{staticStyle:{"margin-left":"150px"}},[t._v("\n\t\t\t\t\t@author : LiaoXingGuang\n\t\t\t\t")])])],1)],1)],1)},i=[],a=(n("a481"),n("6e78")),u={name:"app",components:{HelloWorld:a["default"]},data:function(){return{isCollapse:!0}},methods:{goIndex:function(){this.$router.replace("/index")},goCpu:function(){this.$router.replace("/Cpu")},goRam:function(){this.$router.replace("/RAM")},goHistory:function(){this.$router.replace("/HistoryCpu")}}},l=u,c=(n("034f"),n("b0a0"),n("2877")),s=Object(c["a"])(l,o,i,!1,null,null,null),d=s.exports,p=n("8c4f"),f=n("7de7");r["default"].use(p["a"]);var m=[{path:"/name",name:"Name",component:f["default"]},{path:"/description",component:function(){return n.e("chunk-ab6403c2").then(n.bind(null,"160f"))}},{path:"/index",component:function(){return Promise.resolve().then(n.bind(null,"6e78"))}},{path:"/Cpu",component:function(){return Promise.all([n.e("chunk-2edb2bab"),n.e("chunk-2d21f85d")]).then(n.bind(null,"d9d6"))}},{path:"/RAM",component:function(){return Promise.all([n.e("chunk-2edb2bab"),n.e("chunk-37b55e0e")]).then(n.bind(null,"e6c7"))}},{path:"/HistoryCpu",component:function(){return Promise.all([n.e("chunk-2edb2bab"),n.e("chunk-2d21e1d7")]).then(n.bind(null,"d3d6"))}}],h=new p["a"]({routes:m}),b=p["a"].prototype.push;p["a"].prototype.push=function(t){return b.call(this,t).catch(function(t){return t})};var v=h,g=n("5c96"),y=n.n(g),x=(n("0fae"),n("313e")),_=n.n(x);r["default"].prototype.$echarts=_.a,r["default"].config.productionTip=!1,r["default"].use(y.a),new r["default"]({router:v,render:function(t){return t(d)}}).$mount("#app")},"64a9":function(t,e,n){},"6e78":function(t,e,n){"use strict";n.r(e);var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("el-row",[n("el-button",[t._v("默认按钮")]),n("el-button",{attrs:{type:"primary"}},[t._v("主要按钮")]),n("el-button",{attrs:{type:"success"}},[t._v("成功按钮")]),n("el-button",{attrs:{type:"info"}},[t._v("信息按钮")]),n("el-button",{attrs:{type:"warning"}},[t._v("警告按钮")]),n("el-button",{attrs:{type:"danger"}},[t._v("危险按钮")])],1)},o=[],i=n("2877"),a={},u=Object(i["a"])(a,r,o,!1,null,null,null);e["default"]=u.exports},"7de7":function(t,e,n){"use strict";var r=n("2c65"),o=n("9b9b"),i=n("2877"),a=Object(i["a"])(o["default"],r["a"],r["b"],!1,null,null,null);e["default"]=a.exports},"9b9b":function(t,e,n){"use strict";var r=n("c94f"),o=n.n(r);e["default"]=o.a},b0a0:function(t,e,n){"use strict";var r=n("07bb"),o=n.n(r);o.a},c94f:function(t,e){}});
//# sourceMappingURL=app.afe018c2.js.map
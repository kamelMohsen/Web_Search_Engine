(function(){/*

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/
var m;function aa(a){var b=0;return function(){return b<a.length?{done:!1,value:a[b++]}:{done:!0}}}
function p(a){var b="undefined"!=typeof Symbol&&Symbol.iterator&&a[Symbol.iterator];return b?b.call(a):{next:aa(a)}}
function ba(a){for(var b,c=[];!(b=a.next()).done;)c.push(b.value);return c}
var ca="function"==typeof Object.create?Object.create:function(a){function b(){}
b.prototype=a;return new b},da;
if("function"==typeof Object.setPrototypeOf)da=Object.setPrototypeOf;else{var ea;a:{var fa={a:!0},ha={};try{ha.__proto__=fa;ea=ha.a;break a}catch(a){}ea=!1}da=ea?function(a,b){a.__proto__=b;if(a.__proto__!==b)throw new TypeError(a+" is not extensible");return a}:null}var ia=da;
function q(a,b){a.prototype=ca(b.prototype);a.prototype.constructor=a;if(ia)ia(a,b);else for(var c in b)if("prototype"!=c)if(Object.defineProperties){var d=Object.getOwnPropertyDescriptor(b,c);d&&Object.defineProperty(a,c,d)}else a[c]=b[c];a.L=b.prototype}
var ka="function"==typeof Object.defineProperties?Object.defineProperty:function(a,b,c){if(a==Array.prototype||a==Object.prototype)return a;a[b]=c.value;return a};
function la(a){a=["object"==typeof globalThis&&globalThis,a,"object"==typeof window&&window,"object"==typeof self&&self,"object"==typeof global&&global];for(var b=0;b<a.length;++b){var c=a[b];if(c&&c.Math==Math)return c}throw Error("Cannot find global object");}
var ma=la(this);function u(a,b){if(b){for(var c=ma,d=a.split("."),e=0;e<d.length-1;e++){var f=d[e];f in c||(c[f]={});c=c[f]}d=d[d.length-1];e=c[d];f=b(e);f!=e&&null!=f&&ka(c,d,{configurable:!0,writable:!0,value:f})}}
function na(a,b,c){if(null==a)throw new TypeError("The 'this' value for String.prototype."+c+" must not be null or undefined");if(b instanceof RegExp)throw new TypeError("First argument to String.prototype."+c+" must not be a regular expression");return a+""}
u("String.prototype.endsWith",function(a){return a?a:function(b,c){var d=na(this,b,"endsWith");b+="";void 0===c&&(c=d.length);for(var e=Math.max(0,Math.min(c|0,d.length)),f=b.length;0<f&&0<e;)if(d[--e]!=b[--f])return!1;return 0>=f}});
u("String.prototype.startsWith",function(a){return a?a:function(b,c){var d=na(this,b,"startsWith");b+="";for(var e=d.length,f=b.length,h=Math.max(0,Math.min(c|0,d.length)),g=0;g<f&&h<e;)if(d[h++]!=b[g++])return!1;return g>=f}});
u("Symbol",function(a){function b(e){if(this instanceof b)throw new TypeError("Symbol is not a constructor");return new c("jscomp_symbol_"+(e||"")+"_"+d++,e)}
function c(e,f){this.f=e;ka(this,"description",{configurable:!0,writable:!0,value:f})}
if(a)return a;c.prototype.toString=function(){return this.f};
var d=0;return b});
function oa(){oa=function(){};
var a=Symbol.iterator;a||(a=Symbol.iterator=Symbol("Symbol.iterator"));"function"!=typeof Array.prototype[a]&&ka(Array.prototype,a,{configurable:!0,writable:!0,value:function(){return pa(aa(this))}})}
function pa(a){oa();a={next:a};a[Symbol.iterator]=function(){return this};
return a}
function v(a,b){return Object.prototype.hasOwnProperty.call(a,b)}
var qa="function"==typeof Object.assign?Object.assign:function(a,b){for(var c=1;c<arguments.length;c++){var d=arguments[c];if(d)for(var e in d)v(d,e)&&(a[e]=d[e])}return a};
u("Object.assign",function(a){return a||qa});
u("WeakMap",function(a){function b(k){this.f=(g+=Math.random()+1).toString();if(k){k=p(k);for(var l;!(l=k.next()).done;)l=l.value,this.set(l[0],l[1])}}
function c(){}
function d(k){var l=typeof k;return"object"===l&&null!==k||"function"===l}
function e(k){if(!v(k,h)){var l=new c;ka(k,h,{value:l})}}
function f(k){var l=Object[k];l&&(Object[k]=function(n){if(n instanceof c)return n;e(n);return l(n)})}
if(function(){if(!a||!Object.seal)return!1;try{var k=Object.seal({}),l=Object.seal({}),n=new a([[k,2],[l,3]]);if(2!=n.get(k)||3!=n.get(l))return!1;n["delete"](k);n.set(l,4);return!n.has(k)&&4==n.get(l)}catch(r){return!1}}())return a;
var h="$jscomp_hidden_"+Math.random();f("freeze");f("preventExtensions");f("seal");var g=0;b.prototype.set=function(k,l){if(!d(k))throw Error("Invalid WeakMap key");e(k);if(!v(k,h))throw Error("WeakMap key fail: "+k);k[h][this.f]=l;return this};
b.prototype.get=function(k){return d(k)&&v(k,h)?k[h][this.f]:void 0};
b.prototype.has=function(k){return d(k)&&v(k,h)&&v(k[h],this.f)};
b.prototype["delete"]=function(k){return d(k)&&v(k,h)&&v(k[h],this.f)?delete k[h][this.f]:!1};
return b});
u("Map",function(a){function b(){var g={};return g.previous=g.next=g.head=g}
function c(g,k){var l=g.f;return pa(function(){if(l){for(;l.head!=g.f;)l=l.previous;for(;l.next!=l.head;)return l=l.next,{done:!1,value:k(l)};l=null}return{done:!0,value:void 0}})}
function d(g,k){var l=k&&typeof k;"object"==l||"function"==l?f.has(k)?l=f.get(k):(l=""+ ++h,f.set(k,l)):l="p_"+k;var n=g.g[l];if(n&&v(g.g,l))for(var r=0;r<n.length;r++){var w=n[r];if(k!==k&&w.key!==w.key||k===w.key)return{id:l,list:n,index:r,u:w}}return{id:l,list:n,index:-1,u:void 0}}
function e(g){this.g={};this.f=b();this.size=0;if(g){g=p(g);for(var k;!(k=g.next()).done;)k=k.value,this.set(k[0],k[1])}}
if(function(){if(!a||"function"!=typeof a||!a.prototype.entries||"function"!=typeof Object.seal)return!1;try{var g=Object.seal({x:4}),k=new a(p([[g,"s"]]));if("s"!=k.get(g)||1!=k.size||k.get({x:4})||k.set({x:4},"t")!=k||2!=k.size)return!1;var l=k.entries(),n=l.next();if(n.done||n.value[0]!=g||"s"!=n.value[1])return!1;n=l.next();return n.done||4!=n.value[0].x||"t"!=n.value[1]||!l.next().done?!1:!0}catch(r){return!1}}())return a;
oa();var f=new WeakMap;e.prototype.set=function(g,k){g=0===g?0:g;var l=d(this,g);l.list||(l.list=this.g[l.id]=[]);l.u?l.u.value=k:(l.u={next:this.f,previous:this.f.previous,head:this.f,key:g,value:k},l.list.push(l.u),this.f.previous.next=l.u,this.f.previous=l.u,this.size++);return this};
e.prototype["delete"]=function(g){g=d(this,g);return g.u&&g.list?(g.list.splice(g.index,1),g.list.length||delete this.g[g.id],g.u.previous.next=g.u.next,g.u.next.previous=g.u.previous,g.u.head=null,this.size--,!0):!1};
e.prototype.clear=function(){this.g={};this.f=this.f.previous=b();this.size=0};
e.prototype.has=function(g){return!!d(this,g).u};
e.prototype.get=function(g){return(g=d(this,g).u)&&g.value};
e.prototype.entries=function(){return c(this,function(g){return[g.key,g.value]})};
e.prototype.keys=function(){return c(this,function(g){return g.key})};
e.prototype.values=function(){return c(this,function(g){return g.value})};
e.prototype.forEach=function(g,k){for(var l=this.entries(),n;!(n=l.next()).done;)n=n.value,g.call(k,n[1],n[0],this)};
e.prototype[Symbol.iterator]=e.prototype.entries;var h=0;return e});
u("Object.entries",function(a){return a?a:function(b){var c=[],d;for(d in b)v(b,d)&&c.push([d,b[d]]);return c}});
u("Set",function(a){function b(c){this.f=new Map;if(c){c=p(c);for(var d;!(d=c.next()).done;)this.add(d.value)}this.size=this.f.size}
if(function(){if(!a||"function"!=typeof a||!a.prototype.entries||"function"!=typeof Object.seal)return!1;try{var c=Object.seal({x:4}),d=new a(p([c]));if(!d.has(c)||1!=d.size||d.add(c)!=d||1!=d.size||d.add({x:4})!=d||2!=d.size)return!1;var e=d.entries(),f=e.next();if(f.done||f.value[0]!=c||f.value[1]!=c)return!1;f=e.next();return f.done||f.value[0]==c||4!=f.value[0].x||f.value[1]!=f.value[0]?!1:e.next().done}catch(h){return!1}}())return a;
oa();b.prototype.add=function(c){c=0===c?0:c;this.f.set(c,c);this.size=this.f.size;return this};
b.prototype["delete"]=function(c){c=this.f["delete"](c);this.size=this.f.size;return c};
b.prototype.clear=function(){this.f.clear();this.size=0};
b.prototype.has=function(c){return this.f.has(c)};
b.prototype.entries=function(){return this.f.entries()};
b.prototype.values=function(){return this.f.values()};
b.prototype.keys=b.prototype.values;b.prototype[Symbol.iterator]=b.prototype.values;b.prototype.forEach=function(c,d){var e=this;this.f.forEach(function(f){return c.call(d,f,f,e)})};
return b});
u("String.prototype.includes",function(a){return a?a:function(b,c){return-1!==na(this,b,"includes").indexOf(b,c||0)}});
var ra=function(){function a(){function c(){}
new c;Reflect.construct(c,[],function(){});
return new c instanceof c}
if("undefined"!=typeof Reflect&&Reflect.construct){if(a())return Reflect.construct;var b=Reflect.construct;return function(c,d,e){c=b(c,d);e&&Reflect.setPrototypeOf(c,e.prototype);return c}}return function(c,d,e){void 0===e&&(e=c);
e=ca(e.prototype||Object.prototype);return Function.prototype.apply.call(c,e,d)||e}}();
u("Reflect.construct",function(){return ra});
var x=this||self;function y(a,b,c){a=a.split(".");c=c||x;a[0]in c||"undefined"==typeof c.execScript||c.execScript("var "+a[0]);for(var d;a.length&&(d=a.shift());)a.length||void 0===b?c[d]&&c[d]!==Object.prototype[d]?c=c[d]:c=c[d]={}:c[d]=b}
var sa=/^[\w+/_-]+[=]{0,2}$/,ta=null;function ua(a){return(a=a.querySelector&&a.querySelector("script[nonce]"))&&(a=a.nonce||a.getAttribute("nonce"))&&sa.test(a)?a:""}
function z(a,b){for(var c=a.split("."),d=b||x,e=0;e<c.length;e++)if(d=d[c[e]],null==d)return null;return d}
function va(){}
function wa(a){a.ha=void 0;a.getInstance=function(){return a.ha?a.ha:a.ha=new a}}
function xa(a){var b=typeof a;if("object"==b)if(a){if(a instanceof Array)return"array";if(a instanceof Object)return b;var c=Object.prototype.toString.call(a);if("[object Window]"==c)return"object";if("[object Array]"==c||"number"==typeof a.length&&"undefined"!=typeof a.splice&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("splice"))return"array";if("[object Function]"==c||"undefined"!=typeof a.call&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("call"))return"function"}else return"null";
else if("function"==b&&"undefined"==typeof a.call)return"object";return b}
function ya(a){var b=xa(a);return"array"==b||"object"==b&&"number"==typeof a.length}
function A(a){return"function"==xa(a)}
function za(a){var b=typeof a;return"object"==b&&null!=a||"function"==b}
function Aa(a){return Object.prototype.hasOwnProperty.call(a,Ba)&&a[Ba]||(a[Ba]=++Ca)}
var Ba="closure_uid_"+(1E9*Math.random()>>>0),Ca=0;function Da(a,b,c){return a.call.apply(a.bind,arguments)}
function Ea(a,b,c){if(!a)throw Error();if(2<arguments.length){var d=Array.prototype.slice.call(arguments,2);return function(){var e=Array.prototype.slice.call(arguments);Array.prototype.unshift.apply(e,d);return a.apply(b,e)}}return function(){return a.apply(b,arguments)}}
function B(a,b,c){Function.prototype.bind&&-1!=Function.prototype.bind.toString().indexOf("native code")?B=Da:B=Ea;return B.apply(null,arguments)}
function Fa(a,b){var c=Array.prototype.slice.call(arguments,1);return function(){var d=c.slice();d.push.apply(d,arguments);return a.apply(this,d)}}
var C=Date.now||function(){return+new Date};
function Ga(a,b){y(a,b,void 0)}
function D(a,b){function c(){}
c.prototype=b.prototype;a.L=b.prototype;a.prototype=new c;a.prototype.constructor=a}
;function Ha(a,b){if(!a||/[?&]dsh=1(&|$)/.test(a))return null;if(/[?&]ae=1(&|$)/.test(a)){var c=/[?&]adurl=([^&]+)/.exec(a);if(!c)return null;var d=b?c.index:a.length;try{return{wa:a.slice(0,d)+"&act=1"+a.slice(d),ya:decodeURIComponent(c[1])}}catch(f){return null}}if(/[?&]ae=2(&|$)/.test(a)){c=a;d="";if(b){var e=a.indexOf("&adurl=");0<e&&(c=a.slice(0,e),d=a.slice(e))}return{wa:c+"&act=1"+d,ya:c+"&dct=1"+d}}return null}
;function E(a){if(Error.captureStackTrace)Error.captureStackTrace(this,E);else{var b=Error().stack;b&&(this.stack=b)}a&&(this.message=String(a))}
D(E,Error);E.prototype.name="CustomError";function Ja(a){var b=a.url,c=a.ub;this.j=!!a.ab;this.g=Ha(b,c);a=/[?&]dsh=1(&|$)/.test(b);this.h=!a&&/[?&]ae=1(&|$)/.test(b);this.i=!a&&/[?&]ae=2(&|$)/.test(b);this.f=/[?&]adurl=([^&]*)/.exec(b)}
;var Ka=Array.prototype.indexOf?function(a,b){return Array.prototype.indexOf.call(a,b,void 0)}:function(a,b){if("string"===typeof a)return"string"!==typeof b||1!=b.length?-1:a.indexOf(b,0);
for(var c=0;c<a.length;c++)if(c in a&&a[c]===b)return c;return-1},F=Array.prototype.forEach?function(a,b,c){Array.prototype.forEach.call(a,b,c)}:function(a,b,c){for(var d=a.length,e="string"===typeof a?a.split(""):a,f=0;f<d;f++)f in e&&b.call(c,e[f],f,a)},La=Array.prototype.filter?function(a,b){return Array.prototype.filter.call(a,b,void 0)}:function(a,b){for(var c=a.length,d=[],e=0,f="string"===typeof a?a.split(""):a,h=0;h<c;h++)if(h in f){var g=f[h];
b.call(void 0,g,h,a)&&(d[e++]=g)}return d},Ma=Array.prototype.map?function(a,b){return Array.prototype.map.call(a,b,void 0)}:function(a,b){for(var c=a.length,d=Array(c),e="string"===typeof a?a.split(""):a,f=0;f<c;f++)f in e&&(d[f]=b.call(void 0,e[f],f,a));
return d},Na=Array.prototype.reduce?function(a,b,c){return Array.prototype.reduce.call(a,b,c)}:function(a,b,c){var d=c;
F(a,function(e,f){d=b.call(void 0,d,e,f,a)});
return d};
function Oa(a,b){a:{var c=a.length;for(var d="string"===typeof a?a.split(""):a,e=0;e<c;e++)if(e in d&&b.call(void 0,d[e],e,a)){c=e;break a}c=-1}return 0>c?null:"string"===typeof a?a.charAt(c):a[c]}
function Pa(a,b){var c=Ka(a,b);0<=c&&Array.prototype.splice.call(a,c,1)}
function Qa(a){var b=a.length;if(0<b){for(var c=Array(b),d=0;d<b;d++)c[d]=a[d];return c}return[]}
function Ra(a,b){for(var c=1;c<arguments.length;c++){var d=arguments[c];if(ya(d)){var e=a.length||0,f=d.length||0;a.length=e+f;for(var h=0;h<f;h++)a[e+h]=d[h]}else a.push(d)}}
;function Sa(a){var b=!1,c;return function(){b||(c=a(),b=!0);return c}}
;function Ta(a,b){for(var c in a)b.call(void 0,a[c],c,a)}
function Ua(a,b){var c=ya(b),d=c?b:arguments;for(c=c?0:1;c<d.length;c++){if(null==a)return;a=a[d[c]]}return a}
function Va(a){var b=Wa,c;for(c in b)if(a.call(void 0,b[c],c,b))return c}
function Xa(a){for(var b in a)return!1;return!0}
function Ya(a,b){if(null!==a&&b in a)throw Error('The object already contains the key "'+b+'"');a[b]=!0}
function Za(a,b){for(var c in a)if(!(c in b)||a[c]!==b[c])return!1;for(var d in b)if(!(d in a))return!1;return!0}
function $a(a){var b={},c;for(c in a)b[c]=a[c];return b}
function ab(a){var b=xa(a);if("object"==b||"array"==b){if(A(a.clone))return a.clone();b="array"==b?[]:{};for(var c in a)b[c]=ab(a[c]);return b}return a}
var bb="constructor hasOwnProperty isPrototypeOf propertyIsEnumerable toLocaleString toString valueOf".split(" ");function cb(a,b){for(var c,d,e=1;e<arguments.length;e++){d=arguments[e];for(c in d)a[c]=d[c];for(var f=0;f<bb.length;f++)c=bb[f],Object.prototype.hasOwnProperty.call(d,c)&&(a[c]=d[c])}}
;function db(a,b){this.f=a===eb&&b||"";this.g=fb}
db.prototype.K=!0;db.prototype.J=function(){return this.f.toString()};
db.prototype.ga=!0;db.prototype.da=function(){return 1};
function gb(a){if(a instanceof db&&a.constructor===db&&a.g===fb)return a.f;xa(a);return"type_error:TrustedResourceUrl"}
var fb={},eb={};var hb=String.prototype.trim?function(a){return a.trim()}:function(a){return/^[\s\xa0]*([\s\S]*?)[\s\xa0]*$/.exec(a)[1]};
function ib(a,b){if(b)a=a.replace(jb,"&amp;").replace(kb,"&lt;").replace(lb,"&gt;").replace(mb,"&quot;").replace(nb,"&#39;").replace(ob,"&#0;");else{if(!pb.test(a))return a;-1!=a.indexOf("&")&&(a=a.replace(jb,"&amp;"));-1!=a.indexOf("<")&&(a=a.replace(kb,"&lt;"));-1!=a.indexOf(">")&&(a=a.replace(lb,"&gt;"));-1!=a.indexOf('"')&&(a=a.replace(mb,"&quot;"));-1!=a.indexOf("'")&&(a=a.replace(nb,"&#39;"));-1!=a.indexOf("\x00")&&(a=a.replace(ob,"&#0;"))}return a}
var jb=/&/g,kb=/</g,lb=/>/g,mb=/"/g,nb=/'/g,ob=/\x00/g,pb=/[\x00&<>"']/;function H(a,b){this.f=a===qb&&b||"";this.g=rb}
H.prototype.K=!0;H.prototype.J=function(){return this.f.toString()};
H.prototype.ga=!0;H.prototype.da=function(){return 1};
function sb(a){if(a instanceof H&&a.constructor===H&&a.g===rb)return a.f;xa(a);return"type_error:SafeUrl"}
var tb=/^(?:(?:https?|mailto|ftp):|[^:/?#]*(?:[/?#]|$))/i;function ub(a){if(a instanceof H)return a;a="object"==typeof a&&a.K?a.J():String(a);tb.test(a)||(a="about:invalid#zClosurez");return new H(qb,a)}
var rb={},qb={};var vb;a:{var wb=x.navigator;if(wb){var xb=wb.userAgent;if(xb){vb=xb;break a}}vb=""}function I(a){return-1!=vb.indexOf(a)}
;function yb(){this.f="";this.h=zb;this.g=null}
yb.prototype.ga=!0;yb.prototype.da=function(){return this.g};
yb.prototype.K=!0;yb.prototype.J=function(){return this.f.toString()};
var zb={};function Ab(a,b){var c=new yb;c.f=a;c.g=b;return c}
;function Bb(a,b){var c=b instanceof H?b:ub(b);a.href=sb(c)}
function Cb(a,b){a.src=gb(b);var c;(c=a.ownerDocument&&a.ownerDocument.defaultView)&&c!=x?c=ua(c.document):(null===ta&&(ta=ua(x.document)),c=ta);c&&a.setAttribute("nonce",c)}
;function Db(a){return a=ib(a,void 0)}
function Eb(a){for(var b=0,c=0;c<a.length;++c)b=31*b+a.charCodeAt(c)>>>0;return b}
;var Gb=/^(?:([^:/?#.]+):)?(?:\/\/(?:([^\\/?#]*)@)?([^\\/?#]*?)(?::([0-9]+))?(?=[\\/?#]|$))?([^?#]+)?(?:\?([^#]*))?(?:#([\s\S]*))?$/;function J(a){return a?decodeURI(a):a}
function K(a,b){return b.match(Gb)[a]||null}
function Hb(a,b,c){if(Array.isArray(b))for(var d=0;d<b.length;d++)Hb(a,String(b[d]),c);else null!=b&&c.push(a+(""===b?"":"="+encodeURIComponent(String(b))))}
function Ib(a){var b=[],c;for(c in a)Hb(c,a[c],b);return b.join("&")}
function Jb(a,b){var c=Ib(b);if(c){var d=a.indexOf("#");0>d&&(d=a.length);var e=a.indexOf("?");if(0>e||e>d){e=d;var f=""}else f=a.substring(e+1,d);d=[a.substr(0,e),f,a.substr(d)];e=d[1];d[1]=c?e?e+"&"+c:c:e;c=d[0]+(d[1]?"?"+d[1]:"")+d[2]}else c=a;return c}
var Kb=/#|$/;function Lb(a,b){var c=a.search(Kb);a:{var d=0;for(var e=b.length;0<=(d=a.indexOf(b,d))&&d<c;){var f=a.charCodeAt(d-1);if(38==f||63==f)if(f=a.charCodeAt(d+e),!f||61==f||38==f||35==f)break a;d+=e+1}d=-1}if(0>d)return null;e=a.indexOf("&",d);if(0>e||e>c)e=c;d+=b.length+1;return decodeURIComponent(a.substr(d,e-d).replace(/\+/g," "))}
;var Mb=I("Opera"),Nb=I("Trident")||I("MSIE"),Ob=I("Edge"),Pb=I("Gecko")&&!(-1!=vb.toLowerCase().indexOf("webkit")&&!I("Edge"))&&!(I("Trident")||I("MSIE"))&&!I("Edge"),Qb=-1!=vb.toLowerCase().indexOf("webkit")&&!I("Edge");function Rb(){var a=x.document;return a?a.documentMode:void 0}
var Sb;a:{var Tb="",Ub=function(){var a=vb;if(Pb)return/rv:([^\);]+)(\)|;)/.exec(a);if(Ob)return/Edge\/([\d\.]+)/.exec(a);if(Nb)return/\b(?:MSIE|rv)[: ]([^\);]+)(\)|;)/.exec(a);if(Qb)return/WebKit\/(\S+)/.exec(a);if(Mb)return/(?:Version)[ \/]?(\S+)/.exec(a)}();
Ub&&(Tb=Ub?Ub[1]:"");if(Nb){var Vb=Rb();if(null!=Vb&&Vb>parseFloat(Tb)){Sb=String(Vb);break a}}Sb=Tb}var Wb=Sb,Xb;if(x.document&&Nb){var Yb=Rb();Xb=Yb?Yb:parseInt(Wb,10)||void 0}else Xb=void 0;var Zb=Xb;var $b={},ac=null;var L=window;function bc(a){var b=z("window.location.href");null==a&&(a='Unknown Error of type "null/undefined"');if("string"===typeof a)return{message:a,name:"Unknown error",lineNumber:"Not available",fileName:b,stack:"Not available"};var c=!1;try{var d=a.lineNumber||a.line||"Not available"}catch(f){d="Not available",c=!0}try{var e=a.fileName||a.filename||a.sourceURL||x.$googDebugFname||b}catch(f){e="Not available",c=!0}return!c&&a.lineNumber&&a.fileName&&a.stack&&a.message&&a.name?a:(b=a.message,null==b&&(a.constructor&&
a.constructor instanceof Function?(a.constructor.name?b=a.constructor.name:(b=a.constructor,cc[b]?b=cc[b]:(b=String(b),cc[b]||(c=/function\s+([^\(]+)/m.exec(b),cc[b]=c?c[1]:"[Anonymous]"),b=cc[b])),b='Unknown Error of type "'+b+'"'):b="Unknown Error of unknown type"),{message:b,name:a.name||"UnknownError",lineNumber:d,fileName:e,stack:a.stack||"Not available"})}
var cc={};function dc(a){this.f=a||{cookie:""}}
m=dc.prototype;m.isEnabled=function(){return navigator.cookieEnabled};
m.set=function(a,b,c){var d=!1;if("object"===typeof c){var e=c.wb;d=c.secure||!1;var f=c.domain||void 0;var h=c.path||void 0;var g=c.la}if(/[;=\s]/.test(a))throw Error('Invalid cookie name "'+a+'"');if(/[;\r\n]/.test(b))throw Error('Invalid cookie value "'+b+'"');void 0===g&&(g=-1);c=f?";domain="+f:"";h=h?";path="+h:"";d=d?";secure":"";g=0>g?"":0==g?";expires="+(new Date(1970,1,1)).toUTCString():";expires="+(new Date(C()+1E3*g)).toUTCString();this.f.cookie=a+"="+b+c+h+g+d+(null!=e?";samesite="+e:
"")};
m.get=function(a,b){for(var c=a+"=",d=(this.f.cookie||"").split(";"),e=0,f;e<d.length;e++){f=hb(d[e]);if(0==f.lastIndexOf(c,0))return f.substr(c.length);if(f==a)return""}return b};
m.remove=function(a,b,c){var d=void 0!==this.get(a);this.set(a,"",{la:0,path:b,domain:c});return d};
m.isEmpty=function(){return!this.f.cookie};
m.clear=function(){for(var a=(this.f.cookie||"").split(";"),b=[],c=[],d,e,f=0;f<a.length;f++)e=hb(a[f]),d=e.indexOf("="),-1==d?(b.push(""),c.push(e)):(b.push(e.substring(0,d)),c.push(e.substring(d+1)));for(a=b.length-1;0<=a;a--)this.remove(b[a])};
var ec=new dc("undefined"==typeof document?null:document);var fc=!Nb||9<=Number(Zb);function gc(a,b){this.x=void 0!==a?a:0;this.y=void 0!==b?b:0}
m=gc.prototype;m.clone=function(){return new gc(this.x,this.y)};
m.equals=function(a){return a instanceof gc&&(this==a?!0:this&&a?this.x==a.x&&this.y==a.y:!1)};
m.ceil=function(){this.x=Math.ceil(this.x);this.y=Math.ceil(this.y);return this};
m.floor=function(){this.x=Math.floor(this.x);this.y=Math.floor(this.y);return this};
m.round=function(){this.x=Math.round(this.x);this.y=Math.round(this.y);return this};function hc(a,b){this.width=a;this.height=b}
m=hc.prototype;m.clone=function(){return new hc(this.width,this.height)};
m.aspectRatio=function(){return this.width/this.height};
m.isEmpty=function(){return!(this.width*this.height)};
m.ceil=function(){this.width=Math.ceil(this.width);this.height=Math.ceil(this.height);return this};
m.floor=function(){this.width=Math.floor(this.width);this.height=Math.floor(this.height);return this};
m.round=function(){this.width=Math.round(this.width);this.height=Math.round(this.height);return this};function ic(a){var b=document;return"string"===typeof a?b.getElementById(a):a}
function jc(a,b){Ta(b,function(c,d){c&&"object"==typeof c&&c.K&&(c=c.J());"style"==d?a.style.cssText=c:"class"==d?a.className=c:"for"==d?a.htmlFor=c:kc.hasOwnProperty(d)?a.setAttribute(kc[d],c):0==d.lastIndexOf("aria-",0)||0==d.lastIndexOf("data-",0)?a.setAttribute(d,c):a[d]=c})}
var kc={cellpadding:"cellPadding",cellspacing:"cellSpacing",colspan:"colSpan",frameborder:"frameBorder",height:"height",maxlength:"maxLength",nonce:"nonce",role:"role",rowspan:"rowSpan",type:"type",usemap:"useMap",valign:"vAlign",width:"width"};
function lc(a,b,c){var d=arguments,e=document,f=String(d[0]),h=d[1];if(!fc&&h&&(h.name||h.type)){f=["<",f];h.name&&f.push(' name="',Db(h.name),'"');if(h.type){f.push(' type="',Db(h.type),'"');var g={};cb(g,h);delete g.type;h=g}f.push(">");f=f.join("")}f=mc(e,f);h&&("string"===typeof h?f.className=h:Array.isArray(h)?f.className=h.join(" "):jc(f,h));2<d.length&&nc(e,f,d);return f}
function nc(a,b,c){function d(h){h&&b.appendChild("string"===typeof h?a.createTextNode(h):h)}
for(var e=2;e<c.length;e++){var f=c[e];!ya(f)||za(f)&&0<f.nodeType?d(f):F(oc(f)?Qa(f):f,d)}}
function mc(a,b){b=String(b);"application/xhtml+xml"===a.contentType&&(b=b.toLowerCase());return a.createElement(b)}
function oc(a){if(a&&"number"==typeof a.length){if(za(a))return"function"==typeof a.item||"string"==typeof a.item;if(A(a))return"function"==typeof a.item}return!1}
function pc(a,b){for(var c=0;a;){if(b(a))return a;a=a.parentNode;c++}return null}
;function qc(a){rc();return new db(eb,a)}
var rc=va;function sc(a){var b=tc;if(b)for(var c in b)Object.prototype.hasOwnProperty.call(b,c)&&a.call(void 0,b[c],c,b)}
function uc(){var a=[];sc(function(b){a.push(b)});
return a}
var tc={bb:"allow-forms",cb:"allow-modals",eb:"allow-orientation-lock",fb:"allow-pointer-lock",gb:"allow-popups",hb:"allow-popups-to-escape-sandbox",ib:"allow-presentation",jb:"allow-same-origin",kb:"allow-scripts",lb:"allow-top-navigation",mb:"allow-top-navigation-by-user-activation"},vc=Sa(function(){return uc()});
function wc(){var a=mc(document,"IFRAME"),b={};F(vc(),function(c){a.sandbox&&a.sandbox.supports&&a.sandbox.supports(c)&&(b[c]=!0)});
return b}
;function M(){this.g=this.g;this.C=this.C}
M.prototype.g=!1;M.prototype.dispose=function(){this.g||(this.g=!0,this.o())};
function xc(a,b){a.g?b():(a.C||(a.C=[]),a.C.push(b))}
M.prototype.o=function(){if(this.C)for(;this.C.length;)this.C.shift()()};
function yc(a){a&&"function"==typeof a.dispose&&a.dispose()}
function zc(a){for(var b=0,c=arguments.length;b<c;++b){var d=arguments[b];ya(d)?zc.apply(null,d):yc(d)}}
;function Ac(a){"number"==typeof a&&(a=Math.round(a)+"px");return a}
;var Bc=(new Date).getTime();function Cc(a){if(!a)return"";a=a.split("#")[0].split("?")[0];a=a.toLowerCase();0==a.indexOf("//")&&(a=window.location.protocol+a);/^[\w\-]*:\/\//.test(a)||(a=window.location.href);var b=a.substring(a.indexOf("://")+3),c=b.indexOf("/");-1!=c&&(b=b.substring(0,c));a=a.substring(0,a.indexOf("://"));if("http"!==a&&"https"!==a&&"chrome-extension"!==a&&"file"!==a&&"android-app"!==a&&"chrome-search"!==a&&"chrome-untrusted"!==a&&"chrome"!==a&&"app"!==a)throw Error("Invalid URI scheme in origin: "+a);c="";
var d=b.indexOf(":");if(-1!=d){var e=b.substring(d+1);b=b.substring(0,d);if("http"===a&&"80"!==e||"https"===a&&"443"!==e)c=":"+e}return a+"://"+b+c}
;function Dc(){function a(){e[0]=1732584193;e[1]=4023233417;e[2]=2562383102;e[3]=271733878;e[4]=3285377520;n=l=0}
function b(r){for(var w=h,t=0;64>t;t+=4)w[t/4]=r[t]<<24|r[t+1]<<16|r[t+2]<<8|r[t+3];for(t=16;80>t;t++)r=w[t-3]^w[t-8]^w[t-14]^w[t-16],w[t]=(r<<1|r>>>31)&4294967295;r=e[0];var G=e[1],X=e[2],ja=e[3],Qc=e[4];for(t=0;80>t;t++){if(40>t)if(20>t){var Ia=ja^G&(X^ja);var Fb=1518500249}else Ia=G^X^ja,Fb=1859775393;else 60>t?(Ia=G&X|ja&(G|X),Fb=2400959708):(Ia=G^X^ja,Fb=3395469782);Ia=((r<<5|r>>>27)&4294967295)+Ia+Qc+Fb+w[t]&4294967295;Qc=ja;ja=X;X=(G<<30|G>>>2)&4294967295;G=r;r=Ia}e[0]=e[0]+r&4294967295;e[1]=
e[1]+G&4294967295;e[2]=e[2]+X&4294967295;e[3]=e[3]+ja&4294967295;e[4]=e[4]+Qc&4294967295}
function c(r,w){if("string"===typeof r){r=unescape(encodeURIComponent(r));for(var t=[],G=0,X=r.length;G<X;++G)t.push(r.charCodeAt(G));r=t}w||(w=r.length);t=0;if(0==l)for(;t+64<w;)b(r.slice(t,t+64)),t+=64,n+=64;for(;t<w;)if(f[l++]=r[t++],n++,64==l)for(l=0,b(f);t+64<w;)b(r.slice(t,t+64)),t+=64,n+=64}
function d(){var r=[],w=8*n;56>l?c(g,56-l):c(g,64-(l-56));for(var t=63;56<=t;t--)f[t]=w&255,w>>>=8;b(f);for(t=w=0;5>t;t++)for(var G=24;0<=G;G-=8)r[w++]=e[t]>>G&255;return r}
for(var e=[],f=[],h=[],g=[128],k=1;64>k;++k)g[k]=0;var l,n;a();return{reset:a,update:c,digest:d,xa:function(){for(var r=d(),w="",t=0;t<r.length;t++)w+="0123456789ABCDEF".charAt(Math.floor(r[t]/16))+"0123456789ABCDEF".charAt(r[t]%16);return w}}}
;function Ec(a,b,c){var d=[],e=[];if(1==(Array.isArray(c)?2:1))return e=[b,a],F(d,function(g){e.push(g)}),Fc(e.join(" "));
var f=[],h=[];F(c,function(g){h.push(g.key);f.push(g.value)});
c=Math.floor((new Date).getTime()/1E3);e=0==f.length?[c,b,a]:[f.join(":"),c,b,a];F(d,function(g){e.push(g)});
a=Fc(e.join(" "));a=[c,a];0==h.length||a.push(h.join(""));return a.join("_")}
function Fc(a){var b=Dc();b.update(a);return b.xa().toLowerCase()}
;function Gc(a){var b=Cc(String(x.location.href)),c;(c=x.__SAPISID||x.__APISID||x.__OVERRIDE_SID)?c=!0:(c=new dc(document),c=c.get("SAPISID")||c.get("APISID")||c.get("__Secure-3PAPISID")||c.get("SID"),c=!!c);if(c&&(c=(b=0==b.indexOf("https:")||0==b.indexOf("chrome-extension:"))?x.__SAPISID:x.__APISID,c||(c=new dc(document),c=c.get(b?"SAPISID":"APISID")||c.get("__Secure-3PAPISID")),c)){b=b?"SAPISIDHASH":"APISIDHASH";var d=String(x.location.href);return d&&c&&b?[b,Ec(Cc(d),c,a||null)].join(" "):null}return null}
;function Hc(){this.g=[];this.f=-1}
Hc.prototype.set=function(a,b){b=void 0===b?!0:b;0<=a&&52>a&&0===a%1&&this.g[a]!=b&&(this.g[a]=b,this.f=-1)};
Hc.prototype.get=function(a){return!!this.g[a]};
function Ic(a){-1==a.f&&(a.f=Na(a.g,function(b,c,d){return c?b+Math.pow(2,d):b},0));
return a.f}
;function Jc(a,b){this.h=a;this.i=b;this.g=0;this.f=null}
Jc.prototype.get=function(){if(0<this.g){this.g--;var a=this.f;this.f=a.next;a.next=null}else a=this.h();return a};
function Kc(a,b){a.i(b);100>a.g&&(a.g++,b.next=a.f,a.f=b)}
;function Lc(a){x.setTimeout(function(){throw a;},0)}
var Mc;
function Nc(){var a=x.MessageChannel;"undefined"===typeof a&&"undefined"!==typeof window&&window.postMessage&&window.addEventListener&&!I("Presto")&&(a=function(){var e=mc(document,"IFRAME");e.style.display="none";document.documentElement.appendChild(e);var f=e.contentWindow;e=f.document;e.open();e.close();var h="callImmediate"+Math.random(),g="file:"==f.location.protocol?"*":f.location.protocol+"//"+f.location.host;e=B(function(k){if(("*"==g||k.origin==g)&&k.data==h)this.port1.onmessage()},this);
f.addEventListener("message",e,!1);this.port1={};this.port2={postMessage:function(){f.postMessage(h,g)}}});
if("undefined"!==typeof a&&!I("Trident")&&!I("MSIE")){var b=new a,c={},d=c;b.port1.onmessage=function(){if(void 0!==c.next){c=c.next;var e=c.ka;c.ka=null;e()}};
return function(e){d.next={ka:e};d=d.next;b.port2.postMessage(0)}}return function(e){x.setTimeout(e,0)}}
;function Oc(){this.g=this.f=null}
var Rc=new Jc(function(){return new Pc},function(a){a.reset()});
Oc.prototype.add=function(a,b){var c=Rc.get();c.set(a,b);this.g?this.g.next=c:this.f=c;this.g=c};
Oc.prototype.remove=function(){var a=null;this.f&&(a=this.f,this.f=this.f.next,this.f||(this.g=null),a.next=null);return a};
function Pc(){this.next=this.scope=this.f=null}
Pc.prototype.set=function(a,b){this.f=a;this.scope=b;this.next=null};
Pc.prototype.reset=function(){this.next=this.scope=this.f=null};function Sc(a,b){Tc||Uc();Vc||(Tc(),Vc=!0);Wc.add(a,b)}
var Tc;function Uc(){if(x.Promise&&x.Promise.resolve){var a=x.Promise.resolve(void 0);Tc=function(){a.then(Xc)}}else Tc=function(){var b=Xc;
!A(x.setImmediate)||x.Window&&x.Window.prototype&&!I("Edge")&&x.Window.prototype.setImmediate==x.setImmediate?(Mc||(Mc=Nc()),Mc(b)):x.setImmediate(b)}}
var Vc=!1,Wc=new Oc;function Xc(){for(var a;a=Wc.remove();){try{a.f.call(a.scope)}catch(b){Lc(b)}Kc(Rc,a)}Vc=!1}
;function Yc(){this.g=-1}
;function Zc(){this.g=64;this.f=[];this.l=[];this.m=[];this.i=[];this.i[0]=128;for(var a=1;a<this.g;++a)this.i[a]=0;this.j=this.h=0;this.reset()}
D(Zc,Yc);Zc.prototype.reset=function(){this.f[0]=1732584193;this.f[1]=4023233417;this.f[2]=2562383102;this.f[3]=271733878;this.f[4]=3285377520;this.j=this.h=0};
function $c(a,b,c){c||(c=0);var d=a.m;if("string"===typeof b)for(var e=0;16>e;e++)d[e]=b.charCodeAt(c)<<24|b.charCodeAt(c+1)<<16|b.charCodeAt(c+2)<<8|b.charCodeAt(c+3),c+=4;else for(e=0;16>e;e++)d[e]=b[c]<<24|b[c+1]<<16|b[c+2]<<8|b[c+3],c+=4;for(e=16;80>e;e++){var f=d[e-3]^d[e-8]^d[e-14]^d[e-16];d[e]=(f<<1|f>>>31)&4294967295}b=a.f[0];c=a.f[1];var h=a.f[2],g=a.f[3],k=a.f[4];for(e=0;80>e;e++){if(40>e)if(20>e){f=g^c&(h^g);var l=1518500249}else f=c^h^g,l=1859775393;else 60>e?(f=c&h|g&(c|h),l=2400959708):
(f=c^h^g,l=3395469782);f=(b<<5|b>>>27)+f+k+l+d[e]&4294967295;k=g;g=h;h=(c<<30|c>>>2)&4294967295;c=b;b=f}a.f[0]=a.f[0]+b&4294967295;a.f[1]=a.f[1]+c&4294967295;a.f[2]=a.f[2]+h&4294967295;a.f[3]=a.f[3]+g&4294967295;a.f[4]=a.f[4]+k&4294967295}
Zc.prototype.update=function(a,b){if(null!=a){void 0===b&&(b=a.length);for(var c=b-this.g,d=0,e=this.l,f=this.h;d<b;){if(0==f)for(;d<=c;)$c(this,a,d),d+=this.g;if("string"===typeof a)for(;d<b;){if(e[f]=a.charCodeAt(d),++f,++d,f==this.g){$c(this,e);f=0;break}}else for(;d<b;)if(e[f]=a[d],++f,++d,f==this.g){$c(this,e);f=0;break}}this.h=f;this.j+=b}};
Zc.prototype.digest=function(){var a=[],b=8*this.j;56>this.h?this.update(this.i,56-this.h):this.update(this.i,this.g-(this.h-56));for(var c=this.g-1;56<=c;c--)this.l[c]=b&255,b/=256;$c(this,this.l);for(c=b=0;5>c;c++)for(var d=24;0<=d;d-=8)a[b]=this.f[c]>>d&255,++b;return a};function ad(a){return"string"==typeof a.className?a.className:a.getAttribute&&a.getAttribute("class")||""}
function bd(a,b){"string"==typeof a.className?a.className=b:a.setAttribute&&a.setAttribute("class",b)}
function cd(a,b){if(a.classList)var c=a.classList.contains(b);else c=a.classList?a.classList:ad(a).match(/\S+/g)||[],c=0<=Ka(c,b);return c}
function dd(){var a=document.body;a.classList?a.classList.remove("inverted-hdpi"):cd(a,"inverted-hdpi")&&bd(a,La(a.classList?a.classList:ad(a).match(/\S+/g)||[],function(b){return"inverted-hdpi"!=b}).join(" "))}
;var ed="StopIteration"in x?x.StopIteration:{message:"StopIteration",stack:""};function fd(){}
fd.prototype.next=function(){throw ed;};
fd.prototype.D=function(){return this};
function gd(a){if(a instanceof fd)return a;if("function"==typeof a.D)return a.D(!1);if(ya(a)){var b=0,c=new fd;c.next=function(){for(;;){if(b>=a.length)throw ed;if(b in a)return a[b++];b++}};
return c}throw Error("Not implemented");}
function hd(a,b){if(ya(a))try{F(a,b,void 0)}catch(c){if(c!==ed)throw c;}else{a=gd(a);try{for(;;)b.call(void 0,a.next(),void 0,a)}catch(c){if(c!==ed)throw c;}}}
function id(a){if(ya(a))return Qa(a);a=gd(a);var b=[];hd(a,function(c){b.push(c)});
return b}
;function jd(a,b){this.h={};this.f=[];this.F=this.g=0;var c=arguments.length;if(1<c){if(c%2)throw Error("Uneven number of arguments");for(var d=0;d<c;d+=2)this.set(arguments[d],arguments[d+1])}else if(a)if(a instanceof jd)for(c=kd(a),d=0;d<c.length;d++)this.set(c[d],a.get(c[d]));else for(d in a)this.set(d,a[d])}
function kd(a){ld(a);return a.f.concat()}
m=jd.prototype;m.equals=function(a,b){if(this===a)return!0;if(this.g!=a.g)return!1;var c=b||md;ld(this);for(var d,e=0;d=this.f[e];e++)if(!c(this.get(d),a.get(d)))return!1;return!0};
function md(a,b){return a===b}
m.isEmpty=function(){return 0==this.g};
m.clear=function(){this.h={};this.F=this.g=this.f.length=0};
m.remove=function(a){return Object.prototype.hasOwnProperty.call(this.h,a)?(delete this.h[a],this.g--,this.F++,this.f.length>2*this.g&&ld(this),!0):!1};
function ld(a){if(a.g!=a.f.length){for(var b=0,c=0;b<a.f.length;){var d=a.f[b];Object.prototype.hasOwnProperty.call(a.h,d)&&(a.f[c++]=d);b++}a.f.length=c}if(a.g!=a.f.length){var e={};for(c=b=0;b<a.f.length;)d=a.f[b],Object.prototype.hasOwnProperty.call(e,d)||(a.f[c++]=d,e[d]=1),b++;a.f.length=c}}
m.get=function(a,b){return Object.prototype.hasOwnProperty.call(this.h,a)?this.h[a]:b};
m.set=function(a,b){Object.prototype.hasOwnProperty.call(this.h,a)||(this.g++,this.f.push(a),this.F++);this.h[a]=b};
m.forEach=function(a,b){for(var c=kd(this),d=0;d<c.length;d++){var e=c[d],f=this.get(e);a.call(b,f,e,this)}};
m.clone=function(){return new jd(this)};
m.D=function(a){ld(this);var b=0,c=this.F,d=this,e=new fd;e.next=function(){if(c!=d.F)throw Error("The map has changed since the iterator was created");if(b>=d.f.length)throw ed;var f=d.f[b++];return a?f:d.h[f]};
return e};function nd(a){var b=[];od(new pd,a,b);return b.join("")}
function pd(){}
function od(a,b,c){if(null==b)c.push("null");else{if("object"==typeof b){if(Array.isArray(b)){var d=b;b=d.length;c.push("[");for(var e="",f=0;f<b;f++)c.push(e),od(a,d[f],c),e=",";c.push("]");return}if(b instanceof String||b instanceof Number||b instanceof Boolean)b=b.valueOf();else{c.push("{");e="";for(d in b)Object.prototype.hasOwnProperty.call(b,d)&&(f=b[d],"function"!=typeof f&&(c.push(e),qd(d,c),c.push(":"),od(a,f,c),e=","));c.push("}");return}}switch(typeof b){case "string":qd(b,c);break;case "number":c.push(isFinite(b)&&
!isNaN(b)?String(b):"null");break;case "boolean":c.push(String(b));break;case "function":c.push("null");break;default:throw Error("Unknown type: "+typeof b);}}}
var rd={'"':'\\"',"\\":"\\\\","/":"\\/","\b":"\\b","\f":"\\f","\n":"\\n","\r":"\\r","\t":"\\t","\x0B":"\\u000b"},sd=/\uffff/.test("\uffff")?/[\\"\x00-\x1f\x7f-\uffff]/g:/[\\"\x00-\x1f\x7f-\xff]/g;function qd(a,b){b.push('"',a.replace(sd,function(c){var d=rd[c];d||(d="\\u"+(c.charCodeAt(0)|65536).toString(16).substr(1),rd[c]=d);return d}),'"')}
;function td(a){if(!a)return!1;try{return!!a.$goog_Thenable}catch(b){return!1}}
;function N(a){this.f=0;this.m=void 0;this.i=this.g=this.h=null;this.j=this.l=!1;if(a!=va)try{var b=this;a.call(void 0,function(c){ud(b,2,c)},function(c){ud(b,3,c)})}catch(c){ud(this,3,c)}}
function vd(){this.next=this.context=this.onRejected=this.g=this.f=null;this.h=!1}
vd.prototype.reset=function(){this.context=this.onRejected=this.g=this.f=null;this.h=!1};
var wd=new Jc(function(){return new vd},function(a){a.reset()});
function xd(a,b,c){var d=wd.get();d.g=a;d.onRejected=b;d.context=c;return d}
function yd(a){return new N(function(b,c){c(a)})}
N.prototype.then=function(a,b,c){return zd(this,A(a)?a:null,A(b)?b:null,c)};
N.prototype.$goog_Thenable=!0;function Ad(a,b){return zd(a,null,b,void 0)}
N.prototype.cancel=function(a){if(0==this.f){var b=new Bd(a);Sc(function(){Cd(this,b)},this)}};
function Cd(a,b){if(0==a.f)if(a.h){var c=a.h;if(c.g){for(var d=0,e=null,f=null,h=c.g;h&&(h.h||(d++,h.f==a&&(e=h),!(e&&1<d)));h=h.next)e||(f=h);e&&(0==c.f&&1==d?Cd(c,b):(f?(d=f,d.next==c.i&&(c.i=d),d.next=d.next.next):Dd(c),Ed(c,e,3,b)))}a.h=null}else ud(a,3,b)}
function Fd(a,b){a.g||2!=a.f&&3!=a.f||Gd(a);a.i?a.i.next=b:a.g=b;a.i=b}
function zd(a,b,c,d){var e=xd(null,null,null);e.f=new N(function(f,h){e.g=b?function(g){try{var k=b.call(d,g);f(k)}catch(l){h(l)}}:f;
e.onRejected=c?function(g){try{var k=c.call(d,g);void 0===k&&g instanceof Bd?h(g):f(k)}catch(l){h(l)}}:h});
e.f.h=a;Fd(a,e);return e.f}
N.prototype.w=function(a){this.f=0;ud(this,2,a)};
N.prototype.B=function(a){this.f=0;ud(this,3,a)};
function ud(a,b,c){if(0==a.f){a===c&&(b=3,c=new TypeError("Promise cannot resolve to itself"));a.f=1;a:{var d=c,e=a.w,f=a.B;if(d instanceof N){Fd(d,xd(e||va,f||null,a));var h=!0}else if(td(d))d.then(e,f,a),h=!0;else{if(za(d))try{var g=d.then;if(A(g)){Hd(d,g,e,f,a);h=!0;break a}}catch(k){f.call(a,k);h=!0;break a}h=!1}}h||(a.m=c,a.f=b,a.h=null,Gd(a),3!=b||c instanceof Bd||Id(a,c))}}
function Hd(a,b,c,d,e){function f(k){g||(g=!0,d.call(e,k))}
function h(k){g||(g=!0,c.call(e,k))}
var g=!1;try{b.call(a,h,f)}catch(k){f(k)}}
function Gd(a){a.l||(a.l=!0,Sc(a.C,a))}
function Dd(a){var b=null;a.g&&(b=a.g,a.g=b.next,b.next=null);a.g||(a.i=null);return b}
N.prototype.C=function(){for(var a;a=Dd(this);)Ed(this,a,this.f,this.m);this.l=!1};
function Ed(a,b,c,d){if(3==c&&b.onRejected&&!b.h)for(;a&&a.j;a=a.h)a.j=!1;if(b.f)b.f.h=null,Jd(b,c,d);else try{b.h?b.g.call(b.context):Jd(b,c,d)}catch(e){Kd.call(null,e)}Kc(wd,b)}
function Jd(a,b,c){2==b?a.g.call(a.context,c):a.onRejected&&a.onRejected.call(a.context,c)}
function Id(a,b){a.j=!0;Sc(function(){a.j&&Kd.call(null,b)})}
var Kd=Lc;function Bd(a){E.call(this,a)}
D(Bd,E);Bd.prototype.name="cancel";function O(a){M.call(this);this.l=1;this.i=[];this.j=0;this.f=[];this.h={};this.m=!!a}
D(O,M);m=O.prototype;m.subscribe=function(a,b,c){var d=this.h[a];d||(d=this.h[a]=[]);var e=this.l;this.f[e]=a;this.f[e+1]=b;this.f[e+2]=c;this.l=e+3;d.push(e);return e};
function Ld(a,b,c,d){if(b=a.h[b]){var e=a.f;(b=Oa(b,function(f){return e[f+1]==c&&e[f+2]==d}))&&a.N(b)}}
m.N=function(a){var b=this.f[a];if(b){var c=this.h[b];0!=this.j?(this.i.push(a),this.f[a+1]=va):(c&&Pa(c,a),delete this.f[a],delete this.f[a+1],delete this.f[a+2])}return!!b};
m.M=function(a,b){var c=this.h[a];if(c){for(var d=Array(arguments.length-1),e=1,f=arguments.length;e<f;e++)d[e-1]=arguments[e];if(this.m)for(e=0;e<c.length;e++){var h=c[e];Md(this.f[h+1],this.f[h+2],d)}else{this.j++;try{for(e=0,f=c.length;e<f;e++)h=c[e],this.f[h+1].apply(this.f[h+2],d)}finally{if(this.j--,0<this.i.length&&0==this.j)for(;c=this.i.pop();)this.N(c)}}return 0!=e}return!1};
function Md(a,b,c){Sc(function(){a.apply(b,c)})}
m.clear=function(a){if(a){var b=this.h[a];b&&(F(b,this.N,this),delete this.h[a])}else this.f.length=0,this.h={}};
m.o=function(){O.L.o.call(this);this.clear();this.i.length=0};function Nd(a){this.f=a}
Nd.prototype.set=function(a,b){void 0===b?this.f.remove(a):this.f.set(a,nd(b))};
Nd.prototype.get=function(a){try{var b=this.f.get(a)}catch(c){return}if(null!==b)try{return JSON.parse(b)}catch(c){throw"Storage: Invalid value was encountered";}};
Nd.prototype.remove=function(a){this.f.remove(a)};function Od(a){this.f=a}
D(Od,Nd);function Pd(a){this.data=a}
function Qd(a){return void 0===a||a instanceof Pd?a:new Pd(a)}
Od.prototype.set=function(a,b){Od.L.set.call(this,a,Qd(b))};
Od.prototype.g=function(a){a=Od.L.get.call(this,a);if(void 0===a||a instanceof Object)return a;throw"Storage: Invalid value was encountered";};
Od.prototype.get=function(a){if(a=this.g(a)){if(a=a.data,void 0===a)throw"Storage: Invalid value was encountered";}else a=void 0;return a};function Rd(a){this.f=a}
D(Rd,Od);Rd.prototype.set=function(a,b,c){if(b=Qd(b)){if(c){if(c<C()){Rd.prototype.remove.call(this,a);return}b.expiration=c}b.creation=C()}Rd.L.set.call(this,a,b)};
Rd.prototype.g=function(a){var b=Rd.L.g.call(this,a);if(b){var c=b.creation,d=b.expiration;if(d&&d<C()||c&&c>C())Rd.prototype.remove.call(this,a);else return b}};function Sd(){}
;function Td(){}
D(Td,Sd);Td.prototype.clear=function(){var a=id(this.D(!0)),b=this;F(a,function(c){b.remove(c)})};function Ud(a){this.f=a}
D(Ud,Td);m=Ud.prototype;m.isAvailable=function(){if(!this.f)return!1;try{return this.f.setItem("__sak","1"),this.f.removeItem("__sak"),!0}catch(a){return!1}};
m.set=function(a,b){try{this.f.setItem(a,b)}catch(c){if(0==this.f.length)throw"Storage mechanism: Storage disabled";throw"Storage mechanism: Quota exceeded";}};
m.get=function(a){a=this.f.getItem(a);if("string"!==typeof a&&null!==a)throw"Storage mechanism: Invalid value was encountered";return a};
m.remove=function(a){this.f.removeItem(a)};
m.D=function(a){var b=0,c=this.f,d=new fd;d.next=function(){if(b>=c.length)throw ed;var e=c.key(b++);if(a)return e;e=c.getItem(e);if("string"!==typeof e)throw"Storage mechanism: Invalid value was encountered";return e};
return d};
m.clear=function(){this.f.clear()};
m.key=function(a){return this.f.key(a)};function Vd(){var a=null;try{a=window.localStorage||null}catch(b){}this.f=a}
D(Vd,Ud);function Wd(a,b){this.g=a;this.f=null;if(Nb&&!(9<=Number(Zb))){Xd||(Xd=new jd);this.f=Xd.get(a);this.f||(b?this.f=document.getElementById(b):(this.f=document.createElement("userdata"),this.f.addBehavior("#default#userData"),document.body.appendChild(this.f)),Xd.set(a,this.f));try{this.f.load(this.g)}catch(c){this.f=null}}}
D(Wd,Td);var Yd={".":".2E","!":".21","~":".7E","*":".2A","'":".27","(":".28",")":".29","%":"."},Xd=null;function Zd(a){return"_"+encodeURIComponent(a).replace(/[.!~*'()%]/g,function(b){return Yd[b]})}
m=Wd.prototype;m.isAvailable=function(){return!!this.f};
m.set=function(a,b){this.f.setAttribute(Zd(a),b);$d(this)};
m.get=function(a){a=this.f.getAttribute(Zd(a));if("string"!==typeof a&&null!==a)throw"Storage mechanism: Invalid value was encountered";return a};
m.remove=function(a){this.f.removeAttribute(Zd(a));$d(this)};
m.D=function(a){var b=0,c=this.f.XMLDocument.documentElement.attributes,d=new fd;d.next=function(){if(b>=c.length)throw ed;var e=c[b++];if(a)return decodeURIComponent(e.nodeName.replace(/\./g,"%")).substr(1);e=e.nodeValue;if("string"!==typeof e)throw"Storage mechanism: Invalid value was encountered";return e};
return d};
m.clear=function(){for(var a=this.f.XMLDocument.documentElement,b=a.attributes.length;0<b;b--)a.removeAttribute(a.attributes[b-1].nodeName);$d(this)};
function $d(a){try{a.f.save(a.g)}catch(b){throw"Storage mechanism: Quota exceeded";}}
;function ae(a,b){this.g=a;this.f=b+"::"}
D(ae,Td);ae.prototype.set=function(a,b){this.g.set(this.f+a,b)};
ae.prototype.get=function(a){return this.g.get(this.f+a)};
ae.prototype.remove=function(a){this.g.remove(this.f+a)};
ae.prototype.D=function(a){var b=this.g.D(!0),c=this,d=new fd;d.next=function(){for(var e=b.next();e.substr(0,c.f.length)!=c.f;)e=b.next();return a?e.substr(c.f.length):c.g.get(e)};
return d};function be(a,b){1<b.length?a[b[0]]=b[1]:1===b.length&&Object.assign(a,b[0])}
;var ce=window.yt&&window.yt.config_||window.ytcfg&&window.ytcfg.data_||{};y("yt.config_",ce,void 0);function P(a){be(ce,arguments)}
function Q(a,b){return a in ce?ce[a]:b}
function de(){return Q("PLAYER_CONFIG",{})}
function ee(a){var b=ce.EXPERIMENT_FLAGS;return b?b[a]:void 0}
;function fe(){var a=ge;z("yt.ads.biscotti.getId_")||y("yt.ads.biscotti.getId_",a,void 0)}
function he(a){y("yt.ads.biscotti.lastId_",a,void 0)}
;var ie=[];function je(a){ie.forEach(function(b){return b(a)})}
function ke(a){return a&&window.yterr?function(){try{return a.apply(this,arguments)}catch(b){le(b),je(b)}}:a}
function le(a){var b=z("yt.logging.errors.log");b?b(a,"ERROR",void 0,void 0,void 0):(b=Q("ERRORS",[]),b.push([a,"ERROR",void 0,void 0,void 0]),P("ERRORS",b))}
function me(a){var b=z("yt.logging.errors.log");b?b(a,"WARNING",void 0,void 0,void 0):(b=Q("ERRORS",[]),b.push([a,"WARNING",void 0,void 0,void 0]),P("ERRORS",b))}
;function ne(a){a=a.split("&");for(var b={},c=0,d=a.length;c<d;c++){var e=a[c].split("=");if(1==e.length&&e[0]||2==e.length)try{var f=decodeURIComponent((e[0]||"").replace(/\+/g," ")),h=decodeURIComponent((e[1]||"").replace(/\+/g," "));f in b?Array.isArray(b[f])?Ra(b[f],h):b[f]=[b[f],h]:b[f]=h}catch(k){if("q"!=e[0]){var g=Error("Error decoding URL component");g.params={key:e[0],value:e[1]};le(g)}}}return b}
function oe(a){var b=[];Ta(a,function(c,d){var e=encodeURIComponent(String(d)),f;Array.isArray(c)?f=c:f=[c];F(f,function(h){""==h?b.push(e):b.push(e+"="+encodeURIComponent(String(h)))})});
return b.join("&")}
function pe(a){"?"==a.charAt(0)&&(a=a.substr(1));return ne(a)}
function qe(a,b){return re(a,b||{},!0)}
function re(a,b,c){var d=a.split("#",2);a=d[0];d=1<d.length?"#"+d[1]:"";var e=a.split("?",2);a=e[0];e=pe(e[1]||"");for(var f in b)!c&&null!==e&&f in e||(e[f]=b[f]);return Jb(a,e)+d}
;function se(a){var b=te;a=void 0===a?z("yt.ads.biscotti.lastId_")||"":a;b=Object.assign(ue(b),ve(b));b.ca_type="image";a&&(b.bid=a);return b}
function ue(a){var b={};b.dt=Bc;b.flash="0";a:{try{var c=a.f.top.location.href}catch(f){a=2;break a}a=c?c===a.g.location.href?0:1:2}b=(b.frm=a,b);b.u_tz=-(new Date).getTimezoneOffset();var d=void 0===d?L:d;try{var e=d.history.length}catch(f){e=0}b.u_his=e;b.u_java=!!L.navigator&&"unknown"!==typeof L.navigator.javaEnabled&&!!L.navigator.javaEnabled&&L.navigator.javaEnabled();L.screen&&(b.u_h=L.screen.height,b.u_w=L.screen.width,b.u_ah=L.screen.availHeight,b.u_aw=L.screen.availWidth,b.u_cd=L.screen.colorDepth);
L.navigator&&L.navigator.plugins&&(b.u_nplug=L.navigator.plugins.length);L.navigator&&L.navigator.mimeTypes&&(b.u_nmime=L.navigator.mimeTypes.length);return b}
function ve(a){var b=a.f;try{var c=b.screenX;var d=b.screenY}catch(r){}try{var e=b.outerWidth;var f=b.outerHeight}catch(r){}try{var h=b.innerWidth;var g=b.innerHeight}catch(r){}b=[b.screenLeft,b.screenTop,c,d,b.screen?b.screen.availWidth:void 0,b.screen?b.screen.availTop:void 0,e,f,h,g];c=a.f.top;try{var k=(c||window).document,l="CSS1Compat"==k.compatMode?k.documentElement:k.body;var n=(new hc(l.clientWidth,l.clientHeight)).round()}catch(r){n=new hc(-12245933,-12245933)}k=n;n={};l=new Hc;x.SVGElement&&
x.document.createElementNS&&l.set(0);c=wc();c["allow-top-navigation-by-user-activation"]&&l.set(1);c["allow-popups-to-escape-sandbox"]&&l.set(2);x.crypto&&x.crypto.subtle&&l.set(3);x.TextDecoder&&x.TextEncoder&&l.set(4);l=Ic(l);n.bc=l;n.bih=k.height;n.biw=k.width;n.brdim=b.join();a=a.g;return n.vis={visible:1,hidden:2,prerender:3,preview:4,unloaded:5}[a.visibilityState||a.webkitVisibilityState||a.mozVisibilityState||""]||0,n.wgl=!!L.WebGLRenderingContext,n}
var te=new function(){var a=window.document;this.f=window;this.g=a};
y("yt.ads_.signals_.getAdSignalsString",function(a){return oe(se(a))},void 0);C();function R(a){a=we(a);return"string"===typeof a&&"false"===a?!1:!!a}
function xe(a,b){var c=we(a);return void 0===c&&void 0!==b?b:Number(c||0)}
function we(a){var b=Q("EXPERIMENTS_FORCED_FLAGS",{});return void 0!==b[a]?b[a]:Q("EXPERIMENT_FLAGS",{})[a]}
;var ye=void 0!==XMLHttpRequest?function(){return new XMLHttpRequest}:void 0!==ActiveXObject?function(){return new ActiveXObject("Microsoft.XMLHTTP")}:null;
function ze(){if(!ye)return null;var a=ye();return"open"in a?a:null}
function Ae(a){switch(a&&"status"in a?a.status:-1){case 200:case 201:case 202:case 203:case 204:case 205:case 206:case 304:return!0;default:return!1}}
;function S(a,b){A(a)&&(a=ke(a));return window.setTimeout(a,b)}
function T(a){window.clearTimeout(a)}
;var Be={Authorization:"AUTHORIZATION","X-Goog-Visitor-Id":"SANDBOXED_VISITOR_ID","X-YouTube-Client-Name":"INNERTUBE_CONTEXT_CLIENT_NAME","X-YouTube-Client-Version":"INNERTUBE_CONTEXT_CLIENT_VERSION","X-YouTube-Device":"DEVICE","X-Youtube-Identity-Token":"ID_TOKEN","X-YouTube-Page-CL":"PAGE_CL","X-YouTube-Page-Label":"PAGE_BUILD_LABEL","X-YouTube-Variants-Checksum":"VARIANTS_CHECKSUM"},Ce="app debugcss debugjs expflag force_ad_params force_viral_ad_response_params forced_experiments innertube_snapshots innertube_goldens internalcountrycode internalipoverride absolute_experiments conditional_experiments sbb sr_bns_address".split(" "),
De=!1;
function Ee(a,b){b=void 0===b?{}:b;if(!c)var c=window.location.href;var d=K(1,a),e=J(K(3,a));d&&e?(d=c,c=a.match(Gb),d=d.match(Gb),c=c[3]==d[3]&&c[1]==d[1]&&c[4]==d[4]):c=e?J(K(3,c))==e&&(Number(K(4,c))||null)==(Number(K(4,a))||null):!0;d=R("web_ajax_ignore_global_headers_if_set");for(var f in Be)e=Q(Be[f]),!e||!c&&!Fe(a,f)||d&&void 0!==b[f]||(b[f]=e);if(c||Fe(a,"X-YouTube-Utc-Offset"))b["X-YouTube-Utc-Offset"]=String(-(new Date).getTimezoneOffset());(c||Fe(a,"X-YouTube-Time-Zone"))&&(f="undefined"!=typeof Intl?
(new Intl.DateTimeFormat).resolvedOptions().timeZone:null)&&(b["X-YouTube-Time-Zone"]=f);if(c||Fe(a,"X-YouTube-Ad-Signals"))b["X-YouTube-Ad-Signals"]=oe(se(void 0));return b}
function Ge(a){var b=window.location.search,c=J(K(3,a)),d=J(K(5,a));d=(c=c&&(c.endsWith("youtube.com")||c.endsWith("youtube-nocookie.com")))&&d&&d.startsWith("/api/");if(!c||d)return a;var e=pe(b),f={};F(Ce,function(h){e[h]&&(f[h]=e[h])});
return re(a,f||{},!1)}
function Fe(a,b){var c=Q("CORS_HEADER_WHITELIST")||{},d=J(K(3,a));return d?(c=c[d])?0<=Ka(c,b):!1:!0}
function He(a,b){if(window.fetch&&"XML"!=b.format){var c={method:b.method||"GET",credentials:"same-origin"};b.headers&&(c.headers=b.headers);a=Ie(a,b);var d=Je(a,b);d&&(c.body=d);b.withCredentials&&(c.credentials="include");var e=!1,f;fetch(a,c).then(function(h){if(!e){e=!0;f&&T(f);var g=h.ok,k=function(l){l=l||{};var n=b.context||x;g?b.onSuccess&&b.onSuccess.call(n,l,h):b.onError&&b.onError.call(n,l,h);b.ia&&b.ia.call(n,l,h)};
"JSON"==(b.format||"JSON")&&(g||400<=h.status&&500>h.status)?h.json().then(k,function(){k(null)}):k(null)}});
b.oa&&0<b.timeout&&(f=S(function(){e||(e=!0,T(f),b.oa.call(b.context||x))},b.timeout))}else Ke(a,b)}
function Ke(a,b){var c=b.format||"JSON";a=Ie(a,b);var d=Je(a,b),e=!1,f,h=Le(a,function(g){if(!e){e=!0;f&&T(f);var k=Ae(g),l=null,n=400<=g.status&&500>g.status,r=500<=g.status&&600>g.status;if(k||n||r)l=Me(c,g,b.qb);if(k)a:if(g&&204==g.status)k=!0;else{switch(c){case "XML":k=0==parseInt(l&&l.return_code,10);break a;case "RAW":k=!0;break a}k=!!l}l=l||{};n=b.context||x;k?b.onSuccess&&b.onSuccess.call(n,g,l):b.onError&&b.onError.call(n,g,l);b.ia&&b.ia.call(n,g,l)}},b.method,d,b.headers,b.responseType,
b.withCredentials);
b.O&&0<b.timeout&&(f=S(function(){e||(e=!0,h.abort(),T(f),b.O.call(b.context||x,h))},b.timeout));
return h}
function Ie(a,b){b.tb&&(a=document.location.protocol+"//"+document.location.hostname+(document.location.port?":"+document.location.port:"")+a);var c=Q("XSRF_FIELD_NAME",void 0),d=b.Za;d&&(d[c]&&delete d[c],a=qe(a,d));return a}
function Je(a,b){var c=Q("XSRF_FIELD_NAME",void 0),d=Q("XSRF_TOKEN",void 0),e=b.postBody||"",f=b.A,h=Q("XSRF_FIELD_NAME",void 0),g;b.headers&&(g=b.headers["Content-Type"]);b.sb||J(K(3,a))&&!b.withCredentials&&J(K(3,a))!=document.location.hostname||"POST"!=b.method||g&&"application/x-www-form-urlencoded"!=g||b.A&&b.A[h]||(f||(f={}),f[c]=d);f&&"string"===typeof e&&(e=pe(e),cb(e,f),e=b.qa&&"JSON"==b.qa?JSON.stringify(e):Ib(e));f=e||f&&!Xa(f);!De&&f&&"POST"!=b.method&&(De=!0,le(Error("AJAX request with postData should use POST")));
return e}
function Me(a,b,c){var d=null;switch(a){case "JSON":a=b.responseText;b=b.getResponseHeader("Content-Type")||"";a&&0<=b.indexOf("json")&&(d=JSON.parse(a));break;case "XML":if(b=(b=b.responseXML)?Ne(b):null)d={},F(b.getElementsByTagName("*"),function(e){d[e.tagName]=Oe(e)})}c&&Pe(d);
return d}
function Pe(a){if(za(a))for(var b in a){var c;(c="html_content"==b)||(c=b.length-5,c=0<=c&&b.indexOf("_html",c)==c);if(c){c=b;var d=Ab(a[b],null);a[c]=d}else Pe(a[b])}}
function Ne(a){return a?(a=("responseXML"in a?a.responseXML:a).getElementsByTagName("root"))&&0<a.length?a[0]:null:null}
function Oe(a){var b="";F(a.childNodes,function(c){b+=c.nodeValue});
return b}
function Le(a,b,c,d,e,f,h){function g(){4==(k&&"readyState"in k?k.readyState:0)&&b&&ke(b)(k)}
c=void 0===c?"GET":c;d=void 0===d?"":d;var k=ze();if(!k)return null;"onloadend"in k?k.addEventListener("loadend",g,!1):k.onreadystatechange=g;R("debug_forward_web_query_parameters")&&(a=Ge(a));k.open(c,a,!0);f&&(k.responseType=f);h&&(k.withCredentials=!0);c="POST"==c&&(void 0===window.FormData||!(d instanceof FormData));if(e=Ee(a,e))for(var l in e)k.setRequestHeader(l,e[l]),"content-type"==l.toLowerCase()&&(c=!1);c&&k.setRequestHeader("Content-Type","application/x-www-form-urlencoded");k.send(d);
return k}
;var Qe={},Re=0;
function Se(a,b,c,d,e){e=void 0===e?"":e;a&&(c&&(c=vb,c=!(c&&0<=c.toLowerCase().indexOf("cobalt"))),c?a&&(a instanceof H||(a="object"==typeof a&&a.K?a.J():String(a),tb.test(a)||(a="about:invalid#zClosurez"),a=new H(qb,a)),b=sb(a),"about:invalid#zClosurez"===b?a="":(b instanceof yb?a=b:(d="object"==typeof b,a=null,d&&b.ga&&(a=b.da()),b=ib(d&&b.K?b.J():String(b)),a=Ab(b,a)),a instanceof yb&&a.constructor===yb&&a.h===zb?a=a.f:(xa(a),a="type_error:SafeHtml"),a=encodeURIComponent(String(nd(a.toString())))),/^[\s\xa0]*$/.test(a)||
(a=lc("IFRAME",{src:'javascript:"<body><img src=\\""+'+a+'+"\\"></body>"',style:"display:none"}),(9==a.nodeType?a:a.ownerDocument||a.document).body.appendChild(a))):e?Le(a,b,"POST",e,d):Q("USE_NET_AJAX_FOR_PING_TRANSPORT",!1)||d?Le(a,b,"GET","",d):Te(a,b)||Ue(a,b))}
function Te(a,b){if(!ee("web_use_beacon_api_for_ad_click_server_pings"))return!1;if(ee("use_sonic_js_library_for_v4_support")){a:{try{var c=new Ja({url:a,ab:!0});if(c.j?c.h&&c.f&&c.f[1]||c.i:c.g){var d=J(K(5,a));var e=!(!d||!d.endsWith("/aclk")||"1"!==Lb(a,"ri"));break a}}catch(f){}e=!1}if(!e)return!1}else if(e=J(K(5,a)),!e||-1==e.indexOf("/aclk")||"1"!==Lb(a,"ae")||"1"!==Lb(a,"act"))return!1;return Ve(a)?(b&&b(),!0):!1}
function Ve(a,b){try{if(window.navigator&&window.navigator.sendBeacon&&window.navigator.sendBeacon(a,void 0===b?"":b))return!0}catch(c){}return!1}
function Ue(a,b){var c=new Image,d=""+Re++;Qe[d]=c;c.onload=c.onerror=function(){b&&Qe[d]&&b();delete Qe[d]};
c.src=a}
;var We=z("ytPubsubPubsubInstance")||new O;O.prototype.subscribe=O.prototype.subscribe;O.prototype.unsubscribeByKey=O.prototype.N;O.prototype.publish=O.prototype.M;O.prototype.clear=O.prototype.clear;y("ytPubsubPubsubInstance",We,void 0);var Xe=z("ytPubsubPubsubSubscribedKeys")||{};y("ytPubsubPubsubSubscribedKeys",Xe,void 0);var Ye=z("ytPubsubPubsubTopicToKeys")||{};y("ytPubsubPubsubTopicToKeys",Ye,void 0);var Ze=z("ytPubsubPubsubIsSynchronous")||{};y("ytPubsubPubsubIsSynchronous",Ze,void 0);
function $e(a,b){var c=af();if(c){var d=c.subscribe(a,function(){var e=arguments;var f=function(){Xe[d]&&b.apply&&"function"==typeof b.apply&&b.apply(window,e)};
try{Ze[a]?f():S(f,0)}catch(h){le(h)}},void 0);
Xe[d]=!0;Ye[a]||(Ye[a]=[]);Ye[a].push(d);return d}return 0}
function bf(a){var b=af();b&&("number"===typeof a?a=[a]:"string"===typeof a&&(a=[parseInt(a,10)]),F(a,function(c){b.unsubscribeByKey(c);delete Xe[c]}))}
function cf(a,b){var c=af();c&&c.publish.apply(c,arguments)}
function df(a){var b=af();if(b)if(b.clear(a),a)ef(a);else for(var c in Ye)ef(c)}
function af(){return z("ytPubsubPubsubInstance")}
function ef(a){Ye[a]&&(a=Ye[a],F(a,function(b){Xe[b]&&delete Xe[b]}),a.length=0)}
;var ff=window,U=ff.ytcsi&&ff.ytcsi.now?ff.ytcsi.now:ff.performance&&ff.performance.timing&&ff.performance.now&&ff.performance.timing.navigationStart?function(){return ff.performance.timing.navigationStart+ff.performance.now()}:function(){return(new Date).getTime()};var gf=xe("initial_gel_batch_timeout",1E3),hf=Math.pow(2,16)-1,jf=null,kf=0,lf=void 0,mf=0,nf=0,of=0,pf=!0,qf=z("ytLoggingTransportLogPayloadsQueue_")||{};y("ytLoggingTransportLogPayloadsQueue_",qf,void 0);var rf=z("ytLoggingTransportGELQueue_")||new Map;y("ytLoggingTransportGELQueue_",rf,void 0);var sf=z("ytLoggingTransportTokensToCttTargetIds_")||{};y("ytLoggingTransportTokensToCttTargetIds_",sf,void 0);
function tf(){T(mf);T(nf);nf=0;lf&&lf.isReady()?(uf(rf),"log_event"in qf&&uf(Object.entries(qf.log_event)),rf.clear(),delete qf.log_event):vf()}
function vf(){R("web_gel_timeout_cap")&&!nf&&(nf=S(tf,6E4));T(mf);var a=Q("LOGGING_BATCH_TIMEOUT",xe("web_gel_debounce_ms",1E4));R("shorten_initial_gel_batch_timeout")&&pf&&(a=gf);mf=S(tf,a)}
function uf(a){var b=lf,c=Math.round(U());a=p(a);for(var d=a.next();!d.done;d=a.next()){var e=p(d.value);d=e.next().value;var f=e.next().value;e=ab({context:wf(b.f||xf())});e.events=f;(f=sf[d])&&yf(e,d,f);delete sf[d];zf(e,c);Af(b,"log_event",e,{retry:!0,onSuccess:function(){kf=Math.round(U()-c)}});
pf=!1}}
function zf(a,b){a.requestTimeMs=String(b);R("unsplit_gel_payloads_in_logs")&&(a.unsplitGelPayloadsInLogs=!0);var c=Q("EVENT_ID",void 0);if(c){var d=Q("BATCH_CLIENT_COUNTER",void 0)||0;!d&&R("web_client_counter_random_seed")&&(d=Math.floor(Math.random()*hf/2));d++;d>hf&&(d=1);P("BATCH_CLIENT_COUNTER",d);c={serializedEventId:c,clientCounter:String(d)};a.serializedClientEventId=c;jf&&kf&&R("log_gel_rtt_web")&&(a.previousBatchInfo={serializedClientEventId:jf,roundtripMs:String(kf)});jf=c;kf=0}}
function yf(a,b,c){if(c.videoId)var d="VIDEO";else if(c.playlistId)d="PLAYLIST";else return;a.credentialTransferTokenTargetId=c;a.context=a.context||{};a.context.user=a.context.user||{};a.context.user.credentialTransferTokens=[{token:b,scope:d}]}
;var Bf=xe("initial_gel_batch_timeout",1E3),Cf=Math.pow(2,16)-1,Df=null,Ef=0,Ff={log_event:"events",log_interaction:"interactions"},Gf=new Set(["log_event"]),Hf={},If=0,Jf=0,Kf=0,Lf=!0,V=z("ytLoggingTransportLogPayloadsQueue_")||{};y("ytLoggingTransportLogPayloadsQueue_",V,void 0);var Mf=z("ytLoggingTransportTokensToCttTargetIds_")||{};y("ytLoggingTransportTokensToCttTargetIds_",Mf,void 0);
function Nf(){if(R("use_typescript_transport"))tf();else if(T(If),T(Jf),Jf=0,!Xa(V)){for(var a in V){var b=Hf[a];if(b&&b.isReady()){var c=void 0,d=a,e=Ff[d],f=Math.round(U());for(c in V[d]){var h=ab({context:wf(b.f||xf())});h[e]=Of(d,c);var g=Mf[c];if(g)a:{var k=h,l=c;if(g.videoId)var n="VIDEO";else if(g.playlistId)n="PLAYLIST";else break a;k.credentialTransferTokenTargetId=g;k.context=k.context||{};k.context.user=k.context.user||{};k.context.user.credentialTransferTokens=[{token:l,scope:n}]}delete Mf[c];
g=h;g.requestTimeMs=f;R("unsplit_gel_payloads_in_logs")&&(g.unsplitGelPayloadsInLogs=!0);if(n=Q("EVENT_ID",void 0))k=Q("BATCH_CLIENT_COUNTER",void 0)||0,!k&&R("web_client_counter_random_seed")&&(k=Math.floor(Math.random()*Cf/2)),k++,k>Cf&&(k=1),P("BATCH_CLIENT_COUNTER",k),n={serializedEventId:n,clientCounter:k},g.serializedClientEventId=n,Df&&Ef&&R("log_gel_rtt_web")&&(g.previousBatchInfo={serializedClientEventId:Df,roundtripMs:Ef}),Df=n,Ef=0;Af(b,d,h,{retry:Gf.has(d),onSuccess:Fa(Pf,U())})}delete V[a];
Lf=!1}}Xa(V)||Qf()}}
function Qf(){R("web_gel_timeout_cap")&&!Jf&&(Jf=S(Nf,6E4));T(If);var a=Q("LOGGING_BATCH_TIMEOUT",xe("web_gel_debounce_ms",1E4));R("shorten_initial_gel_batch_timeout")&&Lf&&(a=Bf);If=S(Nf,a)}
function Of(a,b){b=void 0===b?"":b;V[a]=V[a]||{};V[a][b]=V[a][b]||[];return V[a][b]}
function Pf(a){Ef=Math.round(U()-a)}
;var Rf=0;y("ytDomDomGetNextId",z("ytDomDomGetNextId")||function(){return++Rf},void 0);var Sf={stopImmediatePropagation:1,stopPropagation:1,preventMouseEvent:1,preventManipulation:1,preventDefault:1,layerX:1,layerY:1,screenX:1,screenY:1,scale:1,rotation:1,webkitMovementX:1,webkitMovementY:1};
function Tf(a){this.type="";this.state=this.source=this.data=this.currentTarget=this.relatedTarget=this.target=null;this.charCode=this.keyCode=0;this.metaKey=this.shiftKey=this.ctrlKey=this.altKey=!1;this.clientY=this.clientX=0;this.changedTouches=this.touches=null;try{if(a=a||window.event){this.event=a;for(var b in a)b in Sf||(this[b]=a[b]);var c=a.target||a.srcElement;c&&3==c.nodeType&&(c=c.parentNode);this.target=c;var d=a.relatedTarget;if(d)try{d=d.nodeName?d:null}catch(e){d=null}else"mouseover"==
this.type?d=a.fromElement:"mouseout"==this.type&&(d=a.toElement);this.relatedTarget=d;this.clientX=void 0!=a.clientX?a.clientX:a.pageX;this.clientY=void 0!=a.clientY?a.clientY:a.pageY;this.keyCode=a.keyCode?a.keyCode:a.which;this.charCode=a.charCode||("keypress"==this.type?this.keyCode:0);this.altKey=a.altKey;this.ctrlKey=a.ctrlKey;this.shiftKey=a.shiftKey;this.metaKey=a.metaKey;this.f=a.pageX;this.g=a.pageY}}catch(e){}}
function Uf(a){if(document.body&&document.documentElement){var b=document.body.scrollTop+document.documentElement.scrollTop;a.f=a.clientX+(document.body.scrollLeft+document.documentElement.scrollLeft);a.g=a.clientY+b}}
Tf.prototype.preventDefault=function(){this.event&&(this.event.returnValue=!1,this.event.preventDefault&&this.event.preventDefault())};
Tf.prototype.stopPropagation=function(){this.event&&(this.event.cancelBubble=!0,this.event.stopPropagation&&this.event.stopPropagation())};
Tf.prototype.stopImmediatePropagation=function(){this.event&&(this.event.cancelBubble=!0,this.event.stopImmediatePropagation&&this.event.stopImmediatePropagation())};var Wa=z("ytEventsEventsListeners")||{};y("ytEventsEventsListeners",Wa,void 0);var Vf=z("ytEventsEventsCounter")||{count:0};y("ytEventsEventsCounter",Vf,void 0);
function Wf(a,b,c,d){d=void 0===d?{}:d;a.addEventListener&&("mouseenter"!=b||"onmouseenter"in document?"mouseleave"!=b||"onmouseenter"in document?"mousewheel"==b&&"MozBoxSizing"in document.documentElement.style&&(b="MozMousePixelScroll"):b="mouseout":b="mouseover");return Va(function(e){var f="boolean"===typeof e[4]&&e[4]==!!d,h=za(e[4])&&za(d)&&Za(e[4],d);return!!e.length&&e[0]==a&&e[1]==b&&e[2]==c&&(f||h)})}
var Xf=Sa(function(){var a=!1;try{var b=Object.defineProperty({},"capture",{get:function(){a=!0}});
window.addEventListener("test",null,b)}catch(c){}return a});
function W(a,b,c,d){d=void 0===d?{}:d;if(!a||!a.addEventListener&&!a.attachEvent)return"";var e=Wf(a,b,c,d);if(e)return e;e=++Vf.count+"";var f=!("mouseenter"!=b&&"mouseleave"!=b||!a.addEventListener||"onmouseenter"in document);var h=f?function(g){g=new Tf(g);if(!pc(g.relatedTarget,function(k){return k==a}))return g.currentTarget=a,g.type=b,c.call(a,g)}:function(g){g=new Tf(g);
g.currentTarget=a;return c.call(a,g)};
h=ke(h);a.addEventListener?("mouseenter"==b&&f?b="mouseover":"mouseleave"==b&&f?b="mouseout":"mousewheel"==b&&"MozBoxSizing"in document.documentElement.style&&(b="MozMousePixelScroll"),Xf()||"boolean"===typeof d?a.addEventListener(b,h,d):a.addEventListener(b,h,!!d.capture)):a.attachEvent("on"+b,h);Wa[e]=[a,b,c,h,d];return e}
function Yf(a){a&&("string"==typeof a&&(a=[a]),F(a,function(b){if(b in Wa){var c=Wa[b],d=c[0],e=c[1],f=c[3];c=c[4];d.removeEventListener?Xf()||"boolean"===typeof c?d.removeEventListener(e,f,c):d.removeEventListener(e,f,!!c.capture):d.detachEvent&&d.detachEvent("on"+e,f);delete Wa[b]}}))}
;var Zf=window.ytcsi&&window.ytcsi.now?window.ytcsi.now:window.performance&&window.performance.timing&&window.performance.now&&window.performance.timing.navigationStart?function(){return window.performance.timing.navigationStart+window.performance.now()}:function(){return(new Date).getTime()};function $f(a){this.w=a;this.f=null;this.j=0;this.m=null;this.l=0;this.h=[];for(a=0;4>a;a++)this.h.push(0);this.i=0;this.G=W(window,"mousemove",B(this.H,this));a=B(this.B,this);A(a)&&(a=ke(a));this.I=window.setInterval(a,25)}
D($f,M);$f.prototype.H=function(a){void 0===a.f&&Uf(a);var b=a.f;void 0===a.g&&Uf(a);this.f=new gc(b,a.g)};
$f.prototype.B=function(){if(this.f){var a=Zf();if(0!=this.j){var b=this.m,c=this.f,d=b.x-c.x;b=b.y-c.y;d=Math.sqrt(d*d+b*b)/(a-this.j);this.h[this.i]=.5<Math.abs((d-this.l)/this.l)?1:0;for(c=b=0;4>c;c++)b+=this.h[c]||0;3<=b&&this.w();this.l=d}this.j=a;this.m=this.f;this.i=(this.i+1)%4}};
$f.prototype.o=function(){window.clearInterval(this.I);Yf(this.G)};function ag(){}
function bg(a,b){return cg(a,1,b)}
;function dg(){}
q(dg,ag);function cg(a,b,c){isNaN(c)&&(c=void 0);var d=z("yt.scheduler.instance.addJob");return d?d(a,b,c):void 0===c?(a(),NaN):S(a,c||0)}
dg.prototype.start=function(){var a=z("yt.scheduler.instance.start");a&&a()};
dg.prototype.pause=function(){var a=z("yt.scheduler.instance.pause");a&&a()};
wa(dg);dg.getInstance();var eg={};
function fg(a){var b=void 0===a?{}:a;a=void 0===b.Da?!0:b.Da;b=void 0===b.Oa?!1:b.Oa;if(null==z("_lact",window)){var c=parseInt(Q("LACT"),10);c=isFinite(c)?C()-Math.max(c,0):-1;y("_lact",c,window);y("_fact",c,window);-1==c&&gg();W(document,"keydown",gg);W(document,"keyup",gg);W(document,"mousedown",gg);W(document,"mouseup",gg);a&&(b?W(window,"touchmove",function(){hg("touchmove",200)},{passive:!0}):(W(window,"resize",function(){hg("resize",200)}),W(window,"scroll",function(){hg("scroll",200)})));
new $f(function(){hg("mouse",100)});
W(document,"touchstart",gg,{passive:!0});W(document,"touchend",gg,{passive:!0})}}
function hg(a,b){eg[a]||(eg[a]=!0,bg(function(){gg();eg[a]=!1},b))}
function gg(){null==z("_lact",window)&&fg();var a=C();y("_lact",a,window);-1==z("_fact",window)&&y("_fact",a,window);(a=z("ytglobal.ytUtilActivityCallback_"))&&a()}
function ig(){var a=z("_lact",window);return null==a?-1:Math.max(C()-a,0)}
;var jg=z("ytLoggingGelSequenceIdObj_")||{};y("ytLoggingGelSequenceIdObj_",jg,void 0);
function kg(a,b,c,d){d=void 0===d?{}:d;var e={};e.eventTimeMs=Math.round(d.timestamp||U());e[a]=b;e.context={lastActivityMs:String(d.timestamp?-1:ig())};R("log_sequence_info_on_gel_web")&&d.P&&(a=e.context,b=d.P,jg[b]=b in jg?jg[b]+1:0,a.sequence={index:jg[b],groupKey:b},d.rb&&delete jg[d.P]);d=d.ca;R("use_typescript_transport")?(a="",d&&(a={},d.videoId?a.videoId=d.videoId:d.playlistId&&(a.playlistId=d.playlistId),sf[d.token]=a,a=d.token),d=rf.get(a)||[],rf.set(a,d),d.push(e),c&&(lf=new c),c=xe("web_logging_max_batch")||
100,e=U(),d.length>=c?tf():10<=e-of&&(vf(),of=e)):(d?(a={},d.videoId?a.videoId=d.videoId:d.playlistId&&(a.playlistId=d.playlistId),Mf[d.token]=a,d=Of("log_event",d.token)):d=Of("log_event"),d.push(e),c&&(Hf.log_event=new c),c=xe("web_logging_max_batch")||100,e=U(),d.length>=c?Nf():10<=e-Kf&&(Qf(),Kf=e))}
;function lg(){for(var a={},b=p(Object.entries(pe(Q("DEVICE","")))),c=b.next();!c.done;c=b.next()){var d=p(c.value);c=d.next().value;d=d.next().value;"cbrand"===c?a.deviceMake=d:"cmodel"===c?a.deviceModel=d:"cbr"===c?a.browserName=d:"cbrver"===c?a.browserVersion=d:"cos"===c?a.osName=d:"cosver"===c?a.osVersion=d:"cplatform"===c&&(a.platform=d)}return a}
;function mg(){return"INNERTUBE_API_KEY"in ce&&"INNERTUBE_API_VERSION"in ce}
function xf(){return{innertubeApiKey:Q("INNERTUBE_API_KEY",void 0),innertubeApiVersion:Q("INNERTUBE_API_VERSION",void 0),Ea:Q("INNERTUBE_CONTEXT_CLIENT_CONFIG_INFO"),Fa:Q("INNERTUBE_CONTEXT_CLIENT_NAME","WEB"),innertubeContextClientVersion:Q("INNERTUBE_CONTEXT_CLIENT_VERSION",void 0),Ha:Q("INNERTUBE_CONTEXT_HL",void 0),Ga:Q("INNERTUBE_CONTEXT_GL",void 0),Ia:Q("INNERTUBE_HOST_OVERRIDE",void 0)||"",Ja:!!Q("INNERTUBE_USE_THIRD_PARTY_AUTH",!1)}}
function wf(a){a={client:{hl:a.Ha,gl:a.Ga,clientName:a.Fa,clientVersion:a.innertubeContextClientVersion,configInfo:a.Ea}};var b=window.devicePixelRatio;b&&1!=b&&(a.client.screenDensityFloat=String(b));b=Q("EXPERIMENTS_TOKEN","");""!==b&&(a.client.experimentsToken=b);b=[];var c=Q("EXPERIMENTS_FORCED_FLAGS",{});for(d in c)b.push({key:d,value:String(c[d])});var d=Q("EXPERIMENT_FLAGS",{});for(var e in d)e.startsWith("force_")&&void 0===c[e]&&b.push({key:e,value:String(d[e])});0<b.length&&(a.request={internalExperimentFlags:b});
Q("DELEGATED_SESSION_ID")&&!R("pageid_as_header_web")&&(a.user={onBehalfOfUser:Q("DELEGATED_SESSION_ID")});a.client=Object.assign(a.client,lg());return a}
function ng(a,b,c){c=void 0===c?{}:c;var d={"X-Goog-Visitor-Id":c.visitorData||Q("VISITOR_DATA","")};if(b&&b.includes("www.youtube-nocookie.com"))return d;(b=c.ob||Q("AUTHORIZATION"))||(a?b="Bearer "+z("gapi.auth.getToken")().nb:b=Gc([]));b&&(d.Authorization=b,d["X-Goog-AuthUser"]=Q("SESSION_INDEX",0),R("pageid_as_header_web")&&(d["X-Goog-PageId"]=Q("DELEGATED_SESSION_ID")));return d}
function og(a){a=Object.assign({},a);delete a.Authorization;var b=Gc();if(b){var c=new Zc;c.update(Q("INNERTUBE_API_KEY",void 0));c.update(b);b=c.digest();c=3;ya(b);void 0===c&&(c=0);if(!ac){ac={};for(var d="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".split(""),e=["+/=","+/","-_=","-_.","-_"],f=0;5>f;f++){var h=d.concat(e[f].split(""));$b[f]=h;for(var g=0;g<h.length;g++){var k=h[g];void 0===ac[k]&&(ac[k]=g)}}}c=$b[c];d=[];for(e=0;e<b.length;e+=3){var l=b[e],n=(f=e+1<b.length)?
b[e+1]:0;k=(h=e+2<b.length)?b[e+2]:0;g=l>>2;l=(l&3)<<4|n>>4;n=(n&15)<<2|k>>6;k&=63;h||(k=64,f||(n=64));d.push(c[g],c[l],c[n]||"",c[k]||"")}a.hash=d.join("")}return a}
;function pg(a,b,c,d){ec.set(""+a,b,{la:c,path:"/",domain:void 0===d?"youtube.com":d,secure:!1})}
;function qg(){var a=new Vd;(a=a.isAvailable()?new ae(a,"yt.innertube"):null)||(a=new Wd("yt.innertube"),a=a.isAvailable()?a:null);this.f=a?new Rd(a):null;this.g=document.domain||window.location.hostname}
qg.prototype.set=function(a,b,c,d){c=c||31104E3;this.remove(a);if(this.f)try{this.f.set(a,b,C()+1E3*c);return}catch(f){}var e="";if(d)try{e=escape(nd(b))}catch(f){return}else e=escape(b);pg(a,e,c,this.g)};
qg.prototype.get=function(a,b){var c=void 0,d=!this.f;if(!d)try{c=this.f.get(a)}catch(e){d=!0}if(d&&(c=ec.get(""+a,void 0))&&(c=unescape(c),b))try{c=JSON.parse(c)}catch(e){this.remove(a),c=void 0}return c};
qg.prototype.remove=function(a){this.f&&this.f.remove(a);var b=this.g;ec.remove(""+a,"/",void 0===b?"youtube.com":b)};var rg=new qg;function sg(a,b,c,d){if(d)return null;d=rg.get("nextId",!0)||1;var e=rg.get("requests",!0)||{};e[d]={method:a,request:b,authState:og(c),requestTime:Math.round(U())};rg.set("nextId",d+1,86400,!0);rg.set("requests",e,86400,!0);return d}
function tg(a){var b=rg.get("requests",!0)||{};delete b[a];rg.set("requests",b,86400,!0)}
function ug(a){var b=rg.get("requests",!0);if(b){for(var c in b){var d=b[c];if(!(6E4>Math.round(U())-d.requestTime)){var e=d.authState,f=og(ng(!1));Za(e,f)&&(e=d.request,"requestTimeMs"in e&&(e.requestTimeMs=Math.round(U())),Af(a,d.method,e,{}));delete b[c]}}rg.set("requests",b,86400,!0)}}
;function vg(a){var b=this;this.f=null;a?this.f=a:mg()&&(this.f=xf());cg(function(){ug(b)},0,5E3)}
vg.prototype.isReady=function(){!this.f&&mg()&&(this.f=xf());return!!this.f};
function Af(a,b,c,d){!Q("VISITOR_DATA")&&"visitor_id"!==b&&.01>Math.random()&&me(Error("Missing VISITOR_DATA when sending innertube request."));var e={headers:{"Content-Type":"application/json"},method:"POST",A:c,qa:"JSON",O:function(){d.O()},
oa:d.O,onSuccess:function(w,t){if(d.onSuccess)d.onSuccess(t)},
na:function(w){if(d.onSuccess)d.onSuccess(w)},
onError:function(w,t){if(d.onError)d.onError(t)},
vb:function(w){if(d.onError)d.onError(w)},
timeout:d.timeout,withCredentials:!0},f="",h=a.f.Ia;h&&(f=h);h=a.f.Ja||!1;var g=ng(h,f,d);Object.assign(e.headers,g);e.headers.Authorization&&!f&&(e.headers["x-origin"]=window.location.origin);var k=qe(""+f+("/youtubei/"+a.f.innertubeApiVersion+"/"+b),{alt:"json",key:a.f.innertubeApiKey}),l;if(d.retry&&R("retry_web_logging_batches")&&"www.youtube-nocookie.com"!=f&&(l=sg(b,c,g,h))){var n=e.onSuccess,r=e.na;e.onSuccess=function(w,t){tg(l);n(w,t)};
c.na=function(w,t){tg(l);r(w,t)}}try{R("use_fetch_for_op_xhr")?He(k,e):(e.method="POST",e.A||(e.A={}),Ke(k,e))}catch(w){if("InvalidAccessError"==w)l&&(tg(l),l=0),me(Error("An extension is blocking network request."));
else throw w;}l&&cg(function(){ug(a)},0,5E3)}
;function wg(a,b,c){c=void 0===c?{}:c;var d=vg;Q("ytLoggingEventsDefaultDisabled",!1)&&vg==vg&&(d=null);kg(a,b,d,c)}
;function xg(a,b){for(var c=[],d=1;d<arguments.length;++d)c[d-1]=arguments[d];d=Error.call(this,a);this.message=d.message;"stack"in d&&(this.stack=d.stack);this.args=[].concat(c instanceof Array?c:ba(p(c)))}
q(xg,Error);var yg=new Set,zg=0;function Ag(a){Bg(a,"WARNING")}
function Bg(a,b,c,d,e){e=void 0===e?{}:e;e.name=c||Q("INNERTUBE_CONTEXT_CLIENT_NAME",1);e.version=d||Q("INNERTUBE_CONTEXT_CLIENT_VERSION",void 0);c=e||{};b=void 0===b?"ERROR":b;b=void 0===b?"ERROR":b;d=window&&window.yterr||!1;if(a&&d&&!(5<=zg)&&(R("console_log_js_exceptions")&&(d=[],d.push("Name: "+a.name),d.push("Message: "+a.message),a.hasOwnProperty("params")&&d.push("Error Params: "+JSON.stringify(a.params)),d.push("File name: "+a.fileName),d.push("Stacktrace: "+a.stack),window.console.log(d.join("\n"),
a)),0!==a.f)){d=a.g;e=a.columnNumber;if(a.args&&a.args.length)for(var f=0,h=0;h<a.args.length;h++){var g=a.args[h],k="params."+h;f+=k.length;if(g)if(Array.isArray(g))for(var l=c,n=0;n<g.length&&!(g[n]&&(f+=Cg(n,g[n],k,l),500<f));n++);else if("object"===typeof g)for(l in l=void 0,n=c,g){if(g[l]&&(f+=Cg(l,g[l],k,n),500<f))break}else c[k]=String(JSON.stringify(g)).substring(0,500),f+=c[k].length;else c[k]=String(JSON.stringify(g)).substring(0,500),f+=c[k].length;if(500<=f)break}else if(a.hasOwnProperty("params"))if(g=
a.params,"object"===typeof a.params)for(h in k=0,g){if(g[h]&&(f="params."+h,l=String(JSON.stringify(g[h])).substr(0,500),c[f]=l,k+=f.length+l.length,500<k))break}else c.params=String(JSON.stringify(g)).substr(0,500);a=bc(a);(d=d||a.stack)||(d="Not available");g={stackTrace:d};a.fileName&&(g.filename=a.fileName);h=a.lineNumber.toString();isNaN(h)||!e||isNaN(e)||(g.lineNumber=Number(h),g.columnNumber=Number(e),h=h+":"+e);window.yterr&&A(window.yterr)&&(a.params=c,window.yterr(a));if(!(yg.has(a.message)||
0<=d.indexOf("/YouTubeCenter.js")||0<=d.indexOf("/mytube.js"))){if(R("kevlar_gel_error_routing")){k=b;e={level:"ERROR_LEVEL_UNKNOWN",message:a.message};"ERROR"===k?e.level="ERROR_LEVEL_ERROR":"WARNING"===k&&(e.level="ERROR_LEVEL_WARNNING");g={isObfuscated:!0,browserStackInfo:g};k={pageUrl:window.location.href,kvPairs:[]};f=p(Object.keys(c));for(l=f.next();!l.done;l=f.next())l=l.value,k.kvPairs.push({key:"client."+l,value:String(c[l])});wg("clientError",{errorMetadata:k,stackTrace:g,logMessage:e});
Nf()}b={Za:{a:"logerror",t:"jserror",type:a.name,msg:a.message.substr(0,250),line:h,level:b,"client.name":c.name},A:{url:Q("PAGE_NAME",window.location.href),file:a.fileName},method:"POST"};c.version&&(b["client.version"]=c.version);if(b.A){d&&(b.A.stack=d);d=p(Object.keys(c));for(e=d.next();!e.done;e=d.next())e=e.value,b.A["client."+e]=c[e];if(c=Q("LATEST_ECATCHER_SERVICE_TRACKING_PARAMS",void 0))for(d=p(Object.keys(c)),e=d.next();!e.done;e=d.next())e=e.value,b.A[e]=c[e];c=Q("SERVER_NAME",void 0);
d=Q("SERVER_VERSION",void 0);c&&d&&(b.A["server.name"]=c,b.A["server.version"]=d)}Ke(Q("ECATCHER_REPORT_HOST","")+"/error_204",b);yg.add(a.message);zg++}}}
function Cg(a,b,c,d){c+="."+a;a=String(JSON.stringify(b)).substr(0,500);d[c]=a;return c.length+a.length}
;function Dg(a,b,c,d,e,f){Bg(a,void 0===b?"ERROR":b,c,d,f)}
;var Eg=window.yt&&window.yt.msgs_||window.ytcfg&&window.ytcfg.msgs||{};y("yt.msgs_",Eg,void 0);function Fg(a){be(Eg,arguments)}
;function Gg(a){a&&(a.dataset?a.dataset[Hg("loaded")]="true":a.setAttribute("data-loaded","true"))}
function Ig(a,b){return a?a.dataset?a.dataset[Hg(b)]:a.getAttribute("data-"+b):null}
var Jg={};function Hg(a){return Jg[a]||(Jg[a]=String(a).replace(/\-([a-z])/g,function(b,c){return c.toUpperCase()}))}
;var Kg=/\.vflset|-vfl[a-zA-Z0-9_+=-]+/,Lg=/-[a-zA-Z]{2,3}_[a-zA-Z]{2,3}(?=(\/|$))/;function Mg(a,b,c){c=void 0===c?null:c;if(window.spf&&spf.script){c="";if(a){var d=a.indexOf("jsbin/"),e=a.lastIndexOf(".js"),f=d+6;-1<d&&-1<e&&e>f&&(c=a.substring(f,e),c=c.replace(Kg,""),c=c.replace(Lg,""),c=c.replace("debug-",""),c=c.replace("tracing-",""))}spf.script.load(a,c,b)}else Ng(a,b,c)}
function Ng(a,b,c){c=void 0===c?null:c;var d=Og(a),e=document.getElementById(d),f=e&&Ig(e,"loaded"),h=e&&!f;f?b&&b():(b&&(f=$e(d,b),b=""+Aa(b),Pg[b]=f),h||(e=Qg(a,d,function(){Ig(e,"loaded")||(Gg(e),cf(d),S(Fa(df,d),0))},c)))}
function Qg(a,b,c,d){d=void 0===d?null:d;var e=mc(document,"SCRIPT");e.id=b;e.onload=function(){c&&setTimeout(c,0)};
e.onreadystatechange=function(){switch(e.readyState){case "loaded":case "complete":e.onload()}};
d&&e.setAttribute("nonce",d);Cb(e,qc(a));a=document.getElementsByTagName("head")[0]||document.body;a.insertBefore(e,a.firstChild);return e}
function Rg(a){a=Og(a);var b=document.getElementById(a);b&&(df(a),b.parentNode.removeChild(b))}
function Sg(a,b){if(a&&b){var c=""+Aa(b);(c=Pg[c])&&bf(c)}}
function Og(a){var b=document.createElement("a");Bb(b,a);a=b.href.replace(/^[a-zA-Z]+:\/\//,"//");return"js-"+Eb(a)}
var Pg={};var Tg=[],Ug=!1;function Vg(){if("1"!=Ua(de(),"args","privembed")){var a=function(){Ug=!0;"google_ad_status"in window?P("DCLKSTAT",1):P("DCLKSTAT",2)};
Mg("//static.doubleclick.net/instream/ad_status.js",a);Tg.push(bg(function(){Ug||"google_ad_status"in window||(Sg("//static.doubleclick.net/instream/ad_status.js",a),Ug=!0,P("DCLKSTAT",3))},5E3))}}
function Wg(){return parseInt(Q("DCLKSTAT",0),10)}
;function Xg(){this.g=!1;this.f=null}
Xg.prototype.initialize=function(a,b,c,d,e,f){var h=this;f=void 0===f?!1:f;b?(this.g=!0,Mg(b,function(){h.g=!1;window.botguard?Yg(h,c,d,f):(Rg(b),Ag(new xg("Unable to load Botguard","from "+b)))},e)):a&&(eval(a),window.botguard?Yg(this,c,d,f):Ag(Error("Unable to load Botguard from JS")))};
function Yg(a,b,c,d){if(d)try{a.f=new window.botguard.bg(b,c?function(){return c(b)}:va)}catch(e){Ag(e)}else{try{a.f=new window.botguard.bg(b)}catch(e){Ag(e)}c&&c(b)}}
Xg.prototype.dispose=function(){this.f=null};var Zg=new Xg,$g=!1,ah=0,bh="";function ch(a){R("botguard_periodic_refresh")?ah=U():R("botguard_always_refresh")&&(bh=a)}
function dh(a){if(a){if(Zg.g)return!1;if(R("botguard_periodic_refresh"))return 72E5<U()-ah;if(R("botguard_always_refresh"))return bh!=a}else return!1;return!$g}
function eh(){return!!Zg.f}
function fh(a){a=void 0===a?{}:a;a=void 0===a?{}:a;return Zg.f?Zg.f.invoke(void 0,void 0,a):null}
;var gh=C().toString();
function hh(){a:{if(window.crypto&&window.crypto.getRandomValues)try{var a=Array(16),b=new Uint8Array(16);window.crypto.getRandomValues(b);for(var c=0;c<a.length;c++)a[c]=b[c];var d=a;break a}catch(e){}d=Array(16);for(a=0;16>a;a++){b=C();for(c=0;c<b%23;c++)d[a]=Math.random();d[a]=Math.floor(256*Math.random())}if(gh)for(a=1,b=0;b<gh.length;b++)d[a%16]=d[a%16]^d[(a-1)%16]/4^gh.charCodeAt(b),a++}a=[];for(b=0;b<d.length;b++)a.push("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(d[b]&63));
return a.join("")}
;var ih=z("ytLoggingDocDocumentNonce_")||hh();y("ytLoggingDocDocumentNonce_",ih,void 0);var jh=1;function kh(a){this.f=a}
function lh(a){var b={};void 0!==a.f.trackingParams?b.trackingParams=a.f.trackingParams:(b.veType=a.f.veType,void 0!==a.f.veCounter&&(b.veCounter=a.f.veCounter),void 0!==a.f.elementIndex&&(b.elementIndex=a.f.elementIndex));void 0!==a.f.dataElement&&(b.dataElement=lh(a.f.dataElement));void 0!==a.f.youtubeData&&(b.youtubeData=a.f.youtubeData);return b}
kh.prototype.toString=function(){return JSON.stringify(lh(this))};function mh(a){a=void 0===a?0:a;return 0==a?"client-screen-nonce":"client-screen-nonce."+a}
function nh(a){a=void 0===a?0:a;return 0==a?"ROOT_VE_TYPE":"ROOT_VE_TYPE."+a}
function oh(a){return Q(nh(void 0===a?0:a),void 0)}
y("yt_logging_screen.getRootVeType",oh,void 0);function ph(){var a=oh(0),b;a?b=new kh({veType:a,youtubeData:void 0}):b=null;return b}
function qh(){var a=Q("csn-to-ctt-auth-info");a||(a={},P("csn-to-ctt-auth-info",a));return a}
function rh(a){a=void 0===a?0:a;var b=Q(mh(a));if(!b&&!Q("USE_CSN_FALLBACK",!0))return null;b||0!=a||(R("kevlar_client_side_screens")||R("c3_client_side_screens")?b="UNDEFINED_CSN":b=Q("EVENT_ID"));return b?b:null}
y("yt_logging_screen.getCurrentCsn",rh,void 0);function sh(a,b,c){var d=qh();(c=rh(c))&&delete d[c];b&&(d[a]=b)}
function th(a){return qh()[a]}
y("yt_logging_screen.getCttAuthInfo",th,void 0);function uh(a,b,c,d){c=void 0===c?0:c;if(a!==Q(mh(c))||b!==Q(nh(c)))if(sh(a,d,c),P(mh(c),a),P(nh(c),b),0==c||R("web_screen_associated_all_layers"))b=function(){setTimeout(function(){a&&kg("foregroundHeartbeatScreenAssociated",{clientDocumentNonce:ih,clientScreenNonce:a},vg)},0)},"requestAnimationFrame"in window?window.requestAnimationFrame(b):b()}
y("yt_logging_screen.setCurrentScreen",uh,void 0);function vh(a,b,c){b=void 0===b?{}:b;c=void 0===c?!1:c;var d=Q("EVENT_ID");d&&(b.ei||(b.ei=d));if(b){d=a;var e=void 0===e?!0:e;var f=Q("VALID_SESSION_TEMPDATA_DOMAINS",[]),h=J(K(3,window.location.href));h&&f.push(h);h=J(K(3,d));if(0<=Ka(f,h)||!h&&0==d.lastIndexOf("/",0))if(R("autoescape_tempdata_url")&&(f=document.createElement("a"),Bb(f,d),d=f.href),d){h=d.match(Gb);d=h[5];f=h[6];h=h[7];var g="";d&&(g+=d);f&&(g+="?"+f);h&&(g+="#"+h);d=g;f=d.indexOf("#");if(d=0>f?d:d.substr(0,f))if(e&&!b.csn&&(b.itct||
b.ved)&&(b=Object.assign({csn:rh()},b)),k){var k=parseInt(k,10);isFinite(k)&&0<k&&(e=b,b="ST-"+Eb(d).toString(36),e=e?Ib(e):"",pg(b,e,k||5))}else k=b,e="ST-"+Eb(d).toString(36),k=k?Ib(k):"",pg(e,k,5)}}if(c)return!1;if((window.ytspf||{}).enabled)spf.navigate(a);else{var l=void 0===l?{}:l;var n=void 0===n?"":n;var r=void 0===r?window:r;c=r.location;a=Jb(a,l)+n;a=a instanceof H?a:ub(a);c.href=sb(a)}return!0}
;function wh(a,b){this.version=a;this.args=b}
;function xh(a,b){this.topic=a;this.f=b}
xh.prototype.toString=function(){return this.topic};var yh=z("ytPubsub2Pubsub2Instance")||new O;O.prototype.subscribe=O.prototype.subscribe;O.prototype.unsubscribeByKey=O.prototype.N;O.prototype.publish=O.prototype.M;O.prototype.clear=O.prototype.clear;y("ytPubsub2Pubsub2Instance",yh,void 0);var zh=z("ytPubsub2Pubsub2SubscribedKeys")||{};y("ytPubsub2Pubsub2SubscribedKeys",zh,void 0);var Ah=z("ytPubsub2Pubsub2TopicToKeys")||{};y("ytPubsub2Pubsub2TopicToKeys",Ah,void 0);var Bh=z("ytPubsub2Pubsub2IsAsync")||{};y("ytPubsub2Pubsub2IsAsync",Bh,void 0);
y("ytPubsub2Pubsub2SkipSubKey",null,void 0);function Ch(a,b){var c=Dh();c&&c.publish.call(c,a.toString(),a,b)}
function Eh(a){var b=Fh,c=Dh();if(!c)return 0;var d=c.subscribe(b.toString(),function(e,f){var h=z("ytPubsub2Pubsub2SkipSubKey");h&&h==d||(h=function(){if(zh[d])try{if(f&&b instanceof xh&&b!=e)try{var g=b.f,k=f;if(!k.args||!k.version)throw Error("yt.pubsub2.Data.deserialize(): serializedData is incomplete.");try{if(!g.F){var l=new g;g.F=l.version}var n=g.F}catch(r){}if(!n||k.version!=n)throw Error("yt.pubsub2.Data.deserialize(): serializedData version is incompatible.");try{f=Reflect.construct(g,
Qa(k.args))}catch(r){throw r.message="yt.pubsub2.Data.deserialize(): "+r.message,r;}}catch(r){throw r.message="yt.pubsub2.pubsub2 cross-binary conversion error for "+b.toString()+": "+r.message,r;}a.call(window,f)}catch(r){le(r)}},Bh[b.toString()]?z("yt.scheduler.instance")?bg(h):S(h,0):h())});
zh[d]=!0;Ah[b.toString()]||(Ah[b.toString()]=[]);Ah[b.toString()].push(d);return d}
function Gh(){var a=Hh,b=Eh(function(c){a.apply(void 0,arguments);Ih(b)});
return b}
function Ih(a){var b=Dh();b&&("number"===typeof a&&(a=[a]),F(a,function(c){b.unsubscribeByKey(c);delete zh[c]}))}
function Dh(){return z("ytPubsub2Pubsub2Instance")}
;function Jh(a){wh.call(this,1,arguments);this.csn=a}
q(Jh,wh);var Fh=new xh("screen-created",Jh),Kh=[],Lh=0;function Mh(a,b,c){var d=R("use_default_events_client")?void 0:vg;b={csn:a,parentVe:lh(b),childVes:Ma(c,function(f){return lh(f)})};
c=p(c);for(var e=c.next();!e.done;e=c.next())e=lh(e.value),(Xa(e)||!e.trackingParams&&!e.veType)&&Dg(Error("Child VE logged with no data"),"WARNING");c={ca:th(a),P:a};"UNDEFINED_CSN"==a?Nh("visualElementAttached",b,c):d?kg("visualElementAttached",b,d,c):wg("visualElementAttached",b,c)}
function Nh(a,b,c){Kh.push({payloadName:a,payload:b,options:c});Lh||(Lh=Gh())}
function Hh(a){if(Kh){for(var b=p(Kh),c=b.next();!c.done;c=b.next())c=c.value,c.payload&&(c.payload.csn=a.csn,kg(c.payloadName,c.payload,null,c.options));Kh.length=0}Lh=0}
;function Oh(a){a=a||{};var b={},c={};this.url=a.url||"";this.args=a.args||$a(b);this.assets=a.assets||{};this.attrs=a.attrs||$a(c);this.fallback=a.fallback||null;this.fallbackMessage=a.fallbackMessage||null;this.html5=!!a.html5;this.disable=a.disable||{};this.loaded=!!a.loaded;this.messages=a.messages||{}}
Oh.prototype.clone=function(){var a=new Oh,b;for(b in this)if(this.hasOwnProperty(b)){var c=this[b];"object"==xa(c)?a[b]=$a(c):a[b]=c}return a};function Ph(){M.call(this);this.f=[]}
q(Ph,M);Ph.prototype.o=function(){for(;this.f.length;){var a=this.f.pop();a.target.removeEventListener(a.name,a.pb)}M.prototype.o.call(this)};var Qh=/cssbin\/(?:debug-)?([a-zA-Z0-9_-]+?)(?:-2x|-web|-rtl|-vfl|.css)/;function Rh(a){a=a||"";if(window.spf){var b=a.match(Qh);spf.style.load(a,b?b[1]:"",void 0)}else Sh(a)}
function Sh(a){var b=Th(a),c=document.getElementById(b),d=c&&Ig(c,"loaded");d||c&&!d||(c=Uh(a,b,function(){Ig(c,"loaded")||(Gg(c),cf(b),S(Fa(df,b),0))}))}
function Uh(a,b,c){var d=document.createElement("link");d.id=b;d.onload=function(){c&&setTimeout(c,0)};
a=qc(a);d.rel="stylesheet";d.href=gb(a).toString();(document.getElementsByTagName("head")[0]||document.body).appendChild(d);return d}
function Th(a){var b=mc(document,"A");Bb(b,new H(qb,a));a=b.href.replace(/^[a-zA-Z]+:\/\//,"//");return"css-"+Eb(a)}
;function Vh(a,b,c,d){M.call(this);var e=this;this.m=this.X=a;this.U=b;this.w=!1;this.api={};this.V=this.G=null;this.H=new O;xc(this,Fa(yc,this.H));this.j={};this.R=this.W=this.h=this.ba=this.f=null;this.I=!1;this.l=this.B=null;this.Y={};this.ta=["onReady"];this.aa=null;this.ja=NaN;this.S={};this.i=d;Wh(this);this.Z("WATCH_LATER_VIDEO_ADDED",this.La.bind(this));this.Z("WATCH_LATER_VIDEO_REMOVED",this.Ma.bind(this));this.Z("onAdAnnounce",this.va.bind(this));this.ua=new Ph(this);xc(this,Fa(yc,this.ua));
this.T=0;c?this.T=S(function(){e.loadNewVideoConfig(c)},0):d&&(Xh(this),Yh(this))}
q(Vh,M);m=Vh.prototype;m.getId=function(){return this.U};
m.loadNewVideoConfig=function(a){if(!this.g){this.T&&(T(this.T),this.T=0);a instanceof Oh||(a=new Oh(a));this.ba=a;this.f=a.clone();Xh(this);this.W||(this.W=Zh(this,this.f.args.jsapicallback||"onYouTubePlayerReady"));this.f.args.jsapicallback=null;if(a=this.f.attrs.width)this.m.style.width=Ac(Number(a)||a);if(a=this.f.attrs.height)this.m.style.height=Ac(Number(a)||a);Yh(this);this.w&&$h(this)}};
function Xh(a){var b;a.i?b=a.i.rootElementId:b=a.f.attrs.id;a.h=b||a.h;"video-player"==a.h&&(a.h=a.U,a.f.attrs.id=a.U);a.m.id==a.h&&(a.h+="-player",a.f.attrs.id=a.h)}
m.Aa=function(){return this.ba};
function $h(a){a.f&&!a.f.loaded&&(a.f.loaded=!0,"0"!=a.f.args.autoplay?a.api.loadVideoByPlayerVars(a.f.args):a.api.cueVideoByPlayerVars(a.f.args))}
function ai(a){var b=!0,c=bi(a);c&&a.f&&(a=ci(a),b=Ig(c,"version")===a);return b&&!!z("yt.player.Application.create")}
function Yh(a){if(!a.g&&!a.I){var b=ai(a);if(b&&"html5"==(bi(a)?"html5":null))a.R="html5",a.w||di(a);else if(ei(a),a.R="html5",b&&a.l)a.X.appendChild(a.l),di(a);else{a.f&&(a.f.loaded=!0);var c=!1;a.B=function(){c=!0;if(a.i)var d=a.i.serializedExperimentFlags;else a.f&&a.f.args&&(d=a.f.args.fflags);d="true"==ne(d||"").player_bootstrap_method?z("yt.player.Application.createAlternate")||z("yt.player.Application.create"):z("yt.player.Application.create");var e=a.f?a.f.clone():void 0;d(a.X,e,a.i);di(a)};
a.I=!0;b?a.B():(Mg(ci(a),a.B),(b=a.i?a.i.cssUrl:a.f.assets.css)&&Rh(b),fi(a)&&!c&&y("yt.player.Application.create",null,void 0))}}}
function bi(a){var b=ic(a.h);!b&&a.m&&a.m.querySelector&&(b=a.m.querySelector("#"+a.h));return b}
function di(a){if(!a.g){var b=bi(a),c=!1;b&&b.getApiInterface&&b.getApiInterface()&&(c=!0);c?(a.I=!1,b.isNotServable&&a.f&&b.isNotServable(a.f.args.video_id)||gi(a)):a.ja=S(function(){di(a)},50)}}
function gi(a){Wh(a);a.w=!0;var b=bi(a);b.addEventListener&&(a.G=hi(a,b,"addEventListener"));b.removeEventListener&&(a.V=hi(a,b,"removeEventListener"));var c=b.getApiInterface();c=c.concat(b.getInternalApiInterface());for(var d=0;d<c.length;d++){var e=c[d];a.api[e]||(a.api[e]=hi(a,b,e))}for(var f in a.j)a.G(f,a.j[f]);$h(a);a.W&&a.W(a.api);a.H.M("onReady",a.api)}
function hi(a,b,c){var d=b[c];return function(){try{return a.aa=null,d.apply(b,arguments)}catch(e){"sendAbandonmentPing"!=c&&(e.params=c,a.aa=e,me(e))}}}
function Wh(a){a.w=!1;if(a.V)for(var b in a.j)a.V(b,a.j[b]);for(var c in a.S)T(parseInt(c,10));a.S={};a.G=null;a.V=null;for(var d in a.api)a.api[d]=null;a.api.addEventListener=a.Z.bind(a);a.api.removeEventListener=a.Qa.bind(a);a.api.destroy=a.dispose.bind(a);a.api.getLastError=a.Ba.bind(a);a.api.getPlayerType=a.Ca.bind(a);a.api.getCurrentVideoConfig=a.Aa.bind(a);a.api.loadNewVideoConfig=a.loadNewVideoConfig.bind(a);a.api.isReady=a.Ka.bind(a)}
m.Ka=function(){return this.w};
m.Z=function(a,b){var c=this,d=Zh(this,b);if(d){if(!(0<=Ka(this.ta,a)||this.j[a])){var e=ii(this,a);this.G&&this.G(a,e)}this.H.subscribe(a,d);"onReady"==a&&this.w&&S(function(){d(c.api)},0)}};
m.Qa=function(a,b){if(!this.g){var c=Zh(this,b);c&&Ld(this.H,a,c)}};
function Zh(a,b){var c=b;if("string"==typeof b){if(a.Y[b])return a.Y[b];c=function(){var d=z(b);d&&d.apply(x,arguments)};
a.Y[b]=c}return c?c:null}
function ii(a,b){var c="ytPlayer"+b+a.U;a.j[b]=c;x[c]=function(d){var e=S(function(){if(!a.g){a.H.M(b,d);var f=a.S,h=String(e);h in f&&delete f[h]}},0);
Ya(a.S,String(e))};
return c}
m.va=function(a){cf("a11y-announce",a)};
m.La=function(a){cf("WATCH_LATER_VIDEO_ADDED",a)};
m.Ma=function(a){cf("WATCH_LATER_VIDEO_REMOVED",a)};
m.Ca=function(){return this.R||(bi(this)?"html5":null)};
m.Ba=function(){return this.aa};
function ei(a){a.cancel();Wh(a);a.R=null;a.f&&(a.f.loaded=!1);var b=bi(a);b&&(ai(a)||!fi(a)?a.l=b:(b&&b.destroy&&b.destroy(),a.l=null));for(a=a.X;b=a.firstChild;)a.removeChild(b)}
m.cancel=function(){this.B&&Sg(ci(this),this.B);T(this.ja);this.I=!1};
m.o=function(){ei(this);if(this.l&&this.f&&this.l.destroy)try{this.l.destroy()}catch(b){le(b)}this.Y=null;for(var a in this.j)x[this.j[a]]=null;this.ba=this.f=this.api=null;delete this.X;delete this.m;M.prototype.o.call(this)};
function fi(a){return a.f&&a.f.args&&a.f.args.fflags?-1!=a.f.args.fflags.indexOf("player_destroy_old_version=true"):!1}
function ci(a){return a.i?a.i.jsUrl:a.f.assets.js}
;var ji={},ki="player_uid_"+(1E9*Math.random()>>>0);function li(a){delete ji[a.getId()]}
;function mi(a,b){for(var c=[],d=1;d<arguments.length;++d)c[d-1]=arguments[d];if(!ni(a)||c.some(function(e){return!ni(e)}))throw Error("Only objects may be merged.");
c=p(c);for(d=c.next();!d.done;d=c.next())oi(a,d.value);return a}
function oi(a,b){for(var c in b)if(ni(b[c])){if(c in a&&!ni(a[c]))throw Error("Cannot merge an object into a non-object.");c in a||(a[c]={});oi(a[c],b[c])}else if(pi(b[c])){if(c in a&&!pi(a[c]))throw Error("Cannot merge an array into a non-array.");c in a||(a[c]=[]);qi(a[c],b[c])}else a[c]=b[c];return a}
function qi(a,b){for(var c=p(b),d=c.next();!d.done;d=c.next())d=d.value,ni(d)?a.push(oi({},d)):pi(d)?a.push(qi([],d)):a.push(d);return a}
function ni(a){return"object"===typeof a&&!Array.isArray(a)}
function pi(a){return"object"===typeof a&&Array.isArray(a)}
;function ri(a,b){wh.call(this,1,arguments)}
q(ri,wh);function si(a,b){wh.call(this,1,arguments)}
q(si,wh);var ti=new xh("aft-recorded",ri),ui=new xh("timing-sent",si);var vi=window;function wi(){this.timing={};this.clearResourceTimings=function(){};
this.webkitClearResourceTimings=function(){};
this.mozClearResourceTimings=function(){};
this.msClearResourceTimings=function(){};
this.oClearResourceTimings=function(){}}
var xi=vi.performance||vi.mozPerformance||vi.msPerformance||vi.webkitPerformance||new wi;var yi=!1;B(xi.clearResourceTimings||xi.webkitClearResourceTimings||xi.mozClearResourceTimings||xi.msClearResourceTimings||xi.oClearResourceTimings||va,xi);function zi(a){var b=Ai(a);if(b.aft)return b.aft;a=Q((a||"")+"TIMING_AFT_KEYS",["ol"]);for(var c=a.length,d=0;d<c;d++){var e=b[a[d]];if(e)return e}return NaN}
function Bi(a){var b;(b=z("ytcsi."+(a||"")+"data_"))||(b={tick:{},info:{}},Ga("ytcsi."+(a||"")+"data_",b));return b}
function Ci(a){a=Bi(a);a.info||(a.info={});return a.info}
function Ai(a){a=Bi(a);a.tick||(a.tick={});return a.tick}
function Di(a){var b=Bi(a).nonce;b||(b=hh(),Bi(a).nonce=b);return b}
function Ei(a){var b=Ai(a||""),c=zi(a);c&&!yi&&(Ch(ti,new ri(Math.round(c-b._start),a)),yi=!0)}
;function Fi(){var a=z("ytcsi.debug");a||(a=[],y("ytcsi.debug",a,void 0),y("ytcsi.reference",{},void 0));return a}
function Gi(a){a=a||"";var b=z("ytcsi.reference");b||(Fi(),b=z("ytcsi.reference"));if(b[a])return b[a];var c=Fi(),d={timerName:a,info:{},tick:{},span:{}};c.push(d);return b[a]=d}
;var Hi=z("ytLoggingLatencyUsageStats_")||{};y("ytLoggingLatencyUsageStats_",Hi,void 0);function Ii(){this.f=0}
function Ji(){Ii.instance||(Ii.instance=new Ii);return Ii.instance}
Ii.prototype.tick=function(a,b,c){Ki(this,"tick_"+a+"_"+b)||wg("latencyActionTicked",{tickName:a,clientActionNonce:b},{timestamp:c})};
Ii.prototype.info=function(a,b){var c=Object.keys(a).join("");Ki(this,"info_"+c+"_"+b)||(a.clientActionNonce=b,wg("latencyActionInfo",a))};
Ii.prototype.span=function(a,b){var c=Object.keys(a).join("");Ki(this,"span_"+c+"_"+b)||(a.clientActionNonce=b,wg("latencyActionSpan",a))};
function Ki(a,b){Hi[b]=Hi[b]||{count:0};var c=Hi[b];c.count++;c.time=U();a.f||(a.f=cg(function(){var d=U(),e;for(e in Hi)Hi[e]&&6E4<d-Hi[e].time&&delete Hi[e];a&&(a.f=0)},0,5E3));
return 5<c.count?(6===c.count&&1>1E5*Math.random()&&(c=new xg("CSI data exceeded logging limit with key",b),0===b.indexOf("info")?Ag(c):Bg(c)),!0):!1}
;var Y={},Li=(Y.ad_allowed="adTypesAllowed",Y.yt_abt="adBreakType",Y.ad_cpn="adClientPlaybackNonce",Y.ad_docid="adVideoId",Y.yt_ad_an="adNetworks",Y.ad_at="adType",Y.browse_id="browseId",Y.p="httpProtocol",Y.t="transportProtocol",Y.cpn="clientPlaybackNonce",Y.ccs="creatorInfo.creatorCanaryState",Y.cseg="creatorInfo.creatorSegment",Y.csn="clientScreenNonce",Y.docid="videoId",Y.GetHome_rid="requestIds",Y.GetSearch_rid="requestIds",Y.GetPlayer_rid="requestIds",Y.GetWatchNext_rid="requestIds",Y.GetBrowse_rid=
"requestIds",Y.GetLibrary_rid="requestIds",Y.is_continuation="isContinuation",Y.is_nav="isNavigation",Y.b_p="kabukiInfo.browseParams",Y.is_prefetch="kabukiInfo.isPrefetch",Y.is_secondary_nav="kabukiInfo.isSecondaryNav",Y.prev_browse_id="kabukiInfo.prevBrowseId",Y.query_source="kabukiInfo.querySource",Y.voz_type="kabukiInfo.vozType",Y.yt_lt="loadType",Y.mver="creatorInfo.measurementVersion",Y.yt_ad="isMonetized",Y.nr="webInfo.navigationReason",Y.nrsu="navigationRequestedSameUrl",Y.ncnp="webInfo.nonPreloadedNodeCount",
Y.pnt="performanceNavigationTiming",Y.prt="playbackRequiresTap",Y.plt="playerInfo.playbackType",Y.pis="playerInfo.playerInitializedState",Y.paused="playerInfo.isPausedOnLoad",Y.yt_pt="playerType",Y.fmt="playerInfo.itag",Y.yt_pl="watchInfo.isPlaylist",Y.yt_pre="playerInfo.preloadType",Y.yt_ad_pr="prerollAllowed",Y.pa="previousAction",Y.yt_red="isRedSubscriber",Y.rce="mwebInfo.responseContentEncoding",Y.scrh="screenHeight",Y.scrw="screenWidth",Y.st="serverTimeMs",Y.aq="tvInfo.appQuality",Y.br_trs="tvInfo.bedrockTriggerState",
Y.kebqat="kabukiInfo.earlyBrowseRequestInfo.abandonmentType",Y.kebqa="kabukiInfo.earlyBrowseRequestInfo.adopted",Y.label="tvInfo.label",Y.is_mdx="tvInfo.isMdx",Y.preloaded="tvInfo.isPreloaded",Y.upg_player_vis="playerInfo.visibilityState",Y.query="unpluggedInfo.query",Y.upg_chip_ids_string="unpluggedInfo.upgChipIdsString",Y.yt_vst="videoStreamType",Y.vph="viewportHeight",Y.vpw="viewportWidth",Y.yt_vis="isVisible",Y.rcl="mwebInfo.responseContentLength",Y.GetSettings_rid="requestIds",Y.GetTrending_rid=
"requestIds",Y.GetMusicSearchSuggestions_rid="requestIds",Y.REQUEST_ID="requestIds",Y),Mi="isContinuation isNavigation kabukiInfo.earlyBrowseRequestInfo.adopted kabukiInfo.isPrefetch kabukiInfo.isSecondaryNav isMonetized navigationRequestedSameUrl performanceNavigationTiming playerInfo.isPausedOnLoad prerollAllowed isRedSubscriber tvInfo.isMdx tvInfo.isPreloaded isVisible watchInfo.isPlaylist playbackRequiresTap".split(" "),Ni={},Oi=(Ni.ccs="CANARY_STATE_",Ni.mver="MEASUREMENT_VERSION_",Ni.pis="PLAYER_INITIALIZED_STATE_",
Ni.yt_pt="LATENCY_PLAYER_",Ni.pa="LATENCY_ACTION_",Ni.yt_vst="VIDEO_STREAM_TYPE_",Ni),Pi="all_vc ap c cver cbrand cmodel cplatform ctheme ei l_an l_mm plid srt yt_fss yt_li vpst vpni2 vpil2 icrc icrt pa GetAccountOverview_rid GetHistory_rid cmt d_vpct d_vpnfi d_vpni nsru pc pfa pfeh pftr pnc prerender psc rc start tcrt tcrc ssr vpr vps yt_abt yt_fn yt_fs yt_pft yt_pre yt_pt yt_pvis ytu_pvis yt_ref yt_sts tds".split(" ");function Qi(a){return!!Q("FORCE_CSI_ON_GEL",!1)||R("csi_on_gel")||!!Bi(a).useGel}
function Ri(a){a=Bi(a);if(!("gel"in a))a.gel={gelTicks:{},gelInfos:{}};else if(a.gel){var b=a.gel;b.gelInfos||(b.gelInfos={});b.gelTicks||(b.gelTicks={})}return a.gel}
;function Si(a,b,c){if(null!==b)if(Ci(c)[a]=b,Qi(c)){var d=b;b=Ri(c);if(b.gelInfos)b.gelInfos["info_"+a]=!0;else{var e={};b.gelInfos=(e["info_"+a]=!0,e)}if(a in Li){if(a.match("_rid")){var f=a.split("_rid")[0];a="REQUEST_ID"}b=Li[a];0<=Ka(Mi,b)&&(d=!!d);a in Oi&&"string"===typeof d&&(d=Oi[a]+d.toUpperCase());a=d;d=b.split(".");for(var h=e={},g=0;g<d.length-1;g++){var k=d[g];h[k]={};h=h[k]}h[d[d.length-1]]="requestIds"===b?[{id:a,endpoint:f}]:a;f=mi({},e)}else 0<=Ka(Pi,a)||Ag(new xg("Unknown label logged with GEL CSI",
a)),f=void 0;f&&Qi(c)&&(b=Gi(c||""),mi(b.info,f),b=Ri(c),"gelInfos"in b||(b.gelInfos={}),mi(b.gelInfos,f),c=Di(c),Ji().info(f,c))}else Gi(c||"").info[a]=b}
function Ti(a,b,c){var d=Ai(c);if(R("use_first_tick")&&Ui(a,c))return d[a];if(!b&&"_"!==a[0]){var e=a;xi.mark&&(0==e.lastIndexOf("mark_",0)||(e="mark_"+e),c&&(e+=" ("+c+")"),xi.mark(e))}e=b||U();d[a]=e;e=Ri(c);e.gelTicks&&(e.gelTicks["tick_"+a]=!0);c||b||U();if(Qi(c)){Gi(c||"").tick[a]=b||U();e=Di(c);if("_start"===a){var f=Ji();Ki(f,"baseline_"+e)||wg("latencyActionBaselined",{clientActionNonce:e},{timestamp:b})}else Ji().tick(a,e,b);Ei(c);e=!0}else e=!1;if(!e){if(!z("yt.timing."+(c||"")+"pingSent_")&&
(f=Q((c||"")+"TIMING_ACTION",void 0),e=Ai(c),z("ytglobal.timing"+(c||"")+"ready_")&&f&&Ui("_start")&&zi(c)))if(Ei(c),c)Vi(c);else{f=!0;var h=Q("TIMING_WAIT",[]);if(h.length)for(var g=0,k=h.length;g<k;++g)if(!(h[g]in e)){f=!1;break}f&&Vi(c)}Gi(c||"").tick[a]=b||U()}return d[a]}
function Ui(a,b){var c=Ai(b);return a in c}
function Vi(a){if(!Qi(a)){var b=Ai(a),c=Ci(a),d=b._start,e=Q("CSI_SERVICE_NAME","youtube"),f={v:2,s:e,action:Q((a||"")+"TIMING_ACTION",void 0)},h=c.srt;void 0!==b.srt&&delete c.srt;b.aft=zi(a);var g=Ai(a),k=g.pbr,l=g.vc;g=g.pbs;k&&l&&g&&k<l&&l<g&&Ci(a).yt_pvis&&"youtube"===e&&(Si("yt_lt","hot_bg",a),e=b.vc,k=b.pbs,delete b.aft,c.aft=Math.round(k-e));for(var n in c)"_"!==n.charAt(0)&&(f[n]=c[n]);b.ps=U();n={};e=[];for(var r in b)"_"!==r.charAt(0)&&(k=Math.round(b[r]-d),n[r]=k,e.push(r+"."+k));f.rt=
e.join(",");b=!!c.ap;R("debug_csi_data")&&(c=z("yt.timing.csiData"),c||(c=[],Ga("yt.timing.csiData",c)),c.push({page:location.href,time:new Date,args:f}));c="";for(var w in f)f.hasOwnProperty(w)&&(c+="&"+w+"="+f[w]);f="/csi_204?"+c.substring(1);if(window.navigator&&window.navigator.sendBeacon&&b){var t=void 0===t?"":t;Ve(f,t)||Se(f,void 0,void 0,void 0,t)}else Se(f);y("yt.timing."+(a||"")+"pingSent_",!0,void 0);Ch(ui,new si(n.aft+(Number(h)||0),a))}}
if(R("overwrite_polyfill_on_logging_lib_loaded")){var Wi=window;Wi.ytcsi&&(Wi.ytcsi.info=Si,Wi.ytcsi.tick=Ti)};function Xi(a){return(0===a.search("cue")||0===a.search("load"))&&"loadModule"!==a}
function Yi(a,b,c){"string"===typeof a&&(a={mediaContentUrl:a,startSeconds:b,suggestedQuality:c});a:{if((b=a.mediaContentUrl)&&(b=/\/([ve]|embed)\/([^#?]+)/.exec(b))&&b[2]){b=b[2];break a}b=null}a.videoId=b;return Zi(a)}
function Zi(a,b,c){if("string"===typeof a)return{videoId:a,startSeconds:b,suggestedQuality:c};b=["endSeconds","startSeconds","mediaContentUrl","suggestedQuality","videoId"];c={};for(var d=0;d<b.length;d++){var e=b[d];a[e]&&(c[e]=a[e])}return c}
function $i(a,b,c,d){if(za(a)&&!Array.isArray(a)){b="playlist list listType index startSeconds suggestedQuality".split(" ");c={};for(d=0;d<b.length;d++){var e=b[d];a[e]&&(c[e]=a[e])}return c}b={index:b,startSeconds:c,suggestedQuality:d};"string"===typeof a&&16===a.length?b.list="PL"+a:b.playlist=a;return b}
;function aj(a){a=void 0===a?!1:a;M.call(this);this.f=new O(a);xc(this,Fa(yc,this.f))}
D(aj,M);aj.prototype.subscribe=function(a,b,c){return this.g?0:this.f.subscribe(a,b,c)};
aj.prototype.j=function(a,b){this.g||this.f.M.apply(this.f,arguments)};function bj(a,b,c){aj.call(this);this.h=a;this.i=b;this.l=c}
q(bj,aj);function cj(a,b,c){if(!a.g){var d=a.h;d.g||a.i!=d.f||(a={id:a.l,command:b},c&&(a.data=c),d.f.postMessage(nd(a),d.i))}}
bj.prototype.o=function(){this.i=this.h=null;aj.prototype.o.call(this)};function dj(a){M.call(this);this.f=a;this.f.subscribe("command",this.ra,this);this.h={};this.j=!1}
q(dj,M);m=dj.prototype;m.start=function(){this.j||this.g||(this.j=!0,cj(this.f,"RECEIVING"))};
m.ra=function(a,b,c){if(this.j&&!this.g){var d=b||{};switch(a){case "addEventListener":"string"===typeof d.event&&(a=d.event,a in this.h||(c=B(this.Sa,this,a),this.h[a]=c,this.addEventListener(a,c)));break;case "removeEventListener":"string"===typeof d.event&&ej(this,d.event);break;default:this.i.isReady()&&this.i.isExternalMethodAvailable(a,c||null)&&(b=fj(a,b||{}),c=this.i.handleExternalCall(a,b,c||null),(c=gj(a,c))&&this.j&&!this.g&&cj(this.f,a,c))}}};
m.Sa=function(a,b){this.j&&!this.g&&cj(this.f,a,this.ea(a,b))};
m.ea=function(a,b){if(null!=b)return{value:b}};
function ej(a,b){b in a.h&&(a.removeEventListener(b,a.h[b]),delete a.h[b])}
m.o=function(){var a=this.f;a.g||Ld(a.f,"command",this.ra,this);this.f=null;for(var b in this.h)ej(this,b);M.prototype.o.call(this)};function hj(a,b){dj.call(this,b);this.i=a;this.start()}
q(hj,dj);hj.prototype.addEventListener=function(a,b){this.i.addEventListener(a,b)};
hj.prototype.removeEventListener=function(a,b){this.i.removeEventListener(a,b)};
function fj(a,b){switch(a){case "loadVideoById":return b=Zi(b),[b];case "cueVideoById":return b=Zi(b),[b];case "loadVideoByPlayerVars":return[b];case "cueVideoByPlayerVars":return[b];case "loadPlaylist":return b=$i(b),[b];case "cuePlaylist":return b=$i(b),[b];case "seekTo":return[b.seconds,b.allowSeekAhead];case "playVideoAt":return[b.index];case "setVolume":return[b.volume];case "setPlaybackQuality":return[b.suggestedQuality];case "setPlaybackRate":return[b.suggestedRate];case "setLoop":return[b.loopPlaylists];
case "setShuffle":return[b.shufflePlaylist];case "getOptions":return[b.module];case "getOption":return[b.module,b.option];case "setOption":return[b.module,b.option,b.value];case "handleGlobalKeyDown":return[b.keyCode,b.shiftKey,b.ctrlKey,b.altKey,b.metaKey,b.key,b.code]}return[]}
function gj(a,b){switch(a){case "isMuted":return{muted:b};case "getVolume":return{volume:b};case "getPlaybackRate":return{playbackRate:b};case "getAvailablePlaybackRates":return{availablePlaybackRates:b};case "getVideoLoadedFraction":return{videoLoadedFraction:b};case "getPlayerState":return{playerState:b};case "getCurrentTime":return{currentTime:b};case "getPlaybackQuality":return{playbackQuality:b};case "getAvailableQualityLevels":return{availableQualityLevels:b};case "getDuration":return{duration:b};
case "getVideoUrl":return{videoUrl:b};case "getVideoEmbedCode":return{videoEmbedCode:b};case "getPlaylist":return{playlist:b};case "getPlaylistIndex":return{playlistIndex:b};case "getOptions":return{options:b};case "getOption":return{option:b}}}
hj.prototype.ea=function(a,b){switch(a){case "onReady":return;case "onStateChange":return{playerState:b};case "onPlaybackQualityChange":return{playbackQuality:b};case "onPlaybackRateChange":return{playbackRate:b};case "onError":return{errorCode:b}}return dj.prototype.ea.call(this,a,b)};
hj.prototype.o=function(){dj.prototype.o.call(this);delete this.i};function ij(a,b,c){M.call(this);var d=this;c=c||Q("POST_MESSAGE_ORIGIN",void 0)||window.document.location.protocol+"//"+window.document.location.hostname;this.h=b||null;this.w="*";this.i=c;this.sessionId=null;this.channel="widget";this.B=!!a;this.m=function(e){a:if(!("*"!=d.i&&e.origin!=d.i||d.h&&e.source!=d.h||"string"!==typeof e.data)){try{var f=JSON.parse(e.data)}catch(h){break a}if(!(null==f||d.B&&(d.sessionId&&d.sessionId!=f.id||d.channel&&d.channel!=f.channel))&&f)switch(f.event){case "listening":"null"!=
e.origin&&(d.i=d.w=e.origin);d.h=e.source;d.sessionId=f.id;d.f&&(d.f(),d.f=null);break;case "command":d.j&&(!d.l||0<=Ka(d.l,f.func))&&d.j(f.func,f.args,e.origin)}}};
this.l=this.f=this.j=null;window.addEventListener("message",this.m)}
q(ij,M);ij.prototype.sendMessage=function(a,b){var c=b||this.h;if(c){this.sessionId&&(a.id=this.sessionId);this.channel&&(a.channel=this.channel);try{var d=JSON.stringify(a);c.postMessage(d,this.w)}catch(e){me(e)}}};
ij.prototype.o=function(){window.removeEventListener("message",this.m);M.prototype.o.call(this)};function jj(){var a=this.g=new ij(!!Q("WIDGET_ID_ENFORCE")),b=B(this.Pa,this);a.j=b;a.l=null;this.g.channel="widget";if(a=Q("WIDGET_ID"))this.g.sessionId=a;this.i=[];this.l=!1;this.j={}}
m=jj.prototype;m.Pa=function(a,b,c){"addEventListener"==a&&b?(a=b[0],this.j[a]||"onReady"==a||(this.addEventListener(a,kj(this,a)),this.j[a]=!0)):this.ma(a,b,c)};
m.ma=function(){};
function kj(a,b){return B(function(c){this.sendMessage(b,c)},a)}
m.addEventListener=function(){};
m.za=function(){this.l=!0;this.sendMessage("initialDelivery",this.fa());this.sendMessage("onReady");F(this.i,this.sa,this);this.i=[]};
m.fa=function(){return null};
function lj(a,b){a.sendMessage("infoDelivery",b)}
m.sa=function(a){this.l?this.g.sendMessage(a):this.i.push(a)};
m.sendMessage=function(a,b){this.sa({event:a,info:void 0==b?null:b})};
m.dispose=function(){this.g=null};function mj(a){jj.call(this);this.f=a;this.h=[];this.addEventListener("onReady",B(this.Na,this));this.addEventListener("onVideoProgress",B(this.Wa,this));this.addEventListener("onVolumeChange",B(this.Xa,this));this.addEventListener("onApiChange",B(this.Ra,this));this.addEventListener("onPlaybackQualityChange",B(this.Ta,this));this.addEventListener("onPlaybackRateChange",B(this.Ua,this));this.addEventListener("onStateChange",B(this.Va,this));this.addEventListener("onWebglSettingsChanged",B(this.Ya,
this))}
q(mj,jj);m=mj.prototype;m.ma=function(a,b,c){if(this.f.isExternalMethodAvailable(a,c)){b=b||[];if(0<b.length&&Xi(a)){var d=b;if(za(d[0])&&!Array.isArray(d[0]))d=d[0];else{var e={};switch(a){case "loadVideoById":case "cueVideoById":e=Zi.apply(window,d);break;case "loadVideoByUrl":case "cueVideoByUrl":e=Yi.apply(window,d);break;case "loadPlaylist":case "cuePlaylist":e=$i.apply(window,d)}d=e}b.length=1;b[0]=d}this.f.handleExternalCall(a,b,c);Xi(a)&&lj(this,this.fa())}};
m.Na=function(){var a=B(this.za,this);this.g.f=a};
m.addEventListener=function(a,b){this.h.push({eventType:a,listener:b});this.f.addEventListener(a,b)};
m.fa=function(){if(!this.f)return null;var a=this.f.getApiInterface();Pa(a,"getVideoData");for(var b={apiInterface:a},c=0,d=a.length;c<d;c++){var e=a[c];if(0===e.search("get")||0===e.search("is")){var f=0;0===e.search("get")?f=3:0===e.search("is")&&(f=2);f=e.charAt(f).toLowerCase()+e.substr(f+1);try{var h=this.f[e]();b[f]=h}catch(g){}}}b.videoData=this.f.getVideoData();b.currentTimeLastUpdated_=C()/1E3;return b};
m.Va=function(a){a={playerState:a,currentTime:this.f.getCurrentTime(),duration:this.f.getDuration(),videoData:this.f.getVideoData(),videoStartBytes:0,videoBytesTotal:this.f.getVideoBytesTotal(),videoLoadedFraction:this.f.getVideoLoadedFraction(),playbackQuality:this.f.getPlaybackQuality(),availableQualityLevels:this.f.getAvailableQualityLevels(),currentTimeLastUpdated_:C()/1E3,playbackRate:this.f.getPlaybackRate(),mediaReferenceTime:this.f.getMediaReferenceTime()};this.f.getVideoUrl&&(a.videoUrl=
this.f.getVideoUrl());this.f.getVideoContentRect&&(a.videoContentRect=this.f.getVideoContentRect());this.f.getProgressState&&(a.progressState=this.f.getProgressState());this.f.getPlaylist&&(a.playlist=this.f.getPlaylist());this.f.getPlaylistIndex&&(a.playlistIndex=this.f.getPlaylistIndex());this.f.getStoryboardFormat&&(a.storyboardFormat=this.f.getStoryboardFormat());lj(this,a)};
m.Ta=function(a){lj(this,{playbackQuality:a})};
m.Ua=function(a){lj(this,{playbackRate:a})};
m.Ra=function(){for(var a=this.f.getOptions(),b={namespaces:a},c=0,d=a.length;c<d;c++){var e=a[c],f=this.f.getOptions(e);b[e]={options:f};for(var h=0,g=f.length;h<g;h++){var k=f[h],l=this.f.getOption(e,k);b[e][k]=l}}this.sendMessage("apiInfoDelivery",b)};
m.Xa=function(){lj(this,{muted:this.f.isMuted(),volume:this.f.getVolume()})};
m.Wa=function(a){a={currentTime:a,videoBytesLoaded:this.f.getVideoBytesLoaded(),videoLoadedFraction:this.f.getVideoLoadedFraction(),currentTimeLastUpdated_:C()/1E3,playbackRate:this.f.getPlaybackRate(),mediaReferenceTime:this.f.getMediaReferenceTime()};this.f.getProgressState&&(a.progressState=this.f.getProgressState());lj(this,a)};
m.Ya=function(){var a={sphericalProperties:this.f.getSphericalProperties()};lj(this,a)};
m.dispose=function(){jj.prototype.dispose.call(this);for(var a=0;a<this.h.length;a++){var b=this.h[a];this.f.removeEventListener(b.eventType,b.listener)}this.h=[]};function nj(a,b,c){M.call(this);this.f=a;this.i=c;this.j=W(window,"message",B(this.l,this));this.h=new bj(this,a,b);xc(this,Fa(yc,this.h))}
q(nj,M);nj.prototype.l=function(a){var b;if(b=!this.g)if(b=a.origin==this.i)a:{b=this.f;do{b:{var c=a.source;do{if(c==b){c=!0;break b}if(c==c.parent)break;c=c.parent}while(null!=c);c=!1}if(c){b=!0;break a}b=b.opener}while(null!=b);b=!1}if(b&&(b=a.data,"string"===typeof b)){try{b=JSON.parse(b)}catch(d){return}b.command&&(c=this.h,c.g||c.j("command",b.command,b.data,a.origin))}};
nj.prototype.o=function(){Yf(this.j);this.f=null;M.prototype.o.call(this)};function oj(){var a=$a(pj),b;return Ad(new N(function(c,d){a.onSuccess=function(e){Ae(e)?c(e):d(new qj("Request failed, status="+(e&&"status"in e?e.status:-1),"net.badstatus",e))};
a.onError=function(e){d(new qj("Unknown request error","net.unknown",e))};
a.O=function(e){d(new qj("Request timed out","net.timeout",e))};
b=Ke("//googleads.g.doubleclick.net/pagead/id",a)}),function(c){c instanceof Bd&&b.abort();
return yd(c)})}
function qj(a,b){E.call(this,a+", errorCode="+b);this.errorCode=b;this.name="PromiseAjaxError"}
q(qj,E);function rj(){this.g=0;this.f=null}
rj.prototype.then=function(a,b,c){return 1===this.g&&a?(a=a.call(c,this.f),td(a)?a:sj(a)):2===this.g&&b?(a=b.call(c,this.f),td(a)?a:tj(a)):this};
rj.prototype.getValue=function(){return this.f};
rj.prototype.$goog_Thenable=!0;function tj(a){var b=new rj;a=void 0===a?null:a;b.g=2;b.f=void 0===a?null:a;return b}
function sj(a){var b=new rj;a=void 0===a?null:a;b.g=1;b.f=void 0===a?null:a;return b}
;function uj(a){E.call(this,a.message||a.description||a.name);this.isMissing=a instanceof vj;this.isTimeout=a instanceof qj&&"net.timeout"==a.errorCode;this.isCanceled=a instanceof Bd}
q(uj,E);uj.prototype.name="BiscottiError";function vj(){E.call(this,"Biscotti ID is missing from server")}
q(vj,E);vj.prototype.name="BiscottiMissingError";var pj={format:"RAW",method:"GET",timeout:5E3,withCredentials:!0},wj=null;function ge(){if("1"===Ua(de(),"args","privembed"))return yd(Error("Biscotti ID is not available in private embed mode"));wj||(wj=Ad(oj().then(xj),function(a){return yj(2,a)}));
return wj}
function xj(a){a=a.responseText;if(0!=a.lastIndexOf(")]}'",0))throw new vj;a=JSON.parse(a.substr(4));if(1<(a.type||1))throw new vj;a=a.id;he(a);wj=sj(a);zj(18E5,2);return a}
function yj(a,b){var c=new uj(b);he("");wj=tj(c);0<a&&zj(12E4,a-1);throw c;}
function zj(a,b){S(function(){Ad(oj().then(xj,function(c){return yj(b,c)}),va)},a)}
function Aj(){try{var a=z("yt.ads.biscotti.getId_");return a?a():ge()}catch(b){return yd(b)}}
;function Bj(a){if("1"!==Ua(de(),"args","privembed")){a&&fe();try{Aj().then(function(){},function(){}),S(Bj,18E5)}catch(b){le(b)}}}
;var Z=z("ytglobal.prefsUserPrefsPrefs_")||{};y("ytglobal.prefsUserPrefsPrefs_",Z,void 0);function Cj(){this.f=Q("ALT_PREF_COOKIE_NAME","PREF");var a=ec.get(""+this.f,void 0);if(a){a=decodeURIComponent(a).split("&");for(var b=0;b<a.length;b++){var c=a[b].split("="),d=c[0];(c=c[1])&&(Z[d]=c.toString())}}}
m=Cj.prototype;m.get=function(a,b){Dj(a);Ej(a);var c=void 0!==Z[a]?Z[a].toString():null;return null!=c?c:b?b:""};
m.set=function(a,b){Dj(a);Ej(a);if(null==b)throw Error("ExpectedNotNull");Z[a]=b.toString()};
m.remove=function(a){Dj(a);Ej(a);delete Z[a]};
m.save=function(){pg(this.f,this.dump(),63072E3)};
m.clear=function(){for(var a in Z)delete Z[a]};
m.dump=function(){var a=[],b;for(b in Z)a.push(b+"="+encodeURIComponent(String(Z[b])));return a.join("&")};
function Ej(a){if(/^f([1-9][0-9]*)$/.test(a))throw Error("ExpectedRegexMatch: "+a);}
function Dj(a){if(!/^\w+$/.test(a))throw Error("ExpectedRegexMismatch: "+a);}
function Fj(a){a=void 0!==Z[a]?Z[a].toString():null;return null!=a&&/^[A-Fa-f0-9]+$/.test(a)?parseInt(a,16):null}
wa(Cj);var Gj=null,Hj=null,Ij=null,Jj={};function Kj(a){var b=a.id;a=a.ve_type;var c=jh++;a=new kh({veType:a,veCounter:c,elementIndex:void 0,dataElement:void 0,youtubeData:void 0});Jj[b]=a;b=rh();c=ph();b&&c&&Mh(b,c,[a])}
function Lj(a){var b=a.csn;a=a.root_ve_type;if(b&&a&&(uh(b,a),a=ph()))for(var c in Jj){var d=Jj[c];d&&Mh(b,a,[d])}}
function Mj(a){Jj[a.id]=new kh({trackingParams:a.tracking_params})}
function Nj(a){var b=rh(),c=Jj[a.id];if(b&&c){a=R("use_default_events_client")?void 0:vg;c={csn:b,ve:lh(c),gestureType:"INTERACTION_LOGGING_GESTURE_TYPE_GENERIC_CLICK"};var d={ca:th(b),P:b};"UNDEFINED_CSN"==b?Nh("visualElementGestured",c,d):a?kg("visualElementGestured",c,a,d):wg("visualElementGestured",c,d)}}
function Oj(a){a=a.ids;var b=rh();if(b)for(var c=0;c<a.length;c++){var d=Jj[a[c]];if(d){var e=b,f=R("use_default_events_client")?void 0:vg;d={csn:e,ve:lh(d),eventType:1};var h={ca:th(e),P:e};"UNDEFINED_CSN"==e?Nh("visualElementShown",d,h):f?kg("visualElementShown",d,f,h):wg("visualElementShown",d,h)}}}
;y("yt.setConfig",P,void 0);y("yt.config.set",P,void 0);y("yt.setMsg",Fg,void 0);y("yt.msgs.set",Fg,void 0);y("yt.logging.errors.log",Dg,void 0);
y("writeEmbed",function(){var a=Q("PLAYER_CONFIG",void 0);Bj(!0);"gvn"==a.args.ps&&(document.body.style.backgroundColor="transparent");var b=document.referrer,c=Q("POST_MESSAGE_ORIGIN");window!=window.top&&b&&b!=document.URL&&(a.args.loaderUrl=b);Q("LIGHTWEIGHT_AUTOPLAY")&&(a.args.autoplay="1");b="player";var d=void 0===d?!0:d;b="string"===typeof b?ic(b):b;var e=ki+"_"+Aa(b),f=ji[e];f&&d?a&&a.args&&a.args.fflags&&a.args.fflags.includes("web_player_remove_playerproxy=true")?f.api.loadVideoByPlayerVars(a.args||
null):f.loadNewVideoConfig(a):(f=new Vh(b,e,a,void 0),ji[e]=f,cf("player-added",f.api),xc(f,Fa(li,f)));a=f.api;Gj=a;a.addEventListener("onScreenChanged",Lj);a.addEventListener("onLogClientVeCreated",Kj);a.addEventListener("onLogServerVeCreated",Mj);a.addEventListener("onLogVeClicked",Nj);a.addEventListener("onLogVesShown",Oj);d=Q("POST_MESSAGE_ID","player");Q("ENABLE_JS_API")?Ij=new mj(a):Q("ENABLE_POST_API")&&"string"===typeof d&&"string"===typeof c&&(Hj=new nj(window.parent,d,c),Ij=new hj(a,Hj.h));
c=Q("BG_P",void 0);dh(c)&&(Q("BG_I")||Q("BG_IU"))&&($g=!0,Zg.initialize(Q("BG_I",null),Q("BG_IU",null),c,ch,void 0,!!Q("BG_CE",!1)));Vg()},void 0);
y("yt.www.watch.ads.restrictioncookie.spr",function(a){Se(a+"mac_204?action_fcts=1");return!0},void 0);
var Pj=ke(function(){Ti("ol",void 0,void 0);var a=Cj.getInstance(),b=!!((Fj("f"+(Math.floor(119/31)+1))||0)&67108864),c=1<window.devicePixelRatio;if(document.body&&cd(document.body,"exp-invert-logo"))if(c&&!cd(document.body,"inverted-hdpi")){var d=document.body;if(d.classList)d.classList.add("inverted-hdpi");else if(!cd(d,"inverted-hdpi")){var e=ad(d);bd(d,e+(0<e.length?" inverted-hdpi":"inverted-hdpi"))}}else!c&&cd(document.body,"inverted-hdpi")&&dd();b!=c&&(b="f"+(Math.floor(119/31)+1),d=Fj(b)||
0,d=c?d|67108864:d&-67108865,0==d?delete Z[b]:(c=d.toString(16),Z[b]=c.toString()),a.save())}),Qj=ke(function(){var a=Gj;
a&&a.sendAbandonmentPing&&a.sendAbandonmentPing();Q("PL_ATT")&&Zg.dispose();a=0;for(var b=Tg.length;a<b;a++){var c=Tg[a];if(!isNaN(c)){var d=z("yt.scheduler.instance.cancelJob");d?d(c):T(c)}}Tg.length=0;Rg("//static.doubleclick.net/instream/ad_status.js");Ug=!1;P("DCLKSTAT",0);zc(Ij,Hj);if(a=Gj)a.removeEventListener("onScreenChanged",Lj),a.removeEventListener("onLogClientVeCreated",Kj),a.removeEventListener("onLogServerVeCreated",Mj),a.removeEventListener("onLogVeClicked",Nj),a.removeEventListener("onLogVesShown",
Oj),a.destroy();Jj={}});
window.addEventListener?(window.addEventListener("load",Pj),window.addEventListener("unload",Qj)):window.attachEvent&&(window.attachEvent("onload",Pj),window.attachEvent("onunload",Qj));Ga("yt.abuse.player.botguardInitialized",z("yt.abuse.player.botguardInitialized")||eh);Ga("yt.abuse.player.invokeBotguard",z("yt.abuse.player.invokeBotguard")||fh);Ga("yt.abuse.dclkstatus.checkDclkStatus",z("yt.abuse.dclkstatus.checkDclkStatus")||Wg);
Ga("yt.player.exports.navigate",z("yt.player.exports.navigate")||vh);Ga("yt.util.activity.init",z("yt.util.activity.init")||fg);Ga("yt.util.activity.getTimeSinceActive",z("yt.util.activity.getTimeSinceActive")||ig);Ga("yt.util.activity.setTimestamp",z("yt.util.activity.setTimestamp")||gg);}).call(this);

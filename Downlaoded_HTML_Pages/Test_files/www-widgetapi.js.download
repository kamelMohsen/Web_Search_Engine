(function(){/*

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/
var r;function aa(a){var b=0;return function(){return b<a.length?{done:!1,value:a[b++]}:{done:!0}}}
function t(a){var b="undefined"!=typeof Symbol&&Symbol.iterator&&a[Symbol.iterator];return b?b.call(a):{next:aa(a)}}
var ba="function"==typeof Object.create?Object.create:function(a){function b(){}
b.prototype=a;return new b},ca;
if("function"==typeof Object.setPrototypeOf)ca=Object.setPrototypeOf;else{var da;a:{var ea={a:!0},fa={};try{fa.__proto__=ea;da=fa.a;break a}catch(a){}da=!1}ca=da?function(a,b){a.__proto__=b;if(a.__proto__!==b)throw new TypeError(a+" is not extensible");return a}:null}var ia=ca;
function ja(a,b){a.prototype=ba(b.prototype);a.prototype.constructor=a;if(ia)ia(a,b);else for(var c in b)if("prototype"!=c)if(Object.defineProperties){var d=Object.getOwnPropertyDescriptor(b,c);d&&Object.defineProperty(a,c,d)}else a[c]=b[c];a.A=b.prototype}
var ka="function"==typeof Object.defineProperties?Object.defineProperty:function(a,b,c){if(a==Array.prototype||a==Object.prototype)return a;a[b]=c.value;return a};
function la(a){a=["object"==typeof globalThis&&globalThis,a,"object"==typeof window&&window,"object"==typeof self&&self,"object"==typeof global&&global];for(var b=0;b<a.length;++b){var c=a[b];if(c&&c.Math==Math)return c}throw Error("Cannot find global object");}
var ma=la(this);function u(a,b){if(b){for(var c=ma,d=a.split("."),e=0;e<d.length-1;e++){var f=d[e];f in c||(c[f]={});c=c[f]}d=d[d.length-1];e=c[d];f=b(e);f!=e&&null!=f&&ka(c,d,{configurable:!0,writable:!0,value:f})}}
function na(a,b,c){if(null==a)throw new TypeError("The 'this' value for String.prototype."+c+" must not be null or undefined");if(b instanceof RegExp)throw new TypeError("First argument to String.prototype."+c+" must not be a regular expression");return a+""}
u("String.prototype.endsWith",function(a){return a?a:function(b,c){var d=na(this,b,"endsWith");b+="";void 0===c&&(c=d.length);for(var e=Math.max(0,Math.min(c|0,d.length)),f=b.length;0<f&&0<e;)if(d[--e]!=b[--f])return!1;return 0>=f}});
u("String.prototype.startsWith",function(a){return a?a:function(b,c){var d=na(this,b,"startsWith");b+="";for(var e=d.length,f=b.length,l=Math.max(0,Math.min(c|0,d.length)),h=0;h<f&&l<e;)if(d[l++]!=b[h++])return!1;return h>=f}});
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
u("WeakMap",function(a){function b(g){this.f=(h+=Math.random()+1).toString();if(g){g=t(g);for(var k;!(k=g.next()).done;)k=k.value,this.set(k[0],k[1])}}
function c(){}
function d(g){var k=typeof g;return"object"===k&&null!==g||"function"===k}
function e(g){if(!v(g,l)){var k=new c;ka(g,l,{value:k})}}
function f(g){var k=Object[g];k&&(Object[g]=function(m){if(m instanceof c)return m;e(m);return k(m)})}
if(function(){if(!a||!Object.seal)return!1;try{var g=Object.seal({}),k=Object.seal({}),m=new a([[g,2],[k,3]]);if(2!=m.get(g)||3!=m.get(k))return!1;m["delete"](g);m.set(k,4);return!m.has(g)&&4==m.get(k)}catch(n){return!1}}())return a;
var l="$jscomp_hidden_"+Math.random();f("freeze");f("preventExtensions");f("seal");var h=0;b.prototype.set=function(g,k){if(!d(g))throw Error("Invalid WeakMap key");e(g);if(!v(g,l))throw Error("WeakMap key fail: "+g);g[l][this.f]=k;return this};
b.prototype.get=function(g){return d(g)&&v(g,l)?g[l][this.f]:void 0};
b.prototype.has=function(g){return d(g)&&v(g,l)&&v(g[l],this.f)};
b.prototype["delete"]=function(g){return d(g)&&v(g,l)&&v(g[l],this.f)?delete g[l][this.f]:!1};
return b});
u("Map",function(a){function b(){var h={};return h.previous=h.next=h.head=h}
function c(h,g){var k=h.f;return pa(function(){if(k){for(;k.head!=h.f;)k=k.previous;for(;k.next!=k.head;)return k=k.next,{done:!1,value:g(k)};k=null}return{done:!0,value:void 0}})}
function d(h,g){var k=g&&typeof g;"object"==k||"function"==k?f.has(g)?k=f.get(g):(k=""+ ++l,f.set(g,k)):k="p_"+g;var m=h.g[k];if(m&&v(h.g,k))for(var n=0;n<m.length;n++){var p=m[n];if(g!==g&&p.key!==p.key||g===p.key)return{id:k,list:m,index:n,j:p}}return{id:k,list:m,index:-1,j:void 0}}
function e(h){this.g={};this.f=b();this.size=0;if(h){h=t(h);for(var g;!(g=h.next()).done;)g=g.value,this.set(g[0],g[1])}}
if(function(){if(!a||"function"!=typeof a||!a.prototype.entries||"function"!=typeof Object.seal)return!1;try{var h=Object.seal({x:4}),g=new a(t([[h,"s"]]));if("s"!=g.get(h)||1!=g.size||g.get({x:4})||g.set({x:4},"t")!=g||2!=g.size)return!1;var k=g.entries(),m=k.next();if(m.done||m.value[0]!=h||"s"!=m.value[1])return!1;m=k.next();return m.done||4!=m.value[0].x||"t"!=m.value[1]||!k.next().done?!1:!0}catch(n){return!1}}())return a;
oa();var f=new WeakMap;e.prototype.set=function(h,g){h=0===h?0:h;var k=d(this,h);k.list||(k.list=this.g[k.id]=[]);k.j?k.j.value=g:(k.j={next:this.f,previous:this.f.previous,head:this.f,key:h,value:g},k.list.push(k.j),this.f.previous.next=k.j,this.f.previous=k.j,this.size++);return this};
e.prototype["delete"]=function(h){h=d(this,h);return h.j&&h.list?(h.list.splice(h.index,1),h.list.length||delete this.g[h.id],h.j.previous.next=h.j.next,h.j.next.previous=h.j.previous,h.j.head=null,this.size--,!0):!1};
e.prototype.clear=function(){this.g={};this.f=this.f.previous=b();this.size=0};
e.prototype.has=function(h){return!!d(this,h).j};
e.prototype.get=function(h){return(h=d(this,h).j)&&h.value};
e.prototype.entries=function(){return c(this,function(h){return[h.key,h.value]})};
e.prototype.keys=function(){return c(this,function(h){return h.key})};
e.prototype.values=function(){return c(this,function(h){return h.value})};
e.prototype.forEach=function(h,g){for(var k=this.entries(),m;!(m=k.next()).done;)m=m.value,h.call(g,m[1],m[0],this)};
e.prototype[Symbol.iterator]=e.prototype.entries;var l=0;return e});
u("Object.entries",function(a){return a?a:function(b){var c=[],d;for(d in b)v(b,d)&&c.push([d,b[d]]);return c}});
u("Set",function(a){function b(c){this.f=new Map;if(c){c=t(c);for(var d;!(d=c.next()).done;)this.add(d.value)}this.size=this.f.size}
if(function(){if(!a||"function"!=typeof a||!a.prototype.entries||"function"!=typeof Object.seal)return!1;try{var c=Object.seal({x:4}),d=new a(t([c]));if(!d.has(c)||1!=d.size||d.add(c)!=d||1!=d.size||d.add({x:4})!=d||2!=d.size)return!1;var e=d.entries(),f=e.next();if(f.done||f.value[0]!=c||f.value[1]!=c)return!1;f=e.next();return f.done||f.value[0]==c||4!=f.value[0].x||f.value[1]!=f.value[0]?!1:e.next().done}catch(l){return!1}}())return a;
oa();b.prototype.add=function(c){c=0===c?0:c;this.f.set(c,c);this.size=this.f.size;return this};
b.prototype["delete"]=function(c){c=this.f["delete"](c);this.size=this.f.size;return c};
b.prototype.clear=function(){this.f.clear();this.size=0};
b.prototype.has=function(c){return this.f.has(c)};
b.prototype.entries=function(){return this.f.entries()};
b.prototype.values=function(){return this.f.values()};
b.prototype.keys=b.prototype.values;b.prototype[Symbol.iterator]=b.prototype.values;b.prototype.forEach=function(c,d){var e=this;this.f.forEach(function(f){return c.call(d,f,f,e)})};
return b});
u("String.prototype.includes",function(a){return a?a:function(b,c){return-1!==na(this,b,"includes").indexOf(b,c||0)}});
var w=this||self;function y(a,b){for(var c=a.split("."),d=b||w,e=0;e<c.length;e++)if(d=d[c[e]],null==d)return null;return d}
function ra(){}
function sa(a){var b=typeof a;if("object"==b)if(a){if(a instanceof Array)return"array";if(a instanceof Object)return b;var c=Object.prototype.toString.call(a);if("[object Window]"==c)return"object";if("[object Array]"==c||"number"==typeof a.length&&"undefined"!=typeof a.splice&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("splice"))return"array";if("[object Function]"==c||"undefined"!=typeof a.call&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("call"))return"function"}else return"null";
else if("function"==b&&"undefined"==typeof a.call)return"object";return b}
function ta(a){var b=sa(a);return"array"==b||"object"==b&&"number"==typeof a.length}
function ua(a){return"function"==sa(a)}
function va(a){var b=typeof a;return"object"==b&&null!=a||"function"==b}
function wa(a){return Object.prototype.hasOwnProperty.call(a,xa)&&a[xa]||(a[xa]=++ya)}
var xa="closure_uid_"+(1E9*Math.random()>>>0),ya=0;function za(a,b,c){return a.call.apply(a.bind,arguments)}
function Aa(a,b,c){if(!a)throw Error();if(2<arguments.length){var d=Array.prototype.slice.call(arguments,2);return function(){var e=Array.prototype.slice.call(arguments);Array.prototype.unshift.apply(e,d);return a.apply(b,e)}}return function(){return a.apply(b,arguments)}}
function z(a,b,c){Function.prototype.bind&&-1!=Function.prototype.bind.toString().indexOf("native code")?z=za:z=Aa;return z.apply(null,arguments)}
function Ba(a,b){var c=Array.prototype.slice.call(arguments,1);return function(){var d=c.slice();d.push.apply(d,arguments);return a.apply(this,d)}}
var A=Date.now||function(){return+new Date};
function C(a,b){var c=a.split("."),d=w;c[0]in d||"undefined"==typeof d.execScript||d.execScript("var "+c[0]);for(var e;c.length&&(e=c.shift());)c.length||void 0===b?d[e]&&d[e]!==Object.prototype[e]?d=d[e]:d=d[e]={}:d[e]=b}
function D(a,b){function c(){}
c.prototype=b.prototype;a.A=b.prototype;a.prototype=new c;a.prototype.constructor=a}
;var Da=Array.prototype.indexOf?function(a,b){return Array.prototype.indexOf.call(a,b,void 0)}:function(a,b){if("string"===typeof a)return"string"!==typeof b||1!=b.length?-1:a.indexOf(b,0);
for(var c=0;c<a.length;c++)if(c in a&&a[c]===b)return c;return-1},E=Array.prototype.forEach?function(a,b,c){Array.prototype.forEach.call(a,b,c)}:function(a,b,c){for(var d=a.length,e="string"===typeof a?a.split(""):a,f=0;f<d;f++)f in e&&b.call(c,e[f],f,a)},Ea=Array.prototype.reduce?function(a,b,c){return Array.prototype.reduce.call(a,b,c)}:function(a,b,c){var d=c;
E(a,function(e,f){d=b.call(void 0,d,e,f,a)});
return d};
function Fa(a,b){a:{var c=a.length;for(var d="string"===typeof a?a.split(""):a,e=0;e<c;e++)if(e in d&&b.call(void 0,d[e],e,a)){c=e;break a}c=-1}return 0>c?null:"string"===typeof a?a.charAt(c):a[c]}
function Ga(a){return Array.prototype.concat.apply([],arguments)}
function Ha(a){var b=a.length;if(0<b){for(var c=Array(b),d=0;d<b;d++)c[d]=a[d];return c}return[]}
function Ia(a,b){for(var c=1;c<arguments.length;c++){var d=arguments[c];if(ta(d)){var e=a.length||0,f=d.length||0;a.length=e+f;for(var l=0;l<f;l++)a[e+l]=d[l]}else a.push(d)}}
;function Ja(a){var b=!1,c;return function(){b||(c=a(),b=!0);return c}}
;function Ka(a,b){for(var c in a)b.call(void 0,a[c],c,a)}
function La(a){var b=F,c;for(c in b)if(a.call(void 0,b[c],c,b))return c}
function Ma(a){for(var b in a)return!1;return!0}
function Na(a,b){for(var c in a)if(!(c in b)||a[c]!==b[c])return!1;for(var d in b)if(!(d in a))return!1;return!0}
function Oa(a){var b=sa(a);if("object"==b||"array"==b){if(ua(a.clone))return a.clone();b="array"==b?[]:{};for(var c in a)b[c]=Oa(a[c]);return b}return a}
var Pa="constructor hasOwnProperty isPrototypeOf propertyIsEnumerable toLocaleString toString valueOf".split(" ");function Qa(a,b){for(var c,d,e=1;e<arguments.length;e++){d=arguments[e];for(c in d)a[c]=d[c];for(var f=0;f<Pa.length;f++)c=Pa[f],Object.prototype.hasOwnProperty.call(d,c)&&(a[c]=d[c])}}
;var Ra=String.prototype.trim?function(a){return a.trim()}:function(a){return/^[\s\xa0]*([\s\S]*?)[\s\xa0]*$/.exec(a)[1]},Sa=/&/g,Ta=/</g,Ua=/>/g,Va=/"/g,Wa=/'/g,Xa=/\x00/g,Ya=/[\x00&<>"']/;var Za;a:{var $a=w.navigator;if($a){var ab=$a.userAgent;if(ab){Za=ab;break a}}Za=""}function G(a){return-1!=Za.indexOf(a)}
;function bb(){}
;var cb=G("Opera"),db=G("Trident")||G("MSIE"),eb=G("Edge"),fb=G("Gecko")&&!(-1!=Za.toLowerCase().indexOf("webkit")&&!G("Edge"))&&!(G("Trident")||G("MSIE"))&&!G("Edge"),gb=-1!=Za.toLowerCase().indexOf("webkit")&&!G("Edge");function hb(){var a=w.document;return a?a.documentMode:void 0}
var ib;a:{var jb="",kb=function(){var a=Za;if(fb)return/rv:([^\);]+)(\)|;)/.exec(a);if(eb)return/Edge\/([\d\.]+)/.exec(a);if(db)return/\b(?:MSIE|rv)[: ]([^\);]+)(\)|;)/.exec(a);if(gb)return/WebKit\/(\S+)/.exec(a);if(cb)return/(?:Version)[ \/]?(\S+)/.exec(a)}();
kb&&(jb=kb?kb[1]:"");if(db){var lb=hb();if(null!=lb&&lb>parseFloat(jb)){ib=String(lb);break a}}ib=jb}var mb=ib,nb;if(w.document&&db){var ob=hb();nb=ob?ob:parseInt(mb,10)||void 0}else nb=void 0;var pb=nb;var qb={},sb=null;var H=window;function tb(a){var b=y("window.location.href");null==a&&(a='Unknown Error of type "null/undefined"');if("string"===typeof a)return{message:a,name:"Unknown error",lineNumber:"Not available",fileName:b,stack:"Not available"};var c=!1;try{var d=a.lineNumber||a.line||"Not available"}catch(f){d="Not available",c=!0}try{var e=a.fileName||a.filename||a.sourceURL||w.$googDebugFname||b}catch(f){e="Not available",c=!0}return!c&&a.lineNumber&&a.fileName&&a.stack&&a.message&&a.name?a:(b=a.message,null==b&&(a.constructor&&
a.constructor instanceof Function?(a.constructor.name?b=a.constructor.name:(b=a.constructor,ub[b]?b=ub[b]:(b=String(b),ub[b]||(c=/function\s+([^\(]+)/m.exec(b),ub[b]=c?c[1]:"[Anonymous]"),b=ub[b])),b='Unknown Error of type "'+b+'"'):b="Unknown Error of unknown type"),{message:b,name:a.name||"UnknownError",lineNumber:d,fileName:e,stack:a.stack||"Not available"})}
var ub={};function vb(a){this.f=a||{cookie:""}}
r=vb.prototype;r.isEnabled=function(){return navigator.cookieEnabled};
r.set=function(a,b,c){var d=!1;if("object"===typeof c){var e=c.ya;d=c.secure||!1;var f=c.domain||void 0;var l=c.path||void 0;var h=c.M}if(/[;=\s]/.test(a))throw Error('Invalid cookie name "'+a+'"');if(/[;\r\n]/.test(b))throw Error('Invalid cookie value "'+b+'"');void 0===h&&(h=-1);c=f?";domain="+f:"";l=l?";path="+l:"";d=d?";secure":"";h=0>h?"":0==h?";expires="+(new Date(1970,1,1)).toUTCString():";expires="+(new Date(A()+1E3*h)).toUTCString();this.f.cookie=a+"="+b+c+l+h+d+(null!=e?";samesite="+e:"")};
r.get=function(a,b){for(var c=a+"=",d=(this.f.cookie||"").split(";"),e=0,f;e<d.length;e++){f=Ra(d[e]);if(0==f.lastIndexOf(c,0))return f.substr(c.length);if(f==a)return""}return b};
r.remove=function(a,b,c){var d=void 0!==this.get(a);this.set(a,"",{M:0,path:b,domain:c});return d};
r.isEmpty=function(){return!this.f.cookie};
r.clear=function(){for(var a=(this.f.cookie||"").split(";"),b=[],c=[],d,e,f=0;f<a.length;f++)e=Ra(a[f]),d=e.indexOf("="),-1==d?(b.push(""),c.push(e)):(b.push(e.substring(0,d)),c.push(e.substring(d+1)));for(a=b.length-1;0<=a;a--)this.remove(b[a])};
var wb=new vb("undefined"==typeof document?null:document);function xb(a,b){this.width=a;this.height=b}
r=xb.prototype;r.clone=function(){return new xb(this.width,this.height)};
r.aspectRatio=function(){return this.width/this.height};
r.isEmpty=function(){return!(this.width*this.height)};
r.ceil=function(){this.width=Math.ceil(this.width);this.height=Math.ceil(this.height);return this};
r.floor=function(){this.width=Math.floor(this.width);this.height=Math.floor(this.height);return this};
r.round=function(){this.width=Math.round(this.width);this.height=Math.round(this.height);return this};function yb(a,b){var c,d;var e=document;e=b||e;if(e.querySelectorAll&&e.querySelector&&a)return e.querySelectorAll(a?"."+a:"");if(a&&e.getElementsByClassName){var f=e.getElementsByClassName(a);return f}f=e.getElementsByTagName("*");if(a){var l={};for(c=d=0;e=f[c];c++){var h=e.className,g;if(g="function"==typeof h.split)g=0<=Da(h.split(/\s+/),a);g&&(l[d++]=e)}l.length=d;return l}return f}
function zb(){var a=document;var b="IFRAME";"application/xhtml+xml"===a.contentType&&(b=b.toLowerCase());return a.createElement(b)}
function Ab(a,b){for(var c=0;a;){if(b(a))return a;a=a.parentNode;c++}return null}
;var Bb=/^(?:([^:/?#.]+):)?(?:\/\/(?:([^\\/?#]*)@)?([^\\/?#]*?)(?::([0-9]+))?(?=[\\/?#]|$))?([^?#]+)?(?:\?([^#]*))?(?:#([\s\S]*))?$/;function I(a){return a.match(Bb)}
function J(a){return a?decodeURI(a):a}
function Cb(a){var b=I(a);a=b[1];var c=b[2],d=b[3];b=b[4];var e="";a&&(e+=a+":");d&&(e+="//",c&&(e+=c+"@"),e+=d,b&&(e+=":"+b));return e}
function Db(a,b,c){if(Array.isArray(b))for(var d=0;d<b.length;d++)Db(a,String(b[d]),c);else null!=b&&c.push(a+(""===b?"":"="+encodeURIComponent(String(b))))}
function Eb(a){var b=[],c;for(c in a)Db(c,a[c],b);return b.join("&")}
var Fb=/#|$/;function Gb(a){var b=Hb;if(b)for(var c in b)Object.prototype.hasOwnProperty.call(b,c)&&a.call(void 0,b[c],c,b)}
function Ib(){var a=[];Gb(function(b){a.push(b)});
return a}
var Hb={ga:"allow-forms",ha:"allow-modals",ia:"allow-orientation-lock",ja:"allow-pointer-lock",ka:"allow-popups",la:"allow-popups-to-escape-sandbox",ma:"allow-presentation",na:"allow-same-origin",oa:"allow-scripts",pa:"allow-top-navigation",qa:"allow-top-navigation-by-user-activation"},Jb=Ja(function(){return Ib()});
function Kb(){var a=zb(),b={};E(Jb(),function(c){a.sandbox&&a.sandbox.supports&&a.sandbox.supports(c)&&(b[c]=!0)});
return b}
;function Lb(){this.h=this.h;this.i=this.i}
Lb.prototype.h=!1;Lb.prototype.dispose=function(){this.h||(this.h=!0,this.H())};
Lb.prototype.H=function(){if(this.i)for(;this.i.length;)this.i.shift()()};var Mb=(new Date).getTime();function Nb(a){if(!a)return"";a=a.split("#")[0].split("?")[0];a=a.toLowerCase();0==a.indexOf("//")&&(a=window.location.protocol+a);/^[\w\-]*:\/\//.test(a)||(a=window.location.href);var b=a.substring(a.indexOf("://")+3),c=b.indexOf("/");-1!=c&&(b=b.substring(0,c));a=a.substring(0,a.indexOf("://"));if("http"!==a&&"https"!==a&&"chrome-extension"!==a&&"file"!==a&&"android-app"!==a&&"chrome-search"!==a&&"chrome-untrusted"!==a&&"chrome"!==a&&"app"!==a)throw Error("Invalid URI scheme in origin: "+a);c="";
var d=b.indexOf(":");if(-1!=d){var e=b.substring(d+1);b=b.substring(0,d);if("http"===a&&"80"!==e||"https"===a&&"443"!==e)c=":"+e}return a+"://"+b+c}
;function Ob(){function a(){e[0]=1732584193;e[1]=4023233417;e[2]=2562383102;e[3]=271733878;e[4]=3285377520;m=k=0}
function b(n){for(var p=l,q=0;64>q;q+=4)p[q/4]=n[q]<<24|n[q+1]<<16|n[q+2]<<8|n[q+3];for(q=16;80>q;q++)n=p[q-3]^p[q-8]^p[q-14]^p[q-16],p[q]=(n<<1|n>>>31)&4294967295;n=e[0];var x=e[1],B=e[2],U=e[3],rb=e[4];for(q=0;80>q;q++){if(40>q)if(20>q){var ha=U^x&(B^U);var Ca=1518500249}else ha=x^B^U,Ca=1859775393;else 60>q?(ha=x&B|U&(x|B),Ca=2400959708):(ha=x^B^U,Ca=3395469782);ha=((n<<5|n>>>27)&4294967295)+ha+rb+Ca+p[q]&4294967295;rb=U;U=B;B=(x<<30|x>>>2)&4294967295;x=n;n=ha}e[0]=e[0]+n&4294967295;e[1]=e[1]+
x&4294967295;e[2]=e[2]+B&4294967295;e[3]=e[3]+U&4294967295;e[4]=e[4]+rb&4294967295}
function c(n,p){if("string"===typeof n){n=unescape(encodeURIComponent(n));for(var q=[],x=0,B=n.length;x<B;++x)q.push(n.charCodeAt(x));n=q}p||(p=n.length);q=0;if(0==k)for(;q+64<p;)b(n.slice(q,q+64)),q+=64,m+=64;for(;q<p;)if(f[k++]=n[q++],m++,64==k)for(k=0,b(f);q+64<p;)b(n.slice(q,q+64)),q+=64,m+=64}
function d(){var n=[],p=8*m;56>k?c(h,56-k):c(h,64-(k-56));for(var q=63;56<=q;q--)f[q]=p&255,p>>>=8;b(f);for(q=p=0;5>q;q++)for(var x=24;0<=x;x-=8)n[p++]=e[q]>>x&255;return n}
for(var e=[],f=[],l=[],h=[128],g=1;64>g;++g)h[g]=0;var k,m;a();return{reset:a,update:c,digest:d,W:function(){for(var n=d(),p="",q=0;q<n.length;q++)p+="0123456789ABCDEF".charAt(Math.floor(n[q]/16))+"0123456789ABCDEF".charAt(n[q]%16);return p}}}
;function Pb(a,b,c){var d=[],e=[];if(1==(Array.isArray(c)?2:1))return e=[b,a],E(d,function(h){e.push(h)}),Qb(e.join(" "));
var f=[],l=[];E(c,function(h){l.push(h.key);f.push(h.value)});
c=Math.floor((new Date).getTime()/1E3);e=0==f.length?[c,b,a]:[f.join(":"),c,b,a];E(d,function(h){e.push(h)});
a=Qb(e.join(" "));a=[c,a];0==l.length||a.push(l.join(""));return a.join("_")}
function Qb(a){var b=Ob();b.update(a);return b.W().toLowerCase()}
;function Rb(a){var b=Nb(String(w.location.href)),c;(c=w.__SAPISID||w.__APISID||w.__OVERRIDE_SID)?c=!0:(c=new vb(document),c=c.get("SAPISID")||c.get("APISID")||c.get("__Secure-3PAPISID")||c.get("SID"),c=!!c);if(c&&(c=(b=0==b.indexOf("https:")||0==b.indexOf("chrome-extension:"))?w.__SAPISID:w.__APISID,c||(c=new vb(document),c=c.get(b?"SAPISID":"APISID")||c.get("__Secure-3PAPISID")),c)){b=b?"SAPISIDHASH":"APISIDHASH";var d=String(w.location.href);return d&&c&&b?[b,Pb(Nb(d),c,a||null)].join(" "):null}return null}
;function Sb(){this.g=[];this.f=-1}
Sb.prototype.set=function(a,b){b=void 0===b?!0:b;0<=a&&52>a&&0===a%1&&this.g[a]!=b&&(this.g[a]=b,this.f=-1)};
Sb.prototype.get=function(a){return!!this.g[a]};
function Tb(a){-1==a.f&&(a.f=Ea(a.g,function(b,c,d){return c?b+Math.pow(2,d):b},0));
return a.f}
;function Ub(a,b){this.h=a;this.i=b;this.g=0;this.f=null}
Ub.prototype.get=function(){if(0<this.g){this.g--;var a=this.f;this.f=a.next;a.next=null}else a=this.h();return a};function Vb(a){w.setTimeout(function(){throw a;},0)}
var Wb;function Xb(){var a=w.MessageChannel;"undefined"===typeof a&&"undefined"!==typeof window&&window.postMessage&&window.addEventListener&&!G("Presto")&&(a=function(){var e=zb();e.style.display="none";document.documentElement.appendChild(e);var f=e.contentWindow;e=f.document;e.open();e.close();var l="callImmediate"+Math.random(),h="file:"==f.location.protocol?"*":f.location.protocol+"//"+f.location.host;e=z(function(g){if(("*"==h||g.origin==h)&&g.data==l)this.port1.onmessage()},this);
f.addEventListener("message",e,!1);this.port1={};this.port2={postMessage:function(){f.postMessage(l,h)}}});
if("undefined"!==typeof a&&!G("Trident")&&!G("MSIE")){var b=new a,c={},d=c;b.port1.onmessage=function(){if(void 0!==c.next){c=c.next;var e=c.L;c.L=null;e()}};
return function(e){d.next={L:e};d=d.next;b.port2.postMessage(0)}}return function(e){w.setTimeout(e,0)}}
;function Yb(){this.g=this.f=null}
var $b=new Ub(function(){return new Zb},function(a){a.reset()});
Yb.prototype.add=function(a,b){var c=$b.get();c.set(a,b);this.g?this.g.next=c:this.f=c;this.g=c};
Yb.prototype.remove=function(){var a=null;this.f&&(a=this.f,this.f=this.f.next,this.f||(this.g=null),a.next=null);return a};
function Zb(){this.next=this.scope=this.f=null}
Zb.prototype.set=function(a,b){this.f=a;this.scope=b;this.next=null};
Zb.prototype.reset=function(){this.next=this.scope=this.f=null};function ac(a){bc||cc();dc||(bc(),dc=!0);ec.add(a,void 0)}
var bc;function cc(){if(w.Promise&&w.Promise.resolve){var a=w.Promise.resolve(void 0);bc=function(){a.then(fc)}}else bc=function(){var b=fc;
!ua(w.setImmediate)||w.Window&&w.Window.prototype&&!G("Edge")&&w.Window.prototype.setImmediate==w.setImmediate?(Wb||(Wb=Xb()),Wb(b)):w.setImmediate(b)}}
var dc=!1,ec=new Yb;function fc(){for(var a;a=ec.remove();){try{a.f.call(a.scope)}catch(c){Vb(c)}var b=$b;b.i(a);100>b.g&&(b.g++,a.next=b.f,b.f=a)}dc=!1}
;function gc(){this.g=-1}
;function hc(){this.g=64;this.f=[];this.m=[];this.v=[];this.i=[];this.i[0]=128;for(var a=1;a<this.g;++a)this.i[a]=0;this.l=this.h=0;this.reset()}
D(hc,gc);hc.prototype.reset=function(){this.f[0]=1732584193;this.f[1]=4023233417;this.f[2]=2562383102;this.f[3]=271733878;this.f[4]=3285377520;this.l=this.h=0};
function ic(a,b,c){c||(c=0);var d=a.v;if("string"===typeof b)for(var e=0;16>e;e++)d[e]=b.charCodeAt(c)<<24|b.charCodeAt(c+1)<<16|b.charCodeAt(c+2)<<8|b.charCodeAt(c+3),c+=4;else for(e=0;16>e;e++)d[e]=b[c]<<24|b[c+1]<<16|b[c+2]<<8|b[c+3],c+=4;for(e=16;80>e;e++){var f=d[e-3]^d[e-8]^d[e-14]^d[e-16];d[e]=(f<<1|f>>>31)&4294967295}b=a.f[0];c=a.f[1];var l=a.f[2],h=a.f[3],g=a.f[4];for(e=0;80>e;e++){if(40>e)if(20>e){f=h^c&(l^h);var k=1518500249}else f=c^l^h,k=1859775393;else 60>e?(f=c&l|h&(c|l),k=2400959708):
(f=c^l^h,k=3395469782);f=(b<<5|b>>>27)+f+g+k+d[e]&4294967295;g=h;h=l;l=(c<<30|c>>>2)&4294967295;c=b;b=f}a.f[0]=a.f[0]+b&4294967295;a.f[1]=a.f[1]+c&4294967295;a.f[2]=a.f[2]+l&4294967295;a.f[3]=a.f[3]+h&4294967295;a.f[4]=a.f[4]+g&4294967295}
hc.prototype.update=function(a,b){if(null!=a){void 0===b&&(b=a.length);for(var c=b-this.g,d=0,e=this.m,f=this.h;d<b;){if(0==f)for(;d<=c;)ic(this,a,d),d+=this.g;if("string"===typeof a)for(;d<b;){if(e[f]=a.charCodeAt(d),++f,++d,f==this.g){ic(this,e);f=0;break}}else for(;d<b;)if(e[f]=a[d],++f,++d,f==this.g){ic(this,e);f=0;break}}this.h=f;this.l+=b}};
hc.prototype.digest=function(){var a=[],b=8*this.l;56>this.h?this.update(this.i,56-this.h):this.update(this.i,this.g-(this.h-56));for(var c=this.g-1;56<=c;c--)this.m[c]=b&255,b/=256;ic(this,this.m);for(c=b=0;5>c;c++)for(var d=24;0<=d;d-=8)a[b]=this.f[c]>>d&255,++b;return a};var jc="StopIteration"in w?w.StopIteration:{message:"StopIteration",stack:""};function K(){}
K.prototype.next=function(){throw jc;};
K.prototype.u=function(){return this};
function kc(a){if(a instanceof K)return a;if("function"==typeof a.u)return a.u(!1);if(ta(a)){var b=0,c=new K;c.next=function(){for(;;){if(b>=a.length)throw jc;if(b in a)return a[b++];b++}};
return c}throw Error("Not implemented");}
function lc(a,b){if(ta(a))try{E(a,b,void 0)}catch(c){if(c!==jc)throw c;}else{a=kc(a);try{for(;;)b.call(void 0,a.next(),void 0,a)}catch(c){if(c!==jc)throw c;}}}
function mc(a){if(ta(a))return Ha(a);a=kc(a);var b=[];lc(a,function(c){b.push(c)});
return b}
;function nc(a,b){this.h={};this.f=[];this.i=this.g=0;var c=arguments.length;if(1<c){if(c%2)throw Error("Uneven number of arguments");for(var d=0;d<c;d+=2)this.set(arguments[d],arguments[d+1])}else if(a)if(a instanceof nc)for(c=oc(a),d=0;d<c.length;d++)this.set(c[d],a.get(c[d]));else for(d in a)this.set(d,a[d])}
function oc(a){pc(a);return a.f.concat()}
r=nc.prototype;r.equals=function(a,b){if(this===a)return!0;if(this.g!=a.g)return!1;var c=b||qc;pc(this);for(var d,e=0;d=this.f[e];e++)if(!c(this.get(d),a.get(d)))return!1;return!0};
function qc(a,b){return a===b}
r.isEmpty=function(){return 0==this.g};
r.clear=function(){this.h={};this.i=this.g=this.f.length=0};
r.remove=function(a){return Object.prototype.hasOwnProperty.call(this.h,a)?(delete this.h[a],this.g--,this.i++,this.f.length>2*this.g&&pc(this),!0):!1};
function pc(a){if(a.g!=a.f.length){for(var b=0,c=0;b<a.f.length;){var d=a.f[b];Object.prototype.hasOwnProperty.call(a.h,d)&&(a.f[c++]=d);b++}a.f.length=c}if(a.g!=a.f.length){var e={};for(c=b=0;b<a.f.length;)d=a.f[b],Object.prototype.hasOwnProperty.call(e,d)||(a.f[c++]=d,e[d]=1),b++;a.f.length=c}}
r.get=function(a,b){return Object.prototype.hasOwnProperty.call(this.h,a)?this.h[a]:b};
r.set=function(a,b){Object.prototype.hasOwnProperty.call(this.h,a)||(this.g++,this.f.push(a),this.i++);this.h[a]=b};
r.forEach=function(a,b){for(var c=oc(this),d=0;d<c.length;d++){var e=c[d],f=this.get(e);a.call(b,f,e,this)}};
r.clone=function(){return new nc(this)};
r.u=function(a){pc(this);var b=0,c=this.i,d=this,e=new K;e.next=function(){if(c!=d.i)throw Error("The map has changed since the iterator was created");if(b>=d.f.length)throw jc;var f=d.f[b++];return a?f:d.h[f]};
return e};var rc=w.JSON.stringify;function L(a){Lb.call(this);this.v=1;this.l=[];this.m=0;this.f=[];this.g={};this.B=!!a}
D(L,Lb);r=L.prototype;r.subscribe=function(a,b,c){var d=this.g[a];d||(d=this.g[a]=[]);var e=this.v;this.f[e]=a;this.f[e+1]=b;this.f[e+2]=c;this.v=e+3;d.push(e);return e};
function sc(a,b,c){var d=tc;if(a=d.g[a]){var e=d.f;(a=Fa(a,function(f){return e[f+1]==b&&e[f+2]==c}))&&d.D(a)}}
r.D=function(a){var b=this.f[a];if(b){var c=this.g[b];if(0!=this.m)this.l.push(a),this.f[a+1]=ra;else{if(c){var d=Da(c,a);0<=d&&Array.prototype.splice.call(c,d,1)}delete this.f[a];delete this.f[a+1];delete this.f[a+2]}}return!!b};
r.J=function(a,b){var c=this.g[a];if(c){for(var d=Array(arguments.length-1),e=1,f=arguments.length;e<f;e++)d[e-1]=arguments[e];if(this.B)for(e=0;e<c.length;e++){var l=c[e];uc(this.f[l+1],this.f[l+2],d)}else{this.m++;try{for(e=0,f=c.length;e<f;e++)l=c[e],this.f[l+1].apply(this.f[l+2],d)}finally{if(this.m--,0<this.l.length&&0==this.m)for(;c=this.l.pop();)this.D(c)}}return 0!=e}return!1};
function uc(a,b,c){ac(function(){a.apply(b,c)})}
r.clear=function(a){if(a){var b=this.g[a];b&&(E(b,this.D,this),delete this.g[a])}else this.f.length=0,this.g={}};
r.H=function(){L.A.H.call(this);this.clear();this.l.length=0};function vc(a){this.f=a}
vc.prototype.set=function(a,b){void 0===b?this.f.remove(a):this.f.set(a,rc(b))};
vc.prototype.get=function(a){try{var b=this.f.get(a)}catch(c){return}if(null!==b)try{return JSON.parse(b)}catch(c){throw"Storage: Invalid value was encountered";}};
vc.prototype.remove=function(a){this.f.remove(a)};function wc(a){this.f=a}
D(wc,vc);function xc(a){this.data=a}
function yc(a){return void 0===a||a instanceof xc?a:new xc(a)}
wc.prototype.set=function(a,b){wc.A.set.call(this,a,yc(b))};
wc.prototype.g=function(a){a=wc.A.get.call(this,a);if(void 0===a||a instanceof Object)return a;throw"Storage: Invalid value was encountered";};
wc.prototype.get=function(a){if(a=this.g(a)){if(a=a.data,void 0===a)throw"Storage: Invalid value was encountered";}else a=void 0;return a};function M(a){this.f=a}
D(M,wc);M.prototype.set=function(a,b,c){if(b=yc(b)){if(c){if(c<A()){M.prototype.remove.call(this,a);return}b.expiration=c}b.creation=A()}M.A.set.call(this,a,b)};
M.prototype.g=function(a){var b=M.A.g.call(this,a);if(b){var c=b.creation,d=b.expiration;if(d&&d<A()||c&&c>A())M.prototype.remove.call(this,a);else return b}};function zc(){}
;function Ac(){}
D(Ac,zc);Ac.prototype.clear=function(){var a=mc(this.u(!0)),b=this;E(a,function(c){b.remove(c)})};function Bc(a){this.f=a}
D(Bc,Ac);r=Bc.prototype;r.isAvailable=function(){if(!this.f)return!1;try{return this.f.setItem("__sak","1"),this.f.removeItem("__sak"),!0}catch(a){return!1}};
r.set=function(a,b){try{this.f.setItem(a,b)}catch(c){if(0==this.f.length)throw"Storage mechanism: Storage disabled";throw"Storage mechanism: Quota exceeded";}};
r.get=function(a){a=this.f.getItem(a);if("string"!==typeof a&&null!==a)throw"Storage mechanism: Invalid value was encountered";return a};
r.remove=function(a){this.f.removeItem(a)};
r.u=function(a){var b=0,c=this.f,d=new K;d.next=function(){if(b>=c.length)throw jc;var e=c.key(b++);if(a)return e;e=c.getItem(e);if("string"!==typeof e)throw"Storage mechanism: Invalid value was encountered";return e};
return d};
r.clear=function(){this.f.clear()};
r.key=function(a){return this.f.key(a)};function Cc(){var a=null;try{a=window.localStorage||null}catch(b){}this.f=a}
D(Cc,Bc);function Dc(a,b){this.g=a;this.f=null;var c;if(c=db)c=!(9<=Number(pb));if(c){Ec||(Ec=new nc);this.f=Ec.get(a);this.f||(b?this.f=document.getElementById(b):(this.f=document.createElement("userdata"),this.f.addBehavior("#default#userData"),document.body.appendChild(this.f)),Ec.set(a,this.f));try{this.f.load(this.g)}catch(d){this.f=null}}}
D(Dc,Ac);var Fc={".":".2E","!":".21","~":".7E","*":".2A","'":".27","(":".28",")":".29","%":"."},Ec=null;function Gc(a){return"_"+encodeURIComponent(a).replace(/[.!~*'()%]/g,function(b){return Fc[b]})}
r=Dc.prototype;r.isAvailable=function(){return!!this.f};
r.set=function(a,b){this.f.setAttribute(Gc(a),b);Hc(this)};
r.get=function(a){a=this.f.getAttribute(Gc(a));if("string"!==typeof a&&null!==a)throw"Storage mechanism: Invalid value was encountered";return a};
r.remove=function(a){this.f.removeAttribute(Gc(a));Hc(this)};
r.u=function(a){var b=0,c=this.f.XMLDocument.documentElement.attributes,d=new K;d.next=function(){if(b>=c.length)throw jc;var e=c[b++];if(a)return decodeURIComponent(e.nodeName.replace(/\./g,"%")).substr(1);e=e.nodeValue;if("string"!==typeof e)throw"Storage mechanism: Invalid value was encountered";return e};
return d};
r.clear=function(){for(var a=this.f.XMLDocument.documentElement,b=a.attributes.length;0<b;b--)a.removeAttribute(a.attributes[b-1].nodeName);Hc(this)};
function Hc(a){try{a.f.save(a.g)}catch(b){throw"Storage mechanism: Quota exceeded";}}
;function Ic(a,b){this.g=a;this.f=b+"::"}
D(Ic,Ac);Ic.prototype.set=function(a,b){this.g.set(this.f+a,b)};
Ic.prototype.get=function(a){return this.g.get(this.f+a)};
Ic.prototype.remove=function(a){this.g.remove(this.f+a)};
Ic.prototype.u=function(a){var b=this.g.u(!0),c=this,d=new K;d.next=function(){for(var e=b.next();e.substr(0,c.f.length)!=c.f;)e=b.next();return a?e.substr(c.f.length):c.g.get(e)};
return d};var Jc=window.yt&&window.yt.config_||window.ytcfg&&window.ytcfg.data_||{};C("yt.config_",Jc);function Kc(a){var b=arguments;1<b.length?Jc[b[0]]=b[1]:1===b.length&&Object.assign(Jc,b[0])}
function N(a,b){return a in Jc?Jc[a]:b}
;var Lc=[];function Mc(a){Lc.forEach(function(b){return b(a)})}
function Nc(a){return a&&window.yterr?function(){try{return a.apply(this,arguments)}catch(b){Oc(b),Mc(b)}}:a}
function Oc(a){var b=y("yt.logging.errors.log");b?b(a,"ERROR",void 0,void 0,void 0):(b=N("ERRORS",[]),b.push([a,"ERROR",void 0,void 0,void 0]),Kc("ERRORS",b))}
function Pc(a){var b=y("yt.logging.errors.log");b?b(a,"WARNING",void 0,void 0,void 0):(b=N("ERRORS",[]),b.push([a,"WARNING",void 0,void 0,void 0]),Kc("ERRORS",b))}
;var Qc=0;C("ytDomDomGetNextId",y("ytDomDomGetNextId")||function(){return++Qc});var Rc={stopImmediatePropagation:1,stopPropagation:1,preventMouseEvent:1,preventManipulation:1,preventDefault:1,layerX:1,layerY:1,screenX:1,screenY:1,scale:1,rotation:1,webkitMovementX:1,webkitMovementY:1};
function Sc(a){this.type="";this.state=this.source=this.data=this.currentTarget=this.relatedTarget=this.target=null;this.charCode=this.keyCode=0;this.metaKey=this.shiftKey=this.ctrlKey=this.altKey=!1;this.clientY=this.clientX=0;this.changedTouches=this.touches=null;try{if(a=a||window.event){this.event=a;for(var b in a)b in Rc||(this[b]=a[b]);var c=a.target||a.srcElement;c&&3==c.nodeType&&(c=c.parentNode);this.target=c;var d=a.relatedTarget;if(d)try{d=d.nodeName?d:null}catch(e){d=null}else"mouseover"==
this.type?d=a.fromElement:"mouseout"==this.type&&(d=a.toElement);this.relatedTarget=d;this.clientX=void 0!=a.clientX?a.clientX:a.pageX;this.clientY=void 0!=a.clientY?a.clientY:a.pageY;this.keyCode=a.keyCode?a.keyCode:a.which;this.charCode=a.charCode||("keypress"==this.type?this.keyCode:0);this.altKey=a.altKey;this.ctrlKey=a.ctrlKey;this.shiftKey=a.shiftKey;this.metaKey=a.metaKey}}catch(e){}}
Sc.prototype.preventDefault=function(){this.event&&(this.event.returnValue=!1,this.event.preventDefault&&this.event.preventDefault())};
Sc.prototype.stopPropagation=function(){this.event&&(this.event.cancelBubble=!0,this.event.stopPropagation&&this.event.stopPropagation())};
Sc.prototype.stopImmediatePropagation=function(){this.event&&(this.event.cancelBubble=!0,this.event.stopImmediatePropagation&&this.event.stopImmediatePropagation())};var F=y("ytEventsEventsListeners")||{};C("ytEventsEventsListeners",F);var Tc=y("ytEventsEventsCounter")||{count:0};C("ytEventsEventsCounter",Tc);
function Uc(a,b,c,d){d=void 0===d?{}:d;a.addEventListener&&("mouseenter"!=b||"onmouseenter"in document?"mouseleave"!=b||"onmouseenter"in document?"mousewheel"==b&&"MozBoxSizing"in document.documentElement.style&&(b="MozMousePixelScroll"):b="mouseout":b="mouseover");return La(function(e){var f="boolean"===typeof e[4]&&e[4]==!!d,l=va(e[4])&&va(d)&&Na(e[4],d);return!!e.length&&e[0]==a&&e[1]==b&&e[2]==c&&(f||l)})}
function Vc(a){a&&("string"==typeof a&&(a=[a]),E(a,function(b){if(b in F){var c=F[b],d=c[0],e=c[1],f=c[3];c=c[4];d.removeEventListener?Wc()||"boolean"===typeof c?d.removeEventListener(e,f,c):d.removeEventListener(e,f,!!c.capture):d.detachEvent&&d.detachEvent("on"+e,f);delete F[b]}}))}
var Wc=Ja(function(){var a=!1;try{var b=Object.defineProperty({},"capture",{get:function(){a=!0}});
window.addEventListener("test",null,b)}catch(c){}return a});
function Xc(a,b,c){var d=void 0===d?{}:d;if(a&&(a.addEventListener||a.attachEvent)){var e=Uc(a,b,c,d);if(!e){e=++Tc.count+"";var f=!("mouseenter"!=b&&"mouseleave"!=b||!a.addEventListener||"onmouseenter"in document);var l=f?function(h){h=new Sc(h);if(!Ab(h.relatedTarget,function(g){return g==a}))return h.currentTarget=a,h.type=b,c.call(a,h)}:function(h){h=new Sc(h);
h.currentTarget=a;return c.call(a,h)};
l=Nc(l);a.addEventListener?("mouseenter"==b&&f?b="mouseover":"mouseleave"==b&&f?b="mouseout":"mousewheel"==b&&"MozBoxSizing"in document.documentElement.style&&(b="MozMousePixelScroll"),Wc()||"boolean"===typeof d?a.addEventListener(b,l,d):a.addEventListener(b,l,!!d.capture)):a.attachEvent("on"+b,l);F[e]=[a,b,c,l,d]}}}
;function Yc(a,b){ua(a)&&(a=Nc(a));return window.setTimeout(a,b)}
function Zc(a){ua(a)&&(a=Nc(a));return window.setInterval(a,250)}
function O(a){window.clearTimeout(a)}
;function $c(a){var b=[];Ka(a,function(c,d){var e=encodeURIComponent(String(d)),f;Array.isArray(c)?f=c:f=[c];E(f,function(l){""==l?b.push(e):b.push(e+"="+encodeURIComponent(String(l)))})});
return b.join("&")}
function ad(a){"?"==a.charAt(0)&&(a=a.substr(1));a=a.split("&");for(var b={},c=0,d=a.length;c<d;c++){var e=a[c].split("=");if(1==e.length&&e[0]||2==e.length)try{var f=decodeURIComponent((e[0]||"").replace(/\+/g," ")),l=decodeURIComponent((e[1]||"").replace(/\+/g," "));f in b?Array.isArray(b[f])?Ia(b[f],l):b[f]=[b[f],l]:b[f]=l}catch(g){if("q"!=e[0]){var h=Error("Error decoding URL component");h.params={key:e[0],value:e[1]};Oc(h)}}}return b}
function bd(a,b){return cd(a,b||{},!0)}
function cd(a,b,c){var d=a.split("#",2);a=d[0];d=1<d.length?"#"+d[1]:"";var e=a.split("?",2);a=e[0];e=ad(e[1]||"");for(var f in b)!c&&null!==e&&f in e||(e[f]=b[f]);b=a;a=Eb(e);a?(c=b.indexOf("#"),0>c&&(c=b.length),f=b.indexOf("?"),0>f||f>c?(f=c,e=""):e=b.substring(f+1,c),b=[b.substr(0,f),e,b.substr(c)],c=b[1],b[1]=a?c?c+"&"+a:a:c,a=b[0]+(b[1]?"?"+b[1]:"")+b[2]):a=b;return a+d}
;var dd={};function ed(a){return dd[a]||(dd[a]=String(a).replace(/\-([a-z])/g,function(b,c){return c.toUpperCase()}))}
;var fd={},gd=[],tc=new L,hd={};function id(){for(var a=t(gd),b=a.next();!b.done;b=a.next())b=b.value,b()}
function jd(a,b){b||(b=document);var c=Ha(b.getElementsByTagName("yt:"+a)),d="yt-"+a,e=b||document;d=Ha(e.querySelectorAll&&e.querySelector?e.querySelectorAll("."+d):yb(d,b));return Ga(c,d)}
function P(a,b){var c;"yt:"==a.tagName.toLowerCase().substr(0,3)?c=a.getAttribute(b):c=a?a.dataset?a.dataset[ed(b)]:a.getAttribute("data-"+b):null;return c}
function kd(a,b){tc.J.apply(tc,arguments)}
;function ld(a){this.g=a||{};this.h=this.f=!1;a=document.getElementById("www-widgetapi-script");if(this.f=!!("https:"==document.location.protocol||a&&0==a.src.indexOf("https:"))){a=[this.g,window.YTConfig||{}];for(var b=0;b<a.length;b++)a[b].host&&(a[b].host=a[b].host.replace("http://","https://"))}}
function Q(a,b){for(var c=[a.g,window.YTConfig||{}],d=0;d<c.length;d++){var e=c[d][b];if(void 0!=e)return e}return null}
function md(a,b,c){nd||(nd={},Xc(window,"message",z(a.i,a)));nd[c]=b}
ld.prototype.i=function(a){if(a.origin==Q(this,"host")||a.origin==Q(this,"host").replace(/^http:/,"https:")){try{var b=JSON.parse(a.data)}catch(c){return}this.h=!0;this.f||0!=a.origin.indexOf("https:")||(this.f=!0);if(a=nd[b.id])a.B=!0,a.B&&(E(a.v,a.K,a),a.v.length=0),a.S(b)}};
var nd=null;function R(a){a=od(a);return"string"===typeof a&&"false"===a?!1:!!a}
function pd(a,b){var c=od(a);return void 0===c&&void 0!==b?b:Number(c||0)}
function od(a){var b=N("EXPERIMENTS_FORCED_FLAGS",{});return void 0!==b[a]?b[a]:N("EXPERIMENT_FLAGS",{})[a]}
;var qd=y("ytPubsubPubsubInstance")||new L;L.prototype.subscribe=L.prototype.subscribe;L.prototype.unsubscribeByKey=L.prototype.D;L.prototype.publish=L.prototype.J;L.prototype.clear=L.prototype.clear;C("ytPubsubPubsubInstance",qd);C("ytPubsubPubsubSubscribedKeys",y("ytPubsubPubsubSubscribedKeys")||{});C("ytPubsubPubsubTopicToKeys",y("ytPubsubPubsubTopicToKeys")||{});C("ytPubsubPubsubIsSynchronous",y("ytPubsubPubsubIsSynchronous")||{});var S=window,T=S.ytcsi&&S.ytcsi.now?S.ytcsi.now:S.performance&&S.performance.timing&&S.performance.now&&S.performance.timing.navigationStart?function(){return S.performance.timing.navigationStart+S.performance.now()}:function(){return(new Date).getTime()};var rd=pd("initial_gel_batch_timeout",1E3),sd=Math.pow(2,16)-1,td=null,ud=0,vd=void 0,wd=0,xd=0,yd=0,zd=!0,Ad=y("ytLoggingTransportLogPayloadsQueue_")||{};C("ytLoggingTransportLogPayloadsQueue_",Ad);var Bd=y("ytLoggingTransportGELQueue_")||new Map;C("ytLoggingTransportGELQueue_",Bd);var Cd=y("ytLoggingTransportTokensToCttTargetIds_")||{};C("ytLoggingTransportTokensToCttTargetIds_",Cd);
function Dd(){O(wd);O(xd);xd=0;vd&&vd.isReady()?(Ed(Bd),"log_event"in Ad&&Ed(Object.entries(Ad.log_event)),Bd.clear(),delete Ad.log_event):Fd()}
function Fd(){R("web_gel_timeout_cap")&&!xd&&(xd=Yc(Dd,6E4));O(wd);var a=N("LOGGING_BATCH_TIMEOUT",pd("web_gel_debounce_ms",1E4));R("shorten_initial_gel_batch_timeout")&&zd&&(a=rd);wd=Yc(Dd,a)}
function Ed(a){var b=vd,c=Math.round(T());a=t(a);for(var d=a.next();!d.done;d=a.next()){var e=t(d.value);d=e.next().value;var f=e.next().value;e=Oa({context:Gd(b.f||Hd())});e.events=f;(f=Cd[d])&&Id(e,d,f);delete Cd[d];Jd(e,c);Kd(b,"log_event",e,{retry:!0,onSuccess:function(){ud=Math.round(T()-c)}});
zd=!1}}
function Jd(a,b){a.requestTimeMs=String(b);R("unsplit_gel_payloads_in_logs")&&(a.unsplitGelPayloadsInLogs=!0);var c=N("EVENT_ID",void 0);if(c){var d=N("BATCH_CLIENT_COUNTER",void 0)||0;!d&&R("web_client_counter_random_seed")&&(d=Math.floor(Math.random()*sd/2));d++;d>sd&&(d=1);Kc("BATCH_CLIENT_COUNTER",d);c={serializedEventId:c,clientCounter:String(d)};a.serializedClientEventId=c;td&&ud&&R("log_gel_rtt_web")&&(a.previousBatchInfo={serializedClientEventId:td,roundtripMs:String(ud)});td=c;ud=0}}
function Id(a,b,c){if(c.videoId)var d="VIDEO";else if(c.playlistId)d="PLAYLIST";else return;a.credentialTransferTokenTargetId=c;a.context=a.context||{};a.context.user=a.context.user||{};a.context.user.credentialTransferTokens=[{token:b,scope:d}]}
;var Ld=pd("initial_gel_batch_timeout",1E3),Md=Math.pow(2,16)-1,Nd=null,Od=0,Pd={log_event:"events",log_interaction:"interactions"},Qd=new Set(["log_event"]),Rd={},Sd=0,Td=0,Ud=0,Vd=!0,V=y("ytLoggingTransportLogPayloadsQueue_")||{};C("ytLoggingTransportLogPayloadsQueue_",V);var Wd=y("ytLoggingTransportTokensToCttTargetIds_")||{};C("ytLoggingTransportTokensToCttTargetIds_",Wd);
function Xd(){if(R("use_typescript_transport"))Dd();else if(O(Sd),O(Td),Td=0,!Ma(V)){for(var a in V){var b=Rd[a];if(b&&b.isReady()){var c=void 0,d=a,e=Pd[d],f=Math.round(T());for(c in V[d]){var l=Oa({context:Gd(b.f||Hd())});l[e]=Yd(d,c);var h=Wd[c];if(h)a:{var g=l,k=c;if(h.videoId)var m="VIDEO";else if(h.playlistId)m="PLAYLIST";else break a;g.credentialTransferTokenTargetId=h;g.context=g.context||{};g.context.user=g.context.user||{};g.context.user.credentialTransferTokens=[{token:k,scope:m}]}delete Wd[c];
h=l;h.requestTimeMs=f;R("unsplit_gel_payloads_in_logs")&&(h.unsplitGelPayloadsInLogs=!0);if(m=N("EVENT_ID",void 0))g=N("BATCH_CLIENT_COUNTER",void 0)||0,!g&&R("web_client_counter_random_seed")&&(g=Math.floor(Math.random()*Md/2)),g++,g>Md&&(g=1),Kc("BATCH_CLIENT_COUNTER",g),m={serializedEventId:m,clientCounter:g},h.serializedClientEventId=m,Nd&&Od&&R("log_gel_rtt_web")&&(h.previousBatchInfo={serializedClientEventId:Nd,roundtripMs:Od}),Nd=m,Od=0;Kd(b,d,l,{retry:Qd.has(d),onSuccess:Ba(Zd,T())})}delete V[a];
Vd=!1}}Ma(V)||$d()}}
function $d(){R("web_gel_timeout_cap")&&!Td&&(Td=Yc(Xd,6E4));O(Sd);var a=N("LOGGING_BATCH_TIMEOUT",pd("web_gel_debounce_ms",1E4));R("shorten_initial_gel_batch_timeout")&&Vd&&(a=Ld);Sd=Yc(Xd,a)}
function Yd(a,b){b=void 0===b?"":b;V[a]=V[a]||{};V[a][b]=V[a][b]||[];return V[a][b]}
function Zd(a){Od=Math.round(T()-a)}
;function ae(){}
function be(a){var b=5E3;isNaN(b)&&(b=void 0);var c=y("yt.scheduler.instance.addJob");c?c(a,0,b):void 0===b?a():Yc(a,b||0)}
;function W(){}
ja(W,ae);W.prototype.start=function(){var a=y("yt.scheduler.instance.start");a&&a()};
W.f=void 0;W.g=function(){W.f||(W.f=new W)};
W.g();var ce=y("ytLoggingGelSequenceIdObj_")||{};C("ytLoggingGelSequenceIdObj_",ce);function de(a){var b=ee;a=void 0===a?y("yt.ads.biscotti.lastId_")||"":a;b=Object.assign(fe(b),ge(b));b.ca_type="image";a&&(b.bid=a);return b}
function fe(a){var b={};b.dt=Mb;b.flash="0";a:{try{var c=a.f.top.location.href}catch(f){a=2;break a}a=c?c===a.g.location.href?0:1:2}b=(b.frm=a,b);b.u_tz=-(new Date).getTimezoneOffset();var d=void 0===d?H:d;try{var e=d.history.length}catch(f){e=0}b.u_his=e;b.u_java=!!H.navigator&&"unknown"!==typeof H.navigator.javaEnabled&&!!H.navigator.javaEnabled&&H.navigator.javaEnabled();H.screen&&(b.u_h=H.screen.height,b.u_w=H.screen.width,b.u_ah=H.screen.availHeight,b.u_aw=H.screen.availWidth,b.u_cd=H.screen.colorDepth);
H.navigator&&H.navigator.plugins&&(b.u_nplug=H.navigator.plugins.length);H.navigator&&H.navigator.mimeTypes&&(b.u_nmime=H.navigator.mimeTypes.length);return b}
function ge(a){var b=a.f;try{var c=b.screenX;var d=b.screenY}catch(n){}try{var e=b.outerWidth;var f=b.outerHeight}catch(n){}try{var l=b.innerWidth;var h=b.innerHeight}catch(n){}b=[b.screenLeft,b.screenTop,c,d,b.screen?b.screen.availWidth:void 0,b.screen?b.screen.availTop:void 0,e,f,l,h];c=a.f.top;try{var g=(c||window).document,k="CSS1Compat"==g.compatMode?g.documentElement:g.body;var m=(new xb(k.clientWidth,k.clientHeight)).round()}catch(n){m=new xb(-12245933,-12245933)}g=m;m={};k=new Sb;w.SVGElement&&
w.document.createElementNS&&k.set(0);c=Kb();c["allow-top-navigation-by-user-activation"]&&k.set(1);c["allow-popups-to-escape-sandbox"]&&k.set(2);w.crypto&&w.crypto.subtle&&k.set(3);w.TextDecoder&&w.TextEncoder&&k.set(4);k=Tb(k);m.bc=k;m.bih=g.height;m.biw=g.width;m.brdim=b.join();a=a.g;return m.vis={visible:1,hidden:2,prerender:3,preview:4,unloaded:5}[a.visibilityState||a.webkitVisibilityState||a.mozVisibilityState||""]||0,m.wgl=!!H.WebGLRenderingContext,m}
var ee=new function(){var a=window.document;this.f=window;this.g=a};
C("yt.ads_.signals_.getAdSignalsString",function(a){return $c(de(a))});A();var he=void 0!==XMLHttpRequest?function(){return new XMLHttpRequest}:void 0!==ActiveXObject?function(){return new ActiveXObject("Microsoft.XMLHTTP")}:null;
function ie(){if(!he)return null;var a=he();return"open"in a?a:null}
;var je={Authorization:"AUTHORIZATION","X-Goog-Visitor-Id":"SANDBOXED_VISITOR_ID","X-YouTube-Client-Name":"INNERTUBE_CONTEXT_CLIENT_NAME","X-YouTube-Client-Version":"INNERTUBE_CONTEXT_CLIENT_VERSION","X-YouTube-Device":"DEVICE","X-Youtube-Identity-Token":"ID_TOKEN","X-YouTube-Page-CL":"PAGE_CL","X-YouTube-Page-Label":"PAGE_BUILD_LABEL","X-YouTube-Variants-Checksum":"VARIANTS_CHECKSUM"},ke="app debugcss debugjs expflag force_ad_params force_viral_ad_response_params forced_experiments innertube_snapshots innertube_goldens internalcountrycode internalipoverride absolute_experiments conditional_experiments sbb sr_bns_address".split(" "),
le=!1;
function me(a,b){b=void 0===b?{}:b;if(!c)var c=window.location.href;var d=I(a)[1]||null,e=J(I(a)[3]||null);d&&e?(d=c,c=I(a),d=I(d),c=c[3]==d[3]&&c[1]==d[1]&&c[4]==d[4]):c=e?J(I(c)[3]||null)==e&&(Number(I(c)[4]||null)||null)==(Number(I(a)[4]||null)||null):!0;d=R("web_ajax_ignore_global_headers_if_set");for(var f in je)e=N(je[f]),!e||!c&&!ne(a,f)||d&&void 0!==b[f]||(b[f]=e);if(c||ne(a,"X-YouTube-Utc-Offset"))b["X-YouTube-Utc-Offset"]=String(-(new Date).getTimezoneOffset());(c||ne(a,"X-YouTube-Time-Zone"))&&(f=
"undefined"!=typeof Intl?(new Intl.DateTimeFormat).resolvedOptions().timeZone:null)&&(b["X-YouTube-Time-Zone"]=f);if(c||ne(a,"X-YouTube-Ad-Signals"))b["X-YouTube-Ad-Signals"]=$c(de(void 0));return b}
function oe(a){var b=window.location.search,c=J(I(a)[3]||null),d=J(I(a)[5]||null);d=(c=c&&(c.endsWith("youtube.com")||c.endsWith("youtube-nocookie.com")))&&d&&d.startsWith("/api/");if(!c||d)return a;var e=ad(b),f={};E(ke,function(l){e[l]&&(f[l]=e[l])});
return cd(a,f||{},!1)}
function ne(a,b){var c=N("CORS_HEADER_WHITELIST")||{},d=J(I(a)[3]||null);return d?(c=c[d])?0<=Da(c,b):!1:!0}
function pe(a,b){if(window.fetch&&"XML"!=b.format){var c={method:b.method||"GET",credentials:"same-origin"};b.headers&&(c.headers=b.headers);a=qe(a,b);var d=re(a,b);d&&(c.body=d);b.withCredentials&&(c.credentials="include");var e=!1,f;fetch(a,c).then(function(l){if(!e){e=!0;f&&O(f);var h=l.ok,g=function(k){k=k||{};var m=b.context||w;h?b.onSuccess&&b.onSuccess.call(m,k,l):b.onError&&b.onError.call(m,k,l);b.I&&b.I.call(m,k,l)};
"JSON"==(b.format||"JSON")&&(h||400<=l.status&&500>l.status)?l.json().then(g,function(){g(null)}):g(null)}});
b.ea&&0<b.timeout&&(f=Yc(function(){e||(e=!0,O(f))},b.timeout))}else se(a,b)}
function se(a,b){var c=b.format||"JSON";a=qe(a,b);var d=re(a,b),e=!1,f,l=te(a,function(h){if(!e){e=!0;f&&O(f);a:switch(h&&"status"in h?h.status:-1){case 200:case 201:case 202:case 203:case 204:case 205:case 206:case 304:var g=!0;break a;default:g=!1}var k=null,m=400<=h.status&&500>h.status,n=500<=h.status&&600>h.status;if(g||m||n)k=ue(c,h,b.ta);if(g)a:if(h&&204==h.status)g=!0;else{switch(c){case "XML":g=0==parseInt(k&&k.return_code,10);break a;case "RAW":g=!0;break a}g=!!k}k=k||{};m=b.context||w;
g?b.onSuccess&&b.onSuccess.call(m,h,k):b.onError&&b.onError.call(m,h,k);b.I&&b.I.call(m,h,k)}},b.method,d,b.headers,b.responseType,b.withCredentials);
b.O&&0<b.timeout&&(f=Yc(function(){e||(e=!0,l.abort(),O(f))},b.timeout))}
function qe(a,b){b.wa&&(a=document.location.protocol+"//"+document.location.hostname+(document.location.port?":"+document.location.port:"")+a);var c=N("XSRF_FIELD_NAME",void 0),d=b.fa;d&&(d[c]&&delete d[c],a=bd(a,d));return a}
function re(a,b){var c=N("XSRF_FIELD_NAME",void 0),d=N("XSRF_TOKEN",void 0),e=b.postBody||"",f=b.o,l=N("XSRF_FIELD_NAME",void 0),h;b.headers&&(h=b.headers["Content-Type"]);b.va||J(I(a)[3]||null)&&!b.withCredentials&&J(I(a)[3]||null)!=document.location.hostname||"POST"!=b.method||h&&"application/x-www-form-urlencoded"!=h||b.o&&b.o[l]||(f||(f={}),f[c]=d);f&&"string"===typeof e&&(e=ad(e),Qa(e,f),e=b.R&&"JSON"==b.R?JSON.stringify(e):Eb(e));f=e||f&&!Ma(f);!le&&f&&"POST"!=b.method&&(le=!0,Oc(Error("AJAX request with postData should use POST")));
return e}
function ue(a,b,c){var d=null;switch(a){case "JSON":a=b.responseText;b=b.getResponseHeader("Content-Type")||"";a&&0<=b.indexOf("json")&&(d=JSON.parse(a));break;case "XML":if(b=(b=b.responseXML)?ve(b):null)d={},E(b.getElementsByTagName("*"),function(e){d[e.tagName]=we(e)})}c&&xe(d);
return d}
function xe(a){if(va(a))for(var b in a){var c;(c="html_content"==b)||(c=b.length-5,c=0<=c&&b.indexOf("_html",c)==c);c?a[b]=new bb:xe(a[b])}}
function ve(a){return a?(a=("responseXML"in a?a.responseXML:a).getElementsByTagName("root"))&&0<a.length?a[0]:null:null}
function we(a){var b="";E(a.childNodes,function(c){b+=c.nodeValue});
return b}
function te(a,b,c,d,e,f,l){function h(){4==(g&&"readyState"in g?g.readyState:0)&&b&&Nc(b)(g)}
c=void 0===c?"GET":c;d=void 0===d?"":d;var g=ie();if(!g)return null;"onloadend"in g?g.addEventListener("loadend",h,!1):g.onreadystatechange=h;R("debug_forward_web_query_parameters")&&(a=oe(a));g.open(c,a,!0);f&&(g.responseType=f);l&&(g.withCredentials=!0);c="POST"==c&&(void 0===window.FormData||!(d instanceof FormData));if(e=me(a,e))for(var k in e)g.setRequestHeader(k,e[k]),"content-type"==k.toLowerCase()&&(c=!1);c&&g.setRequestHeader("Content-Type","application/x-www-form-urlencoded");g.send(d);
return g}
;function ye(){for(var a={},b=t(Object.entries(ad(N("DEVICE","")))),c=b.next();!c.done;c=b.next()){var d=t(c.value);c=d.next().value;d=d.next().value;"cbrand"===c?a.deviceMake=d:"cmodel"===c?a.deviceModel=d:"cbr"===c?a.browserName=d:"cbrver"===c?a.browserVersion=d:"cos"===c?a.osName=d:"cosver"===c?a.osVersion=d:"cplatform"===c&&(a.platform=d)}return a}
;function ze(){return"INNERTUBE_API_KEY"in Jc&&"INNERTUBE_API_VERSION"in Jc}
function Hd(){return{innertubeApiKey:N("INNERTUBE_API_KEY",void 0),innertubeApiVersion:N("INNERTUBE_API_VERSION",void 0),X:N("INNERTUBE_CONTEXT_CLIENT_CONFIG_INFO"),Y:N("INNERTUBE_CONTEXT_CLIENT_NAME","WEB"),innertubeContextClientVersion:N("INNERTUBE_CONTEXT_CLIENT_VERSION",void 0),aa:N("INNERTUBE_CONTEXT_HL",void 0),Z:N("INNERTUBE_CONTEXT_GL",void 0),ba:N("INNERTUBE_HOST_OVERRIDE",void 0)||"",ca:!!N("INNERTUBE_USE_THIRD_PARTY_AUTH",!1)}}
function Gd(a){a={client:{hl:a.aa,gl:a.Z,clientName:a.Y,clientVersion:a.innertubeContextClientVersion,configInfo:a.X}};var b=window.devicePixelRatio;b&&1!=b&&(a.client.screenDensityFloat=String(b));b=N("EXPERIMENTS_TOKEN","");""!==b&&(a.client.experimentsToken=b);b=[];var c=N("EXPERIMENTS_FORCED_FLAGS",{});for(d in c)b.push({key:d,value:String(c[d])});var d=N("EXPERIMENT_FLAGS",{});for(var e in d)e.startsWith("force_")&&void 0===c[e]&&b.push({key:e,value:String(d[e])});0<b.length&&(a.request={internalExperimentFlags:b});
N("DELEGATED_SESSION_ID")&&!R("pageid_as_header_web")&&(a.user={onBehalfOfUser:N("DELEGATED_SESSION_ID")});a.client=Object.assign(a.client,ye());return a}
function Ae(a,b,c){c=void 0===c?{}:c;var d={"X-Goog-Visitor-Id":c.visitorData||N("VISITOR_DATA","")};if(b&&b.includes("www.youtube-nocookie.com"))return d;(b=c.sa||N("AUTHORIZATION"))||(a?b="Bearer "+y("gapi.auth.getToken")().ra:b=Rb([]));b&&(d.Authorization=b,d["X-Goog-AuthUser"]=N("SESSION_INDEX",0),R("pageid_as_header_web")&&(d["X-Goog-PageId"]=N("DELEGATED_SESSION_ID")));return d}
function Be(a){a=Object.assign({},a);delete a.Authorization;var b=Rb();if(b){var c=new hc;c.update(N("INNERTUBE_API_KEY",void 0));c.update(b);b=c.digest();c=3;void 0===c&&(c=0);if(!sb){sb={};for(var d="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".split(""),e=["+/=","+/","-_=","-_.","-_"],f=0;5>f;f++){var l=d.concat(e[f].split(""));qb[f]=l;for(var h=0;h<l.length;h++){var g=l[h];void 0===sb[g]&&(sb[g]=h)}}}c=qb[c];d=[];for(e=0;e<b.length;e+=3){var k=b[e],m=(f=e+1<b.length)?b[e+1]:
0;g=(l=e+2<b.length)?b[e+2]:0;h=k>>2;k=(k&3)<<4|m>>4;m=(m&15)<<2|g>>6;g&=63;l||(g=64,f||(m=64));d.push(c[h],c[k],c[m]||"",c[g]||"")}a.hash=d.join("")}return a}
;function Ce(){var a=new Cc;(a=a.isAvailable()?new Ic(a,"yt.innertube"):null)||(a=new Dc("yt.innertube"),a=a.isAvailable()?a:null);this.f=a?new M(a):null;this.g=document.domain||window.location.hostname}
Ce.prototype.set=function(a,b,c,d){c=c||31104E3;this.remove(a);if(this.f)try{this.f.set(a,b,A()+1E3*c);return}catch(f){}var e="";if(d)try{e=escape(rc(b))}catch(f){return}else e=escape(b);b=this.g;wb.set(""+a,e,{M:c,path:"/",domain:void 0===b?"youtube.com":b,secure:!1})};
Ce.prototype.get=function(a,b){var c=void 0,d=!this.f;if(!d)try{c=this.f.get(a)}catch(e){d=!0}if(d&&(c=wb.get(""+a,void 0))&&(c=unescape(c),b))try{c=JSON.parse(c)}catch(e){this.remove(a),c=void 0}return c};
Ce.prototype.remove=function(a){this.f&&this.f.remove(a);var b=this.g;wb.remove(""+a,"/",void 0===b?"youtube.com":b)};var X=new Ce;function De(a,b,c,d){if(d)return null;d=X.get("nextId",!0)||1;var e=X.get("requests",!0)||{};e[d]={method:a,request:b,authState:Be(c),requestTime:Math.round(T())};X.set("nextId",d+1,86400,!0);X.set("requests",e,86400,!0);return d}
function Ee(a){var b=X.get("requests",!0)||{};delete b[a];X.set("requests",b,86400,!0)}
function Fe(a){var b=X.get("requests",!0);if(b){for(var c in b){var d=b[c];if(!(6E4>Math.round(T())-d.requestTime)){var e=d.authState,f=Be(Ae(!1));Na(e,f)&&(e=d.request,"requestTimeMs"in e&&(e.requestTimeMs=Math.round(T())),Kd(a,d.method,e,{}));delete b[c]}}X.set("requests",b,86400,!0)}}
;function Ge(a){var b=this;this.f=null;a?this.f=a:ze()&&(this.f=Hd());be(function(){Fe(b)})}
Ge.prototype.isReady=function(){!this.f&&ze()&&(this.f=Hd());return!!this.f};
function Kd(a,b,c,d){!N("VISITOR_DATA")&&"visitor_id"!==b&&.01>Math.random()&&Pc(Error("Missing VISITOR_DATA when sending innertube request."));var e={headers:{"Content-Type":"application/json"},method:"POST",o:c,R:"JSON",O:function(){},
ea:d.O,onSuccess:function(p,q){if(d.onSuccess)d.onSuccess(q)},
N:function(p){if(d.onSuccess)d.onSuccess(p)},
onError:function(p,q){if(d.onError)d.onError(q)},
xa:function(p){if(d.onError)d.onError(p)},
timeout:d.timeout,withCredentials:!0},f="",l=a.f.ba;l&&(f=l);l=a.f.ca||!1;var h=Ae(l,f,d);Object.assign(e.headers,h);e.headers.Authorization&&!f&&(e.headers["x-origin"]=window.location.origin);var g=bd(""+f+("/youtubei/"+a.f.innertubeApiVersion+"/"+b),{alt:"json",key:a.f.innertubeApiKey}),k;if(d.retry&&R("retry_web_logging_batches")&&"www.youtube-nocookie.com"!=f&&(k=De(b,c,h,l))){var m=e.onSuccess,n=e.N;e.onSuccess=function(p,q){Ee(k);m(p,q)};
c.N=function(p,q){Ee(k);n(p,q)}}try{R("use_fetch_for_op_xhr")?pe(g,e):(e.method="POST",e.o||(e.o={}),se(g,e))}catch(p){if("InvalidAccessError"==p)k&&(Ee(k),k=0),Pc(Error("An extension is blocking network request."));
else throw p;}k&&be(function(){Fe(a)})}
;var He=new Set,Ie=0;function Je(a,b,c,d){c+="."+a;a=String(JSON.stringify(b)).substr(0,500);d[c]=a;return c.length+a.length}
;function Y(a,b,c){this.m=this.f=this.g=null;this.l=wa(this);this.h=0;this.B=!1;this.v=[];this.i=null;this.T=c;this.V={};c=document;if(a="string"===typeof a?c.getElementById(a):a)if(c="iframe"==a.tagName.toLowerCase(),b.host||(b.host=c?Cb(a.src):"https://www.youtube.com"),this.g=new ld(b),c||(b=Ke(this,a),this.m=a,(c=a.parentNode)&&c.replaceChild(b,a),a=b),this.f=a,this.f.id||(this.f.id="widget"+wa(this.f)),fd[this.f.id]=this,window.postMessage){this.i=new L;Le(this);b=Q(this.g,"events");for(var d in b)b.hasOwnProperty(d)&&
this.addEventListener(d,b[d]);for(var e in hd)Me(this,e)}}
r=Y.prototype;r.setSize=function(a,b){this.f.width=a;this.f.height=b;return this};
r.da=function(){return this.f};
r.S=function(a){this.C(a.event,a)};
r.addEventListener=function(a,b){var c=b;"string"==typeof b&&(c=function(){window[b].apply(window,arguments)});
if(!c)return this;this.i.subscribe(a,c);Ne(this,a);return this};
function Me(a,b){var c=b.split(".");if(2==c.length){var d=c[1];a.T==c[0]&&Ne(a,d)}}
r.destroy=function(){this.f.id&&(fd[this.f.id]=null);var a=this.i;a&&"function"==typeof a.dispose&&a.dispose();if(this.m){a=this.f;var b=a.parentNode;b&&b.replaceChild(this.m,a)}else(a=this.f)&&a.parentNode&&a.parentNode.removeChild(a);nd&&(nd[this.l]=null);this.g=null;a=this.f;for(var c in F)F[c][0]==a&&Vc(c);this.m=this.f=null};
r.F=function(){return{}};
function Oe(a,b,c){c=c||[];c=Array.prototype.slice.call(c);b={event:"command",func:b,args:c};a.B?a.K(b):a.v.push(b)}
r.C=function(a,b){if(!this.i.h){var c={target:this,data:b};this.i.J(a,c);kd(this.T+"."+a,c)}};
function Ke(a,b){for(var c=document.createElement("iframe"),d=b.attributes,e=0,f=d.length;e<f;e++){var l=d[e].value;null!=l&&""!=l&&"null"!=l&&c.setAttribute(d[e].name,l)}c.setAttribute("frameBorder",0);c.setAttribute("allowfullscreen",1);c.setAttribute("allow","accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture");c.setAttribute("title","YouTube "+Q(a.g,"title"));(d=Q(a.g,"width"))&&c.setAttribute("width",d);(d=Q(a.g,"height"))&&c.setAttribute("height",d);var h=a.F();h.enablejsapi=
window.postMessage?1:0;window.location.host&&(h.origin=window.location.protocol+"//"+window.location.host);h.widgetid=a.l;window.location.href&&E(["debugjs","debugcss"],function(g){var k=window.location.href;var m=k.search(Fb);b:{var n=0;for(var p=g.length;0<=(n=k.indexOf(g,n))&&n<m;){var q=k.charCodeAt(n-1);if(38==q||63==q)if(q=k.charCodeAt(n+p),!q||61==q||38==q||35==q)break b;n+=p+1}n=-1}if(0>n)k=null;else{p=k.indexOf("&",n);if(0>p||p>m)p=m;n+=g.length+1;k=decodeURIComponent(k.substr(n,p-n).replace(/\+/g,
" "))}null!==k&&(h[g]=k)});
c.src=Q(a.g,"host")+a.G()+"?"+Eb(h);return c}
r.P=function(){this.f&&this.f.contentWindow?this.K({event:"listening"}):window.clearInterval(this.h)};
function Le(a){md(a.g,a,a.l);a.h=Zc(z(a.P,a));Xc(a.f,"load",z(function(){window.clearInterval(this.h);this.h=Zc(z(this.P,this))},a))}
function Ne(a,b){a.V[b]||(a.V[b]=!0,Oe(a,"addEventListener",[b]))}
r.K=function(a){a.id=this.l;a.channel="widget";a=rc(a);var b=this.g;var c=Cb(this.f.src||"");b=0==c.indexOf("https:")?[c]:b.f?[c.replace("http:","https:")]:b.h?[c]:[c,c.replace("http:","https:")];if(this.f.contentWindow)for(c=0;c<b.length;c++)try{this.f.contentWindow.postMessage(a,b[c])}catch(B){if(B.name&&"SyntaxError"==B.name){if(!(B.message&&0<B.message.indexOf("target origin ''"))){var d=void 0,e=void 0,f=B;e=void 0===e?{}:e;e.name=N("INNERTUBE_CONTEXT_CLIENT_NAME",1);e.version=N("INNERTUBE_CONTEXT_CLIENT_VERSION",
void 0);var l=e||{};e="WARNING";e=void 0===e?"ERROR":e;var h=window&&window.yterr||!1;if(f&&h&&!(5<=Ie)){if(R("console_log_js_exceptions")){h=f;var g=[];g.push("Name: "+h.name);g.push("Message: "+h.message);h.hasOwnProperty("params")&&g.push("Error Params: "+JSON.stringify(h.params));g.push("File name: "+h.fileName);g.push("Stacktrace: "+h.stack);window.console.log(g.join("\n"),h)}if(0!==f.f){h=f.g;g=f.columnNumber;if(f.args&&f.args.length){var k=0;for(d=0;d<f.args.length;d++){var m=f.args[d],n="params."+
d;k+=n.length;if(m)if(Array.isArray(m)){var p=m;m=n;n=l;for(var q=0;q<p.length&&!(p[q]&&(k+=Je(q,p[q],m,n),500<k));q++);}else if("object"===typeof m)for(p in p=void 0,q=l,m){if(m[p]&&(k+=Je(p,m[p],n,q),500<k))break}else l[n]=String(JSON.stringify(m)).substring(0,500),k+=l[n].length;else l[n]=String(JSON.stringify(m)).substring(0,500),k+=l[n].length;if(500<=k)break}}else if(f.hasOwnProperty("params"))if(k=f.params,"object"===typeof f.params)for(d in p=0,k){if(k[d]&&(m="params."+d,n=String(JSON.stringify(k[d])).substr(0,
500),l[m]=n,p+=m.length+n.length,500<p))break}else l.params=String(JSON.stringify(k)).substr(0,500);f=tb(f);(h=h||f.stack)||(h="Not available");k={stackTrace:h};f.fileName&&(k.filename=f.fileName);d=f.lineNumber.toString();isNaN(d)||!g||isNaN(g)||(k.lineNumber=Number(d),k.columnNumber=Number(g),d=d+":"+g);window.yterr&&ua(window.yterr)&&(f.params=l,window.yterr(f));if(!(He.has(f.message)||0<=h.indexOf("/YouTubeCenter.js")||0<=h.indexOf("/mytube.js"))){if(R("kevlar_gel_error_routing")){g=void 0;m=
e;n=k;k=l;p={level:"ERROR_LEVEL_UNKNOWN",message:f.message};"ERROR"===m?p.level="ERROR_LEVEL_ERROR":"WARNING"===m&&(p.level="ERROR_LEVEL_WARNNING");m={isObfuscated:!0,browserStackInfo:n};n={pageUrl:window.location.href,kvPairs:[]};q=t(Object.keys(k));for(var x=q.next();!x.done;x=q.next())x=x.value,n.kvPairs.push({key:"client."+x,value:String(k[x])});m={errorMetadata:n,stackTrace:m,logMessage:p};g=void 0===g?{}:g;k=Ge;N("ytLoggingEventsDefaultDisabled",!1)&&Ge==Ge&&(k=null);g=void 0===g?{}:g;p={};
p.eventTimeMs=Math.round(g.timestamp||T());p.clientError=m;m=String;g.timestamp?n=-1:(n=y("_lact",window),null==n?n=-1:n=Math.max(A()-n,0));p.context={lastActivityMs:m(n)};R("log_sequence_info_on_gel_web")&&g.U&&(m=p.context,n=g.U,ce[n]=n in ce?ce[n]+1:0,m.sequence={index:ce[n],groupKey:n},g.ua&&delete ce[g.U]);g={endpoint:"log_event",payload:p,s:g.s};R("use_typescript_transport")?"log_event"===g.endpoint&&(m="",g.s&&(p=g.s,m={},p.videoId?m.videoId=p.videoId:p.playlistId&&(m.playlistId=p.playlistId),
Cd[g.s.token]=m,m=g.s.token),p=Bd.get(m)||[],Bd.set(m,p),p.push(g.payload),k&&(vd=new k),g=pd("web_logging_max_batch")||100,k=T(),p.length>=g?Dd():10<=k-yd&&(Fd(),yd=k)):(g.s?(p=g.s,m={},p.videoId?m.videoId=p.videoId:p.playlistId&&(m.playlistId=p.playlistId),Wd[g.s.token]=m,p=Yd(g.endpoint,g.s.token)):p=Yd(g.endpoint),p.push(g.payload),k&&(Rd[g.endpoint]=new k),g=pd("web_logging_max_batch")||100,k=T(),p.length>=g?Xd():10<=k-Ud&&($d(),Ud=k));Xd()}e={fa:{a:"logerror",t:"jserror",type:f.name,msg:f.message.substr(0,
250),line:d,level:e,"client.name":l.name},o:{url:N("PAGE_NAME",window.location.href),file:f.fileName},method:"POST"};l.version&&(e["client.version"]=l.version);if(e.o){h&&(e.o.stack=h);h=t(Object.keys(l));for(d=h.next();!d.done;d=h.next())d=d.value,e.o["client."+d]=l[d];if(l=N("LATEST_ECATCHER_SERVICE_TRACKING_PARAMS",void 0))for(h=t(Object.keys(l)),d=h.next();!d.done;d=h.next())d=d.value,e.o[d]=l[d];l=N("SERVER_NAME",void 0);h=N("SERVER_VERSION",void 0);l&&h&&(e.o["server.name"]=l,e.o["server.version"]=
h)}se(N("ECATCHER_REPORT_HOST","")+"/error_204",e);He.add(f.message);Ie++}}}}}else throw B;}else console&&console.warn&&console.warn("The YouTube player is not attached to the DOM. API calls should be made after the onReady event. See more: https://developers.google.com/youtube/iframe_api_reference#Events")};function Pe(a){return(0===a.search("cue")||0===a.search("load"))&&"loadModule"!==a}
function Qe(a){return 0===a.search("get")||0===a.search("is")}
;function Z(a,b){if(!a)throw Error("YouTube player element ID required.");var c={title:"video player",videoId:"",width:640,height:360};if(b)for(var d in b)c[d]=b[d];Y.call(this,a,c,"player");this.w={};this.playerInfo={}}
ja(Z,Y);r=Z.prototype;r.G=function(){return"/embed/"+Q(this.g,"videoId")};
r.F=function(){var a=Q(this.g,"playerVars");if(a){var b={},c;for(c in a)b[c]=a[c];a=b}else a={};window!=window.top&&document.referrer&&(a.widget_referrer=document.referrer.substring(0,256));if(c=Q(this.g,"embedConfig")){if(va(c))try{c=JSON.stringify(c)}catch(d){console.error("Invalid embed config JSON",d)}a.embed_config=c}return a};
r.S=function(a){var b=a.event;a=a.info;switch(b){case "apiInfoDelivery":if(va(a))for(var c in a)this.w[c]=a[c];break;case "infoDelivery":Re(this,a);break;case "initialDelivery":window.clearInterval(this.h);this.playerInfo={};this.w={};Se(this,a.apiInterface);Re(this,a);break;default:this.C(b,a)}};
function Re(a,b){if(va(b))for(var c in b)a.playerInfo[c]=b[c]}
function Se(a,b){E(b,function(c){this[c]||("getCurrentTime"==c?this[c]=function(){var d=this.playerInfo.currentTime;if(1==this.playerInfo.playerState){var e=(A()/1E3-this.playerInfo.currentTimeLastUpdated_)*this.playerInfo.playbackRate;0<e&&(d+=Math.min(e,1))}return d}:Pe(c)?this[c]=function(){this.playerInfo={};
this.w={};Oe(this,c,arguments);return this}:Qe(c)?this[c]=function(){var d=0;
0===c.search("get")?d=3:0===c.search("is")&&(d=2);return this.playerInfo[c.charAt(d).toLowerCase()+c.substr(d+1)]}:this[c]=function(){Oe(this,c,arguments);
return this})},a)}
r.getVideoEmbedCode=function(){var a=parseInt(Q(this.g,"width"),10);var b=parseInt(Q(this.g,"height"),10),c=Q(this.g,"host")+this.G();Ya.test(c)&&(-1!=c.indexOf("&")&&(c=c.replace(Sa,"&amp;")),-1!=c.indexOf("<")&&(c=c.replace(Ta,"&lt;")),-1!=c.indexOf(">")&&(c=c.replace(Ua,"&gt;")),-1!=c.indexOf('"')&&(c=c.replace(Va,"&quot;")),-1!=c.indexOf("'")&&(c=c.replace(Wa,"&#39;")),-1!=c.indexOf("\x00")&&(c=c.replace(Xa,"&#0;")));a='<iframe width="'+a+'" height="'+b+'" src="'+c+'" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>';
return a};
r.getOptions=function(a){return this.w.namespaces?a?this.w[a].options||[]:this.w.namespaces||[]:[]};
r.getOption=function(a,b){if(this.w.namespaces&&a&&b)return this.w[a][b]};
function Te(a){if("iframe"!=a.tagName.toLowerCase()){var b=P(a,"videoid");b&&(b={videoId:b,width:P(a,"width"),height:P(a,"height")},new Z(a,b))}}
;function Ue(a,b){var c={title:"Thumbnail",videoId:"",width:120,height:68};if(b)for(var d in b)c[d]=b[d];Y.call(this,a,c,"thumbnail")}
ja(Ue,Y);Ue.prototype.G=function(){return"/embed/"+Q(this.g,"videoId")};
Ue.prototype.F=function(){return{player:0,thumb_width:Q(this.g,"thumbWidth"),thumb_height:Q(this.g,"thumbHeight"),thumb_align:Q(this.g,"thumbAlign")}};
Ue.prototype.C=function(a,b){Y.prototype.C.call(this,a,b?b.info:void 0)};
function Ve(a){if("iframe"!=a.tagName.toLowerCase()){var b=P(a,"videoid");if(b){b={videoId:b,events:{},width:P(a,"width"),height:P(a,"height"),thumbWidth:P(a,"thumb-width"),thumbHeight:P(a,"thumb-height"),thumbAlign:P(a,"thumb-align")};var c=P(a,"onclick");c&&(b.events.onClick=c);new Ue(a,b)}}}
;C("YT.PlayerState.UNSTARTED",-1);C("YT.PlayerState.ENDED",0);C("YT.PlayerState.PLAYING",1);C("YT.PlayerState.PAUSED",2);C("YT.PlayerState.BUFFERING",3);C("YT.PlayerState.CUED",5);C("YT.get",function(a){return fd[a]});
C("YT.scan",id);C("YT.subscribe",function(a,b,c){tc.subscribe(a,b,c);hd[a]=!0;for(var d in fd)Me(fd[d],a)});
C("YT.unsubscribe",function(a,b,c){sc(a,b,c)});
C("YT.Player",Z);C("YT.Thumbnail",Ue);Y.prototype.destroy=Y.prototype.destroy;Y.prototype.setSize=Y.prototype.setSize;Y.prototype.getIframe=Y.prototype.da;Y.prototype.addEventListener=Y.prototype.addEventListener;Z.prototype.getVideoEmbedCode=Z.prototype.getVideoEmbedCode;Z.prototype.getOptions=Z.prototype.getOptions;Z.prototype.getOption=Z.prototype.getOption;gd.push(function(a){a=jd("player",a);E(a,Te)});
gd.push(function(){var a=jd("thumbnail");E(a,Ve)});
"undefined"!=typeof YTConfig&&YTConfig.parsetags&&"onload"!=YTConfig.parsetags||id();var We=y("onYTReady");We&&We();var Xe=y("onYouTubeIframeAPIReady");Xe&&Xe();var Ye=y("onYouTubePlayerAPIReady");Ye&&Ye();}).call(this);

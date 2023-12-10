(function(){var aa="function"==typeof Object.create?Object.create:function(a){function b(){}
b.prototype=a;return new b},l;
if("function"==typeof Object.setPrototypeOf)l=Object.setPrototypeOf;else{var m;a:{var ba={s:!0},ca={};try{ca.__proto__=ba;m=ca.s;break a}catch(a){}m=!1}l=m?function(a,b){a.__proto__=b;if(a.__proto__!==b)throw new TypeError(a+" is not extensible");return a}:null}var da=l;
function n(a,b){a.prototype=aa(b.prototype);a.prototype.constructor=a;if(da)da(a,b);else for(var c in b)if("prototype"!=c)if(Object.defineProperties){var d=Object.getOwnPropertyDescriptor(b,c);d&&Object.defineProperty(a,c,d)}else a[c]=b[c];a.C=b.prototype}
var p=this;function q(a){return"string"==typeof a}
function r(a,b){var c=a.split("."),d=p;c[0]in d||"undefined"==typeof d.execScript||d.execScript("var "+c[0]);for(var e;c.length&&(e=c.shift());)c.length||void 0===b?d[e]&&d[e]!==Object.prototype[e]?d=d[e]:d=d[e]={}:d[e]=b}
function u(a){a=a.split(".");for(var b=p,c=0;c<a.length;c++)if(b=b[a[c]],null==b)return null;return b}
function v(){}
function w(a){var b=typeof a;if("object"==b)if(a){if(a instanceof Array)return"array";if(a instanceof Object)return b;var c=Object.prototype.toString.call(a);if("[object Window]"==c)return"object";if("[object Array]"==c||"number"==typeof a.length&&"undefined"!=typeof a.splice&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("splice"))return"array";if("[object Function]"==c||"undefined"!=typeof a.call&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("call"))return"function"}else return"null";
else if("function"==b&&"undefined"==typeof a.call)return"object";return b}
function ea(a){var b=w(a);return"array"==b||"object"==b&&"number"==typeof a.length}
function x(a){return"function"==w(a)}
function fa(a){var b=typeof a;return"object"==b&&null!=a||"function"==b}
function ha(a,b,c){return a.call.apply(a.bind,arguments)}
function ia(a,b,c){if(!a)throw Error();if(2<arguments.length){var d=Array.prototype.slice.call(arguments,2);return function(){var c=Array.prototype.slice.call(arguments);Array.prototype.unshift.apply(c,d);return a.apply(b,c)}}return function(){return a.apply(b,arguments)}}
function y(a,b,c){Function.prototype.bind&&-1!=Function.prototype.bind.toString().indexOf("native code")?y=ha:y=ia;return y.apply(null,arguments)}
var ja=Date.now||function(){return+new Date};
function ka(a,b){function c(){}
c.prototype=b.prototype;a.C=b.prototype;a.prototype=new c;a.prototype.constructor=a;a.D=function(a,c,f){for(var d=Array(arguments.length-2),e=2;e<arguments.length;e++)d[e-2]=arguments[e];return b.prototype[c].apply(a,d)}}
;function z(a){if(Error.captureStackTrace)Error.captureStackTrace(this,z);else{var b=Error().stack;b&&(this.stack=b)}a&&(this.message=String(a))}
ka(z,Error);z.prototype.name="CustomError";var la=Array.prototype.indexOf?function(a,b){return Array.prototype.indexOf.call(a,b,void 0)}:function(a,b){if(q(a))return q(b)&&1==b.length?a.indexOf(b,0):-1;
for(var c=0;c<a.length;c++)if(c in a&&a[c]===b)return c;return-1},A=Array.prototype.forEach?function(a,b){Array.prototype.forEach.call(a,b,void 0)}:function(a,b){for(var c=a.length,d=q(a)?a.split(""):a,e=0;e<c;e++)e in d&&b.call(void 0,d[e],e,a)};
function ma(a,b){for(var c=1;c<arguments.length;c++){var d=arguments[c];if(ea(d)){var e=a.length||0,f=d.length||0;a.length=e+f;for(var g=0;g<f;g++)a[e+g]=d[g]}else a.push(d)}}
;function B(a,b){this.c=a;this.f=b;this.b=0;this.a=null}
B.prototype.get=function(){if(0<this.b){this.b--;var a=this.a;this.a=a.next;a.next=null}else a=this.c();return a};
function na(a,b){a.f(b);100>a.b&&(a.b++,b.next=a.a,a.a=b)}
;var C;a:{var oa=p.navigator;if(oa){var pa=oa.userAgent;if(pa){C=pa;break a}}C=""};function qa(a,b){var c=ea(b),d=c?b:arguments;for(c=c?0:1;c<d.length;c++){if(null==a)return;a=a[d[c]]}return a}
function ra(){var a=sa,b={},c;for(c in a)b[c]=a[c];return b}
var ta="constructor hasOwnProperty isPrototypeOf propertyIsEnumerable toLocaleString toString valueOf".split(" ");function ua(a,b){for(var c,d,e=1;e<arguments.length;e++){d=arguments[e];for(c in d)a[c]=d[c];for(var f=0;f<ta.length;f++)c=ta[f],Object.prototype.hasOwnProperty.call(d,c)&&(a[c]=d[c])}}
;function va(a){p.setTimeout(function(){throw a;},0)}
var D;
function wa(){var a=p.MessageChannel;"undefined"===typeof a&&"undefined"!==typeof window&&window.postMessage&&window.addEventListener&&-1==C.indexOf("Presto")&&(a=function(){var a=document.createElement("IFRAME");a.style.display="none";a.src="";document.documentElement.appendChild(a);var b=a.contentWindow;a=b.document;a.open();a.write("");a.close();var c="callImmediate"+Math.random(),d="file:"==b.location.protocol?"*":b.location.protocol+"//"+b.location.host;a=y(function(a){if(("*"==d||a.origin==d)&&
a.data==c)this.port1.onmessage()},this);
b.addEventListener("message",a,!1);this.port1={};this.port2={postMessage:function(){b.postMessage(c,d)}}});
if("undefined"!==typeof a&&-1==C.indexOf("Trident")&&-1==C.indexOf("MSIE")){var b=new a,c={},d=c;b.port1.onmessage=function(){if(void 0!==c.next){c=c.next;var a=c.i;c.i=null;a()}};
return function(a){d.next={i:a};d=d.next;b.port2.postMessage(0)}}return"undefined"!==typeof document&&"onreadystatechange"in document.createElement("SCRIPT")?function(a){var b=document.createElement("SCRIPT");
b.onreadystatechange=function(){b.onreadystatechange=null;b.parentNode.removeChild(b);b=null;a();a=null};
document.documentElement.appendChild(b)}:function(a){p.setTimeout(a,0)}}
;function E(){this.b=this.a=null}
var xa=new B(function(){return new F},function(a){a.reset()});
E.prototype.add=function(a,b){var c=xa.get();c.set(a,b);this.b?this.b.next=c:this.a=c;this.b=c};
E.prototype.remove=function(){var a=null;this.a&&(a=this.a,this.a=this.a.next,this.a||(this.b=null),a.next=null);return a};
function F(){this.next=this.b=this.a=null}
F.prototype.set=function(a,b){this.a=a;this.b=b;this.next=null};
F.prototype.reset=function(){this.next=this.b=this.a=null};function G(a,b){H||ya();I||(H(),I=!0);za.add(a,b)}
var H;function ya(){if(p.Promise&&p.Promise.resolve){var a=p.Promise.resolve(void 0);H=function(){a.then(Aa)}}else H=function(){var a=Aa,c;
!(c=!x(p.setImmediate))&&(c=p.Window&&p.Window.prototype)&&(c=-1==C.indexOf("Edge")&&p.Window.prototype.setImmediate==p.setImmediate);c?(D||(D=wa()),D(a)):p.setImmediate(a)}}
var I=!1,za=new E;function Aa(){for(var a;a=za.remove();){try{a.a.call(a.b)}catch(b){va(b)}na(xa,a)}I=!1}
;function Ba(){}
;function Ca(a){a.prototype.then=a.prototype.then;a.prototype.$goog_Thenable=!0}
function J(a){if(!a)return!1;try{return!!a.$goog_Thenable}catch(b){return!1}}
;function K(a,b){this.a=0;this.j=void 0;this.f=this.b=this.c=null;this.g=this.h=!1;if(a!=v)try{var c=this;a.call(b,function(a){L(c,2,a)},function(a){L(c,3,a)})}catch(d){L(this,3,d)}}
function Da(){this.next=this.context=this.b=this.c=this.a=null;this.f=!1}
Da.prototype.reset=function(){this.context=this.b=this.c=this.a=null;this.f=!1};
var Ea=new B(function(){return new Da},function(a){a.reset()});
function Fa(a,b,c){var d=Ea.get();d.c=a;d.b=b;d.context=c;return d}
function M(a){return new K(function(b,c){c(a)})}
K.prototype.then=function(a,b,c){return Ga(this,x(a)?a:null,x(b)?b:null,c)};
Ca(K);function N(a,b){return Ga(a,null,b,void 0)}
K.prototype.cancel=function(a){0==this.a&&G(function(){var b=new O(a);Ha(this,b)},this)};
function Ha(a,b){if(0==a.a)if(a.c){var c=a.c;if(c.b){for(var d=0,e=null,f=null,g=c.b;g&&(g.f||(d++,g.a==a&&(e=g),!(e&&1<d)));g=g.next)e||(f=g);e&&(0==c.a&&1==d?Ha(c,b):(f?(d=f,d.next==c.f&&(c.f=d),d.next=d.next.next):Ia(c),Ja(c,e,3,b)))}a.c=null}else L(a,3,b)}
function Ka(a,b){a.b||2!=a.a&&3!=a.a||La(a);a.f?a.f.next=b:a.b=b;a.f=b}
function Ga(a,b,c,d){var e=Fa(null,null,null);e.a=new K(function(a,g){e.c=b?function(c){try{var e=b.call(d,c);a(e)}catch(t){g(t)}}:a;
e.b=c?function(b){try{var e=c.call(d,b);void 0===e&&b instanceof O?g(b):a(e)}catch(t){g(t)}}:g});
e.a.c=a;Ka(a,e);return e.a}
K.prototype.v=function(a){this.a=0;L(this,2,a)};
K.prototype.w=function(a){this.a=0;L(this,3,a)};
function L(a,b,c){if(0==a.a){a===c&&(b=3,c=new TypeError("Promise cannot resolve to itself"));a.a=1;a:{var d=c,e=a.v,f=a.w;if(d instanceof K){Ka(d,Fa(e||v,f||null,a));var g=!0}else if(J(d))d.then(e,f,a),g=!0;else{if(fa(d))try{var h=d.then;if(x(h)){Ma(d,h,e,f,a);g=!0;break a}}catch(k){f.call(a,k);g=!0;break a}g=!1}}g||(a.j=c,a.a=b,a.c=null,La(a),3!=b||c instanceof O||Na(a,c))}}
function Ma(a,b,c,d,e){function f(a){h||(h=!0,d.call(e,a))}
function g(a){h||(h=!0,c.call(e,a))}
var h=!1;try{b.call(a,g,f)}catch(k){f(k)}}
function La(a){a.h||(a.h=!0,G(a.u,a))}
function Ia(a){var b=null;a.b&&(b=a.b,a.b=b.next,b.next=null);a.b||(a.f=null);return b}
K.prototype.u=function(){for(var a;a=Ia(this);)Ja(this,a,this.a,this.j);this.h=!1};
function Ja(a,b,c,d){if(3==c&&b.b&&!b.f)for(;a&&a.g;a=a.c)a.g=!1;if(b.a)b.a.c=null,Oa(b,c,d);else try{b.f?b.c.call(b.context):Oa(b,c,d)}catch(e){Pa.call(null,e)}na(Ea,b)}
function Oa(a,b,c){2==b?a.c.call(a.context,c):a.b&&a.b.call(a.context,c)}
function Na(a,b){a.g=!0;G(function(){a.g&&Pa.call(null,b)})}
var Pa=va;function O(a){z.call(this,a)}
ka(O,z);O.prototype.name="cancel";var P=/^(?:([^:/?#.]+):)?(?:\/\/(?:([^/?#]*)@)?([^/#?]*?)(?::([0-9]+))?(?=[/#?]|$))?([^?#]+)?(?:\?([^#]*))?(?:#([\s\S]*))?$/;function Q(a){return a?decodeURI(a):a}
function Qa(a,b,c){if("array"==w(b))for(var d=0;d<b.length;d++)Qa(a,String(b[d]),c);else null!=b&&c.push(a+(""===b?"":"="+encodeURIComponent(String(b))))}
function Ra(a){var b=[],c;for(c in a)Qa(c,a[c],b);return b.join("&")}
;var R=window.yt&&window.yt.config_||window.ytcfg&&window.ytcfg.data_||{};r("yt.config_",R);function Sa(a){var b=arguments;if(1<b.length)R[b[0]]=b[1];else{b=b[0];for(var c in b)R[c]=b[c]}}
function S(a,b){return a in R?R[a]:b}
;ja();function Ta(a){return a&&window.yterr?function(){try{return a.apply(this,arguments)}catch(b){Ua(b)}}:a}
function Ua(a){var b=u("yt.logging.errors.log");b?b(a,void 0,void 0,void 0,void 0):(b=S("ERRORS",[]),b.push([a,void 0,void 0,void 0,void 0]),Sa("ERRORS",b))}
;var Va=void 0!==XMLHttpRequest?function(){return new XMLHttpRequest}:void 0!==ActiveXObject?function(){return new ActiveXObject("Microsoft.XMLHTTP")}:null;
function Wa(){if(!Va)return null;var a=Va();return"open"in a?a:null}
function Xa(a){switch(a&&"status"in a?a.status:-1){case 200:case 201:case 202:case 203:case 204:case 205:case 206:case 304:return!0;default:return!1}}
;function Ya(a,b){x(a)&&(a=Ta(a));return window.setTimeout(a,b)}
;function T(a){"?"==a.charAt(0)&&(a=a.substr(1));a=a.split("&");for(var b={},c=0,d=a.length;c<d;c++){var e=a[c].split("=");if(1==e.length&&e[0]||2==e.length){var f=decodeURIComponent((e[0]||"").replace(/\+/g," "));e=decodeURIComponent((e[1]||"").replace(/\+/g," "));f in b?"array"==w(b[f])?ma(b[f],e):b[f]=[b[f],e]:b[f]=e}}return b}
function Za(a,b,c){var d=a.split("#",2);a=d[0];d=1<d.length?"#"+d[1]:"";var e=a.split("?",2);a=e[0];e=T(e[1]||"");for(var f in b)!c&&null!==e&&f in e||(e[f]=b[f]);b=a;a=Ra(e);a?(c=b.indexOf("#"),0>c&&(c=b.length),f=b.indexOf("?"),0>f||f>c?(f=c,e=""):e=b.substring(f+1,c),b=[b.substr(0,f),e,b.substr(c)],c=b[1],b[1]=a?c?c+"&"+a:a:c,a=b[0]+(b[1]?"?"+b[1]:"")+b[2]):a=b;return a+d}
;var $a={Authorization:"AUTHORIZATION","X-Goog-Visitor-Id":"SANDBOXED_VISITOR_ID","X-YouTube-Client-Name":"INNERTUBE_CONTEXT_CLIENT_NAME","X-YouTube-Client-Version":"INNERTUBE_CONTEXT_CLIENT_VERSION","X-Youtube-Identity-Token":"ID_TOKEN","X-YouTube-Page-CL":"PAGE_CL","X-YouTube-Page-Label":"PAGE_BUILD_LABEL","X-YouTube-Variants-Checksum":"VARIANTS_CHECKSUM"},ab="app debugcss debugjs expflag forced_experiments absolute_experiments conditional_experiments sbb sr_bns_address".split(" "),bb=!1;
function cb(a,b){b=void 0===b?{}:b;if(!c)var c=window.location.href;var d=a.match(P)[1]||null,e=Q(a.match(P)[3]||null);d&&e?(d=c,c=a.match(P),d=d.match(P),c=c[3]==d[3]&&c[1]==d[1]&&c[4]==d[4]):c=e?Q(c.match(P)[3]||null)==e&&(Number(c.match(P)[4]||null)||null)==(Number(a.match(P)[4]||null)||null):!0;d=!!S("EXPERIMENT_FLAGS",{}).web_ajax_ignore_global_headers_if_set;for(var f in $a)e=S($a[f]),!e||!c&&!db(a,f)||d&&void 0!==b[f]||(b[f]=e);if(c||db(a,"X-YouTube-Utc-Offset"))b["X-YouTube-Utc-Offset"]=-(new Date).getTimezoneOffset();
return b}
function eb(a){var b=T(window.location.search),c={};A(ab,function(a){b[a]&&(c[a]=b[a])});
return Za(a,c||{},!1)}
function db(a,b){var c=S("CORS_HEADER_WHITELIST")||{},d=Q(a.match(P)[3]||null);return d?(c=c[d])?0<=la(c,b):!1:!0}
function fb(a){var b=a.format||"JSON";var c=gb("//googleads.g.doubleclick.net/pagead/id",a);var d=hb(c,a),e=!1,f,g=ib(c,function(c){if(!e){e=!0;f&&window.clearTimeout(f);var d=Xa(c),g=null,h=400<=c.status&&500>c.status,tb=500<=c.status&&600>c.status;if(d||h||tb)g=jb(b,c,a.F);if(d)a:if(c&&204==c.status)d=!0;else{switch(b){case "XML":d=0==parseInt(g&&g.return_code,10);break a;case "RAW":d=!0;break a}d=!!g}g=g||{};h=a.context||p;d?a.l&&a.l.call(h,c,g):a.onError&&a.onError.call(h,c,g);a.A&&a.A.call(h,
c,g)}},a.method,d,a.headers,a.responseType,a.withCredentials);
a.m&&0<a.timeout&&(f=Ya(function(){e||(e=!0,g.abort(),window.clearTimeout(f),a.m.call(a.context||p,g))},a.timeout));
return g}
function gb(a,b){b.H&&(a=document.location.protocol+"//"+document.location.hostname+(document.location.port?":"+document.location.port:"")+a);var c=S("XSRF_FIELD_NAME",void 0),d=b.J;d&&(d[c]&&delete d[c],a=Za(a,d||{},!0));return a}
function hb(a,b){var c=S("XSRF_FIELD_NAME",void 0),d=S("XSRF_TOKEN",void 0),e=b.I||"",f=b.o,g=S("XSRF_FIELD_NAME",void 0),h;b.headers&&(h=b.headers["Content-Type"]);b.G||Q(a.match(P)[3]||null)&&!b.withCredentials&&Q(a.match(P)[3]||null)!=document.location.hostname||"POST"!=b.method||h&&"application/x-www-form-urlencoded"!=h||b.o&&b.o[g]||(f||(f={}),f[c]=d);f&&q(e)&&(e=T(e),ua(e,f),e=b.B&&"JSON"==b.B?JSON.stringify(e):Ra(e));if(!(c=e)&&(c=f)){a:{for(var k in f){f=!1;break a}f=!0}c=!f}!bb&&c&&"POST"!=
b.method&&(bb=!0,Ua(Error("AJAX request with postData should use POST")));return e}
function jb(a,b,c){var d=null;switch(a){case "JSON":a=b.responseText;b=b.getResponseHeader("Content-Type")||"";a&&0<=b.indexOf("json")&&(d=JSON.parse(a));break;case "XML":if(b=(b=b.responseXML)?kb(b):null)d={},A(b.getElementsByTagName("*"),function(a){d[a.tagName]=lb(a)})}c&&mb(d);
return d}
function mb(a){if(fa(a))for(var b in a){var c;(c="html_content"==b)||(c=b.length-5,c=0<=c&&b.indexOf("_html",c)==c);c?a[b]=new Ba:mb(a[b])}}
function kb(a){return a?(a=("responseXML"in a?a.responseXML:a).getElementsByTagName("root"))&&0<a.length?a[0]:null:null}
function lb(a){var b="";A(a.childNodes,function(a){b+=a.nodeValue});
return b}
function ib(a,b,c,d,e,f,g){function h(){4==(k&&"readyState"in k?k.readyState:0)&&b&&Ta(b)(k)}
c=void 0===c?"GET":c;d=void 0===d?"":d;var k=Wa();if(!k)return null;"onloadend"in k?k.addEventListener("loadend",h,!1):k.onreadystatechange=h;S("EXPERIMENT_FLAGS",{}).debug_forward_web_query_parameters&&(a=eb(a));k.open(c,a,!0);f&&(k.responseType=f);g&&(k.withCredentials=!0);c="POST"==c&&(void 0===window.FormData||!(d instanceof FormData));if(e=cb(a,e))for(var t in e)k.setRequestHeader(t,e[t]),"content-type"==t.toLowerCase()&&(c=!1);c&&k.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
k.send(d);return k}
;function nb(){var a=ra(),b;return N(new K(function(c,d){a.l=function(a){Xa(a)?c(a):d(new U("Request failed, status="+a.status,"net.badstatus",a))};
a.onError=function(a){d(new U("Unknown request error","net.unknown",a))};
a.m=function(a){d(new U("Request timed out","net.timeout",a))};
b=fb(a)}),function(a){a instanceof O&&b.abort();
return M(a)})}
function U(a,b){z.call(this,a+", errorCode="+b);this.errorCode=b;this.name="PromiseAjaxError"}
n(U,z);function V(a){this.c=void 0===a?null:a;this.a=0;this.b=null}
V.prototype.then=function(a,b,c){return this.c?this.c.then(a,b,c):1===this.a&&a?(a=a.call(c,this.b),J(a)?a:ob(a)):2===this.a&&b?(a=b.call(c,this.b),J(a)?a:pb(a)):this};
Ca(V);function pb(a){var b=new V;a=void 0===a?null:a;b.a=2;b.b=void 0===a?null:a;return b}
function ob(a){var b=new V;a=void 0===a?null:a;b.a=1;b.b=void 0===a?null:a;return b}
;function W(a){z.call(this,a.message||a.description||a.name);this.isMissing=a instanceof X;this.isTimeout=a instanceof U&&"net.timeout"==a.errorCode;this.isCanceled=a instanceof O}
n(W,z);W.prototype.name="BiscottiError";function X(){z.call(this,"Biscotti ID is missing from server")}
n(X,z);X.prototype.name="BiscottiMissingError";var sa={format:"RAW",method:"GET",timeout:5E3,withCredentials:!0},Y=null;function qb(){if("1"===qa(S("PLAYER_CONFIG",{}),"args","privembed"))return M(Error("Biscotti ID is not available in private embed mode"));Y||(Y=N(nb().then(rb),function(a){return sb(2,a)}));
return Y}
function rb(a){a=a.responseText;if(0!=a.lastIndexOf(")]}'",0))throw new X;a=JSON.parse(a.substr(4));if(1<(a.type||1))throw new X;a=a.id;ub(a);Y=ob(a);vb(18E5,2);return a}
function sb(a,b){var c=new W(b);ub("");Y=pb(c);0<a&&vb(12E4,a-1);throw c;}
function vb(a,b){Ya(function(){N(nb().then(rb,function(a){return sb(b,a)}),v)},a)}
function ub(a){r("yt.ads.biscotti.lastId_",a)}
;u("yt.ads.biscotti.getId_")||r("yt.ads.biscotti.getId_",qb);var Z;try{var wb=u("yt.ads.biscotti.getId_");Z=wb?wb():qb()}catch(a){Z=M(a)}N(Z,v);}).call(this);

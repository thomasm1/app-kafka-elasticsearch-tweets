// modules are defined as an array
// [ module function, map of requires ]
//
// map of requires is short require name -> numeric require
//
// anything defined in a previous bundle is accessed via the
// orig method which is the require for previous bundles
parcelRequire = (function (modules, cache, entry, globalName) {
  // Save the require from previous bundle to this closure if any
  var previousRequire = typeof parcelRequire === 'function' && parcelRequire;
  var nodeRequire = typeof require === 'function' && require;

  function newRequire(name, jumped) {
    if (!cache[name]) {
      if (!modules[name]) {
        // if we cannot find the module within our internal map or
        // cache jump to the current global require ie. the last bundle
        // that was added to the page.
        var currentRequire = typeof parcelRequire === 'function' && parcelRequire;
        if (!jumped && currentRequire) {
          return currentRequire(name, true);
        }

        // If there are other bundles on this page the require from the
        // previous one is saved to 'previousRequire'. Repeat this as
        // many times as there are bundles until the module is found or
        // we exhaust the require chain.
        if (previousRequire) {
          return previousRequire(name, true);
        }

        // Try the node require function if it exists.
        if (nodeRequire && typeof name === 'string') {
          return nodeRequire(name);
        }

        var err = new Error('Cannot find module \'' + name + '\'');
        err.code = 'MODULE_NOT_FOUND';
        throw err;
      }

      localRequire.resolve = resolve;
      localRequire.cache = {};

      var module = cache[name] = new newRequire.Module(name);

      modules[name][0].call(module.exports, localRequire, module, module.exports, this);
    }

    return cache[name].exports;

    function localRequire(x){
      return newRequire(localRequire.resolve(x));
    }

    function resolve(x){
      return modules[name][1][x] || x;
    }
  }

  function Module(moduleName) {
    this.id = moduleName;
    this.bundle = newRequire;
    this.exports = {};
  }

  newRequire.isParcelRequire = true;
  newRequire.Module = Module;
  newRequire.modules = modules;
  newRequire.cache = cache;
  newRequire.parent = previousRequire;
  newRequire.register = function (id, exports) {
    modules[id] = [function (require, module) {
      module.exports = exports;
    }, {}];
  };

  var error;
  for (var i = 0; i < entry.length; i++) {
    try {
      newRequire(entry[i]);
    } catch (e) {
      // Save first error but execute all entries
      if (!error) {
        error = e;
      }
    }
  }

  if (entry.length) {
    // Expose entry point to Node, AMD or browser globals
    // Based on https://github.com/ForbesLindesay/umd/blob/master/template.js
    var mainExports = newRequire(entry[entry.length - 1]);

    // CommonJS
    if (typeof exports === "object" && typeof module !== "undefined") {
      module.exports = mainExports;

    // RequireJS
    } else if (typeof define === "function" && define.amd) {
     define(function () {
       return mainExports;
     });

    // <script>
    } else if (globalName) {
      this[globalName] = mainExports;
    }
  }

  // Override the current require with this new one
  parcelRequire = newRequire;

  if (error) {
    // throw error from earlier, _after updating parcelRequire_
    throw error;
  }

  return newRequire;
})({"dataCalculators/arrayMethods.js":[function(require,module,exports) {
console.log("%c BITCOIN CALCS BEGIN: ", "color:white; background-color:black"); // document.getElementById("app").innerHTML = ` 
// <div class="appTitle">
// </div>   
// `;

var btc2019 = [{
  Date: "2019-07-04",
  Symbol: "BTCUSD",
  Open: 11976.42,
  High: 12064.26,
  Low: 11820,
  Close: 11909.55,
  "Volume BTC": 1237.57,
  "Volume USD": 14790355.69
}, {
  Date: "2019-07-03",
  Symbol: "BTCUSD",
  Open: 10829.18,
  High: 12014.6,
  Low: 10829.18,
  Close: 11976.42,
  "Volume BTC": 36836.85,
  "Volume USD": 419076229.34
}, {
  Date: "2019-07-02",
  Symbol: "BTCUSD",
  Open: 10577.63,
  High: 10925,
  Low: 9651,
  Close: 10829.18,
  "Volume BTC": 41476.42,
  "Volume USD": 424791613.92
}, {
  Date: "2019-07-01",
  Symbol: "BTCUSD",
  Open: 10761.26,
  High: 11210.52,
  Low: 9953,
  Close: 10577.63,
  "Volume BTC": 37633.9,
  "Volume USD": 396857365.17
}];
var ethBtc = [{
  Date: "2019-07-04",
  Symbol: "BTCUSD",
  Open: 11976.42,
  High: 12064.26,
  Low: 11820,
  Close: 11909.55,
  "Volume BTC": 1237.57,
  "Volume USD": 14790355.69
}, {
  Date: "2019-07-03",
  Symbol: "BTCUSD",
  Open: 10829.18,
  High: 12014.6,
  Low: 10829.18,
  Close: 11976.42,
  "Volume BTC": 36836.85,
  "Volume USD": 419076229.34
}, {
  Date: "2019-07-02",
  Symbol: "BTCUSD",
  Open: 10577.63,
  High: 10925,
  Low: 9651,
  Close: 10829.18,
  "Volume BTC": 41476.42,
  "Volume USD": 424791613.92
}, {
  Date: "2019-07-01",
  Symbol: "BTCUSD",
  Open: 10761.26,
  High: 11210.52,
  Low: 9953,
  Close: 10577.63,
  "Volume BTC": 37633.9,
  "Volume USD": 396857365.17
}, {
  Date: "2019-07-04",
  Symbol: "ETHUSD",
  Open: 301.79,
  High: 304,
  Low: 300.39,
  Close: 301.5,
  "Volume ETH": 3825.69,
  "Volume USD": 1154988.12
}, {
  Date: "2019-07-03",
  Symbol: "ETHUSD",
  Open: 291.25,
  High: 303.83,
  Low: 289.61,
  Close: 301.79,
  "Volume ETH": 105691.96,
  "Volume USD": 31264397.55
}, {
  Date: "2019-07-02",
  Symbol: "ETHUSD",
  Open: 293.7,
  High: 296.24,
  Low: 270.42,
  Close: 291.25,
  "Volume ETH": 218010.42,
  "Volume USD": 61564550.93
}, {
  Date: "2019-07-01",
  Symbol: "ETHUSD",
  Open: 290.07,
  High: 301.32,
  Low: 278.65,
  Close: 293.7,
  "Volume ETH": 184436.14,
  "Volume USD": 53230192.12
}];
console.log("%c Object mapping: ", "color:orange; border:solid 1px orange"); //0-A.)

console.time("timer_Obj-A.");

for (var key in btc2019[0]) {
  console.log("btc2019[0][key]: ", btc2019[0][key]);
}

console.timeEnd("timer_Obj-A."); //0-B.)

console.time("timer_Obj-B.");

for (var _i = 0, _Object$values = Object.values(btc2019[0]); _i < _Object$values.length; _i++) {
  var b = _Object$values[_i];
  console.log("Object.values: ", b);
}

console.timeEnd("timer_Obj-B."); //0-C.)

console.time("timer_Obj-C.");
var bObject = new Map(Object.entries({
  Date: "2019-07-02",
  Symbol: "BTCUSD",
  Open: 10577.63,
  High: 10925,
  Low: 9651,
  Close: 10829.18,
  "Volume BTC": 41476.42,
  "Volume USD": 424791613.92
}));
var _iteratorNormalCompletion = true;
var _didIteratorError = false;
var _iteratorError = undefined;

try {
  for (var _iterator = bObject.values()[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
    var _b = _step.value;
    console.log("Object.entries", _b);
  }
} catch (err) {
  _didIteratorError = true;
  _iteratorError = err;
} finally {
  try {
    if (!_iteratorNormalCompletion && _iterator.return != null) {
      _iterator.return();
    }
  } finally {
    if (_didIteratorError) {
      throw _iteratorError;
    }
  }
}

console.timeEnd("timer_Obj-C."); //1.)

console.time("timer_i");

for (var i = 0; i < btc2019.length; i++) {
  console.log(btc2019[i].Symbol, btc2019[i].Date, btc2019[i].High);
}

console.timeEnd("timer_i"); //2.

console.time("timer_forOf");

for (var _i2 = 0, _btc = btc2019; _i2 < _btc.length; _i2++) {
  var btc = _btc[_i2];
  console.log(btc.Symbol, btc.Date, btc.High);
}

console.timeEnd("timer_forOf"); //3. forEach

console.time("timer_forEach");
btc2019.forEach(function (btc) {
  console.log(btc.Symbol, btc.Date, btc.High);
});
console.timeEnd("timer_forEach"); //////// FILTER 

console.log("%c Filter, then addin conditional object/array (shortens new array): ", "color:orange; border:solid 1px orange");
var btc2019AddObj = btc2019.filter(function (btc) {
  return btc.Symbol === 'BTCUSD';
}).map(function (btc) {
  return Object.assign({}, btc, {
    newSymbol: 'BTC'
  });
});
console.log('btc2019 with new obj in array', btc2019AddObj); /// SHORTENS ARRAY

console.log('btc2019 untouched ', btc2019);
var btc2019AddArr = btc2019.filter(function (btc) {
  return btc.Symbol === 'BTCUSD';
}).map(function (btc) {
  return Object.assign({}, btc, {
    newSymbol: ['BTC', '3d array']
  });
});
console.log('btc2019 with new obj in array', btc2019AddArr); /// SHORTENS NEW ARRAY

console.log('btc2019 untouched ', btc2019);
console.log("%c Filtering out negative days: ", "color:orange; border:solid 1px orange"); // filter out negative days, calc

var avgPosOnly = btc2019.filter(function (btc) {
  return btc.Close - btc.Open >= 0;
}).map(function (btc) {
  return (btc.Close - btc.Open) / btc2019.length;
}); ///calc each avg

console.log(avgPosOnly); //

var canBuy = btc2019.filter(function (btc) {
  if (btc.Close <= 11000) {
    return true;
  }
});
console.log(canBuy);
print('FILTER' + canBuy); //

var belowtenk = btc2019.filter(function (item) {
  return item.Close < 11000.0;
});
console.log(belowtenk);
print('FILTER' + "<br /><code>".concat(JSON.stringify(belowtenk), "</code>")); ///////// MAP  

console.log("%c Array mapping: ", "color:orange; border:solid 1px orange"); // create object

var newBTC = new Map(Object.entries({
  bitcoin: 'BTC',
  ethereum: 'ETH',
  litecoin: 'LTC'
}));
var _iteratorNormalCompletion2 = true;
var _didIteratorError2 = false;
var _iteratorError2 = undefined;

try {
  for (var _iterator2 = newBTC.values()[Symbol.iterator](), _step2; !(_iteratorNormalCompletion2 = (_step2 = _iterator2.next()).done); _iteratorNormalCompletion2 = true) {
    var _b2 = _step2.value;
    console.log(_b2);
  }
} catch (err) {
  _didIteratorError2 = true;
  _iteratorError2 = err;
} finally {
  try {
    if (!_iteratorNormalCompletion2 && _iterator2.return != null) {
      _iterator2.return();
    }
  } finally {
    if (_didIteratorError2) {
      throw _iteratorError2;
    }
  }
}

var _iteratorNormalCompletion3 = true;
var _didIteratorError3 = false;
var _iteratorError3 = undefined;

try {
  for (var _iterator3 = newBTC.keys()[Symbol.iterator](), _step3; !(_iteratorNormalCompletion3 = (_step3 = _iterator3.next()).done); _iteratorNormalCompletion3 = true) {
    var _b3 = _step3.value;
    console.log(_b3);
  } // count ETH types in array

} catch (err) {
  _didIteratorError3 = true;
  _iteratorError3 = err;
} finally {
  try {
    if (!_iteratorNormalCompletion3 && _iterator3.return != null) {
      _iterator3.return();
    }
  } finally {
    if (_didIteratorError3) {
      throw _iteratorError3;
    }
  }
}

var ethBtc_mixed = ethBtc;
var eth_in_array = ethBtc_mixed.reduce(function (acc, cur) {
  return acc + (cur.Symbol === 'ETHUSD' ? 1 : 0);
}, 0);
console.log(eth_in_array); // take out, clean array (outlier anomalous data)

var ethBtc_mixed1 = ethBtc;
var mislabled = ethBtc_mixed1.filter(function (e) {
  return e.Symbol === 'ETHUSD';
});
var ethBtc_correct = mislabled.map(function (e) {
  return e.Symbol = 'ETH';
});
console.log(mislabled); // cleaned full array

console.log(ethBtc_correct); // cleaned objects
// c vanilla sorting

var unsorted = ethBtc;
console.log("unsorted", unsorted);
var sortedClose = unsorted.sort(function (a, b) {
  return a.Close < b.Close;
}); // ?

console.log("unsorted", unsorted);
console.log("sortedClose", sortedClose); // sorted.splice(SortedClose.length/2) //  cut  array to length of median
// console.log(sorted)
//

var canSell = [];

for (var _i3 = 0; _i3 < btc2019.length; _i3++) {
  if (btc2019[_i3] >= btc2019[_i3 - 1]) {
    canSell.push(btc2019[_i3]);
  }
}

console.log(canSell); // map new arrays -> create array of btc volumes

var coinIntervals = ethBtc.map(function (coin) {
  return "".concat(coin.Symbol, " [O:").concat(coin.Open, "-C:").concat(coin.Close, "]");
});
console.log(coinIntervals);
print('MAP' + coinIntervals); //

var coinSquareRoot = ethBtc.map(function (coin) {
  return Math.sqrt(coin.Close);
});
var coinSquare = ethBtc.map(function (coin) {
  return coin.Close * 2;
});
console.log(coinSquareRoot, coinSquare);
print('MAP' + coinSquareRoot + ' ' + coinSquare); //

var coinSymbols = ethBtc.map(function (coin) {
  return coin.Symbol;
});
console.log(coinSymbols);
print('MAP' + coinSymbols); //

print('MAP' + coinSymbols);
var btcName = btc2019.map(function (item) {
  return "<br />".concat(item.Symbol, " : ").concat(item.Close);
});
console.log(btcName);
print('MAP' + btcName); /////////// FIND - returns first it finds ..  

var btcFind = btc2019.find(function (item) {
  return item.Date === '2019-07-04';
});
console.log(btcFind);
print('FIND: ' + btcFind); /////////// INDEXOF - returns index or -1  ==> use some()

var btcIndexOf = btc2019.includes(btc2019[0]);
console.log(btcIndexOf);
print('INDEXOF: ' + btcIndexOf); /////////// INCLUDES - returns Boolean  ==> use some()

var btcIncludes = btc2019.includes(btc2019[0]);
console.log(btcIncludes);
print('INCLUDES: ' + btcIncludes); /////////// SOME/EVERY - returns Boolean 

var boolSome = btc2019.some(function (btc) {
  return btc.Symbol === 'EHUSD';
});
console.log(boolSome);
print('SOME: ' + boolSome);
var btcSomeTrue = btc2019.some(function (item) {
  return item.Close < 11000;
});
console.log(btcSomeTrue);
print('SOME: ' + btcSomeTrue); /////////// forEACH  - DOES NOT RETURN ANYTHING

var btcForEach = btc2019.forEach(function (item) {
  print('forEACH: ' + "".concat(item.Symbol, " : ").concat(item.Close));
  console.log("".concat(item.Symbol, " : ").concat(item.Close));
}); /////////// REDUCE((accumulation, item) =>{}, startIndex)
// let closeAvg = 0, closeSum = 0;
// for (let i = 0; i < btc2019.length; i++) {
//   closeSum += btc2019[i].Close;
//   closeAvg = closeSum/btc2019.length;
// } 
// Add reduce accumulation object/array  **does not shorten array

console.log("%c reduce acc, then add object/array (does NOT shorten new array):: ", "color:orange; border:solid 1px orange");
var newReducedObject = btc2019.reduce(function (acc, btc) {
  return btc.Symbol === 'BTCUSD' ? acc.concat(Object.assign({}, btc, {
    newSymbol: 'BTC'
  })) : acc.concat(Object.assign({}, btc, {
    newSymbol: 'Not BTC'
  }));
}, []); // does not shorten array

console.log('conditional btc2019', newReducedObject);
console.log('not touched btc2019', btc2019); // close  sum => close AVG

var closeSum = btc2019.reduce(function (total, btc) {
  return total + btc.Close;
}, 0);
var closeAvg = closeSum / btc2019.length;
console.log("sum: " + closeSum, "avg: " + closeAvg); // reduce daily intervals

var closeIntTot = btc2019.reduce(function (total, btc) {
  return total + (btc.Close - btc.Open);
}, 0); //  !!! fix absolutes logic

var closeIAvg = closeIntTot / btc2019.length;
console.log("sum: " + closeIntTot, "avg: " + closeIAvg);
var btcTotalReduce = btc2019.reduce(function (currentTotal, item) {
  return Math.floor((item.Close + currentTotal) / btc2019.length);
}, 0);
console.log(btcTotalReduce);
print('REDUCE: ' + btcTotalReduce); //////////// SORT  
// const sortedBtc = btc2019.sort(function(a, b) {
//   if (a.Close > b.Close) {
//     return 1;
//   } else {
//     return -1;
//   }
// }); 

console.log("%c Sorting (JavaScript library): ", "color:orange; border:solid 1px orange");
var sortedBtc = btc2019.sort(function (a, b) {
  return a.Open > b.Open ? 1 : -1;
});
var sortedB = btc2019.sort(function (a, b) {
  return a.Open - b.Open;
});
console.log(sortedBtc, sortedB); ///////////// FILTER/MAP/SORT/REDUCE CALCULATION

console.log("%c Calc Avg, Sum each pos avg, reduce to total: ", "color:orange; border:solid 1px orange");
var avgPosLong = btc2019.filter(function (btc) {
  return btc.Close - btc.Open >= 0;
}).map(function (btc) {
  return (btc.Close - btc.Open) / btc2019.length;
}) ///calc each avg
.sort(function (a, b) {
  return a - b;
}).reduce(function (a, b) {
  return a + b;
}, 0); // sum each pos avg, reduce to total

var avgPos = avgPosLong / btc2019.length;
console.log(avgPosLong, avgPos);

function print(val) {
  var el = document.createElement('p');
  el.innerHTML = val; // document.getElementById('output').appendChild(el)
}
},{}],"../../../../../Users/thoma/AppData/Roaming/nvm/v10.16.0/node_modules/parcel-bundler/src/builtins/hmr-runtime.js":[function(require,module,exports) {
var global = arguments[3];
var OVERLAY_ID = '__parcel__error__overlay__';
var OldModule = module.bundle.Module;

function Module(moduleName) {
  OldModule.call(this, moduleName);
  this.hot = {
    data: module.bundle.hotData,
    _acceptCallbacks: [],
    _disposeCallbacks: [],
    accept: function (fn) {
      this._acceptCallbacks.push(fn || function () {});
    },
    dispose: function (fn) {
      this._disposeCallbacks.push(fn);
    }
  };
  module.bundle.hotData = null;
}

module.bundle.Module = Module;
var checkedAssets, assetsToAccept;
var parent = module.bundle.parent;

if ((!parent || !parent.isParcelRequire) && typeof WebSocket !== 'undefined') {
  var hostname = "" || location.hostname;
  var protocol = location.protocol === 'https:' ? 'wss' : 'ws';
  var ws = new WebSocket(protocol + '://' + hostname + ':' + "64428" + '/');

  ws.onmessage = function (event) {
    checkedAssets = {};
    assetsToAccept = [];
    var data = JSON.parse(event.data);

    if (data.type === 'update') {
      var handled = false;
      data.assets.forEach(function (asset) {
        if (!asset.isNew) {
          var didAccept = hmrAcceptCheck(global.parcelRequire, asset.id);

          if (didAccept) {
            handled = true;
          }
        }
      }); // Enable HMR for CSS by default.

      handled = handled || data.assets.every(function (asset) {
        return asset.type === 'css' && asset.generated.js;
      });

      if (handled) {
        console.clear();
        data.assets.forEach(function (asset) {
          hmrApply(global.parcelRequire, asset);
        });
        assetsToAccept.forEach(function (v) {
          hmrAcceptRun(v[0], v[1]);
        });
      } else if (location.reload) {
        // `location` global exists in a web worker context but lacks `.reload()` function.
        location.reload();
      }
    }

    if (data.type === 'reload') {
      ws.close();

      ws.onclose = function () {
        location.reload();
      };
    }

    if (data.type === 'error-resolved') {
      console.log('[parcel] ✨ Error resolved');
      removeErrorOverlay();
    }

    if (data.type === 'error') {
      console.error('[parcel] 🚨  ' + data.error.message + '\n' + data.error.stack);
      removeErrorOverlay();
      var overlay = createErrorOverlay(data);
      document.body.appendChild(overlay);
    }
  };
}

function removeErrorOverlay() {
  var overlay = document.getElementById(OVERLAY_ID);

  if (overlay) {
    overlay.remove();
  }
}

function createErrorOverlay(data) {
  var overlay = document.createElement('div');
  overlay.id = OVERLAY_ID; // html encode message and stack trace

  var message = document.createElement('div');
  var stackTrace = document.createElement('pre');
  message.innerText = data.error.message;
  stackTrace.innerText = data.error.stack;
  overlay.innerHTML = '<div style="background: black; font-size: 16px; color: white; position: fixed; height: 100%; width: 100%; top: 0px; left: 0px; padding: 30px; opacity: 0.85; font-family: Menlo, Consolas, monospace; z-index: 9999;">' + '<span style="background: red; padding: 2px 4px; border-radius: 2px;">ERROR</span>' + '<span style="top: 2px; margin-left: 5px; position: relative;">🚨</span>' + '<div style="font-size: 18px; font-weight: bold; margin-top: 20px;">' + message.innerHTML + '</div>' + '<pre>' + stackTrace.innerHTML + '</pre>' + '</div>';
  return overlay;
}

function getParents(bundle, id) {
  var modules = bundle.modules;

  if (!modules) {
    return [];
  }

  var parents = [];
  var k, d, dep;

  for (k in modules) {
    for (d in modules[k][1]) {
      dep = modules[k][1][d];

      if (dep === id || Array.isArray(dep) && dep[dep.length - 1] === id) {
        parents.push(k);
      }
    }
  }

  if (bundle.parent) {
    parents = parents.concat(getParents(bundle.parent, id));
  }

  return parents;
}

function hmrApply(bundle, asset) {
  var modules = bundle.modules;

  if (!modules) {
    return;
  }

  if (modules[asset.id] || !bundle.parent) {
    var fn = new Function('require', 'module', 'exports', asset.generated.js);
    asset.isNew = !modules[asset.id];
    modules[asset.id] = [fn, asset.deps];
  } else if (bundle.parent) {
    hmrApply(bundle.parent, asset);
  }
}

function hmrAcceptCheck(bundle, id) {
  var modules = bundle.modules;

  if (!modules) {
    return;
  }

  if (!modules[id] && bundle.parent) {
    return hmrAcceptCheck(bundle.parent, id);
  }

  if (checkedAssets[id]) {
    return;
  }

  checkedAssets[id] = true;
  var cached = bundle.cache[id];
  assetsToAccept.push([bundle, id]);

  if (cached && cached.hot && cached.hot._acceptCallbacks.length) {
    return true;
  }

  return getParents(global.parcelRequire, id).some(function (id) {
    return hmrAcceptCheck(global.parcelRequire, id);
  });
}

function hmrAcceptRun(bundle, id) {
  var cached = bundle.cache[id];
  bundle.hotData = {};

  if (cached) {
    cached.hot.data = bundle.hotData;
  }

  if (cached && cached.hot && cached.hot._disposeCallbacks.length) {
    cached.hot._disposeCallbacks.forEach(function (cb) {
      cb(bundle.hotData);
    });
  }

  delete bundle.cache[id];
  bundle(id);
  cached = bundle.cache[id];

  if (cached && cached.hot && cached.hot._acceptCallbacks.length) {
    cached.hot._acceptCallbacks.forEach(function (cb) {
      cb();
    });

    return true;
  }
}
},{}]},{},["../../../../../Users/thoma/AppData/Roaming/nvm/v10.16.0/node_modules/parcel-bundler/src/builtins/hmr-runtime.js","dataCalculators/arrayMethods.js"], null)
//# sourceMappingURL=/arrayMethods.3da28297.js.map
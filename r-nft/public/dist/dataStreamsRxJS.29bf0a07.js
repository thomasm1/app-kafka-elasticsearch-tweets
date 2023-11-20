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
})({"dataGetters/dataStreamsRxJS.js":[function(require,module,exports) {
// 0. mouseEvents
var doubleClick = Rx.Observable.fromEvent(document, 'dblclick');
doubleClick.subscribe(function (dblclick) {
  return console.log(dblclick);
});
var clicks = Rx.Observable.fromEvent(document, 'click');
clicks.subscribe(function (click) {
  return printMouse('X: ' + JSON.stringify(click.clientX) + ' | ' + 'Y: ' + JSON.stringify(click.clientY));
}); // 1. Syntax

var observable = Rx.Observable.create(function (observer) {
  observer.next('this is ...');
  observer.next('...your data STREAM!\n\n');
});
observable.subscribe(function (val) {
  return print1('1. ' + val);
}); // 2. Promise to Observable

var promesa = new Promise(function (resolve, reject) {
  setTimeout(function () {
    resolve("2. ...PROMISE resolved\n\n");
  }, 1000);
});
var observaPromesa = Rx.Observable.fromPromise(promesa);
observaPromesa.subscribe(function (result) {
  return print1(result);
}); // 3. Timer

var timer = Rx.Observable.timer(0);
timer.subscribe(function (done) {
  return print1('3. TIMER ding!\n\n');
}); // 4. Miscellaneous Observables

var mashUp = Rx.Observable.of('string', ['array'], 12); //, true, { property: 'value' })

mashUp.subscribe(function (val) {
  return print1('4. Misc ' + val + '\n\n');
}); // 5. Cold Observable (value is build inside the observable...)

var coldOne = Rx.Observable.create(function (observer) {
  observer.next(Math.random());
});
coldOne.subscribe(function (a) {
  return print1("5. Cold Subscribe_A: ".concat(a));
});
coldOne.subscribe(function (b) {
  return print1("5. Cold Subscribe_B: ".concat(b, "\n\n"));
}); // 6. Hot Observable (value build outside of observable, so same for subscribers)

var x = Math.random();
var hotOne = Rx.Observable.create(function (observer) {
  observer.next(x);
});
hotOne.subscribe(function (a) {
  return print1("6a. Hot Subscribe_A: ".concat(a));
});
hotOne.subscribe(function (b) {
  return print1("6a. Hot Subscribe_B: ".concat(b, "\n\n"));
}); // OR //

var cold = Rx.Observable.create(function (observer) {
  observer.next(Math.random());
});
var hot = cold.publish();
hot.subscribe(function (a) {
  return print1("6b. Hot Subscribe_A: ".concat(a));
});
hot.subscribe(function (b) {
  return print1("6b. Hot Subscribe_B: ".concat(b, "\n\n"));
});
hot.connect(); // 7. Completion

var timerComplete = Rx.Observable.timer(0);
timer.finally(function () {
  return print2('7. Timer .FINALLY completed!\n\n');
}).subscribe(); // 8. Interval

var interval = Rx.Observable.interval(200) // interval.subscribe(int => print1(new Date().getSeconds())) 
.finally(function (int) {
  return print2('8a. Interval ' + new Date() + '\n\n');
}); // Interval manually unsubscribed 

var unSubscribe = interval.subscribe(function (x) {
  return print2('8b.unsubscribe() ' + x);
});
setTimeout(function () {
  unSubscribe.unsubscribe();
}, 500); // 9.  MAP

var nums = Rx.Observable.of(10, 1000);
nums.map(function (num) {
  return Math.log(num);
}).finally(function () {
  return print1('\n\n');
}).subscribe(function (n) {
  return print1('9 MAP:  ' + n);
});
var jsonString = '{ "type": "Dog", "breed": "pug" }';
var apiCall = Rx.Observable.of(jsonString);
apiCall.map(function (json) {
  return JSON.parse(json);
}).subscribe(function (obj) {
  print1('9b. MAP: ' + obj.type);
  print1('9b: MAP' + obj.breed + '\n\n');
}); // 10. DO

var names = Rx.Observable.of('Thomas', 'milton');
names.do(function (name) {
  return print1(name);
}).map(function (name) {
  return name.toUpperCase();
}).do(function (name) {
  return print1('10. DO: ' + name + '\n\n');
}).subscribe(); // 11.  FILTER

var numFilters = Rx.Observable.of(-2, 3, 33, 34, -3);
numFilters.filter(function (n) {
  return n <= 0;
}).finally(function () {
  return print2('\n\n');
}).subscribe(function (n) {
  return print2('11. FILTER: ' + n);
}); // 12. first()

var numFirst = Rx.Observable.of(-2, 3, 33, 34, -3).first().subscribe(function (n) {
  return print2('12. first: ' + n + '\n\n');
}); // 13. throttle()

var mouseEvents = Rx.Observable.fromEvent(document, 'mousemove'); //mouseEvents
//    .subscribe(e => print2(e.type));
// mouseEvents
//     .throttleTime(1000) // GIVES FIRST VALUE, WAITS 1000
//     .subscribe(e => print2('13. THROTTLE: ' + e.type));

mouseEvents.debounceTime(1000) // WAITS 1000, THEN GIVES LAST VALUE
.subscribe(function (e) {
  return print2('13. DEBOUNCE: ' + e.type + '\n\n');
}); //. 14 scan()  JUST LIKE ARRAY REDUCE

var cliicks = Rx.Observable.fromEvent(document, 'click');
cliicks.map(function (e) {
  return parseInt(Math.random() * 10);
}).do(function (score) {
  return printMouse("14. SCAN -- Click scored = ".concat(score));
}).scan(function (highScore, score) {
  return highScore + score;
}).subscribe(function (highScore) {
  return printMouse("14. SCAN High Score ".concat(highScore) + '\n\n');
}); //. 15. switchMap()2

var clicksSwitch = Rx.Observable.fromEvent(document, 'click');
var stopSwitchMap = Rx.Observable.timer(2000);
clicksSwitch.switchMap(function (click) {
  return Rx.Observable.interval(500);
}).takeUntil(stopSwitchMap).finally(function () {
  return print2('--15.SWITCHMAP finally');
}).subscribe(function (i) {
  return print2('--15 SWITCHMAP ' + i + '\n\n');
}); // 16. takeUntil

var interv = Rx.Observable.interval(500);
var notify = Rx.Observable.timer(2000);
interv.takeUntil(notify).finally(function () {
  return print2('--16. finally');
}).subscribe(function (i) {
  return print2('--16 TAKEUNTIL: ' + i + '\n\n');
}); // 17.takeWhile

var namex = Rx.Observable.of('17. tom', '17. milton', 'maestas', 'another-name');
namex.takeWhile(function (name) {
  return name != 'maestas';
}).finally(function () {
  return print2('17. TAKEWHILE, found name \n\n');
}).subscribe(function (i) {
  return print2(i);
}); // 18. zip

var yin = Rx.Observable.of('peanut butter', 'wine', 'random');
var yang = Rx.Observable.of('jelly', 'cheese', 'orderly');
var combined = Rx.Observable.zip(yin, yang);
combined.subscribe(function (arr) {
  return print2('18. ZiP ' + arr);
}); // 19.forkJoin 

var yina = Rx.Observable.of('peanut butter', 'wine', 'random');
var yanga = Rx.Observable.of('jelly', 'cheese', 'orderly').delay(2000);
var forkJoined = Rx.Observable.forkJoin(yin, yang);
forkJoined.subscribe(function (arr) {
  return print2('19. FORKJOIN ' + arr);
}); // 20. catch 

var observeError = Rx.Observable.create(function (observer) {
  observer.next('good');
  observer.next('greate');
  observer.next('grand'); //  throw '20. CATCH this!'  

  observer.next('wonderful');
});
observeError.catch(function (err) {
  return print2("Error caught: ".concat(err));
}).retry(2).subscribe(function (val) {
  return print2(val);
}); // 21. subject()

var subjectt = new Rx.Subject();
var subjA = subjectt.subscribe(function (val) {
  return print2("21.Subject(A): ".concat(val));
});
var subjB = subjectt.subscribe(function (val) {
  return print2("21.Subject(B): ".concat(val));
});
subjectt.next('hi ');
setTimeout(function () {
  subjectt.next('there...');
}, 1000); // 22. subject()

var observMulticast = Rx.Observable.fromEvent(document, 'click');
var clickss = observMulticast.do(function (_) {
  return print2('Do one time!');
});
var subject = clickss.multicast(function () {
  return new Rx.Subject();
});
var subA = subject.subscribe(function (c) {
  return print2("22.SUBJECT-A: ".concat(c.timeStamp));
});
var subB = subject.subscribe(function (c) {
  return print2("22.SUBJECT-B: ".concat(c.timeStamp));
});
subject.connect(); // 23. async
///

var array1 = [{
  "Date": "2019-07-04",
  "Symbol": "BTCUSD",
  "Open": 11976.42,
  "High": 12064.26,
  "Low": 11820,
  "Close": 11909.55,
  "Volume BTC": 1237.57,
  "Volume USD": 14790355.69
}, {
  "Date": "2019-07-04",
  "Symbol": "ETHUSD",
  "Open": 301.79,
  "High": 304,
  "Low": 300.39,
  "Close": 301.5,
  "Volume ETH": 3825.69,
  "Volume USD": 1154988.12
}];
var array2 = {
  "Date": "2019-07-05",
  "Symbol": "LITECOIN",
  "Open": 101.79,
  "High": 104,
  "Low": 100.39,
  "Close": 101.5,
  "Volume LTC": 825.69,
  "Volume USD": 7777777.77
};

function afterTheDelay() {
  setTimeout(function () {
    var outputPromise = "";
    array1.forEach(function (array1, index) {
      outputPromise += "<li>Date: ".concat(array1.Date, " Symbol:  ").concat(array1.Symbol, " Close: ").concat(array1.Close, "</li>");
    });
    document.getElementById("array1").innerHTML = "<strong>Local Ether + Bitcoin:</strong><br />" + outputPromise;
  }, 2000);
}

function addPromise(price) {
  return new Promise(function (resolve, reject) {
    setTimeout(function () {
      array1.push(price);
      console.log("hey num2"); // const error = true;

      var error = false;

      if (!error) {
        resolve();
      } else {
        reject(console.log("%c Promise Errorrr occured", "color:orange; border:solid 1px orange"));
      }
    }, 2000);
  });
}

var promesa_New = new Promise(function (resolve, reject) {
  setInterval(function () {
    resolve(array1.push({
      "Date": "2019-07-05",
      "Symbol": "NEWCOIN",
      "Open": 101.79,
      "High": 104,
      "Low": 100.39,
      "Close": 101.5,
      "Volume LTC": 825.69,
      "Volume USD": 7777777.77
    }));
    array1.push(array2);
    console.log("inside Promes_NEW");
  }, 3000);
});
var observaPromesa_New = Rx.Observable.fromPromise(promesa_New);
observaPromesa.subscribe(function (result) {
  return print3(result);
}); /// 

function initAsync() {
  return regeneratorRuntime.async(function initAsync$(_context) {
    while (1) {
      switch (_context.prev = _context.next) {
        case 0:
          _context.next = 2;
          return regeneratorRuntime.awrap(addPromise({
            "Date": "2020-01-02",
            "Symbol": "coinASYNCAdded",
            "Open": 13000.00,
            "High": 14000,
            "Low": 12000.00,
            "Close": 1350.00
          }));

        case 2:
          afterTheDelay();

        case 3:
        case "end":
          return _context.stop();
      }
    }
  });
}

initAsync(); /// 
/////////////////////////////////
// left colum

function print1(val) {
  var el = document.createElement('p');
  el.innerText = val;
  document.getElementById("analytics").appendChild(el);
}

function print3(val) {
  var el2 = document.createElement('p');
  el2.innerText = val;
  document.getElementById("analyticsNum2").appendChild(el2);
} // middle column


function print2(val) {
  var el = document.createElement('p');
  el.innerText = val;
  document.getElementById("analytics2").appendChild(el);
} // right column


function printMouse(val) {
  var el = document.createElement('p');
  el.innerText = val;
  document.getElementById("mouse").appendChild(el);
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
},{}]},{},["../../../../../Users/thoma/AppData/Roaming/nvm/v10.16.0/node_modules/parcel-bundler/src/builtins/hmr-runtime.js","dataGetters/dataStreamsRxJS.js"], null)
//# sourceMappingURL=/dataStreamsRxJS.29bf0a07.js.map
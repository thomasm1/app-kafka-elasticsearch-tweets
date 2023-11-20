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
})({"dataStructures/dataSorting.js":[function(require,module,exports) {
// SORTING
console.log("%c SORTING: ", "color:black; background-color:yellow;border:solid 1px black"); // Best asymptotic run-time complexity:
//        O(n):  Heap, Insertion  
// average case best:
//        O(nlogn):   Merge Sort, Quick Sort, Heap Sort. 
// The worst case best:
//        O(nlogn):   Merge Sort and Heap Sort.
// SELECTION -- O(n^2)
// pretty lousy performance, but ... can be good at checking if everything is already sorted. 
// -- also good to use when memory space is limited. 

/* current item moves through the array and decides if the it’s smaller than the current minimum. If it is, the current item gets the new marker as the new current minimum.... right until the end of the array and the marked smallest item will get swapped with the value on the left-hand side. This value becomes partitioned.  and again ... */

function selectionSort(arr) {
  var swap = function swap(arr, idx1, idx2) {
    var _ref;

    return _ref = [arr[idx2], arr[idx1]], arr[idx1] = _ref[0], arr[idx2] = _ref[1], _ref;
  };

  for (var _i = 0; _i < arr.length; _i++) {
    var currentMin = _i;

    for (var _j = _i + 1; _j < arr.length; _j++) {
      if (arr[currentMin] > arr[_j]) {
        currentMin = _j;
      }
    }

    if (_i !== currentMin) swap(arr, _i, currentMin);
  }

  return arr;
} // ALTERNATE SELECTION SORT


function selectionSort2(arr) {
  var arrSize = arr.length;
  var currentMin;

  for (i = 0; i < arrSize; i++) {
    //set minimum to this position
    currentMin = i; //check the rest of the array to see if anything is smaller

    for (j = i + 1; j < arrSize; j++) {
      if (arr[j] < arr[currentMin]) {
        currentMin = j;
      }
    } //if the minimum isn't in the position, swap it


    if (i != currentMin) {
      var temp = yourArray[i];
      yourArray[i] = yourArray[currentMin];
      yourArray[currentMin] = temp;
    }
  }

  return arr;
}

var arraySelectionSort = [0, 2, 34, 22, 2, 1, 9, 76, 4, 10, 19, 17];
console.log('Unsorted: ' + arraySelectionSort);
newSelectionSort = selectionSort(arraySelectionSort);
console.log('Selection Sort: ' + newSelectionSort);
newSelectionSort2 = selectionSort2(arraySelectionSort);
console.log('Selection Sort 2: ' + newSelectionSort2); // INSERTION

function insertionSort(arr) {
  var currentVal;

  for (var i = 1; i < arr.length; i++) {
    currentVal = arr[i];

    for (var j = i - 1; j >= 0 && arr[j] > currentVal; j--) {
      arr[j + 1] = arr[j];
    }

    arr[j + 1] = currentVal;
  }

  return arr;
}

var arrayInsertionSort = [0, 2, 34, 22, 2, 1, 9, 76, 4, 10, 19, 17];
console.log('Unsorted: ' + arrayInsertionSort);
newInsertionSort = insertionSort(arrayInsertionSort);
console.log('Insertion Sort: ' + newInsertionSort); // BUBBLE SORT (UNOPTIMIZED) 
// function bubbleSort(arr) {
//     for (var i = arr.length; i > 0; i--) {
//         for (var j = 0; j < i - 1; j++) {
//             console.log(arr, arr[j], arr[j + 1]);
//             if (arr[j] > arr[j + 1]) {
//                 var temp = arr[j];
//                 arr[j] = arr[j + 1];
//                 arr[j + 1] = temp;
//             }
//         }
//     }
//     return arr;
// } 
// ES2015  

function bubbleSort(arr) {
  var swap = function swap(arr, idx1, idx2) {
    var _ref2 = [arr[idx2], arr[idx1]];
    arr[idx1] = _ref2[0];
    arr[idx2] = _ref2[1];
  };

  for (var _i2 = arr.length; _i2 > 0; _i2--) {
    for (var _j2 = 0; _j2 < _i2 - 1; _j2++) {
      if (arr[_j2] > arr[_j2 + 1]) {
        swap(arr, _j2, _j2 + 1);
      }
    }
  }

  return arr;
}

var arrayUnsorted = [0, 2, 34, 22, 2, 1, 9, 76, 4, 10, 19, 17];
console.log('Unsorted: ' + arrayUnsorted);
newBubbleSort = bubbleSort(arrayUnsorted);
console.log('Bubble Sort: ' + newBubbleSort); // BUBBLE SORT (OPTIMIZED) with noSwaps

function bubbleSortOptimize(arr) {
  var noSwaps;

  for (var i = arr.length; i > 0; i--) {
    noSwaps = true;

    for (var j = 0; j < i - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        var temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
        noSwaps = false;
      }
    }

    if (noSwaps) break;
  }

  return arr;
}

var arrayUnsorted2 = [0, 2, 34, 22, 2, 1, 9, 76, 4, 10, 19, 17];
console.log('Unsorted: ' + arrayUnsorted2);
newBubbleSort = bubbleSortOptimize(arrayUnsorted2);
console.log('Bubble Sort (Optimized): ' + newBubbleSort);
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
},{}]},{},["../../../../../Users/thoma/AppData/Roaming/nvm/v10.16.0/node_modules/parcel-bundler/src/builtins/hmr-runtime.js","dataStructures/dataSorting.js"], null)
//# sourceMappingURL=/dataSorting.1bcc2c53.js.map
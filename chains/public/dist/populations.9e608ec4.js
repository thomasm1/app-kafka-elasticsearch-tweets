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
})({"dataVisuals/populations.js":[function(require,module,exports) {
// configuration
var colorVariable = 'population';
var geoIDVariable = 'id';
var format = d3.format(','); // Set tooltips

var tip = d3.tip().attr('class', 'd3-tip').offset([-10, 0]).html(function (d) {
  return "<strong>Country: </strong><span class='details'>".concat(d.properties.name, "<br></span><strong>Population: </strong><span class='details'>").concat(format(d[colorVariable]), "</span>");
});
tip.direction(function (d) {
  if (d.properties.name === 'Antarctica') return 'n'; // Americas

  if (d.properties.name === 'Greenland') return 's';
  if (d.properties.name === 'Canada') return 'e';
  if (d.properties.name === 'USA') return 'e';
  if (d.properties.name === 'Mexico') return 'e'; // Europe

  if (d.properties.name === 'Iceland') return 's';
  if (d.properties.name === 'Norway') return 's';
  if (d.properties.name === 'Sweden') return 's';
  if (d.properties.name === 'Finland') return 's';
  if (d.properties.name === 'Russia') return 'w'; // Asia

  if (d.properties.name === 'China') return 'w';
  if (d.properties.name === 'Japan') return 's'; // Oceania

  if (d.properties.name === 'Indonesia') return 'w';
  if (d.properties.name === 'Papua New Guinea') return 'w';
  if (d.properties.name === 'Australia') return 'w';
  if (d.properties.name === 'New Zealand') return 'w'; // otherwise if not specified

  return 'n';
});
tip.offset(function (d) {
  // [top, left]
  if (d.properties.name === 'Antarctica') return [0, 0]; // Americas

  if (d.properties.name === 'Greenland') return [10, -10];
  if (d.properties.name === 'Canada') return [24, -28];
  if (d.properties.name === 'USA') return [-5, 8];
  if (d.properties.name === 'Mexico') return [12, 10];
  if (d.properties.name === 'Chile') return [0, -15]; // Europe

  if (d.properties.name === 'Iceland') return [15, 0];
  if (d.properties.name === 'Norway') return [10, -28];
  if (d.properties.name === 'Sweden') return [10, -8];
  if (d.properties.name === 'Finland') return [10, 0];
  if (d.properties.name === 'France') return [-9, 66];
  if (d.properties.name === 'Italy') return [-8, -6];
  if (d.properties.name === 'Russia') return [5, 385]; // Africa

  if (d.properties.name === 'Madagascar') return [-10, 10]; // Asia

  if (d.properties.name === 'China') return [-16, -8];
  if (d.properties.name === 'Mongolia') return [-5, 0];
  if (d.properties.name === 'Pakistan') return [-10, 13];
  if (d.properties.name === 'India') return [-11, -18];
  if (d.properties.name === 'Nepal') return [-8, 1];
  if (d.properties.name === 'Myanmar') return [-12, 0];
  if (d.properties.name === 'Laos') return [-12, -8];
  if (d.properties.name === 'Vietnam') return [-12, -4];
  if (d.properties.name === 'Japan') return [5, 5]; // Oceania

  if (d.properties.name === 'Indonesia') return [0, -5];
  if (d.properties.name === 'Papua New Guinea') return [-5, -10];
  if (d.properties.name === 'Australia') return [-15, 0];
  if (d.properties.name === 'New Zealand') return [-15, 0]; // otherwise if not specified

  return [-10, 0];
});
d3.select('#ckmeans').style('overflow', 'hidden');
var parentWidth = d3.select('#ckmeans').node().getBoundingClientRect().width;
var margin = {
  top: 0,
  right: 0,
  bottom: 0,
  left: 0
};
var width = 960 - margin.left - margin.right;
var height = 500 - margin.top - margin.bottom;
var color = d3.scaleQuantile().range(['rgb(247,251,255)', 'rgb(222,235,247)', 'rgb(198,219,239)', 'rgb(158,202,225)', 'rgb(107,174,214)', 'rgb(66,146,198)', 'rgb(33,113,181)', 'rgb(8,81,156)', 'rgb(8,48,107)', 'rgb(3,19,43)']);
var svg = d3.select('#ckmeans').append('svg').attr('width', width).attr('height', height).append('g').attr('class', 'map');
var projection = d3.geoRobinson().scale(135).rotate([359, 0, 0]).translate([width / 2.7, height / 1.7]);
var path = d3.geoPath().projection(projection);
svg.call(tip);
queue().defer(d3.json, 'world_countries.json').defer(d3.tsv, 'world_population.tsv').await(ready);

function ready(error, geography, data) {
  data.forEach(function (d) {
    d[colorVariable] = Number(d[colorVariable].replace(',', ''));
  });
  var colorVariableValueByID = {};
  data.forEach(function (d) {
    colorVariableValueByID[d[geoIDVariable]] = d[colorVariable];
  });
  geography.features.forEach(function (d) {
    d[colorVariable] = colorVariableValueByID[d.id];
  }); // calculate ckmeans clusters
  // then use the max value of each cluster
  // as a break

  var numberOfClasses = color.range().length - 1;
  var ckmeansClusters = ss.ckmeans(data.map(function (d) {
    return d[colorVariable];
  }), numberOfClasses);
  var ckmeansBreaks = ckmeansClusters.map(function (d) {
    return d3.min(d);
  });
  console.log('numberOfClasses', numberOfClasses);
  console.log('ckmeansClusters', ckmeansClusters);
  console.log('ckmeansBreaks', ckmeansBreaks); // set the domain of the color scale based on our data

  color.domain(ckmeansBreaks); //
  // .domain(jenksNaturalBreaks)
  //
  // .domain(d3.extent(data, d => d[colorVariable]));
  //
  // .domain([
  //   10000,
  //   100000,
  //   500000,
  //   1000000,
  //   5000000,
  //   10000000,
  //   50000000,
  //   100000000,
  //   500000000,
  //   1500000000
  // ]);

  svg.append('g').attr('class', 'countries').selectAll('path').data(geography.features).enter().append('path').attr('d', path).style('fill', function (d) {
    if (typeof colorVariableValueByID[d.id] !== 'undefined') {
      return color(colorVariableValueByID[d.id]);
    }

    return 'white';
  }).style('fill-opacity', 0.8).style('stroke', function (d) {
    if (d[colorVariable] !== 0) {
      return 'white';
    }

    return 'lightgray';
  }).style('stroke-width', 1).style('stroke-opacity', 0.5) // tooltips
  .on('mouseover', function (d) {
    tip.show(d);
    d3.select(this).style('fill-opacity', 1).style('stroke-opacity', 1).style('stroke-width', 2);
  }).on('mouseout', function (d) {
    tip.hide(d);
    d3.select(this).style('fill-opacity', 0.8).style('stroke-opacity', 0.5).style('stroke-width', 1);
  });
  svg.append('path').datum(topojson.mesh(geography.features, function (a, b) {
    return a.id !== b.id;
  })).attr('class', 'names').attr('d', path);
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
},{}]},{},["../../../../../Users/thoma/AppData/Roaming/nvm/v10.16.0/node_modules/parcel-bundler/src/builtins/hmr-runtime.js","dataVisuals/populations.js"], null)
//# sourceMappingURL=/populations.9e608ec4.js.map
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
})({"node_modules/d3-geo/src/adder.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

// Adds floating point numbers with twice the normal precision.
// Reference: J. R. Shewchuk, Adaptive Precision Floating-Point Arithmetic and
// Fast Robust Geometric Predicates, Discrete & Computational Geometry 18(3)
// 305–363 (1997).
// Code adapted from GeographicLib by Charles F. F. Karney,
// http://geographiclib.sourceforge.net/
function _default() {
  return new Adder();
}

function Adder() {
  this.reset();
}

Adder.prototype = {
  constructor: Adder,
  reset: function () {
    this.s = // rounded value
    this.t = 0; // exact error
  },
  add: function (y) {
    add(temp, y, this.t);
    add(this, temp.s, this.s);
    if (this.s) this.t += temp.t;else this.s = temp.t;
  },
  valueOf: function () {
    return this.s;
  }
};
var temp = new Adder();

function add(adder, a, b) {
  var x = adder.s = a + b,
      bv = x - a,
      av = x - bv;
  adder.t = a - av + (b - bv);
}
},{}],"node_modules/d3-geo/src/math.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.acos = acos;
exports.asin = asin;
exports.haversin = haversin;
exports.tan = exports.sqrt = exports.sign = exports.sin = exports.pow = exports.log = exports.floor = exports.exp = exports.ceil = exports.cos = exports.atan2 = exports.atan = exports.abs = exports.radians = exports.degrees = exports.tau = exports.quarterPi = exports.halfPi = exports.pi = exports.epsilon2 = exports.epsilon = void 0;
var epsilon = 1e-6;
exports.epsilon = epsilon;
var epsilon2 = 1e-12;
exports.epsilon2 = epsilon2;
var pi = Math.PI;
exports.pi = pi;
var halfPi = pi / 2;
exports.halfPi = halfPi;
var quarterPi = pi / 4;
exports.quarterPi = quarterPi;
var tau = pi * 2;
exports.tau = tau;
var degrees = 180 / pi;
exports.degrees = degrees;
var radians = pi / 180;
exports.radians = radians;
var abs = Math.abs;
exports.abs = abs;
var atan = Math.atan;
exports.atan = atan;
var atan2 = Math.atan2;
exports.atan2 = atan2;
var cos = Math.cos;
exports.cos = cos;
var ceil = Math.ceil;
exports.ceil = ceil;
var exp = Math.exp;
exports.exp = exp;
var floor = Math.floor;
exports.floor = floor;
var log = Math.log;
exports.log = log;
var pow = Math.pow;
exports.pow = pow;
var sin = Math.sin;
exports.sin = sin;

var sign = Math.sign || function (x) {
  return x > 0 ? 1 : x < 0 ? -1 : 0;
};

exports.sign = sign;
var sqrt = Math.sqrt;
exports.sqrt = sqrt;
var tan = Math.tan;
exports.tan = tan;

function acos(x) {
  return x > 1 ? 0 : x < -1 ? pi : Math.acos(x);
}

function asin(x) {
  return x > 1 ? halfPi : x < -1 ? -halfPi : Math.asin(x);
}

function haversin(x) {
  return (x = sin(x / 2)) * x;
}
},{}],"node_modules/d3-geo/src/noop.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = noop;

function noop() {}
},{}],"node_modules/d3-geo/src/stream.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function streamGeometry(geometry, stream) {
  if (geometry && streamGeometryType.hasOwnProperty(geometry.type)) {
    streamGeometryType[geometry.type](geometry, stream);
  }
}

var streamObjectType = {
  Feature: function (object, stream) {
    streamGeometry(object.geometry, stream);
  },
  FeatureCollection: function (object, stream) {
    var features = object.features,
        i = -1,
        n = features.length;

    while (++i < n) streamGeometry(features[i].geometry, stream);
  }
};
var streamGeometryType = {
  Sphere: function (object, stream) {
    stream.sphere();
  },
  Point: function (object, stream) {
    object = object.coordinates;
    stream.point(object[0], object[1], object[2]);
  },
  MultiPoint: function (object, stream) {
    var coordinates = object.coordinates,
        i = -1,
        n = coordinates.length;

    while (++i < n) object = coordinates[i], stream.point(object[0], object[1], object[2]);
  },
  LineString: function (object, stream) {
    streamLine(object.coordinates, stream, 0);
  },
  MultiLineString: function (object, stream) {
    var coordinates = object.coordinates,
        i = -1,
        n = coordinates.length;

    while (++i < n) streamLine(coordinates[i], stream, 0);
  },
  Polygon: function (object, stream) {
    streamPolygon(object.coordinates, stream);
  },
  MultiPolygon: function (object, stream) {
    var coordinates = object.coordinates,
        i = -1,
        n = coordinates.length;

    while (++i < n) streamPolygon(coordinates[i], stream);
  },
  GeometryCollection: function (object, stream) {
    var geometries = object.geometries,
        i = -1,
        n = geometries.length;

    while (++i < n) streamGeometry(geometries[i], stream);
  }
};

function streamLine(coordinates, stream, closed) {
  var i = -1,
      n = coordinates.length - closed,
      coordinate;
  stream.lineStart();

  while (++i < n) coordinate = coordinates[i], stream.point(coordinate[0], coordinate[1], coordinate[2]);

  stream.lineEnd();
}

function streamPolygon(coordinates, stream) {
  var i = -1,
      n = coordinates.length;
  stream.polygonStart();

  while (++i < n) streamLine(coordinates[i], stream, 1);

  stream.polygonEnd();
}

function _default(object, stream) {
  if (object && streamObjectType.hasOwnProperty(object.type)) {
    streamObjectType[object.type](object, stream);
  } else {
    streamGeometry(object, stream);
  }
}
},{}],"node_modules/d3-geo/src/area.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;
exports.areaStream = exports.areaRingSum = void 0;

var _adder = _interopRequireDefault(require("./adder.js"));

var _math = require("./math.js");

var _noop = _interopRequireDefault(require("./noop.js"));

var _stream = _interopRequireDefault(require("./stream.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var areaRingSum = (0, _adder.default)();
exports.areaRingSum = areaRingSum;
var areaSum = (0, _adder.default)(),
    lambda00,
    phi00,
    lambda0,
    cosPhi0,
    sinPhi0;
var areaStream = {
  point: _noop.default,
  lineStart: _noop.default,
  lineEnd: _noop.default,
  polygonStart: function () {
    areaRingSum.reset();
    areaStream.lineStart = areaRingStart;
    areaStream.lineEnd = areaRingEnd;
  },
  polygonEnd: function () {
    var areaRing = +areaRingSum;
    areaSum.add(areaRing < 0 ? _math.tau + areaRing : areaRing);
    this.lineStart = this.lineEnd = this.point = _noop.default;
  },
  sphere: function () {
    areaSum.add(_math.tau);
  }
};
exports.areaStream = areaStream;

function areaRingStart() {
  areaStream.point = areaPointFirst;
}

function areaRingEnd() {
  areaPoint(lambda00, phi00);
}

function areaPointFirst(lambda, phi) {
  areaStream.point = areaPoint;
  lambda00 = lambda, phi00 = phi;
  lambda *= _math.radians, phi *= _math.radians;
  lambda0 = lambda, cosPhi0 = (0, _math.cos)(phi = phi / 2 + _math.quarterPi), sinPhi0 = (0, _math.sin)(phi);
}

function areaPoint(lambda, phi) {
  lambda *= _math.radians, phi *= _math.radians;
  phi = phi / 2 + _math.quarterPi; // half the angular distance from south pole
  // Spherical excess E for a spherical triangle with vertices: south pole,
  // previous point, current point.  Uses a formula derived from Cagnoli’s
  // theorem.  See Todhunter, Spherical Trig. (1871), Sec. 103, Eq. (2).

  var dLambda = lambda - lambda0,
      sdLambda = dLambda >= 0 ? 1 : -1,
      adLambda = sdLambda * dLambda,
      cosPhi = (0, _math.cos)(phi),
      sinPhi = (0, _math.sin)(phi),
      k = sinPhi0 * sinPhi,
      u = cosPhi0 * cosPhi + k * (0, _math.cos)(adLambda),
      v = k * sdLambda * (0, _math.sin)(adLambda);
  areaRingSum.add((0, _math.atan2)(v, u)); // Advance the previous points.

  lambda0 = lambda, cosPhi0 = cosPhi, sinPhi0 = sinPhi;
}

function _default(object) {
  areaSum.reset();
  (0, _stream.default)(object, areaStream);
  return areaSum * 2;
}
},{"./adder.js":"node_modules/d3-geo/src/adder.js","./math.js":"node_modules/d3-geo/src/math.js","./noop.js":"node_modules/d3-geo/src/noop.js","./stream.js":"node_modules/d3-geo/src/stream.js"}],"node_modules/d3-geo/src/cartesian.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.spherical = spherical;
exports.cartesian = cartesian;
exports.cartesianDot = cartesianDot;
exports.cartesianCross = cartesianCross;
exports.cartesianAddInPlace = cartesianAddInPlace;
exports.cartesianScale = cartesianScale;
exports.cartesianNormalizeInPlace = cartesianNormalizeInPlace;

var _math = require("./math.js");

function spherical(cartesian) {
  return [(0, _math.atan2)(cartesian[1], cartesian[0]), (0, _math.asin)(cartesian[2])];
}

function cartesian(spherical) {
  var lambda = spherical[0],
      phi = spherical[1],
      cosPhi = (0, _math.cos)(phi);
  return [cosPhi * (0, _math.cos)(lambda), cosPhi * (0, _math.sin)(lambda), (0, _math.sin)(phi)];
}

function cartesianDot(a, b) {
  return a[0] * b[0] + a[1] * b[1] + a[2] * b[2];
}

function cartesianCross(a, b) {
  return [a[1] * b[2] - a[2] * b[1], a[2] * b[0] - a[0] * b[2], a[0] * b[1] - a[1] * b[0]];
} // TODO return a


function cartesianAddInPlace(a, b) {
  a[0] += b[0], a[1] += b[1], a[2] += b[2];
}

function cartesianScale(vector, k) {
  return [vector[0] * k, vector[1] * k, vector[2] * k];
} // TODO return d


function cartesianNormalizeInPlace(d) {
  var l = (0, _math.sqrt)(d[0] * d[0] + d[1] * d[1] + d[2] * d[2]);
  d[0] /= l, d[1] /= l, d[2] /= l;
}
},{"./math.js":"node_modules/d3-geo/src/math.js"}],"node_modules/d3-geo/src/bounds.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _adder = _interopRequireDefault(require("./adder.js"));

var _area = require("./area.js");

var _cartesian = require("./cartesian.js");

var _math = require("./math.js");

var _stream = _interopRequireDefault(require("./stream.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var lambda0,
    phi0,
    lambda1,
    phi1,
    // bounds
lambda2,
    // previous lambda-coordinate
lambda00,
    phi00,
    // first point
p0,
    // previous 3D point
deltaSum = (0, _adder.default)(),
    ranges,
    range;
var boundsStream = {
  point: boundsPoint,
  lineStart: boundsLineStart,
  lineEnd: boundsLineEnd,
  polygonStart: function () {
    boundsStream.point = boundsRingPoint;
    boundsStream.lineStart = boundsRingStart;
    boundsStream.lineEnd = boundsRingEnd;
    deltaSum.reset();

    _area.areaStream.polygonStart();
  },
  polygonEnd: function () {
    _area.areaStream.polygonEnd();

    boundsStream.point = boundsPoint;
    boundsStream.lineStart = boundsLineStart;
    boundsStream.lineEnd = boundsLineEnd;
    if (_area.areaRingSum < 0) lambda0 = -(lambda1 = 180), phi0 = -(phi1 = 90);else if (deltaSum > _math.epsilon) phi1 = 90;else if (deltaSum < -_math.epsilon) phi0 = -90;
    range[0] = lambda0, range[1] = lambda1;
  },
  sphere: function () {
    lambda0 = -(lambda1 = 180), phi0 = -(phi1 = 90);
  }
};

function boundsPoint(lambda, phi) {
  ranges.push(range = [lambda0 = lambda, lambda1 = lambda]);
  if (phi < phi0) phi0 = phi;
  if (phi > phi1) phi1 = phi;
}

function linePoint(lambda, phi) {
  var p = (0, _cartesian.cartesian)([lambda * _math.radians, phi * _math.radians]);

  if (p0) {
    var normal = (0, _cartesian.cartesianCross)(p0, p),
        equatorial = [normal[1], -normal[0], 0],
        inflection = (0, _cartesian.cartesianCross)(equatorial, normal);
    (0, _cartesian.cartesianNormalizeInPlace)(inflection);
    inflection = (0, _cartesian.spherical)(inflection);
    var delta = lambda - lambda2,
        sign = delta > 0 ? 1 : -1,
        lambdai = inflection[0] * _math.degrees * sign,
        phii,
        antimeridian = (0, _math.abs)(delta) > 180;

    if (antimeridian ^ (sign * lambda2 < lambdai && lambdai < sign * lambda)) {
      phii = inflection[1] * _math.degrees;
      if (phii > phi1) phi1 = phii;
    } else if (lambdai = (lambdai + 360) % 360 - 180, antimeridian ^ (sign * lambda2 < lambdai && lambdai < sign * lambda)) {
      phii = -inflection[1] * _math.degrees;
      if (phii < phi0) phi0 = phii;
    } else {
      if (phi < phi0) phi0 = phi;
      if (phi > phi1) phi1 = phi;
    }

    if (antimeridian) {
      if (lambda < lambda2) {
        if (angle(lambda0, lambda) > angle(lambda0, lambda1)) lambda1 = lambda;
      } else {
        if (angle(lambda, lambda1) > angle(lambda0, lambda1)) lambda0 = lambda;
      }
    } else {
      if (lambda1 >= lambda0) {
        if (lambda < lambda0) lambda0 = lambda;
        if (lambda > lambda1) lambda1 = lambda;
      } else {
        if (lambda > lambda2) {
          if (angle(lambda0, lambda) > angle(lambda0, lambda1)) lambda1 = lambda;
        } else {
          if (angle(lambda, lambda1) > angle(lambda0, lambda1)) lambda0 = lambda;
        }
      }
    }
  } else {
    ranges.push(range = [lambda0 = lambda, lambda1 = lambda]);
  }

  if (phi < phi0) phi0 = phi;
  if (phi > phi1) phi1 = phi;
  p0 = p, lambda2 = lambda;
}

function boundsLineStart() {
  boundsStream.point = linePoint;
}

function boundsLineEnd() {
  range[0] = lambda0, range[1] = lambda1;
  boundsStream.point = boundsPoint;
  p0 = null;
}

function boundsRingPoint(lambda, phi) {
  if (p0) {
    var delta = lambda - lambda2;
    deltaSum.add((0, _math.abs)(delta) > 180 ? delta + (delta > 0 ? 360 : -360) : delta);
  } else {
    lambda00 = lambda, phi00 = phi;
  }

  _area.areaStream.point(lambda, phi);

  linePoint(lambda, phi);
}

function boundsRingStart() {
  _area.areaStream.lineStart();
}

function boundsRingEnd() {
  boundsRingPoint(lambda00, phi00);

  _area.areaStream.lineEnd();

  if ((0, _math.abs)(deltaSum) > _math.epsilon) lambda0 = -(lambda1 = 180);
  range[0] = lambda0, range[1] = lambda1;
  p0 = null;
} // Finds the left-right distance between two longitudes.
// This is almost the same as (lambda1 - lambda0 + 360°) % 360°, except that we want
// the distance between ±180° to be 360°.


function angle(lambda0, lambda1) {
  return (lambda1 -= lambda0) < 0 ? lambda1 + 360 : lambda1;
}

function rangeCompare(a, b) {
  return a[0] - b[0];
}

function rangeContains(range, x) {
  return range[0] <= range[1] ? range[0] <= x && x <= range[1] : x < range[0] || range[1] < x;
}

function _default(feature) {
  var i, n, a, b, merged, deltaMax, delta;
  phi1 = lambda1 = -(lambda0 = phi0 = Infinity);
  ranges = [];
  (0, _stream.default)(feature, boundsStream); // First, sort ranges by their minimum longitudes.

  if (n = ranges.length) {
    ranges.sort(rangeCompare); // Then, merge any ranges that overlap.

    for (i = 1, a = ranges[0], merged = [a]; i < n; ++i) {
      b = ranges[i];

      if (rangeContains(a, b[0]) || rangeContains(a, b[1])) {
        if (angle(a[0], b[1]) > angle(a[0], a[1])) a[1] = b[1];
        if (angle(b[0], a[1]) > angle(a[0], a[1])) a[0] = b[0];
      } else {
        merged.push(a = b);
      }
    } // Finally, find the largest gap between the merged ranges.
    // The final bounding box will be the inverse of this gap.


    for (deltaMax = -Infinity, n = merged.length - 1, i = 0, a = merged[n]; i <= n; a = b, ++i) {
      b = merged[i];
      if ((delta = angle(a[1], b[0])) > deltaMax) deltaMax = delta, lambda0 = b[0], lambda1 = a[1];
    }
  }

  ranges = range = null;
  return lambda0 === Infinity || phi0 === Infinity ? [[NaN, NaN], [NaN, NaN]] : [[lambda0, phi0], [lambda1, phi1]];
}
},{"./adder.js":"node_modules/d3-geo/src/adder.js","./area.js":"node_modules/d3-geo/src/area.js","./cartesian.js":"node_modules/d3-geo/src/cartesian.js","./math.js":"node_modules/d3-geo/src/math.js","./stream.js":"node_modules/d3-geo/src/stream.js"}],"node_modules/d3-geo/src/centroid.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _math = require("./math.js");

var _noop = _interopRequireDefault(require("./noop.js"));

var _stream = _interopRequireDefault(require("./stream.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var W0, W1, X0, Y0, Z0, X1, Y1, Z1, X2, Y2, Z2, lambda00, phi00, // first point
x0, y0, z0; // previous point

var centroidStream = {
  sphere: _noop.default,
  point: centroidPoint,
  lineStart: centroidLineStart,
  lineEnd: centroidLineEnd,
  polygonStart: function () {
    centroidStream.lineStart = centroidRingStart;
    centroidStream.lineEnd = centroidRingEnd;
  },
  polygonEnd: function () {
    centroidStream.lineStart = centroidLineStart;
    centroidStream.lineEnd = centroidLineEnd;
  }
}; // Arithmetic mean of Cartesian vectors.

function centroidPoint(lambda, phi) {
  lambda *= _math.radians, phi *= _math.radians;
  var cosPhi = (0, _math.cos)(phi);
  centroidPointCartesian(cosPhi * (0, _math.cos)(lambda), cosPhi * (0, _math.sin)(lambda), (0, _math.sin)(phi));
}

function centroidPointCartesian(x, y, z) {
  ++W0;
  X0 += (x - X0) / W0;
  Y0 += (y - Y0) / W0;
  Z0 += (z - Z0) / W0;
}

function centroidLineStart() {
  centroidStream.point = centroidLinePointFirst;
}

function centroidLinePointFirst(lambda, phi) {
  lambda *= _math.radians, phi *= _math.radians;
  var cosPhi = (0, _math.cos)(phi);
  x0 = cosPhi * (0, _math.cos)(lambda);
  y0 = cosPhi * (0, _math.sin)(lambda);
  z0 = (0, _math.sin)(phi);
  centroidStream.point = centroidLinePoint;
  centroidPointCartesian(x0, y0, z0);
}

function centroidLinePoint(lambda, phi) {
  lambda *= _math.radians, phi *= _math.radians;
  var cosPhi = (0, _math.cos)(phi),
      x = cosPhi * (0, _math.cos)(lambda),
      y = cosPhi * (0, _math.sin)(lambda),
      z = (0, _math.sin)(phi),
      w = (0, _math.atan2)((0, _math.sqrt)((w = y0 * z - z0 * y) * w + (w = z0 * x - x0 * z) * w + (w = x0 * y - y0 * x) * w), x0 * x + y0 * y + z0 * z);
  W1 += w;
  X1 += w * (x0 + (x0 = x));
  Y1 += w * (y0 + (y0 = y));
  Z1 += w * (z0 + (z0 = z));
  centroidPointCartesian(x0, y0, z0);
}

function centroidLineEnd() {
  centroidStream.point = centroidPoint;
} // See J. E. Brock, The Inertia Tensor for a Spherical Triangle,
// J. Applied Mechanics 42, 239 (1975).


function centroidRingStart() {
  centroidStream.point = centroidRingPointFirst;
}

function centroidRingEnd() {
  centroidRingPoint(lambda00, phi00);
  centroidStream.point = centroidPoint;
}

function centroidRingPointFirst(lambda, phi) {
  lambda00 = lambda, phi00 = phi;
  lambda *= _math.radians, phi *= _math.radians;
  centroidStream.point = centroidRingPoint;
  var cosPhi = (0, _math.cos)(phi);
  x0 = cosPhi * (0, _math.cos)(lambda);
  y0 = cosPhi * (0, _math.sin)(lambda);
  z0 = (0, _math.sin)(phi);
  centroidPointCartesian(x0, y0, z0);
}

function centroidRingPoint(lambda, phi) {
  lambda *= _math.radians, phi *= _math.radians;
  var cosPhi = (0, _math.cos)(phi),
      x = cosPhi * (0, _math.cos)(lambda),
      y = cosPhi * (0, _math.sin)(lambda),
      z = (0, _math.sin)(phi),
      cx = y0 * z - z0 * y,
      cy = z0 * x - x0 * z,
      cz = x0 * y - y0 * x,
      m = (0, _math.sqrt)(cx * cx + cy * cy + cz * cz),
      w = (0, _math.asin)(m),
      // line weight = angle
  v = m && -w / m; // area weight multiplier

  X2 += v * cx;
  Y2 += v * cy;
  Z2 += v * cz;
  W1 += w;
  X1 += w * (x0 + (x0 = x));
  Y1 += w * (y0 + (y0 = y));
  Z1 += w * (z0 + (z0 = z));
  centroidPointCartesian(x0, y0, z0);
}

function _default(object) {
  W0 = W1 = X0 = Y0 = Z0 = X1 = Y1 = Z1 = X2 = Y2 = Z2 = 0;
  (0, _stream.default)(object, centroidStream);
  var x = X2,
      y = Y2,
      z = Z2,
      m = x * x + y * y + z * z; // If the area-weighted ccentroid is undefined, fall back to length-weighted ccentroid.

  if (m < _math.epsilon2) {
    x = X1, y = Y1, z = Z1; // If the feature has zero length, fall back to arithmetic mean of point vectors.

    if (W1 < _math.epsilon) x = X0, y = Y0, z = Z0;
    m = x * x + y * y + z * z; // If the feature still has an undefined ccentroid, then return.

    if (m < _math.epsilon2) return [NaN, NaN];
  }

  return [(0, _math.atan2)(y, x) * _math.degrees, (0, _math.asin)(z / (0, _math.sqrt)(m)) * _math.degrees];
}
},{"./math.js":"node_modules/d3-geo/src/math.js","./noop.js":"node_modules/d3-geo/src/noop.js","./stream.js":"node_modules/d3-geo/src/stream.js"}],"node_modules/d3-geo/src/constant.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(x) {
  return function () {
    return x;
  };
}
},{}],"node_modules/d3-geo/src/compose.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(a, b) {
  function compose(x, y) {
    return x = a(x, y), b(x[0], x[1]);
  }

  if (a.invert && b.invert) compose.invert = function (x, y) {
    return x = b.invert(x, y), x && a.invert(x[0], x[1]);
  };
  return compose;
}
},{}],"node_modules/d3-geo/src/rotation.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.rotateRadians = rotateRadians;
exports.default = _default;

var _compose = _interopRequireDefault(require("./compose.js"));

var _math = require("./math.js");

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function rotationIdentity(lambda, phi) {
  return [(0, _math.abs)(lambda) > _math.pi ? lambda + Math.round(-lambda / _math.tau) * _math.tau : lambda, phi];
}

rotationIdentity.invert = rotationIdentity;

function rotateRadians(deltaLambda, deltaPhi, deltaGamma) {
  return (deltaLambda %= _math.tau) ? deltaPhi || deltaGamma ? (0, _compose.default)(rotationLambda(deltaLambda), rotationPhiGamma(deltaPhi, deltaGamma)) : rotationLambda(deltaLambda) : deltaPhi || deltaGamma ? rotationPhiGamma(deltaPhi, deltaGamma) : rotationIdentity;
}

function forwardRotationLambda(deltaLambda) {
  return function (lambda, phi) {
    return lambda += deltaLambda, [lambda > _math.pi ? lambda - _math.tau : lambda < -_math.pi ? lambda + _math.tau : lambda, phi];
  };
}

function rotationLambda(deltaLambda) {
  var rotation = forwardRotationLambda(deltaLambda);
  rotation.invert = forwardRotationLambda(-deltaLambda);
  return rotation;
}

function rotationPhiGamma(deltaPhi, deltaGamma) {
  var cosDeltaPhi = (0, _math.cos)(deltaPhi),
      sinDeltaPhi = (0, _math.sin)(deltaPhi),
      cosDeltaGamma = (0, _math.cos)(deltaGamma),
      sinDeltaGamma = (0, _math.sin)(deltaGamma);

  function rotation(lambda, phi) {
    var cosPhi = (0, _math.cos)(phi),
        x = (0, _math.cos)(lambda) * cosPhi,
        y = (0, _math.sin)(lambda) * cosPhi,
        z = (0, _math.sin)(phi),
        k = z * cosDeltaPhi + x * sinDeltaPhi;
    return [(0, _math.atan2)(y * cosDeltaGamma - k * sinDeltaGamma, x * cosDeltaPhi - z * sinDeltaPhi), (0, _math.asin)(k * cosDeltaGamma + y * sinDeltaGamma)];
  }

  rotation.invert = function (lambda, phi) {
    var cosPhi = (0, _math.cos)(phi),
        x = (0, _math.cos)(lambda) * cosPhi,
        y = (0, _math.sin)(lambda) * cosPhi,
        z = (0, _math.sin)(phi),
        k = z * cosDeltaGamma - y * sinDeltaGamma;
    return [(0, _math.atan2)(y * cosDeltaGamma + z * sinDeltaGamma, x * cosDeltaPhi + k * sinDeltaPhi), (0, _math.asin)(k * cosDeltaPhi - x * sinDeltaPhi)];
  };

  return rotation;
}

function _default(rotate) {
  rotate = rotateRadians(rotate[0] * _math.radians, rotate[1] * _math.radians, rotate.length > 2 ? rotate[2] * _math.radians : 0);

  function forward(coordinates) {
    coordinates = rotate(coordinates[0] * _math.radians, coordinates[1] * _math.radians);
    return coordinates[0] *= _math.degrees, coordinates[1] *= _math.degrees, coordinates;
  }

  forward.invert = function (coordinates) {
    coordinates = rotate.invert(coordinates[0] * _math.radians, coordinates[1] * _math.radians);
    return coordinates[0] *= _math.degrees, coordinates[1] *= _math.degrees, coordinates;
  };

  return forward;
}
},{"./compose.js":"node_modules/d3-geo/src/compose.js","./math.js":"node_modules/d3-geo/src/math.js"}],"node_modules/d3-geo/src/circle.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.circleStream = circleStream;
exports.default = _default;

var _cartesian = require("./cartesian.js");

var _constant = _interopRequireDefault(require("./constant.js"));

var _math = require("./math.js");

var _rotation = require("./rotation.js");

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

// Generates a circle centered at [0°, 0°], with a given radius and precision.
function circleStream(stream, radius, delta, direction, t0, t1) {
  if (!delta) return;
  var cosRadius = (0, _math.cos)(radius),
      sinRadius = (0, _math.sin)(radius),
      step = direction * delta;

  if (t0 == null) {
    t0 = radius + direction * _math.tau;
    t1 = radius - step / 2;
  } else {
    t0 = circleRadius(cosRadius, t0);
    t1 = circleRadius(cosRadius, t1);
    if (direction > 0 ? t0 < t1 : t0 > t1) t0 += direction * _math.tau;
  }

  for (var point, t = t0; direction > 0 ? t > t1 : t < t1; t -= step) {
    point = (0, _cartesian.spherical)([cosRadius, -sinRadius * (0, _math.cos)(t), -sinRadius * (0, _math.sin)(t)]);
    stream.point(point[0], point[1]);
  }
} // Returns the signed angle of a cartesian point relative to [cosRadius, 0, 0].


function circleRadius(cosRadius, point) {
  point = (0, _cartesian.cartesian)(point), point[0] -= cosRadius;
  (0, _cartesian.cartesianNormalizeInPlace)(point);
  var radius = (0, _math.acos)(-point[1]);
  return ((-point[2] < 0 ? -radius : radius) + _math.tau - _math.epsilon) % _math.tau;
}

function _default() {
  var center = (0, _constant.default)([0, 0]),
      radius = (0, _constant.default)(90),
      precision = (0, _constant.default)(6),
      ring,
      rotate,
      stream = {
    point: point
  };

  function point(x, y) {
    ring.push(x = rotate(x, y));
    x[0] *= _math.degrees, x[1] *= _math.degrees;
  }

  function circle() {
    var c = center.apply(this, arguments),
        r = radius.apply(this, arguments) * _math.radians,
        p = precision.apply(this, arguments) * _math.radians;

    ring = [];
    rotate = (0, _rotation.rotateRadians)(-c[0] * _math.radians, -c[1] * _math.radians, 0).invert;
    circleStream(stream, r, p, 1);
    c = {
      type: "Polygon",
      coordinates: [ring]
    };
    ring = rotate = null;
    return c;
  }

  circle.center = function (_) {
    return arguments.length ? (center = typeof _ === "function" ? _ : (0, _constant.default)([+_[0], +_[1]]), circle) : center;
  };

  circle.radius = function (_) {
    return arguments.length ? (radius = typeof _ === "function" ? _ : (0, _constant.default)(+_), circle) : radius;
  };

  circle.precision = function (_) {
    return arguments.length ? (precision = typeof _ === "function" ? _ : (0, _constant.default)(+_), circle) : precision;
  };

  return circle;
}
},{"./cartesian.js":"node_modules/d3-geo/src/cartesian.js","./constant.js":"node_modules/d3-geo/src/constant.js","./math.js":"node_modules/d3-geo/src/math.js","./rotation.js":"node_modules/d3-geo/src/rotation.js"}],"node_modules/d3-geo/src/clip/buffer.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _noop = _interopRequireDefault(require("../noop.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default() {
  var lines = [],
      line;
  return {
    point: function (x, y, m) {
      line.push([x, y, m]);
    },
    lineStart: function () {
      lines.push(line = []);
    },
    lineEnd: _noop.default,
    rejoin: function () {
      if (lines.length > 1) lines.push(lines.pop().concat(lines.shift()));
    },
    result: function () {
      var result = lines;
      lines = [];
      line = null;
      return result;
    }
  };
}
},{"../noop.js":"node_modules/d3-geo/src/noop.js"}],"node_modules/d3-geo/src/pointEqual.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _math = require("./math.js");

function _default(a, b) {
  return (0, _math.abs)(a[0] - b[0]) < _math.epsilon && (0, _math.abs)(a[1] - b[1]) < _math.epsilon;
}
},{"./math.js":"node_modules/d3-geo/src/math.js"}],"node_modules/d3-geo/src/clip/rejoin.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _pointEqual = _interopRequireDefault(require("../pointEqual.js"));

var _math = require("../math.js");

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function Intersection(point, points, other, entry) {
  this.x = point;
  this.z = points;
  this.o = other; // another intersection

  this.e = entry; // is an entry?

  this.v = false; // visited

  this.n = this.p = null; // next & previous
} // A generalized polygon clipping algorithm: given a polygon that has been cut
// into its visible line segments, and rejoins the segments by interpolating
// along the clip edge.


function _default(segments, compareIntersection, startInside, interpolate, stream) {
  var subject = [],
      clip = [],
      i,
      n;
  segments.forEach(function (segment) {
    if ((n = segment.length - 1) <= 0) return;
    var n,
        p0 = segment[0],
        p1 = segment[n],
        x;

    if ((0, _pointEqual.default)(p0, p1)) {
      if (!p0[2] && !p1[2]) {
        stream.lineStart();

        for (i = 0; i < n; ++i) stream.point((p0 = segment[i])[0], p0[1]);

        stream.lineEnd();
        return;
      } // handle degenerate cases by moving the point


      p1[0] += 2 * _math.epsilon;
    }

    subject.push(x = new Intersection(p0, segment, null, true));
    clip.push(x.o = new Intersection(p0, null, x, false));
    subject.push(x = new Intersection(p1, segment, null, false));
    clip.push(x.o = new Intersection(p1, null, x, true));
  });
  if (!subject.length) return;
  clip.sort(compareIntersection);
  link(subject);
  link(clip);

  for (i = 0, n = clip.length; i < n; ++i) {
    clip[i].e = startInside = !startInside;
  }

  var start = subject[0],
      points,
      point;

  while (1) {
    // Find first unvisited intersection.
    var current = start,
        isSubject = true;

    while (current.v) if ((current = current.n) === start) return;

    points = current.z;
    stream.lineStart();

    do {
      current.v = current.o.v = true;

      if (current.e) {
        if (isSubject) {
          for (i = 0, n = points.length; i < n; ++i) stream.point((point = points[i])[0], point[1]);
        } else {
          interpolate(current.x, current.n.x, 1, stream);
        }

        current = current.n;
      } else {
        if (isSubject) {
          points = current.p.z;

          for (i = points.length - 1; i >= 0; --i) stream.point((point = points[i])[0], point[1]);
        } else {
          interpolate(current.x, current.p.x, -1, stream);
        }

        current = current.p;
      }

      current = current.o;
      points = current.z;
      isSubject = !isSubject;
    } while (!current.v);

    stream.lineEnd();
  }
}

function link(array) {
  if (!(n = array.length)) return;
  var n,
      i = 0,
      a = array[0],
      b;

  while (++i < n) {
    a.n = b = array[i];
    b.p = a;
    a = b;
  }

  a.n = b = array[0];
  b.p = a;
}
},{"../pointEqual.js":"node_modules/d3-geo/src/pointEqual.js","../math.js":"node_modules/d3-geo/src/math.js"}],"node_modules/d3-geo/src/polygonContains.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _adder = _interopRequireDefault(require("./adder.js"));

var _cartesian = require("./cartesian.js");

var _math = require("./math.js");

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var sum = (0, _adder.default)();

function longitude(point) {
  if ((0, _math.abs)(point[0]) <= _math.pi) return point[0];else return (0, _math.sign)(point[0]) * (((0, _math.abs)(point[0]) + _math.pi) % _math.tau - _math.pi);
}

function _default(polygon, point) {
  var lambda = longitude(point),
      phi = point[1],
      sinPhi = (0, _math.sin)(phi),
      normal = [(0, _math.sin)(lambda), -(0, _math.cos)(lambda), 0],
      angle = 0,
      winding = 0;
  sum.reset();
  if (sinPhi === 1) phi = _math.halfPi + _math.epsilon;else if (sinPhi === -1) phi = -_math.halfPi - _math.epsilon;

  for (var i = 0, n = polygon.length; i < n; ++i) {
    if (!(m = (ring = polygon[i]).length)) continue;
    var ring,
        m,
        point0 = ring[m - 1],
        lambda0 = longitude(point0),
        phi0 = point0[1] / 2 + _math.quarterPi,
        sinPhi0 = (0, _math.sin)(phi0),
        cosPhi0 = (0, _math.cos)(phi0);

    for (var j = 0; j < m; ++j, lambda0 = lambda1, sinPhi0 = sinPhi1, cosPhi0 = cosPhi1, point0 = point1) {
      var point1 = ring[j],
          lambda1 = longitude(point1),
          phi1 = point1[1] / 2 + _math.quarterPi,
          sinPhi1 = (0, _math.sin)(phi1),
          cosPhi1 = (0, _math.cos)(phi1),
          delta = lambda1 - lambda0,
          sign = delta >= 0 ? 1 : -1,
          absDelta = sign * delta,
          antimeridian = absDelta > _math.pi,
          k = sinPhi0 * sinPhi1;
      sum.add((0, _math.atan2)(k * sign * (0, _math.sin)(absDelta), cosPhi0 * cosPhi1 + k * (0, _math.cos)(absDelta)));
      angle += antimeridian ? delta + sign * _math.tau : delta; // Are the longitudes either side of the point’s meridian (lambda),
      // and are the latitudes smaller than the parallel (phi)?

      if (antimeridian ^ lambda0 >= lambda ^ lambda1 >= lambda) {
        var arc = (0, _cartesian.cartesianCross)((0, _cartesian.cartesian)(point0), (0, _cartesian.cartesian)(point1));
        (0, _cartesian.cartesianNormalizeInPlace)(arc);
        var intersection = (0, _cartesian.cartesianCross)(normal, arc);
        (0, _cartesian.cartesianNormalizeInPlace)(intersection);
        var phiArc = (antimeridian ^ delta >= 0 ? -1 : 1) * (0, _math.asin)(intersection[2]);

        if (phi > phiArc || phi === phiArc && (arc[0] || arc[1])) {
          winding += antimeridian ^ delta >= 0 ? 1 : -1;
        }
      }
    }
  } // First, determine whether the South pole is inside or outside:
  //
  // It is inside if:
  // * the polygon winds around it in a clockwise direction.
  // * the polygon does not (cumulatively) wind around it, but has a negative
  //   (counter-clockwise) area.
  //
  // Second, count the (signed) number of times a segment crosses a lambda
  // from the point to the South pole.  If it is zero, then the point is the
  // same side as the South pole.


  return (angle < -_math.epsilon || angle < _math.epsilon && sum < -_math.epsilon) ^ winding & 1;
}
},{"./adder.js":"node_modules/d3-geo/src/adder.js","./cartesian.js":"node_modules/d3-geo/src/cartesian.js","./math.js":"node_modules/d3-geo/src/math.js"}],"node_modules/d3-geo/node_modules/d3-array/src/ascending.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(a, b) {
  return a < b ? -1 : a > b ? 1 : a >= b ? 0 : NaN;
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/bisector.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _ascending = _interopRequireDefault(require("./ascending"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(compare) {
  if (compare.length === 1) compare = ascendingComparator(compare);
  return {
    left: function (a, x, lo, hi) {
      if (lo == null) lo = 0;
      if (hi == null) hi = a.length;

      while (lo < hi) {
        var mid = lo + hi >>> 1;
        if (compare(a[mid], x) < 0) lo = mid + 1;else hi = mid;
      }

      return lo;
    },
    right: function (a, x, lo, hi) {
      if (lo == null) lo = 0;
      if (hi == null) hi = a.length;

      while (lo < hi) {
        var mid = lo + hi >>> 1;
        if (compare(a[mid], x) > 0) hi = mid;else lo = mid + 1;
      }

      return lo;
    }
  };
}

function ascendingComparator(f) {
  return function (d, x) {
    return (0, _ascending.default)(f(d), x);
  };
}
},{"./ascending":"node_modules/d3-geo/node_modules/d3-array/src/ascending.js"}],"node_modules/d3-geo/node_modules/d3-array/src/bisect.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = exports.bisectLeft = exports.bisectRight = void 0;

var _ascending = _interopRequireDefault(require("./ascending"));

var _bisector = _interopRequireDefault(require("./bisector"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var ascendingBisect = (0, _bisector.default)(_ascending.default);
var bisectRight = ascendingBisect.right;
exports.bisectRight = bisectRight;
var bisectLeft = ascendingBisect.left;
exports.bisectLeft = bisectLeft;
var _default = bisectRight;
exports.default = _default;
},{"./ascending":"node_modules/d3-geo/node_modules/d3-array/src/ascending.js","./bisector":"node_modules/d3-geo/node_modules/d3-array/src/bisector.js"}],"node_modules/d3-geo/node_modules/d3-array/src/pairs.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;
exports.pair = pair;

function _default(array, f) {
  if (f == null) f = pair;
  var i = 0,
      n = array.length - 1,
      p = array[0],
      pairs = new Array(n < 0 ? 0 : n);

  while (i < n) pairs[i] = f(p, p = array[++i]);

  return pairs;
}

function pair(a, b) {
  return [a, b];
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/cross.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _pairs = require("./pairs");

function _default(values0, values1, reduce) {
  var n0 = values0.length,
      n1 = values1.length,
      values = new Array(n0 * n1),
      i0,
      i1,
      i,
      value0;
  if (reduce == null) reduce = _pairs.pair;

  for (i0 = i = 0; i0 < n0; ++i0) {
    for (value0 = values0[i0], i1 = 0; i1 < n1; ++i1, ++i) {
      values[i] = reduce(value0, values1[i1]);
    }
  }

  return values;
}
},{"./pairs":"node_modules/d3-geo/node_modules/d3-array/src/pairs.js"}],"node_modules/d3-geo/node_modules/d3-array/src/descending.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(a, b) {
  return b < a ? -1 : b > a ? 1 : b >= a ? 0 : NaN;
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/number.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(x) {
  return x === null ? NaN : +x;
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/variance.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _number = _interopRequireDefault(require("./number"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(values, valueof) {
  var n = values.length,
      m = 0,
      i = -1,
      mean = 0,
      value,
      delta,
      sum = 0;

  if (valueof == null) {
    while (++i < n) {
      if (!isNaN(value = (0, _number.default)(values[i]))) {
        delta = value - mean;
        mean += delta / ++m;
        sum += delta * (value - mean);
      }
    }
  } else {
    while (++i < n) {
      if (!isNaN(value = (0, _number.default)(valueof(values[i], i, values)))) {
        delta = value - mean;
        mean += delta / ++m;
        sum += delta * (value - mean);
      }
    }
  }

  if (m > 1) return sum / (m - 1);
}
},{"./number":"node_modules/d3-geo/node_modules/d3-array/src/number.js"}],"node_modules/d3-geo/node_modules/d3-array/src/deviation.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _variance = _interopRequireDefault(require("./variance"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(array, f) {
  var v = (0, _variance.default)(array, f);
  return v ? Math.sqrt(v) : v;
}
},{"./variance":"node_modules/d3-geo/node_modules/d3-array/src/variance.js"}],"node_modules/d3-geo/node_modules/d3-array/src/extent.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(values, valueof) {
  var n = values.length,
      i = -1,
      value,
      min,
      max;

  if (valueof == null) {
    while (++i < n) {
      // Find the first comparable value.
      if ((value = values[i]) != null && value >= value) {
        min = max = value;

        while (++i < n) {
          // Compare the remaining values.
          if ((value = values[i]) != null) {
            if (min > value) min = value;
            if (max < value) max = value;
          }
        }
      }
    }
  } else {
    while (++i < n) {
      // Find the first comparable value.
      if ((value = valueof(values[i], i, values)) != null && value >= value) {
        min = max = value;

        while (++i < n) {
          // Compare the remaining values.
          if ((value = valueof(values[i], i, values)) != null) {
            if (min > value) min = value;
            if (max < value) max = value;
          }
        }
      }
    }
  }

  return [min, max];
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/array.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.map = exports.slice = void 0;
var array = Array.prototype;
var slice = array.slice;
exports.slice = slice;
var map = array.map;
exports.map = map;
},{}],"node_modules/d3-geo/node_modules/d3-array/src/constant.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(x) {
  return function () {
    return x;
  };
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/identity.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(x) {
  return x;
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/range.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(start, stop, step) {
  start = +start, stop = +stop, step = (n = arguments.length) < 2 ? (stop = start, start = 0, 1) : n < 3 ? 1 : +step;
  var i = -1,
      n = Math.max(0, Math.ceil((stop - start) / step)) | 0,
      range = new Array(n);

  while (++i < n) {
    range[i] = start + i * step;
  }

  return range;
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/ticks.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;
exports.tickIncrement = tickIncrement;
exports.tickStep = tickStep;
var e10 = Math.sqrt(50),
    e5 = Math.sqrt(10),
    e2 = Math.sqrt(2);

function _default(start, stop, count) {
  var reverse,
      i = -1,
      n,
      ticks,
      step;
  stop = +stop, start = +start, count = +count;
  if (start === stop && count > 0) return [start];
  if (reverse = stop < start) n = start, start = stop, stop = n;
  if ((step = tickIncrement(start, stop, count)) === 0 || !isFinite(step)) return [];

  if (step > 0) {
    start = Math.ceil(start / step);
    stop = Math.floor(stop / step);
    ticks = new Array(n = Math.ceil(stop - start + 1));

    while (++i < n) ticks[i] = (start + i) * step;
  } else {
    start = Math.floor(start * step);
    stop = Math.ceil(stop * step);
    ticks = new Array(n = Math.ceil(start - stop + 1));

    while (++i < n) ticks[i] = (start - i) / step;
  }

  if (reverse) ticks.reverse();
  return ticks;
}

function tickIncrement(start, stop, count) {
  var step = (stop - start) / Math.max(0, count),
      power = Math.floor(Math.log(step) / Math.LN10),
      error = step / Math.pow(10, power);
  return power >= 0 ? (error >= e10 ? 10 : error >= e5 ? 5 : error >= e2 ? 2 : 1) * Math.pow(10, power) : -Math.pow(10, -power) / (error >= e10 ? 10 : error >= e5 ? 5 : error >= e2 ? 2 : 1);
}

function tickStep(start, stop, count) {
  var step0 = Math.abs(stop - start) / Math.max(0, count),
      step1 = Math.pow(10, Math.floor(Math.log(step0) / Math.LN10)),
      error = step0 / step1;
  if (error >= e10) step1 *= 10;else if (error >= e5) step1 *= 5;else if (error >= e2) step1 *= 2;
  return stop < start ? -step1 : step1;
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/threshold/sturges.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(values) {
  return Math.ceil(Math.log(values.length) / Math.LN2) + 1;
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/histogram.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _array = require("./array");

var _bisect = _interopRequireDefault(require("./bisect"));

var _constant = _interopRequireDefault(require("./constant"));

var _extent = _interopRequireDefault(require("./extent"));

var _identity = _interopRequireDefault(require("./identity"));

var _range = _interopRequireDefault(require("./range"));

var _ticks = require("./ticks");

var _sturges = _interopRequireDefault(require("./threshold/sturges"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default() {
  var value = _identity.default,
      domain = _extent.default,
      threshold = _sturges.default;

  function histogram(data) {
    var i,
        n = data.length,
        x,
        values = new Array(n);

    for (i = 0; i < n; ++i) {
      values[i] = value(data[i], i, data);
    }

    var xz = domain(values),
        x0 = xz[0],
        x1 = xz[1],
        tz = threshold(values, x0, x1); // Convert number of thresholds into uniform thresholds.

    if (!Array.isArray(tz)) {
      tz = (0, _ticks.tickStep)(x0, x1, tz);
      tz = (0, _range.default)(Math.ceil(x0 / tz) * tz, x1, tz); // exclusive
    } // Remove any thresholds outside the domain.


    var m = tz.length;

    while (tz[0] <= x0) tz.shift(), --m;

    while (tz[m - 1] > x1) tz.pop(), --m;

    var bins = new Array(m + 1),
        bin; // Initialize bins.

    for (i = 0; i <= m; ++i) {
      bin = bins[i] = [];
      bin.x0 = i > 0 ? tz[i - 1] : x0;
      bin.x1 = i < m ? tz[i] : x1;
    } // Assign data to bins by value, ignoring any outside the domain.


    for (i = 0; i < n; ++i) {
      x = values[i];

      if (x0 <= x && x <= x1) {
        bins[(0, _bisect.default)(tz, x, 0, m)].push(data[i]);
      }
    }

    return bins;
  }

  histogram.value = function (_) {
    return arguments.length ? (value = typeof _ === "function" ? _ : (0, _constant.default)(_), histogram) : value;
  };

  histogram.domain = function (_) {
    return arguments.length ? (domain = typeof _ === "function" ? _ : (0, _constant.default)([_[0], _[1]]), histogram) : domain;
  };

  histogram.thresholds = function (_) {
    return arguments.length ? (threshold = typeof _ === "function" ? _ : Array.isArray(_) ? (0, _constant.default)(_array.slice.call(_)) : (0, _constant.default)(_), histogram) : threshold;
  };

  return histogram;
}
},{"./array":"node_modules/d3-geo/node_modules/d3-array/src/array.js","./bisect":"node_modules/d3-geo/node_modules/d3-array/src/bisect.js","./constant":"node_modules/d3-geo/node_modules/d3-array/src/constant.js","./extent":"node_modules/d3-geo/node_modules/d3-array/src/extent.js","./identity":"node_modules/d3-geo/node_modules/d3-array/src/identity.js","./range":"node_modules/d3-geo/node_modules/d3-array/src/range.js","./ticks":"node_modules/d3-geo/node_modules/d3-array/src/ticks.js","./threshold/sturges":"node_modules/d3-geo/node_modules/d3-array/src/threshold/sturges.js"}],"node_modules/d3-geo/node_modules/d3-array/src/quantile.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _number = _interopRequireDefault(require("./number"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(values, p, valueof) {
  if (valueof == null) valueof = _number.default;
  if (!(n = values.length)) return;
  if ((p = +p) <= 0 || n < 2) return +valueof(values[0], 0, values);
  if (p >= 1) return +valueof(values[n - 1], n - 1, values);
  var n,
      i = (n - 1) * p,
      i0 = Math.floor(i),
      value0 = +valueof(values[i0], i0, values),
      value1 = +valueof(values[i0 + 1], i0 + 1, values);
  return value0 + (value1 - value0) * (i - i0);
}
},{"./number":"node_modules/d3-geo/node_modules/d3-array/src/number.js"}],"node_modules/d3-geo/node_modules/d3-array/src/threshold/freedmanDiaconis.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _array = require("../array");

var _ascending = _interopRequireDefault(require("../ascending"));

var _number = _interopRequireDefault(require("../number"));

var _quantile = _interopRequireDefault(require("../quantile"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(values, min, max) {
  values = _array.map.call(values, _number.default).sort(_ascending.default);
  return Math.ceil((max - min) / (2 * ((0, _quantile.default)(values, 0.75) - (0, _quantile.default)(values, 0.25)) * Math.pow(values.length, -1 / 3)));
}
},{"../array":"node_modules/d3-geo/node_modules/d3-array/src/array.js","../ascending":"node_modules/d3-geo/node_modules/d3-array/src/ascending.js","../number":"node_modules/d3-geo/node_modules/d3-array/src/number.js","../quantile":"node_modules/d3-geo/node_modules/d3-array/src/quantile.js"}],"node_modules/d3-geo/node_modules/d3-array/src/threshold/scott.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _deviation = _interopRequireDefault(require("../deviation"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(values, min, max) {
  return Math.ceil((max - min) / (3.5 * (0, _deviation.default)(values) * Math.pow(values.length, -1 / 3)));
}
},{"../deviation":"node_modules/d3-geo/node_modules/d3-array/src/deviation.js"}],"node_modules/d3-geo/node_modules/d3-array/src/max.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(values, valueof) {
  var n = values.length,
      i = -1,
      value,
      max;

  if (valueof == null) {
    while (++i < n) {
      // Find the first comparable value.
      if ((value = values[i]) != null && value >= value) {
        max = value;

        while (++i < n) {
          // Compare the remaining values.
          if ((value = values[i]) != null && value > max) {
            max = value;
          }
        }
      }
    }
  } else {
    while (++i < n) {
      // Find the first comparable value.
      if ((value = valueof(values[i], i, values)) != null && value >= value) {
        max = value;

        while (++i < n) {
          // Compare the remaining values.
          if ((value = valueof(values[i], i, values)) != null && value > max) {
            max = value;
          }
        }
      }
    }
  }

  return max;
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/mean.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _number = _interopRequireDefault(require("./number"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(values, valueof) {
  var n = values.length,
      m = n,
      i = -1,
      value,
      sum = 0;

  if (valueof == null) {
    while (++i < n) {
      if (!isNaN(value = (0, _number.default)(values[i]))) sum += value;else --m;
    }
  } else {
    while (++i < n) {
      if (!isNaN(value = (0, _number.default)(valueof(values[i], i, values)))) sum += value;else --m;
    }
  }

  if (m) return sum / m;
}
},{"./number":"node_modules/d3-geo/node_modules/d3-array/src/number.js"}],"node_modules/d3-geo/node_modules/d3-array/src/median.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _ascending = _interopRequireDefault(require("./ascending"));

var _number = _interopRequireDefault(require("./number"));

var _quantile = _interopRequireDefault(require("./quantile"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(values, valueof) {
  var n = values.length,
      i = -1,
      value,
      numbers = [];

  if (valueof == null) {
    while (++i < n) {
      if (!isNaN(value = (0, _number.default)(values[i]))) {
        numbers.push(value);
      }
    }
  } else {
    while (++i < n) {
      if (!isNaN(value = (0, _number.default)(valueof(values[i], i, values)))) {
        numbers.push(value);
      }
    }
  }

  return (0, _quantile.default)(numbers.sort(_ascending.default), 0.5);
}
},{"./ascending":"node_modules/d3-geo/node_modules/d3-array/src/ascending.js","./number":"node_modules/d3-geo/node_modules/d3-array/src/number.js","./quantile":"node_modules/d3-geo/node_modules/d3-array/src/quantile.js"}],"node_modules/d3-geo/node_modules/d3-array/src/merge.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(arrays) {
  var n = arrays.length,
      m,
      i = -1,
      j = 0,
      merged,
      array;

  while (++i < n) j += arrays[i].length;

  merged = new Array(j);

  while (--n >= 0) {
    array = arrays[n];
    m = array.length;

    while (--m >= 0) {
      merged[--j] = array[m];
    }
  }

  return merged;
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/min.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(values, valueof) {
  var n = values.length,
      i = -1,
      value,
      min;

  if (valueof == null) {
    while (++i < n) {
      // Find the first comparable value.
      if ((value = values[i]) != null && value >= value) {
        min = value;

        while (++i < n) {
          // Compare the remaining values.
          if ((value = values[i]) != null && min > value) {
            min = value;
          }
        }
      }
    }
  } else {
    while (++i < n) {
      // Find the first comparable value.
      if ((value = valueof(values[i], i, values)) != null && value >= value) {
        min = value;

        while (++i < n) {
          // Compare the remaining values.
          if ((value = valueof(values[i], i, values)) != null && min > value) {
            min = value;
          }
        }
      }
    }
  }

  return min;
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/permute.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(array, indexes) {
  var i = indexes.length,
      permutes = new Array(i);

  while (i--) permutes[i] = array[indexes[i]];

  return permutes;
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/scan.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _ascending = _interopRequireDefault(require("./ascending"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(values, compare) {
  if (!(n = values.length)) return;
  var n,
      i = 0,
      j = 0,
      xi,
      xj = values[j];
  if (compare == null) compare = _ascending.default;

  while (++i < n) {
    if (compare(xi = values[i], xj) < 0 || compare(xj, xj) !== 0) {
      xj = xi, j = i;
    }
  }

  if (compare(xj, xj) === 0) return j;
}
},{"./ascending":"node_modules/d3-geo/node_modules/d3-array/src/ascending.js"}],"node_modules/d3-geo/node_modules/d3-array/src/shuffle.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(array, i0, i1) {
  var m = (i1 == null ? array.length : i1) - (i0 = i0 == null ? 0 : +i0),
      t,
      i;

  while (m) {
    i = Math.random() * m-- | 0;
    t = array[m + i0];
    array[m + i0] = array[i + i0];
    array[i + i0] = t;
  }

  return array;
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/sum.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(values, valueof) {
  var n = values.length,
      i = -1,
      value,
      sum = 0;

  if (valueof == null) {
    while (++i < n) {
      if (value = +values[i]) sum += value; // Note: zero and null are equivalent.
    }
  } else {
    while (++i < n) {
      if (value = +valueof(values[i], i, values)) sum += value;
    }
  }

  return sum;
}
},{}],"node_modules/d3-geo/node_modules/d3-array/src/transpose.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _min = _interopRequireDefault(require("./min"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(matrix) {
  if (!(n = matrix.length)) return [];

  for (var i = -1, m = (0, _min.default)(matrix, length), transpose = new Array(m); ++i < m;) {
    for (var j = -1, n, row = transpose[i] = new Array(n); ++j < n;) {
      row[j] = matrix[j][i];
    }
  }

  return transpose;
}

function length(d) {
  return d.length;
}
},{"./min":"node_modules/d3-geo/node_modules/d3-array/src/min.js"}],"node_modules/d3-geo/node_modules/d3-array/src/zip.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _transpose = _interopRequireDefault(require("./transpose"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default() {
  return (0, _transpose.default)(arguments);
}
},{"./transpose":"node_modules/d3-geo/node_modules/d3-array/src/transpose.js"}],"node_modules/d3-geo/node_modules/d3-array/src/index.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
Object.defineProperty(exports, "bisect", {
  enumerable: true,
  get: function () {
    return _bisect.default;
  }
});
Object.defineProperty(exports, "bisectRight", {
  enumerable: true,
  get: function () {
    return _bisect.bisectRight;
  }
});
Object.defineProperty(exports, "bisectLeft", {
  enumerable: true,
  get: function () {
    return _bisect.bisectLeft;
  }
});
Object.defineProperty(exports, "ascending", {
  enumerable: true,
  get: function () {
    return _ascending.default;
  }
});
Object.defineProperty(exports, "bisector", {
  enumerable: true,
  get: function () {
    return _bisector.default;
  }
});
Object.defineProperty(exports, "cross", {
  enumerable: true,
  get: function () {
    return _cross.default;
  }
});
Object.defineProperty(exports, "descending", {
  enumerable: true,
  get: function () {
    return _descending.default;
  }
});
Object.defineProperty(exports, "deviation", {
  enumerable: true,
  get: function () {
    return _deviation.default;
  }
});
Object.defineProperty(exports, "extent", {
  enumerable: true,
  get: function () {
    return _extent.default;
  }
});
Object.defineProperty(exports, "histogram", {
  enumerable: true,
  get: function () {
    return _histogram.default;
  }
});
Object.defineProperty(exports, "thresholdFreedmanDiaconis", {
  enumerable: true,
  get: function () {
    return _freedmanDiaconis.default;
  }
});
Object.defineProperty(exports, "thresholdScott", {
  enumerable: true,
  get: function () {
    return _scott.default;
  }
});
Object.defineProperty(exports, "thresholdSturges", {
  enumerable: true,
  get: function () {
    return _sturges.default;
  }
});
Object.defineProperty(exports, "max", {
  enumerable: true,
  get: function () {
    return _max.default;
  }
});
Object.defineProperty(exports, "mean", {
  enumerable: true,
  get: function () {
    return _mean.default;
  }
});
Object.defineProperty(exports, "median", {
  enumerable: true,
  get: function () {
    return _median.default;
  }
});
Object.defineProperty(exports, "merge", {
  enumerable: true,
  get: function () {
    return _merge.default;
  }
});
Object.defineProperty(exports, "min", {
  enumerable: true,
  get: function () {
    return _min.default;
  }
});
Object.defineProperty(exports, "pairs", {
  enumerable: true,
  get: function () {
    return _pairs.default;
  }
});
Object.defineProperty(exports, "permute", {
  enumerable: true,
  get: function () {
    return _permute.default;
  }
});
Object.defineProperty(exports, "quantile", {
  enumerable: true,
  get: function () {
    return _quantile.default;
  }
});
Object.defineProperty(exports, "range", {
  enumerable: true,
  get: function () {
    return _range.default;
  }
});
Object.defineProperty(exports, "scan", {
  enumerable: true,
  get: function () {
    return _scan.default;
  }
});
Object.defineProperty(exports, "shuffle", {
  enumerable: true,
  get: function () {
    return _shuffle.default;
  }
});
Object.defineProperty(exports, "sum", {
  enumerable: true,
  get: function () {
    return _sum.default;
  }
});
Object.defineProperty(exports, "ticks", {
  enumerable: true,
  get: function () {
    return _ticks.default;
  }
});
Object.defineProperty(exports, "tickIncrement", {
  enumerable: true,
  get: function () {
    return _ticks.tickIncrement;
  }
});
Object.defineProperty(exports, "tickStep", {
  enumerable: true,
  get: function () {
    return _ticks.tickStep;
  }
});
Object.defineProperty(exports, "transpose", {
  enumerable: true,
  get: function () {
    return _transpose.default;
  }
});
Object.defineProperty(exports, "variance", {
  enumerable: true,
  get: function () {
    return _variance.default;
  }
});
Object.defineProperty(exports, "zip", {
  enumerable: true,
  get: function () {
    return _zip.default;
  }
});

var _bisect = _interopRequireWildcard(require("./bisect"));

var _ascending = _interopRequireDefault(require("./ascending"));

var _bisector = _interopRequireDefault(require("./bisector"));

var _cross = _interopRequireDefault(require("./cross"));

var _descending = _interopRequireDefault(require("./descending"));

var _deviation = _interopRequireDefault(require("./deviation"));

var _extent = _interopRequireDefault(require("./extent"));

var _histogram = _interopRequireDefault(require("./histogram"));

var _freedmanDiaconis = _interopRequireDefault(require("./threshold/freedmanDiaconis"));

var _scott = _interopRequireDefault(require("./threshold/scott"));

var _sturges = _interopRequireDefault(require("./threshold/sturges"));

var _max = _interopRequireDefault(require("./max"));

var _mean = _interopRequireDefault(require("./mean"));

var _median = _interopRequireDefault(require("./median"));

var _merge = _interopRequireDefault(require("./merge"));

var _min = _interopRequireDefault(require("./min"));

var _pairs = _interopRequireDefault(require("./pairs"));

var _permute = _interopRequireDefault(require("./permute"));

var _quantile = _interopRequireDefault(require("./quantile"));

var _range = _interopRequireDefault(require("./range"));

var _scan = _interopRequireDefault(require("./scan"));

var _shuffle = _interopRequireDefault(require("./shuffle"));

var _sum = _interopRequireDefault(require("./sum"));

var _ticks = _interopRequireWildcard(require("./ticks"));

var _transpose = _interopRequireDefault(require("./transpose"));

var _variance = _interopRequireDefault(require("./variance"));

var _zip = _interopRequireDefault(require("./zip"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _getRequireWildcardCache() { if (typeof WeakMap !== "function") return null; var cache = new WeakMap(); _getRequireWildcardCache = function () { return cache; }; return cache; }

function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } if (obj === null || typeof obj !== "object" && typeof obj !== "function") { return { default: obj }; } var cache = _getRequireWildcardCache(); if (cache && cache.has(obj)) { return cache.get(obj); } var newObj = {}; var hasPropertyDescriptor = Object.defineProperty && Object.getOwnPropertyDescriptor; for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) { var desc = hasPropertyDescriptor ? Object.getOwnPropertyDescriptor(obj, key) : null; if (desc && (desc.get || desc.set)) { Object.defineProperty(newObj, key, desc); } else { newObj[key] = obj[key]; } } } newObj.default = obj; if (cache) { cache.set(obj, newObj); } return newObj; }
},{"./bisect":"node_modules/d3-geo/node_modules/d3-array/src/bisect.js","./ascending":"node_modules/d3-geo/node_modules/d3-array/src/ascending.js","./bisector":"node_modules/d3-geo/node_modules/d3-array/src/bisector.js","./cross":"node_modules/d3-geo/node_modules/d3-array/src/cross.js","./descending":"node_modules/d3-geo/node_modules/d3-array/src/descending.js","./deviation":"node_modules/d3-geo/node_modules/d3-array/src/deviation.js","./extent":"node_modules/d3-geo/node_modules/d3-array/src/extent.js","./histogram":"node_modules/d3-geo/node_modules/d3-array/src/histogram.js","./threshold/freedmanDiaconis":"node_modules/d3-geo/node_modules/d3-array/src/threshold/freedmanDiaconis.js","./threshold/scott":"node_modules/d3-geo/node_modules/d3-array/src/threshold/scott.js","./threshold/sturges":"node_modules/d3-geo/node_modules/d3-array/src/threshold/sturges.js","./max":"node_modules/d3-geo/node_modules/d3-array/src/max.js","./mean":"node_modules/d3-geo/node_modules/d3-array/src/mean.js","./median":"node_modules/d3-geo/node_modules/d3-array/src/median.js","./merge":"node_modules/d3-geo/node_modules/d3-array/src/merge.js","./min":"node_modules/d3-geo/node_modules/d3-array/src/min.js","./pairs":"node_modules/d3-geo/node_modules/d3-array/src/pairs.js","./permute":"node_modules/d3-geo/node_modules/d3-array/src/permute.js","./quantile":"node_modules/d3-geo/node_modules/d3-array/src/quantile.js","./range":"node_modules/d3-geo/node_modules/d3-array/src/range.js","./scan":"node_modules/d3-geo/node_modules/d3-array/src/scan.js","./shuffle":"node_modules/d3-geo/node_modules/d3-array/src/shuffle.js","./sum":"node_modules/d3-geo/node_modules/d3-array/src/sum.js","./ticks":"node_modules/d3-geo/node_modules/d3-array/src/ticks.js","./transpose":"node_modules/d3-geo/node_modules/d3-array/src/transpose.js","./variance":"node_modules/d3-geo/node_modules/d3-array/src/variance.js","./zip":"node_modules/d3-geo/node_modules/d3-array/src/zip.js"}],"node_modules/d3-geo/src/clip/index.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _buffer = _interopRequireDefault(require("./buffer.js"));

var _rejoin = _interopRequireDefault(require("./rejoin.js"));

var _math = require("../math.js");

var _polygonContains = _interopRequireDefault(require("../polygonContains.js"));

var _d3Array = require("d3-array");

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(pointVisible, clipLine, interpolate, start) {
  return function (sink) {
    var line = clipLine(sink),
        ringBuffer = (0, _buffer.default)(),
        ringSink = clipLine(ringBuffer),
        polygonStarted = false,
        polygon,
        segments,
        ring;
    var clip = {
      point: point,
      lineStart: lineStart,
      lineEnd: lineEnd,
      polygonStart: function () {
        clip.point = pointRing;
        clip.lineStart = ringStart;
        clip.lineEnd = ringEnd;
        segments = [];
        polygon = [];
      },
      polygonEnd: function () {
        clip.point = point;
        clip.lineStart = lineStart;
        clip.lineEnd = lineEnd;
        segments = (0, _d3Array.merge)(segments);
        var startInside = (0, _polygonContains.default)(polygon, start);

        if (segments.length) {
          if (!polygonStarted) sink.polygonStart(), polygonStarted = true;
          (0, _rejoin.default)(segments, compareIntersection, startInside, interpolate, sink);
        } else if (startInside) {
          if (!polygonStarted) sink.polygonStart(), polygonStarted = true;
          sink.lineStart();
          interpolate(null, null, 1, sink);
          sink.lineEnd();
        }

        if (polygonStarted) sink.polygonEnd(), polygonStarted = false;
        segments = polygon = null;
      },
      sphere: function () {
        sink.polygonStart();
        sink.lineStart();
        interpolate(null, null, 1, sink);
        sink.lineEnd();
        sink.polygonEnd();
      }
    };

    function point(lambda, phi) {
      if (pointVisible(lambda, phi)) sink.point(lambda, phi);
    }

    function pointLine(lambda, phi) {
      line.point(lambda, phi);
    }

    function lineStart() {
      clip.point = pointLine;
      line.lineStart();
    }

    function lineEnd() {
      clip.point = point;
      line.lineEnd();
    }

    function pointRing(lambda, phi) {
      ring.push([lambda, phi]);
      ringSink.point(lambda, phi);
    }

    function ringStart() {
      ringSink.lineStart();
      ring = [];
    }

    function ringEnd() {
      pointRing(ring[0][0], ring[0][1]);
      ringSink.lineEnd();
      var clean = ringSink.clean(),
          ringSegments = ringBuffer.result(),
          i,
          n = ringSegments.length,
          m,
          segment,
          point;
      ring.pop();
      polygon.push(ring);
      ring = null;
      if (!n) return; // No intersections.

      if (clean & 1) {
        segment = ringSegments[0];

        if ((m = segment.length - 1) > 0) {
          if (!polygonStarted) sink.polygonStart(), polygonStarted = true;
          sink.lineStart();

          for (i = 0; i < m; ++i) sink.point((point = segment[i])[0], point[1]);

          sink.lineEnd();
        }

        return;
      } // Rejoin connected segments.
      // TODO reuse ringBuffer.rejoin()?


      if (n > 1 && clean & 2) ringSegments.push(ringSegments.pop().concat(ringSegments.shift()));
      segments.push(ringSegments.filter(validSegment));
    }

    return clip;
  };
}

function validSegment(segment) {
  return segment.length > 1;
} // Intersections are sorted along the clip edge. For both antimeridian cutting
// and circle clipping, the same comparison is used.


function compareIntersection(a, b) {
  return ((a = a.x)[0] < 0 ? a[1] - _math.halfPi - _math.epsilon : _math.halfPi - a[1]) - ((b = b.x)[0] < 0 ? b[1] - _math.halfPi - _math.epsilon : _math.halfPi - b[1]);
}
},{"./buffer.js":"node_modules/d3-geo/src/clip/buffer.js","./rejoin.js":"node_modules/d3-geo/src/clip/rejoin.js","../math.js":"node_modules/d3-geo/src/math.js","../polygonContains.js":"node_modules/d3-geo/src/polygonContains.js","d3-array":"node_modules/d3-geo/node_modules/d3-array/src/index.js"}],"node_modules/d3-geo/src/clip/antimeridian.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = void 0;

var _index = _interopRequireDefault(require("./index.js"));

var _math = require("../math.js");

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var _default = (0, _index.default)(function () {
  return true;
}, clipAntimeridianLine, clipAntimeridianInterpolate, [-_math.pi, -_math.halfPi]); // Takes a line and cuts into visible segments. Return values: 0 - there were
// intersections or the line was empty; 1 - no intersections; 2 - there were
// intersections, and the first and last segments should be rejoined.


exports.default = _default;

function clipAntimeridianLine(stream) {
  var lambda0 = NaN,
      phi0 = NaN,
      sign0 = NaN,
      clean; // no intersections

  return {
    lineStart: function () {
      stream.lineStart();
      clean = 1;
    },
    point: function (lambda1, phi1) {
      var sign1 = lambda1 > 0 ? _math.pi : -_math.pi,
          delta = (0, _math.abs)(lambda1 - lambda0);

      if ((0, _math.abs)(delta - _math.pi) < _math.epsilon) {
        // line crosses a pole
        stream.point(lambda0, phi0 = (phi0 + phi1) / 2 > 0 ? _math.halfPi : -_math.halfPi);
        stream.point(sign0, phi0);
        stream.lineEnd();
        stream.lineStart();
        stream.point(sign1, phi0);
        stream.point(lambda1, phi0);
        clean = 0;
      } else if (sign0 !== sign1 && delta >= _math.pi) {
        // line crosses antimeridian
        if ((0, _math.abs)(lambda0 - sign0) < _math.epsilon) lambda0 -= sign0 * _math.epsilon; // handle degeneracies

        if ((0, _math.abs)(lambda1 - sign1) < _math.epsilon) lambda1 -= sign1 * _math.epsilon;
        phi0 = clipAntimeridianIntersect(lambda0, phi0, lambda1, phi1);
        stream.point(sign0, phi0);
        stream.lineEnd();
        stream.lineStart();
        stream.point(sign1, phi0);
        clean = 0;
      }

      stream.point(lambda0 = lambda1, phi0 = phi1);
      sign0 = sign1;
    },
    lineEnd: function () {
      stream.lineEnd();
      lambda0 = phi0 = NaN;
    },
    clean: function () {
      return 2 - clean; // if intersections, rejoin first and last segments
    }
  };
}

function clipAntimeridianIntersect(lambda0, phi0, lambda1, phi1) {
  var cosPhi0,
      cosPhi1,
      sinLambda0Lambda1 = (0, _math.sin)(lambda0 - lambda1);
  return (0, _math.abs)(sinLambda0Lambda1) > _math.epsilon ? (0, _math.atan)(((0, _math.sin)(phi0) * (cosPhi1 = (0, _math.cos)(phi1)) * (0, _math.sin)(lambda1) - (0, _math.sin)(phi1) * (cosPhi0 = (0, _math.cos)(phi0)) * (0, _math.sin)(lambda0)) / (cosPhi0 * cosPhi1 * sinLambda0Lambda1)) : (phi0 + phi1) / 2;
}

function clipAntimeridianInterpolate(from, to, direction, stream) {
  var phi;

  if (from == null) {
    phi = direction * _math.halfPi;
    stream.point(-_math.pi, phi);
    stream.point(0, phi);
    stream.point(_math.pi, phi);
    stream.point(_math.pi, 0);
    stream.point(_math.pi, -phi);
    stream.point(0, -phi);
    stream.point(-_math.pi, -phi);
    stream.point(-_math.pi, 0);
    stream.point(-_math.pi, phi);
  } else if ((0, _math.abs)(from[0] - to[0]) > _math.epsilon) {
    var lambda = from[0] < to[0] ? _math.pi : -_math.pi;
    phi = direction * lambda / 2;
    stream.point(-lambda, phi);
    stream.point(0, phi);
    stream.point(lambda, phi);
  } else {
    stream.point(to[0], to[1]);
  }
}
},{"./index.js":"node_modules/d3-geo/src/clip/index.js","../math.js":"node_modules/d3-geo/src/math.js"}],"node_modules/d3-geo/src/clip/circle.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _cartesian = require("../cartesian.js");

var _circle = require("../circle.js");

var _math = require("../math.js");

var _pointEqual = _interopRequireDefault(require("../pointEqual.js"));

var _index = _interopRequireDefault(require("./index.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(radius) {
  var cr = (0, _math.cos)(radius),
      delta = 6 * _math.radians,
      smallRadius = cr > 0,
      notHemisphere = (0, _math.abs)(cr) > _math.epsilon; // TODO optimise for this common case


  function interpolate(from, to, direction, stream) {
    (0, _circle.circleStream)(stream, radius, delta, direction, from, to);
  }

  function visible(lambda, phi) {
    return (0, _math.cos)(lambda) * (0, _math.cos)(phi) > cr;
  } // Takes a line and cuts into visible segments. Return values used for polygon
  // clipping: 0 - there were intersections or the line was empty; 1 - no
  // intersections 2 - there were intersections, and the first and last segments
  // should be rejoined.


  function clipLine(stream) {
    var point0, // previous point
    c0, // code for previous point
    v0, // visibility of previous point
    v00, // visibility of first point
    clean; // no intersections

    return {
      lineStart: function () {
        v00 = v0 = false;
        clean = 1;
      },
      point: function (lambda, phi) {
        var point1 = [lambda, phi],
            point2,
            v = visible(lambda, phi),
            c = smallRadius ? v ? 0 : code(lambda, phi) : v ? code(lambda + (lambda < 0 ? _math.pi : -_math.pi), phi) : 0;
        if (!point0 && (v00 = v0 = v)) stream.lineStart();

        if (v !== v0) {
          point2 = intersect(point0, point1);
          if (!point2 || (0, _pointEqual.default)(point0, point2) || (0, _pointEqual.default)(point1, point2)) point1[2] = 1;
        }

        if (v !== v0) {
          clean = 0;

          if (v) {
            // outside going in
            stream.lineStart();
            point2 = intersect(point1, point0);
            stream.point(point2[0], point2[1]);
          } else {
            // inside going out
            point2 = intersect(point0, point1);
            stream.point(point2[0], point2[1], 2);
            stream.lineEnd();
          }

          point0 = point2;
        } else if (notHemisphere && point0 && smallRadius ^ v) {
          var t; // If the codes for two points are different, or are both zero,
          // and there this segment intersects with the small circle.

          if (!(c & c0) && (t = intersect(point1, point0, true))) {
            clean = 0;

            if (smallRadius) {
              stream.lineStart();
              stream.point(t[0][0], t[0][1]);
              stream.point(t[1][0], t[1][1]);
              stream.lineEnd();
            } else {
              stream.point(t[1][0], t[1][1]);
              stream.lineEnd();
              stream.lineStart();
              stream.point(t[0][0], t[0][1], 3);
            }
          }
        }

        if (v && (!point0 || !(0, _pointEqual.default)(point0, point1))) {
          stream.point(point1[0], point1[1]);
        }

        point0 = point1, v0 = v, c0 = c;
      },
      lineEnd: function () {
        if (v0) stream.lineEnd();
        point0 = null;
      },
      // Rejoin first and last segments if there were intersections and the first
      // and last points were visible.
      clean: function () {
        return clean | (v00 && v0) << 1;
      }
    };
  } // Intersects the great circle between a and b with the clip circle.


  function intersect(a, b, two) {
    var pa = (0, _cartesian.cartesian)(a),
        pb = (0, _cartesian.cartesian)(b); // We have two planes, n1.p = d1 and n2.p = d2.
    // Find intersection line p(t) = c1 n1 + c2 n2 + t (n1 ⨯ n2).

    var n1 = [1, 0, 0],
        // normal
    n2 = (0, _cartesian.cartesianCross)(pa, pb),
        n2n2 = (0, _cartesian.cartesianDot)(n2, n2),
        n1n2 = n2[0],
        // cartesianDot(n1, n2),
    determinant = n2n2 - n1n2 * n1n2; // Two polar points.

    if (!determinant) return !two && a;
    var c1 = cr * n2n2 / determinant,
        c2 = -cr * n1n2 / determinant,
        n1xn2 = (0, _cartesian.cartesianCross)(n1, n2),
        A = (0, _cartesian.cartesianScale)(n1, c1),
        B = (0, _cartesian.cartesianScale)(n2, c2);
    (0, _cartesian.cartesianAddInPlace)(A, B); // Solve |p(t)|^2 = 1.

    var u = n1xn2,
        w = (0, _cartesian.cartesianDot)(A, u),
        uu = (0, _cartesian.cartesianDot)(u, u),
        t2 = w * w - uu * ((0, _cartesian.cartesianDot)(A, A) - 1);
    if (t2 < 0) return;
    var t = (0, _math.sqrt)(t2),
        q = (0, _cartesian.cartesianScale)(u, (-w - t) / uu);
    (0, _cartesian.cartesianAddInPlace)(q, A);
    q = (0, _cartesian.spherical)(q);
    if (!two) return q; // Two intersection points.

    var lambda0 = a[0],
        lambda1 = b[0],
        phi0 = a[1],
        phi1 = b[1],
        z;
    if (lambda1 < lambda0) z = lambda0, lambda0 = lambda1, lambda1 = z;

    var delta = lambda1 - lambda0,
        polar = (0, _math.abs)(delta - _math.pi) < _math.epsilon,
        meridian = polar || delta < _math.epsilon;

    if (!polar && phi1 < phi0) z = phi0, phi0 = phi1, phi1 = z; // Check that the first point is between a and b.

    if (meridian ? polar ? phi0 + phi1 > 0 ^ q[1] < ((0, _math.abs)(q[0] - lambda0) < _math.epsilon ? phi0 : phi1) : phi0 <= q[1] && q[1] <= phi1 : delta > _math.pi ^ (lambda0 <= q[0] && q[0] <= lambda1)) {
      var q1 = (0, _cartesian.cartesianScale)(u, (-w + t) / uu);
      (0, _cartesian.cartesianAddInPlace)(q1, A);
      return [q, (0, _cartesian.spherical)(q1)];
    }
  } // Generates a 4-bit vector representing the location of a point relative to
  // the small circle's bounding box.


  function code(lambda, phi) {
    var r = smallRadius ? radius : _math.pi - radius,
        code = 0;
    if (lambda < -r) code |= 1; // left
    else if (lambda > r) code |= 2; // right

    if (phi < -r) code |= 4; // below
    else if (phi > r) code |= 8; // above

    return code;
  }

  return (0, _index.default)(visible, clipLine, interpolate, smallRadius ? [0, -radius] : [-_math.pi, radius - _math.pi]);
}
},{"../cartesian.js":"node_modules/d3-geo/src/cartesian.js","../circle.js":"node_modules/d3-geo/src/circle.js","../math.js":"node_modules/d3-geo/src/math.js","../pointEqual.js":"node_modules/d3-geo/src/pointEqual.js","./index.js":"node_modules/d3-geo/src/clip/index.js"}],"node_modules/d3-geo/src/clip/line.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(a, b, x0, y0, x1, y1) {
  var ax = a[0],
      ay = a[1],
      bx = b[0],
      by = b[1],
      t0 = 0,
      t1 = 1,
      dx = bx - ax,
      dy = by - ay,
      r;
  r = x0 - ax;
  if (!dx && r > 0) return;
  r /= dx;

  if (dx < 0) {
    if (r < t0) return;
    if (r < t1) t1 = r;
  } else if (dx > 0) {
    if (r > t1) return;
    if (r > t0) t0 = r;
  }

  r = x1 - ax;
  if (!dx && r < 0) return;
  r /= dx;

  if (dx < 0) {
    if (r > t1) return;
    if (r > t0) t0 = r;
  } else if (dx > 0) {
    if (r < t0) return;
    if (r < t1) t1 = r;
  }

  r = y0 - ay;
  if (!dy && r > 0) return;
  r /= dy;

  if (dy < 0) {
    if (r < t0) return;
    if (r < t1) t1 = r;
  } else if (dy > 0) {
    if (r > t1) return;
    if (r > t0) t0 = r;
  }

  r = y1 - ay;
  if (!dy && r < 0) return;
  r /= dy;

  if (dy < 0) {
    if (r > t1) return;
    if (r > t0) t0 = r;
  } else if (dy > 0) {
    if (r < t0) return;
    if (r < t1) t1 = r;
  }

  if (t0 > 0) a[0] = ax + t0 * dx, a[1] = ay + t0 * dy;
  if (t1 < 1) b[0] = ax + t1 * dx, b[1] = ay + t1 * dy;
  return true;
}
},{}],"node_modules/d3-geo/src/clip/rectangle.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = clipRectangle;

var _math = require("../math.js");

var _buffer = _interopRequireDefault(require("./buffer.js"));

var _line = _interopRequireDefault(require("./line.js"));

var _rejoin = _interopRequireDefault(require("./rejoin.js"));

var _d3Array = require("d3-array");

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var clipMax = 1e9,
    clipMin = -clipMax; // TODO Use d3-polygon’s polygonContains here for the ring check?
// TODO Eliminate duplicate buffering in clipBuffer and polygon.push?

function clipRectangle(x0, y0, x1, y1) {
  function visible(x, y) {
    return x0 <= x && x <= x1 && y0 <= y && y <= y1;
  }

  function interpolate(from, to, direction, stream) {
    var a = 0,
        a1 = 0;

    if (from == null || (a = corner(from, direction)) !== (a1 = corner(to, direction)) || comparePoint(from, to) < 0 ^ direction > 0) {
      do stream.point(a === 0 || a === 3 ? x0 : x1, a > 1 ? y1 : y0); while ((a = (a + direction + 4) % 4) !== a1);
    } else {
      stream.point(to[0], to[1]);
    }
  }

  function corner(p, direction) {
    return (0, _math.abs)(p[0] - x0) < _math.epsilon ? direction > 0 ? 0 : 3 : (0, _math.abs)(p[0] - x1) < _math.epsilon ? direction > 0 ? 2 : 1 : (0, _math.abs)(p[1] - y0) < _math.epsilon ? direction > 0 ? 1 : 0 : direction > 0 ? 3 : 2; // abs(p[1] - y1) < epsilon
  }

  function compareIntersection(a, b) {
    return comparePoint(a.x, b.x);
  }

  function comparePoint(a, b) {
    var ca = corner(a, 1),
        cb = corner(b, 1);
    return ca !== cb ? ca - cb : ca === 0 ? b[1] - a[1] : ca === 1 ? a[0] - b[0] : ca === 2 ? a[1] - b[1] : b[0] - a[0];
  }

  return function (stream) {
    var activeStream = stream,
        bufferStream = (0, _buffer.default)(),
        segments,
        polygon,
        ring,
        x__,
        y__,
        v__,
        // first point
    x_,
        y_,
        v_,
        // previous point
    first,
        clean;
    var clipStream = {
      point: point,
      lineStart: lineStart,
      lineEnd: lineEnd,
      polygonStart: polygonStart,
      polygonEnd: polygonEnd
    };

    function point(x, y) {
      if (visible(x, y)) activeStream.point(x, y);
    }

    function polygonInside() {
      var winding = 0;

      for (var i = 0, n = polygon.length; i < n; ++i) {
        for (var ring = polygon[i], j = 1, m = ring.length, point = ring[0], a0, a1, b0 = point[0], b1 = point[1]; j < m; ++j) {
          a0 = b0, a1 = b1, point = ring[j], b0 = point[0], b1 = point[1];

          if (a1 <= y1) {
            if (b1 > y1 && (b0 - a0) * (y1 - a1) > (b1 - a1) * (x0 - a0)) ++winding;
          } else {
            if (b1 <= y1 && (b0 - a0) * (y1 - a1) < (b1 - a1) * (x0 - a0)) --winding;
          }
        }
      }

      return winding;
    } // Buffer geometry within a polygon and then clip it en masse.


    function polygonStart() {
      activeStream = bufferStream, segments = [], polygon = [], clean = true;
    }

    function polygonEnd() {
      var startInside = polygonInside(),
          cleanInside = clean && startInside,
          visible = (segments = (0, _d3Array.merge)(segments)).length;

      if (cleanInside || visible) {
        stream.polygonStart();

        if (cleanInside) {
          stream.lineStart();
          interpolate(null, null, 1, stream);
          stream.lineEnd();
        }

        if (visible) {
          (0, _rejoin.default)(segments, compareIntersection, startInside, interpolate, stream);
        }

        stream.polygonEnd();
      }

      activeStream = stream, segments = polygon = ring = null;
    }

    function lineStart() {
      clipStream.point = linePoint;
      if (polygon) polygon.push(ring = []);
      first = true;
      v_ = false;
      x_ = y_ = NaN;
    } // TODO rather than special-case polygons, simply handle them separately.
    // Ideally, coincident intersection points should be jittered to avoid
    // clipping issues.


    function lineEnd() {
      if (segments) {
        linePoint(x__, y__);
        if (v__ && v_) bufferStream.rejoin();
        segments.push(bufferStream.result());
      }

      clipStream.point = point;
      if (v_) activeStream.lineEnd();
    }

    function linePoint(x, y) {
      var v = visible(x, y);
      if (polygon) ring.push([x, y]);

      if (first) {
        x__ = x, y__ = y, v__ = v;
        first = false;

        if (v) {
          activeStream.lineStart();
          activeStream.point(x, y);
        }
      } else {
        if (v && v_) activeStream.point(x, y);else {
          var a = [x_ = Math.max(clipMin, Math.min(clipMax, x_)), y_ = Math.max(clipMin, Math.min(clipMax, y_))],
              b = [x = Math.max(clipMin, Math.min(clipMax, x)), y = Math.max(clipMin, Math.min(clipMax, y))];

          if ((0, _line.default)(a, b, x0, y0, x1, y1)) {
            if (!v_) {
              activeStream.lineStart();
              activeStream.point(a[0], a[1]);
            }

            activeStream.point(b[0], b[1]);
            if (!v) activeStream.lineEnd();
            clean = false;
          } else if (v) {
            activeStream.lineStart();
            activeStream.point(x, y);
            clean = false;
          }
        }
      }

      x_ = x, y_ = y, v_ = v;
    }

    return clipStream;
  };
}
},{"../math.js":"node_modules/d3-geo/src/math.js","./buffer.js":"node_modules/d3-geo/src/clip/buffer.js","./line.js":"node_modules/d3-geo/src/clip/line.js","./rejoin.js":"node_modules/d3-geo/src/clip/rejoin.js","d3-array":"node_modules/d3-geo/node_modules/d3-array/src/index.js"}],"node_modules/d3-geo/src/clip/extent.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _rectangle = _interopRequireDefault(require("./rectangle.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default() {
  var x0 = 0,
      y0 = 0,
      x1 = 960,
      y1 = 500,
      cache,
      cacheStream,
      clip;
  return clip = {
    stream: function (stream) {
      return cache && cacheStream === stream ? cache : cache = (0, _rectangle.default)(x0, y0, x1, y1)(cacheStream = stream);
    },
    extent: function (_) {
      return arguments.length ? (x0 = +_[0][0], y0 = +_[0][1], x1 = +_[1][0], y1 = +_[1][1], cache = cacheStream = null, clip) : [[x0, y0], [x1, y1]];
    }
  };
}
},{"./rectangle.js":"node_modules/d3-geo/src/clip/rectangle.js"}],"node_modules/d3-geo/src/length.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _adder = _interopRequireDefault(require("./adder.js"));

var _math = require("./math.js");

var _noop = _interopRequireDefault(require("./noop.js"));

var _stream = _interopRequireDefault(require("./stream.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var lengthSum = (0, _adder.default)(),
    lambda0,
    sinPhi0,
    cosPhi0;
var lengthStream = {
  sphere: _noop.default,
  point: _noop.default,
  lineStart: lengthLineStart,
  lineEnd: _noop.default,
  polygonStart: _noop.default,
  polygonEnd: _noop.default
};

function lengthLineStart() {
  lengthStream.point = lengthPointFirst;
  lengthStream.lineEnd = lengthLineEnd;
}

function lengthLineEnd() {
  lengthStream.point = lengthStream.lineEnd = _noop.default;
}

function lengthPointFirst(lambda, phi) {
  lambda *= _math.radians, phi *= _math.radians;
  lambda0 = lambda, sinPhi0 = (0, _math.sin)(phi), cosPhi0 = (0, _math.cos)(phi);
  lengthStream.point = lengthPoint;
}

function lengthPoint(lambda, phi) {
  lambda *= _math.radians, phi *= _math.radians;
  var sinPhi = (0, _math.sin)(phi),
      cosPhi = (0, _math.cos)(phi),
      delta = (0, _math.abs)(lambda - lambda0),
      cosDelta = (0, _math.cos)(delta),
      sinDelta = (0, _math.sin)(delta),
      x = cosPhi * sinDelta,
      y = cosPhi0 * sinPhi - sinPhi0 * cosPhi * cosDelta,
      z = sinPhi0 * sinPhi + cosPhi0 * cosPhi * cosDelta;
  lengthSum.add((0, _math.atan2)((0, _math.sqrt)(x * x + y * y), z));
  lambda0 = lambda, sinPhi0 = sinPhi, cosPhi0 = cosPhi;
}

function _default(object) {
  lengthSum.reset();
  (0, _stream.default)(object, lengthStream);
  return +lengthSum;
}
},{"./adder.js":"node_modules/d3-geo/src/adder.js","./math.js":"node_modules/d3-geo/src/math.js","./noop.js":"node_modules/d3-geo/src/noop.js","./stream.js":"node_modules/d3-geo/src/stream.js"}],"node_modules/d3-geo/src/distance.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _length = _interopRequireDefault(require("./length.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var coordinates = [null, null],
    object = {
  type: "LineString",
  coordinates: coordinates
};

function _default(a, b) {
  coordinates[0] = a;
  coordinates[1] = b;
  return (0, _length.default)(object);
}
},{"./length.js":"node_modules/d3-geo/src/length.js"}],"node_modules/d3-geo/src/contains.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _polygonContains = _interopRequireDefault(require("./polygonContains.js"));

var _distance = _interopRequireDefault(require("./distance.js"));

var _math = require("./math.js");

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var containsObjectType = {
  Feature: function (object, point) {
    return containsGeometry(object.geometry, point);
  },
  FeatureCollection: function (object, point) {
    var features = object.features,
        i = -1,
        n = features.length;

    while (++i < n) if (containsGeometry(features[i].geometry, point)) return true;

    return false;
  }
};
var containsGeometryType = {
  Sphere: function () {
    return true;
  },
  Point: function (object, point) {
    return containsPoint(object.coordinates, point);
  },
  MultiPoint: function (object, point) {
    var coordinates = object.coordinates,
        i = -1,
        n = coordinates.length;

    while (++i < n) if (containsPoint(coordinates[i], point)) return true;

    return false;
  },
  LineString: function (object, point) {
    return containsLine(object.coordinates, point);
  },
  MultiLineString: function (object, point) {
    var coordinates = object.coordinates,
        i = -1,
        n = coordinates.length;

    while (++i < n) if (containsLine(coordinates[i], point)) return true;

    return false;
  },
  Polygon: function (object, point) {
    return containsPolygon(object.coordinates, point);
  },
  MultiPolygon: function (object, point) {
    var coordinates = object.coordinates,
        i = -1,
        n = coordinates.length;

    while (++i < n) if (containsPolygon(coordinates[i], point)) return true;

    return false;
  },
  GeometryCollection: function (object, point) {
    var geometries = object.geometries,
        i = -1,
        n = geometries.length;

    while (++i < n) if (containsGeometry(geometries[i], point)) return true;

    return false;
  }
};

function containsGeometry(geometry, point) {
  return geometry && containsGeometryType.hasOwnProperty(geometry.type) ? containsGeometryType[geometry.type](geometry, point) : false;
}

function containsPoint(coordinates, point) {
  return (0, _distance.default)(coordinates, point) === 0;
}

function containsLine(coordinates, point) {
  var ao, bo, ab;

  for (var i = 0, n = coordinates.length; i < n; i++) {
    bo = (0, _distance.default)(coordinates[i], point);
    if (bo === 0) return true;

    if (i > 0) {
      ab = (0, _distance.default)(coordinates[i], coordinates[i - 1]);
      if (ab > 0 && ao <= ab && bo <= ab && (ao + bo - ab) * (1 - Math.pow((ao - bo) / ab, 2)) < _math.epsilon2 * ab) return true;
    }

    ao = bo;
  }

  return false;
}

function containsPolygon(coordinates, point) {
  return !!(0, _polygonContains.default)(coordinates.map(ringRadians), pointRadians(point));
}

function ringRadians(ring) {
  return ring = ring.map(pointRadians), ring.pop(), ring;
}

function pointRadians(point) {
  return [point[0] * _math.radians, point[1] * _math.radians];
}

function _default(object, point) {
  return (object && containsObjectType.hasOwnProperty(object.type) ? containsObjectType[object.type] : containsGeometry)(object, point);
}
},{"./polygonContains.js":"node_modules/d3-geo/src/polygonContains.js","./distance.js":"node_modules/d3-geo/src/distance.js","./math.js":"node_modules/d3-geo/src/math.js"}],"node_modules/d3-geo/src/graticule.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = graticule;
exports.graticule10 = graticule10;

var _d3Array = require("d3-array");

var _math = require("./math.js");

function graticuleX(y0, y1, dy) {
  var y = (0, _d3Array.range)(y0, y1 - _math.epsilon, dy).concat(y1);
  return function (x) {
    return y.map(function (y) {
      return [x, y];
    });
  };
}

function graticuleY(x0, x1, dx) {
  var x = (0, _d3Array.range)(x0, x1 - _math.epsilon, dx).concat(x1);
  return function (y) {
    return x.map(function (x) {
      return [x, y];
    });
  };
}

function graticule() {
  var x1,
      x0,
      X1,
      X0,
      y1,
      y0,
      Y1,
      Y0,
      dx = 10,
      dy = dx,
      DX = 90,
      DY = 360,
      x,
      y,
      X,
      Y,
      precision = 2.5;

  function graticule() {
    return {
      type: "MultiLineString",
      coordinates: lines()
    };
  }

  function lines() {
    return (0, _d3Array.range)((0, _math.ceil)(X0 / DX) * DX, X1, DX).map(X).concat((0, _d3Array.range)((0, _math.ceil)(Y0 / DY) * DY, Y1, DY).map(Y)).concat((0, _d3Array.range)((0, _math.ceil)(x0 / dx) * dx, x1, dx).filter(function (x) {
      return (0, _math.abs)(x % DX) > _math.epsilon;
    }).map(x)).concat((0, _d3Array.range)((0, _math.ceil)(y0 / dy) * dy, y1, dy).filter(function (y) {
      return (0, _math.abs)(y % DY) > _math.epsilon;
    }).map(y));
  }

  graticule.lines = function () {
    return lines().map(function (coordinates) {
      return {
        type: "LineString",
        coordinates: coordinates
      };
    });
  };

  graticule.outline = function () {
    return {
      type: "Polygon",
      coordinates: [X(X0).concat(Y(Y1).slice(1), X(X1).reverse().slice(1), Y(Y0).reverse().slice(1))]
    };
  };

  graticule.extent = function (_) {
    if (!arguments.length) return graticule.extentMinor();
    return graticule.extentMajor(_).extentMinor(_);
  };

  graticule.extentMajor = function (_) {
    if (!arguments.length) return [[X0, Y0], [X1, Y1]];
    X0 = +_[0][0], X1 = +_[1][0];
    Y0 = +_[0][1], Y1 = +_[1][1];
    if (X0 > X1) _ = X0, X0 = X1, X1 = _;
    if (Y0 > Y1) _ = Y0, Y0 = Y1, Y1 = _;
    return graticule.precision(precision);
  };

  graticule.extentMinor = function (_) {
    if (!arguments.length) return [[x0, y0], [x1, y1]];
    x0 = +_[0][0], x1 = +_[1][0];
    y0 = +_[0][1], y1 = +_[1][1];
    if (x0 > x1) _ = x0, x0 = x1, x1 = _;
    if (y0 > y1) _ = y0, y0 = y1, y1 = _;
    return graticule.precision(precision);
  };

  graticule.step = function (_) {
    if (!arguments.length) return graticule.stepMinor();
    return graticule.stepMajor(_).stepMinor(_);
  };

  graticule.stepMajor = function (_) {
    if (!arguments.length) return [DX, DY];
    DX = +_[0], DY = +_[1];
    return graticule;
  };

  graticule.stepMinor = function (_) {
    if (!arguments.length) return [dx, dy];
    dx = +_[0], dy = +_[1];
    return graticule;
  };

  graticule.precision = function (_) {
    if (!arguments.length) return precision;
    precision = +_;
    x = graticuleX(y0, y1, 90);
    y = graticuleY(x0, x1, precision);
    X = graticuleX(Y0, Y1, 90);
    Y = graticuleY(X0, X1, precision);
    return graticule;
  };

  return graticule.extentMajor([[-180, -90 + _math.epsilon], [180, 90 - _math.epsilon]]).extentMinor([[-180, -80 - _math.epsilon], [180, 80 + _math.epsilon]]);
}

function graticule10() {
  return graticule()();
}
},{"d3-array":"node_modules/d3-geo/node_modules/d3-array/src/index.js","./math.js":"node_modules/d3-geo/src/math.js"}],"node_modules/d3-geo/src/interpolate.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _math = require("./math.js");

function _default(a, b) {
  var x0 = a[0] * _math.radians,
      y0 = a[1] * _math.radians,
      x1 = b[0] * _math.radians,
      y1 = b[1] * _math.radians,
      cy0 = (0, _math.cos)(y0),
      sy0 = (0, _math.sin)(y0),
      cy1 = (0, _math.cos)(y1),
      sy1 = (0, _math.sin)(y1),
      kx0 = cy0 * (0, _math.cos)(x0),
      ky0 = cy0 * (0, _math.sin)(x0),
      kx1 = cy1 * (0, _math.cos)(x1),
      ky1 = cy1 * (0, _math.sin)(x1),
      d = 2 * (0, _math.asin)((0, _math.sqrt)((0, _math.haversin)(y1 - y0) + cy0 * cy1 * (0, _math.haversin)(x1 - x0))),
      k = (0, _math.sin)(d);
  var interpolate = d ? function (t) {
    var B = (0, _math.sin)(t *= d) / k,
        A = (0, _math.sin)(d - t) / k,
        x = A * kx0 + B * kx1,
        y = A * ky0 + B * ky1,
        z = A * sy0 + B * sy1;
    return [(0, _math.atan2)(y, x) * _math.degrees, (0, _math.atan2)(z, (0, _math.sqrt)(x * x + y * y)) * _math.degrees];
  } : function () {
    return [x0 * _math.degrees, y0 * _math.degrees];
  };
  interpolate.distance = d;
  return interpolate;
}
},{"./math.js":"node_modules/d3-geo/src/math.js"}],"node_modules/d3-geo/src/identity.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(x) {
  return x;
}
},{}],"node_modules/d3-geo/src/path/area.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = void 0;

var _adder = _interopRequireDefault(require("../adder.js"));

var _math = require("../math.js");

var _noop = _interopRequireDefault(require("../noop.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var areaSum = (0, _adder.default)(),
    areaRingSum = (0, _adder.default)(),
    x00,
    y00,
    x0,
    y0;
var areaStream = {
  point: _noop.default,
  lineStart: _noop.default,
  lineEnd: _noop.default,
  polygonStart: function () {
    areaStream.lineStart = areaRingStart;
    areaStream.lineEnd = areaRingEnd;
  },
  polygonEnd: function () {
    areaStream.lineStart = areaStream.lineEnd = areaStream.point = _noop.default;
    areaSum.add((0, _math.abs)(areaRingSum));
    areaRingSum.reset();
  },
  result: function () {
    var area = areaSum / 2;
    areaSum.reset();
    return area;
  }
};

function areaRingStart() {
  areaStream.point = areaPointFirst;
}

function areaPointFirst(x, y) {
  areaStream.point = areaPoint;
  x00 = x0 = x, y00 = y0 = y;
}

function areaPoint(x, y) {
  areaRingSum.add(y0 * x - x0 * y);
  x0 = x, y0 = y;
}

function areaRingEnd() {
  areaPoint(x00, y00);
}

var _default = areaStream;
exports.default = _default;
},{"../adder.js":"node_modules/d3-geo/src/adder.js","../math.js":"node_modules/d3-geo/src/math.js","../noop.js":"node_modules/d3-geo/src/noop.js"}],"node_modules/d3-geo/src/path/bounds.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = void 0;

var _noop = _interopRequireDefault(require("../noop.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var x0 = Infinity,
    y0 = x0,
    x1 = -x0,
    y1 = x1;
var boundsStream = {
  point: boundsPoint,
  lineStart: _noop.default,
  lineEnd: _noop.default,
  polygonStart: _noop.default,
  polygonEnd: _noop.default,
  result: function () {
    var bounds = [[x0, y0], [x1, y1]];
    x1 = y1 = -(y0 = x0 = Infinity);
    return bounds;
  }
};

function boundsPoint(x, y) {
  if (x < x0) x0 = x;
  if (x > x1) x1 = x;
  if (y < y0) y0 = y;
  if (y > y1) y1 = y;
}

var _default = boundsStream;
exports.default = _default;
},{"../noop.js":"node_modules/d3-geo/src/noop.js"}],"node_modules/d3-geo/src/path/centroid.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = void 0;

var _math = require("../math.js");

// TODO Enforce positive area for exterior, negative area for interior?
var X0 = 0,
    Y0 = 0,
    Z0 = 0,
    X1 = 0,
    Y1 = 0,
    Z1 = 0,
    X2 = 0,
    Y2 = 0,
    Z2 = 0,
    x00,
    y00,
    x0,
    y0;
var centroidStream = {
  point: centroidPoint,
  lineStart: centroidLineStart,
  lineEnd: centroidLineEnd,
  polygonStart: function () {
    centroidStream.lineStart = centroidRingStart;
    centroidStream.lineEnd = centroidRingEnd;
  },
  polygonEnd: function () {
    centroidStream.point = centroidPoint;
    centroidStream.lineStart = centroidLineStart;
    centroidStream.lineEnd = centroidLineEnd;
  },
  result: function () {
    var centroid = Z2 ? [X2 / Z2, Y2 / Z2] : Z1 ? [X1 / Z1, Y1 / Z1] : Z0 ? [X0 / Z0, Y0 / Z0] : [NaN, NaN];
    X0 = Y0 = Z0 = X1 = Y1 = Z1 = X2 = Y2 = Z2 = 0;
    return centroid;
  }
};

function centroidPoint(x, y) {
  X0 += x;
  Y0 += y;
  ++Z0;
}

function centroidLineStart() {
  centroidStream.point = centroidPointFirstLine;
}

function centroidPointFirstLine(x, y) {
  centroidStream.point = centroidPointLine;
  centroidPoint(x0 = x, y0 = y);
}

function centroidPointLine(x, y) {
  var dx = x - x0,
      dy = y - y0,
      z = (0, _math.sqrt)(dx * dx + dy * dy);
  X1 += z * (x0 + x) / 2;
  Y1 += z * (y0 + y) / 2;
  Z1 += z;
  centroidPoint(x0 = x, y0 = y);
}

function centroidLineEnd() {
  centroidStream.point = centroidPoint;
}

function centroidRingStart() {
  centroidStream.point = centroidPointFirstRing;
}

function centroidRingEnd() {
  centroidPointRing(x00, y00);
}

function centroidPointFirstRing(x, y) {
  centroidStream.point = centroidPointRing;
  centroidPoint(x00 = x0 = x, y00 = y0 = y);
}

function centroidPointRing(x, y) {
  var dx = x - x0,
      dy = y - y0,
      z = (0, _math.sqrt)(dx * dx + dy * dy);
  X1 += z * (x0 + x) / 2;
  Y1 += z * (y0 + y) / 2;
  Z1 += z;
  z = y0 * x - x0 * y;
  X2 += z * (x0 + x);
  Y2 += z * (y0 + y);
  Z2 += z * 3;
  centroidPoint(x0 = x, y0 = y);
}

var _default = centroidStream;
exports.default = _default;
},{"../math.js":"node_modules/d3-geo/src/math.js"}],"node_modules/d3-geo/src/path/context.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = PathContext;

var _math = require("../math.js");

var _noop = _interopRequireDefault(require("../noop.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function PathContext(context) {
  this._context = context;
}

PathContext.prototype = {
  _radius: 4.5,
  pointRadius: function (_) {
    return this._radius = _, this;
  },
  polygonStart: function () {
    this._line = 0;
  },
  polygonEnd: function () {
    this._line = NaN;
  },
  lineStart: function () {
    this._point = 0;
  },
  lineEnd: function () {
    if (this._line === 0) this._context.closePath();
    this._point = NaN;
  },
  point: function (x, y) {
    switch (this._point) {
      case 0:
        {
          this._context.moveTo(x, y);

          this._point = 1;
          break;
        }

      case 1:
        {
          this._context.lineTo(x, y);

          break;
        }

      default:
        {
          this._context.moveTo(x + this._radius, y);

          this._context.arc(x, y, this._radius, 0, _math.tau);

          break;
        }
    }
  },
  result: _noop.default
};
},{"../math.js":"node_modules/d3-geo/src/math.js","../noop.js":"node_modules/d3-geo/src/noop.js"}],"node_modules/d3-geo/src/path/measure.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = void 0;

var _adder = _interopRequireDefault(require("../adder.js"));

var _math = require("../math.js");

var _noop = _interopRequireDefault(require("../noop.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var lengthSum = (0, _adder.default)(),
    lengthRing,
    x00,
    y00,
    x0,
    y0;
var lengthStream = {
  point: _noop.default,
  lineStart: function () {
    lengthStream.point = lengthPointFirst;
  },
  lineEnd: function () {
    if (lengthRing) lengthPoint(x00, y00);
    lengthStream.point = _noop.default;
  },
  polygonStart: function () {
    lengthRing = true;
  },
  polygonEnd: function () {
    lengthRing = null;
  },
  result: function () {
    var length = +lengthSum;
    lengthSum.reset();
    return length;
  }
};

function lengthPointFirst(x, y) {
  lengthStream.point = lengthPoint;
  x00 = x0 = x, y00 = y0 = y;
}

function lengthPoint(x, y) {
  x0 -= x, y0 -= y;
  lengthSum.add((0, _math.sqrt)(x0 * x0 + y0 * y0));
  x0 = x, y0 = y;
}

var _default = lengthStream;
exports.default = _default;
},{"../adder.js":"node_modules/d3-geo/src/adder.js","../math.js":"node_modules/d3-geo/src/math.js","../noop.js":"node_modules/d3-geo/src/noop.js"}],"node_modules/d3-geo/src/path/string.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = PathString;

function PathString() {
  this._string = [];
}

PathString.prototype = {
  _radius: 4.5,
  _circle: circle(4.5),
  pointRadius: function (_) {
    if ((_ = +_) !== this._radius) this._radius = _, this._circle = null;
    return this;
  },
  polygonStart: function () {
    this._line = 0;
  },
  polygonEnd: function () {
    this._line = NaN;
  },
  lineStart: function () {
    this._point = 0;
  },
  lineEnd: function () {
    if (this._line === 0) this._string.push("Z");
    this._point = NaN;
  },
  point: function (x, y) {
    switch (this._point) {
      case 0:
        {
          this._string.push("M", x, ",", y);

          this._point = 1;
          break;
        }

      case 1:
        {
          this._string.push("L", x, ",", y);

          break;
        }

      default:
        {
          if (this._circle == null) this._circle = circle(this._radius);

          this._string.push("M", x, ",", y, this._circle);

          break;
        }
    }
  },
  result: function () {
    if (this._string.length) {
      var result = this._string.join("");

      this._string = [];
      return result;
    } else {
      return null;
    }
  }
};

function circle(radius) {
  return "m0," + radius + "a" + radius + "," + radius + " 0 1,1 0," + -2 * radius + "a" + radius + "," + radius + " 0 1,1 0," + 2 * radius + "z";
}
},{}],"node_modules/d3-geo/src/path/index.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _identity = _interopRequireDefault(require("../identity.js"));

var _stream = _interopRequireDefault(require("../stream.js"));

var _area = _interopRequireDefault(require("./area.js"));

var _bounds = _interopRequireDefault(require("./bounds.js"));

var _centroid = _interopRequireDefault(require("./centroid.js"));

var _context = _interopRequireDefault(require("./context.js"));

var _measure = _interopRequireDefault(require("./measure.js"));

var _string = _interopRequireDefault(require("./string.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(projection, context) {
  var pointRadius = 4.5,
      projectionStream,
      contextStream;

  function path(object) {
    if (object) {
      if (typeof pointRadius === "function") contextStream.pointRadius(+pointRadius.apply(this, arguments));
      (0, _stream.default)(object, projectionStream(contextStream));
    }

    return contextStream.result();
  }

  path.area = function (object) {
    (0, _stream.default)(object, projectionStream(_area.default));
    return _area.default.result();
  };

  path.measure = function (object) {
    (0, _stream.default)(object, projectionStream(_measure.default));
    return _measure.default.result();
  };

  path.bounds = function (object) {
    (0, _stream.default)(object, projectionStream(_bounds.default));
    return _bounds.default.result();
  };

  path.centroid = function (object) {
    (0, _stream.default)(object, projectionStream(_centroid.default));
    return _centroid.default.result();
  };

  path.projection = function (_) {
    return arguments.length ? (projectionStream = _ == null ? (projection = null, _identity.default) : (projection = _).stream, path) : projection;
  };

  path.context = function (_) {
    if (!arguments.length) return context;
    contextStream = _ == null ? (context = null, new _string.default()) : new _context.default(context = _);
    if (typeof pointRadius !== "function") contextStream.pointRadius(pointRadius);
    return path;
  };

  path.pointRadius = function (_) {
    if (!arguments.length) return pointRadius;
    pointRadius = typeof _ === "function" ? _ : (contextStream.pointRadius(+_), +_);
    return path;
  };

  return path.projection(projection).context(context);
}
},{"../identity.js":"node_modules/d3-geo/src/identity.js","../stream.js":"node_modules/d3-geo/src/stream.js","./area.js":"node_modules/d3-geo/src/path/area.js","./bounds.js":"node_modules/d3-geo/src/path/bounds.js","./centroid.js":"node_modules/d3-geo/src/path/centroid.js","./context.js":"node_modules/d3-geo/src/path/context.js","./measure.js":"node_modules/d3-geo/src/path/measure.js","./string.js":"node_modules/d3-geo/src/path/string.js"}],"node_modules/d3-geo/src/transform.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;
exports.transformer = transformer;

function _default(methods) {
  return {
    stream: transformer(methods)
  };
}

function transformer(methods) {
  return function (stream) {
    var s = new TransformStream();

    for (var key in methods) s[key] = methods[key];

    s.stream = stream;
    return s;
  };
}

function TransformStream() {}

TransformStream.prototype = {
  constructor: TransformStream,
  point: function (x, y) {
    this.stream.point(x, y);
  },
  sphere: function () {
    this.stream.sphere();
  },
  lineStart: function () {
    this.stream.lineStart();
  },
  lineEnd: function () {
    this.stream.lineEnd();
  },
  polygonStart: function () {
    this.stream.polygonStart();
  },
  polygonEnd: function () {
    this.stream.polygonEnd();
  }
};
},{}],"node_modules/d3-geo/src/projection/fit.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.fitExtent = fitExtent;
exports.fitSize = fitSize;
exports.fitWidth = fitWidth;
exports.fitHeight = fitHeight;

var _stream = _interopRequireDefault(require("../stream.js"));

var _bounds = _interopRequireDefault(require("../path/bounds.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function fit(projection, fitBounds, object) {
  var clip = projection.clipExtent && projection.clipExtent();
  projection.scale(150).translate([0, 0]);
  if (clip != null) projection.clipExtent(null);
  (0, _stream.default)(object, projection.stream(_bounds.default));
  fitBounds(_bounds.default.result());
  if (clip != null) projection.clipExtent(clip);
  return projection;
}

function fitExtent(projection, extent, object) {
  return fit(projection, function (b) {
    var w = extent[1][0] - extent[0][0],
        h = extent[1][1] - extent[0][1],
        k = Math.min(w / (b[1][0] - b[0][0]), h / (b[1][1] - b[0][1])),
        x = +extent[0][0] + (w - k * (b[1][0] + b[0][0])) / 2,
        y = +extent[0][1] + (h - k * (b[1][1] + b[0][1])) / 2;
    projection.scale(150 * k).translate([x, y]);
  }, object);
}

function fitSize(projection, size, object) {
  return fitExtent(projection, [[0, 0], size], object);
}

function fitWidth(projection, width, object) {
  return fit(projection, function (b) {
    var w = +width,
        k = w / (b[1][0] - b[0][0]),
        x = (w - k * (b[1][0] + b[0][0])) / 2,
        y = -k * b[0][1];
    projection.scale(150 * k).translate([x, y]);
  }, object);
}

function fitHeight(projection, height, object) {
  return fit(projection, function (b) {
    var h = +height,
        k = h / (b[1][1] - b[0][1]),
        x = -k * b[0][0],
        y = (h - k * (b[1][1] + b[0][1])) / 2;
    projection.scale(150 * k).translate([x, y]);
  }, object);
}
},{"../stream.js":"node_modules/d3-geo/src/stream.js","../path/bounds.js":"node_modules/d3-geo/src/path/bounds.js"}],"node_modules/d3-geo/src/projection/resample.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _cartesian = require("../cartesian.js");

var _math = require("../math.js");

var _transform = require("../transform.js");

var maxDepth = 16,
    // maximum depth of subdivision
cosMinDistance = (0, _math.cos)(30 * _math.radians); // cos(minimum angular distance)

function _default(project, delta2) {
  return +delta2 ? resample(project, delta2) : resampleNone(project);
}

function resampleNone(project) {
  return (0, _transform.transformer)({
    point: function (x, y) {
      x = project(x, y);
      this.stream.point(x[0], x[1]);
    }
  });
}

function resample(project, delta2) {
  function resampleLineTo(x0, y0, lambda0, a0, b0, c0, x1, y1, lambda1, a1, b1, c1, depth, stream) {
    var dx = x1 - x0,
        dy = y1 - y0,
        d2 = dx * dx + dy * dy;

    if (d2 > 4 * delta2 && depth--) {
      var a = a0 + a1,
          b = b0 + b1,
          c = c0 + c1,
          m = (0, _math.sqrt)(a * a + b * b + c * c),
          phi2 = (0, _math.asin)(c /= m),
          lambda2 = (0, _math.abs)((0, _math.abs)(c) - 1) < _math.epsilon || (0, _math.abs)(lambda0 - lambda1) < _math.epsilon ? (lambda0 + lambda1) / 2 : (0, _math.atan2)(b, a),
          p = project(lambda2, phi2),
          x2 = p[0],
          y2 = p[1],
          dx2 = x2 - x0,
          dy2 = y2 - y0,
          dz = dy * dx2 - dx * dy2;

      if (dz * dz / d2 > delta2 // perpendicular projected distance
      || (0, _math.abs)((dx * dx2 + dy * dy2) / d2 - 0.5) > 0.3 // midpoint close to an end
      || a0 * a1 + b0 * b1 + c0 * c1 < cosMinDistance) {
        // angular distance
        resampleLineTo(x0, y0, lambda0, a0, b0, c0, x2, y2, lambda2, a /= m, b /= m, c, depth, stream);
        stream.point(x2, y2);
        resampleLineTo(x2, y2, lambda2, a, b, c, x1, y1, lambda1, a1, b1, c1, depth, stream);
      }
    }
  }

  return function (stream) {
    var lambda00, x00, y00, a00, b00, c00, // first point
    lambda0, x0, y0, a0, b0, c0; // previous point

    var resampleStream = {
      point: point,
      lineStart: lineStart,
      lineEnd: lineEnd,
      polygonStart: function () {
        stream.polygonStart();
        resampleStream.lineStart = ringStart;
      },
      polygonEnd: function () {
        stream.polygonEnd();
        resampleStream.lineStart = lineStart;
      }
    };

    function point(x, y) {
      x = project(x, y);
      stream.point(x[0], x[1]);
    }

    function lineStart() {
      x0 = NaN;
      resampleStream.point = linePoint;
      stream.lineStart();
    }

    function linePoint(lambda, phi) {
      var c = (0, _cartesian.cartesian)([lambda, phi]),
          p = project(lambda, phi);
      resampleLineTo(x0, y0, lambda0, a0, b0, c0, x0 = p[0], y0 = p[1], lambda0 = lambda, a0 = c[0], b0 = c[1], c0 = c[2], maxDepth, stream);
      stream.point(x0, y0);
    }

    function lineEnd() {
      resampleStream.point = point;
      stream.lineEnd();
    }

    function ringStart() {
      lineStart();
      resampleStream.point = ringPoint;
      resampleStream.lineEnd = ringEnd;
    }

    function ringPoint(lambda, phi) {
      linePoint(lambda00 = lambda, phi), x00 = x0, y00 = y0, a00 = a0, b00 = b0, c00 = c0;
      resampleStream.point = linePoint;
    }

    function ringEnd() {
      resampleLineTo(x0, y0, lambda0, a0, b0, c0, x00, y00, lambda00, a00, b00, c00, maxDepth, stream);
      resampleStream.lineEnd = lineEnd;
      lineEnd();
    }

    return resampleStream;
  };
}
},{"../cartesian.js":"node_modules/d3-geo/src/cartesian.js","../math.js":"node_modules/d3-geo/src/math.js","../transform.js":"node_modules/d3-geo/src/transform.js"}],"node_modules/d3-geo/src/projection/index.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = projection;
exports.projectionMutator = projectionMutator;

var _antimeridian = _interopRequireDefault(require("../clip/antimeridian.js"));

var _circle = _interopRequireDefault(require("../clip/circle.js"));

var _rectangle = _interopRequireDefault(require("../clip/rectangle.js"));

var _compose = _interopRequireDefault(require("../compose.js"));

var _identity = _interopRequireDefault(require("../identity.js"));

var _math = require("../math.js");

var _rotation = require("../rotation.js");

var _transform = require("../transform.js");

var _fit = require("./fit.js");

var _resample = _interopRequireDefault(require("./resample.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var transformRadians = (0, _transform.transformer)({
  point: function (x, y) {
    this.stream.point(x * _math.radians, y * _math.radians);
  }
});

function transformRotate(rotate) {
  return (0, _transform.transformer)({
    point: function (x, y) {
      var r = rotate(x, y);
      return this.stream.point(r[0], r[1]);
    }
  });
}

function scaleTranslate(k, dx, dy, sx, sy) {
  function transform(x, y) {
    x *= sx;
    y *= sy;
    return [dx + k * x, dy - k * y];
  }

  transform.invert = function (x, y) {
    return [(x - dx) / k * sx, (dy - y) / k * sy];
  };

  return transform;
}

function scaleTranslateRotate(k, dx, dy, sx, sy, alpha) {
  var cosAlpha = (0, _math.cos)(alpha),
      sinAlpha = (0, _math.sin)(alpha),
      a = cosAlpha * k,
      b = sinAlpha * k,
      ai = cosAlpha / k,
      bi = sinAlpha / k,
      ci = (sinAlpha * dy - cosAlpha * dx) / k,
      fi = (sinAlpha * dx + cosAlpha * dy) / k;

  function transform(x, y) {
    x *= sx;
    y *= sy;
    return [a * x - b * y + dx, dy - b * x - a * y];
  }

  transform.invert = function (x, y) {
    return [sx * (ai * x - bi * y + ci), sy * (fi - bi * x - ai * y)];
  };

  return transform;
}

function projection(project) {
  return projectionMutator(function () {
    return project;
  })();
}

function projectionMutator(projectAt) {
  var project,
      k = 150,
      // scale
  x = 480,
      y = 250,
      // translate
  lambda = 0,
      phi = 0,
      // center
  deltaLambda = 0,
      deltaPhi = 0,
      deltaGamma = 0,
      rotate,
      // pre-rotate
  alpha = 0,
      // post-rotate angle
  sx = 1,
      // reflectX
  sy = 1,
      // reflectX
  theta = null,
      preclip = _antimeridian.default,
      // pre-clip angle
  x0 = null,
      y0,
      x1,
      y1,
      postclip = _identity.default,
      // post-clip extent
  delta2 = 0.5,
      // precision
  projectResample,
      projectTransform,
      projectRotateTransform,
      cache,
      cacheStream;

  function projection(point) {
    return projectRotateTransform(point[0] * _math.radians, point[1] * _math.radians);
  }

  function invert(point) {
    point = projectRotateTransform.invert(point[0], point[1]);
    return point && [point[0] * _math.degrees, point[1] * _math.degrees];
  }

  projection.stream = function (stream) {
    return cache && cacheStream === stream ? cache : cache = transformRadians(transformRotate(rotate)(preclip(projectResample(postclip(cacheStream = stream)))));
  };

  projection.preclip = function (_) {
    return arguments.length ? (preclip = _, theta = undefined, reset()) : preclip;
  };

  projection.postclip = function (_) {
    return arguments.length ? (postclip = _, x0 = y0 = x1 = y1 = null, reset()) : postclip;
  };

  projection.clipAngle = function (_) {
    return arguments.length ? (preclip = +_ ? (0, _circle.default)(theta = _ * _math.radians) : (theta = null, _antimeridian.default), reset()) : theta * _math.degrees;
  };

  projection.clipExtent = function (_) {
    return arguments.length ? (postclip = _ == null ? (x0 = y0 = x1 = y1 = null, _identity.default) : (0, _rectangle.default)(x0 = +_[0][0], y0 = +_[0][1], x1 = +_[1][0], y1 = +_[1][1]), reset()) : x0 == null ? null : [[x0, y0], [x1, y1]];
  };

  projection.scale = function (_) {
    return arguments.length ? (k = +_, recenter()) : k;
  };

  projection.translate = function (_) {
    return arguments.length ? (x = +_[0], y = +_[1], recenter()) : [x, y];
  };

  projection.center = function (_) {
    return arguments.length ? (lambda = _[0] % 360 * _math.radians, phi = _[1] % 360 * _math.radians, recenter()) : [lambda * _math.degrees, phi * _math.degrees];
  };

  projection.rotate = function (_) {
    return arguments.length ? (deltaLambda = _[0] % 360 * _math.radians, deltaPhi = _[1] % 360 * _math.radians, deltaGamma = _.length > 2 ? _[2] % 360 * _math.radians : 0, recenter()) : [deltaLambda * _math.degrees, deltaPhi * _math.degrees, deltaGamma * _math.degrees];
  };

  projection.angle = function (_) {
    return arguments.length ? (alpha = _ % 360 * _math.radians, recenter()) : alpha * _math.degrees;
  };

  projection.reflectX = function (_) {
    return arguments.length ? (sx = _ ? -1 : 1, recenter()) : sx < 0;
  };

  projection.reflectY = function (_) {
    return arguments.length ? (sy = _ ? -1 : 1, recenter()) : sy < 0;
  };

  projection.precision = function (_) {
    return arguments.length ? (projectResample = (0, _resample.default)(projectTransform, delta2 = _ * _), reset()) : (0, _math.sqrt)(delta2);
  };

  projection.fitExtent = function (extent, object) {
    return (0, _fit.fitExtent)(projection, extent, object);
  };

  projection.fitSize = function (size, object) {
    return (0, _fit.fitSize)(projection, size, object);
  };

  projection.fitWidth = function (width, object) {
    return (0, _fit.fitWidth)(projection, width, object);
  };

  projection.fitHeight = function (height, object) {
    return (0, _fit.fitHeight)(projection, height, object);
  };

  function recenter() {
    var center = scaleTranslateRotate(k, 0, 0, sx, sy, alpha).apply(null, project(lambda, phi)),
        transform = (alpha ? scaleTranslateRotate : scaleTranslate)(k, x - center[0], y - center[1], sx, sy, alpha);
    rotate = (0, _rotation.rotateRadians)(deltaLambda, deltaPhi, deltaGamma);
    projectTransform = (0, _compose.default)(project, transform);
    projectRotateTransform = (0, _compose.default)(rotate, projectTransform);
    projectResample = (0, _resample.default)(projectTransform, delta2);
    return reset();
  }

  function reset() {
    cache = cacheStream = null;
    return projection;
  }

  return function () {
    project = projectAt.apply(this, arguments);
    projection.invert = project.invert && invert;
    return recenter();
  };
}
},{"../clip/antimeridian.js":"node_modules/d3-geo/src/clip/antimeridian.js","../clip/circle.js":"node_modules/d3-geo/src/clip/circle.js","../clip/rectangle.js":"node_modules/d3-geo/src/clip/rectangle.js","../compose.js":"node_modules/d3-geo/src/compose.js","../identity.js":"node_modules/d3-geo/src/identity.js","../math.js":"node_modules/d3-geo/src/math.js","../rotation.js":"node_modules/d3-geo/src/rotation.js","../transform.js":"node_modules/d3-geo/src/transform.js","./fit.js":"node_modules/d3-geo/src/projection/fit.js","./resample.js":"node_modules/d3-geo/src/projection/resample.js"}],"node_modules/d3-geo/src/projection/conic.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.conicProjection = conicProjection;

var _math = require("../math.js");

var _index = require("./index.js");

function conicProjection(projectAt) {
  var phi0 = 0,
      phi1 = _math.pi / 3,
      m = (0, _index.projectionMutator)(projectAt),
      p = m(phi0, phi1);

  p.parallels = function (_) {
    return arguments.length ? m(phi0 = _[0] * _math.radians, phi1 = _[1] * _math.radians) : [phi0 * _math.degrees, phi1 * _math.degrees];
  };

  return p;
}
},{"../math.js":"node_modules/d3-geo/src/math.js","./index.js":"node_modules/d3-geo/src/projection/index.js"}],"node_modules/d3-geo/src/projection/cylindricalEqualArea.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.cylindricalEqualAreaRaw = cylindricalEqualAreaRaw;

var _math = require("../math.js");

function cylindricalEqualAreaRaw(phi0) {
  var cosPhi0 = (0, _math.cos)(phi0);

  function forward(lambda, phi) {
    return [lambda * cosPhi0, (0, _math.sin)(phi) / cosPhi0];
  }

  forward.invert = function (x, y) {
    return [x / cosPhi0, (0, _math.asin)(y * cosPhi0)];
  };

  return forward;
}
},{"../math.js":"node_modules/d3-geo/src/math.js"}],"node_modules/d3-geo/src/projection/conicEqualArea.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.conicEqualAreaRaw = conicEqualAreaRaw;
exports.default = _default;

var _math = require("../math.js");

var _conic = require("./conic.js");

var _cylindricalEqualArea = require("./cylindricalEqualArea.js");

function conicEqualAreaRaw(y0, y1) {
  var sy0 = (0, _math.sin)(y0),
      n = (sy0 + (0, _math.sin)(y1)) / 2; // Are the parallels symmetrical around the Equator?

  if ((0, _math.abs)(n) < _math.epsilon) return (0, _cylindricalEqualArea.cylindricalEqualAreaRaw)(y0);
  var c = 1 + sy0 * (2 * n - sy0),
      r0 = (0, _math.sqrt)(c) / n;

  function project(x, y) {
    var r = (0, _math.sqrt)(c - 2 * n * (0, _math.sin)(y)) / n;
    return [r * (0, _math.sin)(x *= n), r0 - r * (0, _math.cos)(x)];
  }

  project.invert = function (x, y) {
    var r0y = r0 - y,
        l = (0, _math.atan2)(x, (0, _math.abs)(r0y)) * (0, _math.sign)(r0y);
    if (r0y * n < 0) l -= _math.pi * (0, _math.sign)(x) * (0, _math.sign)(r0y);
    return [l / n, (0, _math.asin)((c - (x * x + r0y * r0y) * n * n) / (2 * n))];
  };

  return project;
}

function _default() {
  return (0, _conic.conicProjection)(conicEqualAreaRaw).scale(155.424).center([0, 33.6442]);
}
},{"../math.js":"node_modules/d3-geo/src/math.js","./conic.js":"node_modules/d3-geo/src/projection/conic.js","./cylindricalEqualArea.js":"node_modules/d3-geo/src/projection/cylindricalEqualArea.js"}],"node_modules/d3-geo/src/projection/albers.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _conicEqualArea = _interopRequireDefault(require("./conicEqualArea.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default() {
  return (0, _conicEqualArea.default)().parallels([29.5, 45.5]).scale(1070).translate([480, 250]).rotate([96, 0]).center([-0.6, 38.7]);
}
},{"./conicEqualArea.js":"node_modules/d3-geo/src/projection/conicEqualArea.js"}],"node_modules/d3-geo/src/projection/albersUsa.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _math = require("../math.js");

var _albers = _interopRequireDefault(require("./albers.js"));

var _conicEqualArea = _interopRequireDefault(require("./conicEqualArea.js"));

var _fit = require("./fit.js");

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

// The projections must have mutually exclusive clip regions on the sphere,
// as this will avoid emitting interleaving lines and polygons.
function multiplex(streams) {
  var n = streams.length;
  return {
    point: function (x, y) {
      var i = -1;

      while (++i < n) streams[i].point(x, y);
    },
    sphere: function () {
      var i = -1;

      while (++i < n) streams[i].sphere();
    },
    lineStart: function () {
      var i = -1;

      while (++i < n) streams[i].lineStart();
    },
    lineEnd: function () {
      var i = -1;

      while (++i < n) streams[i].lineEnd();
    },
    polygonStart: function () {
      var i = -1;

      while (++i < n) streams[i].polygonStart();
    },
    polygonEnd: function () {
      var i = -1;

      while (++i < n) streams[i].polygonEnd();
    }
  };
} // A composite projection for the United States, configured by default for
// 960×500. The projection also works quite well at 960×600 if you change the
// scale to 1285 and adjust the translate accordingly. The set of standard
// parallels for each region comes from USGS, which is published here:
// http://egsc.usgs.gov/isb/pubs/MapProjections/projections.html#albers


function _default() {
  var cache,
      cacheStream,
      lower48 = (0, _albers.default)(),
      lower48Point,
      alaska = (0, _conicEqualArea.default)().rotate([154, 0]).center([-2, 58.5]).parallels([55, 65]),
      alaskaPoint,
      // EPSG:3338
  hawaii = (0, _conicEqualArea.default)().rotate([157, 0]).center([-3, 19.9]).parallels([8, 18]),
      hawaiiPoint,
      // ESRI:102007
  point,
      pointStream = {
    point: function (x, y) {
      point = [x, y];
    }
  };

  function albersUsa(coordinates) {
    var x = coordinates[0],
        y = coordinates[1];
    return point = null, (lower48Point.point(x, y), point) || (alaskaPoint.point(x, y), point) || (hawaiiPoint.point(x, y), point);
  }

  albersUsa.invert = function (coordinates) {
    var k = lower48.scale(),
        t = lower48.translate(),
        x = (coordinates[0] - t[0]) / k,
        y = (coordinates[1] - t[1]) / k;
    return (y >= 0.120 && y < 0.234 && x >= -0.425 && x < -0.214 ? alaska : y >= 0.166 && y < 0.234 && x >= -0.214 && x < -0.115 ? hawaii : lower48).invert(coordinates);
  };

  albersUsa.stream = function (stream) {
    return cache && cacheStream === stream ? cache : cache = multiplex([lower48.stream(cacheStream = stream), alaska.stream(stream), hawaii.stream(stream)]);
  };

  albersUsa.precision = function (_) {
    if (!arguments.length) return lower48.precision();
    lower48.precision(_), alaska.precision(_), hawaii.precision(_);
    return reset();
  };

  albersUsa.scale = function (_) {
    if (!arguments.length) return lower48.scale();
    lower48.scale(_), alaska.scale(_ * 0.35), hawaii.scale(_);
    return albersUsa.translate(lower48.translate());
  };

  albersUsa.translate = function (_) {
    if (!arguments.length) return lower48.translate();
    var k = lower48.scale(),
        x = +_[0],
        y = +_[1];
    lower48Point = lower48.translate(_).clipExtent([[x - 0.455 * k, y - 0.238 * k], [x + 0.455 * k, y + 0.238 * k]]).stream(pointStream);
    alaskaPoint = alaska.translate([x - 0.307 * k, y + 0.201 * k]).clipExtent([[x - 0.425 * k + _math.epsilon, y + 0.120 * k + _math.epsilon], [x - 0.214 * k - _math.epsilon, y + 0.234 * k - _math.epsilon]]).stream(pointStream);
    hawaiiPoint = hawaii.translate([x - 0.205 * k, y + 0.212 * k]).clipExtent([[x - 0.214 * k + _math.epsilon, y + 0.166 * k + _math.epsilon], [x - 0.115 * k - _math.epsilon, y + 0.234 * k - _math.epsilon]]).stream(pointStream);
    return reset();
  };

  albersUsa.fitExtent = function (extent, object) {
    return (0, _fit.fitExtent)(albersUsa, extent, object);
  };

  albersUsa.fitSize = function (size, object) {
    return (0, _fit.fitSize)(albersUsa, size, object);
  };

  albersUsa.fitWidth = function (width, object) {
    return (0, _fit.fitWidth)(albersUsa, width, object);
  };

  albersUsa.fitHeight = function (height, object) {
    return (0, _fit.fitHeight)(albersUsa, height, object);
  };

  function reset() {
    cache = cacheStream = null;
    return albersUsa;
  }

  return albersUsa.scale(1070);
}
},{"../math.js":"node_modules/d3-geo/src/math.js","./albers.js":"node_modules/d3-geo/src/projection/albers.js","./conicEqualArea.js":"node_modules/d3-geo/src/projection/conicEqualArea.js","./fit.js":"node_modules/d3-geo/src/projection/fit.js"}],"node_modules/d3-geo/src/projection/azimuthal.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.azimuthalRaw = azimuthalRaw;
exports.azimuthalInvert = azimuthalInvert;

var _math = require("../math.js");

function azimuthalRaw(scale) {
  return function (x, y) {
    var cx = (0, _math.cos)(x),
        cy = (0, _math.cos)(y),
        k = scale(cx * cy);
    return [k * cy * (0, _math.sin)(x), k * (0, _math.sin)(y)];
  };
}

function azimuthalInvert(angle) {
  return function (x, y) {
    var z = (0, _math.sqrt)(x * x + y * y),
        c = angle(z),
        sc = (0, _math.sin)(c),
        cc = (0, _math.cos)(c);
    return [(0, _math.atan2)(x * sc, z * cc), (0, _math.asin)(z && y * sc / z)];
  };
}
},{"../math.js":"node_modules/d3-geo/src/math.js"}],"node_modules/d3-geo/src/projection/azimuthalEqualArea.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;
exports.azimuthalEqualAreaRaw = void 0;

var _math = require("../math.js");

var _azimuthal = require("./azimuthal.js");

var _index = _interopRequireDefault(require("./index.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var azimuthalEqualAreaRaw = (0, _azimuthal.azimuthalRaw)(function (cxcy) {
  return (0, _math.sqrt)(2 / (1 + cxcy));
});
exports.azimuthalEqualAreaRaw = azimuthalEqualAreaRaw;
azimuthalEqualAreaRaw.invert = (0, _azimuthal.azimuthalInvert)(function (z) {
  return 2 * (0, _math.asin)(z / 2);
});

function _default() {
  return (0, _index.default)(azimuthalEqualAreaRaw).scale(124.75).clipAngle(180 - 1e-3);
}
},{"../math.js":"node_modules/d3-geo/src/math.js","./azimuthal.js":"node_modules/d3-geo/src/projection/azimuthal.js","./index.js":"node_modules/d3-geo/src/projection/index.js"}],"node_modules/d3-geo/src/projection/azimuthalEquidistant.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;
exports.azimuthalEquidistantRaw = void 0;

var _math = require("../math.js");

var _azimuthal = require("./azimuthal.js");

var _index = _interopRequireDefault(require("./index.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var azimuthalEquidistantRaw = (0, _azimuthal.azimuthalRaw)(function (c) {
  return (c = (0, _math.acos)(c)) && c / (0, _math.sin)(c);
});
exports.azimuthalEquidistantRaw = azimuthalEquidistantRaw;
azimuthalEquidistantRaw.invert = (0, _azimuthal.azimuthalInvert)(function (z) {
  return z;
});

function _default() {
  return (0, _index.default)(azimuthalEquidistantRaw).scale(79.4188).clipAngle(180 - 1e-3);
}
},{"../math.js":"node_modules/d3-geo/src/math.js","./azimuthal.js":"node_modules/d3-geo/src/projection/azimuthal.js","./index.js":"node_modules/d3-geo/src/projection/index.js"}],"node_modules/d3-geo/src/projection/mercator.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.mercatorRaw = mercatorRaw;
exports.default = _default;
exports.mercatorProjection = mercatorProjection;

var _math = require("../math.js");

var _rotation = _interopRequireDefault(require("../rotation.js"));

var _index = _interopRequireDefault(require("./index.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function mercatorRaw(lambda, phi) {
  return [lambda, (0, _math.log)((0, _math.tan)((_math.halfPi + phi) / 2))];
}

mercatorRaw.invert = function (x, y) {
  return [x, 2 * (0, _math.atan)((0, _math.exp)(y)) - _math.halfPi];
};

function _default() {
  return mercatorProjection(mercatorRaw).scale(961 / _math.tau);
}

function mercatorProjection(project) {
  var m = (0, _index.default)(project),
      center = m.center,
      scale = m.scale,
      translate = m.translate,
      clipExtent = m.clipExtent,
      x0 = null,
      y0,
      x1,
      y1; // clip extent

  m.scale = function (_) {
    return arguments.length ? (scale(_), reclip()) : scale();
  };

  m.translate = function (_) {
    return arguments.length ? (translate(_), reclip()) : translate();
  };

  m.center = function (_) {
    return arguments.length ? (center(_), reclip()) : center();
  };

  m.clipExtent = function (_) {
    return arguments.length ? (_ == null ? x0 = y0 = x1 = y1 = null : (x0 = +_[0][0], y0 = +_[0][1], x1 = +_[1][0], y1 = +_[1][1]), reclip()) : x0 == null ? null : [[x0, y0], [x1, y1]];
  };

  function reclip() {
    var k = _math.pi * scale(),
        t = m((0, _rotation.default)(m.rotate()).invert([0, 0]));
    return clipExtent(x0 == null ? [[t[0] - k, t[1] - k], [t[0] + k, t[1] + k]] : project === mercatorRaw ? [[Math.max(t[0] - k, x0), y0], [Math.min(t[0] + k, x1), y1]] : [[x0, Math.max(t[1] - k, y0)], [x1, Math.min(t[1] + k, y1)]]);
  }

  return reclip();
}
},{"../math.js":"node_modules/d3-geo/src/math.js","../rotation.js":"node_modules/d3-geo/src/rotation.js","./index.js":"node_modules/d3-geo/src/projection/index.js"}],"node_modules/d3-geo/src/projection/conicConformal.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.conicConformalRaw = conicConformalRaw;
exports.default = _default;

var _math = require("../math.js");

var _conic = require("./conic.js");

var _mercator = require("./mercator.js");

function tany(y) {
  return (0, _math.tan)((_math.halfPi + y) / 2);
}

function conicConformalRaw(y0, y1) {
  var cy0 = (0, _math.cos)(y0),
      n = y0 === y1 ? (0, _math.sin)(y0) : (0, _math.log)(cy0 / (0, _math.cos)(y1)) / (0, _math.log)(tany(y1) / tany(y0)),
      f = cy0 * (0, _math.pow)(tany(y0), n) / n;
  if (!n) return _mercator.mercatorRaw;

  function project(x, y) {
    if (f > 0) {
      if (y < -_math.halfPi + _math.epsilon) y = -_math.halfPi + _math.epsilon;
    } else {
      if (y > _math.halfPi - _math.epsilon) y = _math.halfPi - _math.epsilon;
    }

    var r = f / (0, _math.pow)(tany(y), n);
    return [r * (0, _math.sin)(n * x), f - r * (0, _math.cos)(n * x)];
  }

  project.invert = function (x, y) {
    var fy = f - y,
        r = (0, _math.sign)(n) * (0, _math.sqrt)(x * x + fy * fy),
        l = (0, _math.atan2)(x, (0, _math.abs)(fy)) * (0, _math.sign)(fy);
    if (fy * n < 0) l -= _math.pi * (0, _math.sign)(x) * (0, _math.sign)(fy);
    return [l / n, 2 * (0, _math.atan)((0, _math.pow)(f / r, 1 / n)) - _math.halfPi];
  };

  return project;
}

function _default() {
  return (0, _conic.conicProjection)(conicConformalRaw).scale(109.5).parallels([30, 30]);
}
},{"../math.js":"node_modules/d3-geo/src/math.js","./conic.js":"node_modules/d3-geo/src/projection/conic.js","./mercator.js":"node_modules/d3-geo/src/projection/mercator.js"}],"node_modules/d3-geo/src/projection/equirectangular.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.equirectangularRaw = equirectangularRaw;
exports.default = _default;

var _index = _interopRequireDefault(require("./index.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function equirectangularRaw(lambda, phi) {
  return [lambda, phi];
}

equirectangularRaw.invert = equirectangularRaw;

function _default() {
  return (0, _index.default)(equirectangularRaw).scale(152.63);
}
},{"./index.js":"node_modules/d3-geo/src/projection/index.js"}],"node_modules/d3-geo/src/projection/conicEquidistant.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.conicEquidistantRaw = conicEquidistantRaw;
exports.default = _default;

var _math = require("../math.js");

var _conic = require("./conic.js");

var _equirectangular = require("./equirectangular.js");

function conicEquidistantRaw(y0, y1) {
  var cy0 = (0, _math.cos)(y0),
      n = y0 === y1 ? (0, _math.sin)(y0) : (cy0 - (0, _math.cos)(y1)) / (y1 - y0),
      g = cy0 / n + y0;
  if ((0, _math.abs)(n) < _math.epsilon) return _equirectangular.equirectangularRaw;

  function project(x, y) {
    var gy = g - y,
        nx = n * x;
    return [gy * (0, _math.sin)(nx), g - gy * (0, _math.cos)(nx)];
  }

  project.invert = function (x, y) {
    var gy = g - y,
        l = (0, _math.atan2)(x, (0, _math.abs)(gy)) * (0, _math.sign)(gy);
    if (gy * n < 0) l -= _math.pi * (0, _math.sign)(x) * (0, _math.sign)(gy);
    return [l / n, g - (0, _math.sign)(n) * (0, _math.sqrt)(x * x + gy * gy)];
  };

  return project;
}

function _default() {
  return (0, _conic.conicProjection)(conicEquidistantRaw).scale(131.154).center([0, 13.9389]);
}
},{"../math.js":"node_modules/d3-geo/src/math.js","./conic.js":"node_modules/d3-geo/src/projection/conic.js","./equirectangular.js":"node_modules/d3-geo/src/projection/equirectangular.js"}],"node_modules/d3-geo/src/projection/equalEarth.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.equalEarthRaw = equalEarthRaw;
exports.default = _default;

var _index = _interopRequireDefault(require("./index.js"));

var _math = require("../math.js");

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var A1 = 1.340264,
    A2 = -0.081106,
    A3 = 0.000893,
    A4 = 0.003796,
    M = (0, _math.sqrt)(3) / 2,
    iterations = 12;

function equalEarthRaw(lambda, phi) {
  var l = (0, _math.asin)(M * (0, _math.sin)(phi)),
      l2 = l * l,
      l6 = l2 * l2 * l2;
  return [lambda * (0, _math.cos)(l) / (M * (A1 + 3 * A2 * l2 + l6 * (7 * A3 + 9 * A4 * l2))), l * (A1 + A2 * l2 + l6 * (A3 + A4 * l2))];
}

equalEarthRaw.invert = function (x, y) {
  var l = y,
      l2 = l * l,
      l6 = l2 * l2 * l2;

  for (var i = 0, delta, fy, fpy; i < iterations; ++i) {
    fy = l * (A1 + A2 * l2 + l6 * (A3 + A4 * l2)) - y;
    fpy = A1 + 3 * A2 * l2 + l6 * (7 * A3 + 9 * A4 * l2);
    l -= delta = fy / fpy, l2 = l * l, l6 = l2 * l2 * l2;
    if ((0, _math.abs)(delta) < _math.epsilon2) break;
  }

  return [M * x * (A1 + 3 * A2 * l2 + l6 * (7 * A3 + 9 * A4 * l2)) / (0, _math.cos)(l), (0, _math.asin)((0, _math.sin)(l) / M)];
};

function _default() {
  return (0, _index.default)(equalEarthRaw).scale(177.158);
}
},{"./index.js":"node_modules/d3-geo/src/projection/index.js","../math.js":"node_modules/d3-geo/src/math.js"}],"node_modules/d3-geo/src/projection/gnomonic.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.gnomonicRaw = gnomonicRaw;
exports.default = _default;

var _math = require("../math.js");

var _azimuthal = require("./azimuthal.js");

var _index = _interopRequireDefault(require("./index.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function gnomonicRaw(x, y) {
  var cy = (0, _math.cos)(y),
      k = (0, _math.cos)(x) * cy;
  return [cy * (0, _math.sin)(x) / k, (0, _math.sin)(y) / k];
}

gnomonicRaw.invert = (0, _azimuthal.azimuthalInvert)(_math.atan);

function _default() {
  return (0, _index.default)(gnomonicRaw).scale(144.049).clipAngle(60);
}
},{"../math.js":"node_modules/d3-geo/src/math.js","./azimuthal.js":"node_modules/d3-geo/src/projection/azimuthal.js","./index.js":"node_modules/d3-geo/src/projection/index.js"}],"node_modules/d3-geo/src/projection/identity.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _rectangle = _interopRequireDefault(require("../clip/rectangle.js"));

var _identity = _interopRequireDefault(require("../identity.js"));

var _transform = require("../transform.js");

var _fit = require("./fit.js");

var _math = require("../math.js");

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default() {
  var k = 1,
      tx = 0,
      ty = 0,
      sx = 1,
      sy = 1,
      // scale, translate and reflect
  alpha = 0,
      ca,
      sa,
      // angle
  x0 = null,
      y0,
      x1,
      y1,
      // clip extent
  kx = 1,
      ky = 1,
      transform = (0, _transform.transformer)({
    point: function (x, y) {
      var p = projection([x, y]);
      this.stream.point(p[0], p[1]);
    }
  }),
      postclip = _identity.default,
      cache,
      cacheStream;

  function reset() {
    kx = k * sx;
    ky = k * sy;
    cache = cacheStream = null;
    return projection;
  }

  function projection(p) {
    var x = p[0] * kx,
        y = p[1] * ky;

    if (alpha) {
      var t = y * ca - x * sa;
      x = x * ca + y * sa;
      y = t;
    }

    return [x + tx, y + ty];
  }

  projection.invert = function (p) {
    var x = p[0] - tx,
        y = p[1] - ty;

    if (alpha) {
      var t = y * ca + x * sa;
      x = x * ca - y * sa;
      y = t;
    }

    return [x / kx, y / ky];
  };

  projection.stream = function (stream) {
    return cache && cacheStream === stream ? cache : cache = transform(postclip(cacheStream = stream));
  };

  projection.postclip = function (_) {
    return arguments.length ? (postclip = _, x0 = y0 = x1 = y1 = null, reset()) : postclip;
  };

  projection.clipExtent = function (_) {
    return arguments.length ? (postclip = _ == null ? (x0 = y0 = x1 = y1 = null, _identity.default) : (0, _rectangle.default)(x0 = +_[0][0], y0 = +_[0][1], x1 = +_[1][0], y1 = +_[1][1]), reset()) : x0 == null ? null : [[x0, y0], [x1, y1]];
  };

  projection.scale = function (_) {
    return arguments.length ? (k = +_, reset()) : k;
  };

  projection.translate = function (_) {
    return arguments.length ? (tx = +_[0], ty = +_[1], reset()) : [tx, ty];
  };

  projection.angle = function (_) {
    return arguments.length ? (alpha = _ % 360 * _math.radians, sa = (0, _math.sin)(alpha), ca = (0, _math.cos)(alpha), reset()) : alpha * _math.degrees;
  };

  projection.reflectX = function (_) {
    return arguments.length ? (sx = _ ? -1 : 1, reset()) : sx < 0;
  };

  projection.reflectY = function (_) {
    return arguments.length ? (sy = _ ? -1 : 1, reset()) : sy < 0;
  };

  projection.fitExtent = function (extent, object) {
    return (0, _fit.fitExtent)(projection, extent, object);
  };

  projection.fitSize = function (size, object) {
    return (0, _fit.fitSize)(projection, size, object);
  };

  projection.fitWidth = function (width, object) {
    return (0, _fit.fitWidth)(projection, width, object);
  };

  projection.fitHeight = function (height, object) {
    return (0, _fit.fitHeight)(projection, height, object);
  };

  return projection;
}
},{"../clip/rectangle.js":"node_modules/d3-geo/src/clip/rectangle.js","../identity.js":"node_modules/d3-geo/src/identity.js","../transform.js":"node_modules/d3-geo/src/transform.js","./fit.js":"node_modules/d3-geo/src/projection/fit.js","../math.js":"node_modules/d3-geo/src/math.js"}],"node_modules/d3-geo/src/projection/naturalEarth1.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.naturalEarth1Raw = naturalEarth1Raw;
exports.default = _default;

var _index = _interopRequireDefault(require("./index.js"));

var _math = require("../math.js");

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function naturalEarth1Raw(lambda, phi) {
  var phi2 = phi * phi,
      phi4 = phi2 * phi2;
  return [lambda * (0.8707 - 0.131979 * phi2 + phi4 * (-0.013791 + phi4 * (0.003971 * phi2 - 0.001529 * phi4))), phi * (1.007226 + phi2 * (0.015085 + phi4 * (-0.044475 + 0.028874 * phi2 - 0.005916 * phi4)))];
}

naturalEarth1Raw.invert = function (x, y) {
  var phi = y,
      i = 25,
      delta;

  do {
    var phi2 = phi * phi,
        phi4 = phi2 * phi2;
    phi -= delta = (phi * (1.007226 + phi2 * (0.015085 + phi4 * (-0.044475 + 0.028874 * phi2 - 0.005916 * phi4))) - y) / (1.007226 + phi2 * (0.015085 * 3 + phi4 * (-0.044475 * 7 + 0.028874 * 9 * phi2 - 0.005916 * 11 * phi4)));
  } while ((0, _math.abs)(delta) > _math.epsilon && --i > 0);

  return [x / (0.8707 + (phi2 = phi * phi) * (-0.131979 + phi2 * (-0.013791 + phi2 * phi2 * phi2 * (0.003971 - 0.001529 * phi2)))), phi];
};

function _default() {
  return (0, _index.default)(naturalEarth1Raw).scale(175.295);
}
},{"./index.js":"node_modules/d3-geo/src/projection/index.js","../math.js":"node_modules/d3-geo/src/math.js"}],"node_modules/d3-geo/src/projection/orthographic.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.orthographicRaw = orthographicRaw;
exports.default = _default;

var _math = require("../math.js");

var _azimuthal = require("./azimuthal.js");

var _index = _interopRequireDefault(require("./index.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function orthographicRaw(x, y) {
  return [(0, _math.cos)(y) * (0, _math.sin)(x), (0, _math.sin)(y)];
}

orthographicRaw.invert = (0, _azimuthal.azimuthalInvert)(_math.asin);

function _default() {
  return (0, _index.default)(orthographicRaw).scale(249.5).clipAngle(90 + _math.epsilon);
}
},{"../math.js":"node_modules/d3-geo/src/math.js","./azimuthal.js":"node_modules/d3-geo/src/projection/azimuthal.js","./index.js":"node_modules/d3-geo/src/projection/index.js"}],"node_modules/d3-geo/src/projection/stereographic.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.stereographicRaw = stereographicRaw;
exports.default = _default;

var _math = require("../math.js");

var _azimuthal = require("./azimuthal.js");

var _index = _interopRequireDefault(require("./index.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function stereographicRaw(x, y) {
  var cy = (0, _math.cos)(y),
      k = 1 + (0, _math.cos)(x) * cy;
  return [cy * (0, _math.sin)(x) / k, (0, _math.sin)(y) / k];
}

stereographicRaw.invert = (0, _azimuthal.azimuthalInvert)(function (z) {
  return 2 * (0, _math.atan)(z);
});

function _default() {
  return (0, _index.default)(stereographicRaw).scale(250).clipAngle(142);
}
},{"../math.js":"node_modules/d3-geo/src/math.js","./azimuthal.js":"node_modules/d3-geo/src/projection/azimuthal.js","./index.js":"node_modules/d3-geo/src/projection/index.js"}],"node_modules/d3-geo/src/projection/transverseMercator.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.transverseMercatorRaw = transverseMercatorRaw;
exports.default = _default;

var _math = require("../math.js");

var _mercator = require("./mercator.js");

function transverseMercatorRaw(lambda, phi) {
  return [(0, _math.log)((0, _math.tan)((_math.halfPi + phi) / 2)), -lambda];
}

transverseMercatorRaw.invert = function (x, y) {
  return [-y, 2 * (0, _math.atan)((0, _math.exp)(x)) - _math.halfPi];
};

function _default() {
  var m = (0, _mercator.mercatorProjection)(transverseMercatorRaw),
      center = m.center,
      rotate = m.rotate;

  m.center = function (_) {
    return arguments.length ? center([-_[1], _[0]]) : (_ = center(), [_[1], -_[0]]);
  };

  m.rotate = function (_) {
    return arguments.length ? rotate([_[0], _[1], _.length > 2 ? _[2] + 90 : 90]) : (_ = rotate(), [_[0], _[1], _[2] - 90]);
  };

  return rotate([0, 0, 90]).scale(159.155);
}
},{"../math.js":"node_modules/d3-geo/src/math.js","./mercator.js":"node_modules/d3-geo/src/projection/mercator.js"}],"node_modules/d3-geo/src/index.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
Object.defineProperty(exports, "geoArea", {
  enumerable: true,
  get: function () {
    return _area.default;
  }
});
Object.defineProperty(exports, "geoBounds", {
  enumerable: true,
  get: function () {
    return _bounds.default;
  }
});
Object.defineProperty(exports, "geoCentroid", {
  enumerable: true,
  get: function () {
    return _centroid.default;
  }
});
Object.defineProperty(exports, "geoCircle", {
  enumerable: true,
  get: function () {
    return _circle.default;
  }
});
Object.defineProperty(exports, "geoClipAntimeridian", {
  enumerable: true,
  get: function () {
    return _antimeridian.default;
  }
});
Object.defineProperty(exports, "geoClipCircle", {
  enumerable: true,
  get: function () {
    return _circle2.default;
  }
});
Object.defineProperty(exports, "geoClipExtent", {
  enumerable: true,
  get: function () {
    return _extent.default;
  }
});
Object.defineProperty(exports, "geoClipRectangle", {
  enumerable: true,
  get: function () {
    return _rectangle.default;
  }
});
Object.defineProperty(exports, "geoContains", {
  enumerable: true,
  get: function () {
    return _contains.default;
  }
});
Object.defineProperty(exports, "geoDistance", {
  enumerable: true,
  get: function () {
    return _distance.default;
  }
});
Object.defineProperty(exports, "geoGraticule", {
  enumerable: true,
  get: function () {
    return _graticule.default;
  }
});
Object.defineProperty(exports, "geoGraticule10", {
  enumerable: true,
  get: function () {
    return _graticule.graticule10;
  }
});
Object.defineProperty(exports, "geoInterpolate", {
  enumerable: true,
  get: function () {
    return _interpolate.default;
  }
});
Object.defineProperty(exports, "geoLength", {
  enumerable: true,
  get: function () {
    return _length.default;
  }
});
Object.defineProperty(exports, "geoPath", {
  enumerable: true,
  get: function () {
    return _index.default;
  }
});
Object.defineProperty(exports, "geoAlbers", {
  enumerable: true,
  get: function () {
    return _albers.default;
  }
});
Object.defineProperty(exports, "geoAlbersUsa", {
  enumerable: true,
  get: function () {
    return _albersUsa.default;
  }
});
Object.defineProperty(exports, "geoAzimuthalEqualArea", {
  enumerable: true,
  get: function () {
    return _azimuthalEqualArea.default;
  }
});
Object.defineProperty(exports, "geoAzimuthalEqualAreaRaw", {
  enumerable: true,
  get: function () {
    return _azimuthalEqualArea.azimuthalEqualAreaRaw;
  }
});
Object.defineProperty(exports, "geoAzimuthalEquidistant", {
  enumerable: true,
  get: function () {
    return _azimuthalEquidistant.default;
  }
});
Object.defineProperty(exports, "geoAzimuthalEquidistantRaw", {
  enumerable: true,
  get: function () {
    return _azimuthalEquidistant.azimuthalEquidistantRaw;
  }
});
Object.defineProperty(exports, "geoConicConformal", {
  enumerable: true,
  get: function () {
    return _conicConformal.default;
  }
});
Object.defineProperty(exports, "geoConicConformalRaw", {
  enumerable: true,
  get: function () {
    return _conicConformal.conicConformalRaw;
  }
});
Object.defineProperty(exports, "geoConicEqualArea", {
  enumerable: true,
  get: function () {
    return _conicEqualArea.default;
  }
});
Object.defineProperty(exports, "geoConicEqualAreaRaw", {
  enumerable: true,
  get: function () {
    return _conicEqualArea.conicEqualAreaRaw;
  }
});
Object.defineProperty(exports, "geoConicEquidistant", {
  enumerable: true,
  get: function () {
    return _conicEquidistant.default;
  }
});
Object.defineProperty(exports, "geoConicEquidistantRaw", {
  enumerable: true,
  get: function () {
    return _conicEquidistant.conicEquidistantRaw;
  }
});
Object.defineProperty(exports, "geoEqualEarth", {
  enumerable: true,
  get: function () {
    return _equalEarth.default;
  }
});
Object.defineProperty(exports, "geoEqualEarthRaw", {
  enumerable: true,
  get: function () {
    return _equalEarth.equalEarthRaw;
  }
});
Object.defineProperty(exports, "geoEquirectangular", {
  enumerable: true,
  get: function () {
    return _equirectangular.default;
  }
});
Object.defineProperty(exports, "geoEquirectangularRaw", {
  enumerable: true,
  get: function () {
    return _equirectangular.equirectangularRaw;
  }
});
Object.defineProperty(exports, "geoGnomonic", {
  enumerable: true,
  get: function () {
    return _gnomonic.default;
  }
});
Object.defineProperty(exports, "geoGnomonicRaw", {
  enumerable: true,
  get: function () {
    return _gnomonic.gnomonicRaw;
  }
});
Object.defineProperty(exports, "geoIdentity", {
  enumerable: true,
  get: function () {
    return _identity.default;
  }
});
Object.defineProperty(exports, "geoProjection", {
  enumerable: true,
  get: function () {
    return _index2.default;
  }
});
Object.defineProperty(exports, "geoProjectionMutator", {
  enumerable: true,
  get: function () {
    return _index2.projectionMutator;
  }
});
Object.defineProperty(exports, "geoMercator", {
  enumerable: true,
  get: function () {
    return _mercator.default;
  }
});
Object.defineProperty(exports, "geoMercatorRaw", {
  enumerable: true,
  get: function () {
    return _mercator.mercatorRaw;
  }
});
Object.defineProperty(exports, "geoNaturalEarth1", {
  enumerable: true,
  get: function () {
    return _naturalEarth.default;
  }
});
Object.defineProperty(exports, "geoNaturalEarth1Raw", {
  enumerable: true,
  get: function () {
    return _naturalEarth.naturalEarth1Raw;
  }
});
Object.defineProperty(exports, "geoOrthographic", {
  enumerable: true,
  get: function () {
    return _orthographic.default;
  }
});
Object.defineProperty(exports, "geoOrthographicRaw", {
  enumerable: true,
  get: function () {
    return _orthographic.orthographicRaw;
  }
});
Object.defineProperty(exports, "geoStereographic", {
  enumerable: true,
  get: function () {
    return _stereographic.default;
  }
});
Object.defineProperty(exports, "geoStereographicRaw", {
  enumerable: true,
  get: function () {
    return _stereographic.stereographicRaw;
  }
});
Object.defineProperty(exports, "geoTransverseMercator", {
  enumerable: true,
  get: function () {
    return _transverseMercator.default;
  }
});
Object.defineProperty(exports, "geoTransverseMercatorRaw", {
  enumerable: true,
  get: function () {
    return _transverseMercator.transverseMercatorRaw;
  }
});
Object.defineProperty(exports, "geoRotation", {
  enumerable: true,
  get: function () {
    return _rotation.default;
  }
});
Object.defineProperty(exports, "geoStream", {
  enumerable: true,
  get: function () {
    return _stream.default;
  }
});
Object.defineProperty(exports, "geoTransform", {
  enumerable: true,
  get: function () {
    return _transform.default;
  }
});

var _area = _interopRequireDefault(require("./area.js"));

var _bounds = _interopRequireDefault(require("./bounds.js"));

var _centroid = _interopRequireDefault(require("./centroid.js"));

var _circle = _interopRequireDefault(require("./circle.js"));

var _antimeridian = _interopRequireDefault(require("./clip/antimeridian.js"));

var _circle2 = _interopRequireDefault(require("./clip/circle.js"));

var _extent = _interopRequireDefault(require("./clip/extent.js"));

var _rectangle = _interopRequireDefault(require("./clip/rectangle.js"));

var _contains = _interopRequireDefault(require("./contains.js"));

var _distance = _interopRequireDefault(require("./distance.js"));

var _graticule = _interopRequireWildcard(require("./graticule.js"));

var _interpolate = _interopRequireDefault(require("./interpolate.js"));

var _length = _interopRequireDefault(require("./length.js"));

var _index = _interopRequireDefault(require("./path/index.js"));

var _albers = _interopRequireDefault(require("./projection/albers.js"));

var _albersUsa = _interopRequireDefault(require("./projection/albersUsa.js"));

var _azimuthalEqualArea = _interopRequireWildcard(require("./projection/azimuthalEqualArea.js"));

var _azimuthalEquidistant = _interopRequireWildcard(require("./projection/azimuthalEquidistant.js"));

var _conicConformal = _interopRequireWildcard(require("./projection/conicConformal.js"));

var _conicEqualArea = _interopRequireWildcard(require("./projection/conicEqualArea.js"));

var _conicEquidistant = _interopRequireWildcard(require("./projection/conicEquidistant.js"));

var _equalEarth = _interopRequireWildcard(require("./projection/equalEarth.js"));

var _equirectangular = _interopRequireWildcard(require("./projection/equirectangular.js"));

var _gnomonic = _interopRequireWildcard(require("./projection/gnomonic.js"));

var _identity = _interopRequireDefault(require("./projection/identity.js"));

var _index2 = _interopRequireWildcard(require("./projection/index.js"));

var _mercator = _interopRequireWildcard(require("./projection/mercator.js"));

var _naturalEarth = _interopRequireWildcard(require("./projection/naturalEarth1.js"));

var _orthographic = _interopRequireWildcard(require("./projection/orthographic.js"));

var _stereographic = _interopRequireWildcard(require("./projection/stereographic.js"));

var _transverseMercator = _interopRequireWildcard(require("./projection/transverseMercator.js"));

var _rotation = _interopRequireDefault(require("./rotation.js"));

var _stream = _interopRequireDefault(require("./stream.js"));

var _transform = _interopRequireDefault(require("./transform.js"));

function _getRequireWildcardCache() { if (typeof WeakMap !== "function") return null; var cache = new WeakMap(); _getRequireWildcardCache = function () { return cache; }; return cache; }

function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } if (obj === null || typeof obj !== "object" && typeof obj !== "function") { return { default: obj }; } var cache = _getRequireWildcardCache(); if (cache && cache.has(obj)) { return cache.get(obj); } var newObj = {}; var hasPropertyDescriptor = Object.defineProperty && Object.getOwnPropertyDescriptor; for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) { var desc = hasPropertyDescriptor ? Object.getOwnPropertyDescriptor(obj, key) : null; if (desc && (desc.get || desc.set)) { Object.defineProperty(newObj, key, desc); } else { newObj[key] = obj[key]; } } } newObj.default = obj; if (cache) { cache.set(obj, newObj); } return newObj; }

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }
},{"./area.js":"node_modules/d3-geo/src/area.js","./bounds.js":"node_modules/d3-geo/src/bounds.js","./centroid.js":"node_modules/d3-geo/src/centroid.js","./circle.js":"node_modules/d3-geo/src/circle.js","./clip/antimeridian.js":"node_modules/d3-geo/src/clip/antimeridian.js","./clip/circle.js":"node_modules/d3-geo/src/clip/circle.js","./clip/extent.js":"node_modules/d3-geo/src/clip/extent.js","./clip/rectangle.js":"node_modules/d3-geo/src/clip/rectangle.js","./contains.js":"node_modules/d3-geo/src/contains.js","./distance.js":"node_modules/d3-geo/src/distance.js","./graticule.js":"node_modules/d3-geo/src/graticule.js","./interpolate.js":"node_modules/d3-geo/src/interpolate.js","./length.js":"node_modules/d3-geo/src/length.js","./path/index.js":"node_modules/d3-geo/src/path/index.js","./projection/albers.js":"node_modules/d3-geo/src/projection/albers.js","./projection/albersUsa.js":"node_modules/d3-geo/src/projection/albersUsa.js","./projection/azimuthalEqualArea.js":"node_modules/d3-geo/src/projection/azimuthalEqualArea.js","./projection/azimuthalEquidistant.js":"node_modules/d3-geo/src/projection/azimuthalEquidistant.js","./projection/conicConformal.js":"node_modules/d3-geo/src/projection/conicConformal.js","./projection/conicEqualArea.js":"node_modules/d3-geo/src/projection/conicEqualArea.js","./projection/conicEquidistant.js":"node_modules/d3-geo/src/projection/conicEquidistant.js","./projection/equalEarth.js":"node_modules/d3-geo/src/projection/equalEarth.js","./projection/equirectangular.js":"node_modules/d3-geo/src/projection/equirectangular.js","./projection/gnomonic.js":"node_modules/d3-geo/src/projection/gnomonic.js","./projection/identity.js":"node_modules/d3-geo/src/projection/identity.js","./projection/index.js":"node_modules/d3-geo/src/projection/index.js","./projection/mercator.js":"node_modules/d3-geo/src/projection/mercator.js","./projection/naturalEarth1.js":"node_modules/d3-geo/src/projection/naturalEarth1.js","./projection/orthographic.js":"node_modules/d3-geo/src/projection/orthographic.js","./projection/stereographic.js":"node_modules/d3-geo/src/projection/stereographic.js","./projection/transverseMercator.js":"node_modules/d3-geo/src/projection/transverseMercator.js","./rotation.js":"node_modules/d3-geo/src/rotation.js","./stream.js":"node_modules/d3-geo/src/stream.js","./transform.js":"node_modules/d3-geo/src/transform.js"}],"node_modules/d3-array/src/ascending.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(a, b) {
  return a < b ? -1 : a > b ? 1 : a >= b ? 0 : NaN;
}
},{}],"node_modules/d3-array/src/bisector.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _ascending = _interopRequireDefault(require("./ascending.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(compare) {
  if (compare.length === 1) compare = ascendingComparator(compare);
  return {
    left: function (a, x, lo, hi) {
      if (lo == null) lo = 0;
      if (hi == null) hi = a.length;

      while (lo < hi) {
        var mid = lo + hi >>> 1;
        if (compare(a[mid], x) < 0) lo = mid + 1;else hi = mid;
      }

      return lo;
    },
    right: function (a, x, lo, hi) {
      if (lo == null) lo = 0;
      if (hi == null) hi = a.length;

      while (lo < hi) {
        var mid = lo + hi >>> 1;
        if (compare(a[mid], x) > 0) hi = mid;else lo = mid + 1;
      }

      return lo;
    }
  };
}

function ascendingComparator(f) {
  return function (d, x) {
    return (0, _ascending.default)(f(d), x);
  };
}
},{"./ascending.js":"node_modules/d3-array/src/ascending.js"}],"node_modules/d3-array/src/bisect.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = exports.bisectLeft = exports.bisectRight = void 0;

var _ascending = _interopRequireDefault(require("./ascending.js"));

var _bisector = _interopRequireDefault(require("./bisector.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var ascendingBisect = (0, _bisector.default)(_ascending.default);
var bisectRight = ascendingBisect.right;
exports.bisectRight = bisectRight;
var bisectLeft = ascendingBisect.left;
exports.bisectLeft = bisectLeft;
var _default = bisectRight;
exports.default = _default;
},{"./ascending.js":"node_modules/d3-array/src/ascending.js","./bisector.js":"node_modules/d3-array/src/bisector.js"}],"node_modules/d3-array/src/count.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = count;

function count(values, valueof) {
  let count = 0;

  if (valueof === undefined) {
    for (let value of values) {
      if (value != null && (value = +value) >= value) {
        ++count;
      }
    }
  } else {
    let index = -1;

    for (let value of values) {
      if ((value = valueof(value, ++index, values)) != null && (value = +value) >= value) {
        ++count;
      }
    }
  }

  return count;
}
},{}],"node_modules/d3-array/src/cross.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = cross;

function length(array) {
  return array.length | 0;
}

function empty(length) {
  return !(length > 0);
}

function arrayify(values) {
  return typeof values !== "object" || "length" in values ? values : Array.from(values);
}

function reducer(reduce) {
  return values => reduce(...values);
}

function cross(...values) {
  const reduce = typeof values[values.length - 1] === "function" && reducer(values.pop());
  values = values.map(arrayify);
  const lengths = values.map(length);
  const j = values.length - 1;
  const index = new Array(j + 1).fill(0);
  const product = [];
  if (j < 0 || lengths.some(empty)) return product;

  while (true) {
    product.push(index.map((j, i) => values[i][j]));
    let i = j;

    while (++index[i] === lengths[i]) {
      if (i === 0) return reduce ? product.map(reduce) : product;
      index[i--] = 0;
    }
  }
}
},{}],"node_modules/d3-array/src/cumsum.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = cumsum;

function cumsum(values, valueof) {
  var sum = 0,
      index = 0;
  return Float64Array.from(values, valueof === undefined ? v => sum += +v || 0 : v => sum += +valueof(v, index++, values) || 0);
}
},{}],"node_modules/d3-array/src/descending.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(a, b) {
  return b < a ? -1 : b > a ? 1 : b >= a ? 0 : NaN;
}
},{}],"node_modules/d3-array/src/variance.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = variance;

function variance(values, valueof) {
  let count = 0;
  let delta;
  let mean = 0;
  let sum = 0;

  if (valueof === undefined) {
    for (let value of values) {
      if (value != null && (value = +value) >= value) {
        delta = value - mean;
        mean += delta / ++count;
        sum += delta * (value - mean);
      }
    }
  } else {
    let index = -1;

    for (let value of values) {
      if ((value = valueof(value, ++index, values)) != null && (value = +value) >= value) {
        delta = value - mean;
        mean += delta / ++count;
        sum += delta * (value - mean);
      }
    }
  }

  if (count > 1) return sum / (count - 1);
}
},{}],"node_modules/d3-array/src/deviation.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = deviation;

var _variance = _interopRequireDefault(require("./variance.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function deviation(values, valueof) {
  const v = (0, _variance.default)(values, valueof);
  return v ? Math.sqrt(v) : v;
}
},{"./variance.js":"node_modules/d3-array/src/variance.js"}],"node_modules/d3-array/src/extent.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(values, valueof) {
  let min;
  let max;

  if (valueof === undefined) {
    for (const value of values) {
      if (value != null) {
        if (min === undefined) {
          if (value >= value) min = max = value;
        } else {
          if (min > value) min = value;
          if (max < value) max = value;
        }
      }
    }
  } else {
    let index = -1;

    for (let value of values) {
      if ((value = valueof(value, ++index, values)) != null) {
        if (min === undefined) {
          if (value >= value) min = max = value;
        } else {
          if (min > value) min = value;
          if (max < value) max = value;
        }
      }
    }
  }

  return [min, max];
}
},{}],"node_modules/d3-array/src/identity.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(x) {
  return x;
}
},{}],"node_modules/d3-array/src/group.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = group;
exports.groups = groups;
exports.rollup = rollup;
exports.rollups = rollups;

var _identity = _interopRequireDefault(require("./identity.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function group(values, ...keys) {
  return nest(values, _identity.default, _identity.default, keys);
}

function groups(values, ...keys) {
  return nest(values, Array.from, _identity.default, keys);
}

function rollup(values, reduce, ...keys) {
  return nest(values, _identity.default, reduce, keys);
}

function rollups(values, reduce, ...keys) {
  return nest(values, Array.from, reduce, keys);
}

function nest(values, map, reduce, keys) {
  return function regroup(values, i) {
    if (i >= keys.length) return reduce(values);
    const groups = new Map();
    const keyof = keys[i++];
    let index = -1;

    for (const value of values) {
      const key = keyof(value, ++index, values);
      const group = groups.get(key);
      if (group) group.push(value);else groups.set(key, [value]);
    }

    for (const [key, values] of groups) {
      groups.set(key, regroup(values, i));
    }

    return map(groups);
  }(values, 0);
}
},{"./identity.js":"node_modules/d3-array/src/identity.js"}],"node_modules/d3-array/src/array.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.map = exports.slice = void 0;
var array = Array.prototype;
var slice = array.slice;
exports.slice = slice;
var map = array.map;
exports.map = map;
},{}],"node_modules/d3-array/src/constant.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(x) {
  return function () {
    return x;
  };
}
},{}],"node_modules/d3-array/src/range.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(start, stop, step) {
  start = +start, stop = +stop, step = (n = arguments.length) < 2 ? (stop = start, start = 0, 1) : n < 3 ? 1 : +step;
  var i = -1,
      n = Math.max(0, Math.ceil((stop - start) / step)) | 0,
      range = new Array(n);

  while (++i < n) {
    range[i] = start + i * step;
  }

  return range;
}
},{}],"node_modules/d3-array/src/ticks.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;
exports.tickIncrement = tickIncrement;
exports.tickStep = tickStep;
var e10 = Math.sqrt(50),
    e5 = Math.sqrt(10),
    e2 = Math.sqrt(2);

function _default(start, stop, count) {
  var reverse,
      i = -1,
      n,
      ticks,
      step;
  stop = +stop, start = +start, count = +count;
  if (start === stop && count > 0) return [start];
  if (reverse = stop < start) n = start, start = stop, stop = n;
  if ((step = tickIncrement(start, stop, count)) === 0 || !isFinite(step)) return [];

  if (step > 0) {
    start = Math.ceil(start / step);
    stop = Math.floor(stop / step);
    ticks = new Array(n = Math.ceil(stop - start + 1));

    while (++i < n) ticks[i] = (start + i) * step;
  } else {
    start = Math.floor(start * step);
    stop = Math.ceil(stop * step);
    ticks = new Array(n = Math.ceil(start - stop + 1));

    while (++i < n) ticks[i] = (start - i) / step;
  }

  if (reverse) ticks.reverse();
  return ticks;
}

function tickIncrement(start, stop, count) {
  var step = (stop - start) / Math.max(0, count),
      power = Math.floor(Math.log(step) / Math.LN10),
      error = step / Math.pow(10, power);
  return power >= 0 ? (error >= e10 ? 10 : error >= e5 ? 5 : error >= e2 ? 2 : 1) * Math.pow(10, power) : -Math.pow(10, -power) / (error >= e10 ? 10 : error >= e5 ? 5 : error >= e2 ? 2 : 1);
}

function tickStep(start, stop, count) {
  var step0 = Math.abs(stop - start) / Math.max(0, count),
      step1 = Math.pow(10, Math.floor(Math.log(step0) / Math.LN10)),
      error = step0 / step1;
  if (error >= e10) step1 *= 10;else if (error >= e5) step1 *= 5;else if (error >= e2) step1 *= 2;
  return stop < start ? -step1 : step1;
}
},{}],"node_modules/d3-array/src/threshold/sturges.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _count = _interopRequireDefault(require("../count.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(values) {
  return Math.ceil(Math.log((0, _count.default)(values)) / Math.LN2) + 1;
}
},{"../count.js":"node_modules/d3-array/src/count.js"}],"node_modules/d3-array/src/bin.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _array = require("./array.js");

var _bisect = _interopRequireDefault(require("./bisect.js"));

var _constant = _interopRequireDefault(require("./constant.js"));

var _extent = _interopRequireDefault(require("./extent.js"));

var _identity = _interopRequireDefault(require("./identity.js"));

var _range = _interopRequireDefault(require("./range.js"));

var _ticks = require("./ticks.js");

var _sturges = _interopRequireDefault(require("./threshold/sturges.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default() {
  var value = _identity.default,
      domain = _extent.default,
      threshold = _sturges.default;

  function histogram(data) {
    if (!Array.isArray(data)) data = Array.from(data);
    var i,
        n = data.length,
        x,
        values = new Array(n);

    for (i = 0; i < n; ++i) {
      values[i] = value(data[i], i, data);
    }

    var xz = domain(values),
        x0 = xz[0],
        x1 = xz[1],
        tz = threshold(values, x0, x1); // Convert number of thresholds into uniform thresholds.

    if (!Array.isArray(tz)) {
      tz = (0, _ticks.tickStep)(x0, x1, tz);
      tz = (0, _range.default)(Math.ceil(x0 / tz) * tz, x1, tz); // exclusive
    } // Remove any thresholds outside the domain.


    var m = tz.length;

    while (tz[0] <= x0) tz.shift(), --m;

    while (tz[m - 1] > x1) tz.pop(), --m;

    var bins = new Array(m + 1),
        bin; // Initialize bins.

    for (i = 0; i <= m; ++i) {
      bin = bins[i] = [];
      bin.x0 = i > 0 ? tz[i - 1] : x0;
      bin.x1 = i < m ? tz[i] : x1;
    } // Assign data to bins by value, ignoring any outside the domain.


    for (i = 0; i < n; ++i) {
      x = values[i];

      if (x0 <= x && x <= x1) {
        bins[(0, _bisect.default)(tz, x, 0, m)].push(data[i]);
      }
    }

    return bins;
  }

  histogram.value = function (_) {
    return arguments.length ? (value = typeof _ === "function" ? _ : (0, _constant.default)(_), histogram) : value;
  };

  histogram.domain = function (_) {
    return arguments.length ? (domain = typeof _ === "function" ? _ : (0, _constant.default)([_[0], _[1]]), histogram) : domain;
  };

  histogram.thresholds = function (_) {
    return arguments.length ? (threshold = typeof _ === "function" ? _ : Array.isArray(_) ? (0, _constant.default)(_array.slice.call(_)) : (0, _constant.default)(_), histogram) : threshold;
  };

  return histogram;
}
},{"./array.js":"node_modules/d3-array/src/array.js","./bisect.js":"node_modules/d3-array/src/bisect.js","./constant.js":"node_modules/d3-array/src/constant.js","./extent.js":"node_modules/d3-array/src/extent.js","./identity.js":"node_modules/d3-array/src/identity.js","./range.js":"node_modules/d3-array/src/range.js","./ticks.js":"node_modules/d3-array/src/ticks.js","./threshold/sturges.js":"node_modules/d3-array/src/threshold/sturges.js"}],"node_modules/d3-array/src/max.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = max;

function max(values, valueof) {
  let max;

  if (valueof === undefined) {
    for (const value of values) {
      if (value != null && (max < value || max === undefined && value >= value)) {
        max = value;
      }
    }
  } else {
    let index = -1;

    for (let value of values) {
      if ((value = valueof(value, ++index, values)) != null && (max < value || max === undefined && value >= value)) {
        max = value;
      }
    }
  }

  return max;
}
},{}],"node_modules/d3-array/src/min.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = min;

function min(values, valueof) {
  let min;

  if (valueof === undefined) {
    for (const value of values) {
      if (value != null && (min > value || min === undefined && value >= value)) {
        min = value;
      }
    }
  } else {
    let index = -1;

    for (let value of values) {
      if ((value = valueof(value, ++index, values)) != null && (min > value || min === undefined && value >= value)) {
        min = value;
      }
    }
  }

  return min;
}
},{}],"node_modules/d3-array/src/quickselect.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = quickselect;

var _ascending = _interopRequireDefault(require("./ascending.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

// Based on https://github.com/mourner/quickselect
// ISC license, Copyright 2018 Vladimir Agafonkin.
function quickselect(array, k, left = 0, right = array.length - 1, compare = _ascending.default) {
  while (right > left) {
    if (right - left > 600) {
      const n = right - left + 1;
      const m = k - left + 1;
      const z = Math.log(n);
      const s = 0.5 * Math.exp(2 * z / 3);
      const sd = 0.5 * Math.sqrt(z * s * (n - s) / n) * (m - n / 2 < 0 ? -1 : 1);
      const newLeft = Math.max(left, Math.floor(k - m * s / n + sd));
      const newRight = Math.min(right, Math.floor(k + (n - m) * s / n + sd));
      quickselect(array, k, newLeft, newRight, compare);
    }

    const t = array[k];
    let i = left;
    let j = right;
    swap(array, left, k);
    if (compare(array[right], t) > 0) swap(array, left, right);

    while (i < j) {
      swap(array, i, j), ++i, --j;

      while (compare(array[i], t) < 0) ++i;

      while (compare(array[j], t) > 0) --j;
    }

    if (compare(array[left], t) === 0) swap(array, left, j);else ++j, swap(array, j, right);
    if (j <= k) left = j + 1;
    if (k <= j) right = j - 1;
  }

  return array;
}

function swap(array, i, j) {
  const t = array[i];
  array[i] = array[j];
  array[j] = t;
}
},{"./ascending.js":"node_modules/d3-array/src/ascending.js"}],"node_modules/d3-array/src/number.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;
exports.numbers = numbers;

function _default(x) {
  return x === null ? NaN : +x;
}

function* numbers(values, valueof) {
  if (valueof === undefined) {
    for (let value of values) {
      if (value != null && (value = +value) >= value) {
        yield value;
      }
    }
  } else {
    let index = -1;

    for (let value of values) {
      if ((value = valueof(value, ++index, values)) != null && (value = +value) >= value) {
        yield value;
      }
    }
  }
}
},{}],"node_modules/d3-array/src/quantile.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = quantile;
exports.quantileSorted = quantileSorted;

var _max = _interopRequireDefault(require("./max.js"));

var _min = _interopRequireDefault(require("./min.js"));

var _quickselect = _interopRequireDefault(require("./quickselect.js"));

var _number = _interopRequireWildcard(require("./number.js"));

function _getRequireWildcardCache() { if (typeof WeakMap !== "function") return null; var cache = new WeakMap(); _getRequireWildcardCache = function () { return cache; }; return cache; }

function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } if (obj === null || typeof obj !== "object" && typeof obj !== "function") { return { default: obj }; } var cache = _getRequireWildcardCache(); if (cache && cache.has(obj)) { return cache.get(obj); } var newObj = {}; var hasPropertyDescriptor = Object.defineProperty && Object.getOwnPropertyDescriptor; for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) { var desc = hasPropertyDescriptor ? Object.getOwnPropertyDescriptor(obj, key) : null; if (desc && (desc.get || desc.set)) { Object.defineProperty(newObj, key, desc); } else { newObj[key] = obj[key]; } } } newObj.default = obj; if (cache) { cache.set(obj, newObj); } return newObj; }

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function quantile(values, p, valueof) {
  values = Float64Array.from((0, _number.numbers)(values, valueof));
  if (!(n = values.length)) return;
  if ((p = +p) <= 0 || n < 2) return (0, _min.default)(values);
  if (p >= 1) return (0, _max.default)(values);
  var n,
      i = (n - 1) * p,
      i0 = Math.floor(i),
      value0 = (0, _max.default)((0, _quickselect.default)(values, i0).subarray(0, i0 + 1)),
      value1 = (0, _min.default)(values.subarray(i0 + 1));
  return value0 + (value1 - value0) * (i - i0);
}

function quantileSorted(values, p, valueof = _number.default) {
  if (!(n = values.length)) return;
  if ((p = +p) <= 0 || n < 2) return +valueof(values[0], 0, values);
  if (p >= 1) return +valueof(values[n - 1], n - 1, values);
  var n,
      i = (n - 1) * p,
      i0 = Math.floor(i),
      value0 = +valueof(values[i0], i0, values),
      value1 = +valueof(values[i0 + 1], i0 + 1, values);
  return value0 + (value1 - value0) * (i - i0);
}
},{"./max.js":"node_modules/d3-array/src/max.js","./min.js":"node_modules/d3-array/src/min.js","./quickselect.js":"node_modules/d3-array/src/quickselect.js","./number.js":"node_modules/d3-array/src/number.js"}],"node_modules/d3-array/src/threshold/freedmanDiaconis.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _count = _interopRequireDefault(require("../count.js"));

var _quantile = _interopRequireDefault(require("../quantile.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(values, min, max) {
  return Math.ceil((max - min) / (2 * ((0, _quantile.default)(values, 0.75) - (0, _quantile.default)(values, 0.25)) * Math.pow((0, _count.default)(values), -1 / 3)));
}
},{"../count.js":"node_modules/d3-array/src/count.js","../quantile.js":"node_modules/d3-array/src/quantile.js"}],"node_modules/d3-array/src/threshold/scott.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _count = _interopRequireDefault(require("../count.js"));

var _deviation = _interopRequireDefault(require("../deviation.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(values, min, max) {
  return Math.ceil((max - min) / (3.5 * (0, _deviation.default)(values) * Math.pow((0, _count.default)(values), -1 / 3)));
}
},{"../count.js":"node_modules/d3-array/src/count.js","../deviation.js":"node_modules/d3-array/src/deviation.js"}],"node_modules/d3-array/src/maxIndex.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = maxIndex;

function maxIndex(values, valueof) {
  let max;
  let maxIndex = -1;
  let index = -1;

  if (valueof === undefined) {
    for (const value of values) {
      ++index;

      if (value != null && (max < value || max === undefined && value >= value)) {
        max = value, maxIndex = index;
      }
    }
  } else {
    for (let value of values) {
      if ((value = valueof(value, ++index, values)) != null && (max < value || max === undefined && value >= value)) {
        max = value, maxIndex = index;
      }
    }
  }

  return maxIndex;
}
},{}],"node_modules/d3-array/src/mean.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = mean;

function mean(values, valueof) {
  let count = 0;
  let sum = 0;

  if (valueof === undefined) {
    for (let value of values) {
      if (value != null && (value = +value) >= value) {
        ++count, sum += value;
      }
    }
  } else {
    let index = -1;

    for (let value of values) {
      if ((value = valueof(value, ++index, values)) != null && (value = +value) >= value) {
        ++count, sum += value;
      }
    }
  }

  if (count) return sum / count;
}
},{}],"node_modules/d3-array/src/median.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _quantile = _interopRequireDefault(require("./quantile.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(values, valueof) {
  return (0, _quantile.default)(values, 0.5, valueof);
}
},{"./quantile.js":"node_modules/d3-array/src/quantile.js"}],"node_modules/d3-array/src/merge.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = merge;

function* flatten(arrays) {
  for (const array of arrays) {
    yield* array;
  }
}

function merge(arrays) {
  return Array.from(flatten(arrays));
}
},{}],"node_modules/d3-array/src/minIndex.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = minIndex;

function minIndex(values, valueof) {
  let min;
  let minIndex = -1;
  let index = -1;

  if (valueof === undefined) {
    for (const value of values) {
      ++index;

      if (value != null && (min > value || min === undefined && value >= value)) {
        min = value, minIndex = index;
      }
    }
  } else {
    for (let value of values) {
      if ((value = valueof(value, ++index, values)) != null && (min > value || min === undefined && value >= value)) {
        min = value, minIndex = index;
      }
    }
  }

  return minIndex;
}
},{}],"node_modules/d3-array/src/pairs.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = pairs;
exports.pair = pair;

function pairs(values, pairof = pair) {
  const pairs = [];
  let previous;
  let first = false;

  for (const value of values) {
    if (first) pairs.push(pairof(previous, value));
    previous = value;
    first = true;
  }

  return pairs;
}

function pair(a, b) {
  return [a, b];
}
},{}],"node_modules/d3-array/src/permute.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _default(source, keys) {
  return Array.from(keys, key => source[key]);
}
},{}],"node_modules/d3-array/src/least.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = least;

var _ascending = _interopRequireDefault(require("./ascending.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function least(values, compare = _ascending.default) {
  let min;
  let defined = false;

  if (compare.length === 1) {
    let minValue;

    for (const element of values) {
      const value = compare(element);

      if (defined ? (0, _ascending.default)(value, minValue) < 0 : (0, _ascending.default)(value, value) === 0) {
        min = element;
        minValue = value;
        defined = true;
      }
    }
  } else {
    for (const value of values) {
      if (defined ? compare(value, min) < 0 : compare(value, value) === 0) {
        min = value;
        defined = true;
      }
    }
  }

  return min;
}
},{"./ascending.js":"node_modules/d3-array/src/ascending.js"}],"node_modules/d3-array/src/leastIndex.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = leastIndex;

var _ascending = _interopRequireDefault(require("./ascending.js"));

var _minIndex = _interopRequireDefault(require("./minIndex.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function leastIndex(values, compare = _ascending.default) {
  if (compare.length === 1) return (0, _minIndex.default)(values, compare);
  let minValue;
  let min = -1;
  let index = -1;

  for (const value of values) {
    ++index;

    if (min < 0 ? compare(value, value) === 0 : compare(value, minValue) < 0) {
      minValue = value;
      min = index;
    }
  }

  return min;
}
},{"./ascending.js":"node_modules/d3-array/src/ascending.js","./minIndex.js":"node_modules/d3-array/src/minIndex.js"}],"node_modules/d3-array/src/greatest.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = greatest;

var _ascending = _interopRequireDefault(require("./ascending.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function greatest(values, compare = _ascending.default) {
  let max;
  let defined = false;

  if (compare.length === 1) {
    let maxValue;

    for (const element of values) {
      const value = compare(element);

      if (defined ? (0, _ascending.default)(value, maxValue) > 0 : (0, _ascending.default)(value, value) === 0) {
        max = element;
        maxValue = value;
        defined = true;
      }
    }
  } else {
    for (const value of values) {
      if (defined ? compare(value, max) > 0 : compare(value, value) === 0) {
        max = value;
        defined = true;
      }
    }
  }

  return max;
}
},{"./ascending.js":"node_modules/d3-array/src/ascending.js"}],"node_modules/d3-array/src/greatestIndex.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = greatestIndex;

var _ascending = _interopRequireDefault(require("./ascending.js"));

var _maxIndex = _interopRequireDefault(require("./maxIndex.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function greatestIndex(values, compare = _ascending.default) {
  if (compare.length === 1) return (0, _maxIndex.default)(values, compare);
  let maxValue;
  let max = -1;
  let index = -1;

  for (const value of values) {
    ++index;

    if (max < 0 ? compare(value, value) === 0 : compare(value, maxValue) > 0) {
      maxValue = value;
      max = index;
    }
  }

  return max;
}
},{"./ascending.js":"node_modules/d3-array/src/ascending.js","./maxIndex.js":"node_modules/d3-array/src/maxIndex.js"}],"node_modules/d3-array/src/scan.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = scan;

var _leastIndex = _interopRequireDefault(require("./leastIndex.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function scan(values, compare) {
  const index = (0, _leastIndex.default)(values, compare);
  return index < 0 ? undefined : index;
}
},{"./leastIndex.js":"node_modules/d3-array/src/leastIndex.js"}],"node_modules/d3-array/src/shuffle.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = shuffle;

function shuffle(array, i0 = 0, i1 = array.length) {
  var m = i1 - (i0 = +i0),
      t,
      i;

  while (m) {
    i = Math.random() * m-- | 0;
    t = array[m + i0];
    array[m + i0] = array[i + i0];
    array[i + i0] = t;
  }

  return array;
}
},{}],"node_modules/d3-array/src/sum.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = sum;

function sum(values, valueof) {
  let sum = 0;

  if (valueof === undefined) {
    for (let value of values) {
      if (value = +value) {
        sum += value;
      }
    }
  } else {
    let index = -1;

    for (let value of values) {
      if (value = +valueof(value, ++index, values)) {
        sum += value;
      }
    }
  }

  return sum;
}
},{}],"node_modules/d3-array/src/transpose.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _min = _interopRequireDefault(require("./min.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default(matrix) {
  if (!(n = matrix.length)) return [];

  for (var i = -1, m = (0, _min.default)(matrix, length), transpose = new Array(m); ++i < m;) {
    for (var j = -1, n, row = transpose[i] = new Array(n); ++j < n;) {
      row[j] = matrix[j][i];
    }
  }

  return transpose;
}

function length(d) {
  return d.length;
}
},{"./min.js":"node_modules/d3-array/src/min.js"}],"node_modules/d3-array/src/zip.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

var _transpose = _interopRequireDefault(require("./transpose.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _default() {
  return (0, _transpose.default)(arguments);
}
},{"./transpose.js":"node_modules/d3-array/src/transpose.js"}],"node_modules/d3-array/src/index.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
Object.defineProperty(exports, "bisect", {
  enumerable: true,
  get: function () {
    return _bisect.default;
  }
});
Object.defineProperty(exports, "bisectRight", {
  enumerable: true,
  get: function () {
    return _bisect.bisectRight;
  }
});
Object.defineProperty(exports, "bisectLeft", {
  enumerable: true,
  get: function () {
    return _bisect.bisectLeft;
  }
});
Object.defineProperty(exports, "ascending", {
  enumerable: true,
  get: function () {
    return _ascending.default;
  }
});
Object.defineProperty(exports, "bisector", {
  enumerable: true,
  get: function () {
    return _bisector.default;
  }
});
Object.defineProperty(exports, "count", {
  enumerable: true,
  get: function () {
    return _count.default;
  }
});
Object.defineProperty(exports, "cross", {
  enumerable: true,
  get: function () {
    return _cross.default;
  }
});
Object.defineProperty(exports, "cumsum", {
  enumerable: true,
  get: function () {
    return _cumsum.default;
  }
});
Object.defineProperty(exports, "descending", {
  enumerable: true,
  get: function () {
    return _descending.default;
  }
});
Object.defineProperty(exports, "deviation", {
  enumerable: true,
  get: function () {
    return _deviation.default;
  }
});
Object.defineProperty(exports, "extent", {
  enumerable: true,
  get: function () {
    return _extent.default;
  }
});
Object.defineProperty(exports, "group", {
  enumerable: true,
  get: function () {
    return _group.default;
  }
});
Object.defineProperty(exports, "groups", {
  enumerable: true,
  get: function () {
    return _group.groups;
  }
});
Object.defineProperty(exports, "rollup", {
  enumerable: true,
  get: function () {
    return _group.rollup;
  }
});
Object.defineProperty(exports, "rollups", {
  enumerable: true,
  get: function () {
    return _group.rollups;
  }
});
Object.defineProperty(exports, "bin", {
  enumerable: true,
  get: function () {
    return _bin.default;
  }
});
Object.defineProperty(exports, "histogram", {
  enumerable: true,
  get: function () {
    return _bin.default;
  }
});
Object.defineProperty(exports, "thresholdFreedmanDiaconis", {
  enumerable: true,
  get: function () {
    return _freedmanDiaconis.default;
  }
});
Object.defineProperty(exports, "thresholdScott", {
  enumerable: true,
  get: function () {
    return _scott.default;
  }
});
Object.defineProperty(exports, "thresholdSturges", {
  enumerable: true,
  get: function () {
    return _sturges.default;
  }
});
Object.defineProperty(exports, "max", {
  enumerable: true,
  get: function () {
    return _max.default;
  }
});
Object.defineProperty(exports, "maxIndex", {
  enumerable: true,
  get: function () {
    return _maxIndex.default;
  }
});
Object.defineProperty(exports, "mean", {
  enumerable: true,
  get: function () {
    return _mean.default;
  }
});
Object.defineProperty(exports, "median", {
  enumerable: true,
  get: function () {
    return _median.default;
  }
});
Object.defineProperty(exports, "merge", {
  enumerable: true,
  get: function () {
    return _merge.default;
  }
});
Object.defineProperty(exports, "min", {
  enumerable: true,
  get: function () {
    return _min.default;
  }
});
Object.defineProperty(exports, "minIndex", {
  enumerable: true,
  get: function () {
    return _minIndex.default;
  }
});
Object.defineProperty(exports, "pairs", {
  enumerable: true,
  get: function () {
    return _pairs.default;
  }
});
Object.defineProperty(exports, "permute", {
  enumerable: true,
  get: function () {
    return _permute.default;
  }
});
Object.defineProperty(exports, "quantile", {
  enumerable: true,
  get: function () {
    return _quantile.default;
  }
});
Object.defineProperty(exports, "quantileSorted", {
  enumerable: true,
  get: function () {
    return _quantile.quantileSorted;
  }
});
Object.defineProperty(exports, "quickselect", {
  enumerable: true,
  get: function () {
    return _quickselect.default;
  }
});
Object.defineProperty(exports, "range", {
  enumerable: true,
  get: function () {
    return _range.default;
  }
});
Object.defineProperty(exports, "least", {
  enumerable: true,
  get: function () {
    return _least.default;
  }
});
Object.defineProperty(exports, "leastIndex", {
  enumerable: true,
  get: function () {
    return _leastIndex.default;
  }
});
Object.defineProperty(exports, "greatest", {
  enumerable: true,
  get: function () {
    return _greatest.default;
  }
});
Object.defineProperty(exports, "greatestIndex", {
  enumerable: true,
  get: function () {
    return _greatestIndex.default;
  }
});
Object.defineProperty(exports, "scan", {
  enumerable: true,
  get: function () {
    return _scan.default;
  }
});
Object.defineProperty(exports, "shuffle", {
  enumerable: true,
  get: function () {
    return _shuffle.default;
  }
});
Object.defineProperty(exports, "sum", {
  enumerable: true,
  get: function () {
    return _sum.default;
  }
});
Object.defineProperty(exports, "ticks", {
  enumerable: true,
  get: function () {
    return _ticks.default;
  }
});
Object.defineProperty(exports, "tickIncrement", {
  enumerable: true,
  get: function () {
    return _ticks.tickIncrement;
  }
});
Object.defineProperty(exports, "tickStep", {
  enumerable: true,
  get: function () {
    return _ticks.tickStep;
  }
});
Object.defineProperty(exports, "transpose", {
  enumerable: true,
  get: function () {
    return _transpose.default;
  }
});
Object.defineProperty(exports, "variance", {
  enumerable: true,
  get: function () {
    return _variance.default;
  }
});
Object.defineProperty(exports, "zip", {
  enumerable: true,
  get: function () {
    return _zip.default;
  }
});

var _bisect = _interopRequireWildcard(require("./bisect.js"));

var _ascending = _interopRequireDefault(require("./ascending.js"));

var _bisector = _interopRequireDefault(require("./bisector.js"));

var _count = _interopRequireDefault(require("./count.js"));

var _cross = _interopRequireDefault(require("./cross.js"));

var _cumsum = _interopRequireDefault(require("./cumsum.js"));

var _descending = _interopRequireDefault(require("./descending.js"));

var _deviation = _interopRequireDefault(require("./deviation.js"));

var _extent = _interopRequireDefault(require("./extent.js"));

var _group = _interopRequireWildcard(require("./group.js"));

var _bin = _interopRequireDefault(require("./bin.js"));

var _freedmanDiaconis = _interopRequireDefault(require("./threshold/freedmanDiaconis.js"));

var _scott = _interopRequireDefault(require("./threshold/scott.js"));

var _sturges = _interopRequireDefault(require("./threshold/sturges.js"));

var _max = _interopRequireDefault(require("./max.js"));

var _maxIndex = _interopRequireDefault(require("./maxIndex.js"));

var _mean = _interopRequireDefault(require("./mean.js"));

var _median = _interopRequireDefault(require("./median.js"));

var _merge = _interopRequireDefault(require("./merge.js"));

var _min = _interopRequireDefault(require("./min.js"));

var _minIndex = _interopRequireDefault(require("./minIndex.js"));

var _pairs = _interopRequireDefault(require("./pairs.js"));

var _permute = _interopRequireDefault(require("./permute.js"));

var _quantile = _interopRequireWildcard(require("./quantile.js"));

var _quickselect = _interopRequireDefault(require("./quickselect.js"));

var _range = _interopRequireDefault(require("./range.js"));

var _least = _interopRequireDefault(require("./least.js"));

var _leastIndex = _interopRequireDefault(require("./leastIndex.js"));

var _greatest = _interopRequireDefault(require("./greatest.js"));

var _greatestIndex = _interopRequireDefault(require("./greatestIndex.js"));

var _scan = _interopRequireDefault(require("./scan.js"));

var _shuffle = _interopRequireDefault(require("./shuffle.js"));

var _sum = _interopRequireDefault(require("./sum.js"));

var _ticks = _interopRequireWildcard(require("./ticks.js"));

var _transpose = _interopRequireDefault(require("./transpose.js"));

var _variance = _interopRequireDefault(require("./variance.js"));

var _zip = _interopRequireDefault(require("./zip.js"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _getRequireWildcardCache() { if (typeof WeakMap !== "function") return null; var cache = new WeakMap(); _getRequireWildcardCache = function () { return cache; }; return cache; }

function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } if (obj === null || typeof obj !== "object" && typeof obj !== "function") { return { default: obj }; } var cache = _getRequireWildcardCache(); if (cache && cache.has(obj)) { return cache.get(obj); } var newObj = {}; var hasPropertyDescriptor = Object.defineProperty && Object.getOwnPropertyDescriptor; for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) { var desc = hasPropertyDescriptor ? Object.getOwnPropertyDescriptor(obj, key) : null; if (desc && (desc.get || desc.set)) { Object.defineProperty(newObj, key, desc); } else { newObj[key] = obj[key]; } } } newObj.default = obj; if (cache) { cache.set(obj, newObj); } return newObj; }
},{"./bisect.js":"node_modules/d3-array/src/bisect.js","./ascending.js":"node_modules/d3-array/src/ascending.js","./bisector.js":"node_modules/d3-array/src/bisector.js","./count.js":"node_modules/d3-array/src/count.js","./cross.js":"node_modules/d3-array/src/cross.js","./cumsum.js":"node_modules/d3-array/src/cumsum.js","./descending.js":"node_modules/d3-array/src/descending.js","./deviation.js":"node_modules/d3-array/src/deviation.js","./extent.js":"node_modules/d3-array/src/extent.js","./group.js":"node_modules/d3-array/src/group.js","./bin.js":"node_modules/d3-array/src/bin.js","./threshold/freedmanDiaconis.js":"node_modules/d3-array/src/threshold/freedmanDiaconis.js","./threshold/scott.js":"node_modules/d3-array/src/threshold/scott.js","./threshold/sturges.js":"node_modules/d3-array/src/threshold/sturges.js","./max.js":"node_modules/d3-array/src/max.js","./maxIndex.js":"node_modules/d3-array/src/maxIndex.js","./mean.js":"node_modules/d3-array/src/mean.js","./median.js":"node_modules/d3-array/src/median.js","./merge.js":"node_modules/d3-array/src/merge.js","./min.js":"node_modules/d3-array/src/min.js","./minIndex.js":"node_modules/d3-array/src/minIndex.js","./pairs.js":"node_modules/d3-array/src/pairs.js","./permute.js":"node_modules/d3-array/src/permute.js","./quantile.js":"node_modules/d3-array/src/quantile.js","./quickselect.js":"node_modules/d3-array/src/quickselect.js","./range.js":"node_modules/d3-array/src/range.js","./least.js":"node_modules/d3-array/src/least.js","./leastIndex.js":"node_modules/d3-array/src/leastIndex.js","./greatest.js":"node_modules/d3-array/src/greatest.js","./greatestIndex.js":"node_modules/d3-array/src/greatestIndex.js","./scan.js":"node_modules/d3-array/src/scan.js","./shuffle.js":"node_modules/d3-array/src/shuffle.js","./sum.js":"node_modules/d3-array/src/sum.js","./ticks.js":"node_modules/d3-array/src/ticks.js","./transpose.js":"node_modules/d3-array/src/transpose.js","./variance.js":"node_modules/d3-array/src/variance.js","./zip.js":"node_modules/d3-array/src/zip.js"}],"src/d3-geo-projection.v1.min.js":[function(require,module,exports) {
var define;
function _typeof(obj) { if (typeof Symbol === "function" && typeof Symbol.iterator === "symbol") { _typeof = function _typeof(obj) { return typeof obj; }; } else { _typeof = function _typeof(obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; }; } return _typeof(obj); }

// https://d3js.org/d3-geo-projection/ Version 1.2.3. Copyright 2017 Mike Bostock.
!function (n, r) {
  "object" == (typeof exports === "undefined" ? "undefined" : _typeof(exports)) && "undefined" != typeof module ? r(exports, require("d3-geo"), require("d3-array")) : "function" == typeof define && define.amd ? define(["exports", "d3-geo", "d3-array"], r) : r(n.d3 = n.d3 || {}, n.d3, n.d3);
}(this, function (n, r, e) {
  "use strict";

  function t(n) {
    return n ? n / Math.sin(n) : 1;
  }

  function o(n) {
    return n > 1 ? Yr : n < -1 ? -Yr : Math.asin(n);
  }

  function i(n) {
    return n > 1 ? 0 : n < -1 ? Xr : Math.acos(n);
  }

  function u(n) {
    return n > 0 ? Math.sqrt(n) : 0;
  }

  function a(n) {
    return ((n = Ir(2 * n)) - 1) / (n + 1);
  }

  function c(n) {
    return (Ir(n) - Ir(-n)) / 2;
  }

  function f(n) {
    return (Ir(n) + Ir(-n)) / 2;
  }

  function l(n) {
    return Tr(n + u(n * n + 1));
  }

  function g(n) {
    return Tr(n + u(n * n - 1));
  }

  function v(n) {
    function r(n, r) {
      var e = Hr(n),
          o = Hr(r),
          i = Kr(r),
          u = o * e,
          a = -((1 - u ? Tr((1 + u) / 2) / (1 - u) : -.5) + t / (1 + u));
      return [a * o * Kr(n), a * i];
    }

    var e = Or(n / 2),
        t = 2 * Tr(Hr(n / 2)) / (e * e);
    return r.invert = function (r, e) {
      var i,
          a = u(r * r + e * e),
          c = -n / 2,
          f = 50;
      if (!a) return [0, 0];

      do {
        var l = c / 2,
            g = Hr(l),
            v = Kr(l),
            s = Or(l),
            h = Tr(1 / g);
        c -= i = (2 / s * h - t * s - a) / (-h / (v * v) + 1 - t / (2 * g * g));
      } while (qr(i) > Ur && --f > 0);

      var p = Kr(c);
      return [Br(r * p, a * Hr(c)), o(e * p / a)];
    }, r;
  }

  function s(n, r) {
    var e = Hr(r),
        o = t(i(e * Hr(n /= 2)));
    return [2 * e * Kr(n) * o, Kr(r) * o];
  }

  function h(n) {
    function r(n, r) {
      var a = Hr(r),
          c = Hr(n /= 2);
      return [(1 + a) * Kr(n), (o * r > -Br(c, i) - .001 ? 0 : 10 * -o) + u + Kr(r) * t - (1 + a) * e * c];
    }

    var e = Kr(n),
        t = Hr(n),
        o = n >= 0 ? 1 : -1,
        i = Or(o * n),
        u = (1 + e - t) / 2;
    return r.invert = function (n, r) {
      var a = 0,
          c = 0,
          f = 50;

      do {
        var l = Hr(a),
            g = Kr(a),
            v = Hr(c),
            s = Kr(c),
            h = 1 + v,
            p = h * g - n,
            d = u + s * t - h * e * l - r,
            w = h * l / 2,
            P = -g * s,
            m = e * h * g / 2,
            y = t * v + e * l * s,
            R = P * m - y * w,
            j = (d * P - p * y) / R / 2,
            M = (p * m - d * w) / R;
        a -= j, c -= M;
      } while ((qr(j) > Ur || qr(M) > Ur) && --f > 0);

      return o * c > -Br(Hr(a), i) - .001 ? [2 * a, c] : null;
    }, r;
  }

  function p(n, r) {
    var e = Or(r / 2),
        t = u(1 - e * e),
        o = 1 + t * Hr(n /= 2),
        i = Kr(n) * t / o,
        a = e / o,
        c = i * i,
        f = a * a;
    return [4 / 3 * i * (3 + c - 3 * f), 4 / 3 * a * (3 + 3 * c - f)];
  }

  function d(n, r) {
    var e = qr(r);
    return e < Zr ? [n, Tr(Or(Zr + r / 2))] : [n * Hr(e) * (2 * ne - 1 / Kr(e)), _r(r) * (2 * ne * (e - Zr) - Tr(Or(e / 2)))];
  }

  function w(n) {
    function e(n, e) {
      var i = r.geoAzimuthalEquidistantRaw(n, e);

      if (qr(n) > Yr) {
        var a = Br(i[1], i[0]),
            c = u(i[0] * i[0] + i[1] * i[1]),
            f = t * Nr((a - Yr) / t) + Yr,
            l = Br(Kr(a -= f), 2 - Hr(a));
        a = f + o(Xr / c * Kr(l)) - l, i[0] = c * Hr(a), i[1] = c * Kr(a);
      }

      return i;
    }

    var t = 2 * Xr / n;
    return e.invert = function (n, e) {
      var o = u(n * n + e * e);

      if (o > Yr) {
        var a = Br(e, n),
            c = t * Nr((a - Yr) / t) + Yr,
            f = a > c ? -1 : 1,
            l = o * Hr(c - a),
            g = 1 / Or(f * i((l - Xr) / u(Xr * (Xr - 2 * l) + o * o)));
        a = c + 2 * xr((g + f * u(g * g - 3)) / 3), n = o * Hr(a), e = o * Kr(a);
      }

      return r.geoAzimuthalEquidistantRaw.invert(n, e);
    }, e;
  }

  function P(n, r) {
    var e,
        t = n * Kr(r),
        o = 30;

    do {
      r -= e = (r + Kr(r) - t) / (1 + Hr(r));
    } while (qr(e) > Ur && --o > 0);

    return r / 2;
  }

  function m(n, r, e) {
    function t(t, o) {
      return [n * t * Hr(o = P(e, o)), r * Kr(o)];
    }

    return t.invert = function (t, i) {
      return i = o(i / r), [t / (n * Hr(i)), o((2 * i + Kr(2 * i)) / e)];
    }, t;
  }

  function y(n, r) {
    var e = P(Xr, r);
    return [pe * n / (1 / Hr(r) + de / Hr(e)), (r + ne * Kr(e)) / pe];
  }

  function R(n, r) {
    return [n * Hr(r), r];
  }

  function j(n) {
    function r(r, t) {
      var o = e + n - t,
          i = o ? r * Hr(t) / o : o;
      return [o * Kr(i), e - o * Hr(i)];
    }

    if (!n) return R;
    var e = 1 / Or(n);
    return r.invert = function (r, t) {
      var o = u(r * r + (t = e - t) * t),
          i = e + n - o;
      return [o / Hr(i) * Br(r, t), i];
    }, r;
  }

  function M(n) {
    function r(r, e) {
      var t = Yr - e,
          o = t ? r * n * Kr(t) / t : t;
      return [t * Kr(o) / n, Yr - t * Hr(o)];
    }

    return r.invert = function (r, e) {
      var t = r * n,
          o = Yr - e,
          i = u(t * t + o * o),
          a = Br(t, o);
      return [(i ? i / Kr(i) : 1) * a / n, Yr - i];
    }, r;
  }

  function E(n, r, e, t, a, c) {
    var f,
        l = Hr(c);
    if (qr(n) > 1 || qr(c) > 1) f = i(e * a + r * t * l);else {
      var g = Kr(n / 2),
          v = Kr(c / 2);
      f = 2 * o(u(g * g + r * t * v * v));
    }
    return qr(f) > Ur ? [f, Br(t * Kr(c), r * a - e * t * l)] : [0, 0];
  }

  function b(n, r, e) {
    return i((n * n + r * r - e * e) / (2 * n * r));
  }

  function k(n) {
    return n - 2 * Xr * Wr((n + Xr) / (2 * Xr));
  }

  function S(n, r, e) {
    function t(n, r) {
      var e,
          t = Kr(r),
          o = Hr(r),
          u = new Array(3);

      for (e = 0; e < 3; ++e) {
        var a = i[e];
        if (u[e] = E(r - a[1], a[3], a[2], o, t, n - a[0]), !u[e][0]) return a.point;
        u[e][1] = k(u[e][1] - a.v[1]);
      }

      var c = g.slice();

      for (e = 0; e < 3; ++e) {
        var v = 2 == e ? 0 : e + 1,
            s = b(i[e].v[0], u[e][0], u[v][0]);
        u[e][1] < 0 && (s = -s), e ? 1 == e ? (s = f - s, c[0] -= u[e][0] * Hr(s), c[1] -= u[e][0] * Kr(s)) : (s = l - s, c[0] += u[e][0] * Hr(s), c[1] += u[e][0] * Kr(s)) : (c[0] += u[e][0] * Hr(s), c[1] -= u[e][0] * Kr(s));
      }

      return c[0] /= 3, c[1] /= 3, c;
    }

    for (var o, i = [[n[0], n[1], Kr(n[1]), Hr(n[1])], [r[0], r[1], Kr(r[1]), Hr(r[1])], [e[0], e[1], Kr(e[1]), Hr(e[1])]], u = i[2], a = 0; a < 3; ++a, u = o) {
      o = i[a], u.v = E(o[1] - u[1], u[3], u[2], o[3], o[2], o[0] - u[0]), u.point = [0, 0];
    }

    var c = b(i[0].v[0], i[2].v[0], i[1].v[0]),
        f = b(i[0].v[0], i[1].v[0], i[2].v[0]),
        l = Xr - c;
    i[2].point[1] = 0, i[0].point[0] = -(i[1].point[0] = i[0].v[0] / 2);
    var g = [i[2].point[0] = i[0].point[0] + i[2].v[0] * Hr(c), 2 * (i[0].point[1] = i[1].point[1] = i[2].v[0] * Kr(c))];
    return t;
  }

  function A(n) {
    return n[0] *= oe, n[1] *= oe, n;
  }

  function G() {
    return C([0, 22], [45, 22], [22.5, -22]).scale(380).center([22.5, 2]);
  }

  function C(n, e, t) {
    var o = r.geoCentroid({
      type: "MultiPoint",
      coordinates: [n, e, t]
    }),
        i = [-o[0], -o[1]],
        u = r.geoRotation(i),
        a = r.geoProjection(S(A(u(n)), A(u(e)), A(u(t)))).rotate(i),
        c = a.center;
    return delete a.rotate, a.center = function (n) {
      return arguments.length ? c(u(n)) : u.invert(c());
    }, a.clipAngle(90);
  }

  function z(n, r) {
    var e = u(1 - Kr(r));
    return [2 / re * n * e, re * (1 - e)];
  }

  function F(n) {
    function r(n, r) {
      return [n, (n ? n / Kr(n) : 1) * (Kr(r) * Hr(n) - e * Hr(r))];
    }

    var e = Or(n);
    return r.invert = e ? function (n, r) {
      n && (r *= Kr(n) / n);
      var t = Hr(n);
      return [n, 2 * Br(u(t * t + e * e - r * r) - t, e - r)];
    } : function (n, r) {
      return [n, o(n ? r * Or(n) / n : r)];
    }, r;
  }

  function L(n, r) {
    return [ke * n * (2 * Hr(2 * r / 3) - 1) / re, ke * re * Kr(r / 3)];
  }

  function q(n) {
    function r(n, r) {
      return [n * e, Kr(r) / e];
    }

    var e = Hr(n);
    return r.invert = function (n, r) {
      return [n / e, o(r * e)];
    }, r;
  }

  function x(n) {
    function r(n, r) {
      return [n * e, (1 + e) * Or(r / 2)];
    }

    var e = Hr(n);
    return r.invert = function (n, r) {
      return [n / e, 2 * xr(r / (1 + e))];
    }, r;
  }

  function B(n, r) {
    var e = u(8 / (3 * Xr));
    return [e * n * (1 - qr(r) / Xr), e * r];
  }

  function H(n, r) {
    var e = u(4 - 3 * Kr(qr(r)));
    return [2 / u(6 * Xr) * n * e, _r(r) * u(2 * Xr / 3) * (2 - e)];
  }

  function I(n, r) {
    var e = u(Xr * (4 + Xr));
    return [2 / e * n * (1 + u(1 - 4 * r * r / (Xr * Xr))), 4 / e * r];
  }

  function W(n, r) {
    var e = (2 + Yr) * Kr(r);
    r /= 2;

    for (var t = 0, o = 1 / 0; t < 10 && qr(o) > Ur; t++) {
      var i = Hr(r);
      r -= o = (r + Kr(r) * (i + 2) - e) / (2 * i * (1 + i));
    }

    return [2 / u(Xr * (4 + Xr)) * n * (1 + Hr(r)), 2 * u(Xr / (4 + Xr)) * Kr(r)];
  }

  function T(n, r) {
    return [n * (1 + Hr(r)) / u(2 + Xr), 2 * r / u(2 + Xr)];
  }

  function D(n, r) {
    for (var e = (1 + Yr) * Kr(r), t = 0, o = 1 / 0; t < 10 && qr(o) > Ur; t++) {
      r -= o = (r + Kr(r) - e) / (1 + Hr(r));
    }

    return e = u(2 + Xr), [n * (1 + Hr(r)) / e, 2 * r / e];
  }

  function Q(n, r) {
    var e = Kr(n /= 2),
        t = Hr(n),
        o = u(Hr(r)),
        i = Hr(r /= 2),
        a = Kr(r) / (i + ne * t * o),
        c = u(2 / (1 + a * a)),
        f = u((ne * i + (t + e) * o) / (ne * i + (t - e) * o));
    return [Be * (c * (f - 1 / f) - 2 * Tr(f)), Be * (c * a * (f + 1 / f) - 2 * xr(a))];
  }

  function V(n, r) {
    var e = Or(r / 2);
    return [n * Ie * u(1 - e * e), (1 + Ie) * e];
  }

  function N(n, r) {
    var e = r / 2,
        t = Hr(e);
    return [2 * n / re * Hr(r) * t * t, re * Or(e)];
  }

  function _(n) {
    return [n[0] / 2, o(Or(n[1] / 2 * oe)) * te];
  }

  function K(n) {
    return [2 * n[0], 2 * xr(Kr(n[1] * oe)) * te];
  }

  function O(n, e) {
    function t(e, t) {
      var a = r.geoAzimuthalEquidistantRaw(e, t),
          c = a[0],
          f = a[1],
          l = c * c + f * f;

      if (l > i) {
        var g = u(l),
            v = Br(f, c),
            s = o * Nr(v / o),
            h = v - s,
            p = n * Hr(h),
            d = (n * Kr(h) - h * Kr(p)) / (Yr - p),
            w = U(h, d),
            P = (Xr - n) / J(w, p, Xr);
        c = g;
        var m,
            y = 50;

        do {
          c -= m = (n + J(w, p, c) * P - g) / (w(c) * P);
        } while (qr(m) > Ur && --y > 0);

        f = h * Kr(c), c < Yr && (f -= d * (c - Yr));
        var R = Kr(s),
            j = Hr(s);
        a[0] = c * j - f * R, a[1] = c * R + f * j;
      }

      return a;
    }

    var o = 2 * Xr / e,
        i = n * n;
    return t.invert = function (e, t) {
      var a = e * e + t * t;

      if (a > i) {
        var c = u(a),
            f = Br(t, e),
            l = o * Nr(f / o),
            g = f - l;
        e = c * Hr(g), t = c * Kr(g);

        for (var v = e - Yr, s = Kr(e), h = t / s, p = e < Yr ? 1 / 0 : 0, d = 10;;) {
          var w = n * Kr(h),
              P = n * Hr(h),
              m = Kr(P),
              y = Yr - P,
              R = (w - h * m) / y,
              j = U(h, R);
          if (qr(p) < Jr || ! --d) break;
          h -= p = (h * s - R * v - t) / (s - 2 * v * (y * (P + h * w * Hr(P) - m) - w * (w - h * m)) / (y * y));
        }

        c = n + J(j, P, e) * (Xr - n) / J(j, P, Xr), f = l + h, e = c * Hr(f), t = c * Kr(f);
      }

      return r.geoAzimuthalEquidistantRaw.invert(e, t);
    }, t;
  }

  function U(n, r) {
    return function (e) {
      var t = n * Hr(e);
      return e < Yr && (t -= r), u(1 + t * t);
    };
  }

  function J(n, r, e) {
    for (var t = (e - r) / 50, o = n(r) + n(e), i = 1, u = r; i < 50; ++i) {
      o += 2 * n(u += t);
    }

    return .5 * o * t;
  }

  function X(n, r) {
    var e = n * n,
        t = r * r;
    return [n * (1 - .162388 * t) * (.87 - 952426e-9 * e * e), r * (1 + t / 12)];
  }

  function Y(n, r) {
    var e = _r(n),
        t = _r(r),
        i = Hr(r),
        u = Hr(n) * i,
        a = Kr(n) * i,
        c = Kr(t * r);

    n = qr(Br(a, c)), r = o(u), qr(n - Yr) > Ur && (n %= Yr);
    var f = Z(n > Xr / 4 ? Yr - n : n, r);
    return n > Xr / 4 && (c = f[0], f[0] = -f[1], f[1] = -c), f[0] *= e, f[1] *= -t, f;
  }

  function Z(n, r) {
    if (r === Yr) return [0, 0];
    var e,
        t,
        i = Kr(r),
        a = i * i,
        c = a * a,
        f = 1 + c,
        l = 1 + 3 * c,
        g = 1 - c,
        v = o(1 / u(f)),
        s = g + a * f * v,
        h = (1 - i) / s,
        p = u(h),
        d = h * f,
        w = u(d),
        P = p * g;
    if (0 === n) return [0, -(P + a * w)];
    var m,
        y = Hr(r),
        R = 1 / y,
        j = 2 * i * y,
        M = (-3 * a + v * l) * j,
        E = (-s * y - (1 - i) * M) / (s * s),
        b = .5 * E / p,
        k = g * b - 2 * a * p * j,
        S = a * f * E + h * l * j,
        A = -R * j,
        G = -R * S,
        C = -2 * R * k,
        z = 4 * n / Xr;

    if (n > .222 * Xr || r < Xr / 4 && n > .175 * Xr) {
      if (e = (P + a * u(d * (1 + c) - P * P)) / (1 + c), n > Xr / 4) return [e, e];
      var F = e,
          L = .5 * e;
      e = .5 * (L + F), t = 50;

      do {
        var q = u(d - e * e),
            x = e * (C + A * q) + G * o(e / w) - z;
        if (!x) break;
        x < 0 ? L = e : F = e, e = .5 * (L + F);
      } while (qr(F - L) > Ur && --t > 0);
    } else {
      e = Ur, t = 25;

      do {
        var B = e * e,
            H = u(d - B),
            I = C + A * H,
            W = e * I + G * o(e / w) - z,
            T = I + (G - A * B) / H;
        e -= m = H ? W / T : 0;
      } while (qr(m) > Ur && --t > 0);
    }

    return [e, -P - a * u(d - e * e)];
  }

  function $(n, r) {
    for (var e = 0, t = 1, i = .5, a = 50;;) {
      var c = i * i,
          f = u(i),
          l = o(1 / u(1 + c)),
          g = 1 - c + i * (1 + c) * l,
          v = (1 - f) / g,
          s = u(v),
          h = v * (1 + c),
          p = s * (1 - c),
          d = h - n * n,
          w = u(d),
          P = r + p + i * w;
      if (qr(t - e) < Jr || 0 == --a || 0 === P) break;
      P > 0 ? e = i : t = i, i = .5 * (e + t);
    }

    if (!a) return null;
    var m = o(f),
        y = Hr(m),
        R = 1 / y,
        j = 2 * f * y,
        M = (-3 * i + l * (1 + 3 * c)) * j,
        E = (-g * y - (1 - f) * M) / (g * g);
    return [Xr / 4 * (n * (-2 * R * (.5 * E / s * (1 - c) - 2 * i * s * j) + -R * j * w) + -R * (i * (1 + c) * E + v * (1 + 3 * c) * j) * o(n / u(h))), m];
  }

  function nn(n, r, e) {
    var t, o, i;
    return n ? (t = rn(n, e), r ? (o = rn(r, 1 - e), i = o[1] * o[1] + e * t[0] * t[0] * o[0] * o[0], [[t[0] * o[2] / i, t[1] * t[2] * o[0] * o[1] / i], [t[1] * o[1] / i, -t[0] * t[2] * o[0] * o[2] / i], [t[2] * o[1] * o[2] / i, -e * t[0] * t[1] * o[0] / i]]) : [[t[0], 0], [t[1], 0], [t[2], 0]]) : (o = rn(r, 1 - e), [[0, o[0] / o[1]], [1 / o[1], 0], [o[2] / o[1], 0]]);
  }

  function rn(n, r) {
    var e, t, i, l, g;
    if (r < Ur) return l = Kr(n), t = Hr(n), e = r * (n - l * t) / 4, [l - e * t, t + e * l, 1 - r * l * l / 2, n - e];
    if (r >= 1 - Ur) return e = (1 - r) / 4, t = f(n), l = a(n), i = 1 / t, g = t * c(n), [l + e * (g - n) / (t * t), i - e * l * i * (g - n), i + e * l * i * (g + n), 2 * xr(Ir(n)) - Yr + e * (g - n) / t];
    var v = [1, 0, 0, 0, 0, 0, 0, 0, 0],
        s = [u(r), 0, 0, 0, 0, 0, 0, 0, 0],
        h = 0;

    for (t = u(1 - r), g = 1; qr(s[h] / v[h]) > Ur && h < 8;) {
      e = v[h++], s[h] = (e - t) / 2, v[h] = (e + t) / 2, t = u(e * t), g *= 2;
    }

    i = g * v[h] * n;

    do {
      l = s[h] * Kr(t = i) / v[h], i = (o(l) + i) / 2;
    } while (--h);

    return [Kr(i), l = Hr(i), l / Hr(i - t), i];
  }

  function en(n, r, e) {
    var t = qr(n),
        o = qr(r),
        i = c(o);

    if (t) {
      var a = 1 / Kr(t),
          f = 1 / (Or(t) * Or(t)),
          l = -(f + e * (i * i * a * a) - 1 + e),
          g = (e - 1) * f,
          v = (-l + u(l * l - 4 * g)) / 2;
      return [tn(xr(1 / u(v)), e) * _r(n), tn(xr(u((v / f - 1) / e)), 1 - e) * _r(r)];
    }

    return [0, tn(xr(i), 1 - e) * _r(r)];
  }

  function tn(n, r) {
    if (!r) return n;
    if (1 === r) return Tr(Or(n / 2 + Zr));

    for (var e = 1, t = u(1 - r), o = u(r), i = 0; qr(o) > Ur; i++) {
      if (n % Xr) {
        var a = xr(t * Or(n) / e);
        a < 0 && (a += Xr), n += a + ~~(n / Xr) * Xr;
      } else n += n;

      o = (e + t) / 2, t = u(e * t), o = ((e = o) - t) / 2;
    }

    return n / (Vr(2, i) * e);
  }

  function on(n, r) {
    var e = (ne - 1) / (ne + 1),
        t = u(1 - e * e),
        o = tn(Yr, t * t),
        i = Tr(Or(Xr / 4 + qr(r) / 2)),
        a = Ir(-1 * i) / u(e),
        c = un(a * Hr(-1 * n), a * Kr(-1 * n)),
        f = en(c[0], c[1], t * t);
    return [-f[1], (r >= 0 ? 1 : -1) * (.5 * o - f[0])];
  }

  function un(n, r) {
    var e = n * n,
        t = r + 1,
        o = 1 - e - r * r;
    return [.5 * ((n >= 0 ? Yr : -Yr) - Br(o, 2 * n)), -.25 * Tr(o * o + 4 * e) + .5 * Tr(t * t + e)];
  }

  function an(n, r) {
    var e = r[0] * r[0] + r[1] * r[1];
    return [(n[0] * r[0] + n[1] * r[1]) / e, (n[1] * r[0] - n[0] * r[1]) / e];
  }

  function cn(n, e) {
    function t(t, o) {
      var i = r.geoAzimuthalEqualAreaRaw(t / e, o);
      return i[0] *= n, i;
    }

    return arguments.length < 2 && (e = n), 1 === e ? r.geoAzimuthalEqualAreaRaw : e === 1 / 0 ? fn : (t.invert = function (t, o) {
      var i = r.geoAzimuthalEqualAreaRaw.invert(t / n, o);
      return i[0] *= e, i;
    }, t);
  }

  function fn(n, r) {
    return [n * Hr(r) / Hr(r /= 2), 2 * Kr(r)];
  }

  function ln(n) {
    function r(n, r) {
      var u = o(n, r);
      n = u[0], r = u[1];
      var a = Kr(r),
          c = Hr(r),
          f = Hr(n),
          l = i(e * a + t * c * f),
          g = Kr(l),
          v = qr(g) > Ur ? l / g : 1;
      return [v * t * Kr(n), (qr(n) > Yr ? v : -v) * (e * c - t * a * f)];
    }

    var e = Kr(n),
        t = Hr(n),
        o = gn(n);
    return o.invert = gn(-n), r.invert = function (n, r) {
      var t = u(n * n + r * r),
          i = -Kr(t),
          a = Hr(t),
          c = t * a,
          f = -r * i,
          l = t * e,
          g = u(c * c + f * f - l * l),
          v = Br(c * l + f * g, f * l - c * g),
          s = (t > Yr ? -1 : 1) * Br(n * i, t * Hr(v) * a + r * Kr(v) * i);
      return o.invert(s, v);
    }, r;
  }

  function gn(n) {
    var r = Kr(n),
        e = Hr(n);
    return function (n, t) {
      var i = Hr(t),
          u = Hr(n) * i,
          a = Kr(n) * i,
          c = Kr(t);
      return [Br(a, u * e - c * r), o(c * e + u * r)];
    };
  }

  function vn(n) {
    function r(r, l) {
      var g,
          v = qr(l);

      if (v > e) {
        var s = Qr(n - 1, Dr(0, Wr((r + Xr) / a)));
        r += Xr * (n - 1) / n - s * a, g = z(r, v), g[0] = g[0] * ee / t - ee * (n - 1) / (2 * n) + s * ee / n, g[1] = o + 4 * (g[1] - i) * u / ee, l < 0 && (g[1] = -g[1]);
      } else g = it(r, l);

      return g[0] *= c, g[1] /= f, g;
    }

    var e = ot * oe,
        t = z(Xr, e)[0] - z(-Xr, e)[0],
        o = it(0, e)[1],
        i = z(0, e)[1],
        u = re - i,
        a = ee / n,
        c = 4 / ee,
        f = o + u * u * 4 / ee;
    return r.invert = function (r, e) {
      r /= c, e *= f;
      var l = qr(e);

      if (l > o) {
        var g = Qr(n - 1, Dr(0, Wr((r + Xr) / a)));
        r = (r + Xr * (n - 1) / n - g * a) * t / ee;
        var v = z.invert(r, .25 * (l - o) * ee / u + i);
        return v[0] -= Xr * (n - 1) / n - g * a, e < 0 && (v[1] = -v[1]), v;
      }

      return it.invert(r, e);
    }, r;
  }

  function sn(n) {
    return {
      type: "Polygon",
      coordinates: [e.range(-180, 180 + n / 2, n).map(function (n, r) {
        return [n, 1 & r ? 90 - 1e-6 : ot];
      }).concat(e.range(180, -180 - n / 2, -n).map(function (n, r) {
        return [n, 1 & r ? 1e-6 - 90 : -ot];
      }))]
    };
  }

  function hn(n) {
    function r(r, o) {
      var i,
          a,
          s = 1 - Kr(o);

      if (s && s < 2) {
        var h,
            p = Yr - o,
            d = 25;

        do {
          var w = Kr(p),
              P = Hr(p),
              m = c + Br(w, t - P),
              y = 1 + v - 2 * t * P;
          p -= h = (p - g * c - t * w + y * m - .5 * s * e) / (2 * t * w * m);
        } while (qr(h) > Jr && --d > 0);

        i = f * u(y), a = r * m / Xr;
      } else i = f * (n + s), a = r * c / Xr;

      return [i * Kr(a), l - i * Hr(a)];
    }

    var e,
        t = 1 + n,
        a = Kr(1 / t),
        c = o(a),
        f = 2 * u(Xr / (e = Xr + 4 * c * t)),
        l = .5 * f * (t + u(n * (2 + n))),
        g = n * n,
        v = t * t;
    return r.invert = function (n, r) {
      var a = n * n + (r -= l) * r,
          s = (1 + v - a / (f * f)) / (2 * t),
          h = i(s),
          p = Kr(h),
          d = c + Br(p, t - s);
      return [o(n / u(a)) * Xr / d, o(1 - 2 * (h - g * c - t * p + (1 + v - 2 * t * s) * d) / e)];
    }, r;
  }

  function pn(n, r) {
    return r > -ct ? (n = se(n, r), n[1] += ft, n) : R(n, r);
  }

  function dn(n, r) {
    return qr(r) > ct ? (n = se(n, r), n[1] -= r > 0 ? ft : -ft, n) : R(n, r);
  }

  function wn(n, r) {
    return qr(n[0] - r[0]) < Ur && qr(n[1] - r[1]) < Ur;
  }

  function Pn(n, r) {
    for (var e, t, o, i = -1, u = n.length, a = n[0], c = []; ++i < u;) {
      e = n[i], t = (e[0] - a[0]) / r, o = (e[1] - a[1]) / r;

      for (var f = 0; f < r; ++f) {
        c.push([a[0] + f * t, a[1] + f * o]);
      }

      a = e;
    }

    return c.push(e), c;
  }

  function mn(n) {
    var r,
        t,
        o,
        i,
        u,
        a,
        c,
        f = [],
        l = n[0].length;

    for (c = 0; c < l; ++c) {
      r = n[0][c], t = r[0][0], o = r[0][1], i = r[1][1], u = r[2][0], a = r[2][1], f.push(Pn([[t + Ur, o + Ur], [t + Ur, i - Ur], [u - Ur, i - Ur], [u - Ur, a + Ur]], 30));
    }

    for (c = n[1].length - 1; c >= 0; --c) {
      r = n[1][c], t = r[0][0], o = r[0][1], i = r[1][1], u = r[2][0], a = r[2][1], f.push(Pn([[u - Ur, a - Ur], [u - Ur, i + Ur], [t + Ur, i + Ur], [t + Ur, o - Ur]], 30));
    }

    return {
      type: "Polygon",
      coordinates: [e.merge(f)]
    };
  }

  function yn(n, r) {
    return [3 / ee * n * u(Xr * Xr / 3 - r * r), r];
  }

  function Rn(n) {
    function r(r, e) {
      if (qr(qr(e) - Yr) < Ur) return [0, e < 0 ? -2 : 2];
      var t = Kr(e),
          o = Vr((1 + t) / (1 - t), n / 2),
          i = .5 * (o + 1 / o) + Hr(r *= n);
      return [2 * Kr(r) / i, (o - 1 / o) / i];
    }

    return r.invert = function (r, e) {
      var t = qr(e);
      if (qr(t - 2) < Ur) return r ? null : [0, _r(e) * Yr];
      if (t > 2) return null;
      r /= 2, e /= 2;
      var i = r * r,
          u = e * e,
          a = 2 * e / (1 + i + u);
      return a = Vr((1 + a) / (1 - a), 1 / n), [Br(2 * r, 1 - i - u) / n, o((a - 1) / (a + 1))];
    }, r;
  }

  function jn(n, r) {
    return [n * (1 + u(Hr(r))) / 2, r / (Hr(r / 2) * Hr(n / 6))];
  }

  function Mn(n, r) {
    var e = n * n,
        t = r * r;
    return [n * (.975534 + t * (e * -.0143059 - .119161 + t * -.0547009)), r * (1.00384 + e * (.0802894 + t * -.02855 + 199025e-9 * e) + t * (.0998909 + t * -.0491032))];
  }

  function En(n, r) {
    return [Kr(n) / Hr(r), Or(r) * Hr(n)];
  }

  function bn(n) {
    function r(r, o) {
      var i = o - n,
          u = qr(i) < Ur ? r * e : qr(u = Zr + o / 2) < Ur || qr(qr(u) - Yr) < Ur ? 0 : r * i / Tr(Or(u) / t);
      return [u, i];
    }

    var e = Hr(n),
        t = Or(Zr + n / 2);
    return r.invert = function (r, o) {
      var i,
          u = o + n;
      return [qr(o) < Ur ? r / e : qr(i = Zr + u / 2) < Ur || qr(qr(i) - Yr) < Ur ? 0 : r * Tr(Or(i) / t) / o, u];
    }, r;
  }

  function kn(n, r) {
    return [n, 1.25 * Tr(Or(Zr + .4 * r))];
  }

  function Sn(n) {
    function r(r, t) {
      for (var o, i = Hr(t), u = 2 / (1 + i * Hr(r)), a = u * i * Kr(r), c = u * Kr(t), f = e, l = n[f], g = l[0], v = l[1]; --f >= 0;) {
        l = n[f], g = l[0] + a * (o = g) - c * v, v = l[1] + a * v + c * o;
      }

      return g = a * (o = g) - c * v, v = a * v + c * o, [g, v];
    }

    var e = n.length - 1;
    return r.invert = function (r, t) {
      var i = 20,
          a = r,
          c = t;

      do {
        for (var f, l = e, g = n[l], v = g[0], s = g[1], h = 0, p = 0; --l >= 0;) {
          g = n[l], h = v + a * (f = h) - c * p, p = s + a * p + c * f, v = g[0] + a * (f = v) - c * s, s = g[1] + a * s + c * f;
        }

        h = v + a * (f = h) - c * p, p = s + a * p + c * f, v = a * (f = v) - c * s - r, s = a * s + c * f - t;
        var d,
            w,
            P = h * h + p * p;
        a -= d = (v * h + s * p) / P, c -= w = (s * h - v * p) / P;
      } while (qr(d) + qr(w) > Ur * Ur && --i > 0);

      if (i) {
        var m = u(a * a + c * c),
            y = 2 * xr(.5 * m),
            R = Kr(y);
        return [Br(a * R, m * Hr(y)), m ? o(c * R / m) : 0];
      }
    }, r;
  }

  function An() {
    return Ln(Lt, [152, -64]).scale(1500).center([-160.908, 62.4864]).clipAngle(25);
  }

  function Gn() {
    return Ln(qt, [95, -38]).scale(1e3).clipAngle(55).center([-96.5563, 38.8675]);
  }

  function Cn() {
    return Ln(xt, [120, -45]).scale(359.513).clipAngle(55).center([-117.474, 53.0628]);
  }

  function zn() {
    return Ln(Bt, [-20, -18]).scale(209.091).center([20, 16.7214]).clipAngle(82);
  }

  function Fn() {
    return Ln(Ht, [165, 10]).scale(250).clipAngle(130).center([-165, -10]);
  }

  function Ln(n, e) {
    var t = r.geoProjection(Sn(n)).rotate(e).clipAngle(90),
        o = r.geoRotation(e),
        i = t.center;
    return delete t.rotate, t.center = function (n) {
      return arguments.length ? i(o(n)) : o.invert(i());
    }, t;
  }

  function qn(n, r) {
    var e = o(7 * Kr(r) / (3 * It));
    return [It * n * (2 * Hr(2 * e / 3) - 1) / Wt, 9 * Kr(e / 3) / Wt];
  }

  function xn(n, r) {
    for (var e, t = (1 + $r) * Kr(r), o = r, i = 0; i < 25 && (o -= e = (Kr(o / 2) + Kr(o) - t) / (.5 * Hr(o / 2) + Hr(o)), !(qr(e) < Ur)); i++) {
      ;
    }

    return [n * (1 + 2 * Hr(o) / Hr(o / 2)) / (3 * ne), 2 * u(3) * Kr(o / 2) / u(2 + ne)];
  }

  function Bn(n, r) {
    for (var e, t = u(6 / (4 + Xr)), o = (1 + Xr / 4) * Kr(r), i = r / 2, a = 0; a < 25 && (i -= e = (i / 2 + Kr(i) - o) / (.5 + Hr(i)), !(qr(e) < Ur)); a++) {
      ;
    }

    return [t * (.5 + Hr(i)) * n / 1.5, t * i];
  }

  function Hn(n, r) {
    var e = r * r,
        t = e * e;
    return [n * (.8707 - .131979 * e + t * (t * (.003971 * e - .001529 * t) - .013791)), r * (1.007226 + e * (.015085 + t * (.028874 * e - .044475 - .005916 * t)))];
  }

  function In(n, r) {
    return [n * (1 + Hr(r)) / 2, 2 * (r - Or(r / 2))];
  }

  function Wn(n, r) {
    var e = r * r;
    return [n, r * (_t + e * e * (Kt + e * (Ot + Ut * e)))];
  }

  function Tn(n, r) {
    if (qr(r) < Ur) return [n, 0];
    var e = Or(r),
        t = n * Kr(r);
    return [Kr(t) / e, r + (1 - Hr(t)) / e];
  }

  function Dn(n) {
    var r = 1 / (n[0] * n[4] - n[1] * n[3]);
    return [r * n[4], -r * n[1], r * (n[1] * n[5] - n[2] * n[4]), -r * n[3], r * n[0], r * (n[2] * n[3] - n[0] * n[5])];
  }

  function Qn(n, r) {
    return [n[0] * r[0] + n[1] * r[3], n[0] * r[1] + n[1] * r[4], n[0] * r[2] + n[1] * r[5] + n[2], n[3] * r[0] + n[4] * r[3], n[3] * r[1] + n[4] * r[4], n[3] * r[2] + n[4] * r[5] + n[5]];
  }

  function Vn(n, r) {
    return [n[0] - r[0], n[1] - r[1]];
  }

  function Nn(n) {
    return u(n[0] * n[0] + n[1] * n[1]);
  }

  function _n(n, r) {
    return Br(n[0] * r[1] - n[1] * r[0], n[0] * r[0] + n[1] * r[1]);
  }

  function Kn(n, e, t) {
    var o,
        i,
        u = e.edges,
        a = u.length,
        c = {
      type: "MultiPoint",
      coordinates: e.face
    },
        f = e.face.filter(function (n) {
      return 90 !== qr(n[1]);
    }),
        l = r.geoBounds({
      type: "MultiPoint",
      coordinates: f
    }),
        g = !1,
        v = -1,
        s = l[1][0] - l[0][0],
        h = 180 === s || 360 === s ? [(l[0][0] + l[1][0]) / 2, (l[0][1] + l[1][1]) / 2] : r.geoCentroid(c);
    if (t) for (; ++v < a && u[v] !== t;) {
      ;
    }
    ++v;

    for (var p = 0; p < a; ++p) {
      i = u[(p + v) % a], Array.isArray(i) ? (g || (n.point((o = r.geoInterpolate(i[0], h)(Ur))[0], o[1]), g = !0), n.point((o = r.geoInterpolate(i[1], h)(Ur))[0], o[1])) : (g = !1, i !== t && Kn(n, i, e));
    }
  }

  function On(n, r) {
    return n && r && n[0] === r[0] && n[1] === r[1];
  }

  function Un(n, r) {
    for (var e, t, o = n.length, i = null, u = 0; u < o; ++u) {
      e = n[u];

      for (var a = r.length; --a >= 0;) {
        if (t = r[a], e[0] === t[0] && e[1] === t[1]) {
          if (i) return [i, e];
          i = e;
        }
      }
    }
  }

  function Jn(n) {
    for (var r = n.length, e = [], t = n[r - 1], o = 0; o < r; ++o) {
      e.push([t, t = n[o]]);
    }

    return e;
  }

  function Xn(n) {
    return n.project.invert || n.children && n.children.some(Xn);
  }

  function Yn(n, r) {
    var e = z(n, r);
    return [e[0] * uo, e[1]];
  }

  function Zn(n, r) {
    for (var e = 0, t = n.length, o = 0; e < t; ++e) {
      o += n[e] * r[e];
    }

    return o;
  }

  function $n(n, r) {
    return [n[1] * r[2] - n[2] * r[1], n[2] * r[0] - n[0] * r[2], n[0] * r[1] - n[1] * r[0]];
  }

  function nr(n) {
    return [Br(n[1], n[0]) * te, o(Dr(-1, Qr(1, n[2]))) * te];
  }

  function rr(n) {
    var r = n[0] * oe,
        e = n[1] * oe,
        t = Hr(e);
    return [t * Hr(r), t * Kr(r), Kr(e)];
  }

  function er(n, r) {
    return {
      type: "FeatureCollection",
      features: n.features.map(function (n) {
        return tr(n, r);
      })
    };
  }

  function tr(n, r) {
    return {
      type: "Feature",
      id: n.id,
      properties: n.properties,
      geometry: ir(n.geometry, r)
    };
  }

  function or(n, r) {
    return {
      type: "GeometryCollection",
      geometries: n.geometries.map(function (n) {
        return ir(n, r);
      })
    };
  }

  function ir(n, e) {
    if (!n) return null;
    if ("GeometryCollection" === n.type) return or(n, e);
    var t;

    switch (n.type) {
      case "Point":
      case "MultiPoint":
        t = po;
        break;

      case "LineString":
      case "MultiLineString":
        t = wo;
        break;

      case "Polygon":
      case "MultiPolygon":
      case "Sphere":
        t = Po;
        break;

      default:
        return null;
    }

    return r.geoStream(n, e(t)), t.result();
  }

  function ur(n) {
    function r(r, t) {
      var o = e ? Or(r * e / 2) / e : r / 2;
      if (!t) return [2 * o, -n];
      var i = 2 * xr(o * Kr(t)),
          u = 1 / Or(t);
      return [Kr(i) * u, t + (1 - Hr(i)) * u - n];
    }

    var e = Kr(n);
    return r.invert = function (r, t) {
      if (qr(t += n) < Ur) return [e ? 2 * xr(e * r / 2) / e : r, 0];
      var u,
          a = r * r + t * t,
          c = 0,
          f = 10;

      do {
        var l = Or(c),
            g = 1 / Hr(c),
            v = a - 2 * t * c + c * c;
        c -= u = (l * v + 2 * (c - t)) / (2 + v * g * g + 2 * (c - t) * l);
      } while (qr(u) > Ur && --f > 0);

      var s = r * (l = Or(c)),
          h = Or(qr(t) < qr(c + 1 / l) ? .5 * o(s) : .5 * i(s) + Xr / 4) / Kr(c);
      return [e ? 2 * xr(e * h) / e : 2 * h, c];
    }, r;
  }

  function ar(n, r) {
    var e,
        t = Qr(18, 36 * qr(r) / Xr),
        o = Wr(t),
        i = t - o,
        u = (e = Eo[o])[0],
        a = e[1],
        c = (e = Eo[++o])[0],
        f = e[1],
        l = (e = Eo[Qr(19, ++o)])[0],
        g = e[1];
    return [n * (c + i * (l - u) / 2 + i * i * (l - 2 * c + u) / 2), (r > 0 ? Yr : -Yr) * (f + i * (g - a) / 2 + i * i * (g - 2 * f + a) / 2)];
  }

  function cr(n) {
    function r(r, e) {
      var t = Hr(e),
          o = (n - 1) / (n - t * Hr(r));
      return [o * t * Kr(r), o * Kr(e)];
    }

    return r.invert = function (r, e) {
      var t = r * r + e * e,
          i = u(t),
          a = (n - u(1 - t * (n + 1) / (n - 1))) / ((n - 1) / i + i / (n - 1));
      return [Br(r * a, i * u(1 - a * a)), i ? o(e * a / i) : 0];
    }, r;
  }

  function fr(n, r) {
    function e(r, e) {
      var u = t(r, e),
          a = u[1],
          c = a * i / (n - 1) + o;
      return [u[0] * o / c, a / c];
    }

    var t = cr(n);
    if (!r) return t;
    var o = Hr(r),
        i = Kr(r);
    return e.invert = function (r, e) {
      var u = (n - 1) / (n - 1 - e * i);
      return t.invert(u * r, u * e * o);
    }, e;
  }

  function lr(n) {
    return n.length > 0;
  }

  function gr(n) {
    return Math.floor(n * So) / So;
  }

  function vr(n) {
    return n === Fo || n === qo ? [0, n] : [Ao, gr(n)];
  }

  function sr(n) {
    n[0] <= Go ? n[0] = Ao : n[0] >= zo && (n[0] = Co), n[1] <= Lo ? n[1] = Fo : n[1] >= xo && (n[1] = qo);
  }

  function hr(n) {
    n.forEach(sr);
  }

  function pr(n, r) {
    for (var e = 0, t = n.length; e < t; ++e) {
      var o = n[e];
      o.polygon = n, r.push(o);

      for (var i = 0, u = o.length; i < u; ++i) {
        var a = o[i],
            c = a[0],
            f = a[1];

        if (c <= Go || c >= zo || f <= Lo || f >= xo) {
          sr(a);

          for (var l = i + 1; l < u; ++l) {
            var g = o[l],
                v = g[0],
                s = g[1];
            if (v > Go && v < zo && s > Lo && s < xo) break;
          }

          if (l === i + 1) continue;

          if (i) {
            var h = o.slice(0, i + 1);
            h.polygon = n, h[h.length - 1] = vr(f), r[r.length - 1] = h;
          } else r.pop();

          if (l >= u) break;
          r.push(o = o.slice(l - 1)), o[0] = vr(o[0][1]), o.polygon = n, i = -1, u = o.length;
        }
      }
    }

    n.length = 0;
  }

  function dr(n) {
    var r,
        e,
        t,
        o,
        i,
        u,
        a = n.length,
        c = {},
        f = {};

    for (r = 0; r < a; ++r) {
      e = n[r], t = e[0], i = e[e.length - 1], t[0] !== i[0] || t[1] !== i[1] ? (e.index = r, c[t] = f[i] = e) : (e.polygon.push(e), n[r] = null);
    }

    for (r = 0; r < a; ++r) {
      if (e = n[r]) {
        if (t = e[0], i = e[e.length - 1], o = f[t], u = c[i], delete c[t], delete f[i], t[0] === i[0] && t[1] === i[1]) {
          e.polygon.push(e);
          continue;
        }

        o ? (delete f[t], delete c[o[0]], o.pop(), n[o.index] = null, e = o.concat(e), e.polygon = o.polygon, o === u ? e.polygon.push(e) : (e.index = a++, n.push(c[e[0]] = f[e[e.length - 1]] = e))) : u ? (delete c[i], delete f[u[u.length - 1]], e.pop(), e = e.concat(u), e.polygon = u.polygon, e.index = a++, n[u.index] = null, n.push(c[e[0]] = f[e[e.length - 1]] = e)) : (e.push(e[0]), e.polygon.push(e));
      }
    }
  }

  function wr(n) {
    Pr(n.geometry);
  }

  function Pr(n) {
    if (n) {
      var r, e, t;

      switch (n.type) {
        case "GeometryCollection":
          n.geometries.forEach(Pr);
          break;

        case "Point":
          sr(n.coordinates);
          break;

        case "MultiPoint":
        case "LineString":
          hr(n.coordinates);
          break;

        case "MultiLineString":
          n.coordinates.forEach(hr);
          break;

        case "Polygon":
          pr(n.coordinates, r = []), dr(r);
          break;

        case "MultiPolygon":
          for (r = [], e = -1, t = n.coordinates.length; ++e < t;) {
            pr(n.coordinates[e], r);
          }

          dr(r), n.coordinates = n.coordinates.filter(lr);
      }
    }
  }

  function mr(n, r) {
    var e = Or(r / 2),
        t = Kr(Zr * e);
    return [n * (.74482 - .34588 * t * t), 1.70711 * e];
  }

  function yr(n) {
    function e(n, e) {
      var o = r.geoGnomonicRaw(n, e);
      return o[0] *= t, o;
    }

    var t = Hr(n);
    return e.invert = function (n, e) {
      return r.geoGnomonicRaw.invert(n / t, e);
    }, e;
  }

  function Rr() {
    return jr([-158, 21.5], [-77, 39]).clipAngle(60).scale(400);
  }

  function jr(n, r) {
    return Io(yr, n, r);
  }

  function Mr(n) {
    function e(r, e) {
      var c = i(Hr(e) * Hr(r - t)),
          f = i(Hr(e) * Hr(r - o)),
          l = e < 0 ? -1 : 1;
      return c *= c, f *= f, [(c - f) / (2 * n), l * u(4 * a * f - (a - c + f) * (a - c + f)) / (2 * n)];
    }

    if (!(n *= 2)) return r.geoAzimuthalEquidistantRaw;
    var t = -n / 2,
        o = -t,
        a = n * n,
        c = Or(o),
        f = .5 / Kr(o);
    return e.invert = function (n, r) {
      var e,
          a,
          l = r * r,
          g = Hr(u(l + (e = n + t) * e)),
          v = Hr(u(l + (e = n + o) * e));
      return [Br(a = g - v, e = (g + v) * c), (r < 0 ? -1 : 1) * i(u(e * e + a * a) * f)];
    }, e;
  }

  function Er() {
    return br([-158, 21.5], [-77, 39]).clipAngle(130).scale(122.571);
  }

  function br(n, r) {
    return Io(Mr, n, r);
  }

  function kr(n, r) {
    if (qr(r) < Ur) return [n, 0];
    var e = qr(r / Yr),
        t = o(e);
    if (qr(n) < Ur || qr(qr(r) - Yr) < Ur) return [0, _r(r) * Xr * Or(t / 2)];
    var i = Hr(t),
        a = qr(Xr / n - n / Xr) / 2,
        c = a * a,
        f = i / (e + i - 1),
        l = f * (2 / e - 1),
        g = l * l,
        v = g + c,
        s = f - g,
        h = c + f;
    return [_r(n) * Xr * (a * s + u(c * s * s - v * (f * f - g))) / v, _r(r) * Xr * (l * h - a * u((c + 1) * v - h * h)) / v];
  }

  function Sr(n, r) {
    if (qr(r) < Ur) return [n, 0];
    var e = qr(r / Yr),
        t = o(e);
    if (qr(n) < Ur || qr(qr(r) - Yr) < Ur) return [0, _r(r) * Xr * Or(t / 2)];
    var i = Hr(t),
        a = qr(Xr / n - n / Xr) / 2,
        c = a * a,
        f = i * (u(1 + c) - a * i) / (1 + c * e * e);
    return [_r(n) * Xr * f, _r(r) * Xr * u(1 - f * (2 * a + f))];
  }

  function Ar(n, r) {
    if (qr(r) < Ur) return [n, 0];
    var e = r / Yr,
        t = o(e);
    if (qr(n) < Ur || qr(qr(r) - Yr) < Ur) return [0, Xr * Or(t / 2)];
    var i = (Xr / n - n / Xr) / 2,
        a = e / (1 + Hr(t));
    return [Xr * (_r(n) * u(i * i + 1 - a * a) - i), Xr * a];
  }

  function Gr(n, r) {
    if (!r) return [n, 0];
    var e = qr(r);
    if (!n || e === Yr) return [0, r];
    var t = e / Yr,
        o = t * t,
        i = (8 * t - o * (o + 2) - 5) / (2 * o * (t - 1)),
        a = i * i,
        c = t * i,
        f = o + a + 2 * c,
        l = t + 3 * i,
        g = n / Yr,
        v = g + 1 / g,
        s = _r(qr(n) - Yr) * u(v * v - 4),
        h = s * s,
        p = f * (o + a * h - 1) + (1 - o) * (o * (l * l + 4 * a) + 12 * c * a + 4 * a * a),
        d = (s * (f + a - 1) + 2 * u(p)) / (4 * f + h);
    return [_r(n) * Yr * d, _r(r) * Yr * u(1 + s * qr(d) - d * d)];
  }

  function Cr(n, r) {
    return [n * u(1 - 3 * r * r / (Xr * Xr)), r];
  }

  function zr(n, r) {
    var e = .90631 * Kr(r),
        t = u(1 - e * e),
        o = u(2 / (1 + t * Hr(n /= 3)));
    return [2.66723 * t * o * Kr(n), 1.24104 * e * o];
  }

  function Fr(n, r) {
    var e = Hr(r),
        t = Hr(n) * e,
        o = 1 - t,
        i = Hr(n = Br(Kr(n) * e, -Kr(r))),
        a = Kr(n);
    return e = u(1 - t * t), [a * e - i * o, -i * e - a * o];
  }

  function Lr(n, r) {
    var e = s(n, r);
    return [(e[0] + n / Yr) / 2, (e[1] + r) / 2];
  }

  var qr = Math.abs,
      xr = Math.atan,
      Br = Math.atan2,
      Hr = Math.cos,
      Ir = Math.exp,
      Wr = Math.floor,
      Tr = Math.log,
      Dr = Math.max,
      Qr = Math.min,
      Vr = Math.pow,
      Nr = Math.round,
      _r = Math.sign || function (n) {
    return n > 0 ? 1 : n < 0 ? -1 : 0;
  },
      Kr = Math.sin,
      Or = Math.tan,
      Ur = 1e-6,
      Jr = 1e-12,
      Xr = Math.PI,
      Yr = Xr / 2,
      Zr = Xr / 4,
      $r = Math.SQRT1_2,
      ne = u(2),
      re = u(Xr),
      ee = 2 * Xr,
      te = 180 / Xr,
      oe = Xr / 180,
      ie = function ie() {
    var n = Yr,
        e = r.geoProjectionMutator(v),
        t = e(n);
    return t.radius = function (r) {
      return arguments.length ? e(n = r * oe) : n * te;
    }, t.scale(179.976).clipAngle(147);
  };

  s.invert = function (n, r) {
    if (!(n * n + 4 * r * r > Xr * Xr + Ur)) {
      var e = n,
          t = r,
          o = 25;

      do {
        var a,
            c = Kr(e),
            f = Kr(e / 2),
            l = Hr(e / 2),
            g = Kr(t),
            v = Hr(t),
            s = Kr(2 * t),
            h = g * g,
            p = v * v,
            d = f * f,
            w = 1 - p * l * l,
            P = w ? i(v * l) * u(a = 1 / w) : a = 0,
            m = 2 * P * v * f - n,
            y = P * g - r,
            R = a * (p * d + P * v * l * h),
            j = a * (.5 * c * s - 2 * P * g * f),
            M = .25 * a * (s * f - P * g * p * c),
            E = a * (h * l + P * d * v),
            b = j * M - E * R;
        if (!b) break;
        var k = (y * j - m * E) / b,
            S = (m * M - y * R) / b;
        e -= k, t -= S;
      } while ((qr(k) > Ur || qr(S) > Ur) && --o > 0);

      return [e, t];
    }
  };

  var ue = function ue() {
    return r.geoProjection(s).scale(152.63);
  },
      ae = function ae() {
    var n = 20 * oe,
        e = n >= 0 ? 1 : -1,
        t = Or(e * n),
        o = r.geoProjectionMutator(h),
        i = o(n),
        u = i.stream;
    return i.parallel = function (r) {
      return arguments.length ? (t = Or((e = (n = r * oe) >= 0 ? 1 : -1) * n), o(n)) : n * te;
    }, i.stream = function (r) {
      var o = i.rotate(),
          a = u(r),
          c = (i.rotate([0, 0]), u(r));
      return i.rotate(o), a.sphere = function () {
        c.polygonStart(), c.lineStart();

        for (var r = e * -180; e * r < 180; r += 90 * e) {
          c.point(r, 90 * e);
        }

        for (; e * (r -= n) >= -180;) {
          c.point(r, e * -Br(Hr(r * oe / 2), t) * te);
        }

        c.lineEnd(), c.polygonEnd();
      }, a;
    }, i.scale(218.695).center([0, 28.0974]);
  };

  p.invert = function (n, r) {
    if (n *= 3 / 8, r *= 3 / 8, !n && qr(r) > 1) return null;
    var e = n * n,
        t = r * r,
        i = 1 + e + t,
        a = u((i - u(i * i - 4 * r * r)) / 2),
        v = o(a) / 3,
        s = a ? g(qr(r / a)) / 3 : l(qr(n)) / 3,
        h = Hr(v),
        p = f(s),
        d = p * p - h * h;
    return [2 * _r(n) * Br(c(s) * h, .25 - d), 2 * _r(r) * Br(p * Kr(v), .25 + d)];
  };

  var ce = function ce() {
    return r.geoProjection(p).scale(66.1603);
  },
      fe = u(8),
      le = Tr(1 + ne);

  d.invert = function (n, r) {
    if ((t = qr(r)) < le) return [n, 2 * xr(Ir(r)) - Yr];
    var e,
        t,
        o = Zr,
        i = 25;

    do {
      var u = Hr(o / 2),
          a = Or(o / 2);
      o -= e = (fe * (o - Zr) - Tr(a) - t) / (fe - u * u / (2 * a));
    } while (qr(e) > Jr && --i > 0);

    return [n / (Hr(o) * (fe - 1 / Kr(o))), _r(r) * o];
  };

  var ge = function ge() {
    return r.geoProjection(d).scale(112.314);
  },
      ve = function ve() {
    var n = 5,
        e = r.geoProjectionMutator(w),
        t = e(n),
        i = t.stream,
        u = -Hr(.01 * oe),
        a = Kr(.01 * oe);
    return t.lobes = function (r) {
      return arguments.length ? e(n = +r) : n;
    }, t.stream = function (r) {
      var e = t.rotate(),
          c = i(r),
          f = (t.rotate([0, 0]), i(r));
      return t.rotate(e), c.sphere = function () {
        f.polygonStart(), f.lineStart();

        for (var r = 0, e = 360 / n, t = 2 * Xr / n, i = 90 - 180 / n, c = Yr; r < n; ++r, i -= e, c -= t) {
          f.point(Br(a * Hr(c), u) * te, o(a * Kr(c)) * te), i < -90 ? (f.point(-90, -180 - i - .01), f.point(-90, -180 - i + .01)) : (f.point(90, i + .01), f.point(90, i - .01));
        }

        f.lineEnd(), f.polygonEnd();
      }, c;
    }, t.scale(87.8076).center([0, 17.1875]).clipAngle(179.999);
  },
      se = m(ne / Yr, ne, Xr),
      he = function he() {
    return r.geoProjection(se).scale(169.529);
  },
      pe = 2.00276,
      de = 1.11072;

  y.invert = function (n, r) {
    var e,
        t,
        o = pe * r,
        i = r < 0 ? -Zr : Zr,
        u = 25;

    do {
      t = o - ne * Kr(i), i -= e = (Kr(2 * i) + 2 * i - Xr * Kr(t)) / (2 * Hr(2 * i) + 2 + Xr * Hr(t) * ne * Hr(i));
    } while (qr(e) > Ur && --u > 0);

    return t = o - ne * Kr(i), [n * (1 / Hr(t) + de / Hr(i)) / pe, t];
  };

  var we = function we() {
    return r.geoProjection(y).scale(160.857);
  },
      Pe = function Pe(n) {
    var e = 0,
        t = r.geoProjectionMutator(n),
        o = t(e);
    return o.parallel = function (n) {
      return arguments.length ? t(e = n * oe) : e * te;
    }, o;
  };

  R.invert = function (n, r) {
    return [n / Hr(r), r];
  };

  var me = function me() {
    return r.geoProjection(R).scale(152.63);
  },
      ye = function ye() {
    return Pe(j).scale(123.082).center([0, 26.1441]).parallel(45);
  },
      Re = function Re() {
    var n = .5,
        e = r.geoProjectionMutator(M),
        t = e(n);
    return t.fraction = function (r) {
      return arguments.length ? e(n = +r) : n;
    }, t.scale(158.837);
  },
      je = m(1, 4 / Xr, Xr),
      Me = function Me() {
    return r.geoProjection(je).scale(152.63);
  };

  z.invert = function (n, r) {
    var e = (e = r / re - 1) * e;
    return [e > 0 ? n * u(Xr / e) / 2 : 0, o(1 - e)];
  };

  var Ee = function Ee() {
    return r.geoProjection(z).scale(95.6464).center([0, 30]);
  },
      be = function be() {
    return Pe(F).scale(249.828).clipAngle(90);
  },
      ke = u(3);

  L.invert = function (n, r) {
    var e = 3 * o(r / (ke * re));
    return [re * n / (ke * (2 * Hr(2 * e / 3) - 1)), e];
  };

  var Se = function Se() {
    return r.geoProjection(L).scale(156.19);
  },
      Ae = function Ae() {
    return Pe(q).parallel(38.58).scale(195.044);
  },
      Ge = function Ge() {
    return Pe(x).scale(124.75);
  };

  B.invert = function (n, r) {
    var e = u(8 / (3 * Xr)),
        t = r / e;
    return [n / (e * (1 - qr(t) / Xr)), t];
  };

  var Ce = function Ce() {
    return r.geoProjection(B).scale(165.664);
  };

  H.invert = function (n, r) {
    var e = 2 - qr(r) / u(2 * Xr / 3);
    return [n * u(6 * Xr) / (2 * e), _r(r) * o((4 - e * e) / 3)];
  };

  var ze = function ze() {
    return r.geoProjection(H).scale(165.664);
  };

  I.invert = function (n, r) {
    var e = u(Xr * (4 + Xr)) / 2;
    return [n * e / (1 + u(1 - r * r * (4 + Xr) / (4 * Xr))), r * e / 2];
  };

  var Fe = function Fe() {
    return r.geoProjection(I).scale(180.739);
  };

  W.invert = function (n, r) {
    var e = r * u((4 + Xr) / Xr) / 2,
        t = o(e),
        i = Hr(t);
    return [n / (2 / u(Xr * (4 + Xr)) * (1 + i)), o((t + e * (i + 2)) / (2 + Yr))];
  };

  var Le = function Le() {
    return r.geoProjection(W).scale(180.739);
  };

  T.invert = function (n, r) {
    var e = u(2 + Xr),
        t = r * e / 2;
    return [e * n / (1 + Hr(t)), t];
  };

  var qe = function qe() {
    return r.geoProjection(T).scale(173.044);
  };

  D.invert = function (n, r) {
    var e = 1 + Yr,
        t = u(e / 2);
    return [2 * n * t / (1 + Hr(r *= t)), o((r + Kr(r)) / e)];
  };

  var xe = function xe() {
    return r.geoProjection(D).scale(173.044);
  },
      Be = 3 + 2 * ne;

  Q.invert = function (n, r) {
    if (!(e = p.invert(n / 1.2, 1.065 * r))) return null;
    var e,
        t = e[0],
        o = e[1],
        i = 20;
    n /= Be, r /= Be;

    do {
      var a = t / 2,
          c = o / 2,
          f = Kr(a),
          l = Hr(a),
          g = Kr(c),
          v = Hr(c),
          s = Hr(o),
          h = u(s),
          d = g / (v + ne * l * h),
          w = d * d,
          P = u(2 / (1 + w)),
          m = ne * v + (l + f) * h,
          y = ne * v + (l - f) * h,
          R = m / y,
          j = u(R),
          M = j - 1 / j,
          E = j + 1 / j,
          b = P * M - 2 * Tr(j) - n,
          k = P * d * E - 2 * xr(d) - r,
          S = g && $r * h * f * w / g,
          A = (ne * l * v + h) / (2 * (v + ne * l * h) * (v + ne * l * h) * h),
          G = -.5 * d * P * P * P,
          C = G * S,
          z = G * A,
          F = (F = 2 * v + ne * h * (l - f)) * F * j,
          L = (ne * l * v * h + s) / F,
          q = -(ne * f * g) / (h * F),
          x = M * C - 2 * L / j + P * (L + L / R),
          B = M * z - 2 * q / j + P * (q + q / R),
          H = d * E * C - 2 * S / (1 + w) + P * E * S + P * d * (L - L / R),
          I = d * E * z - 2 * A / (1 + w) + P * E * A + P * d * (q - q / R),
          W = B * H - I * x;
      if (!W) break;
      var T = (k * B - b * I) / W,
          D = (b * H - k * x) / W;
      t -= T, o = Dr(-Yr, Qr(Yr, o - D));
    } while ((qr(T) > Ur || qr(D) > Ur) && --i > 0);

    return qr(qr(o) - Yr) < Ur ? [0, o] : i && [t, o];
  };

  var He = function He() {
    return r.geoProjection(Q).scale(62.5271);
  },
      Ie = Hr(35 * oe);

  V.invert = function (n, r) {
    var e = r / (1 + Ie);
    return [n && n / (Ie * u(1 - e * e)), 2 * xr(e)];
  };

  var We = function We() {
    return r.geoProjection(V).scale(137.152);
  };

  N.invert = function (n, r) {
    var e = xr(r / re),
        t = Hr(e),
        o = 2 * e;
    return [n * re / 2 / (Hr(o) * t * t), o];
  };

  var Te = function Te() {
    return r.geoProjection(N).scale(135.264);
  },
      De = function De(n) {
    function e(n) {
      return i(_(n));
    }

    function t(n) {
      e[n] = function (r) {
        return arguments.length ? (i[n](r), e) : i[n]();
      };
    }

    null == n && (n = r.geoOrthographic);
    var i = n(),
        u = r.geoEquirectangular().scale(te).precision(0).clipAngle(null).translate([0, 0]);
    return i.invert && (e.invert = function (n) {
      return K(i.invert(n));
    }), e.stream = function (n) {
      var r = i.stream(n),
          e = u.stream({
        point: function point(n, e) {
          r.point(n / 2, o(Or(-e / 2 * oe)) * te);
        },
        lineStart: function lineStart() {
          r.lineStart();
        },
        lineEnd: function lineEnd() {
          r.lineEnd();
        },
        polygonStart: function polygonStart() {
          r.polygonStart();
        },
        polygonEnd: function polygonEnd() {
          r.polygonEnd();
        }
      });
      return e.sphere = r.sphere, e;
    }, e.rotate = function (n) {
      return arguments.length ? (u.rotate(n), e) : u.rotate();
    }, e.center = function (n) {
      return arguments.length ? (i.center(_(n)), e) : K(i.center());
    }, t("clipAngle"), t("clipExtent"), t("scale"), t("translate"), t("precision"), e.scale(249.5);
  },
      Qe = function Qe() {
    var n = 6,
        e = 30 * oe,
        t = Hr(e),
        i = Kr(e),
        u = r.geoProjectionMutator(O),
        a = u(e, n),
        c = a.stream,
        f = -Hr(.01 * oe),
        l = Kr(.01 * oe);
    return a.radius = function (r) {
      return arguments.length ? (t = Hr(e = r * oe), i = Kr(e), u(e, n)) : e * te;
    }, a.lobes = function (r) {
      return arguments.length ? u(e, n = +r) : n;
    }, a.stream = function (r) {
      var e = a.rotate(),
          u = c(r),
          g = (a.rotate([0, 0]), c(r));
      return a.rotate(e), u.sphere = function () {
        g.polygonStart(), g.lineStart();

        for (var r = 0, e = 2 * Xr / n, u = 0; r < n; ++r, u -= e) {
          g.point(Br(l * Hr(u), f) * te, o(l * Kr(u)) * te), g.point(Br(i * Hr(u - e / 2), t) * te, o(i * Kr(u - e / 2)) * te);
        }

        g.lineEnd(), g.polygonEnd();
      }, u;
    }, a.rotate([90, -40]).scale(91.7095).clipAngle(179.999);
  },
      Ve = function Ve(n, r, e, t, i, a, c, f) {
    function l(u, l) {
      if (!l) return [n * u / Xr, 0];
      var g = l * l,
          v = n + g * (r + g * (e + g * t)),
          s = l * (i - 1 + g * (a - f + g * c)),
          h = (v * v + s * s) / (2 * s),
          p = u * o(v / h) / Xr;
      return [h * Kr(p), l * (1 + g * f) + h * (1 - Hr(p))];
    }

    return arguments.length < 8 && (f = 0), l.invert = function (l, g) {
      var v,
          s,
          h = Xr * l / n,
          p = g,
          d = 50;

      do {
        var w = p * p,
            P = n + w * (r + w * (e + w * t)),
            m = p * (i - 1 + w * (a - f + w * c)),
            y = P * P + m * m,
            R = 2 * m,
            j = y / R,
            M = j * j,
            E = o(P / j) / Xr,
            b = h * E,
            k = P * P,
            S = (2 * r + w * (4 * e + 6 * w * t)) * p,
            A = i + w * (3 * a + 5 * w * c),
            G = 2 * (P * S + m * (A - 1)),
            C = 2 * (A - 1),
            z = (G * R - y * C) / (R * R),
            F = Hr(b),
            L = Kr(b),
            q = j * F,
            x = j * L,
            B = h / Xr * (1 / u(1 - k / M)) * (S * j - P * z) / M,
            H = x - l,
            I = p * (1 + w * f) + j - q - g,
            W = z * L + q * B,
            T = q * E,
            D = 1 + z - (z * F - x * B),
            Q = x * E,
            V = W * Q - D * T;
        if (!V) break;
        h -= v = (I * W - H * D) / V, p -= s = (H * Q - I * T) / V;
      } while ((qr(v) > Ur || qr(s) > Ur) && --d > 0);

      return [h, p];
    }, l;
  },
      Ne = Ve(2.8284, -1.6988, .75432, -.18071, 1.76003, -.38914, .042555),
      _e = function _e() {
    return r.geoProjection(Ne).scale(149.995);
  },
      Ke = Ve(2.583819, -.835827, .170354, -.038094, 1.543313, -.411435, .082742),
      Oe = function Oe() {
    return r.geoProjection(Ke).scale(153.93);
  },
      Ue = Ve(5 / 6 * Xr, -.62636, -.0344, 0, 1.3493, -.05524, 0, .045),
      Je = function Je() {
    return r.geoProjection(Ue).scale(130.945);
  };

  X.invert = function (n, r) {
    var e,
        t = n,
        o = r,
        i = 50;

    do {
      var u = o * o;
      o -= e = (o * (1 + u / 12) - r) / (1 + u / 4);
    } while (qr(e) > Ur && --i > 0);

    i = 50, n /= 1 - .162388 * u;

    do {
      var a = (a = t * t) * a;
      t -= e = (t * (.87 - 952426e-9 * a) - n) / (.87 - .00476213 * a);
    } while (qr(e) > Ur && --i > 0);

    return [t, o];
  };

  var Xe = function Xe() {
    return r.geoProjection(X).scale(131.747);
  },
      Ye = Ve(2.6516, -.76534, .19123, -.047094, 1.36289, -.13965, .031762),
      Ze = function Ze() {
    return r.geoProjection(Ye).scale(131.087);
  },
      $e = function $e(n) {
    function r(r, t) {
      var o = r > 0 ? -.5 : .5,
          i = n(r + o * Xr, t);
      return i[0] -= o * e, i;
    }

    var e = n(Yr, 0)[0] - n(-Yr, 0)[0];
    return n.invert && (r.invert = function (r, t) {
      var o = r > 0 ? -.5 : .5,
          i = n.invert(r + o * e, t),
          u = i[0] - o * Xr;
      return u < -Xr ? u += 2 * Xr : u > Xr && (u -= 2 * Xr), i[0] = u, i;
    }), r;
  };

  Y.invert = function (n, r) {
    var e = _r(n),
        t = _r(r),
        i = -e * n,
        u = -t * r,
        a = u / i < 1,
        c = $(a ? u : i, a ? i : u),
        f = c[0],
        l = c[1],
        g = Hr(l);

    return a && (f = -Yr - f), [e * (Br(Kr(f) * g, -Kr(l)) + Xr), t * o(Hr(f) * g)];
  };

  var nt = function nt() {
    return r.geoProjection($e(Y)).scale(239.75);
  };

  on.invert = function (n, r) {
    var e = (ne - 1) / (ne + 1),
        t = u(1 - e * e),
        o = tn(Yr, t * t),
        i = nn(.5 * o - r, -n, t * t),
        a = an(i[0], i[1]);
    return [Br(a[1], a[0]) / -1, 2 * xr(Ir(-.5 * Tr(e * a[0] * a[0] + e * a[1] * a[1]))) - Yr];
  };

  var rt = function rt() {
    return r.geoProjection($e(on)).scale(151.496);
  };

  fn.invert = function (n, r) {
    var e = 2 * o(r / 2);
    return [n * Hr(e / 2) / Hr(e), e];
  };

  var et = function et() {
    var n = 2,
        e = r.geoProjectionMutator(cn),
        t = e(n);
    return t.coefficient = function (r) {
      return arguments.length ? e(n = +r) : n;
    }, t.scale(169.529);
  },
      tt = function tt() {
    var n = 0,
        e = r.geoProjectionMutator(ln),
        t = e(n),
        o = t.rotate,
        i = t.stream,
        u = r.geoCircle();
    return t.parallel = function (r) {
      if (!arguments.length) return n * te;
      var o = t.rotate();
      return e(n = r * oe).rotate(o);
    }, t.rotate = function (r) {
      return arguments.length ? (o.call(t, [r[0], r[1] - n * te]), u.center([-r[0], -r[1]]), t) : (r = o.call(t), r[1] += n * te, r);
    }, t.stream = function (n) {
      return n = i(n), n.sphere = function () {
        n.polygonStart();
        var r,
            e = u.radius(89.99)().coordinates[0],
            t = e.length - 1,
            o = -1;

        for (n.lineStart(); ++o < t;) {
          n.point((r = e[o])[0], r[1]);
        }

        for (n.lineEnd(), e = u.radius(90.01)().coordinates[0], t = e.length - 1, n.lineStart(); --o >= 0;) {
          n.point((r = e[o])[0], r[1]);
        }

        n.lineEnd(), n.polygonEnd();
      }, n;
    }, t.scale(79.4187).parallel(45).clipAngle(179.999);
  },
      ot = 41 + 48 / 36 + 37 / 3600,
      it = q(0),
      ut = function ut() {
    var n = 4,
        e = r.geoProjectionMutator(vn),
        t = e(n),
        o = t.stream;
    return t.lobes = function (r) {
      return arguments.length ? e(n = +r) : n;
    }, t.stream = function (e) {
      var i = t.rotate(),
          u = o(e),
          a = (t.rotate([0, 0]), o(e));
      return t.rotate(i), u.sphere = function () {
        r.geoStream(sn(180 / n), a);
      }, u;
    }, t.scale(239.75);
  },
      at = function at() {
    var n = 1,
        e = r.geoProjectionMutator(hn),
        t = e(n);
    return t.ratio = function (r) {
      return arguments.length ? e(n = +r) : n;
    }, t.scale(167.774).center([0, 18.67]);
  },
      ct = .7109889596207567,
      ft = .0528035274542;

  pn.invert = function (n, r) {
    return r > -ct ? se.invert(n, r - ft) : R.invert(n, r);
  };

  var lt = function lt() {
    return r.geoProjection(pn).rotate([-20, -55]).scale(164.263).center([0, -5.4036]);
  };

  dn.invert = function (n, r) {
    return qr(r) > ct ? se.invert(n, r + (r > 0 ? ft : -ft)) : R.invert(n, r);
  };

  var gt = function gt() {
    return r.geoProjection(dn).scale(152.63);
  },
      vt = function vt(n, e) {
    function t(r, t) {
      for (var o = t < 0 ? -1 : 1, i = e[+(t < 0)], u = 0, a = i.length - 1; u < a && r > i[u][2][0]; ++u) {
        ;
      }

      var c = n(r - i[u][1][0], t);
      return c[0] += n(i[u][1][0], o * t > o * i[u][0][1] ? i[u][0][1] : t)[0], c;
    }

    var o = mn(e);
    e = e.map(function (n) {
      return n.map(function (n) {
        return [[n[0][0] * oe, n[0][1] * oe], [n[1][0] * oe, n[1][1] * oe], [n[2][0] * oe, n[2][1] * oe]];
      });
    });
    var i = e.map(function (r) {
      return r.map(function (r) {
        var e,
            t = n(r[0][0], r[0][1])[0],
            o = n(r[2][0], r[2][1])[0],
            i = n(r[1][0], r[0][1])[1],
            u = n(r[1][0], r[1][1])[1];
        return i > u && (e = i, i = u, u = e), [[t, i], [o, u]];
      });
    });
    n.invert && (t.invert = function (r, o) {
      for (var u = i[+(o < 0)], a = e[+(o < 0)], c = 0, f = u.length; c < f; ++c) {
        var l = u[c];

        if (l[0][0] <= r && r < l[1][0] && l[0][1] <= o && o < l[1][1]) {
          var g = n.invert(r - n(a[c][1][0], 0)[0], o);
          return g[0] += a[c][1][0], wn(t(g[0], g[1]), [r, o]) ? g : null;
        }
      }
    });
    var u = r.geoProjection(t),
        a = u.stream;
    return u.stream = function (n) {
      var e = u.rotate(),
          t = a(n),
          i = (u.rotate([0, 0]), a(n));
      return u.rotate(e), t.sphere = function () {
        r.geoStream(o, i);
      }, t;
    }, u;
  },
      st = [[[[-180, 0], [-100, 90], [-40, 0]], [[-40, 0], [30, 90], [180, 0]]], [[[-180, 0], [-160, -90], [-100, 0]], [[-100, 0], [-60, -90], [-20, 0]], [[-20, 0], [20, -90], [80, 0]], [[80, 0], [140, -90], [180, 0]]]],
      ht = function ht() {
    return vt(y, st).scale(160.857);
  },
      pt = [[[[-180, 0], [-100, 90], [-40, 0]], [[-40, 0], [30, 90], [180, 0]]], [[[-180, 0], [-160, -90], [-100, 0]], [[-100, 0], [-60, -90], [-20, 0]], [[-20, 0], [20, -90], [80, 0]], [[80, 0], [140, -90], [180, 0]]]],
      dt = function dt() {
    return vt(dn, pt).scale(152.63);
  },
      wt = [[[[-180, 0], [-100, 90], [-40, 0]], [[-40, 0], [30, 90], [180, 0]]], [[[-180, 0], [-160, -90], [-100, 0]], [[-100, 0], [-60, -90], [-20, 0]], [[-20, 0], [20, -90], [80, 0]], [[80, 0], [140, -90], [180, 0]]]],
      Pt = function Pt() {
    return vt(se, wt).scale(169.529);
  },
      mt = [[[[-180, 0], [-90, 90], [0, 0]], [[0, 0], [90, 90], [180, 0]]], [[[-180, 0], [-90, -90], [0, 0]], [[0, 0], [90, -90], [180, 0]]]],
      yt = function yt() {
    return vt(se, mt).scale(169.529).rotate([20, 0]);
  },
      Rt = [[[[-180, 35], [-30, 90], [0, 35]], [[0, 35], [30, 90], [180, 35]]], [[[-180, -10], [-102, -90], [-65, -10]], [[-65, -10], [5, -90], [77, -10]], [[77, -10], [103, -90], [180, -10]]]],
      jt = function jt() {
    return vt(pn, Rt).rotate([-20, -55]).scale(164.263).center([0, -5.4036]);
  },
      Mt = [[[[-180, 0], [-110, 90], [-40, 0]], [[-40, 0], [0, 90], [40, 0]], [[40, 0], [110, 90], [180, 0]]], [[[-180, 0], [-110, -90], [-40, 0]], [[-40, 0], [0, -90], [40, 0]], [[40, 0], [110, -90], [180, 0]]]],
      Et = function Et() {
    return vt(R, Mt).scale(152.63).rotate([-20, 0]);
  };

  yn.invert = function (n, r) {
    return [ee / 3 * n / u(Xr * Xr / 3 - r * r), r];
  };

  var bt = function bt() {
    return r.geoProjection(yn).scale(158.837);
  },
      kt = function kt() {
    var n = .5,
        e = r.geoProjectionMutator(Rn),
        t = e(n);
    return t.spacing = function (r) {
      return arguments.length ? e(n = +r) : n;
    }, t.scale(124.75);
  },
      St = Xr / ne;

  jn.invert = function (n, r) {
    var e = qr(n),
        t = qr(r),
        o = Ur,
        a = Yr;
    t < St ? a *= t / St : o += 6 * i(St / t);

    for (var c = 0; c < 25; c++) {
      var f = Kr(a),
          l = u(Hr(a)),
          g = Kr(a / 2),
          v = Hr(a / 2),
          s = Kr(o / 6),
          h = Hr(o / 6),
          p = .5 * o * (1 + l) - e,
          d = a / (v * h) - t,
          w = l ? -.25 * o * f / l : 0,
          P = .5 * (1 + l),
          m = (1 + .5 * a * g / v) / (v * h),
          y = a / v * (s / 6) / (h * h),
          R = w * y - m * P,
          j = (p * y - d * P) / R,
          M = (d * w - p * m) / R;
      if (a -= j, o -= M, qr(j) < Ur && qr(M) < Ur) break;
    }

    return [n < 0 ? -o : o, r < 0 ? -a : a];
  };

  var At = function At() {
    return r.geoProjection(jn).scale(97.2672);
  };

  Mn.invert = function (n, r) {
    var e = _r(n) * Xr,
        t = r / 2,
        o = 50;

    do {
      var i = e * e,
          u = t * t,
          a = e * t,
          c = e * (.975534 + u * (i * -.0143059 - .119161 + u * -.0547009)) - n,
          f = t * (1.00384 + i * (.0802894 + u * -.02855 + 199025e-9 * i) + u * (.0998909 + u * -.0491032)) - r,
          l = .975534 - u * (.119161 + 3 * i * .0143059 + .0547009 * u),
          g = -a * (.238322 + .2188036 * u + .0286118 * i),
          v = a * (.1605788 + 7961e-7 * i + -.0571 * u),
          s = 1.00384 + i * (.0802894 + 199025e-9 * i) + u * (3 * (.0998909 - .02855 * i) - .245516 * u),
          h = g * v - s * l,
          p = (f * g - c * s) / h,
          d = (c * v - f * l) / h;
      e -= p, t -= d;
    } while ((qr(p) > Ur || qr(d) > Ur) && --o > 0);

    return o && [e, t];
  };

  var Gt = function Gt() {
    return r.geoProjection(Mn).scale(139.98);
  };

  En.invert = function (n, r) {
    var e = n * n,
        t = r * r,
        a = t + 1,
        c = n ? $r * u((a - u(e * e + 2 * e * (t - 1) + a * a)) / e + 1) : 1 / u(a);
    return [o(n * c), _r(r) * i(c)];
  };

  var Ct = function Ct() {
    return r.geoProjection(En).scale(144.049).clipAngle(89.999);
  },
      zt = function zt() {
    return Pe(bn).parallel(40).scale(158.837);
  };

  kn.invert = function (n, r) {
    return [n, 2.5 * xr(Ir(.8 * r)) - .625 * Xr];
  };

  var Ft = function Ft() {
    return r.geoProjection(kn).scale(108.318);
  },
      Lt = [[.9972523, 0], [.0052513, -.0041175], [.0074606, .0048125], [-.0153783, -.1968253], [.0636871, -.1408027], [.3660976, -.2937382]],
      qt = [[.98879, 0], [0, 0], [-.050909, 0], [0, 0], [.075528, 0]],
      xt = [[.984299, 0], [.0211642, .0037608], [-.1036018, -.0575102], [-.0329095, -.0320119], [.0499471, .1223335], [.026046, .0899805], [7388e-7, -.1435792], [.0075848, -.1334108], [-.0216473, .0776645], [-.0225161, .0853673]],
      Bt = [[.9245, 0], [0, 0], [.01943, 0]],
      Ht = [[.721316, 0], [0, 0], [-.00881625, -.00617325]],
      It = u(6),
      Wt = u(7);

  qn.invert = function (n, r) {
    var e = 3 * o(r * Wt / 9);
    return [n * Wt / (It * (2 * Hr(2 * e / 3) - 1)), o(3 * Kr(e) * It / 7)];
  };

  var Tt = function Tt() {
    return r.geoProjection(qn).scale(164.859);
  };

  xn.invert = function (n, r) {
    var e = r * u(2 + ne) / (2 * u(3)),
        t = 2 * o(e);
    return [3 * ne * n / (1 + 2 * Hr(t) / Hr(t / 2)), o((e + Kr(t)) / (1 + $r))];
  };

  var Dt = function Dt() {
    return r.geoProjection(xn).scale(188.209);
  };

  Bn.invert = function (n, r) {
    var e = u(6 / (4 + Xr)),
        t = r / e;
    return qr(qr(t) - Yr) < Ur && (t = t < 0 ? -Yr : Yr), [1.5 * n / (e * (.5 + Hr(t))), o((t / 2 + Kr(t)) / (1 + Xr / 4))];
  };

  var Qt = function Qt() {
    return r.geoProjection(Bn).scale(166.518);
  };

  Hn.invert = function (n, r) {
    var e,
        t = r,
        o = 25;

    do {
      var i = t * t,
          u = i * i;
      t -= e = (t * (1.007226 + i * (.015085 + u * (.028874 * i - .044475 - .005916 * u))) - r) / (1.007226 + i * (.045255 + u * (.259866 * i - .311325 - .005916 * 11 * u)));
    } while (qr(e) > Ur && --o > 0);

    return [n / (.8707 + (i = t * t) * (i * (i * i * i * (.003971 - .001529 * i) - .013791) - .131979)), t];
  };

  var Vt = function Vt() {
    return r.geoProjection(Hn).scale(175.295);
  };

  In.invert = function (n, r) {
    for (var e = r / 2, t = 0, o = 1 / 0; t < 10 && qr(o) > Ur; ++t) {
      var i = Hr(r / 2);
      r -= o = (r - Or(r / 2) - e) / (1 - .5 / (i * i));
    }

    return [2 * n / (1 + Hr(r)), r];
  };

  var Nt = function Nt() {
    return r.geoProjection(In).scale(152.63);
  },
      _t = 1.0148,
      Kt = .23185,
      Ot = -.14499,
      Ut = .02406,
      Jt = _t,
      Xt = 5 * Kt,
      Yt = 7 * Ot,
      Zt = 9 * Ut;

  Wn.invert = function (n, r) {
    r > 1.790857183 ? r = 1.790857183 : r < -1.790857183 && (r = -1.790857183);
    var e,
        t = r;

    do {
      var o = t * t;
      t -= e = (t * (_t + o * o * (Kt + o * (Ot + Ut * o))) - r) / (Jt + o * o * (Xt + o * (Yt + Zt * o)));
    } while (qr(e) > Ur);

    return [n, t];
  };

  var $t = function $t() {
    return r.geoProjection(Wn).scale(139.319);
  };

  Tn.invert = function (n, r) {
    if (qr(r) < Ur) return [n, 0];
    var e,
        t = n * n + r * r,
        u = .5 * r,
        a = 10;

    do {
      var c = Or(u),
          f = 1 / Hr(u),
          l = t - 2 * r * u + u * u;
      u -= e = (c * l + 2 * (u - r)) / (2 + l * f * f + 2 * (u - r) * c);
    } while (qr(e) > Ur && --a > 0);

    return c = Or(u), [(qr(r) < qr(u + 1 / c) ? o(n * c) : _r(n) * (i(qr(n * c)) + Yr)) / Kr(u), u];
  };

  var no = function no() {
    return r.geoProjection(Tn).scale(103.74);
  },
      ro = function ro(n, r) {
    var e = Vn(n[1], n[0]),
        t = Vn(r[1], r[0]),
        o = _n(e, t),
        i = Nn(e) / Nn(t);

    return Qn([1, 0, n[0][0], 0, 1, n[0][1]], Qn([i, 0, 0, 0, i, 0], Qn([Hr(o), Kr(o), 0, -Kr(o), Hr(o), 0], [1, 0, -r[0][0], 0, 1, -r[0][1]])));
  },
      eo = function eo(n, e, t) {
    function o(n, r) {
      if (n.edges = Jn(n.face), r.face) {
        var e = n.shared = Un(n.face, r.face),
            t = ro(e.map(r.project), e.map(n.project));
        n.transform = r.transform ? Qn(r.transform, t) : t;

        for (var i = r.edges, u = 0, a = i.length; u < a; ++u) {
          On(e[0], i[u][1]) && On(e[1], i[u][0]) && (i[u] = n), On(e[0], i[u][0]) && On(e[1], i[u][1]) && (i[u] = n);
        }

        for (i = n.edges, u = 0, a = i.length; u < a; ++u) {
          On(e[0], i[u][0]) && On(e[1], i[u][1]) && (i[u] = r), On(e[0], i[u][1]) && On(e[1], i[u][0]) && (i[u] = r);
        }
      } else n.transform = r.transform;

      return n.children && n.children.forEach(function (r) {
        o(r, n);
      }), n;
    }

    function i(n, r) {
      var t,
          o = e(n, r),
          i = o.project([n * te, r * te]);
      return (t = o.transform) ? [t[0] * i[0] + t[1] * i[1] + t[2], -(t[3] * i[0] + t[4] * i[1] + t[5])] : (i[1] = -i[1], i);
    }

    function u(n, r) {
      var e = n.project.invert,
          t = n.transform,
          o = r;
      if (t && (t = Dn(t), o = [t[0] * o[0] + t[1] * o[1] + t[2], t[3] * o[0] + t[4] * o[1] + t[5]]), e && n === a(i = e(o))) return i;

      for (var i, c = n.children, f = 0, l = c && c.length; f < l; ++f) {
        if (i = u(c[f], r)) return i;
      }
    }

    function a(n) {
      return e(n[0] * oe, n[1] * oe);
    }

    t = null == t ? -Xr / 6 : t, o(n, {
      transform: [Hr(t), Kr(t), 0, -Kr(t), Hr(t), 0]
    }), Xn(n) && (i.invert = function (r, e) {
      var t = u(n, [r, -e]);
      return t && (t[0] *= oe, t[1] *= oe, t);
    });
    var c = r.geoProjection(i),
        f = c.stream;
    return c.stream = function (r) {
      var e = c.rotate(),
          t = f(r),
          o = (c.rotate([0, 0]), f(r));
      return c.rotate(e), t.sphere = function () {
        o.polygonStart(), o.lineStart(), Kn(o, n), o.lineEnd(), o.polygonEnd();
      }, t;
    }, c;
  },
      to = [[0, 90], [-90, 0], [0, 0], [90, 0], [180, 0], [0, -90]],
      oo = [[0, 2, 1], [0, 3, 2], [5, 1, 2], [5, 2, 3], [0, 1, 4], [0, 4, 3], [5, 4, 1], [5, 3, 4]].map(function (n) {
    return n.map(function (n) {
      return to[n];
    });
  }),
      io = function io(n) {
    n = n || function (n) {
      var e = r.geoCentroid({
        type: "MultiPoint",
        coordinates: n
      });
      return r.geoGnomonic().scale(1).translate([0, 0]).rotate([-e[0], -e[1]]);
    };

    var e = oo.map(function (r) {
      return {
        face: r,
        project: n(r)
      };
    });
    return [-1, 0, 0, 1, 0, 1, 4, 5].forEach(function (n, r) {
      var t = e[n];
      t && (t.children || (t.children = [])).push(e[r]);
    }), eo(e[0], function (n, r) {
      return e[n < -Xr / 2 ? r < 0 ? 6 : 4 : n < 0 ? r < 0 ? 2 : 0 : n < Xr / 2 ? r < 0 ? 3 : 1 : r < 0 ? 7 : 5];
    }).scale(101.858).center([0, 45]);
  },
      uo = 2 / u(3);

  Yn.invert = function (n, r) {
    return z.invert(n / uo, r);
  };

  var ao = function ao(n) {
    n = n || function (n) {
      var e = r.geoCentroid({
        type: "MultiPoint",
        coordinates: n
      });
      return r.geoProjection(Yn).translate([0, 0]).scale(1).rotate(e[1] > 0 ? [-e[0], 0] : [180 - e[0], 180]);
    };

    var e = oo.map(function (r) {
      return {
        face: r,
        project: n(r)
      };
    });
    return [-1, 0, 0, 1, 0, 1, 4, 5].forEach(function (n, r) {
      var t = e[n];
      t && (t.children || (t.children = [])).push(e[r]);
    }), eo(e[0], function (n, r) {
      return e[n < -Xr / 2 ? r < 0 ? 6 : 4 : n < 0 ? r < 0 ? 2 : 0 : n < Xr / 2 ? r < 0 ? 3 : 1 : r < 0 ? 7 : 5];
    }).scale(121.906).center([0, 48.5904]);
  },
      co = function co(n) {
    function e(n, r) {
      var e = Hr(r),
          t = [e * Hr(n), e * Kr(n), Kr(r)],
          i = n < -Xr / 2 ? r < 0 ? 6 : 4 : n < 0 ? r < 0 ? 2 : 0 : n < Xr / 2 ? r < 0 ? 3 : 1 : r < 0 ? 7 : 5,
          a = o[i];
      return u[Zn(a[0], t) < 0 ? 8 + 3 * i : Zn(a[1], t) < 0 ? 8 + 3 * i + 1 : Zn(a[2], t) < 0 ? 8 + 3 * i + 2 : i];
    }

    n = n || function (n) {
      var e = 6 === n.length ? r.geoCentroid({
        type: "MultiPoint",
        coordinates: n
      }) : n[0];
      return r.geoGnomonic().scale(1).translate([0, 0]).rotate([-e[0], -e[1]]);
    };

    var t = oo.map(function (n) {
      for (var r, e = n.map(rr), t = e.length, o = e[t - 1], i = [], u = 0; u < t; ++u) {
        r = e[u], i.push(nr([.9486832980505138 * o[0] + .31622776601683794 * r[0], .9486832980505138 * o[1] + .31622776601683794 * r[1], .9486832980505138 * o[2] + .31622776601683794 * r[2]]), nr([.9486832980505138 * r[0] + .31622776601683794 * o[0], .9486832980505138 * r[1] + .31622776601683794 * o[1], .9486832980505138 * r[2] + .31622776601683794 * o[2]])), o = r;
      }

      return i;
    }),
        o = [],
        i = [-1, 0, 0, 1, 0, 1, 4, 5];
    t.forEach(function (n, r) {
      for (var e = oo[r], u = e.length, a = o[r] = [], c = 0; c < u; ++c) {
        t.push([e[c], n[(2 * c + 2) % (2 * u)], n[(2 * c + 1) % (2 * u)]]), i.push(r), a.push($n(rr(n[(2 * c + 2) % (2 * u)]), rr(n[(2 * c + 1) % (2 * u)])));
      }
    });
    var u = t.map(function (r) {
      return {
        project: n(r),
        face: r
      };
    });
    return i.forEach(function (n, r) {
      var e = u[n];
      e && (e.children || (e.children = [])).push(u[r]);
    }), eo(u[0], e).scale(110.625).center([0, 45]);
  },
      fo = function fo() {},
      lo = function lo(n) {
    if ((r = n.length) < 4) return !1;

    for (var r, e = 0, t = n[r - 1][1] * n[0][0] - n[r - 1][0] * n[0][1]; ++e < r;) {
      t += n[e - 1][1] * n[e][0] - n[e - 1][0] * n[e][1];
    }

    return t <= 0;
  },
      go = function go(n, r) {
    for (var e = r[0], t = r[1], o = !1, i = 0, u = n.length, a = u - 1; i < u; a = i++) {
      var c = n[i],
          f = c[0],
          l = c[1],
          g = n[a],
          v = g[0],
          s = g[1];
      l > t ^ s > t && e < (v - f) * (t - l) / (s - l) + f && (o = !o);
    }

    return o;
  },
      vo = function vo(n, r) {
    var e,
        t = r.stream;
    if (!t) throw new Error("invalid projection");

    switch (n && n.type) {
      case "Feature":
        e = tr;
        break;

      case "FeatureCollection":
        e = er;
        break;

      default:
        e = ir;
    }

    return e(n, t);
  },
      so = [],
      ho = [],
      po = {
    point: function point(n, r) {
      so.push([n, r]);
    },
    result: function result() {
      var n = so.length ? so.length < 2 ? {
        type: "Point",
        coordinates: so[0]
      } : {
        type: "MultiPoint",
        coordinates: so
      } : null;
      return so = [], n;
    }
  },
      wo = {
    lineStart: fo,
    point: function point(n, r) {
      so.push([n, r]);
    },
    lineEnd: function lineEnd() {
      so.length && (ho.push(so), so = []);
    },
    result: function result() {
      var n = ho.length ? ho.length < 2 ? {
        type: "LineString",
        coordinates: ho[0]
      } : {
        type: "MultiLineString",
        coordinates: ho
      } : null;
      return ho = [], n;
    }
  },
      Po = {
    polygonStart: fo,
    lineStart: fo,
    point: function point(n, r) {
      so.push([n, r]);
    },
    lineEnd: function lineEnd() {
      var n = so.length;

      if (n) {
        do {
          so.push(so[0].slice());
        } while (++n < 4);

        ho.push(so), so = [];
      }
    },
    polygonEnd: fo,
    result: function result() {
      if (!ho.length) return null;
      var n = [],
          r = [];
      return ho.forEach(function (e) {
        lo(e) ? n.push([e]) : r.push(e);
      }), r.forEach(function (r) {
        var e = r[0];
        n.some(function (n) {
          if (go(n[0], e)) return n.push(r), !0;
        }) || n.push([r]);
      }), ho = [], n.length ? n.length > 1 ? {
        type: "MultiPolygon",
        coordinates: n
      } : {
        type: "Polygon",
        coordinates: n[0]
      } : null;
    }
  },
      mo = function mo(n) {
    function e(r, e) {
      var o = qr(r) < Yr,
          i = n(o ? r : r > 0 ? r - Xr : r + Xr, e),
          u = (i[0] - i[1]) * $r,
          a = (i[0] + i[1]) * $r;
      if (o) return [u, a];
      var c = t * $r,
          f = u > 0 ^ a > 0 ? -1 : 1;
      return [f * u - _r(a) * c, f * a - _r(u) * c];
    }

    var t = n(Yr, 0)[0] - n(-Yr, 0)[0];
    return n.invert && (e.invert = function (r, e) {
      var o = (r + e) * $r,
          i = (e - r) * $r,
          u = qr(o) < .5 * t && qr(i) < .5 * t;

      if (!u) {
        var a = t * $r,
            c = o > 0 ^ i > 0 ? -1 : 1,
            f = -c * (r + (i > 0 ? 1 : -1) * a),
            l = -c * (e + (o > 0 ? 1 : -1) * a);
        o = (-f - l) * $r, i = (f - l) * $r;
      }

      var g = n.invert(o, i);
      return u || (g[0] += o > 0 ? Xr : -Xr), g;
    }), r.geoProjection(e).rotate([-90, -90, 45]).clipAngle(179.999);
  },
      yo = function yo() {
    return mo(Y).scale(176.423);
  },
      Ro = function Ro() {
    return mo(on).scale(111.48);
  },
      jo = function jo(n, r) {
    function e(n) {
      n[0] = +n[0].toFixed(r), n[1] = +n[1].toFixed(r);
    }

    function t(n) {
      n.forEach(e);
    }

    function o(n) {
      n.forEach(t);
    }

    function i(n) {
      if (n) switch (n.type) {
        case "GeometryCollection":
          n.geometries.forEach(i);
          break;

        case "Point":
          e(n.coordinates);
          break;

        case "MultiPoint":
        case "LineString":
          t(n.coordinates);
          break;

        case "MultiLineString":
        case "Polygon":
          o(n.coordinates);
          break;

        case "MultiPolygon":
          n.coordinates.forEach(o);
          break;

        default:
          return;
      }
    }

    function u(n) {
      i(n.geometry);
    }

    if (!(0 <= (r = +r) && r <= 20)) throw new Error("invalid digits");
    if (n) switch (n.type) {
      case "Feature":
        u(n);
        break;

      case "FeatureCollection":
        n.features.forEach(u);
        break;

      default:
        i(n);
    }
    return n;
  },
      Mo = function Mo() {
    return Pe(ur).scale(131.215);
  },
      Eo = [[.9986, -.062], [1, 0], [.9986, .062], [.9954, .124], [.99, .186], [.9822, .248], [.973, .31], [.96, .372], [.9427, .434], [.9216, .4958], [.8962, .5571], [.8679, .6176], [.835, .6769], [.7986, .7346], [.7597, .7903], [.7186, .8435], [.6732, .8936], [.6213, .9394], [.5722, .9761], [.5322, 1]];

  Eo.forEach(function (n) {
    n[1] *= 1.0144;
  }), ar.invert = function (n, r) {
    var e = r / Yr,
        t = 90 * e,
        o = Qr(18, qr(t / 5)),
        i = Dr(0, Wr(o));

    do {
      var u = Eo[i][1],
          a = Eo[i + 1][1],
          c = Eo[Qr(19, i + 2)][1],
          f = c - u,
          l = c - 2 * a + u,
          g = 2 * (qr(e) - a) / f,
          v = l / f,
          s = g * (1 - v * g * (1 - 2 * v * g));

      if (s >= 0 || 1 === i) {
        t = (r >= 0 ? 5 : -5) * (s + o);
        var h,
            p = 50;

        do {
          o = Qr(18, qr(t) / 5), i = Wr(o), s = o - i, u = Eo[i][1], a = Eo[i + 1][1], c = Eo[Qr(19, i + 2)][1], t -= (h = (r >= 0 ? Yr : -Yr) * (a + s * (c - u) / 2 + s * s * (c - 2 * a + u) / 2) - r) * te;
        } while (qr(h) > Jr && --p > 0);

        break;
      }
    } while (--i >= 0);

    var d = Eo[i][0],
        w = Eo[i + 1][0],
        P = Eo[Qr(19, i + 2)][0];
    return [n / (w + s * (P - d) / 2 + s * s * (P - 2 * w + d) / 2), t * oe];
  };

  var bo = function bo() {
    return r.geoProjection(ar).scale(152.63);
  },
      ko = function ko() {
    var n = 2,
        e = 0,
        t = r.geoProjectionMutator(fr),
        o = t(n, e);
    return o.distance = function (r) {
      return arguments.length ? t(n = +r, e) : n;
    }, o.tilt = function (r) {
      return arguments.length ? t(n, e = r * oe) : e * te;
    }, o.scale(432.147).clipAngle(i(1 / n) * te - 1e-6);
  },
      So = 1e4,
      Ao = -180,
      Go = Ao + 1e-4,
      Co = 180,
      zo = Co - 1e-4,
      Fo = -90,
      Lo = Fo + 1e-4,
      qo = 90,
      xo = qo - 1e-4,
      Bo = function Bo(n) {
    if (n) switch (n.type) {
      case "Feature":
        wr(n);
        break;

      case "FeatureCollection":
        n.features.forEach(wr);
        break;

      default:
        Pr(n);
    }
    return n;
  };

  mr.invert = function (n, r) {
    var e = r / 1.70711,
        t = Kr(Zr * e);
    return [n / (.74482 - .34588 * t * t), 2 * xr(e)];
  };

  var Ho = function Ho() {
    return r.geoProjection(mr).scale(146.153);
  },
      Io = function Io(n, e, t) {
    var i = r.geoInterpolate(e, t),
        u = i(.5),
        a = r.geoRotation([-u[0], -u[1]])(e),
        c = i.distance / 2,
        f = -o(Kr(a[1] * oe) / Kr(c)),
        l = [-u[0], -u[1], -(a[0] > 0 ? Xr - f : f) * te],
        g = r.geoProjection(n(c)).rotate(l),
        v = r.geoRotation(l),
        s = g.center;
    return delete g.rotate, g.center = function (n) {
      return arguments.length ? s(v(n)) : v.invert(s());
    }, g.clipAngle(90);
  };

  kr.invert = function (n, r) {
    if (qr(r) < Ur) return [n, 0];
    if (qr(n) < Ur) return [0, Yr * Kr(2 * xr(r / Xr))];
    var e = (n /= Xr) * n,
        t = (r /= Xr) * r,
        o = e + t,
        a = o * o,
        c = -qr(r) * (1 + o),
        f = c - 2 * t + e,
        l = -2 * c + 1 + 2 * t + a,
        g = t / l + (2 * f * f * f / (l * l * l) - 9 * c * f / (l * l)) / 27,
        v = (c - f * f / (3 * l)) / l,
        s = 2 * u(-v / 3),
        h = i(3 * g / (v * s)) / 3;
    return [Xr * (o - 1 + u(1 + 2 * (e - t) + a)) / (2 * n), _r(r) * Xr * (-s * Hr(h + Xr / 3) - f / (3 * l))];
  };

  var Wo = function Wo() {
    return r.geoProjection(kr).scale(79.4183);
  };

  Sr.invert = function (n, r) {
    if (!n) return [0, Yr * Kr(2 * xr(r / Xr))];
    var e = qr(n / Xr),
        t = (1 - e * e - (r /= Xr) * r) / (2 * e),
        o = t * t,
        i = u(o + 1);
    return [_r(n) * Xr * (i - t), _r(r) * Yr * Kr(2 * Br(u((1 - 2 * t * e) * (t + i) - e), u(i + t + e)))];
  };

  var To = function To() {
    return r.geoProjection(Sr).scale(79.4183);
  };

  Ar.invert = function (n, r) {
    if (!r) return [n, 0];
    var e = r / Xr,
        t = (Xr * Xr * (1 - e * e) - n * n) / (2 * Xr * n);
    return [n ? Xr * (_r(n) * u(t * t + 1) - t) : 0, Yr * Kr(2 * xr(e))];
  };

  var Do = function Do() {
    return r.geoProjection(Ar).scale(79.4183);
  };

  Gr.invert = function (n, r) {
    var e;
    if (!n || !r) return [n, r];
    r /= Xr;
    var t = _r(n) * n / Yr,
        o = (t * t - 1 + 4 * r * r) / qr(t),
        i = o * o,
        a = 2 * r,
        c = 50;

    do {
      var f = a * a,
          l = (8 * a - f * (f + 2) - 5) / (2 * f * (a - 1)),
          g = (3 * a - f * a - 10) / (2 * f * a),
          v = l * l,
          s = a * l,
          h = a + l,
          p = h * h,
          d = a + 3 * l,
          w = p * (f + v * i - 1) + (1 - f) * (f * (d * d + 4 * v) + v * (12 * s + 4 * v)),
          P = -2 * h * (4 * s * v + (1 - 4 * f + 3 * f * f) * (1 + g) + v * (14 * f - 6 - i + (8 * f - 8 - 2 * i) * g) + s * (12 * f - 8 + (10 * f - 10 - i) * g)),
          m = u(w);
      a -= e = (o * (p + v - 1) + 2 * m - t * (4 * p + i)) / (o * (2 * l * g + 2 * h * (1 + g)) + P / m - 8 * h * (o * (-1 + v + p) + 2 * m) * (1 + g) / (i + 4 * p));
    } while (e > Ur && --c > 0);

    return [_r(n) * (u(o * o + 4) + o) * Xr / 4, Yr * a];
  };

  var Qo = function Qo() {
    return r.geoProjection(Gr).scale(127.16);
  },
      Vo = 4 * Xr + 3 * u(3),
      No = 2 * u(2 * Xr * u(3) / Vo),
      _o = m(No * u(3) / Xr, No, Vo / 6),
      Ko = function Ko() {
    return r.geoProjection(_o).scale(176.84);
  };

  Cr.invert = function (n, r) {
    return [n / u(1 - 3 * r * r / (Xr * Xr)), r];
  };

  var Oo = function Oo() {
    return r.geoProjection(Cr).scale(152.63);
  };

  zr.invert = function (n, r) {
    var e = n / 2.66723,
        t = r / 1.24104,
        i = u(e * e + t * t),
        a = 2 * o(i / 2);
    return [3 * Br(n * Or(a), 2.66723 * i), i && o(r * Kr(a) / (1.24104 * .90631 * i))];
  };

  var Uo = function Uo() {
    return r.geoProjection(zr).scale(172.632);
  };

  Fr.invert = function (n, r) {
    var e = (n * n + r * r) / -2,
        t = u(-e * (2 + e)),
        i = r * e + n * t,
        a = n * e - r * t,
        c = u(a * a + i * i);
    return [Br(t * i, c * (1 + e)), c ? -o(t * a / c) : 0];
  };

  var Jo = function Jo() {
    return r.geoProjection(Fr).rotate([0, -90, 45]).scale(124.75).clipAngle(179.999);
  };

  Lr.invert = function (n, r) {
    var e = n,
        t = r,
        o = 25;

    do {
      var a,
          c = Hr(t),
          f = Kr(t),
          l = Kr(2 * t),
          g = f * f,
          v = c * c,
          s = Kr(e),
          h = Hr(e / 2),
          p = Kr(e / 2),
          d = p * p,
          w = 1 - v * h * h,
          P = w ? i(c * h) * u(a = 1 / w) : a = 0,
          m = .5 * (2 * P * c * p + e / Yr) - n,
          y = .5 * (P * f + t) - r,
          R = .5 * a * (v * d + P * c * h * g) + .5 / Yr,
          j = a * (s * l / 4 - P * f * p),
          M = .125 * a * (l * p - P * f * v * s),
          E = .5 * a * (g * h + P * d * c) + .5,
          b = j * M - E * R,
          k = (y * j - m * E) / b,
          S = (m * M - y * R) / b;
      e -= k, t -= S;
    } while ((qr(k) > Ur || qr(S) > Ur) && --o > 0);

    return [e, t];
  };

  var Xo = function Xo() {
    return r.geoProjection(Lr).scale(158.837);
  };

  n.geoAiry = ie, n.geoAiryRaw = v, n.geoAitoff = ue, n.geoAitoffRaw = s, n.geoArmadillo = ae, n.geoArmadilloRaw = h, n.geoAugust = ce, n.geoAugustRaw = p, n.geoBaker = ge, n.geoBakerRaw = d, n.geoBerghaus = ve, n.geoBerghausRaw = w, n.geoBoggs = we, n.geoBoggsRaw = y, n.geoBonne = ye, n.geoBonneRaw = j, n.geoBottomley = Re, n.geoBottomleyRaw = M, n.geoBromley = Me, n.geoBromleyRaw = je, n.geoChamberlin = C, n.geoChamberlinRaw = S, n.geoChamberlinAfrica = G, n.geoCollignon = Ee, n.geoCollignonRaw = z, n.geoCraig = be, n.geoCraigRaw = F, n.geoCraster = Se, n.geoCrasterRaw = L, n.geoCylindricalEqualArea = Ae, n.geoCylindricalEqualAreaRaw = q, n.geoCylindricalStereographic = Ge, n.geoCylindricalStereographicRaw = x, n.geoEckert1 = Ce, n.geoEckert1Raw = B, n.geoEckert2 = ze, n.geoEckert2Raw = H, n.geoEckert3 = Fe, n.geoEckert3Raw = I, n.geoEckert4 = Le, n.geoEckert4Raw = W, n.geoEckert5 = qe, n.geoEckert5Raw = T, n.geoEckert6 = xe, n.geoEckert6Raw = D, n.geoEisenlohr = He, n.geoEisenlohrRaw = Q, n.geoFahey = We, n.geoFaheyRaw = V, n.geoFoucaut = Te, n.geoFoucautRaw = N, n.geoGilbert = De, n.geoGingery = Qe, n.geoGingeryRaw = O, n.geoGinzburg4 = _e, n.geoGinzburg4Raw = Ne, n.geoGinzburg5 = Oe, n.geoGinzburg5Raw = Ke, n.geoGinzburg6 = Je, n.geoGinzburg6Raw = Ue, n.geoGinzburg8 = Xe, n.geoGinzburg8Raw = X, n.geoGinzburg9 = Ze, n.geoGinzburg9Raw = Ye, n.geoGringorten = nt, n.geoGringortenRaw = Y, n.geoGuyou = rt, n.geoGuyouRaw = on, n.geoHammer = et, n.geoHammerRaw = cn, n.geoHammerRetroazimuthal = tt, n.geoHammerRetroazimuthalRaw = ln, n.geoHealpix = ut, n.geoHealpixRaw = vn, n.geoHill = at, n.geoHillRaw = hn, n.geoHomolosine = gt, n.geoHomolosineRaw = dn, n.geoInterrupt = vt, n.geoInterruptedBoggs = ht, n.geoInterruptedHomolosine = dt, n.geoInterruptedMollweide = Pt, n.geoInterruptedMollweideHemispheres = yt, n.geoInterruptedSinuMollweide = jt, n.geoInterruptedSinusoidal = Et, n.geoKavrayskiy7 = bt, n.geoKavrayskiy7Raw = yn, n.geoLagrange = kt, n.geoLagrangeRaw = Rn, n.geoLarrivee = At, n.geoLarriveeRaw = jn, n.geoLaskowski = Gt, n.geoLaskowskiRaw = Mn, n.geoLittrow = Ct, n.geoLittrowRaw = En, n.geoLoximuthal = zt, n.geoLoximuthalRaw = bn, n.geoMiller = Ft, n.geoMillerRaw = kn, n.geoModifiedStereographic = Ln, n.geoModifiedStereographicRaw = Sn, n.geoModifiedStereographicAlaska = An, n.geoModifiedStereographicGs48 = Gn, n.geoModifiedStereographicGs50 = Cn, n.geoModifiedStereographicMiller = zn, n.geoModifiedStereographicLee = Fn, n.geoMollweide = he, n.geoMollweideRaw = se, n.geoMtFlatPolarParabolic = Tt, n.geoMtFlatPolarParabolicRaw = qn, n.geoMtFlatPolarQuartic = Dt, n.geoMtFlatPolarQuarticRaw = xn, n.geoMtFlatPolarSinusoidal = Qt, n.geoMtFlatPolarSinusoidalRaw = Bn, n.geoNaturalEarth = Vt, n.geoNaturalEarthRaw = Hn, n.geoNellHammer = Nt, n.geoNellHammerRaw = In, n.geoPatterson = $t, n.geoPattersonRaw = Wn, n.geoPolyconic = no, n.geoPolyconicRaw = Tn, n.geoPolyhedral = eo, n.geoPolyhedralButterfly = io, n.geoPolyhedralCollignon = ao, n.geoPolyhedralWaterman = co, n.geoProject = vo, n.geoGringortenQuincuncial = yo, n.geoPeirceQuincuncial = Ro, n.geoPierceQuincuncial = Ro, n.geoQuantize = jo, n.geoQuincuncial = mo, n.geoRectangularPolyconic = Mo, n.geoRectangularPolyconicRaw = ur, n.geoRobinson = bo, n.geoRobinsonRaw = ar, n.geoSatellite = ko, n.geoSatelliteRaw = fr, n.geoSinuMollweide = lt, n.geoSinuMollweideRaw = pn, n.geoSinusoidal = me, n.geoSinusoidalRaw = R, n.geoStitch = Bo, n.geoTimes = Ho, n.geoTimesRaw = mr, n.geoTwoPointAzimuthal = jr, n.geoTwoPointAzimuthalRaw = yr, n.geoTwoPointAzimuthalUsa = Rr, n.geoTwoPointEquidistant = br, n.geoTwoPointEquidistantRaw = Mr, n.geoTwoPointEquidistantUsa = Er, n.geoVanDerGrinten = Wo, n.geoVanDerGrintenRaw = kr, n.geoVanDerGrinten2 = To, n.geoVanDerGrinten2Raw = Sr, n.geoVanDerGrinten3 = Do, n.geoVanDerGrinten3Raw = Ar, n.geoVanDerGrinten4 = Qo, n.geoVanDerGrinten4Raw = Gr, n.geoWagner4 = Ko, n.geoWagner4Raw = _o, n.geoWagner6 = Oo, n.geoWagner6Raw = Cr, n.geoWagner7 = Uo, n.geoWagner7Raw = zr, n.geoWiechel = Jo, n.geoWiechelRaw = Fr, n.geoWinkel3 = Xo, n.geoWinkel3Raw = Lr, Object.defineProperty(n, "__esModule", {
    value: !0
  });
});
},{"d3-geo":"node_modules/d3-geo/src/index.js","d3-array":"node_modules/d3-array/src/index.js"}],"../../../../../Users/thoma/AppData/Roaming/nvm/v10.16.0/node_modules/parcel-bundler/src/builtins/hmr-runtime.js":[function(require,module,exports) {
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
},{}]},{},["../../../../../Users/thoma/AppData/Roaming/nvm/v10.16.0/node_modules/parcel-bundler/src/builtins/hmr-runtime.js","src/d3-geo-projection.v1.min.js"], null)
//# sourceMappingURL=/d3-geo-projection.v1.min.1f4c9fdb.js.map
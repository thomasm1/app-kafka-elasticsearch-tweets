const path = require('path');

const config = {
    entry: './src/js/cats.js', 
  output: {
    path: path.resolve(__dirname, 'dist/js/'),
  filename: 'cats.bundle-october.js'
},
  module: {
    rules: [
      { test: /\.txt$/, use: 'raw-loader' }
    ]
  }
};

module.exports = config;

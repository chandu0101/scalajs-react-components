'use strict';

var webpack = require('webpack'),
    _ = require('lodash');

module.exports = _.merge(require('./webpack.config.js'), {
    output: {
        filename: 'bundle.js'
    },
    plugins: [
        new webpack.optimize.OccurenceOrderPlugin(),
        new webpack.optimize.DedupePlugin(),
        new webpack.optimize.UglifyJsPlugin({
            compress: {
                warnings: false,
                drop_console: true,
                hoist_vars: true,
                unsafe: true
            }
        })
    ]
});
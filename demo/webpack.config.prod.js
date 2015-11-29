'use strict';

var webpack = require('webpack');
var CommonsChunkPlugin = webpack.optimize.CommonsChunkPlugin;
var _ = require('lodash');

module.exports = _.merge(require('./webpack.config.js'), {

    output: {
        publicPath: "/sjrc/assets/"
    },
    plugins: [
        new CommonsChunkPlugin({
            name: "index"
        }),
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
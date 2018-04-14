'use strict';

var webpack = require('webpack');
var _ = require('lodash');

module.exports = _.merge(
    require('./scalajs.webpack.config'),
    require('./webpack.config.shared'),
    {
        plugins: [
            new webpack.DefinePlugin({
                'process.env.NODE_ENV': JSON.stringify('development')
            })
        ],
    });

'use strict';

var webpack = require('webpack');
var _ = require('lodash');

module.exports = _.merge(
    require('./scalajs.webpack.config'),
    {
        plugins: [
            new webpack.NoEmitOnErrorsPlugin(),
        ],
        module: {
            loaders: [
                {test: /\.css$/, loader: 'style-loader!css-loader'}
                ],
            rules: [{
                test: /\.css$/,
                loader : [ 'style-loader', 'css-loader' ]
            }, {
                test: /\.(png|jpg|gif|svg|eot|ttf|woff|woff2)$/,
                loader: 'url-loader',
                options: {
                    limit: 20000
                }
            }]
        }
    });

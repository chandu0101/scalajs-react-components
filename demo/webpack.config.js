'use strict';

var webpack = require('webpack');

module.exports = {

    entry: [
        './index.js'
    ],
    output: {
        path: __dirname + '/assets',
        publicPath: __dirname  + "/assets/",
        filename: 'bundle.js'
    },
    plugins: [
        new webpack.NoErrorsPlugin()
    ],
    module: {
        loaders: [
            { test: /\.css$/, loader: 'style-loader!css-loader' },
            { test: /\.(png|jpg|svg)$/, loader: 'url-loader?limit=8192'} // inline base64 URLs for <=8k images, direct URLs for the rest
        ]
    }


};
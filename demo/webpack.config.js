'use strict';

var webpack = require('webpack');

module.exports = {

    entry: [
        //'webpack/hot/only-dev-server',
        './index.js'
    ],
    output: {
        path: __dirname + '/build',
        publicPath: __dirname  + "/assets/",
        filename: 'bundle.js'
    },
    plugins: [
        new webpack.NoErrorsPlugin()
    ],
    module: {
        loaders: [
            { test: /\.css$/, loader: 'style-loader!css-loader' },
            {test: /\.(png|jpg)$/, loader: 'url-loader?limit=81920'} // inline base64 URLs for <=8k images, direct URLs for the rest
        ]
    }


};
'use strict';

var webpack = require('webpack');
var CommonsChunkPlugin = webpack.optimize.CommonsChunkPlugin;

module.exports = {

    entry: {
        index: './bundles/index.js',
        elemental_ui: './bundles/elemental-ui.js',
        material_ui: './bundles/material-ui.js',
        react_tags_input: './bundles/react-tags-input.js',
        react_select: './bundles/react-select.js',
        react_geom_icons: './bundles/react-geom-icons.js',
        react_infinite: './bundles/react-infinite.js',
        react_spinner: './bundles/react-spinner.js',
        react_slick: './bundles/react-slick.js'
    },
    output: {
        path: __dirname + '/assets',
        publicPath: "/assets/",
        filename: '[name]-bundle.js'
    },
    plugins: [
        new webpack.NoErrorsPlugin(),
        new CommonsChunkPlugin({
            name: "index"
        })
    ],
    module: {
        loaders: [
            {
                test: /\.css$/,
                loader: 'style-loader!css-loader'
            },

            {
                test: /\.(png|jpg|svg)$/,
                loaders: [
                    'url-loader?limit=8192',
                    'image-webpack?optimizationLevel=7&progressive=true']
            } // inline base64 URLs for <=8k images, direct URLs for the rest
        ]
    }


};